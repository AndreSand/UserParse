package andres_sjsu.parseusers;

import android.app.Application;
import android.os.Message;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


import java.text.ParseException;

/**
 * Created by andres on 10/6/15.
 */
public class UserSimple_Parse extends Application {
    public static final String YOUR_APPLICATION_ID = "yvDL7S0lQ80ftgduGQ9zTK27Elqlvi3YtQftdKcG";
    public static final String YOUR_CLIENT_KEY = "lZ7kls44MmqEN80L9nu10xy3IcAKPVdKJim7ay0y";

    @Override
    public void onCreate() {
        super.onCreate();
        // Register your parse models here
        ParseObject.registerSubclass(User.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, YOUR_APPLICATION_ID, YOUR_CLIENT_KEY);
    }
}
        // Test creation of object
/*
        ParseUser user = new ParseUser();
        user.setUsername("Wolverine");
        user.setPassword("Xmen");
        user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }

        });*/
