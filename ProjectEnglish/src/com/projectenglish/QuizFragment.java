package com.projectenglish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizFragment extends Fragment {

	private int userLevel;

	private Question question;

	private AnswerAdapter adapter;

	public static Fragment newInstance() {
		return new QuizFragment();
	}

	private QuizFragment(){
		this.userLevel= UserDAO.getInstance(getActivity()).getLevel();
		this.question = QuestionDAO.getInstance(getActivity()).getQuestionAlea(userLevel);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

		if(this.question == null){
			Toast.makeText(getActivity(), "Vous avez répondu à toutes les questions du jeu !! ", Toast.LENGTH_LONG).show();
			Handler handler = new Handler(); 
			handler.postDelayed(new Runnable() { 
				public void run() { 
					getActivity().finish();
					Intent i = new Intent(getActivity(), FirstPageActivity.class);
					getActivity().startActivity(i);
					getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				} 
			}, 3000);

		}
		else{
			getActivity().setTitle(this.question.getTheme());
		}
	}

	ProgressBar mProgressBar;
	CountDownTimer mCountDownTimer;
	int i=0;

	private GridView gridview;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.quiz, container, false);
		if(this.question != null){
			TextView textQuestion = (TextView) rootView.findViewById(R.id.textQuestion);
			textQuestion.setText(this.question.getQuestion());



			mProgressBar=(ProgressBar)rootView.findViewById(R.id.progressbar);
			mProgressBar.setProgress(i);
			mCountDownTimer=new CountDownTimer(15000,1000) {

				@Override
				public void onTick(long millisUntilFinished) {
					i++;
					mProgressBar.setProgress(i);
				}

				@Override
				public void onFinish() {
					i++;
					mProgressBar.setProgress(i);
					adapter.setTimePass(true);
					int nbquestion = QuestionDAO.getInstance(getActivity()).getNumberOfQuestionAsk();
					UserDAO.getInstance(getActivity()).setStat(nbquestion);

					getActivity().finish();
					Intent i = new Intent(getActivity(), LoseActivity.class);
					getActivity().startActivity(i);
					getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				}
			};
			mCountDownTimer.start();

			gridview = (GridView) rootView.findViewById(R.id.gridview);
			List<String> list = new ArrayList<String>();
			list.addAll(Arrays.asList(this.question.getReponse1(),this.question.getReponse2(),this.question.getReponse3(),this.question.getReponse4()));
			adapter =new AnswerAdapter(getActivity(),list,this.question.isWithImage(),this.question.getReponseJuste(),this.question.getPoints(),mCountDownTimer);
			gridview.setAdapter(adapter);
		}

		return rootView;
	}
}
