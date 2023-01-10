package com.didi.beatles.p101im.access.recorder;

import android.app.Activity;
import com.didi.beatles.p101im.views.IMAudioDialog;

/* renamed from: com.didi.beatles.im.access.recorder.IMOpenRecorderTip */
public class IMOpenRecorderTip {

    /* renamed from: a */
    private IMAudioDialog f10684a;

    public IMOpenRecorderTip(Activity activity) {
        this.f10684a = new IMAudioDialog(activity);
    }

    public void show() {
        this.f10684a.show();
        this.f10684a.setTip(false);
    }

    public boolean isShowing() {
        return this.f10684a.isShowing();
    }

    public void dismiss() {
        this.f10684a.dissMissAudioDialog();
    }

    public void setTip(boolean z) {
        this.f10684a.setTip(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public IMAudioDialog mo46553a() {
        return this.f10684a;
    }
}
