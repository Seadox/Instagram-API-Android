package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

public class Collection {
    public static String getList() throws Exception {
        Client.SendRequest("collections/list/", null);
        return Globals.LastResponse;
    }

    public static String getFeed(String collectionId) throws Exception {
        Client.SendRequest("feed/collection/" + collectionId + "/", null);
        return Globals.LastResponse;
    }
}
