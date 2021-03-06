package com.example.hottieapp;


import org.w3c.dom.Text;

import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	void vibration(int time)
	{

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    	v.vibrate(time);
	}
	TextView boys,girls,fests,couples,heading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		boys=(TextView) findViewById(R.id.textView1);
		girls=(TextView) findViewById(R.id.textView2);
		fests=(TextView) findViewById(R.id.textView3);
		couples=(TextView) findViewById(R.id.textView4);
		heading=(TextView) findViewById(R.id.textView5);
		
		heading.setTextSize(36);
		
		Typeface fontobject=Typeface.createFromAsset(getAssets(),"oneway.ttf");
		Typeface fontheading=Typeface.createFromAsset(getAssets(),"citycontrasts.ttf");
        boys.setTypeface(fontobject);
        girls.setTypeface(fontobject);
        fests.setTypeface(fontobject);
        couples.setTypeface(fontobject);
        heading.setTypeface(fontheading);
		
		ImageButton boysButton = (ImageButton) findViewById(R.id.boys);
		boysButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				vibration(30);
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton girlsButton = (ImageButton) findViewById(R.id.girls);
		girlsButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				vibration(30);
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton couplesButton = (ImageButton) findViewById(R.id.couples);
		couplesButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				vibration(30);
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
		
		ImageButton festsButton = (ImageButton) findViewById(R.id.fests);
		festsButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				vibration(30);
				Intent intent = new Intent(MainActivity.this,GridContestCommonActivity.class);
				startActivity(intent);	
			}
		});
				
		Button registerButton = (Button) findViewById(R.id.Register_id_button);
		registerButton.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				vibration(30);
				Intent intent = new Intent(MainActivity.this,Practice_activity.class);
				startActivity(intent);	
			}
		});
	}
    
}//Activity ends


