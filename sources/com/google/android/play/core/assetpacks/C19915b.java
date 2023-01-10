package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20076bz;
import com.google.android.play.core.internal.C20112w;
import com.google.android.play.core.internal.C20115z;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.b */
final class C19915b extends C20112w {

    /* renamed from: a */
    private final C20030ag f55723a = new C20030ag("AssetPackExtractionService");

    /* renamed from: b */
    private final Context f55724b;

    /* renamed from: c */
    private final AssetPackExtractionService f55725c;

    /* renamed from: d */
    private final C19917bb f55726d;

    C19915b(Context context, AssetPackExtractionService assetPackExtractionService, C19917bb bbVar) {
        this.f55724b = context;
        this.f55725c = assetPackExtractionService;
        this.f55726d = bbVar;
    }

    /* renamed from: a */
    public final void mo164091a(Bundle bundle, C20115z zVar) throws RemoteException {
        String[] packagesForUid;
        this.f55723a.mo164267a("updateServiceState AIDL call", new Object[0]);
        if (!C20076bz.m42267a(this.f55724b) || (packagesForUid = this.f55724b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) == null || !Arrays.asList(packagesForUid).contains("com.android.vending")) {
            zVar.mo164369a(new Bundle());
            this.f55725c.mo164032a();
            return;
        }
        zVar.mo164370a(this.f55725c.mo164031a(bundle), new Bundle());
    }

    /* renamed from: a */
    public final void mo164092a(C20115z zVar) throws RemoteException {
        this.f55726d.mo164119f();
        zVar.mo164371b(new Bundle());
    }
}
