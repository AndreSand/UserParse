/*
Tutorials:
git repo:
https://github.com/AndreSand/UserParse.git

get username:
http://codetheory.in/android-login-signup-with-parse/

 */

package andres_sjsu.parseusers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ParseUser parseUser;
    String TAG = "Hello Andres";
    private UserParse User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get current user
        final ParseUser currentUser = ParseUser.getCurrentUser();

        //getting intent
        User = (UserParse) getIntent().getSerializableExtra("user");

        //TEXT
        TextView mUsername = (TextView) findViewById(R.id.txt_name);
        TextView tv_email = (TextView) findViewById(R.id.tv_email);
        TextView tv_zipcode = (TextView) findViewById(R.id.tv_zipcode);

        if (currentUser == null) {
            // It's an anonymous user, hence show the login screen
            navigateToLogin();
        } else {
            // The user is logged in, yay!!
            Log.i(TAG, currentUser.getUsername());
           mUsername.setText(currentUser.getUsername());
         // mUsername.setText(currentUser.g());
            // The user is logged in, yay!!
        //  //  Log.i("failed: ---->", UserParse.class.getName());
            Log.i("failed: ---->", currentUser.getEmail());
           tv_email.setText(currentUser.getString("email"));
            tv_zipcode.setText(currentUser.getString("zipcode"));
         //   tv_zipcode.setText(currentUser.getString("myString"));
          // Works
          // tv_email.setText(currentUser.getEmail());
          // mUsername.setText(currentUser.getmyString());

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

        //Camera button
        // Locate the button in main.xml
        ImageButton button = (ImageButton) findViewById(R.id.imageButton);

        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {

            public void onClick (View arg0){
                // Locate the image in res > drawable-hdpi
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher);
                // Convert it to byte
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                // Compress image to lower quality scale 1 - 100
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] image = stream.toByteArray();

                // Create the ParseFile
                ParseFile file = new ParseFile("androidbegin.png", image);
                // Upload the image into Parse Cloud
                file.saveInBackground();

                // Create a New Class called "ImageUpload" in Parse
                ParseObject imgupload = new ParseObject("ImageUpload");

                // Create a column named "ImageName" and set the string
                imgupload.put("ImageName", "AndroidBegin Logo");

                // Create a column named "ImageFile" and insert the image
                //imgupload.put("ImageFile", file);

                currentUser.put("Pic",file);

                // Create the class and the columns
                currentUser.saveInBackground();

                // Show a simple toast message
                Toast.makeText(MainActivity.this, "Image Uploaded",
                        Toast.LENGTH_SHORT).show();
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
