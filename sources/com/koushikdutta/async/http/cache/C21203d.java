package com.koushikdutta.async.http.cache;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.http.HttpDate;
import com.koushikdutta.async.http.cache.HeaderParser;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/* renamed from: com.koushikdutta.async.http.cache.d */
/* compiled from: ResponseHeaders */
final class C21203d {

    /* renamed from: a */
    private static final String f58217a = "X-Android-Sent-Millis";

    /* renamed from: b */
    private static final String f58218b = "X-Android-Received-Millis";

    /* renamed from: c */
    private final Uri f58219c;

    /* renamed from: d */
    private final C21201b f58220d;

    /* renamed from: e */
    private Date f58221e;

    /* renamed from: f */
    private Date f58222f;

    /* renamed from: g */
    private Date f58223g;

    /* renamed from: h */
    private long f58224h;

    /* renamed from: i */
    private long f58225i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f58226j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f58227k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f58228l = -1;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f58229m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f58230n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f58231o;

    /* renamed from: p */
    private String f58232p;

    /* renamed from: q */
    private int f58233q = -1;

    /* renamed from: r */
    private Set<String> f58234r = Collections.emptySet();

    /* renamed from: s */
    private String f58235s;

    /* renamed from: t */
    private String f58236t;

    /* renamed from: u */
    private long f58237u = -1;

    /* renamed from: v */
    private String f58238v;

    /* renamed from: w */
    private String f58239w;

    /* renamed from: x */
    private String f58240x;

    public C21203d(Uri uri, C21201b bVar) {
        this.f58219c = uri;
        this.f58220d = bVar;
        ResponseHeaders$1 responseHeaders$1 = new ResponseHeaders$1(this);
        for (int i = 0; i < bVar.mo173626e(); i++) {
            String a = bVar.mo173613a(i);
            String b = bVar.mo173619b(i);
            if (HttpHeaders.CACHE_CONTROL.equalsIgnoreCase(a)) {
                HeaderParser.m44071a(b, (HeaderParser.CacheControlHandler) responseHeaders$1);
            } else if (HttpHeaders.DATE.equalsIgnoreCase(a)) {
                this.f58221e = HttpDate.parse(b);
            } else if (HttpHeaders.EXPIRES.equalsIgnoreCase(a)) {
                this.f58223g = HttpDate.parse(b);
            } else if (HttpHeaders.LAST_MODIFIED.equalsIgnoreCase(a)) {
                this.f58222f = HttpDate.parse(b);
            } else if (HttpHeaders.ETAG.equalsIgnoreCase(a)) {
                this.f58232p = b;
            } else if (HttpHeaders.PRAGMA.equalsIgnoreCase(a)) {
                if (b.equalsIgnoreCase("no-cache")) {
                    this.f58226j = true;
                }
            } else if (HttpHeaders.AGE.equalsIgnoreCase(a)) {
                this.f58233q = HeaderParser.m44068a(b);
            } else if (HttpHeaders.VARY.equalsIgnoreCase(a)) {
                if (this.f58234r.isEmpty()) {
                    this.f58234r = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String trim : b.split(",")) {
                    this.f58234r.add(trim.trim().toLowerCase(Locale.US));
                }
            } else if (HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(a)) {
                this.f58235s = b;
            } else if (HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(a)) {
                this.f58236t = b;
            } else if (HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(a)) {
                try {
                    this.f58237u = Long.parseLong(b);
                } catch (NumberFormatException unused) {
                }
            } else if (HttpHeaders.CONNECTION.equalsIgnoreCase(a)) {
                this.f58238v = b;
            } else if (HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(a)) {
                this.f58239w = b;
            } else if (HttpHeaders.WWW_AUTHENTICATE.equalsIgnoreCase(a)) {
                this.f58240x = b;
            } else if (f58217a.equalsIgnoreCase(a)) {
                this.f58224h = Long.parseLong(b);
            } else if (f58218b.equalsIgnoreCase(a)) {
                this.f58225i = Long.parseLong(b);
            }
        }
    }

