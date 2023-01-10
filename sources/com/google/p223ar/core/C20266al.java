package com.google.p223ar.core;

import android.media.ImageReader;

/* renamed from: com.google.ar.core.al */
final /* synthetic */ class C20266al implements ImageReader.OnImageAvailableListener {

    /* renamed from: a */
    static final ImageReader.OnImageAvailableListener f56444a = new C20266al();

    private C20266al() {
    }

    public final void onImageAvailable(ImageReader imageReader) {
        SharedCamera.lambda$setDummyOnImageAvailableListener$0$SharedCamera(imageReader);
    }
}
