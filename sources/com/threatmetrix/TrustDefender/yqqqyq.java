package com.threatmetrix.TrustDefender;

import com.google.common.net.HttpHeaders;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class yqqqyq {
    @Nonnull
    public static final String b006200620062bbb;
    private static final Pattern b00620062bbbb = Pattern.compile("^[a-zA-Z0-9]{8}$");
    private static final Map<String, String> b0062b0062bbb;
    public static final Map<String, String> bb00620062bbb;
    private static final String bb0062bbbb = yyyyqy.b0074t007400740074t(yqqqyq.class);
    private static final String bbb0062bbb = "https://";
    public final String b0062bb0062bb;
    public final String bb0062b0062bb;
    private final String bbbb0062bb;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate, no-transform");
        bb00620062bbb = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap(hashMap);
        String bqq0071qq0071 = yyqyyy.bqq0071qq0071();
        b006200620062bbb = bqq0071qq0071;
        hashMap2.put(HttpHeaders.ACCEPT_LANGUAGE, bqq0071qq0071);
        b0062b0062bbb = Collections.unmodifiableMap(hashMap2);
    }

    public yqqqyq(String str, String str2, String str3) {
        this.bbbb0062bb = str3;
        this.bb0062b0062bb = str2;
        this.b0062bb0062bb = str;
    }

    public static boolean bi0069i0069ii(@Nullable String str) {
        if (str != null && !str.isEmpty() && b00620062bbbb.matcher(str).find()) {
            return true;
        }
        yyyyqy.bt0074t00740074t(bb0062bbbb, "Invalid org_id");
        return false;
    }

    @Nonnull
    public static Map<String, String> bii00690069ii(@Nullable jkjjkj jkjjkj, String str, int i) {
        HashMap hashMap = new HashMap(b0062b0062bbb);
        if (!yqqyqq.b0069ii0069i0069(str)) {
            str = null;
        }
        if (jkjjkj != null) {
            hashMap.put(HttpHeaders.REFERER, jkjjkj.bss0073sss);
            if (str == null && yqqyqq.b0069ii0069i0069(jkjjkj.b0073s0073sss)) {
                str = jkjjkj.b0073s0073sss;
            }
            hashMap.put(HttpHeaders.COOKIE, "thx_guid=" + jkjjkj.bs0073ssss);
        }
        if (str != null) {
            hashMap.put("User-Agent", str);
        }
        if (i > 0) {
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put(HttpHeaders.CONTENT_ENCODING, "gzip");
            hashMap.put(HttpHeaders.CONTENT_LENGTH, Integer.toString(i));
        }
        return hashMap;
    }

    public static boolean biiii0069i(@Nullable String str) {
        if (str == null) {
            str = TMXConfig.b006Fooo006F006F;
        }
        try {
            new URL("https://" + str);
            return false;
        } catch (MalformedURLException e) {
            String str2 = bb0062bbbb;
            yyyyqy.b00740074t00740074t(str2, "Invalid hostname " + str, e);
            return true;
        }
    }

    @Nonnull
    public String b0069006900690069ii(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(str);
        sb.append("/fp/");
        sb.append(str3);
        if (yqqyqq.b0069ii0069i0069(str2)) {
            sb.append(";CIS3SID=");
            sb.append(str2);
        }
        return sb.toString();
    }

    @Nullable
    public String b00690069i0069ii(@Nonnull String str, @Nullable String str2, @Nullable String str3) {
        String str4;
        String str5;
        StringBuilder sb = new StringBuilder(this.bb0062b0062bb);
        if (yqqyqq.bi0069i0069i0069(str2) || yqqyqq.bi0069i0069i0069(str3)) {
            str4 = bb0062bbbb;
            str5 = "Failed to generate DNS domain: invalid nonce or dnsDomain";
        } else {
            String bi0069ii00690069 = yqqyqq.bi0069ii00690069(str.getBytes());
            int indexOf = str3.indexOf(".");
            int length = this.bb0062b0062bb.length() + (bi0069ii00690069 != null ? bi0069ii00690069.length() : 0) + str2.length();
            if (indexOf < 0) {
                indexOf = str3.length();
            }
            if (length + indexOf >= 64) {
                str4 = bb0062bbbb;
                str5 = "Combined org id, session id, nonce (optional) and postfix is too long for host name fragment";
            } else {
                sb.append(bi0069ii00690069);
                sb.append(str2);
                sb.append(str3);
                String str6 = bb0062bbbb;
                yyyyqy.qyyyqy.bt0074tttt(str6, "FQDN is " + sb.toString());
                return sb.toString();
            }
        }
        yyyyqy.qyyyqy.bt0074tttt(str4, str5);
        return null;
    }

    @Nonnull
    public qttttt b0069i00690069ii(@Nonnull String str) {
        qttttt qttttt = new qttttt();
        qttttt.byyyy00790079("org_id", this.bb0062b0062bb);
        qttttt.byyyy00790079("session_id", str);
        qttttt.byyyy00790079("os", yyqyyy.b007100710071q0071q());
        qttttt.byyyy00790079("osVersion", tqttqq.ttttqq.qqqqtq.b006Enn006En006E);
        qttttt.byyyy00790079("sdk_version", "6.3-80");
        String str2 = this.bbbb0062bb;
        if (str2 != null && !str2.isEmpty()) {
            qttttt.byyyy00790079("api_key", this.bbbb0062bb);
        }
        return qttttt;
    }

    @Nonnull
    public String bi006900690069ii() {
        return "https://" + this.b0062bb0062bb + "/fp/mobile/conf";
    }
}
