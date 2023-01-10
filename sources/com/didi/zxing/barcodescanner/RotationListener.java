package com.didi.zxing.barcodescanner;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public class RotationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f47971a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WindowManager f47972b;

    /* renamed from: c */
    private OrientationEventListener f47973c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RotationCallback f47974d;

    public void listen(Context context, RotationCallback rotationCallback) {
        stop();
        Context applicationContext = context.getApplicationContext();
        this.f47974d = rotationCallback;
        this.f47972b = (WindowManager) applicationContext.getSystemService("window");
        C157371 r3 = new OrientationEventListener(applicationContext, 3) {
            public void onOrientationChanged(int i) {
                int rotation;
                WindowManager a = RotationListener.this.f47972b;
                RotationCallback b = RotationListener.this.f47974d;
                if (RotationListener.this.f47972b != null && b != null && (rotation = a.getDefaultDisplay().getRotation()) != RotationListener.this.f47971a) {
                    int unused = RotationListener.this.f47971a = rotation;
                    b.onRotationChanged(rotation);
                }
            }
        };
        this.f47973c = r3;
        r3.enable();
        this.f47971a = this.f47972b.getDefaultDisplay().getRotation();
    }

    public void stop() {
        OrientationEventListener orientationEventListener = this.f47973c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f47973c = null;
        this.f47972b = null;
        this.f47974d = null;
    }
}
