package com.didi.beatles.p101im.views.eggs;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.beatles.p101im.api.entity.IMConfig;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.eggs.IIMEggsView;
import com.didi.beatles.p101im.views.eggs.impl.IMEggsSurfaceView;
import com.didi.beatles.p101im.views.eggs.impl.IMEggsView;

/* renamed from: com.didi.beatles.im.views.eggs.IMEggsLayout */
public class IMEggsLayout extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12042a = IMEggsLayout.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IIMEggsView f12043b;

    public IMEggsLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10357b();
    }

    /* renamed from: b */
    private void m10357b() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f12043b = new IMEggsSurfaceView(getContext());
        } else {
            this.f12043b = new IMEggsView(getContext(), (AttributeSet) null);
        }
        String str = f12042a;
        IMLog.m10020d(str, "[initViews] IIMEggsView=>" + this.f12043b.getClass());
        ((View) this.f12043b).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        post(new Runnable() {
            public void run() {
                if (IMEggsLayout.this.f12043b != null && (IMEggsLayout.this.f12043b instanceof View)) {
                    IMEggsLayout iMEggsLayout = IMEggsLayout.this;
                    iMEggsLayout.addView((View) iMEggsLayout.f12043b);
                }
            }
        });
        this.f12043b.setOnDrawCallback(new IIMEggsView.OnDrawCallback() {
            public void onFinished(IIMEggsDrop iIMEggsDrop) {
                iIMEggsDrop.recycle();
            }
        });
    }

    public void displayEggs(final IMConfig.EggsInfo eggsInfo) {
        if (eggsInfo.width <= 0 || eggsInfo.height <= 0) {
            IMLog.m10021e(f12042a, C4786I.m9980t("[displayEggs] invalid size info: w=", Integer.valueOf(eggsInfo.width), " |h=", Integer.valueOf(eggsInfo.height)));
            return;
        }
        BtsImageLoader.getInstance().download(eggsInfo.image, new Callback() {
            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
                if (bitmap != null) {
                    IMEggsLayout.this.f12043b.displayEggs(eggsInfo, bitmap);
                }
            }

            public void onFailed() {
                IMLog.m10021e(IMEggsLayout.f12042a, "[displayEggs] #loadEggsBitmap# onFailed");
            }
        });
    }
}
