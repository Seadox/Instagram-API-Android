package com.sean.instagram_api_android.Source;

import java.net.URLEncoder;
import java.security.Key;
import java.util.Formatter;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Signatures {
    public static String generateUUID(boolean type) throws Exception{
        if (type)
            return UUID.randomUUID().toString();
        else
            return UUID.randomUUID().toString().replace("-","");
    }

    public static String generateDeviceId(String source) throws Exception{
        return "android-" + GetMd5Hash(GetMd5Hash(source)+"12345").substring(0, 16);
    }

    public static String HMAC(String string, String key) throws Exception{
        Key secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        Mac instance = Mac.getInstance(secretKeySpec.getAlgorithm());
        instance.init(secretKeySpec);
        return Builder(instance.doFinal(string.getBytes()));
    }

    public static String Builder(byte[] bArr) {
        Appendable stringBuilder = new StringBuilder(bArr.length * 2);
        Formatter formatter = new Formatter(stringBuilder);
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
        }
        return stringBuilder.toString();
    }

    public static String EncodeUrl(String url) throws Exception{
        return URLEncoder.encode(url, "UTF-8");
    }

    static String GetMd5Hash(String input) throws Exception{
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
