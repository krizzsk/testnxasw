package com.didi.unifylogin.utils.autologin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import com.didi.unifylogin.utils.LoginLog;

public class SmsReceiver extends BroadcastReceiver {
    public static final String TAG = "SmsReceiver";

    /* renamed from: a */
    private SmsReceiverListener f47608a;

    /* renamed from: b */
    private ICollector f47609b = ((ICollector) ServiceUtil.getServiceImp(ICollector.class));

    public interface SmsReceiverListener {
        void handleSmsCode(String str);
    }

    public void setListener(SmsReceiverListener smsReceiverListener) {
        this.f47608a = smsReceiverListener;
    }

    public void onReceive(Context context, Intent intent) {
        ICollector iCollector = this.f47609b;
        if (iCollector != null && !TextUtils.isEmpty(iCollector.getSmsReceiverAction()) && this.f47609b.getSmsReceiverAction().equals(intent.getAction())) {
            LoginLog.write(TAG, "onReceive:" + this.f47609b.getSmsReceiverAction());
            int statusCode = this.f47609b.getStatusCode(intent);
            if (this.f47609b.isStatusCodeSuccess(statusCode)) {
                if (this.f47608a != null) {
                    String smsMessage = this.f47609b.getSmsMessage(intent);
                    LoginLog.write("SmsReceiveronReceive: " + smsMessage);
                    this.f47608a.handleSmsCode(CodeMatcher.getCode(smsMessage));
                }
            } else if (this.f47609b.isStatusCodeTimeout(statusCode)) {
                LoginLog.write(TAG, "onReceive: TIMEOUT");
            }
        }
    }
}
