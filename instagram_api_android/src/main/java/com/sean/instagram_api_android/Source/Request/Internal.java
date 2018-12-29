package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONArray;
import org.json.JSONObject;

public class Internal {

    //TODO add api version
    public static String markStoryMediaSeen(String itemSourceId, String itemId, String itemTakenAt) throws Exception {
        long maxSeenAt = System.currentTimeMillis()/1000;
        int seenAt = (int) (maxSeenAt - 3);

        String reelId = itemId + "_" + itemSourceId;

        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("live_vods", new JSONArray());
        data.put("reels", new JSONObject().put(reelId, new JSONArray(itemTakenAt + "_" + seenAt)));
        data.put("reel", 1);
        data.put("live_vod", 0);

        Client.SendRequest("media/seen/", data.toString());
        return Globals.LastResponse;
    }
}
