package com.example.hottieapp;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GridContestCommonActivity extends Activity implements AdapterView.OnItemClickListener {
    GridView grid;
    Intent intent=null;
    TextView customfont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_contest_common);
        grid= (GridView) findViewById(R.id.gridView);

        grid.setAdapter(new VivzAdapter(this));
        grid.setOnItemClickListener(this);
        intent=new Intent(this, GridItemDisplayDetails.class);
        
        customfont=(TextView) findViewById(R.id.textView1);
        Typeface fontobject=Typeface.createFromAsset(getAssets(),"horrendo.ttf");
        customfont.setTypeface(fontobject);
        customfont.setText("HOT WAR");
        customfont.setTextSize(27);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    	Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		v.vibrate(30);
        RelativeLayout layout=(RelativeLayout)view;
        ImageView image= (ImageView) layout.findViewById(R.id.imageView);
        SingleRow row= (SingleRow) image.getTag();

        int imageId=row.image;
        String imageName=row.flagName;
        intent.putExtra("selectedFlagId",imageId);
        intent.putExtra("selectedFlagName",imageName);

        startActivity(intent);
    }
    
}



class SingleRow {
    String flagName;
    int image;
    SingleRow(String flagName,int image)
    {
        this.flagName=flagName;
        this.image=image;
    }
}
class VivzAdapter extends BaseAdapter
{
    Context context;
    ArrayList<SingleRow> list;
    VivzAdapter(Context c)
    {
        this.context=c;
        list=new ArrayList<SingleRow>();
        Resources res=c.getResources();
        String[] flagTitles=res.getStringArray(R.array.flags);
        //int images[]={R.drawable.a,R.drawable.b,R.drawable.i,R.drawable.c,R.drawable.h,R.drawable.a,R.drawable.b,R.drawable.i,R.drawable.c,R.drawable.h,R.drawable.i};
        int images[]={R.drawable.mohit,R.drawable.sabrina,R.drawable.sabrina,R.drawable.a,R.drawable.mohit,R.drawable.sabrina,R.drawable.a,R.drawable.sabrina,R.drawable.mohit,R.drawable.a,R.drawable.sabrina,R.drawable.mohit,R.drawable.mohit,R.drawable.sabrina,R.drawable.a};
        //int images[]={R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i,R.drawable.i};
        for(int i=0;i<images.length;i++)
        {
            list.add(new SingleRow(flagTitles[i],images[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    class ViewHolder
    {
        ImageView myImageView;
        TextView contestant_name;
        ViewHolder(View view)
        {
            myImageView= (ImageView) view.findViewById(R.id.imageView);
            contestant_name= (TextView) view.findViewById(R.id.contestant_in_id);
        }
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder myHolder=null;
        View row=view;

        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_item,viewGroup,false);
            myHolder=new ViewHolder(row);
            row.setTag(myHolder);
        }
        else
        {
            myHolder= (ViewHolder) row.getTag();
        }
        SingleRow temp=list.get(i);
        //myHolder.myImageView.setImageResource(temp.image);
        
        //Drawable myDrawable = context.getResources().getDrawable(temp.image);
       // Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
       // myLogo.setDensity(DisplayMetrics.DENSITY_LOW);

        /*ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        myLogo.compress(CompressFormat.JPEG, 30, oStream);

        Bitmap newBitmap = BitmapFactory.decodeByteArray(oStream.toByteArray(), 0, oStream.toByteArray().length);*/
        
        
       // myHolder.myImageView.setImageBitmap(myLogo);
        //myHolder.myImageView.setImageDrawable.(temp.image);
        

        myHolder.myImageView.setImageResource(temp.image);
        myHolder.contestant_name.setTextSize(15);
        //myHolder.contestant_name.setTextColor();
        myHolder.contestant_name.setText(temp.flagName);
        myHolder.myImageView.setTag(temp);
        return row;
    }

}
