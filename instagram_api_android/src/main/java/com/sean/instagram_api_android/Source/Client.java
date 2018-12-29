package com.sean.instagram_api_android.Source;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Locale;

public class Client {
    public static boolean SendRequest(String endpoint, String post) throws Exception {
        BufferedReader in = null;
        Log.i("System", "Debugging... " + Constants.API_URLS[0] + endpoint);
        try {
            HttpClient client = new DefaultHttpClient();
            URI url = new URI(Constants.API_URLS[0] + endpoint);
            HttpPost request = new HttpPost();
            request.setHeader("Connection", "close");
            request.setHeader("Accept", "*/*");
            request.setHeader("Content-type", Constants.CONTENT_TYPE);
            request.setHeader("Cookie2", "$Version=1");
            request.setHeader("Accept-Language", Constants.ACCEPT_LANGUAGE);
            request.setHeader("User-Agent", "Instagram " + Constants.IG_VERSION +" Android (18/4.3; 320dpi; 720x1280; Xiaomi; HM 1SW; armani; qcom; en_US)");
            request.setHeader("Cookie", Globals.sessionid);
            request.setURI(url);

            if (post != null) {
                StringEntity entity = new StringEntity("ig_sig_key_version=4&signed_body=" + Signatures.HMAC(post, Constants.IG_SIG_KEY) + "." + Signatures.EncodeUrl(post));
                request.setEntity(entity);
            }

            HttpResponse response = client.execute(request);

            Header[] headers2 = response.getHeaders("Set-Cookie");
            for (Header header : headers2) {
                if (header.getValue().split(";")[0].split("=")[0].equals("sessionid"))
                    Globals.sessionid = header.getValue().split(";")[0];
                if (header.getValue().split(";")[0].split("=")[0].equals("csrftoken"))
                    Globals.csrftoken = header.getValue().split(";")[0].split("=")[1];
            }

            in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuffer buffer = new StringBuffer("");

            String l = "";
            String nl = System.getProperty("line.separator");
            while ((l = in.readLine()) != null){
                buffer.append(l).append(nl);
            }
            in.close();
            Globals.LastResponse = buffer.toString();
            return true;

        }finally {
            if (in != null){
                try {
                    in.close();
                    return true;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static String m8457b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = (int) (displayMetrics.density * 160.0f);
        int i2 = displayMetrics.heightPixels;
        int i3 = displayMetrics.widthPixels;
        return String.format("%s Android (%s/%s; %s; %s; %s; %s; %s; %s; %s_%s)", "Instagram 9.2.0", Build.VERSION.RELEASE, Build.VERSION.SDK, i + "dpi", i2 + "x" + i3, Build.MODEL, Build.MANUFACTURER, Build.BRAND, Build.DEVICE, Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());
    }
}
