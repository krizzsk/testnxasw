package com.didi.soda.bill.component.deliverymethod;

import android.view.View;
import android.widget.ScrollView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.app.GlobalContext;

/* renamed from: com.didi.soda.bill.component.deliverymethod.a */
/* compiled from: ScrollViewHelper */
class C14220a {
    C14220a() {
    }

    /* renamed from: a */
    public static void m31319a(ScrollView scrollView, View view) {
        scrollView.post(new Runnable(scrollView, view) {
            public final /* synthetic */ ScrollView f$0;
            public final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                C14220a.m31322d(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m31322d(ScrollView scrollView, View view) {
        scrollView.fullScroll(130);
        view.setPadding(0, 0, 0, 0);
    }

    /* renamed from: b */
    public static void m31320b(ScrollView scrollView, View view) {
        scrollView.post(new Runnable(scrollView, view) {
            public final /* synthetic */ ScrollView f$0;
            public final /* synthetic */ View f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                C14220a.m31321c(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m31321c(ScrollView scrollView, View view) {
        scrollView.fullScroll(33);
        view.setPadding(0, 0, 0, DisplayUtils.dip2px(GlobalContext.getContext(), 94.0f));
    }
}
