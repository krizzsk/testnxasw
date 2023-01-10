package com.didichuxing.bigdata.p174dp.locsdk.biz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.DriverCommonBizAdapter */
class DriverCommonBizAdapter implements C15913a {

    /* renamed from: a */
    private static final String f48405a = ".action.DRIVER_USER_STATE_CHANGED";

    /* renamed from: b */
    private static final String f48406b = ".action.DRIVER_ORDER_STATE_CHANGED";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static String f48407c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f48408d = "";

    /* renamed from: e */
    private static final String f48409e = "user_state";

    /* renamed from: f */
    private static final String f48410f = "order_state";

    /* renamed from: g */
    private static final String f48411g = "phone";

    /* renamed from: h */
    private static final String f48412h = "order_id";

    /* renamed from: i */
    private static final int f48413i = 1;

    /* renamed from: j */
    private static final int f48414j = 0;

    /* renamed from: k */
    private static final int f48415k = 1;

    /* renamed from: l */
    private static final int f48416l = 2;

    /* renamed from: m */
    private static final int f48417m = 4;

    /* renamed from: n */
    private static final int f48418n = 5;

    /* renamed from: o */
    private static final int f48419o = 7;

    /* renamed from: p */
    private static final int f48420p = -1;

    /* renamed from: q */
    private Context f48421q;

    /* renamed from: r */
    private BizStateReceiver f48422r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public BizStateListener f48423s;

    DriverCommonBizAdapter() {
    }

    /* renamed from: a */
    public void mo120988a(Context context) {
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        this.f48421q = applicationContext;
        String packageName = applicationContext != null ? applicationContext.getPackageName() : "";
        f48407c = packageName + f48405a;
        f48408d = packageName + f48406b;
    }

    /* renamed from: a */
    public void mo120989a(BizStateListener bizStateListener) {
        this.f48423s = bizStateListener;
        if (bizStateListener != null) {
            m36254c();
        } else {
            m36255d();
        }
    }

    /* renamed from: c */
    private void m36254c() {
        if (this.f48421q != null && this.f48422r == null) {
            this.f48422r = new BizStateReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(f48407c);
            intentFilter.addAction(f48408d);
            LocalBroadcastManager.getInstance(this.f48421q).registerReceiver(this.f48422r, intentFilter);
        }
    }

    /* renamed from: d */
    private void m36255d() {
        Context context = this.f48421q;
        if (context != null && this.f48422r != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f48422r);
            this.f48422r = null;
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.DriverCommonBizAdapter$BizStateReceiver */
    private class BizStateReceiver extends BroadcastReceiver {
        private BizStateReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            BizState bizState = null;
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                String stringExtra = intent.getStringExtra("phone");
                String stringExtra2 = intent.getStringExtra("order_id");
                if (DriverCommonBizAdapter.f48408d.equals(action)) {
                    bizState = DriverCommonBizAdapter.this.m36251b(intent.getIntExtra(DriverCommonBizAdapter.f48410f, -1));
                } else if (DriverCommonBizAdapter.f48407c.equals(action)) {
                    bizState = DriverCommonBizAdapter.this.m36247a(intent.getIntExtra(DriverCommonBizAdapter.f48409e, -1));
                }
                if (bizState != null && DriverCommonBizAdapter.this.f48423s != null) {
                    DriverCommonBizAdapter.this.f48423s.onBizStateChanged(bizState, stringExtra, stringExtra2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BizState m36247a(int i) {
        if (i == 0) {
            return BizState.USER_DRIVER_END_OFF;
        }
        if (i != 1) {
            return BizState.INVAILD;
        }
        return BizState.USER_DRIVER_START_OFF;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public BizState m36251b(int i) {
        if (i == 1) {
            return BizState.ORDER_PICKUP;
        }
        if (i == 2) {
            return BizState.ORDER_WAIT;
        }
        if (i == 4) {
            return BizState.ORDER_ONTRIP;
        }
        if (i == 5) {
            return BizState.ORDER_COMPLETE;
        }
        if (i != 7) {
            return BizState.INVAILD;
        }
        return BizState.ORDER_CANCEL;
    }
}
