package andres_sjsu.parseusers;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by andres on 10/6/15.
 */
@ParseClassName("User")
public class User extends ParseObject {

    public User() {
        // Default constructor
    }

    //myString test
    public String getmyString() {
        String myString = getString("myString");
        return str(myString);
    }
    public void setmyString(String myString) {
        put("myString", myString);
    }




//    public String getUserId() {
//        return getString("userId");
//    }
//
//    public String getBody() {
//        return getString("body");
//    }
//
//    public void setUserId(String userId) {
//        put("userId", userId);
//    }
//
//    public void setBody(String body) {
//        put("body", body);
//    }


    //    public void setUsername(String username) {
//        this.put("username", username);
//    }
//
//    public String getUsername() {
//        return this.getString("username");
//    }
// Method to check if string is empty, return '';
    private String str(String text) {
        if (text == null) {
            text = "";
        }
        return text;
    }

}