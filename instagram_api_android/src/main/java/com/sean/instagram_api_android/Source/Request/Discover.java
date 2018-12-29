package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Discover {
    public static String getExploreFeed(String maxId, boolean isPrefetch) throws Exception {
        isPrefetch = false;

        JSONObject data = new JSONObject();
        data.put("is_prefetch", isPrefetch);
        data.put("is_from_promote", false);
        data.put("timezone_offset", System.currentTimeMillis());
        data.put("session_id", Globals.sessionid);

        Client.SendRequest("discover/explore/",data.toString());
        return Globals.LastResponse;
    }

    public static String getPopularFeed() throws Exception {
        JSONObject data = new JSONObject();
        data.put("people_teaser_supported", "1");
        data.put("rank_token", Globals.rank_token);
        data.put("ranked_content", "true");

        Client.SendRequest("feed/popular/",data.toString());
        return Globals.LastResponse;
    }

    public static String getHomeChannelFeed() throws Exception {
        Client.SendRequest("discover/channels_home/", null);
        return Globals.LastResponse;
    }
}
