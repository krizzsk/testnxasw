package com.threatmetrix.TrustDefender;

import android.content.Context;
import com.threatmetrix.TrustDefender.tqttqq;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.Nonnull;

public class tqqtqq {
    private static final String b006E006En006Enn = "537.36";
    private static final String b006Enn006Enn = "534.13";
    private static final String bn006En006Enn = "534.30";
    @Nonnull
    private static final TreeMap<Integer, String> bnn006E006Enn;
    private static final String bnnn006Enn = "533.1";

    static {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        bnn006E006Enn = treeMap;
        treeMap.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bn006E006E006En006E), bnnn006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006E006E006E006En006E), bnnn006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bnnnn006E006E), bnnn006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006Ennn006E006E), bnnn006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bn006Enn006E006E), b006Enn006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006E006Enn006E006E), bn006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bnn006En006E006E), bn006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006En006En006E006E), bn006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bn006E006En006E006E), bn006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006E006E006En006E006E), bn006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bnnn006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006Enn006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bn006En006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006E006En006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bnn006E006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006En006E006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bn006E006E006E006E006E), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006B006Bkkkk), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bkk006Bkkk), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.b006Bk006Bkkk), b006E006En006Enn);
        bnn006E006Enn.put(Integer.valueOf(tqttqq.ttttqq.tqqqtq.bk006B006Bkkk), b006E006En006Enn);
    }

    private tqqtqq() {
    }

    private static String b00750075uuu0075(Context context) {
        tqttqq tqttqq = new tqttqq();
        tqttqq.getClass();
        String b00760076vv0076v = new tqttqq.tqqttq(context, "com.google.android.webview", 128).b00760076vv0076v();
        if (yqqyqq.b0069ii0069i0069(b00760076vv0076v)) {
            return " Chrome/".concat(b00760076vv0076v);
        }
        tqttqq tqttqq2 = new tqttqq();
        tqttqq2.getClass();
        String b00760076vv0076v2 = new tqttqq.tqqttq(context, "com.android.webview", 128).b00760076vv0076v();
        return yqqyqq.b0069ii0069i0069(b00760076vv0076v2) ? " Chrome/".concat(b00760076vv0076v2) : "";
    }

    @Nonnull
    public static String buu0075uu0075(tqtqqt tqtqqt) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "";
        if (bnn006E006Enn.containsKey(Integer.valueOf(tqttqq.ttttqq.qqqqtq.b006E006En006En006E))) {
            str = bnn006E006Enn.get(Integer.valueOf(tqttqq.ttttqq.qqqqtq.b006E006En006En006E));
        } else {
            Map.Entry<Integer, String> lastEntry = bnn006E006Enn.lastEntry();
            str = lastEntry != null ? lastEntry.getValue().concat("+") : str5;
        }
        String language = Locale.getDefault().getLanguage();
        String country = Locale.getDefault().getCountry();
        if (!country.isEmpty()) {
            str2 = language + "-" + country + "; ";
        } else {
            str2 = language + "; ";
        }
        if (tqttqq.ttttqq.qqqqtq.b006E006En006En006E >= tqttqq.ttttqq.tqqqtq.bn006En006E006E006E) {
            str3 = "; wv) AppleWebKit/";
            str4 = "Mozilla/5.0 (Linux; Android ";
            str2 = str5;
        } else {
            str4 = "Mozilla/5.0 (Linux; U; Android ";
            str3 = ") AppleWebKit/";
        }
        if (!(tqtqqt == null || tqtqqt.bll006C006C006C006C == null)) {
            str5 = b00750075uuu0075(tqtqqt.bll006C006C006C006C);
        }
        return str4 + tqttqq.ttttqq.qqqqtq.b006Enn006En006E + "; " + str2.toLowerCase(Locale.US) + tqttqq.ttttqq.bn006E006E006E006En + " Build/" + tqttqq.ttttqq.b006E006En006E006En + str3 + str + " (KHTML, like Gecko) Version/4.0" + str5 + " Mobile Safari/" + str + " " + "6.3-80";
    }
}
