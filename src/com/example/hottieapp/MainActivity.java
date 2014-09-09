package com.example.hottieapp;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ImageButton boysButton = (ImageButton) findViewById(R.id.boys);
		boysButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton girlsButton = (ImageButton) findViewById(R.id.girls);
		girlsButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton couplesButton = (ImageButton) findViewById(R.id.couples);
		couplesButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton festsButton = (ImageButton) findViewById(R.id.fests);
		festsButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
