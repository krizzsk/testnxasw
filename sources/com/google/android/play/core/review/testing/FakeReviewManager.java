package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeReviewManager implements ReviewManager {

    /* renamed from: a */
    private final Context f56157a;

    /* renamed from: b */
    private ReviewInfo f56158b;

    public FakeReviewManager(Context context) {
        this.f56157a = context;
    }

    public Task<Void> launchReviewFlow(Activity activity, ReviewInfo reviewInfo) {
        return reviewInfo != this.f56158b ? Tasks.m42595a((Exception) new C20148a()) : Tasks.m42596a(null);
    }

    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo a = ReviewInfo.m42394a(PendingIntent.getBroadcast(this.f56157a, 0, new Intent(), 0));
        this.f56158b = a;
        return Tasks.m42596a(a);
    }
}
