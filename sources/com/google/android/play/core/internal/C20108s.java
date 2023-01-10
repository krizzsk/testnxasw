package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.s */
public abstract class C20108s extends C20100k implements C20109t {
    /* renamed from: a */
    public static C20109t m42341a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof C20109t ? (C20109t) queryLocalInterface : new C20107r(iBinder);
    }
}
