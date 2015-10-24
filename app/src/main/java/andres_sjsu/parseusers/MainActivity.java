/*
Tutorials:
git repo:
https://github.com/AndreSand/UserParse.git

get username:
http://codetheory.in/android-login-signup-with-parse/

 */

package andres_sjsu.parseusers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseFile;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {
    ParseUser parseUser;
    String TAG = "Hello Andres";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TEXT
        TextView mUsername = (TextView) findViewById(R.id.txt_name);



        // Get current user
        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser == null) {
            // It's an anonymous user, hence show the login screen
            navigateToLogin();
        }
        else {
            // The user is logged in, yay!!
            Log.i(TAG, currentUser.getUsername());
            mUsername.setText(currentUser.getUsername());
        }


        //Add sign out button POC
        findViewById(R.id.logout_button).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                ParseUser.logOut();

                Intent intent = new Intent(MainActivity.this, DispatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
    private void navigateToLogin() {
        // Launch the login activity

        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //LogOut From Menu not Working. Sign out button working fine :)
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_user_profile, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.logout) {
                //return true;
                LogOut();
                Toast.makeText(getApplicationContext(), "Sign Out", Toast.LENGTH_LONG).show();
            }

            return super.onOptionsItemSelected(item);
        }

    public void LogOut() {
        ParseUser.logOut();
        Intent intent = new Intent(MainActivity.this, DispatchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
