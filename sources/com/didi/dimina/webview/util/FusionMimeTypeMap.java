package com.didi.dimina.webview.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

public class FusionMimeTypeMap {

    /* renamed from: a */
    private static final Map<String, String> f20270a = new HashMap();

    static {
        m17091a("png", "image/png");
        m17091a("jpeg", "image/jpeg");
        m17091a(FileUtil.JPG, "image/jpeg");
        m17091a("jfif", "image/jpeg");
        m17091a("gif", "image/gif");
        m17091a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m17091a("js", "application/javascript");
        m17091a("html", "text/html");
        m17091a("htm", "text/html");
        m17091a("mp4", "video/mp4");
        m17091a("woff", "font/woff");
        m17091a("woff2", "font/woff2");
        m17091a("eot", "application/vnd.ms-fontobject");
        m17091a("ttf", "application/font-sfnt");
        m17091a("svg", "image/svg+xml");
        m17091a("webp", "image/webp");
        m17091a("webm", "video/webm");
    }

    public static String getMimeTypeFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (MimeTypeMap.getSingleton().hasExtension(fileExtensionFromUrl)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return f20270a.get(fileExtensionFromUrl);
    }

    public static String getContentType(String str) {
        return f20270a.get(str);
    }

    /* renamed from: a */
    private static void m17091a(String str, String str2) {
        f20270a.put(str, str2);
    }
}
