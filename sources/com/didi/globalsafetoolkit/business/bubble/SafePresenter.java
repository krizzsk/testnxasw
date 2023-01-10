package com.didi.globalsafetoolkit.business.bubble;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.globalsafetoolkit.business.bubble.ISafePresenter;
import com.didi.globalsafetoolkit.business.bubble.model.SfBubbleData;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfBubbleData;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.JsonObject;
import java.io.IOException;

public class SafePresenter implements ISafePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f24949a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GlobalSfBubbleData f24950b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfBubbleData f24951c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ISafePresenter.Callback f24952d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f24953e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Handler f24954f = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Runnable f24955g = new Runnable() {
        public void run() {
            if (!TextUtils.isEmpty(SafePresenter.this.f24951c.bubbleId)) {
                SafePresenter.this.f24954f.removeCallbacksAndMessages((Object) null);
                SafePresenter safePresenter = SafePresenter.this;
                safePresenter.m20003a(safePresenter.f24949a, SafePresenter.this.f24951c.bubbleId);
                return;
            }
            SfLog.m20152i("lxs", "runnable");
            boolean z = true;
            int d = SafePresenter.this.f24953e + 1;
            SafePresenter safePresenter2 = SafePresenter.this;
            int unused = safePresenter2.f24953e = d % safePresenter2.f24950b.bubbles.size();
            SafePresenter safePresenter3 = SafePresenter.this;
            SfBubbleData unused2 = safePresenter3.f24951c = safePresenter3.f24950b.bubbles.get(SafePresenter.this.f24953e);
            ISafePresenter.Callback f = SafePresenter.this.f24952d;
            SfBubbleData a = SafePresenter.this.f24951c;
            if (d >= SafePresenter.this.f24950b.bubbles.size()) {
                z = false;
            }
            f.callback(a, z);
            SafePresenter.this.f24954f.postDelayed(SafePresenter.this.f24955g, (long) (SafePresenter.this.f24951c.show * 1000));
        }
    };

    public SafePresenter(Context context) {
        this.f24949a = context;
    }

    public void onActionClick(String str) {
        DRouter.build(str).start(this.f24949a);
    }

    public void refreshJarvisData(GlobalSfBubbleData globalSfBubbleData, ISafePresenter.Callback callback) {
        this.f24950b = globalSfBubbleData;
        this.f24952d = callback;
        this.f24953e = 0;
        this.f24954f.removeCallbacksAndMessages((Object) null);
        if (!m20005a(globalSfBubbleData)) {
            callback.callback((SfBubbleData) null, true);
        } else if (globalSfBubbleData.bubbles == null || globalSfBubbleData.bubbles.size() <= 0) {
            callback.callback((SfBubbleData) null, true);
        } else {
            SfBubbleData sfBubbleData = globalSfBubbleData.bubbles.get(this.f24953e);
            this.f24951c = sfBubbleData;
            if (sfBubbleData.show == -1) {
                callback.callback(this.f24951c, true);
                return;
            }
            callback.callback(this.f24951c, true);
            this.f24954f.postDelayed(this.f24955g, (long) (this.f24951c.show * 1000));
        }
    }

    public void removeCallBacks() {
        this.f24954f.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20003a(Context context, String str) {
        GlobalSfManager.getInstance().reportUserState(this.f24949a, new RpcService.Callback<JsonObject>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(JsonObject jsonObject) {
            }
        }, str);
    }

    /* renamed from: a */
    private boolean m20005a(GlobalSfBubbleData globalSfBubbleData) {
        return globalSfBubbleData != null && globalSfBubbleData.errno == 0;
    }
}
