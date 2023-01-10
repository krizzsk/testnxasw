package com.didi.rfusion.widget.toast;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationManagerCompat;
import com.didi.rfusion.RFusion;
import com.didi.rfusion.utils.RFActivityManager;
import com.didi.rfusion.widget.toast.helper.RFToastSafeHook;
import com.didi.sdk.apm.SystemUtils;

class RFToastController {

    /* renamed from: a */
    private static final int f36762a = 3;

    /* renamed from: b */
    private static final Handler f36763b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private C12414a f36764c;

    private RFToastController() {
    }

    private static final class InnerHolder {
        /* access modifiers changed from: private */
        public static final RFToastController INSTANCE = new RFToastController();

        private InnerHolder() {
        }
    }

    /* renamed from: a */
    public static RFToastController m27731a() {
        return InnerHolder.INSTANCE;
    }

    /* renamed from: a */
    public void mo95015a(String str, int i, boolean z) {
        if (z || RFActivityManager.getInstance().isApplicationForeground()) {
            Context context = RFusion.getContext();
            if (context instanceof Application) {
                f36763b.post(new Runnable(context, str, i) {
                    public final /* synthetic */ Context f$1;
                    public final /* synthetic */ String f$2;
                    public final /* synthetic */ int f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        RFToastController.this.m27733a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27733a(Context context, String str, int i) {
        m27735b();
        C12414a a = m27732a((Application) context);
        this.f36764c = a;
        a.mo95017a(str);
        this.f36764c.mo95016a(i);
        SystemUtils.showToast(this.f36764c);
    }

    /* renamed from: a */
    private C12414a m27732a(Application application) {
        C12414a aVar;
        if (m27734a((Context) application)) {
            aVar = new C12414a(application);
        } else {
            aVar = new C12415b(application);
        }
        if (Build.VERSION.SDK_INT == 25) {
            RFToastSafeHook.makeSafe(aVar);
        }
        return aVar;
    }

    /* renamed from: b */
    private void m27735b() {
        C12414a aVar = this.f36764c;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    /* renamed from: a */
    private static boolean m27734a(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }
}
