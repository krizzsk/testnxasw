package com.didi.beatles.p101im.views.eggs;

import android.graphics.Bitmap;
import com.didi.beatles.p101im.api.entity.IMConfig;

/* renamed from: com.didi.beatles.im.views.eggs.IIMEggsView */
public interface IIMEggsView {

    /* renamed from: com.didi.beatles.im.views.eggs.IIMEggsView$OnDrawCallback */
    public interface OnDrawCallback {
        void onFinished(IIMEggsDrop iIMEggsDrop);
    }

    void displayEggs(IMConfig.EggsInfo eggsInfo, Bitmap bitmap);

    void reset();

    void setFrameInterval(int i);

    void setMaxCount(int i);

    void setOnDrawCallback(OnDrawCallback onDrawCallback);
}
