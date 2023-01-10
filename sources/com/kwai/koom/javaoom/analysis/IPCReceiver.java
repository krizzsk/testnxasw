package com.kwai.koom.javaoom.analysis;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

class IPCReceiver extends ResultReceiver {

    /* renamed from: a */
    public static final int f58395a = 1001;

    /* renamed from: b */
    public static final int f58396b = 1002;

    /* renamed from: c */
    private ReceiverCallback f58397c;

    public interface ReceiverCallback {
        void onError();

        void onSuccess();
    }

    public IPCReceiver(ReceiverCallback receiverCallback) {
        super((Handler) null);
        this.f58397c = receiverCallback;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        ReceiverCallback receiverCallback = this.f58397c;
        if (receiverCallback == null) {
            return;
        }
        if (i == 1001) {
            receiverCallback.onSuccess();
        } else {
            receiverCallback.onError();
        }
    }
}
