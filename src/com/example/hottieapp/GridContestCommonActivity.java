package com.example.hottieapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GridContestCommonActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_contest_common);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grid_contest_common, menu);
		return true;
	}

}