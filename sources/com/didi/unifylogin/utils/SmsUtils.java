package com.didi.unifylogin.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.tasks.OnFailureListener;
import com.didi.sdk.p155ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import com.didi.unifylogin.utils.autologin.AppSignatureHashHelper;
import com.didi.unifylogin.utils.autologin.SmsReceiver;

public class SmsUtils {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static SmsReceiver f47603a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICollector f47604b = ((ICollector) ServiceUtil.getServiceImp(ICollector.class));

    public void registeSmsRetriever(final Context context, final SmsReceiver.SmsReceiverListener smsReceiverListener) {
        ICollector iCollector;
        AppSignatureHashHelper appSignatureHashHelper = new AppSignatureHashHelper(context);
        LoginLog.write(SmsReceiver.TAG, "registeSmsRetriever HashKey: " + appSignatureHashHelper.getAppSignatures().get(0));
        if (context != null && smsReceiverListener != null && (iCollector = this.f47604b) != null && iCollector.isSupportSmsReceiver()) {
            this.f47604b.createSmsReceiverTask(context, new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    LoginLog.write("SmsReceiver SmsRetriever Success Listen");
                    if (SmsUtils.f47603a == null && SmsUtils.this.f47604b != null) {
                        SmsReceiver unused = SmsUtils.f47603a = new SmsReceiver();
                        SmsUtils.f47603a.setListener(smsReceiverListener);
                        try {
                            context.registerReceiver(SmsUtils.f47603a, new IntentFilter(SmsUtils.this.f47604b.getSmsReceiverAction()));
                        } catch (Exception e) {
                            Log.d("Context", "registerReceiver", e);
                        }
                        LoginLog.write(SmsReceiver.TAG, "SmsRetriever Success Listen");
                    }
                }
            }, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    LoginLog.write(SmsReceiver.TAG, "SmsRetriever Failure Listen");
                    exc.printStackTrace();
                }
            });
        }
    }

    public void unRegisteSmsRetriever(Context context) {
        SmsReceiver smsReceiver;
        LoginLog.write(SmsReceiver.TAG, "unRegisteSmsRetriever");
        if (!(context == null || (smsReceiver = f47603a) == null)) {
            try {
                context.unregisterReceiver(smsReceiver);
            } catch (Exception e) {
                try {
                    Log.d("Context", "unregisterReceiver", e);
                } catch (Exception e2) {
                    LoginLog.write(SmsReceiver.TAG, "unRegisteSmsRetriever:" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        }
        f47603a = null;
    }
}
