package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20040aq;
import com.google.android.play.core.internal.C20076bz;
import com.google.android.play.core.internal.C20109t;
import com.google.android.play.core.splitcompat.C20164p;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.play.core.assetpacks.ar */
final class C19906ar implements C20013w {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C20030ag f55688a = new C20030ag("AssetPackServiceImpl");

    /* renamed from: b */
    private static final Intent f55689b = new Intent("com.google.android.play.core.assetmoduleservice.BIND_ASSET_MODULE_SERVICE").setPackage("com.android.vending");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f55690c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C19941bz f55691d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C20040aq<C20109t> f55692e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C20040aq<C20109t> f55693f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final AtomicBoolean f55694g = new AtomicBoolean();

    C19906ar(Context context, C19941bz bzVar) {
        this.f55690c = context.getPackageName();
        this.f55691d = bzVar;
        if (C20076bz.m42267a(context)) {
            this.f55692e = new C20040aq(C20164p.m42450a(context), f55688a, "AssetPackService", f55689b, C20014x.f56043a);
            this.f55693f = new C20040aq(C20164p.m42450a(context), f55688a, "AssetPackService-keepAlive", f55689b, C20015y.f56044a);
        }
        f55688a.mo164267a("AssetPackService initiated.", new Object[0]);
    }

    /* renamed from: a */
    static /* synthetic */ ArrayList m41841a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Bundle bundle = new Bundle();
            bundle.putString("module_name", (String) it.next());
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ List m41842a(C19906ar arVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AssetPackState next = AssetPackStates.m41805a((Bundle) it.next(), arVar.f55691d).packStates().values().iterator().next();
            if (next == null) {
                f55688a.mo164269b("onGetSessionStates: Bundle contained no pack.", new Object[0]);
            }
            if (C19971db.m42014a(next.status())) {
                arrayList.add(next.name());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m41843a(int i, String str, int i2) {
        if (this.f55692e != null) {
            f55688a.mo164270c("notifyModuleCompleted", new Object[0]);
            C20237i iVar = new C20237i();
            this.f55692e.mo164279a((C20031ah) new C19895ag(this, iVar, i, str, iVar, i2));
            return;
        }
        throw new C19937bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: b */
    static /* synthetic */ Bundle m41847b(Map map) {
        Bundle e = m41857e();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Bundle bundle = new Bundle();
            bundle.putString("installed_asset_module_name", (String) entry.getKey());
            bundle.putLong("installed_asset_module_version", ((Long) entry.getValue()).longValue());
            arrayList.add(bundle);
        }
        e.putParcelableArrayList("installed_asset_module", arrayList);
        return e;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m41851c(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", i);
        return bundle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bundle m41852c(int i, String str) {
        Bundle c = m41851c(i);
        c.putString("module_name", str);
        return c;
    }

    /* renamed from: c */
    static /* synthetic */ Bundle m41853c(int i, String str, String str2, int i2) {
        Bundle c = m41852c(i, str);
        c.putString("slice_id", str2);
        c.putInt("chunk_number", i2);
        return c;
    }

    /* renamed from: d */
    private static <T> Task<T> m41856d() {
        f55688a.mo164269b("onError(%d)", -11);
        return Tasks.m42595a((Exception) new AssetPackException(-11));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static Bundle m41857e() {
        Bundle bundle = new Bundle();
        bundle.putInt("playcore_version_code", 10802);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(1);
        bundle.putIntegerArrayList("supported_compression_formats", arrayList);
        bundle.putIntegerArrayList("supported_patch_formats", new ArrayList());
        return bundle;
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo164074a(List<String> list, C19914az azVar, Map<String, Long> map) {
        if (this.f55692e == null) {
            return m41856d();
        }
        f55688a.mo164270c("getPackStates(%s)", list);
        C20237i iVar = new C20237i();
        this.f55692e.mo164279a((C20031ah) new C19893ae(this, iVar, list, map, iVar, azVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo164075a(List<String> list, List<String> list2, Map<String, Long> map) {
        if (this.f55692e == null) {
            return m41856d();
        }
        f55688a.mo164270c("startDownload(%s)", list2);
        C20237i iVar = new C20237i();
        this.f55692e.mo164279a((C20031ah) new C19890ab(this, iVar, list2, map, iVar, list));
        iVar.mo164553a().addOnSuccessListener(new C20016z(this));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo164076a(Map<String, Long> map) {
        if (this.f55692e == null) {
            return m41856d();
        }
        f55688a.mo164270c("syncPacks", new Object[0]);
        C20237i iVar = new C20237i();
        this.f55692e.mo164279a((C20031ah) new C19892ad(this, iVar, map, iVar));
        return iVar.mo164553a();
    }

    /* renamed from: a */
    public final synchronized void mo164077a() {
        if (this.f55693f == null) {
            f55688a.mo164271d("Keep alive connection manager is not initialized.", new Object[0]);
            return;
        }
        f55688a.mo164270c("keepAlive", new Object[0]);
        if (!this.f55694g.compareAndSet(false, true)) {
            f55688a.mo164270c("Service is already kept alive.", new Object[0]);
            return;
        }
        C20237i iVar = new C20237i();
        this.f55693f.mo164279a((C20031ah) new C19898aj(this, iVar, iVar));
    }

    /* renamed from: a */
    public final void mo164078a(int i) {
        if (this.f55692e != null) {
            f55688a.mo164270c("notifySessionFailed", new Object[0]);
            C20237i iVar = new C20237i();
            this.f55692e.mo164279a((C20031ah) new C19896ah(this, iVar, i, iVar));
            return;
        }
        throw new C19937bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo164079a(int i, String str) {
        m41843a(i, str, 10);
    }

    /* renamed from: a */
    public final void mo164080a(int i, String str, String str2, int i2) {
        if (this.f55692e != null) {
            f55688a.mo164270c("notifyChunkTransferred", new Object[0]);
            C20237i iVar = new C20237i();
            this.f55692e.mo164279a((C20031ah) new C19894af(this, iVar, i, str, str2, i2, iVar));
            return;
        }
        throw new C19937bv("The Play Store app is not installed or is an unofficial version.", i);
    }

    /* renamed from: a */
    public final void mo164081a(String str) {
        if (this.f55692e != null) {
            f55688a.mo164270c("removePack(%s)", str);
            C20237i iVar = new C20237i();
            this.f55692e.mo164279a((C20031ah) new C19889aa(this, iVar, str, iVar));
        }
    }

    /* renamed from: a */
    public final void mo164082a(List<String> list) {
        if (this.f55692e != null) {
            f55688a.mo164270c("cancelDownloads(%s)", list);
            C20237i iVar = new C20237i();
            this.f55692e.mo164279a((C20031ah) new C19891ac(this, iVar, list, iVar));
        }
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo164083b(int i, String str, String str2, int i2) {
        if (this.f55692e == null) {
            return m41856d();
        }
        f55688a.mo164270c("getChunkFileDescriptor(%s, %s, %d, session=%d)", str, str2, Integer.valueOf(i2), Integer.valueOf(i));
        C20237i iVar = new C20237i();
        this.f55692e.mo164279a((C20031ah) new C19897ai(this, iVar, i, str, str2, i2, iVar));
        return iVar.mo164553a();
    }
}
