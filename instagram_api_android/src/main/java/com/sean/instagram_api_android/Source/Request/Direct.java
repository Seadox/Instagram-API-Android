package com.sean.instagram_api_android.Source.Request;

import com.sean.instagram_api_android.Source.Client;
import com.sean.instagram_api_android.Source.Globals;

import org.json.JSONObject;

public class Direct {
    public static String getInbox(String cursorId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("persistentBadging", "true");
        data.put("use_unified_inbox", "true");

        Client.SendRequest("direct_v2/inbox/",data.toString());
        return Globals.LastResponse;
    }

    public static String getVisualInbox() throws Exception {
        JSONObject data = new JSONObject();
        data.put("persistentBadging", "true");

        Client.SendRequest("direct_v2/visual_inbox/",data.toString());
        return Globals.LastResponse;
    }

    public static String getShareInbox() throws Exception {
        Client.SendRequest("direct_share/inbox/?", null);
        return Globals.LastResponse;
    }

    public static String getThread(String threadId, String cursorId) throws Exception {
        JSONObject data = new JSONObject();
        data.put("use_unified_inbox", "true");

        Client.SendRequest("direct_v2/threads/" + threadId + "/",data.toString());
        return Globals.LastResponse;
    }

    public static String getPresences() throws Exception {
        Client.SendRequest("direct_v2/get_presence/", null);
        return Globals.LastResponse;
    }
}
