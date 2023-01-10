package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class FcmBroadcastProcessor$$Lambda$2 implements Continuation {
    private final Context arg$1;
    private final Intent arg$2;

    FcmBroadcastProcessor$$Lambda$2(Context context, Intent intent) {
        this.arg$1 = context;
        this.arg$2 = intent;
    }

    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2$FcmBroadcastProcessor(this.arg$1, this.arg$2, task);
    }
}
