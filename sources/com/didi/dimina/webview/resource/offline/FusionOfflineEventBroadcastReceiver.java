package com.didi.dimina.webview.resource.offline;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class FusionOfflineEventBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    MyHandler f20227a = new MyHandler(Looper.myLooper());

    public void onReceive(Context context, Intent intent) {
        Bundle a = m17065a(intent);
        if (a != null) {
            String string = a.getString("fusion_offline_event_type", "0");
            char c = 65535;
            if (string.hashCode() == 49 && string.equals("1")) {
                c = 0;
            }
            if (c == 0) {
                m17066a(a, "1");
            }
        }
    }

    /* renamed from: a */
    private Bundle m17065a(Intent intent) {
        String action;
        if (intent != null && (action = intent.getAction()) != null && !action.isEmpty() && action.equals("fusion_offline_event")) {
            return intent.getExtras();
        }
        return null;
    }

    static class MyHandler extends Handler {
        public MyHandler() {
        }

        public MyHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (!OfflineBundleManager.getInstance().isAllOfflineItemLoaded()) {
                sendMessageDelayedSecure(message);
            } else if (message.what == 10023) {
                OfflineBundleManager.getInstance().downloadOfflineWhenEvent((String) message.obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void sendMessageDelayedSecure(Message message) {
            sendMessageDelayed(obtainMessage(message.what, message.obj), 2000);
        }
    }

    /* renamed from: a */
    private void m17066a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string != null && !string.isEmpty() && OfflineBundleManager.isInitialized()) {
            Message obtainMessage = this.f20227a.obtainMessage();
            obtainMessage.what = 10023;
            obtainMessage.obj = string;
            this.f20227a.sendMessage(obtainMessage);
        }
    }
}
