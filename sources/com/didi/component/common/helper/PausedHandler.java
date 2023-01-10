package com.didi.component.common.helper;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.sdk.util.UiThreadHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class PausedHandler extends Handler {

    /* renamed from: a */
    private final Vector<Message> f13440a = new Vector<>();

    /* renamed from: b */
    private volatile boolean f13441b;

    public PausedHandler(Looper looper) {
        super(looper);
    }

    public void resume() {
        this.f13441b = false;
        while (this.f13440a.size() > 0) {
            final ArrayList arrayList = new ArrayList(this.f13440a);
            this.f13440a.clear();
            post(new Runnable() {
                public void run() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        Message message = (Message) it.next();
                        PausedHandler.this.processMessage(message);
                        message.recycle();
                    }
                }
            });
        }
    }

    public void pause() {
        this.f13441b = true;
    }

    public boolean isPaused() {
        return this.f13441b;
    }

    /* access modifiers changed from: protected */
    public void processMessage(Message message) {
        if (message.obj != null) {
            UiThreadHandler.postDelayed((Runnable) message.obj, 100);
        }
    }

    public final void handleMessage(Message message) {
        if (this.f13441b) {
            this.f13440a.add(Message.obtain(message));
            return;
        }
        processMessage(message);
    }
}
