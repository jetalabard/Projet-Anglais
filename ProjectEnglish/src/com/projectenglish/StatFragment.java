package com.projectenglish;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatFragment extends Fragment {

	Stat userStat = null;
	User user = null;
	
	public static Fragment newInstance() {
		return new StatFragment();
	}
	
	private StatFragment(){
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.stat_layout, container, false);
		
		userStat = UserDAO.getInstance(getActivity()).getStat();
		user = UserDAO.getInstance(getActivity()).getUser();
		
		TextView textPoint = (TextView) rootView.findViewById(R.id.textPoint2);
		textPoint.setText(user.getPoint()+"");
		
		TextView textLevel = (TextView) rootView.findViewById(R.id.textLevel2);
		textLevel.setText(UserDAO.getInstance(getActivity()).getLevel()+"");
		
		TextView textNbPart2 = (TextView) rootView.findViewById(R.id.textNbPart2);
		textNbPart2.setText(userStat.getNbPart()+"");
		
		TextView textNbWrong2 = (TextView) rootView.findViewById(R.id.textNbWrong2);
		textNbWrong2.setText(userStat.getNbQuestionWrong()+"");
		
		TextView textnbAverage2 = (TextView) rootView.findViewById(R.id.textnbAverage2);
		textnbAverage2.setText(userStat.getNbQuestionAverage()+"");
		
		TextView textnbQuestion2 = (TextView) rootView.findViewById(R.id.textnbQuestion2);
		textnbQuestion2.setText(userStat.getNbQuestion()+"");
		
		
		return rootView;
	}
}