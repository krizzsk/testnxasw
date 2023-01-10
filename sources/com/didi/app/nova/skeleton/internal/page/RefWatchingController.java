package com.didi.app.nova.skeleton.internal.page;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Skeleton;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.ControllerChangeType;

public abstract class RefWatchingController extends Controller {

    /* renamed from: c */
    private boolean f10331c;

    protected RefWatchingController(Bundle bundle) {
        super(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f10331c) {
            Skeleton.watchDeletedObject(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onChangeEnded(ControllerChangeHandler controllerChangeHandler, ControllerChangeType controllerChangeType) {
        super.onChangeEnded(controllerChangeHandler, controllerChangeType);
        this.f10331c = !controllerChangeType.isEnter;
        if (isDestroyed()) {
            Skeleton.watchDeletedObject(this);
        }
    }
}
