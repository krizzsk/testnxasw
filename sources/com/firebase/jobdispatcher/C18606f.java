package com.firebase.jobdispatcher;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* renamed from: com.firebase.jobdispatcher.f */
/* compiled from: GooglePlayMessengerCallback */
class C18606f implements JobCallback {

    /* renamed from: a */
    private final Messenger f54750a;

    /* renamed from: b */
    private final String f54751b;

    C18606f(Messenger messenger, String str) {
        this.f54750a = messenger;
        this.f54751b = str;
    }

    public void jobFinished(int i) {
        try {
            this.f54750a.send(m40657a(i));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private Message m40657a(int i) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.arg1 = i;
        Bundle bundle = new Bundle();
        bundle.putString("tag", this.f54751b);
        obtain.setData(bundle);
        return obtain;
    }
}
