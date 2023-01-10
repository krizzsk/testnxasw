package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Date;
import java.util.List;
import java.util.Map;

/* renamed from: com.koushikdutta.async.http.cache.c */
/* compiled from: RequestHeaders */
final class C21202c {

    /* renamed from: a */
    private final Uri f58199a;

    /* renamed from: b */
    private final C21201b f58200b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f58201c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f58202d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f58203e = -1;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f58204f = -1;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f58205g;

    /* renamed from: h */
    private boolean f58206h;

    /* renamed from: i */
    private int f58207i = -1;

    /* renamed from: j */
    private String f58208j;

    /* renamed from: k */
    private String f58209k;

    /* renamed from: l */
    private String f58210l;

    /* renamed from: m */
    private String f58211m;

    /* renamed from: n */
    private String f58212n;

    /* renamed from: o */
    private String f58213o;

    /* renamed from: p */
    private String f58214p;

    /* renamed from: q */
    private String f58215q;

    /* renamed from: r */
    private String f58216r;

    public C21202c(Uri uri, C21201b bVar) {
        this.f58199a = uri;
        this.f58200b = bVar;
        RequestHeaders$1 requestHeaders$1 = new RequestHeaders$1(this);
        for (int i = 0; i < bVar.mo173626e(); i++) {
            String a = bVar.mo173613a(i);
            String b = bVar.mo173619b(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(a)) {
                HeaderParser.m44071a(b, (HeaderParser.CacheControlHandler) requestHeaders$1);
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.f58201c = true;
                }
            } else if (HttpHeaders.IF_NONE_MATCH.equalsIgnoreCase(a)) {
                this.f58215q = b;
            } else if (HttpHeaders.IF_MODIFIED_SINCE.equalsIgnoreCase(a)) {
                this.f58214p = b;
            } else if (HttpHeaders.AUTHORIZATION.equalsIgnoreCase(a)) {
                this.f58206h = true;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a)) {
                try {
                    this.f58207i = Integer.parseInt(b);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(a)) {
                this.f58208j = b;
            } else if ("User-Agent".equalsIgnoreCase(a)) {
                this.f58209k = b;
            } else if (HttpHeaders.HOST.equalsIgnoreCase(a)) {
                this.f58210l = b;
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(a)) {
                this.f58211m = b;
            } else if (HttpHeaders.ACCEPT_ENCODING.equalsIgnoreCase(a)) {
                this.f58212n = b;
            } else if ("Content-Type".equalsIgnoreCase(a)) {
                this.f58213o = b;
            } else if (HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(a)) {
                this.f58216r = b;
            }
        }
    }

    /* renamed from: a */
    public boolean mo173633a() {
        return "chunked".equalsIgnoreCase(this.f58208j);
    }

    /* renamed from: b */
    public boolean mo173635b() {
        return "close".equalsIgnoreCase(this.f58211m);
    }

    /* renamed from: c */
    public Uri mo173636c() {
        return this.f58199a;
    }

    /* renamed from: d */
    public C21201b mo173638d() {
        return this.f58200b;
    }

    /* renamed from: e */
    public boolean mo173641e() {
        return this.f58201c;
    }

    /* renamed from: f */
    public int mo173642f() {
        return this.f58202d;
    }

    /* renamed from: g */
    public int mo173644g() {
        return this.f58203e;
    }

    /* renamed from: h */
    public int mo173645h() {
        return this.f58204f;
    }

    /* renamed from: i */
    public boolean mo173646i() {
        return this.f58205g;
    }

    /* renamed from: j */
    public boolean mo173647j() {
        return this.f58206h;
    }

    /* renamed from: k */
    public int mo173648k() {
        return this.f58207i;
    }

    /* renamed from: l */
    public String mo173649l() {
        return this.f58208j;
    }

    /* renamed from: m */
    public String mo173650m() {
        return this.f58209k;
    }

    /* renamed from: n */
    public String mo173651n() {
        return this.f58210l;
    }

    /* renamed from: o */
    public String mo173652o() {
        return this.f58211m;
    }

    /* renamed from: p */
    public String mo173653p() {
        return this.f58212n;
    }

    /* renamed from: q */
    public String mo173654q() {
        return this.f58213o;
    }

    /* renamed from: r */
    public String mo173655r() {
        return this.f58214p;
    }

    /* renamed from: s */
    public String mo173656s() {
        return this.f58215q;
    }

    /* renamed from: t */
    public String mo173657t() {
        return this.f58216r;
    }

    /* renamed from: u */
    public void mo173658u() {
        if (this.f58208j != null) {
            this.f58200b.mo173623c(HttpHeaders.TRANSFER_ENCODING);
        }
        this.f58200b.mo173616a(HttpHeaders.TRANSFER_ENCODING, "chunked");
        this.f58208j = "chunked";
    }

    /* renamed from: a */
    public void mo173629a(int i) {
        if (this.f58207i != -1) {
            this.f58200b.mo173623c(HttpHeaders.CONTENT_LENGTH);
        }
        if (i != -1) {
            this.f58200b.mo173616a(HttpHeaders.CONTENT_LENGTH, Integer.toString(i));
        }
        this.f58207i = i;
    }

    /* renamed from: a */
    public void mo173630a(String str) {
        if (this.f58209k != null) {
            this.f58200b.mo173623c("User-Agent");
        }
        this.f58200b.mo173616a("User-Agent", str);
        this.f58209k = str;
    }

    /* renamed from: b */
    public void mo173634b(String str) {
        if (this.f58210l != null) {
            this.f58200b.mo173623c(HttpHeaders.HOST);
        }
        this.f58200b.mo173616a(HttpHeaders.HOST, str);
        this.f58210l = str;
    }

    /* renamed from: c */
    public void mo173637c(String str) {
        if (this.f58211m != null) {
            this.f58200b.mo173623c(HttpHeaders.CONNECTION);
        }
        this.f58200b.mo173616a(HttpHeaders.CONNECTION, str);
        this.f58211m = str;
    }

    /* renamed from: d */
    public void mo173639d(String str) {
        if (this.f58212n != null) {
            this.f58200b.mo173623c(HttpHeaders.ACCEPT_ENCODING);
        }
        this.f58200b.mo173616a(HttpHeaders.ACCEPT_ENCODING, str);
        this.f58212n = str;
    }

    /* renamed from: e */
    public void mo173640e(String str) {
        if (this.f58213o != null) {
            this.f58200b.mo173623c("Content-Type");
        }
        this.f58200b.mo173616a("Content-Type", str);
        this.f58213o = str;
    }

    /* renamed from: a */
    public void mo173631a(Date date) {
        if (this.f58214p != null) {
            this.f58200b.mo173623c(HttpHeaders.IF_MODIFIED_SINCE);
        }
        String format = HttpDate.format(date);
        this.f58200b.mo173616a(HttpHeaders.IF_MODIFIED_SINCE, format);
        this.f58214p = format;
    }

    /* renamed from: f */
    public void mo173643f(String str) {
        if (this.f58215q != null) {
            this.f58200b.mo173623c(HttpHeaders.IF_NONE_MATCH);
        }
        this.f58200b.mo173616a(HttpHeaders.IF_NONE_MATCH, str);
        this.f58215q = str;
    }

    /* renamed from: v */
    public boolean mo173659v() {
        return (this.f58214p == null && this.f58215q == null) ? false : true;
    }

    /* renamed from: a */
    public void mo173632a(Map<String, List<String>> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            if (HttpHeaders.COOKIE.equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                this.f58200b.mo173617a(str, (List<String>) (List) next.getValue());
            }
        }
    }
}
