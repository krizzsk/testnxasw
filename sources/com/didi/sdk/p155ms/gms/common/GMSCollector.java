package com.didi.sdk.p155ms.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.didi.sdk.p155ms.common.ICollector;
import com.didi.sdk.p155ms.common.tasks.OnFailureListener;
import com.didi.sdk.p155ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p155ms.common.utils.LogUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.instantapps.InstantApps;
import com.google.android.gms.instantapps.PackageManagerCompat;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.taxis99.R;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

@ServiceProvider(alias = "GMS", value = {ICollector.class})
/* renamed from: com.didi.sdk.ms.gms.common.GMSCollector */
public class GMSCollector extends GMSType implements ICollector {
    private static final String TAG = GMSCollector.class.getSimpleName();

    public int getMSAvailableSuccessCode() {
        return 0;
    }

    public String getMSPackageId() {
        return "com.google.android.gms";
    }

    public String getSmsReceiverAction() {
        return SmsRetriever.SMS_RETRIEVED_ACTION;
    }

    public boolean isHMSupportPreInitMap() {
        return true;
    }

    public boolean isStatusCodeSuccess(int i) {
        return i == 0;
    }

    public boolean isStatusCodeTimeout(int i) {
        return i == 15;
    }

    public boolean isSupportDeferredDeepLink() {
        return true;
    }

    public boolean isSupportSmsReceiver() {
        return true;
    }

