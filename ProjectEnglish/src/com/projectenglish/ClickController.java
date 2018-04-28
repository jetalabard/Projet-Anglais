package com.projectenglish;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

public class ClickController implements View.OnClickListener{

	private String urlRedirectButton;
	private int clickMode;
	private Activity activity;
	private AlertDialog alertDialog;
	private String reponse;
	private String reponseJuste;

	public ClickController(Activity act,String url,int clickMode) {
		this.activity = act;
		this.urlRedirectButton =url;
		this.clickMode = clickMode;
	}
	public ClickController(Activity act,int clickMode,String reponse, String reponseJuste) {
		this.activity = act;
		this.reponse = reponse;
		this.clickMode = clickMode;
		this.reponseJuste = reponseJuste;
	}
	public ClickController(Activity act,int clickMode) {
		this.activity = act;
		this.clickMode = clickMode;
	}
	@Override
	public void onClick(View v) {
		if(this.clickMode == 0)
		{
			//remeise à zéro des questions posé
			QuestionDAO.getInstance(activity).setQuestionAsk(new ArrayList<Question>());
			UserDAO.getInstance(activity).reinitializeQuestionAnswer();
			//play
			Intent i = new Intent(activity, QuizActivity.class);
			activity.startActivity(i);
			activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		}
		else if(this.clickMode == 1){
			new TestConnection(activity).testConnectionAndOpenNavigator(urlRedirectButton);
		}
		//redirection vers une simple activité
		else if(this.clickMode == 3){
			Intent i = new Intent(activity, StatActivity.class);
			activity.startActivity(i);
			activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		}
		else if(this.clickMode == 4){
			maj();
		}
		
	}
	private void maj() {
		
		Dialog d = new Dialog(activity, "Update Application", "Are you sure ? All data will be delete ?", true);
		alertDialog  = d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				activity.getApplicationContext().deleteDatabase(DataBase.DATABASE_NAME);
				Handler handler = new Handler(); 
				handler.postDelayed(new Runnable() { 
					public void run() { 
						activity.finish();
						Intent intent = new Intent(activity.getApplicationContext(), SplashScreen.class);
						intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						intent.putExtra("EXIT",true);
						activity.startActivity(intent);
						activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
					} 
				}, 1000);
				
			}
		}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
			}
		}).create();


		alertDialog.show();
		
		
	}
}
