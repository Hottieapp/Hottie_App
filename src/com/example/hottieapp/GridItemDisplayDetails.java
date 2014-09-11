package com.example.hottieapp;



import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class GridItemDisplayDetails extends Activity {

	ImageView image;
    TextView text;
    RatingBar rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item_display_details);

        int imageResource=getIntent().getIntExtra("selectedFlagId",R.drawable.a);
        String flag=getIntent().getStringExtra("selectedFlagName");
        image=(ImageView)findViewById(R.id.imageView);
        text= (TextView) findViewById(R.id.textView);
        
        if(flag!=null)
        {
            text.setText(flag);

            Log.e("VIVZ","selected flag was successful");
            image.setImageResource(imageResource);
        }
        else
        {
            Log.e("VIVZ","selected flag was null");
            text.setText("Flag string Empty !");

        }

    }
    public void wrapUp(View v)
    {
        finish();
    }
    
}