    /* renamed from: a */
    public boolean mo173662a() {
        return "gzip".equalsIgnoreCase(this.f58235s);
    }

    /* renamed from: b */
    public void mo173667b() {
        this.f58235s = null;
        this.f58220d.mo173623c(HttpHeaders.CONTENT_ENCODING);
    }

    /* renamed from: c */
    public boolean mo173668c() {
        return "chunked".equalsIgnoreCase(this.f58236t);
    }

    /* renamed from: d */
    public boolean mo173669d() {
        return "close".equalsIgnoreCase(this.f58238v);
    }

    /* renamed from: e */
    public Uri mo173670e() {
        return this.f58219c;
    }

    /* renamed from: f */
    public C21201b mo173671f() {
        return this.f58220d;
    }

    /* renamed from: g */
    public Date mo173672g() {
        return this.f58221e;
    }

    /* renamed from: h */
    public Date mo173673h() {
        return this.f58222f;
    }

    /* renamed from: i */
    public Date mo173674i() {
        return this.f58223g;
    }

    /* renamed from: j */
    public boolean mo173675j() {
        return this.f58226j;
    }

    /* renamed from: k */
    public boolean mo173676k() {
        return this.f58227k;
    }

    /* renamed from: l */
    public int mo173677l() {
        return this.f58228l;
    }

    /* renamed from: m */
    public int mo173678m() {
        return this.f58229m;
    }

    /* renamed from: n */
    public boolean mo173679n() {
        return this.f58230n;
    }

    /* renamed from: o */
    public boolean mo173680o() {
        return this.f58231o;
    }

    /* renamed from: p */
    public String mo173681p() {
        return this.f58232p;
    }

    /* renamed from: q */
    public Set<String> mo173682q() {
        return this.f58234r;
    }

    /* renamed from: r */
    public String mo173683r() {
        return this.f58235s;
    }

    /* renamed from: s */
    public long mo173684s() {
        return this.f58237u;
    }

    /* renamed from: t */
    public String mo173685t() {
        return this.f58238v;
    }

    /* renamed from: u */
    public String mo173686u() {
        return this.f58239w;
    }

    /* renamed from: v */
    public String mo173687v() {
        return this.f58240x;
    }

    /* renamed from: a */
    public void mo173661a(long j, long j2) {
        this.f58224h = j;
        this.f58220d.mo173616a(f58217a, Long.toString(j));
        this.f58225i = j2;
        this.f58220d.mo173616a(f58218b, Long.toString(j2));
    }

