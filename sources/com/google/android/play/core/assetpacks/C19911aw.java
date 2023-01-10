package com.google.android.play.core.assetpacks;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.C20018a;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.listener.C20137b;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.assetpacks.aw */
final class C19911aw extends C20137b<AssetPackState> {

    /* renamed from: c */
    private final C19958cp f55704c;

    /* renamed from: d */
    private final C19938bw f55705d;

    /* renamed from: e */
    private final C20088ck<C20013w> f55706e;

    /* renamed from: f */
    private final C19929bn f55707f;

    /* renamed from: g */
    private final C19941bz f55708g;

    /* renamed from: h */
    private final C20018a f55709h;

    /* renamed from: i */
    private final C20088ck<Executor> f55710i;

    /* renamed from: j */
    private final C20088ck<Executor> f55711j;

    /* renamed from: k */
    private final Handler f55712k = new Handler(Looper.getMainLooper());

    C19911aw(Context context, C19958cp cpVar, C19938bw bwVar, C20088ck<C20013w> ckVar, C19941bz bzVar, C19929bn bnVar, C20018a aVar, C20088ck<Executor> ckVar2, C20088ck<Executor> ckVar3) {
        super(new C20030ag("AssetPackServiceListenerRegistry"), new IntentFilter("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE"), context);
        this.f55704c = cpVar;
        this.f55705d = bwVar;
        this.f55706e = ckVar;
        this.f55708g = bzVar;
        this.f55707f = bnVar;
        this.f55709h = aVar;
        this.f55710i = ckVar2;
        this.f55711j = ckVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo163986a(Context context, Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE");
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.size() != 1) {
                this.f56129a.mo164269b("Corrupt bundle received from broadcast.", new Object[0]);
                return;
            }
            Bundle bundleExtra2 = intent.getBundleExtra("com.google.android.play.core.FLAGS");
            if (bundleExtra2 != null) {
                this.f55709h.mo164250a(bundleExtra2);
            }
            AssetPackState a = AssetPackState.m41801a(bundleExtra, stringArrayList.get(0), this.f55708g, C19913ay.f55722a);
            this.f56129a.mo164267a("ListenerRegistryBroadcastReceiver.onReceive: %s", a);
            PendingIntent pendingIntent = (PendingIntent) bundleExtra.getParcelable("confirmation_intent");
            if (pendingIntent != null) {
                this.f55707f.mo164147a(pendingIntent);
            }
            this.f55711j.mo164325a().execute(new C19909au(this, bundleExtra, a));
            this.f55710i.mo164325a().execute(new C19910av(this, bundleExtra));
            return;
        }
        this.f56129a.mo164269b("Empty bundle received from broadcast.", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164087a(Bundle bundle) {
        if (this.f55704c.mo164165a(bundle)) {
            this.f55705d.mo164152a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo164088a(Bundle bundle, AssetPackState assetPackState) {
        if (this.f55704c.mo164170b(bundle)) {
            mo164089a(assetPackState);
            this.f55706e.mo164325a().mo164077a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164089a(AssetPackState assetPackState) {
        this.f55712k.post(new C19908at(this, assetPackState));
    }
}
