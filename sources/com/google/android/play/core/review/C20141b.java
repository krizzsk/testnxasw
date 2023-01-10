package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.review.b */
final class C20141b extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C20237i f56145a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C20141b(Handler handler, C20237i iVar) {
        super(handler);
        this.f56145a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f56145a.mo164557b(null);
    }
}
