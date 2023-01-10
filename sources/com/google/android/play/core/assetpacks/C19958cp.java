package com.google.android.play.core.assetpacks;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.internal.C20098i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.android.play.core.assetpacks.cp */
final class C19958cp {

    /* renamed from: a */
    private static final C20030ag f55874a = new C20030ag("ExtractorSessionStoreView");

    /* renamed from: b */
    private final C19917bb f55875b;

    /* renamed from: c */
    private final C20088ck<C20013w> f55876c;

    /* renamed from: d */
    private final C19941bz f55877d;

    /* renamed from: e */
    private final C20088ck<Executor> f55878e;

    /* renamed from: f */
    private final Map<Integer, C19955cm> f55879f = new HashMap();

    /* renamed from: g */
    private final ReentrantLock f55880g = new ReentrantLock();

    C19958cp(C19917bb bbVar, C20088ck<C20013w> ckVar, C19941bz bzVar, C20088ck<Executor> ckVar2) {
        this.f55875b = bbVar;
        this.f55876c = ckVar;
        this.f55877d = bzVar;
        this.f55878e = ckVar2;
    }

    /* renamed from: a */
    private final <T> T m41963a(C19957co<T> coVar) {
        try {
            mo164162a();
            return coVar.mo164159a();
        } finally {
            mo164167b();
        }
    }

    /* renamed from: d */
    private final Map<String, C19955cm> m41964d(List<String> list) {
        return (Map) m41963a(new C19948cf(this, list));
    }

    /* renamed from: e */
    private final C19955cm m41965e(int i) {
        Map<Integer, C19955cm> map = this.f55879f;
        Integer valueOf = Integer.valueOf(i);
        C19955cm cmVar = map.get(valueOf);
        if (cmVar != null) {
            return cmVar;
        }
        throw new C19937bv(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i);
    }

    /* renamed from: e */
    private static String m41966e(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new C19937bv("Session without pack received.");
    }

