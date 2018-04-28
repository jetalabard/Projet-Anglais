package com.projectenglish;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstPageFragment extends Fragment {
	

	public static Fragment newInstance() {
		return new FirstPageFragment();
	}
	
	public FirstPageFragment(){
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);	
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.firstpagelayout, container, false);
		User user = UserDAO.getInstance(getActivity()).getUser();
		TextView text = (TextView) rootView.findViewById(R.id.textNbLevel);
		if(user != null)
		{
			text.setText(UserDAO.getInstance(getActivity()).getLevel()+"");
		}
		
		ImageView imageLauncher= (ImageView) rootView.findViewById(R.id.tabPeriod);
		LoadImageFromAssetFolder.execute(getActivity(), imageLauncher, "logo2.png");
		Button b = (Button) rootView.findViewById(R.id.buttonStart);
		b.setOnClickListener(new ClickController(getActivity(),0));
		Button b2 = (Button) rootView.findViewById(R.id.buttonStat);
		b2.setOnClickListener(new ClickController(getActivity(),3));
		return rootView;
	}

}
