package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class WithinAppServiceConnection$BindRequest$$Lambda$1 implements OnCompleteListener {
    private final ScheduledFuture arg$1;

    WithinAppServiceConnection$BindRequest$$Lambda$1(ScheduledFuture scheduledFuture) {
        this.arg$1 = scheduledFuture;
    }

    public void onComplete(Task task) {
        this.arg$1.cancel(false);
    }
}