    /* renamed from: a */
    private long m44135a(long j) {
        Date date = this.f58221e;
        long j2 = 0;
        if (date != null) {
            j2 = Math.max(0, this.f58225i - date.getTime());
        }
        if (this.f58233q != -1) {
            j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.f58233q));
        }
        long j3 = this.f58225i;
        return j2 + (j3 - this.f58224h) + (j - j3);
    }

    /* renamed from: x */
    private long m44142x() {
        if (this.f58228l != -1) {
            return TimeUnit.SECONDS.toMillis((long) this.f58228l);
        }
        if (this.f58223g != null) {
            Date date = this.f58221e;
            long time = this.f58223g.getTime() - (date != null ? date.getTime() : this.f58225i);
            if (time > 0) {
                return time;
            }
            return 0;
        } else if (this.f58222f == null || this.f58219c.getEncodedQuery() != null) {
            return 0;
        } else {
            Date date2 = this.f58221e;
            long time2 = (date2 != null ? date2.getTime() : this.f58224h) - this.f58222f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0;
        }
    }

    /* renamed from: y */
    private boolean m44143y() {
        return this.f58228l == -1 && this.f58223g == null;
    }

    /* renamed from: a */
    public boolean mo173663a(C21202c cVar) {
        int c = this.f58220d.mo173622c();
        if (c != 200 && c != 203 && c != 300 && c != 301 && c != 410) {
            return false;
        }
        if ((!cVar.mo173647j() || this.f58230n || this.f58231o || this.f58229m != -1) && !this.f58227k) {
            return true;
        }
        return false;
    }

    /* renamed from: w */
    public boolean mo173688w() {
        return this.f58234r.contains("*");
    }

    /* renamed from: a */
    public boolean mo173665a(Map<String, List<String>> map, Map<String, List<String>> map2) {
        for (String next : this.f58234r) {
            if (!C21200a.m44077a(map.get(next), map2.get(next))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public ResponseSource mo173660a(long j, C21202c cVar) {
        if (!mo173663a(cVar)) {
            return ResponseSource.NETWORK;
        }
        if (cVar.mo173641e() || cVar.mo173659v()) {
            return ResponseSource.NETWORK;
        }
        long a = m44135a(j);
        long x = m44142x();
        if (cVar.mo173642f() != -1) {
            x = Math.min(x, TimeUnit.SECONDS.toMillis((long) cVar.mo173642f()));
        }
        long j2 = 0;
        long millis = cVar.mo173645h() != -1 ? TimeUnit.SECONDS.toMillis((long) cVar.mo173645h()) : 0;
        if (!this.f58231o && cVar.mo173644g() != -1) {
            j2 = TimeUnit.SECONDS.toMillis((long) cVar.mo173644g());
        }
        if (!this.f58226j) {
            long j3 = millis + a;
            if (j3 < j2 + x) {
                if (j3 >= x) {
                    this.f58220d.mo173616a(HttpHeaders.WARNING, "110 HttpURLConnection \"Response is stale\"");
                }
                if (a > 86400000 && m44143y()) {
                    this.f58220d.mo173616a(HttpHeaders.WARNING, "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return ResponseSource.CACHE;
            }
        }
        String str = this.f58232p;
        if (str != null) {
            cVar.mo173643f(str);
        } else {
            Date date = this.f58222f;
            if (date != null) {
                cVar.mo173631a(date);
            } else {
                Date date2 = this.f58221e;
                if (date2 != null) {
                    cVar.mo173631a(date2);
                }
            }
        }
        return cVar.mo173659v() ? ResponseSource.CONDITIONAL_CACHE : ResponseSource.NETWORK;
    }

    /* renamed from: a */
    public boolean mo173664a(C21203d dVar) {
        Date date;
        if (dVar.f58220d.mo173622c() == 304) {
            return true;
        }
        if (this.f58222f == null || (date = dVar.f58222f) == null || date.getTime() >= this.f58222f.getTime()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public C21203d mo173666b(C21203d dVar) {
        C21201b bVar = new C21201b();
        for (int i = 0; i < this.f58220d.mo173626e(); i++) {
            String a = this.f58220d.mo173613a(i);
            String b = this.f58220d.mo173619b(i);
            if ((!a.equals(HttpHeaders.WARNING) || !b.startsWith("1")) && (!m44137a(a) || dVar.f58220d.mo173625d(a) == null)) {
                bVar.mo173616a(a, b);
            }
        }
        for (int i2 = 0; i2 < dVar.f58220d.mo173626e(); i2++) {
            String a2 = dVar.f58220d.mo173613a(i2);
            if (m44137a(a2)) {
                bVar.mo173616a(a2, dVar.f58220d.mo173619b(i2));
            }
        }
        return new C21203d(this.f58219c, bVar);
    }

    /* renamed from: a */
    private static boolean m44137a(String str) {
        return !str.equalsIgnoreCase(HttpHeaders.CONNECTION) && !str.equalsIgnoreCase("Keep-Alive") && !str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHENTICATE) && !str.equalsIgnoreCase(HttpHeaders.PROXY_AUTHORIZATION) && !str.equalsIgnoreCase(HttpHeaders.f55222TE) && !str.equalsIgnoreCase("Trailers") && !str.equalsIgnoreCase(HttpHeaders.TRANSFER_ENCODING) && !str.equalsIgnoreCase(HttpHeaders.UPGRADE);
    }
}
