package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

public class Highlight {
    public static String getUserFeed(String userId) throws Exception {
        Client.SendRequest("highlights/" + userId + "/highlights_tray/", null);
        return Globals.LastResponse;
    }

    public static String getSelfUserFeed() throws Exception {
        getUserFeed(Globals.username_id);
        return Globals.LastResponse;
    }
}
