package andres_sjsu.parseusers;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by andres on 10/6/15.
 */
@ParseClassName("User")
public class User extends ParseObject {
    public String getUserId() {
        return getString("userId");
    }

    public String getBody() {
        return getString("body");
    }

    public void setUserId(String userId) {
        put("userId", userId);
    }

    public void setBody(String body) {
        put("body", body);
    }
}