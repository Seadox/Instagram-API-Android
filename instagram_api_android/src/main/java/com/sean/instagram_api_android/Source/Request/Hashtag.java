package com.sean.instagram_api_android.Source.Request;

import android.text.Html;
import android.text.Spanned;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Hashtag {
    public static String getInfo(String hashtag) throws Exception {
        Spanned urlhashtag = Html.fromHtml(hashtag);

        Client.SendRequest("tags/"+urlhashtag+"/info/", null);
        return Globals.LastResponse;
    }

    public static String getFeed(String hashtag, String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Spanned urlhashtag = Html.fromHtml(hashtag);

        Client.SendRequest("feed/tag/"+urlhashtag+"/&max_id"+maxId, null);
        return Globals.LastResponse;
    }

    public static String getRelated(String hashtag) throws Exception {
        Spanned urlhashtag = Html.fromHtml(hashtag);

        JSONObject data = new JSONObject();
        data.put("visited", "[{\"id\":\"\" + urlhashtag + \"\",\"type\":\"hashtag\"}]");
        data.put("related_types", "[\"hashtag\"]");

        Client.SendRequest("tags/"+urlhashtag+"/related/", data.toString());
        return Globals.LastResponse;
    }

    public static String search(String query) throws Exception{
        JSONObject data = new JSONObject();
        data.put("q", query);
        data.put("timezone_offset",  System.currentTimeMillis());
        data.put("count", "30");
        data.put("rank_token", Globals.rank_token);

        Client.SendRequest("tags/search/", data.toString());
        return Globals.LastResponse;
    }

    public static String follow(String hashtag) throws Exception {
        Spanned urlhashtag = Html.fromHtml(hashtag);

        JSONObject data = new JSONObject();
        data.put("_uuid",  Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("tags/follow/" + urlhashtag +"/", data.toString());
        return Globals.LastResponse;
    }

    public static String unfollow(String hashtag) throws Exception {
        Spanned urlhashtag = Html.fromHtml(hashtag);

        JSONObject data = new JSONObject();
        data.put("_uuid",  Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("tags/unfollow/" + urlhashtag +"/", data.toString());
        return Globals.LastResponse;
    }

    public static String getFollowing(String userId) throws Exception {
        Client.SendRequest("users/" + userId + "/following_tags_info/", null);
        return Globals.LastResponse;
    }

    public static String getSelfFollowing() throws Exception {
        getFollowing(Globals.username_id);
        return Globals.LastResponse;
    }

    public static String getFollowSuggestions() throws Exception {
        Client.SendRequest("tags/suggested/", null);
        return Globals.LastResponse;
    }
}
