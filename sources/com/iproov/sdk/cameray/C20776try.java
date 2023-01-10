package com.iproov.sdk.cameray;

import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import p235do.C21824for;
import p235do.C21827new;
import p235do.C21828this;

/* renamed from: com.iproov.sdk.cameray.try */
/* compiled from: CameraAPI */
public interface C20776try {

    /* renamed from: com.iproov.sdk.cameray.try$do */
    /* compiled from: CameraAPI */
    public interface C20777do {
        /* renamed from: do */
        void mo171343do();

        /* renamed from: do */
        void mo171344do(C20778if ifVar, Exception exc);

        /* renamed from: do */
        void mo171345do(C21824for forR);

        /* renamed from: do */
        void mo171346do(C21827new newR);

        /* renamed from: do */
        void mo171347do(C21828this thisR);

        /* renamed from: do */
        void mo171348do(Exception exc);

        /* renamed from: do */
        void mo171349do(boolean z);
    }

    /* renamed from: com.iproov.sdk.cameray.try$if */
    /* compiled from: CameraAPI */
    public enum C20778if {
        FAILED_TO_LOCK_EXPOSURE,
        FAILED_TO_STOP_GRACEFULLY,
        FAILED_TO_READ_EXIF_DATA,
        FAILED_TO_TAKE_PICTURE
    }

    /* renamed from: do */
    void mo171299do();

    /* renamed from: do */
    void mo171300do(RectF rectF);

    /* renamed from: do */
    void mo171301do(SurfaceTexture surfaceTexture);

    /* renamed from: do */
    void mo171303do(Runnable runnable);

    /* renamed from: do */
    void mo171304do(boolean z);

    /* renamed from: for  reason: not valid java name */
    void m48074for();

    /* renamed from: if */
    C20759const mo171306if();

    /* renamed from: new  reason: not valid java name */
    C21827new m48075new();
}
