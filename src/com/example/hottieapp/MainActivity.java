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
	
	private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;
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
		
		//Upload button for gallery
		Button registerButton = (Button) findViewById(R.id.gallery);
		registerButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				   Intent intent = new Intent();
                   intent.setType("image/*");
                   intent.setAction(Intent.ACTION_GET_CONTENT);
                   startActivityForResult(Intent.createChooser(intent, ""),SELECT_PICTURE);

			}
		});
	}

	
	
	// method called after startActivityForResult()
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                TextView text= (TextView) findViewById(R.id.textView5);
                text.setTextSize(10);
                text.setText(selectedImagePath);
            }
        }
    }

    /**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
            // just some safety built in 
            if( uri == null ) {
                // TODO perform some logging or show user feedback
                return null;
            }
            // try to retrieve the image from the media store first
            // this will only work for images selected from gallery
            String[] projection = { MediaStore.Images.Media.DATA };
            Cursor cursor = managedQuery(uri, projection, null, null, null);
            if( cursor != null ){
                int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            }
            return uri.getPath();
    }

    
    
    
    
}//Activity ends


