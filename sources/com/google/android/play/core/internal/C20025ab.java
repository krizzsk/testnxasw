package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.ab */
public abstract class C20025ab extends C20100k implements C20026ac {
    /* renamed from: a */
    public static C20026ac m42120a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof C20026ac ? (C20026ac) queryLocalInterface : new C20024aa(iBinder);
    }
}
