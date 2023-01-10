package com.didi.sdk.p155ms.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.didi.sdk.p155ms.common.tasks.OnFailureListener;
import com.didi.sdk.p155ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p155ms.common.type.IMSType;
import java.util.List;

/* renamed from: com.didi.sdk.ms.common.ICollector */
public interface ICollector extends IMSType {
    void clearInstantAppCookie(Context context);

    void createDeferredDeepLinkTask(Activity activity, Intent intent, OnSuccessListener<Uri> onSuccessListener, OnFailureListener onFailureListener);

    void createSmsReceiverTask(Context context, OnSuccessListener<Void> onSuccessListener, OnFailureListener onFailureListener);

    Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener);

    Intent getErrorResolutionIntent(Context context, int i, String str);

    String getInstantAppCookie(Context context);

    int getMSAvailableStatusCode(Context context);

    int getMSAvailableSuccessCode();

    String getMSPackageId();

    int getMSVersionCode();

    String getSmsMessage(Intent intent);

    String getSmsReceiverAction();

    int getStatusCode(Intent intent);

    void goInAppReviewFlow(Activity activity, OnFailureListener onFailureListener, OnSuccessListener<List<String>> onSuccessListener);

    void initFirebaseApp(Context context);

    boolean isHMSupportPreInitMap();

    boolean isMSAvailable(Context context);

    boolean isStatusCodeSuccess(int i);

    boolean isStatusCodeTimeout(int i);

    boolean isSupportDeferredDeepLink();

    boolean isSupportPlayUpdate(Context context);

    boolean isSupportSmsReceiver();

    boolean isUserResolvableError(int i);

    void remoteConfig(Context context, Runnable runnable);

    void sodaRemoteConfig(Context context, OnSuccessListener<String> onSuccessListener);

    void sslSecurity(Context context);

    void traceEvent(Context context, String str, Bundle bundle);
}
