package com.projectenglish;

import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class StatActivity extends SimpleFragmentActivity{

	@Override
	protected Fragment createFragment() {
		return StatFragment.newInstance();
	}
	@Override
	public void onBackPressed() {
		if (NavUtils.getParentActivityName(this) != null) {
			NavUtils.navigateUpFromSameTask(this);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			if (NavUtils.getParentActivityName(this) != null) {
				NavUtils.navigateUpFromSameTask(this);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}