package com.example.hottieapp;


import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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
				
		Button registerButton = (Button) findViewById(R.id.Register_id_button);
		registerButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent(MainActivity.this,Practice_activity.class);
				startActivity(intent);	
			}
		});
	}
    
}//Activity ends


