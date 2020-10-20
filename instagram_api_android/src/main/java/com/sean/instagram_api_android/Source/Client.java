package com.sean.instalive.src;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class Client {
    public static boolean SendRequest(final String endpoint, final String post) {
        ((Runnable) () -> {

            HttpResponse response = null;

            try {
                HttpClient client = new DefaultHttpClient();
                URI url = new URI(Constants.API_URLS[0] + endpoint);

                //POST request
                if (post != null) {
                    HttpPost request = new HttpPost();
                    request.setHeader("Connection", "Keep-Alive");
                    request.setHeader("Accept", "*/*");
                    request.setHeader("Content-type", Constants.CONTENT_TYPE);
                    request.setHeader("Cookie2", "$Version=1");
                    request.setHeader("Accept-Language", Constants.ACCEPT_LANGUAGE);
                    request.setHeader("User-Agent", Globals.userAgent);
                    request.setHeader("Cookie", Globals.sessionid);
                    request.setHeader("X-IG-Connection-Type", Constants.X_IG_Connection_Type);
                    request.setURI(url);

                    StringEntity entity = new StringEntity("ig_sig_key_version=4&signed_body=" + Signatures.HMAC(post, Constants.IG_SIG_KEY) + "." + Signatures.EncodeUrl(post));
                    request.setEntity(entity);

                    response = client.execute(request);
                }
                //GET request
                else{
                    HttpGet request = new HttpGet();
                    request.setHeader("Connection", "Keep-Alive");
                    request.setHeader("Accept", "*/*");
                    request.setHeader("Content-type", Constants.CONTENT_TYPE);
                    request.setHeader("Cookie2", "$Version=1");
                    request.setHeader("Accept-Language", Constants.ACCEPT_LANGUAGE);
                    request.setHeader("User-Agent", "Instagram " + Constants.IG_VERSION + " Android (18/4.3; 320dpi; 720x1280; Xiaomi; HM 1SW; armani; qcom; en_US)");
                    request.setHeader("Cookie", Globals.sessionid);
                    request.setHeader("X-IG-Connection-Type", Constants.X_IG_Connection_Type);
                    request.setURI(url);

                    response = client.execute(request);
                }

                HttpEntity entity = response.getEntity();
                InputStream is = entity.getContent();

                Header[] headers2 = response.getHeaders("Set-Cookie");
                for (Header header : headers2) {
                    if (header.getValue().split(";")[0].split("=")[0].equals("sessionid"))
                        Globals.sessionid = header.getValue().split(";")[0];
                    if (header.getValue().split(";")[0].split("=")[0].equals("csrftoken"))
                        Globals.csrftoken = header.getValue().split(";")[0].split("=")[1];
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(is));
                StringBuilder sb = new StringBuilder();

                String l = "";
                while ((l = in.readLine()) != null) // Read line by line
                    sb.append(l).append("\n");

                is.close();

                Globals.LastResponse = String.valueOf(sb);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).run();
        return true;
    }


}
