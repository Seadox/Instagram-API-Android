package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Constants;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONException;
import org.json.JSONObject;

public class Business {
    public static String getMediaInsights(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("ig_sig_key_version", Constants.SIG_KEY_VERSION);

        Client.SendRequest("insights/media_organic_insights/" + mediaId + "/", data.toString());
        return Globals.LastResponse;
    }
}
