package didihttp;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.common.net.HttpHeaders;
import didihttp.Cookie;
import didihttp.internal.C21750Util;
import didihttp.internal.platform.Platform;
import java.io.IOException;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class JavaNetCookieJar implements CookieJar {

    /* renamed from: a */
    private final CookieHandler f59229a;

    public JavaNetCookieJar(CookieHandler cookieHandler) {
        this.f59229a = cookieHandler;
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        if (this.f59229a != null) {
            ArrayList arrayList = new ArrayList();
            for (Cookie a : list) {
                arrayList.add(a.mo179253a(true));
            }
            try {
                this.f59229a.put(httpUrl.uri(), Collections.singletonMap("Set-Cookie", arrayList));
            } catch (IOException e) {
                Platform platform = Platform.get();
                platform.log(5, "Saving cookies failed for " + httpUrl.resolve("/..."), e);
            }
        }
    }

    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        try {
            ArrayList arrayList = null;
            for (Map.Entry next : this.f59229a.get(httpUrl.uri(), Collections.emptyMap()).entrySet()) {
                String str = (String) next.getKey();
                if ((HttpHeaders.COOKIE.equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) && !((List) next.getValue()).isEmpty()) {
                    for (String str2 : (List) next.getValue()) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.addAll(m44747a(httpUrl, str2));
                    }
                }
            }
            if (arrayList != null) {
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        } catch (IOException e) {
            Platform platform = Platform.get();
            platform.log(5, "Loading cookies failed for " + httpUrl.resolve("/..."), e);
            return Collections.emptyList();
        }
    }

    /* renamed from: a */
    private List<Cookie> m44747a(HttpUrl httpUrl, String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int delimiterOffset = C21750Util.delimiterOffset(str, i, length, ";,");
            int delimiterOffset2 = C21750Util.delimiterOffset(str, i, delimiterOffset, '=');
            String trimSubstring = C21750Util.trimSubstring(str, i, delimiterOffset2);
            if (!trimSubstring.startsWith("$")) {
                String trimSubstring2 = delimiterOffset2 < delimiterOffset ? C21750Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset) : "";
                if (trimSubstring2.startsWith(Const.jsQuote) && trimSubstring2.endsWith(Const.jsQuote)) {
                    trimSubstring2 = trimSubstring2.substring(1, trimSubstring2.length() - 1);
                }
                arrayList.add(new Cookie.Builder().name(trimSubstring).value(trimSubstring2).domain(httpUrl.host()).build());
            }
            i = delimiterOffset + 1;
        }
        return arrayList;
    }
}
