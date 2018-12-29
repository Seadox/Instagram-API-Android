package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class People {
    public static String GetInfoByName(String username) throws Exception {
        Client.SendRequest("users/" + username + "/usernameinfo/", null);
        return Globals.LastResponse;
    }

    public static String GetInfoById(String userId) throws Exception {
        Client.SendRequest("users/" + userId + "/info/", null);
        return Globals.LastResponse;
    }

    public static String GetSelfInfo() throws Exception {
        GetInfoById(Globals.username_id);
        return Globals.LastResponse;
    }

    public static String GetRecentActivityInbox() throws Exception {
        Client.SendRequest("news/inbox/?activity_module=all&show_su=true", null);
        return Globals.LastResponse;
    }

    public static String GetFollowingRecentActivity(String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("news/?max_id=" + maxId, null);
        return Globals.LastResponse;
    }

    public static String GetFriendship(String userId) throws Exception {
        Client.SendRequest("friendships/show/" + userId, null);
        return Globals.LastResponse;
    }

    public static String RemoveFollower(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.token);
        data.put("user_id", userId);

        Client.SendRequest("friendships/remove_follower/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String GetFollowing(String userId, String maxId) throws Exception {
        maxId = maxId.isEmpty() ? "" : maxId;
        Client.SendRequest("friendships/" + userId + "/followers/?rank_token=" + Globals.rank_token + "&max_id=" + maxId, null);

        return Globals.LastResponse;
    }

    // query = username or name
    public static String Search(String query) throws Exception {
        Client.SendRequest("users/search/?rank_token=" + Globals.rank_token + "query" + query, null);
        return Globals.LastResponse;
    }

    public static String Follow(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("user_id", userId);

        Client.SendRequest("friendships/create/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String Unfollow(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("user_id", userId);

        Client.SendRequest("friendships/destroy/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String TurnOnUserNotification(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("friendships/favorite/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String TurnOffUserNotification(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("friendships/unfavorite/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String Block(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("user_id", userId);

        Client.SendRequest("friendships/block/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String Unblock(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("user_id", userId);

        Client.SendRequest("friendships/unblock/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String GetBlockedList() throws Exception {
        Client.SendRequest("users/blocked_list/", null);
        return Globals.LastResponse;
    }

    public static String BlockStory(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("source", "profile");

        Client.SendRequest("friendships/block_friend_reel/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String UnblockStory(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);
        data.put("source", "profile");

        Client.SendRequest("friendships/unblock_friend_reel/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String GetBlockedStoryList(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("friendships/blocked_reels/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String muteFriendStory(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("friendships/mute_friend_reel/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String unmuteFriendStory(String userId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("_uuid", Globals.uuid);
        data.put("_uid", Globals.username_id);
        data.put("_csrftoken", Globals.csrftoken);

        Client.SendRequest("friendships/unmute_friend_reel/" + userId + "/", data.toString());
        return Globals.LastResponse;
    }

    public static String GetUserId(String username) throws Exception {
        JSONObject o = new JSONObject(GetInfoByName(username));
        return o.getJSONObject("user").getString("pk");
    }
}
