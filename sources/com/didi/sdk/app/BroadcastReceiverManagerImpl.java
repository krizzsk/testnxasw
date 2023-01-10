package com.didi.sdk.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.sdk.app.BaseBusinessContext;
import java.util.HashMap;
import java.util.Map;

public class BroadcastReceiverManagerImpl<T extends BaseBusinessContext> implements BroadcastReceiverManager {

    /* renamed from: a */
    private LocalBroadcastManager f37890a;

    /* renamed from: b */
    private T f37891b;

    /* renamed from: c */
    private Context f37892c;

    /* renamed from: d */
    private Map<AbsDidiBroadcastReceiver, BroadcastReceiver> f37893d = new HashMap();

    BroadcastReceiverManagerImpl(T t) {
        this.f37890a = LocalBroadcastManager.getInstance(t.getContext());
        this.f37891b = t;
        this.f37892c = t.getContext();
    }

    public void unregisterReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver) {
        BroadcastReceiver remove;
        if (absDidiBroadcastReceiver != null && (remove = this.f37893d.remove(absDidiBroadcastReceiver)) != null) {
            this.f37890a.unregisterReceiver(remove);
        }
    }

    public void registerReceiver(AbsDidiBroadcastReceiver absDidiBroadcastReceiver, IntentFilter intentFilter) {
        InternalReceiver internalReceiver = new InternalReceiver(this.f37891b, absDidiBroadcastReceiver);
        this.f37890a.registerReceiver(internalReceiver, intentFilter);
        this.f37893d.put(absDidiBroadcastReceiver, internalReceiver);
    }

    public void sendBroadcast(Intent intent) {
        BroadcastSender.getInstance(this.f37892c).sendBroadcast(intent);
    }

    private static class InternalReceiver<T extends BaseBusinessContext> extends BroadcastReceiver {
        private AbsDidiBroadcastReceiver absDidiBroadcastReceiver;
        private T context;

        public InternalReceiver(T t, AbsDidiBroadcastReceiver absDidiBroadcastReceiver2) {
            this.context = t;
            this.absDidiBroadcastReceiver = absDidiBroadcastReceiver2;
        }

        public void onReceive(Context context2, Intent intent) {
            this.absDidiBroadcastReceiver.onReceive(this.context, intent);
        }
    }
}
