package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
final /* synthetic */ class RequestDeduplicator$$Lambda$0 implements Continuation {
    private final RequestDeduplicator arg$1;
    private final String arg$2;

    RequestDeduplicator$$Lambda$0(RequestDeduplicator requestDeduplicator, String str) {
        this.arg$1 = requestDeduplicator;
        this.arg$2 = str;
    }

    public Object then(Task task) {
        this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, task);
        return task;
    }
}
