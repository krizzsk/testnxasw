package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.didi.component.core.ComponentParams;
import com.didi.sdk.app.ActivityStack;

public class EndJarvisPresenterV2 extends AbsJarvisPresenterV2 {

    /* renamed from: a */
    private ActivityStack.OnStackChangedAdapter f17277a = new ActivityStack.OnStackChangedAdapter() {
        public void onAppResume() {
            super.onAppResume();
            EndJarvisPresenterV2.this.requestJarvisStatus();
        }
    };

    /* access modifiers changed from: protected */
    public String getPage() {
        return "end";
    }

    public EndJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        requestJarvisStatus();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
        ActivityStack.addStackChangedListener(this.f17277a);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
        ActivityStack.removeStackChangedListener(this.f17277a);
    }
}
