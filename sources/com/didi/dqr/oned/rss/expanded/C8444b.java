package com.didi.dqr.oned.rss.expanded;

import com.didi.dqr.oned.rss.DataCharacter;
import com.didi.dqr.oned.rss.FinderPattern;

/* renamed from: com.didi.dqr.oned.rss.expanded.b */
/* compiled from: ExpandedPair */
final class C8444b {

    /* renamed from: a */
    private final boolean f20690a;

    /* renamed from: b */
    private final DataCharacter f20691b;

    /* renamed from: c */
    private final DataCharacter f20692c;

    /* renamed from: d */
    private final FinderPattern f20693d;

    C8444b(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.f20691b = dataCharacter;
        this.f20692c = dataCharacter2;
        this.f20693d = finderPattern;
        this.f20690a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo63354a() {
        return this.f20690a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public DataCharacter mo63355b() {
        return this.f20691b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public DataCharacter mo63356c() {
        return this.f20692c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public FinderPattern mo63357d() {
        return this.f20693d;
    }

    /* renamed from: e */
    public boolean mo63358e() {
        return this.f20692c == null;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(this.f20691b);
        sb.append(" , ");
        sb.append(this.f20692c);
        sb.append(" : ");
        FinderPattern finderPattern = this.f20693d;
        if (finderPattern == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(finderPattern.getValue());
        }
        sb.append(obj);
        sb.append(" ]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C8444b)) {
            return false;
        }
        C8444b bVar = (C8444b) obj;
        if (!m17401a(this.f20691b, bVar.f20691b) || !m17401a(this.f20692c, bVar.f20692c) || !m17401a(this.f20693d, bVar.f20693d)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m17401a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        return (m17400a(this.f20691b) ^ m17400a(this.f20692c)) ^ m17400a(this.f20693d);
    }

    /* renamed from: a */
    private static int m17400a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
