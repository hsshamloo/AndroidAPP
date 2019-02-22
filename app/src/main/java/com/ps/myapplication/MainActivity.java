package com.ps.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.apache.commons.logging.Log;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private ViewPager mViewPager;
    private PagerAdapter mSlideShowPagerAdapter;
    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.tool_bar);

       //Add Icon Fragment To MAin Activity
        try {
            FragmentViewIcon fragmentViewIcon = new FragmentViewIcon();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.main_layout,fragmentViewIcon,"IconFragment");
            fragmentTransaction.commit();
        }
        catch (Exception e){
            e.printStackTrace();

        }



        /*mViewPager = (ViewPager)findViewById(R.id.slide_show);

        mSlideShowPagerAdapter = new SlideShowPagerAdapter(this);
        mViewPager.setAdapter(mSlideShowPagerAdapter);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
       /* if (id == R.id.imgaboutus) {
            startActivity(new Intent(this, AboutUsActivity.class));
        }*/


        return super.onOptionsItemSelected(item);
    }

    public void goOnContat() {
        this.toolbar.setBackgroundColor(Color.BLUE);


    }

    public class SlideShowPagerAdapter extends PagerAdapter {
        public int[] mResources = {
                R.drawable.ydhospital_day,
                R.drawable.ydhospital_night
        };

        Context mContext;
        LayoutInflater mLayoutInflater;

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.image_item, container, false);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);
            container.addView(itemView);
            return itemView;


        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }


        public SlideShowPagerAdapter(Context context) {

            mContext = context;
            mLayoutInflater =
                    (LayoutInflater) mContext.getSystemService(context.LAYOUT_INFLATER_SERVICE);


        }


    }

}
