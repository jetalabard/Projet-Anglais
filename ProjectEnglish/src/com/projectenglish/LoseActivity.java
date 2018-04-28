package com.projectenglish;

import android.content.Intent;
import android.support.v4.app.Fragment;

public class LoseActivity extends SimpleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return LoseFragment.newInstance();
	}
	
	@Override
	public void onBackPressed() {
		finish();
		Intent i = new Intent(this, FirstPageActivity.class);
		startActivity(i);
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}

}
