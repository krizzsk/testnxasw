package com.didi.onehybrid.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.onehybrid.resource.offline.UrlTrieTree;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FusionMimeTypeMap {

    /* renamed from: a */
    private static final Map<String, String> f32169a = new HashMap();

    static {
        m24460a("png", "image/png");
        m24460a("jpeg", "image/jpeg");
        m24460a(FileUtil.JPG, "image/jpeg");
        m24460a("jfif", "image/jpeg");
        m24460a("gif", "image/gif");
        m24460a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m24460a("js", "application/javascript");
        m24460a("html", "text/html");
        m24460a("htm", "text/html");
        m24460a("mp4", "video/mp4");
        m24460a("woff", "font/woff");
        m24460a("woff2", "font/woff2");
        m24460a("eot", "application/vnd.ms-fontobject");
        m24460a("ttf", "application/font-sfnt");
        m24460a("svg", "image/svg+xml");
        m24460a("webp", "image/webp");
        m24460a("webm", "video/webm");
    }

    public static String getMimeTypeFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String pureUrl = UrlTrieTree.getPureUrl(str);
        int lastIndexOf = pureUrl.lastIndexOf(46);
        if (lastIndexOf > 0) {
            pureUrl = pureUrl.substring(lastIndexOf + 1);
        }
        String lowerCase = pureUrl.toLowerCase(Locale.getDefault());
        if (MimeTypeMap.getSingleton().hasExtension(lowerCase)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        }
        return f32169a.get(lowerCase);
    }

    public static String getContentType(String str) {
        return f32169a.get(str);
    }

    /* renamed from: a */
    private static void m24460a(String str, String str2) {
        f32169a.put(str, str2);
    }
}
