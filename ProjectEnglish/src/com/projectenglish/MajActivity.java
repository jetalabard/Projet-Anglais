package com.projectenglish;

import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class MajActivity extends SimpleFragmentActivity{

	@Override
	protected Fragment createFragment() {
		return MajFragment.newInstance();
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
