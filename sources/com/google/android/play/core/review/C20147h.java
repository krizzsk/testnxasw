package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.internal.C20026ac;
import com.google.android.play.core.internal.C20030ag;
import com.google.android.play.core.internal.C20031ah;
import com.google.android.play.core.internal.C20040aq;
import com.google.android.play.core.tasks.C20237i;
import com.google.android.play.core.tasks.Task;

/* renamed from: com.google.android.play.core.review.h */
public final class C20147h {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final C20030ag f56154b = new C20030ag("ReviewService");

    /* renamed from: a */
    final C20040aq<C20026ac> f56155a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f56156c;

    public C20147h(Context context) {
        this.f56156c = context.getPackageName();
        Context context2 = context;
        this.f56155a = new C20040aq(context2, f56154b, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), C20143d.f56148a);
    }

    /* renamed from: a */
    public final Task<ReviewInfo> mo164427a() {
        f56154b.mo164270c("requestInAppReview (%s)", this.f56156c);
        C20237i iVar = new C20237i();
        this.f56155a.mo164279a((C20031ah) new C20144e(this, iVar, iVar));
        return iVar.mo164553a();
    }
}