    public boolean isMSAvailable(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context.getApplicationContext()) == 0;
    }

    public int getMSAvailableStatusCode(Context context) {
        return GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
    }

    public Intent getErrorResolutionIntent(Context context, int i, String str) {
        return GoogleApiAvailability.getInstance().getErrorResolutionIntent(context, i, str);
    }

    public boolean isUserResolvableError(int i) {
        return GoogleApiAvailability.getInstance().isUserResolvableError(i);
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, i, i2, onCancelListener);
    }

    public int getMSVersionCode() {
        return GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public void sslSecurity(Context context) {
        try {
            if (Build.VERSION.SDK_INT <= 19) {
                ProviderInstaller.installIfNeeded(context.getApplicationContext());
                SSLContext instance = SSLContext.getInstance("TLSv1.2");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                instance.createSSLEngine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "sslSecurity : exception = " + e);
        }
    }

    public void initFirebaseApp(Context context) {
        try {
            FirebaseApp.initializeApp(context.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "initFirebaseApp : exception = " + e);
        }
    }

    public void traceEvent(Context context, String str, Bundle bundle) {
        try {
            FirebaseAnalytics.getInstance(context.getApplicationContext()).logEvent(str, bundle);
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = TAG;
            LogUtil.m29854e(str2, "traceEvent : exception = " + e);
        }
    }

    public void remoteConfig(Context context, final Runnable runnable) {
        try {
            final FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
            instance.setDefaultsAsync((int) R.xml.remote_config_defaults);
            instance.fetchAndActivate().addOnCompleteListener(new OnCompleteListener<Boolean>() {
                public void onComplete(Task<Boolean> task) {
                    Runnable runnable;
                    if (instance.getBoolean("will_sign_up") && (runnable = runnable) != null) {
                        runnable.run();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "remoteConfig : exception = " + e.getMessage());
        }
    }

    public void sodaRemoteConfig(Context context, final OnSuccessListener<String> onSuccessListener) {
        try {
            final FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
            instance.setDefaultsAsync((int) R.xml.remote_config_defaults);
            instance.fetch().addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    OnSuccessListener onSuccessListener;
                    for (String next : instance.getKeysByPrefix("")) {
                        if (instance.getBoolean(next) && (onSuccessListener = onSuccessListener) != null) {
                            onSuccessListener.onSuccess(next);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            String str = TAG;
            LogUtil.m29854e(str, "remoteConfig : exception = " + e.getMessage());
        }
    }

    public String getInstantAppCookie(Context context) {
        PackageManagerCompat packageManagerCompat = InstantApps.getPackageManagerCompat(context);
        return (packageManagerCompat.getInstantAppCookie() == null || Build.VERSION.SDK_INT < 19) ? "" : new String(packageManagerCompat.getInstantAppCookie(), StandardCharsets.UTF_8);
    }

    public void clearInstantAppCookie(Context context) {
        InstantApps.getPackageManagerCompat(context).setInstantAppCookie((byte[]) null);
    }

    public void goInAppReviewFlow(Activity activity, OnFailureListener onFailureListener, OnSuccessListener<List<String>> onSuccessListener) {
        final ReviewManager create = ReviewManagerFactory.create(activity);
        com.google.android.play.core.tasks.Task<ReviewInfo> requestReviewFlow = create.requestReviewFlow();
        final com.google.android.play.core.tasks.Task<ReviewInfo> task = requestReviewFlow;
        final Activity activity2 = activity;
        final OnSuccessListener<List<String>> onSuccessListener2 = onSuccessListener;
        final OnFailureListener onFailureListener2 = onFailureListener;
        requestReviewFlow.addOnCompleteListener(new com.google.android.play.core.tasks.OnCompleteListener<ReviewInfo>() {
            public void onComplete(com.google.android.play.core.tasks.Task<ReviewInfo> task) {
                if (task.isSuccessful()) {
                    create.launchReviewFlow(activity2, (ReviewInfo) task.getResult()).addOnCompleteListener(new com.google.android.play.core.tasks.OnCompleteListener<Void>() {
                        public void onComplete(com.google.android.play.core.tasks.Task<Void> task) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(String.valueOf(task.isSuccessful()));
                            if (task.getException() != null) {
                                arrayList.add(task.getException().getMessage());
                            }
                            onSuccessListener2.onSuccess(arrayList);
                        }
                    });
                    return;
                }
                onFailureListener2.onFailure(task.getException());
            }
        });
    }

    public void createDeferredDeepLinkTask(Activity activity, Intent intent, final OnSuccessListener<Uri> onSuccessListener, final OnFailureListener onFailureListener) {
        FirebaseDynamicLinks.getInstance().getDynamicLink(intent).addOnSuccessListener(activity, new com.google.android.gms.tasks.OnSuccessListener<PendingDynamicLinkData>() {
            public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                Uri link = pendingDynamicLinkData != null ? pendingDynamicLinkData.getLink() : null;
                OnSuccessListener onSuccessListener = onSuccessListener;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(link);
                }
            }
        }).addOnFailureListener(activity, (com.google.android.gms.tasks.OnFailureListener) new com.google.android.gms.tasks.OnFailureListener() {
            public void onFailure(Exception exc) {
                OnFailureListener onFailureListener = onFailureListener;
                if (onFailureListener != null) {
                    onFailureListener.onFailure(exc);
                }
            }
        });
    }

    public boolean isSupportPlayUpdate(Context context) {
        return Build.VERSION.SDK_INT >= 21;
    }

    public void createSmsReceiverTask(Context context, final OnSuccessListener<Void> onSuccessListener, final OnFailureListener onFailureListener) {
        Task<Void> startSmsRetriever = SmsRetriever.getClient(context).startSmsRetriever();
        startSmsRetriever.addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<Void>() {
            public void onSuccess(Void voidR) {
                OnSuccessListener onSuccessListener = onSuccessListener;
                if (onSuccessListener != null) {
                    onSuccessListener.onSuccess(voidR);
                }
            }
        });
        startSmsRetriever.addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
            public void onFailure(Exception exc) {
                OnFailureListener onFailureListener = onFailureListener;
                if (onFailureListener != null) {
                    onFailureListener.onFailure(exc);
                }
            }
        });
    }

    public int getStatusCode(Intent intent) {
        Status status;
        if (intent == null || intent.getExtras() == null || (status = (Status) intent.getExtras().get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")) == null) {
            return 13;
        }
        return status.getStatusCode();
    }

    public String getSmsMessage(Intent intent) {
        return intent == null ? "" : intent.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
    }
}
