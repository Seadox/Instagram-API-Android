package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Media {
    public static String GetInfo(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("media_id", mediaId);

        Client.SendRequest("media/" + mediaId + "/info/",data.toString());
        return Globals.LastResponse;
    }

    public static String Delete(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("media_id", mediaId);

        Client.SendRequest("media/" + mediaId + "/Delete/",data.toString());
        return Globals.LastResponse;
    }

    public static String Edit(String mediaId, String text) throws Exception {
        JSONObject data = new JSONObject();
        data.put("caption_text", text);

        Client.SendRequest("'media/"  + mediaId + "/edit_media/", null);
        return Globals.LastResponse;
    }

    public static String Like(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("media_id", mediaId);

        Client.SendRequest("media/" + mediaId + "/like/",data.toString());
        return Globals.LastResponse;
    }

    public static String Unlike(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("media_id", mediaId);

        Client.SendRequest("media/" + mediaId + "/unlike/",data.toString());
        return Globals.LastResponse;
    }

    public static String GetLikedFeed(String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("feed/liked/&max_id" + maxId, null);
        return Globals.LastResponse;
    }

    public static String GetLikers(String mediaId) throws Exception {
        Client.SendRequest("media/" + mediaId + "/likers/", null);
        return Globals.LastResponse;
    }

    public static String comment(String mediaId, String commentText) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("comment_text", commentText);

        Client.SendRequest("media/" + mediaId + "/comment/",data.toString());
        return Globals.LastResponse;
    }

    public static String GetComments(String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("feed/comments/&max_id" + maxId, null);
        return Globals.LastResponse;
    }

    public static String DeletComment(String mediaId, String commentId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/" + mediaId + "/comment/" + commentId + "/delete/",data.toString());
        return Globals.LastResponse;
    }

    public static String LikeComment(String commentId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/" + commentId + "/comment_like/",data.toString());
        return Globals.LastResponse;
    }

    public static String UnlikeComment(String commentId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/" + commentId + "/comment_unlike/",data.toString());
        return Globals.LastResponse;
    }

    public static String Save(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/" + mediaId + "/save/",data.toString());
        return Globals.LastResponse;
    }

    public static String UnSave(String mediaId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/" + mediaId + "/unsave/",data.toString());
        return Globals.LastResponse;
    }

    public static String GetSavedFeed(String maxId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("feed/saved/?max_id=" + maxId,data.toString());
        return Globals.LastResponse;
    }

    public static String GetBlockedMedia() throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("media/blocked/",data.toString());
        return Globals.LastResponse;
    }

    public static String GetID(String url){
        String[] urlexplode = url.split("/");
        String code = urlexplode[4];
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();

        long n = 0;
        for (int i = 0; i < code.length(); i++)
        {
            String c = String.valueOf(code.charAt(i));
            n = n * 64 + new String(alphabet).indexOf(c);
            if (i == 10) break;
        }
        return String.valueOf(n);
    }
}
