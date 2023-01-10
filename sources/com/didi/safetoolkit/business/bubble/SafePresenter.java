package com.didi.safetoolkit.business.bubble;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.safetoolkit.api.ISfJarvisService;
import com.didi.safetoolkit.business.bubble.ISafePresenter;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.business.bubble.model.SfJarvisData;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfLog;
import com.didichuxing.foundation.spi.ServiceLoader;

public class SafePresenter implements ISafePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f37028a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SfJarvisData f37029b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfBubbleData f37030c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ISafePresenter.Callback f37031d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f37032e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f37033f = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f37034g = new Runnable() {
        public void run() {
            if (!TextUtils.isEmpty(SafePresenter.this.f37030c.bubbleId)) {
                SafePresenter.this.f37033f.removeCallbacksAndMessages((Object) null);
                SafePresenter safePresenter = SafePresenter.this;
                safePresenter.m27967a(safePresenter.f37028a, SafePresenter.this.f37030c.bubbleId);
                return;
            }
            SfLog.m28138i("lxs", "runnable");
            boolean z = true;
            int d = SafePresenter.this.f37032e + 1;
            SafePresenter safePresenter2 = SafePresenter.this;
            int unused = safePresenter2.f37032e = d % safePresenter2.f37029b.bubbles.size();
            SafePresenter safePresenter3 = SafePresenter.this;
            SfBubbleData unused2 = safePresenter3.f37030c = safePresenter3.f37029b.bubbles.get(SafePresenter.this.f37032e);
            ISafePresenter.Callback f = SafePresenter.this.f37031d;
            SfBubbleData a = SafePresenter.this.f37030c;
            if (d >= SafePresenter.this.f37029b.bubbles.size()) {
                z = false;
            }
            f.callback(a, z);
            SafePresenter.this.f37033f.postDelayed(SafePresenter.this.f37034g, (long) (SafePresenter.this.f37030c.show * 1000));
        }
    };

    public SafePresenter(Context context) {
        this.f37028a = context;
    }

    public void onActionClick(String str) {
        DRouter.build(str).start(this.f37028a);
    }

    public void refreshJarvisData(SfJarvisData sfJarvisData, ISafePresenter.Callback callback) {
        this.f37029b = sfJarvisData;
        this.f37031d = callback;
        this.f37032e = 0;
        this.f37033f.removeCallbacksAndMessages((Object) null);
        SfLog.m28138i("lxs", "refreshJarvisData");
        if (!m27969a(sfJarvisData)) {
            callback.callback((SfBubbleData) null, true);
        } else if (sfJarvisData.bubbles == null || sfJarvisData.bubbles.size() <= 0) {
            callback.callback((SfBubbleData) null, true);
        } else {
            SfBubbleData sfBubbleData = sfJarvisData.bubbles.get(this.f37032e);
            this.f37030c = sfBubbleData;
            if (sfBubbleData.show == -1) {
                callback.callback(this.f37030c, true);
                return;
            }
            callback.callback(this.f37030c, true);
            this.f37033f.postDelayed(this.f37034g, (long) (this.f37030c.show * 1000));
        }
    }

    public void removeCallBacks() {
        this.f37033f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27967a(Context context, String str) {
        ISfJarvisService iSfJarvisService = (ISfJarvisService) ServiceLoader.load(ISfJarvisService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfJarvisService != null) {
            iSfJarvisService.monitorAbnormalClick(context, str);
        }
    }

    /* renamed from: a */
    private boolean m27969a(SfJarvisData sfJarvisData) {
        return sfJarvisData != null && sfJarvisData.errno == 0;
    }
}
