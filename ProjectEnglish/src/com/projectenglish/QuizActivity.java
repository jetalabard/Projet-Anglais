package com.projectenglish;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class QuizActivity extends SimpleFragmentActivity{

	private AlertDialog alertDialog;

	@Override
	protected Fragment createFragment() {
		return QuizFragment.newInstance();
	}

	@Override
	public void onBackPressed() {
			Dialog d = new Dialog(this, "Are you sure ?", "Do you want finish game ?", true);
			alertDialog  = d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					back();
				}
				
			}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.dismiss();
				}
			}).create();
			alertDialog.show();

	}
	private void back() {
		super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Dialog d = new Dialog(this, "Are you sure ?", "Do you want finish game ?", true);
			alertDialog  = d.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					goParent();
				}
				
			}).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.dismiss();
				}
			}).create();
			alertDialog.show();
			
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	private void goParent() {
		if (NavUtils.getParentActivityName(this) != null) {
			NavUtils.navigateUpFromSameTask(this);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	}

}