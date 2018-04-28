package com.projectenglish;

import android.app.Activity;
import android.widget.TextView;

public class ImageCategory{

	public TextView draw(Activity act,TextView imageView,String text) {
		imageView.setBackgroundResource(R.drawable.greencircle);
		imageView.setText(text);
		return imageView;
	}

}
