package com.sean.instagram_api_android.Source.Request;

import android.util.Log;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;
import com.sean.instagram_api_android.Source.Signatures;

import org.json.JSONObject;

public class Instagram {
    public static void Login(String username, String password) throws Exception {

        String device_id =  Signatures.generateDeviceId(username + password);
        Globals.uuid = Signatures.generateUUID(true);

        if (Client.SendRequest("si/fetch_headers/?challenge_type=signup&guid=" + Signatures.generateUUID(false), null)){

            JSONObject data = new JSONObject();
            data.put("_csrftoken",Globals.csrftoken);
            data.put("username", username);
            data.put("guid", Globals.uuid);
            data.put("device_id", device_id);
            data.put("password", password);
            data.put("login_attempt_count", "0");

            if (Client.SendRequest("accounts/login/",data.toString())){
                JSONObject o = new JSONObject(Globals.LastResponse);

                //Success
                if (o.getString("status").equals("ok")) {
                    Globals.username_id = o.getJSONObject("logged_in_user").getString("pk").toString();
                    Globals.rank_token = Globals.username_id + "_" + Globals.uuid;
                    Globals.token = Globals.csrftoken;
                    Globals.profile_pic_url = o.getJSONObject("logged_in_user").getString("profile_pic_url");

                    Log.v("Client", "Login Success!");
                }
                //Fail
                else if(o.getString("status").equals("fail")){

                }
            }
        }

    }

    public static String Logout() throws Exception {
        Client.SendRequest("accounts/logout/", null);
        return Globals.LastResponse;
    }
}
