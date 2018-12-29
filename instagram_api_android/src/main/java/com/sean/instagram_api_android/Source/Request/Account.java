package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Account {
    //TODO
    public static String ChangeProfilePicture(){
        return Globals.LastResponse;
    }

    public static String RemoveProfilePicture() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("accounts/remove_profile_picture/",data.toString());
        return Globals.LastResponse;
    }

    public static String SetPrivate() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("accounts/set_private/",data.toString());
        return Globals.LastResponse;
    }

    public static String SetPublic() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("accounts/set_public/",data.toString());
        return Globals.LastResponse;
    }

    public static String ChangePassword(String oldPassword, String newPassword) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("old_password", oldPassword);
        data.put("new_password1", newPassword);
        data.put("new_password2", newPassword);

        Client.SendRequest("accounts/change_password/",data.toString());
        return Globals.LastResponse;
    }

    public static String getCurrentUser() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("accounts/current_user/", data.toString());
        return Globals.LastResponse;
    }

    public static String checkUsername(String username) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("username", username);

        Client.SendRequest("accounts/check_username/",data.toString());
        return Globals.LastResponse;
    }

    public static String enablePresence() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("disabled", "0");

        Client.SendRequest("accounts/set_presence_disabled/",data.toString());
        return Globals.LastResponse;
    }

    public static String disablePresence() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("disabled", "1");

        Client.SendRequest("accounts/set_presence_disabled/",data.toString());
        return Globals.LastResponse;
    }
}
