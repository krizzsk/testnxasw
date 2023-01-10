package com.didi.beatles.p101im.utils.imageloader;

import android.graphics.Bitmap;

/* renamed from: com.didi.beatles.im.utils.imageloader.Callback */
public interface Callback {
    void onFailed();

    void onStart();

    void onSuccess(Bitmap bitmap);
}
