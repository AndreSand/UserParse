package andres_sjsu.parseusers;

import com.parse.ParseFile;

import java.io.Serializable;

/**
 * Created by andres on 10/26/15.
 */
public class UserParse implements Serializable {

    private String myString;



    public UserParse(User parseObject){

        myString = parseObject.getmyString();


    }


    public String getmyString() {
        return myString;
    }

    public void myString(String myString) {
        this.myString = myString;
    }




}
