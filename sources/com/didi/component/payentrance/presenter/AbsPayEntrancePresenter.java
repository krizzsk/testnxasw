package com.didi.component.payentrance.presenter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.common.loading.AbsLoadingPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.IPayEntranceViewContainer;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.unifiedPay.component.presenter.AbsPaymentPresenter;
import com.didi.unifiedPay.sdk.model.PushMessage;

public abstract class AbsPayEntrancePresenter extends AbsLoadingPresenter<IPayEntranceViewContainer> implements IPayEntranceView.OnCancelRuleClickListener, IPayEntranceView.OnErrorClickListener, IPayEntranceView.OnJumpableClickListener, IPayEntranceView.OnPayListener {

    /* renamed from: c */
    private static final String f16791c = "AbsPayEntrancePresenter";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f16792a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private PushReceiver f16793b;
    protected UniPayManager mUniPayManager = new UniPayManager();

    /* access modifiers changed from: protected */
    public void handlePushReceiver(int i, PushMessage pushMessage) {
    }

    public AbsPayEntrancePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void registerPushListener() {
        m14124b();
        this.mUniPayManager.registerPushListener(this.mContext, f16791c);
    }

    /* access modifiers changed from: protected */
    public void unregisterPushListener() {
        m14125c();
        this.mUniPayManager.unregisterPushListener();
    }

    /* renamed from: b */
    private void m14124b() {
        this.f16793b = new PushReceiver();
        LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this.f16793b, new IntentFilter(AbsPaymentPresenter.ACTION_PAY_PUSH_MESSAGE));
    }

    /* renamed from: c */
    private void m14125c() {
        if (this.mContext != null && this.f16793b != null) {
            LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this.f16793b);
        }
    }

    private class PushReceiver extends BroadcastReceiver {
        private PushReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            PushMessage pushMessage;
            if (intent != null && AbsPayEntrancePresenter.f16791c.equals(intent.getStringExtra(UniPayManager.EXTRA_PAGE)) && (pushMessage = (PushMessage) intent.getParcelableExtra(AbsPaymentPresenter.EXTRA_PAY_PUSH_MESSAGE)) != null) {
                Logger a = AbsPayEntrancePresenter.this.f16792a;
                a.info("PushReceiver code:" + pushMessage.code + " msg:" + pushMessage.msg + " data:" + pushMessage.data + " oid:" + pushMessage.oid + " productId:" + pushMessage.productId, new Object[0]);
                AbsPayEntrancePresenter.this.handlePushReceiver(pushMessage.code, pushMessage);
            }
        }
    }
}
