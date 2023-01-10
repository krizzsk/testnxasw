package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20040aq;
import com.google.android.play.core.internal.C20072bv;
import com.google.android.play.core.internal.C20076bz;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.av */
final class C20188av {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C20030ag f56237b = new C20030ag("SplitInstallService");

    /* renamed from: c */
    private static final Intent f56238c = new Intent("com.google.android.play.core.splitinstall.BIND_SPLIT_INSTALL_SERVICE").setPackage("com.android.vending");

    /* renamed from: a */
    C20040aq<C20072bv> f56239a;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f56240d;

    public C20188av(Context context) {
        this.f56240d = context.getPackageName();
        if (C20076bz.m42267a(context)) {
            this.f56239a = new C20040aq(C20164p.m42450a(context), f56237b, "SplitInstallService", f56238c, C20170ad.f56210a);
        }
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m42497a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m42498b() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10802);
        return bundle;
    }

    /* renamed from: b */
    static /* synthetic */ ArrayList m42499b(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("language", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: d */
    private static <T> Task<T> m42501d() {
        f56237b.mo164269b("onError(%d)", -14);
        return Tasks.m42595a((Exception) new SplitInstallException(-14));
    }

    /* renamed from: a */
    public final Task<List<SplitInstallSessionState>> mo164494a() {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("getSessionStates", new Object[0]);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20177ak(this, iVar, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<SplitInstallSessionState> mo164495a(int i) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("getSessionState(%d)", Integer.valueOf(i));
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20176aj(this, iVar, i, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<Integer> mo164496a(Collection<String> collection, Collection<String> collection2) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("startInstall(%s,%s)", collection, collection2);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20171ae(this, iVar, collection, collection2, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<Void> mo164497a(List<String> list) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("deferredUninstall(%s)", list);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20172af(this, iVar, list, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: b */
    public final Task<Void> mo164498b(int i) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("cancelInstall(%d)", Integer.valueOf(i));
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20178al(this, iVar, i, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: b */
    public final Task<Void> mo164499b(List<String> list) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("deferredInstall(%s)", list);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20173ag(this, iVar, list, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: c */
    public final Task<Void> mo164500c(List<String> list) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("deferredLanguageInstall(%s)", list);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20174ah(this, iVar, list, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: d */
    public final Task<Void> mo164501d(List<String> list) {
        if (this.f56239a == null) {
            return m42501d();
        }
        f56237b.mo164270c("deferredLanguageUninstall(%s)", list);
        C20237i iVar = new C20237i();
        this.f56239a.mo164279a((C20031ah) new C20175ai(this, iVar, list, iVar));
        return iVar.mo164553a();
    }
}
