package com.didi.dimina.container.secondparty.http;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.secondparty.http.b */
/* compiled from: MimeTypeMap */
class C8139b {

    /* renamed from: a */
    private static final Map<String, String> f19007a = new HashMap();

    C8139b() {
    }

    static {
        m16130a("png", "image/png");
        m16130a("jpeg", "image/jpeg");
        m16130a(FileUtil.JPG, "image/jpeg");
        m16130a("jfif", "image/jpeg");
        m16130a("gif", "image/gif");
        m16130a(Constants.JSON_KEY_CUR_CPU_STAT, "text/css");
        m16130a("js", "application/javascript");
        m16130a("html", "text/html");
        m16130a("htm", "text/html");
        m16130a("svg", "image/svg+xml");
        m16130a("webp", "image/webp");
        m16130a("webm", "video/webm");
    }

    /* renamed from: a */
    static String m16129a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (MimeTypeMap.getSingleton().hasExtension(fileExtensionFromUrl)) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return f19007a.get(fileExtensionFromUrl);
    }

    /* renamed from: b */
    static String m16131b(String str) {
        return f19007a.get(str);
    }

    /* renamed from: a */
    private static void m16130a(String str, String str2) {
        f19007a.put(str, str2);
    }
}
