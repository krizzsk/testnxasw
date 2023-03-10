package didihttp;

import java.nio.charset.Charset;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, Charset.forName("ISO-8859-1"));
    }

    public static String basic(String str, String str2, Charset charset) {
        String base64 = ByteString.m6997of((str + ":" + str2).getBytes(charset)).base64();
        return "Basic " + base64;
    }
}
