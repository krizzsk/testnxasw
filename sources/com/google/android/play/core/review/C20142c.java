package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.c */
public final class C20142c implements ReviewManager {

    /* renamed from: a */
    private final C20147h f56146a;

    /* renamed from: b */
    private final Handler f56147b = new Handler(Looper.getMainLooper());

    C20142c(C20147h hVar) {
        this.f56146a = hVar;
    }

    public final Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        Intent intent = new Intent(activity, PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.mo164418a());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        C20237i iVar = new C20237i();
        intent.putExtra("result_receiver", new C20141b(this.f56147b, iVar));
        activity.startActivity(intent);
        return iVar.mo164553a();
    }

    public final Task<ReviewInfo> requestReviewFlow() {
        return this.f56146a.mo164427a();
    }
}
