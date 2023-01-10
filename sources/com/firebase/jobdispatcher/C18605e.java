package com.firebase.jobdispatcher;

import android.app.AppOpsManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.firebase.jobdispatcher.JobInvocation;

/* renamed from: com.firebase.jobdispatcher.e */
/* compiled from: GooglePlayMessageHandler */
class C18605e extends Handler {

    /* renamed from: a */
    static final int f54745a = 1;

    /* renamed from: b */
    static final int f54746b = 2;

    /* renamed from: c */
    static final int f54747c = 3;

    /* renamed from: d */
    private static final int f54748d = 4;

    /* renamed from: e */
    private final GooglePlayReceiver f54749e;

    public C18605e(Looper looper, GooglePlayReceiver googlePlayReceiver) {
        super(looper);
        this.f54749e = googlePlayReceiver;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            try {
                ((AppOpsManager) this.f54749e.getApplicationContext().getSystemService("appops")).checkPackage(message.sendingUid, "com.google.android.gms");
                int i = message.what;
                if (i == 1) {
                    m40655a(message);
                } else if (i == 2) {
                    m40656b(message);
                } else if (i != 4) {
                    SystemUtils.log(6, "FJD.GooglePlayReceiver", "Unrecognized message received: " + message, (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 79);
                }
            } catch (SecurityException unused) {
                SystemUtils.log(6, "FJD.GooglePlayReceiver", "Message was not sent from GCM.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 61);
            }
        }
    }

    /* renamed from: a */
    private void m40655a(Message message) {
        Bundle data = message.getData();
        Messenger messenger = message.replyTo;
        String string = data.getString("tag");
        if (messenger != null && string != null) {
            this.f54749e.mo137460b().mo137443a(this.f54749e.mo137457a((JobCallback) new C18606f(messenger, string), data));
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            SystemUtils.log(3, "FJD.GooglePlayReceiver", "Invalid start execution message.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 91);
        }
    }

    /* renamed from: b */
    private void m40656b(Message message) {
        JobInvocation.Builder b = GooglePlayReceiver.m40625c().mo137553b(message.getData());
        if (b != null) {
            ExecutionDelegator.m40616a(b.build(), true);
        } else if (Log.isLoggable("FJD.GooglePlayReceiver", 3)) {
            SystemUtils.log(3, "FJD.GooglePlayReceiver", "Invalid stop execution message.", (Throwable) null, "com.firebase.jobdispatcher.GooglePlayMessageHandler", 105);
        }
    }
}
