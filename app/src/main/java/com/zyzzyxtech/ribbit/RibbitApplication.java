package com.zyzzyxtech.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;
import com.zyzzyxtech.ribbit.ui.MainActivity;
import com.zyzzyxtech.ribbit.utils.ParseConstants;

/**
 * Created by Ken on 12/26/2014.
 */
public class RibbitApplication extends Application {

    @Override
    public void onCreate() {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        super.onCreate();
        Parse.initialize(this, "yAuyzglSo7nLzgkS2OVFdVGj6lWwWm5FE01M6Jtr", "bN67hNWszlq7K5JKr85Z2ML0QkmvzfJL62KpJsKD");

        //PushService.setDefaultPushCallback(this, MainActivity.class);
        PushService.setDefaultPushCallback(this,
                MainActivity.class, 
                R.drawable.ic_stat_ic_launcher);
        ParseInstallation.getCurrentInstallation().saveInBackground();
       
    }
    
    public static void updateParseInstallation(ParseUser user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
        installation.saveInBackground();
        
    }
}