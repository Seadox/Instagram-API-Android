package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Story {
    public static String getReelsTrayFeed() throws Exception {
        Client.SendRequest("feed/reels_tray/", null);
        return Globals.LastResponse;
    }

    public static String getUserReelMediaFeed(String userId) throws Exception {
        Client.SendRequest("feed/user/" + userId + "/reel_media/", null);
        return Globals.LastResponse;
    }

    public static String getUserStoryFeed(String userId) throws Exception {
        Client.SendRequest("feed/user/" + userId + "/story/", null);
        return Globals.LastResponse;
    }

    //Works for your own story items
    public static String getStoryItemViewers(String storyPk, String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("media/" + storyPk + "/list_reel_media_viewer/?max_id=" + maxId, null);
        return Globals.LastResponse;
    }

    public static String getReelSettings() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("users/reel_settings/", data.toString());
        return Globals.LastResponse;
    }

    public static String getArchivedStoriesFeed() throws Exception {
        Client.SendRequest("archive/reel/day_shells/?include_cover=0", null);
        return Globals.LastResponse;
    }
}
