package com.koushikdutta.async.http.cache;

import android.text.TextUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.koushikdutta.async.http.cache.b */
/* compiled from: RawHeaders */
final class C21201b {

    /* renamed from: a */
    private static final Comparator<String> f58193a = new RawHeaders$1();

    /* renamed from: b */
    private final List<String> f58194b = new ArrayList(20);

    /* renamed from: c */
    private String f58195c;

    /* renamed from: d */
    private int f58196d = 1;

    /* renamed from: e */
    private int f58197e = -1;

    /* renamed from: f */
    private String f58198f;

    public C21201b() {
    }

    public C21201b(C21201b bVar) {
        mo173614a(bVar);
    }

    /* renamed from: a */
    public void mo173614a(C21201b bVar) {
        this.f58194b.addAll(bVar.f58194b);
        this.f58195c = bVar.f58195c;
        this.f58196d = bVar.f58196d;
        this.f58197e = bVar.f58197e;
        this.f58198f = bVar.f58198f;
    }

    /* renamed from: a */
    public void mo173615a(String str) {
        String trim = str.trim();
        this.f58195c = trim;
        if (trim != null && trim.startsWith("HTTP/")) {
            String trim2 = trim.trim();
            int indexOf = trim2.indexOf(" ") + 1;
            if (indexOf != 0) {
                if (trim2.charAt(indexOf - 2) != '1') {
                    this.f58196d = 0;
                }
                int i = indexOf + 3;
                if (i > trim2.length()) {
                    i = trim2.length();
                }
                this.f58197e = Integer.parseInt(trim2.substring(indexOf, i));
                int i2 = i + 1;
                if (i2 <= trim2.length()) {
                    this.f58198f = trim2.substring(i2);
                }
            }
        }
    }

    /* renamed from: a */
    public String mo173612a() {
        return this.f58195c;
    }

    /* renamed from: b */
    public int mo173618b() {
        int i = this.f58196d;
        if (i != -1) {
            return i;
        }
        return 1;
    }

    /* renamed from: c */
    public int mo173622c() {
        return this.f58197e;
    }

    /* renamed from: d */
    public String mo173624d() {
        return this.f58198f;
    }

    /* renamed from: b */
    public void mo173620b(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf == -1) {
            mo173616a("", str);
        } else {
            mo173616a(str.substring(0, indexOf), str.substring(indexOf + 1));
        }
    }

    /* renamed from: a */
    public void mo173616a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("fieldName == null");
        } else if (str2 == null) {
            PrintStream printStream = System.err;
            printStream.println("Ignoring HTTP header field '" + str + "' because its value is null");
        } else {
            this.f58194b.add(str);
            this.f58194b.add(str2.trim());
        }
    }

    /* renamed from: c */
    public void mo173623c(String str) {
        for (int i = 0; i < this.f58194b.size(); i += 2) {
            if (str.equalsIgnoreCase(this.f58194b.get(i))) {
                this.f58194b.remove(i);
                this.f58194b.remove(i);
            }
        }
    }

    /* renamed from: a */
    public void mo173617a(String str, List<String> list) {
        for (String a : list) {
            mo173616a(str, a);
        }
    }

    /* renamed from: b */
    public void mo173621b(String str, String str2) {
        mo173623c(str);
        mo173616a(str, str2);
    }

    /* renamed from: e */
    public int mo173626e() {
        return this.f58194b.size() / 2;
    }

    /* renamed from: a */
    public String mo173613a(int i) {
        int i2 = i * 2;
        if (i2 < 0 || i2 >= this.f58194b.size()) {
            return null;
        }
        return this.f58194b.get(i2);
    }

    /* renamed from: b */
    public String mo173619b(int i) {
        int i2 = (i * 2) + 1;
        if (i2 < 0 || i2 >= this.f58194b.size()) {
            return null;
        }
        return this.f58194b.get(i2);
    }

    /* renamed from: d */
    public String mo173625d(String str) {
        for (int size = this.f58194b.size() - 2; size >= 0; size -= 2) {
            if (str.equalsIgnoreCase(this.f58194b.get(size))) {
                return this.f58194b.get(size + 1);
            }
        }
        return null;
    }

    /* renamed from: a */
    public C21201b mo173611a(Set<String> set) {
        C21201b bVar = new C21201b();
        for (int i = 0; i < this.f58194b.size(); i += 2) {
            String str = this.f58194b.get(i);
            if (set.contains(str)) {
                bVar.mo173616a(str, this.f58194b.get(i + 1));
            }
        }
        return bVar;
    }

    /* renamed from: f */
    public String mo173627f() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(this.f58195c);
        sb.append("\r\n");
        for (int i = 0; i < this.f58194b.size(); i += 2) {
            sb.append(this.f58194b.get(i));
            sb.append(": ");
            sb.append(this.f58194b.get(i + 1));
            sb.append("\r\n");
        }
        sb.append("\r\n");
        return sb.toString();
    }

    /* renamed from: g */
    public Map<String, List<String>> mo173628g() {
        TreeMap treeMap = new TreeMap(f58193a);
        for (int i = 0; i < this.f58194b.size(); i += 2) {
            String str = this.f58194b.get(i);
            String str2 = this.f58194b.get(i + 1);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(str2);
            treeMap.put(str, Collections.unmodifiableList(arrayList));
        }
        String str3 = this.f58195c;
        if (str3 != null) {
            treeMap.put((Object) null, Collections.unmodifiableList(Collections.singletonList(str3)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    /* renamed from: a */
    public static C21201b m44078a(Map<String, List<String>> map) {
        C21201b bVar = new C21201b();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            if (str != null) {
                bVar.mo173617a(str, (List<String>) list);
            } else if (!list.isEmpty()) {
                bVar.mo173615a((String) list.get(list.size() - 1));
            }
        }
        return bVar;
    }

    /* renamed from: e */
    public static C21201b m44079e(String str) {
        String[] split = str.split("\n");
        C21201b bVar = new C21201b();
        for (String trim : split) {
            String trim2 = trim.trim();
            if (!TextUtils.isEmpty(trim2)) {
                if (bVar.mo173612a() == null) {
                    bVar.mo173615a(trim2);
                } else {
                    bVar.mo173620b(trim2);
                }
            }
        }
        return bVar;
    }
}
