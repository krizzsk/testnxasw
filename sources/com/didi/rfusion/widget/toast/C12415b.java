package com.didi.rfusion.widget.toast;

import android.app.Application;
import com.didi.rfusion.widget.toast.helper.RFNotificationToastHelper;

/* renamed from: com.didi.rfusion.widget.toast.b */
/* compiled from: RFNotificationToast */
class C12415b extends C12414a {

    /* renamed from: a */
    private final RFNotificationToastHelper f36768a;

    public C12415b(Application application) {
        super(application);
        this.f36768a = new RFNotificationToastHelper(this, application);
    }

    public void show() {
        this.f36768a.show();
    }

    public void cancel() {
        this.f36768a.cancel();
    }
}
