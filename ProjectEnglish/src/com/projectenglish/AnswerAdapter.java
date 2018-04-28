package com.projectenglish;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AnswerAdapter extends ArrayAdapter<String> {

	private Activity activity;
	private boolean isQuestionImage;
	private String reponseJuste;

	private View convertViewGoodAnswer;
	private int nbPoint;
	private boolean timePass = false;
	private CountDownTimer mCountDownTimer;

	public AnswerAdapter(Activity act,List<String> list,boolean isQuestionImage,String reponseJuste,int nbPoint, CountDownTimer mCountDownTimer) {
		super(act, 0, list);
		this.activity = act;
		this.isQuestionImage = isQuestionImage;
		this.reponseJuste = reponseJuste;
		this.nbPoint = nbPoint;
		this.mCountDownTimer = mCountDownTimer;
	}

	private static class ViewHolder {
		TextView text;
		ImageView image;
		LinearLayout choiceLayout;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;

		if (convertView == null) {
			convertView = LayoutInflater.from(activity).inflate(R.layout.question_adapter, parent,false);
			vh = new ViewHolder();
			vh.choiceLayout = (LinearLayout) convertView.findViewById(R.id.relative1);
			vh.text = (TextView) convertView.findViewById(R.id.reponse);
			vh.image = (ImageView) convertView.findViewById(R.id.reponseImage);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}

		final String choice = getItem(position);
		if (choice != null) {
			if(choice.equals(reponseJuste)){
				this.convertViewGoodAnswer = convertView;
			}
			if(isQuestionImage){
				LoadImageFromAssetFolder.execute(activity, vh.image, choice);
			}
			else{
				vh.text.setText(choice);
				vh.text.setTextSize(20f);
				vh.text.setVisibility(View.VISIBLE);
			}
			vh.choiceLayout.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					//appuie pour repondre question
					if(timePass == false){
						mCountDownTimer.cancel();
						if(choice.equals(reponseJuste)){
							goodAnswer(vh); 
						}
						else{
							badAnswer(vh); 
						}
					}
				}
				private void badAnswer(final ViewHolder vh) {
					//ecran fin partie
					vh.choiceLayout.setBackground(activity.getResources().getDrawable(R.drawable.button_red,null));

					Animation anim = new AlphaAnimation(0.0f, 1.0f);
					anim.setDuration(500); //You can manage the time of the blink with this parameter
					anim.setStartOffset(20);
					anim.setRepeatMode(Animation.REVERSE);
					anim.setRepeatCount(Animation.INFINITE);
					((ViewHolder)convertViewGoodAnswer.getTag()).choiceLayout.startAnimation(anim);

					updateStat();

					Handler handler = new Handler(); 
					handler.postDelayed(new Runnable() { 
						public void run() { 
							activity.finish();
							Intent i = new Intent(activity, LoseActivity.class);
							activity.startActivity(i);
							activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
						} 
					}, 3000);
				}

				private void updateStat() {
					int nbquestion = QuestionDAO.getInstance(activity).getNumberOfQuestionAsk();
					UserDAO.getInstance(activity).setStat(nbquestion);
				}

				private void goodAnswer(final ViewHolder vh) {
					// change question
					vh.choiceLayout.setBackground(activity.getResources().getDrawable(R.drawable.button_green,null));
					Animation anim = new AlphaAnimation(0.0f, 1.0f);
					anim.setDuration(500); //You can manage the time of the blink with this parameter
					anim.setStartOffset(20);
					anim.setRepeatMode(Animation.REVERSE);
					anim.setRepeatCount(Animation.INFINITE);
					vh.choiceLayout.startAnimation(anim);

					UserDAO.getInstance(activity).addQuestionAnwer(QuestionDAO.getInstance(activity).getLastQuestion());
					UserDAO.getInstance(activity).setPoint(nbPoint);

					Handler handler = new Handler(); 
					handler.postDelayed(new Runnable() { 
						public void run() { 
							activity.finish();
							Intent i = new Intent(activity, QuizActivity.class);
							activity.startActivity(i);
							activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
						} 
					}, 3000);
				}
			});
		}

		return convertView;
	}

	public void setTimePass(boolean b) {
		this.timePass  = b;

	}

}

