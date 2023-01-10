package com.google.android.play.core.assetpacks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.internal.C20098i;
import com.google.android.play.core.splitinstall.C20207p;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.j */
final class C19999j implements AssetPackManager {

    /* renamed from: a */
    private static final C20030ag f56010a = new C20030ag("AssetPackManager");

    /* renamed from: b */
    private final C19917bb f56011b;

    /* renamed from: c */
    private final C20088ck<C20013w> f56012c;

    /* renamed from: d */
    private final C19911aw f56013d;

    /* renamed from: e */
    private final C20207p f56014e;

    /* renamed from: f */
    private final C19958cp f56015f;

    /* renamed from: g */
    private final C19941bz f56016g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C19929bn f56017h;

    /* renamed from: i */
    private final C20088ck<Executor> f56018i;

    /* renamed from: j */
    private final Handler f56019j = new Handler(Looper.getMainLooper());

    /* renamed from: k */
    private boolean f56020k;

    C19999j(C19917bb bbVar, C20088ck<C20013w> ckVar, C19911aw awVar, C20207p pVar, C19958cp cpVar, C19941bz bzVar, C19929bn bnVar, C20088ck<Executor> ckVar2) {
        this.f56011b = bbVar;
        this.f56012c = ckVar;
        this.f56013d = awVar;
        this.f56014e = pVar;
        this.f56015f = cpVar;
        this.f56016g = bzVar;
        this.f56017h = bnVar;
        this.f56018i = ckVar2;
    }

    /* renamed from: c */
    private final void m42073c() {
        this.f56018i.mo164325a().execute(new C19994e(this));
    }

