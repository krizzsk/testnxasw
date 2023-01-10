package com.didi.soda.customer.app;

import android.app.Activity;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/customer/app/ActivityTraceInfo;", "", "()V", "traceInfo", "", "append", "", "activity", "Landroid/app/Activity;", "isAdd", "", "getTraceInfo", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ActivityTraceInfo.kt */
public final class ActivityTraceInfo {

    /* renamed from: a */
    private String f42875a = "";

    public final void append(Activity activity, boolean z) {
        String str = "null";
        if (z) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f42875a);
                sb.append("|enter-");
                if (activity != null) {
                    Class<?> cls = activity.getClass();
                    if (cls != null) {
                        String simpleName = cls.getSimpleName();
                        if (simpleName != null) {
                            str = simpleName;
                        }
                    }
                }
                sb.append(str);
                this.f42875a = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f42875a);
            sb2.append("|exit-");
            if (activity != null) {
                Class<?> cls2 = activity.getClass();
                if (cls2 != null) {
                    String simpleName2 = cls2.getSimpleName();
                    if (simpleName2 != null) {
                        str = simpleName2;
                    }
                }
            }
            sb2.append(str);
            this.f42875a = sb2.toString();
        }
    }

    public final String getTraceInfo() {
        return this.f42875a;
    }
}
