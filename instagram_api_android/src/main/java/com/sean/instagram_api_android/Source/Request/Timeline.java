package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

public class Timeline {
    public static String GetTimelineFeed() throws Exception {
        Client.SendRequest("feed/timeline/", null);
        return Globals.LastResponse;
    }

    public static String GetUserFeed(String userId, String maxId, String minTimestamp) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        minTimestamp = minTimestamp.isEmpty() ? "" : minTimestamp;

        Client.SendRequest("feed/user/" + userId + "/?rank_token=" + Globals.csrftoken + "&ranked_content=true&max_id" + maxId + "&min_timestamp" + minTimestamp, null);
        return Globals.LastResponse;
    }

    public static String GetSelfFeed(String maxId, String minTimestamp) throws Exception {
        GetUserFeed(Globals.username_id, maxId, minTimestamp);
        return Globals.LastResponse;
    }
}