    /* renamed from: d */
    private final void m42074d() {
        this.f56018i.mo164325a().execute(new C19995f(this));
        this.f56020k = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo164238a(int i, String str) {
        if (!this.f56011b.mo164100a(str) && i == 4) {
            return 8;
        }
        if (!this.f56011b.mo164100a(str) || i == 4) {
            return i;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164239a() {
        this.f56011b.mo164111d();
        this.f56011b.mo164108c();
        this.f56011b.mo164116e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164240a(String str, C20237i iVar) {
        if (this.f56011b.mo164112d(str)) {
            iVar.mo164555a(null);
            this.f56012c.mo164325a().mo164081a(str);
            return;
        }
        iVar.mo164554a((Exception) new IOException(String.format("Failed to remove pack %s.", new Object[]{str})));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164241a(boolean z) {
        boolean b = this.f56013d.mo164408b();
        this.f56013d.mo164406a(z);
        if (z && !b) {
            m42073c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo164242b() {
        C19917bb bbVar = this.f56011b;
        bbVar.getClass();
        this.f56012c.mo164325a().mo164076a(this.f56011b.mo164104b()).addOnSuccessListener(this.f56018i.mo164325a(), C19996g.m42070a(bbVar)).addOnFailureListener(this.f56018i.mo164325a(), C19997h.f56007a);
    }

    public final AssetPackStates cancel(List<String> list) {
        Map<String, Integer> a = this.f56015f.mo164161a(list);
        HashMap hashMap = new HashMap();
        for (String next : list) {
            Integer num = a.get(next);
            hashMap.put(next, AssetPackState.m41802a(next, num == null ? 0 : num.intValue(), 0, 0, 0, 0.0d, 1));
        }
        this.f56012c.mo164325a().mo164082a(list);
        return AssetPackStates.m41804a(0, (Map<String, AssetPackState>) hashMap);
    }

    public final void clearListeners() {
        this.f56013d.mo164403a();
    }

    public final Task<AssetPackStates> fetch(List<String> list) {
        Map<String, Long> b = this.f56011b.mo164104b();
        ArrayList arrayList = new ArrayList(list);
        arrayList.removeAll(b.keySet());
        ArrayList arrayList2 = new ArrayList(list);
        arrayList2.removeAll(arrayList);
        if (!arrayList.isEmpty()) {
            return this.f56012c.mo164325a().mo164075a((List<String>) arrayList2, (List<String>) arrayList, b);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("error_code", 0);
        for (String next : list) {
            bundle.putInt(C20098i.m42301a("status", next), 4);
            bundle.putInt(C20098i.m42301a("error_code", next), 0);
            bundle.putLong(C20098i.m42301a("total_bytes_to_download", next), 0);
            bundle.putLong(C20098i.m42301a("bytes_downloaded", next), 0);
        }
        bundle.putStringArrayList("pack_names", new ArrayList(list));
        bundle.putLong("total_bytes_to_download", 0);
        bundle.putLong("bytes_downloaded", 0);
        return Tasks.m42596a(AssetPackStates.m41805a(bundle, this.f56016g));
    }

    public final AssetLocation getAssetLocation(String str, String str2) {
        AssetPackLocation assetPackLocation;
        if (!this.f56020k) {
            this.f56018i.mo164325a().execute(new C19995f(this));
            this.f56020k = true;
        }
        if (this.f56011b.mo164100a(str)) {
            try {
                assetPackLocation = this.f56011b.mo164101b(str);
            } catch (IOException unused) {
            }
        } else {
            if (this.f56014e.mo164516a().contains(str)) {
                assetPackLocation = AssetPackLocation.m41799a();
            }
            assetPackLocation = null;
        }
        if (assetPackLocation == null) {
            return null;
        }
        if (assetPackLocation.packStorageMethod() == 1) {
            return this.f56011b.mo164093a(str, str2);
        }
        if (assetPackLocation.packStorageMethod() == 0) {
            return this.f56011b.mo164094a(str, str2, assetPackLocation);
        }
        f56010a.mo164267a("The asset %s is not present in Asset Pack %s", str2, str);
        return null;
    }

    public final AssetPackLocation getPackLocation(String str) {
        if (!this.f56020k) {
            m42074d();
        }
        if (this.f56011b.mo164100a(str)) {
            try {
                return this.f56011b.mo164101b(str);
            } catch (IOException unused) {
                return null;
            }
        } else if (this.f56014e.mo164516a().contains(str)) {
            return AssetPackLocation.m41799a();
        } else {
            return null;
        }
    }

    public final Map<String, AssetPackLocation> getPackLocations() {
        Map<String, AssetPackLocation> a = this.f56011b.mo164097a();
        HashMap hashMap = new HashMap();
        for (String put : this.f56014e.mo164516a()) {
            hashMap.put(put, AssetPackLocation.m41799a());
        }
        a.putAll(hashMap);
        return a;
    }

    public final Task<AssetPackStates> getPackStates(List<String> list) {
        return this.f56012c.mo164325a().mo164074a(list, (C19914az) new C19942c(this), this.f56011b.mo164104b());
    }

    public final synchronized void registerListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        boolean b = this.f56013d.mo164408b();
        this.f56013d.mo164404a(assetPackStateUpdateListener);
        if (!b) {
            m42073c();
        }
    }

    public final Task<Void> removePack(String str) {
        C20237i iVar = new C20237i();
        this.f56018i.mo164325a().execute(new C19969d(this, str, iVar));
        return iVar.mo164553a();
    }

    public final Task<Integer> showCellularDataConfirmation(Activity activity) {
        if (activity == null) {
            return Tasks.m42595a((Exception) new AssetPackException(-3));
        }
        if (this.f56017h.mo164146a() == null) {
            return Tasks.m42595a((Exception) new AssetPackException(-12));
        }
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", this.f56017h.mo164146a());
        C20237i iVar = new C20237i();
        intent.putExtra("result_receiver", new C19998i(this, this.f56019j, iVar));
        activity.startActivity(intent);
        return iVar.mo164553a();
    }

    public final void unregisterListener(AssetPackStateUpdateListener assetPackStateUpdateListener) {
        this.f56013d.mo164407b(assetPackStateUpdateListener);
    }
}
