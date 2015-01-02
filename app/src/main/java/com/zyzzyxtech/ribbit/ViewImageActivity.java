package com.zyzzyxtech.ribbit;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Timer;
import java.util.TimerTask;


public class ViewImageActivity extends Activity {
    
    private static final int TIMER_DELAY = 10*1000; // 10 seconds * 1000 milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);
        
        setupActionBar();
        
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        
        Uri imageUri = getIntent().getData();
        
        Picasso.with(this).load(imageUri.toString()).into(imageView);
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
                
            }
        }, TIMER_DELAY);
    }

    /**
    * Set up the {@link android.app.ActionBar}.
    */
    
    private void setupActionBar() {
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
        
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

        return super.onOptionsItemSelected(item);
    }
}
