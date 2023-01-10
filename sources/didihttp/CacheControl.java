package didihttp;

import java.util.concurrent.TimeUnit;

public final class CacheControl {
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();

    /* renamed from: a */
    String f59098a;

    /* renamed from: b */
    private final boolean f59099b;

    /* renamed from: c */
    private final boolean f59100c;

    /* renamed from: d */
    private final int f59101d;

    /* renamed from: e */
    private final int f59102e;

    /* renamed from: f */
    private final boolean f59103f;

    /* renamed from: g */
    private final boolean f59104g;

    /* renamed from: h */
    private final boolean f59105h;

    /* renamed from: i */
    private final int f59106i;

    /* renamed from: j */
    private final int f59107j;

    /* renamed from: k */
    private final boolean f59108k;

    /* renamed from: l */
    private final boolean f59109l;

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.f59099b = z;
        this.f59100c = z2;
        this.f59101d = i;
        this.f59102e = i2;
        this.f59103f = z3;
        this.f59104g = z4;
        this.f59105h = z5;
        this.f59106i = i3;
        this.f59107j = i4;
        this.f59108k = z6;
        this.f59109l = z7;
        this.f59098a = str;
    }

    CacheControl(Builder builder) {
        this.f59099b = builder.noCache;
        this.f59100c = builder.noStore;
        this.f59101d = builder.maxAgeSeconds;
        this.f59102e = -1;
        this.f59103f = false;
        this.f59104g = false;
        this.f59105h = false;
        this.f59106i = builder.maxStaleSeconds;
        this.f59107j = builder.minFreshSeconds;
        this.f59108k = builder.onlyIfCached;
        this.f59109l = builder.noTransform;
    }

    public boolean noCache() {
        return this.f59099b;
    }

    public boolean noStore() {
        return this.f59100c;
    }

    public int maxAgeSeconds() {
        return this.f59101d;
    }

    public int sMaxAgeSeconds() {
        return this.f59102e;
    }

    public boolean isPrivate() {
        return this.f59103f;
    }

    public boolean isPublic() {
        return this.f59104g;
    }

    public boolean mustRevalidate() {
        return this.f59105h;
    }

    public int maxStaleSeconds() {
        return this.f59106i;
    }

    public int minFreshSeconds() {
        return this.f59107j;
    }

    public boolean onlyIfCached() {
        return this.f59108k;
    }

    public boolean noTransform() {
        return this.f59109l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static didihttp.CacheControl parse(didihttp.Headers r21) {
        /*
            r0 = r21
            int r1 = r21.size()
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
        L_0x0018:
            if (r6 >= r1) goto L_0x0131
            java.lang.String r2 = r0.name(r6)
            java.lang.String r4 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = r2.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x002f
            if (r8 == 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            r8 = r4
            goto L_0x0038
        L_0x002f:
            java.lang.String r3 = "Pragma"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x012a
        L_0x0037:
            r7 = 0
        L_0x0038:
            r2 = 0
        L_0x0039:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x012a
            java.lang.String r3 = "=,;"
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r2, r3)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r2 = r2.trim()
            int r5 = r4.length()
            if (r3 == r5) goto L_0x0097
            char r5 = r4.charAt(r3)
            r0 = 44
            if (r5 == r0) goto L_0x0097
            char r0 = r4.charAt(r3)
            r5 = 59
            if (r0 != r5) goto L_0x0064
            goto L_0x0097
        L_0x0064:
            int r3 = r3 + 1
            int r0 = didihttp.internal.http.HttpHeaders.skipWhitespace(r4, r3)
            int r3 = r4.length()
            if (r0 >= r3) goto L_0x0087
            char r3 = r4.charAt(r0)
            r5 = 34
            if (r3 != r5) goto L_0x0087
            int r0 = r0 + 1
            java.lang.String r3 = "\""
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            r5 = 1
            int r3 = r3 + r5
            goto L_0x009b
        L_0x0087:
            r5 = 1
            java.lang.String r3 = ",;"
            int r3 = didihttp.internal.http.HttpHeaders.skipUntil(r4, r0, r3)
            java.lang.String r0 = r4.substring(r0, r3)
            java.lang.String r0 = r0.trim()
            goto L_0x009b
        L_0x0097:
            r5 = 1
            int r3 = r3 + 1
            r0 = 0
        L_0x009b:
            java.lang.String r5 = "no-cache"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00a7
            r5 = -1
            r9 = 1
            goto L_0x0125
        L_0x00a7:
            java.lang.String r5 = "no-store"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b3
            r5 = -1
            r10 = 1
            goto L_0x0125
        L_0x00b3:
            java.lang.String r5 = "max-age"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00c1
            r5 = -1
            int r11 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x00c1:
            java.lang.String r5 = "s-maxage"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00cf
            r5 = -1
            int r12 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x00cf:
            java.lang.String r5 = "private"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00da
            r5 = -1
            r13 = 1
            goto L_0x0125
        L_0x00da:
            java.lang.String r5 = "public"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00e5
            r5 = -1
            r14 = 1
            goto L_0x0125
        L_0x00e5:
            java.lang.String r5 = "must-revalidate"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00f0
            r5 = -1
            r15 = 1
            goto L_0x0125
        L_0x00f0:
            java.lang.String r5 = "max-stale"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x0101
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r2)
            r5 = -1
            goto L_0x0125
        L_0x0101:
            java.lang.String r5 = "min-fresh"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x010f
            r5 = -1
            int r17 = didihttp.internal.http.HttpHeaders.parseSeconds(r0, r5)
            goto L_0x0125
        L_0x010f:
            r5 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x011b
            r18 = 1
            goto L_0x0125
        L_0x011b:
            java.lang.String r0 = "no-transform"
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x0125
            r19 = 1
        L_0x0125:
            r0 = r21
            r2 = r3
            goto L_0x0039
        L_0x012a:
            r5 = -1
            int r6 = r6 + 1
            r0 = r21
            goto L_0x0018
        L_0x0131:
            if (r7 != 0) goto L_0x0136
            r20 = 0
            goto L_0x0138
        L_0x0136:
            r20 = r8
        L_0x0138:
            didihttp.CacheControl r0 = new didihttp.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.CacheControl.parse(didihttp.Headers):didihttp.CacheControl");
    }

    public String toString() {
        String str = this.f59098a;
        if (str != null) {
            return str;
        }
        String a = m44679a();
        this.f59098a = a;
        return a;
    }

    /* renamed from: a */
    private String m44679a() {
        StringBuilder sb = new StringBuilder();
        if (this.f59099b) {
            sb.append("no-cache, ");
        }
        if (this.f59100c) {
            sb.append("no-store, ");
        }
        if (this.f59101d != -1) {
            sb.append("max-age=");
            sb.append(this.f59101d);
            sb.append(", ");
        }
        if (this.f59102e != -1) {
            sb.append("s-maxage=");
            sb.append(this.f59102e);
            sb.append(", ");
        }
        if (this.f59103f) {
            sb.append("private, ");
        }
        if (this.f59104g) {
            sb.append("public, ");
        }
        if (this.f59105h) {
            sb.append("must-revalidate, ");
        }
        if (this.f59106i != -1) {
            sb.append("max-stale=");
            sb.append(this.f59106i);
            sb.append(", ");
        }
        if (this.f59107j != -1) {
            sb.append("min-fresh=");
            sb.append(this.f59107j);
            sb.append(", ");
        }
        if (this.f59108k) {
            sb.append("only-if-cached, ");
        }
        if (this.f59109l) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static final class Builder {
        int maxAgeSeconds = -1;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean noCache;
        boolean noStore;
        boolean noTransform;
        boolean onlyIfCached;

        public Builder noCache() {
            this.noCache = true;
            return this;
        }

        public Builder noStore() {
            this.noStore = true;
            return this;
        }

        public Builder maxAge(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.maxAgeSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i);
        }

        public Builder maxStale(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.maxStaleSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        public Builder minFresh(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds((long) i);
                this.minFreshSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i);
        }

        public Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        public Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        public CacheControl build() {
            return new CacheControl(this);
        }
    }
}
