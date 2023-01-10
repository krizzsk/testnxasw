package com.threatmetrix.TrustDefender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import javax.annotation.Nonnull;

public class qyqqqq extends BroadcastReceiver {
    private static final String b006Dm006Dm006Dm = yyyyqy.b0074t007400740074t(qyqqqq.class);
    public TMXProfiling bm006D006Dm006Dm;

    private qyqqqq(TMXProfiling tMXProfiling) {
        this.bm006D006Dm006Dm = tMXProfiling;
    }

    public static void b00680068h0068hh(TMXProfiling tMXProfiling, tqtqqt tqtqqt) {
        if (tqtqqt == null || tqtqqt.bll006C006C006C006C == null) {
            yyyyqy.b007400740074tt0074(b006Dm006Dm006Dm, "Null context");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        try {
            tqtqqt.bll006C006C006C006C.registerReceiver(new qyqqqq(tMXProfiling), intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public void onReceive(Context context, @Nonnull Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.bm006D006Dm006Dm.b007300730073ss0073s();
        } else if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
            this.bm006D006Dm006Dm.bsss0073s0073s();
        }
    }
}
