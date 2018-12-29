package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Live {
    public static String getInfo(String broadcastId) throws Exception {
        Client.SendRequest("live/" + broadcastId + "/info/", null);
        return Globals.LastResponse;
    }

    public static String getViewerList(String broadcastId) throws Exception {
        Client.SendRequest("live/" + broadcastId + "/get_viewer_list/", null);
        return Globals.LastResponse;
    }

    public static String getFinalViewerList(String broadcastId) throws Exception {
        Client.SendRequest("live/" + broadcastId + "/get_final_viewer_list/", null);
        return Globals.LastResponse;
    }

    public static String getPostLiveViewerList(String broadcastId) throws Exception {
        Client.SendRequest("live/" + broadcastId + "/get_post_live_viewers_list/", null);
        return Globals.LastResponse;
    }

    public static String getHeartbeatAndViewerCount(String broadcastId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid",Globals.uuid);
        data.put("csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "/heartbeat_and_get_viewer_count/", data.toString());
        return Globals.LastResponse;
    }

    public static String showQuestion(String broadcastId, String questionId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid",Globals.uuid);
        data.put("csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "/question/" + questionId + "/activate", data.toString());
        return Globals.LastResponse;
    }

    public static String hideQuestion(String broadcastId, String questionId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid",Globals.uuid);
        data.put("csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "/question/" + questionId + "/deactivate", data.toString());
        return Globals.LastResponse;
    }

    public static String getQuestions(String broadcastId) throws Exception {
        Client.SendRequest("live/get_questions", null);
        return Globals.LastResponse;
    }

    public static String getLiveBroadcastQuestions() throws Exception {
        getQuestions(Globals.username_id);
        return Globals.LastResponse;
    }

    public static String pinComment(String broadcastId, String commentId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("offset_to_video_start", 0);
        data.put("comment_id", commentId);
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "/pin_comment/", data.toString());
        return Globals.LastResponse;
    }

    public static String unpinComment(String broadcastId, String commentId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("offset_to_video_start", 0);
        data.put("comment_id", commentId);
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "/unpin_comment/", data.toString());
        return Globals.LastResponse;
    }

    public static String enableComments(String broadcastId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "unmute_comment/", data.toString());
        return Globals.LastResponse;
    }

    public static String disableComments(String broadcastId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        Client.SendRequest("live/" + broadcastId + "mute_comment/", data.toString());
        return Globals.LastResponse;
    }

    public static String create() throws Exception {
        String previewWidth = "720";
        String previewHeight = "1184";
        String broadcastMessage = "";

        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("preview_height", previewHeight);
        data.put("preview_width", previewWidth);
        data.put("broadcast_message", broadcastMessage);
        data.put("broadcast_type", "RTMP");
        data.put("internal_only", "0");

        Client.SendRequest("live/create/", data.toString());
        return Globals.LastResponse;
    }

    public static String start(String broadcastId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("live/"+broadcastId+"/start/", data.toString());
        return Globals.LastResponse;
    }

    public static String addToPostLive(String broadcastId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("uid", Globals.username_id);

        Client.SendRequest("live/"+broadcastId+"/add_to_post_live/", data.toString());
        return Globals.LastResponse;
    }

    public static String like(String broadcastId) throws Exception {
        String likeCount = "1";

        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("uid", Globals.username_id);
        data.put("user_like_count", likeCount);

        Client.SendRequest("live/"+broadcastId+"/like/", data.toString());
        return Globals.LastResponse;
    }
}