    /* renamed from: e */
    private static <T> List<T> m41967e(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Map<String, Integer> mo164161a(List<String> list) {
        return (Map) m41963a(new C19951ci(this, list));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164162a() {
        this.f55880g.lock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164163a(int i) {
        m41963a(new C19950ch(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164164a(String str, int i, long j) {
        m41963a(new C19947ce(this, str, i, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo164165a(Bundle bundle) {
        return ((Boolean) m41963a(new C19945cc(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ Map mo164166b(List list) {
        int i;
        Map<String, C19955cm> d = m41964d((List<String>) list);
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C19955cm cmVar = d.get(str);
            if (cmVar == null) {
                i = 8;
            } else {
                if (C19971db.m42014a(cmVar.f55867c.f55862c)) {
                    try {
                        cmVar.f55867c.f55862c = 6;
                        this.f55878e.mo164325a().execute(new C19952cj(this, cmVar));
                        this.f55877d.mo164157a(str);
                    } catch (C19937bv unused) {
                        f55874a.mo164270c("Session %d with pack %s does not exist, no need to cancel.", Integer.valueOf(cmVar.f55865a), str);
                    }
                }
                i = cmVar.f55867c.f55862c;
            }
            hashMap.put(str, Integer.valueOf(i));
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo164167b() {
        this.f55880g.unlock();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo164168b(int i) {
        m41965e(i).f55867c.f55862c = 5;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo164169b(String str, int i, long j) {
        C19955cm cmVar = m41964d((List<String>) Arrays.asList(new String[]{str})).get(str);
        if (cmVar == null || C19971db.m42017b(cmVar.f55867c.f55862c)) {
            f55874a.mo164269b(String.format("Could not find pack %s while trying to complete it", new Object[]{str}), new Object[0]);
        }
        this.f55875b.mo164120f(str, i, j);
        cmVar.f55867c.f55862c = 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo164170b(Bundle bundle) {
        return ((Boolean) m41963a(new C19946cd(this, bundle))).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Boolean mo164171c(Bundle bundle) {
        boolean z;
        int i = bundle.getInt("session_id");
        if (i == 0) {
            return true;
        }
        Map<Integer, C19955cm> map = this.f55879f;
        Integer valueOf = Integer.valueOf(i);
        if (!map.containsKey(valueOf)) {
            return true;
        }
        C19955cm cmVar = this.f55879f.get(valueOf);
        if (cmVar.f55867c.f55862c == 6) {
            z = false;
        } else {
            z = !C19971db.m42015a(cmVar.f55867c.f55862c, bundle.getInt(C20098i.m42301a("status", m41966e(bundle))));
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final Map<Integer, C19955cm> mo164172c() {
        return this.f55879f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ Map mo164173c(List list) {
        HashMap hashMap = new HashMap();
        for (C19955cm next : this.f55879f.values()) {
            String str = next.f55867c.f55860a;
            if (list.contains(str)) {
                C19955cm cmVar = (C19955cm) hashMap.get(str);
                if ((cmVar == null ? -1 : cmVar.f55865a) < next.f55865a) {
                    hashMap.put(str, next);
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final /* synthetic */ void mo164174c(int i) {
        C19955cm e = m41965e(i);
        if (C19971db.m42017b(e.f55867c.f55862c)) {
            C19917bb bbVar = this.f55875b;
            C19954cl clVar = e.f55867c;
            bbVar.mo164120f(clVar.f55860a, e.f55866b, clVar.f55861b);
            C19954cl clVar2 = e.f55867c;
            int i2 = clVar2.f55862c;
            if (i2 == 5 || i2 == 6) {
                this.f55875b.mo164112d(clVar2.f55860a);
                return;
            }
            return;
        }
        throw new C19937bv(String.format("Could not safely delete session %d because it is not in a terminal state.", new Object[]{Integer.valueOf(i)}), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final /* synthetic */ Boolean mo164175d(Bundle bundle) {
        C19956cn cnVar;
        Bundle bundle2 = bundle;
        int i = bundle2.getInt("session_id");
        if (i == 0) {
            return false;
        }
        Map<Integer, C19955cm> map = this.f55879f;
        Integer valueOf = Integer.valueOf(i);
        boolean z = true;
        if (map.containsKey(valueOf)) {
            C19955cm e = m41965e(i);
            int i2 = bundle2.getInt(C20098i.m42301a("status", e.f55867c.f55860a));
            if (C19971db.m42015a(e.f55867c.f55862c, i2)) {
                f55874a.mo164267a("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(e.f55867c.f55862c));
                C19954cl clVar = e.f55867c;
                String str = clVar.f55860a;
                int i3 = clVar.f55862c;
                if (i3 == 4) {
                    this.f55876c.mo164325a().mo164079a(i, str);
                } else if (i3 == 5) {
                    this.f55876c.mo164325a().mo164078a(i);
                } else if (i3 == 6) {
                    this.f55876c.mo164325a().mo164082a((List<String>) Arrays.asList(new String[]{str}));
                }
            } else {
                e.f55867c.f55862c = i2;
                if (C19971db.m42017b(i2)) {
                    mo164163a(i);
                    this.f55877d.mo164157a(e.f55867c.f55860a);
                } else {
                    for (C19956cn next : e.f55867c.f55864e) {
                        ArrayList parcelableArrayList = bundle2.getParcelableArrayList(C20098i.m42302a("chunk_intents", e.f55867c.f55860a, next.f55868a));
                        if (parcelableArrayList != null) {
                            for (int i4 = 0; i4 < parcelableArrayList.size(); i4++) {
                                if (!(parcelableArrayList.get(i4) == null || ((Intent) parcelableArrayList.get(i4)).getData() == null)) {
                                    next.f55871d.get(i4).f55859a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            String e2 = m41966e(bundle);
            long j = bundle2.getLong(C20098i.m42301a("pack_version", e2));
            int i5 = bundle2.getInt(C20098i.m42301a("status", e2));
            long j2 = bundle2.getLong(C20098i.m42301a("total_bytes_to_download", e2));
            ArrayList<String> stringArrayList = bundle2.getStringArrayList(C20098i.m42301a("slice_ids", e2));
            ArrayList arrayList = new ArrayList();
            for (T t : m41967e(stringArrayList)) {
                ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList(C20098i.m42302a("chunk_intents", e2, (String) t));
                ArrayList arrayList2 = new ArrayList();
                for (Intent intent : m41967e(parcelableArrayList2)) {
                    if (intent == null) {
                        z = false;
                    }
                    arrayList2.add(new C19953ck(z));
                    z = true;
                }
                String string = bundle2.getString(C20098i.m42302a("uncompressed_hash_sha256", e2, (String) t));
                long j3 = bundle2.getLong(C20098i.m42302a("uncompressed_size", e2, (String) t));
                int i6 = bundle2.getInt(C20098i.m42302a("patch_format", e2, (String) t), 0);
                if (i6 != 0) {
                    cnVar = new C19956cn(t, string, j3, arrayList2, 0, i6);
                } else {
                    cnVar = new C19956cn(t, string, j3, arrayList2, bundle2.getInt(C20098i.m42302a("compression_format", e2, (String) t), 0), 0);
                }
                arrayList.add(cnVar);
                z = true;
            }
            this.f55879f.put(Integer.valueOf(i), new C19955cm(i, bundle2.getInt("app_version_code"), new C19954cl(e2, j, i5, j2, arrayList)));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo164176d(int i) {
        m41963a(new C19949cg(this, i));
    }
}
