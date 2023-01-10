package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.safetoolkit.views.IJarvisViewV2;
import com.didi.sdk.util.UiThreadHandler;

public class HomeJarvisPresenterV2 extends AbsJarvisPresenterV2 {

    /* renamed from: a */
    private int f17280a = -1;

    /* access modifiers changed from: protected */
    public String getPage() {
        return "home";
    }

    public HomeJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                HomeJarvisPresenterV2.this.requestJarvisStatus();
            }
        }, 1000);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        ((IJarvisViewV2) this.mView).onLeaveHome();
        unRegister();
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        ((IJarvisViewV2) this.mView).onBackHome();
        register();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                HomeJarvisPresenterV2.this.requestJarvisStatus();
            }
        }, 1000);
    }

    /* renamed from: b */
    private void m14533b() {
        if (this.mView != null) {
            ((IJarvisViewV2) this.mView).setJarvisVisible(8);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, 0);
        }
    }

    /* renamed from: c */
    private void m14534c() {
        if (this.mView != null) {
            ((IJarvisViewV2) this.mView).setJarvisVisible(0);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.SafeToolkit.EVENT_JARVIS_HEIGHT_CHANGED, Integer.valueOf(((IJarvisViewV2) this.mView).getView().getMeasuredHeight()));
        }
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
    }
}
