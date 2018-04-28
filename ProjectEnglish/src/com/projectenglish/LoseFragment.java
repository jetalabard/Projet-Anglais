package com.projectenglish;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoseFragment extends Fragment{

	public static Fragment newInstance() {
		return new LoseFragment();
	}

	private View rootView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.lose_fragment, container, false);
		
		ImageView imageLose= (ImageView) rootView.findViewById(R.id.imageLose);
		LoadImageFromAssetFolder.execute(getActivity(), imageLose, "lose.png");
		Animation myAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.left_to_right);
		imageLose.startAnimation(myAnimation);
		
		TextView textPointLose2 = (TextView) rootView.findViewById(R.id.textPointLose2);
		textPointLose2.setText(UserDAO.getInstance(getActivity()).getNumberOfPointGain()+"");
		
		TextView textNbQuestionLose2 = (TextView) rootView.findViewById(R.id.textNbQuestionLose2);
		textNbQuestionLose2.setText(QuestionDAO.getInstance(getActivity()).getNumberOfQuestionAsk()+"");
		
		ImageView imageBack = (ImageView) rootView.findViewById(R.id.imageBack);
		imageBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActivity().finish();
				Intent i = new Intent(getActivity(), FirstPageActivity.class);
				getActivity().startActivity(i);
				getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
				
			}
		});
		
		ImageView ic_facebook = (ImageView) rootView.findViewById(R.id.imageFacebook);
		ic_facebook.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/*SharePhoto photo = new SharePhoto.Builder()
				        .setBitmap(getBitmapFromView())
				        .build();*/
			}
		});
		
		return rootView;
	}
	
	 public Bitmap getBitmapFromView() {
	        //Define a bitmap with the same size as the view
	        Bitmap returnedBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(),Bitmap.Config.ARGB_8888);
	        //Bind a canvas to it
	        Canvas canvas = new Canvas(returnedBitmap);
	        //Get the view's background
	        Drawable bgDrawable =rootView.getBackground();
	        if (bgDrawable!=null) 
	            //has background drawable, then draw it on the canvas
	            bgDrawable.draw(canvas);
	        else 
	            //does not have background drawable, then draw white background on the canvas
	            canvas.drawColor(Color.WHITE);
	        // draw the view on the canvas
	        rootView.draw(canvas);
	        //return the bitmap
	        return returnedBitmap;
	    }

}
