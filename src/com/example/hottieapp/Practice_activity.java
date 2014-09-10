package com.example.hottieapp;


import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings.Secure;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Practice_activity extends Activity {
	private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;
    private String android_id;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practice_activity);
		Button photoButton = (Button) findViewById(R.id.photo_upload);
		android_id= Secure.getString(getContentResolver(), Secure.ANDROID_ID);
		photoButton.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, ""),SELECT_PICTURE);	
			}
		});
		
		Button deviceID_Button = (Button) findViewById(R.id.deviceID_button);
		deviceID_Button.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View v) 
			{
				TextView text= (TextView) findViewById(R.id.device_id_text);
                text.setTextSize(18);
                text.setText(android_id);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practice_activity, menu);
		return true;
	} 
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                TextView text= (TextView) findViewById(R.id.pic_text);
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
	
}
