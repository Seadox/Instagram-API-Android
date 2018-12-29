package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Location {
    public static String search(String latitude, String longitude) throws Exception {
        JSONObject data = new JSONObject();
        data.put("rank_token", Globals.rank_token);
        data.put("latitude", latitude);
        data.put("longitude", longitude);

        Client.SendRequest("location_search/", data.toString());
        return Globals.LastResponse;
    }

    public static String getFeed(String locationId, String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;

        Client.SendRequest("feed/location/" + locationId + "/&max_id", null);
        return Globals.LastResponse;
    }
}
