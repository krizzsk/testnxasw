package com.didichuxing.security.challenge.cookie;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class ClgCookie {

    /* renamed from: a */
    static final Map<String, CookieAttributeAssignor> f51526a;

    /* renamed from: b */
    private static final Set<String> f51527b;

    /* renamed from: o */
    private static final long f51528o = -1;

    /* renamed from: p */
    private static final String f51529p = "set-cookie:";

    /* renamed from: q */
    private static final String f51530q = "set-cookie2:";

    /* renamed from: r */
    private static final String f51531r = ",;= \t";

    /* renamed from: c */
    private String f51532c;

    /* renamed from: d */
    private String f51533d;

    /* renamed from: e */
    private String f51534e;

    /* renamed from: f */
    private boolean f51535f = false;

    /* renamed from: g */
    private String f51536g;

    /* renamed from: h */
    private long f51537h = -1;

    /* renamed from: i */
    private String f51538i;

    /* renamed from: j */
    private String f51539j = null;

    /* renamed from: k */
    private boolean f51540k = false;

    /* renamed from: l */
    private boolean f51541l;

    /* renamed from: m */
    private int f51542m = 1;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final long f51543n = System.currentTimeMillis();

    interface CookieAttributeAssignor {
        void assign(ClgCookie clgCookie, String str, String str2);
    }

    public static ClgCookie parse(String str) {
        List<ClgCookie> a = m38630a(str);
        if (a == null || a.isEmpty()) {
            return null;
        }
        return a.get(0);
    }

    static {
        HashSet hashSet = new HashSet();
        f51527b = hashSet;
        hashSet.add("secch_sessionid");
        f51527b.add("comment");
        f51527b.add("commenturl");
        f51527b.add("discard");
        f51527b.add("domain");
        f51527b.add("expires");
        f51527b.add("httponly");
        f51527b.add("max-age");
        f51527b.add("path");
        f51527b.add("port");
        f51527b.add("secure");
        f51527b.add("version");
        HashMap hashMap = new HashMap();
        f51526a = hashMap;
        hashMap.put("secch_sessionid", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getSecchSessionid() == null) {
                    clgCookie.setSecchSessionid(str2);
                }
            }
        });
        f51526a.put("comment", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getComment() == null) {
                    clgCookie.setComment(str2);
                }
            }
        });
        f51526a.put("commenturl", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getCommentURL() == null) {
                    clgCookie.setCommentURL(str2);
                }
            }
        });
        f51526a.put("discard", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                clgCookie.setDiscard(true);
            }
        });
        f51526a.put("domain", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getDomain() == null) {
                    clgCookie.setDomain(str2);
                }
            }
        });
        f51526a.put("max-age", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                try {
                    long parseLong = Long.parseLong(str2);
                    if (clgCookie.getMaxAge() == -1) {
                        clgCookie.setMaxAge(parseLong);
                    }
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Illegal cookie max-age attribute");
                }
            }
        });
        f51526a.put("path", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getPath() == null) {
                    clgCookie.setPath(str2);
                }
            }
        });
        f51526a.put("port", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getPortlist() == null) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    clgCookie.setPortlist(str2);
                }
            }
        });
        f51526a.put("secure", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                clgCookie.setSecure(true);
            }
        });
        f51526a.put("httponly", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                clgCookie.setHttpOnly(true);
            }
        });
        f51526a.put("version", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                try {
                    clgCookie.setVersion(Integer.parseInt(str2));
                } catch (NumberFormatException unused) {
                }
            }
        });
        f51526a.put("expires", new CookieAttributeAssignor() {
            public void assign(ClgCookie clgCookie, String str, String str2) {
                if (clgCookie.getMaxAge() == -1) {
                    Date parse = ClgHttpDate.parse(str2);
                    long j = 0;
                    if (parse != null) {
                        long time = (parse.getTime() - clgCookie.f51543n) / 1000;
                        if (time != -1) {
                            j = time;
                        }
                    }
                    clgCookie.setMaxAge(j);
                }
            }
        });
    }

    private ClgCookie() {
    }

    /* renamed from: a */
    private static List<ClgCookie> m38630a(String str) {
        int d = m38637d(str);
        if (m38635b(str, f51530q)) {
            str = str.substring(12);
        } else if (m38635b(str, f51529p)) {
            str = str.substring(11);
        }
        ArrayList arrayList = new ArrayList();
        if (d == 0) {
            ClgCookie c = m38636c(str);
            c.setVersion(0);
            arrayList.add(c);
        } else {
            for (String c2 : m38639f(str)) {
                ClgCookie c3 = m38636c(c2);
                c3.setVersion(1);
                arrayList.add(c3);
            }
        }
        return arrayList;
    }

    public boolean hasExpired() {
        long j = this.f51537h;
        if (j == 0) {
            return true;
        }
        return j != -1 && (System.currentTimeMillis() - this.f51543n) / 1000 > this.f51537h;
    }

    public void setSecchSessionid(String str) {
        this.f51532c = str;
    }

    public String getSecchSessionid() {
        return this.f51532c;
    }

    public void setComment(String str) {
        this.f51533d = str;
    }

    public String getComment() {
        return this.f51533d;
    }

    public void setCommentURL(String str) {
        this.f51534e = str;
    }

    public String getCommentURL() {
        return this.f51534e;
    }

    public void setDiscard(boolean z) {
        this.f51535f = z;
    }

    public boolean getDiscard() {
        return this.f51535f;
    }

    public void setPortlist(String str) {
        this.f51539j = str;
    }

    public String getPortlist() {
        return this.f51539j;
    }

    public void setDomain(String str) {
        if (str != null) {
            this.f51536g = str.toLowerCase();
        } else {
            this.f51536g = str;
        }
    }

    public String getDomain() {
        return this.f51536g;
    }

    public void setMaxAge(long j) {
        this.f51537h = j;
    }

    public long getMaxAge() {
        return this.f51537h;
    }

    public void setPath(String str) {
        this.f51538i = str;
    }

    public String getPath() {
        return this.f51538i;
    }

    public void setSecure(boolean z) {
        this.f51540k = z;
    }

    public boolean getSecure() {
        return this.f51540k;
    }

    public int getVersion() {
        return this.f51542m;
    }

    public void setVersion(int i) {
        if (i == 0 || i == 1) {
            this.f51542m = i;
            return;
        }
        throw new IllegalArgumentException("cookie version should be 0 or 1");
    }

    public boolean isHttpOnly() {
        return this.f51541l;
    }

    public void setHttpOnly(boolean z) {
        this.f51541l = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r8.equalsIgnoreCase(r9 + ".local") != false) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean domainMatches(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0089
            if (r9 != 0) goto L_0x0007
            goto L_0x0089
        L_0x0007:
            java.lang.String r1 = ".local"
            boolean r2 = r1.equalsIgnoreCase(r8)
            r3 = 46
            int r4 = r8.indexOf(r3)
            r5 = 1
            if (r4 != 0) goto L_0x001a
            int r4 = r8.indexOf(r3, r5)
        L_0x001a:
            r6 = -1
            if (r2 != 0) goto L_0x0027
            if (r4 == r6) goto L_0x0026
            int r7 = r8.length()
            int r7 = r7 - r5
            if (r4 != r7) goto L_0x0027
        L_0x0026:
            return r0
        L_0x0027:
            int r4 = r9.indexOf(r3)
            if (r4 != r6) goto L_0x0045
            if (r2 != 0) goto L_0x0044
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r9)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            boolean r1 = r8.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0045
        L_0x0044:
            return r5
        L_0x0045:
            int r1 = r8.length()
            int r4 = r9.length()
            int r4 = r4 - r1
            if (r4 != 0) goto L_0x0055
            boolean r8 = r9.equalsIgnoreCase(r8)
            return r8
        L_0x0055:
            if (r4 <= 0) goto L_0x0076
            r9.substring(r0, r4)
            java.lang.String r9 = r9.substring(r4)
            boolean r9 = r9.equalsIgnoreCase(r8)
            if (r9 == 0) goto L_0x0075
            java.lang.String r9 = "."
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L_0x0072
            boolean r8 = m38632a((java.lang.String) r8, (int) r5)
            if (r8 != 0) goto L_0x0074
        L_0x0072:
            if (r2 == 0) goto L_0x0075
        L_0x0074:
            r0 = 1
        L_0x0075:
            return r0
        L_0x0076:
            if (r4 != r6) goto L_0x0089
            char r1 = r8.charAt(r0)
            if (r1 != r3) goto L_0x0089
            java.lang.String r8 = r8.substring(r5)
            boolean r8 = r9.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0089
            r0 = 1
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.security.challenge.cookie.ClgCookie.domainMatches(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static boolean m38632a(String str, int i) {
        int indexOf = str.indexOf(46, i + 1);
        if (indexOf == -1 || indexOf >= str.length() - 1) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClgCookie)) {
            return false;
        }
        ClgCookie clgCookie = (ClgCookie) obj;
        if (!m38633a(getDomain(), clgCookie.getDomain()) || !Objects.equals(getPath(), clgCookie.getPath())) {
            return false;
        }
        return true;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /* renamed from: b */
    private static boolean m38634b(String str) {
        if (f51527b.contains(str.toLowerCase(Locale.US))) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < ' ' || charAt >= 127 || f51531r.indexOf(charAt) != -1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    private static ClgCookie m38636c(String str) {
        String str2;
        String str3;
        ClgCookie clgCookie = new ClgCookie();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf != -1) {
                str3 = nextToken.substring(0, indexOf).trim();
                str2 = nextToken.substring(indexOf + 1).trim();
            } else {
                str3 = nextToken.trim();
                str2 = null;
            }
            m38631a(clgCookie, str3, str2);
        }
        return clgCookie;
    }

    /* renamed from: a */
    private static void m38631a(ClgCookie clgCookie, String str, String str2) {
        String e = m38638e(str2);
        CookieAttributeAssignor cookieAttributeAssignor = f51526a.get(str.toLowerCase());
        if (cookieAttributeAssignor != null) {
            cookieAttributeAssignor.assign(clgCookie, str, e);
        }
    }

    /* renamed from: d */
    private static int m38637d(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("expires=") != -1) {
            return 0;
        }
        if (lowerCase.indexOf("version=") == -1 && lowerCase.indexOf("max-age") == -1 && !m38635b(lowerCase, f51530q)) {
            return 0;
        }
        return 1;
    }

    /* renamed from: e */
    private static String m38638e(String str) {
        if (str == null || str.length() <= 2 || str.charAt(0) != '\"' || str.charAt(str.length() - 1) != '\"') {
            return (str == null || str.length() <= 2 || str.charAt(0) != '\'' || str.charAt(str.length() - 1) != '\'') ? str : str.substring(1, str.length() - 1);
        }
        return str.substring(1, str.length() - 1);
    }

    /* renamed from: a */
    private static boolean m38633a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    /* renamed from: b */
    private static boolean m38635b(String str, String str2) {
        if (str == null || str2 == null || str.length() < str2.length() || !str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    private static List<String> m38639f(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '\"') {
                i2++;
            }
            if (charAt == ',' && i2 % 2 == 0) {
                arrayList.add(str.substring(i, i3));
                i = i3 + 1;
            }
        }
        arrayList.add(str.substring(i));
        return arrayList;
    }
}
