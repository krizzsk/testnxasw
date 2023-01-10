package com.didi.sdk.apm;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.didi.quicksilver.QuicksilverPreferencesHelper;
import com.didi.sdk.apm.SystemServiceHelper;
import com.didi.sdk.apm.canvas.CanvasHelper;
import com.didi.sdk.apm.utils.Objects;
import com.didi.sdk.apm.utils.PendingResultHelper;
import com.didi.sdk.apm.utils.RemoteConfiguration;
import com.didi.sdk.apm.utils.ThreadUtils;
import com.didi.sdk.apm.utils.ToastCompat;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.apollo.sdk.Apollo;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class SystemUtils {
    public static final boolean DEFAULT_APM_FIREBASEINSTANCEIDRECEIVER = true;
    public static final boolean DEFAULT_APM_GETACTIVENETWORKINFO = true;
    public static final boolean DEFAULT_APM_GETDEVICEID = false;
    public static final boolean DEFAULT_APM_GETPACKAGEINFO = true;
    public static final boolean DEFAULT_APM_GETSYSTEMSERVICE = false;
    public static final boolean DEFAULT_APM_SHOWDIALOG = true;
    public static final boolean DEFAULT_APM_THREAD_HOOK = false;
    public static final boolean DEFAULT_APM_TOAST_SHOW = true;
    public static final boolean DEFAULT_FIREBASEINSTANCE_ID_RECEIVER_OPEN = false;
    public static final boolean DEFAULT_FIREBASE_HOOK = false;
    public static final boolean DEFAULT_NETWORK_CHANGED_RECEIVER_OPEN = false;
    public static final boolean DEFAULT_SP_COMMIT2APPLY = false;
    public static final boolean DEFAULT_USE_QUICKSILVER = true;
    public static final String KEY_GETACTIVENETWORKINFO_EXPIRE = "expire";
    public static final String TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER = "global_app_apm_firebaseinstanceidreceiver";
    public static final String TOGGLE_FIREBASEINSTANCE_ID_RECEIVER_AB = "global_firebaseinstance_id_receiver_ab";
    public static final String TOGGLE_FIREBASE_HOOK = "global_app_apm_firebase_hook";
    public static final String TOGGLE_NETWORK_CHANGED_RECEIVER_AB = "global_network_changed_receiver_ab";

    /* renamed from: a */
    private static final String f37706a = "ApmSystemUtils";

    /* renamed from: b */
    private static final String f37707b = "global_app_use_quicksilver";

    /* renamed from: c */
    private static final String f37708c = "global_app_sp_commit2apply";

    /* renamed from: d */
    private static final String f37709d = "global_app_apm_getdeviceid";

    /* renamed from: e */
    private static final String f37710e = "global_app_apm_getpackageinfo";

    /* renamed from: f */
    private static final String f37711f = "global_app_apm_showdialog";

    /* renamed from: g */
    private static final String f37712g = "global_app_apm_getsystemservice";

    /* renamed from: h */
    private static final String f37713h = "global_app_apm_getactivenetworkinfo";

    /* renamed from: i */
    private static final String f37714i = "global_app_apm_toast_show";

    /* renamed from: j */
    private static final String f37715j = "global_app_apm_thread_hook";

    /* renamed from: k */
    private static final String f37716k = "getactivenetworkinfo_expire";

    /* renamed from: l */
    private static final String f37717l = "sp_name_set";

    /* renamed from: m */
    private static Logger f37718m = LoggerFactory.getLogger(f37706a);

    /* renamed from: n */
    private static Map<String, Object> f37719n = new ConcurrentHashMap();

    /* renamed from: o */
    private static Object f37720o = new Object();

    /* renamed from: p */
    private static Context f37721p;

    /* renamed from: q */
    private static Handler f37722q = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    static void m28437a(Context context) {
        try {
            f37719n.put(TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER, Boolean.valueOf(RemoteConfiguration.isOpen(TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER, true)));
            f37719n.put(f37714i, Boolean.valueOf(RemoteConfiguration.isOpen(f37714i, true)));
            f37719n.put(f37715j, Boolean.valueOf(RemoteConfiguration.isOpen(f37715j, false)));
            f37719n.put(TOGGLE_FIREBASE_HOOK, Boolean.valueOf(RemoteConfiguration.isOpen(TOGGLE_FIREBASE_HOOK, false)));
            f37719n.put(TOGGLE_NETWORK_CHANGED_RECEIVER_AB, Boolean.valueOf(RemoteConfiguration.isOpen(TOGGLE_NETWORK_CHANGED_RECEIVER_AB, false)));
            f37719n.put(TOGGLE_FIREBASEINSTANCE_ID_RECEIVER_AB, Boolean.valueOf(RemoteConfiguration.isOpen(TOGGLE_FIREBASEINSTANCE_ID_RECEIVER_AB, false)));
            f37721p = context;
            Logger logger = f37718m;
            logger.debug("init finish apollo extra:" + f37719n, new Object[0]);
        } catch (Throwable th) {
            Log.e(f37706a, "init error:  ", th);
        }
    }

    /* renamed from: a */
    private static <T> T m28436a(String str, T t) {
        T t2 = f37719n.get(str);
        return t2 == null ? t : t2;
    }

    public static Context getContext() {
        return f37721p;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, int i) {
        if (((Boolean) m28436a(f37707b, true)).booleanValue()) {
            return QuicksilverPreferencesHelper.getSharedPreferences(context, str, i);
        }
        return context.getSharedPreferences(str, i);
    }

    public static SharedPreferences getPreferences(Activity activity, int i) {
        return getSharedPreferences(activity, activity.getLocalClassName(), i);
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return getSharedPreferences(context, context.getPackageName() + "_preferences", 0);
    }

    public static String getDeviceId(TelephonyManager telephonyManager) {
        if (!((Boolean) m28436a(f37709d, false)).booleanValue()) {
            return telephonyManager.getDeviceId();
        }
        return SystemServiceHelper.TelephonyManager.getDeviceId(telephonyManager);
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        if (packageManager == null || str == null) {
            return null;
        }
        if (!((Boolean) m28436a(f37710e, true)).booleanValue()) {
            return packageManager.getPackageInfo(str, i);
        }
        return SystemServiceHelper.PackageManager.getPackageInfo(packageManager, str, i);
    }

    public static ApplicationInfo getApplicationInfo(PackageManager packageManager, String str, int i) throws PackageManager.NameNotFoundException {
        if (packageManager == null || str == null) {
            return null;
        }
        if (!((Boolean) m28436a(f37710e, true)).booleanValue()) {
            return packageManager.getApplicationInfo(str, i);
        }
        return SystemServiceHelper.PackageManager.getApplicationInfo(packageManager, str, i);
    }

    public static List<ApplicationInfo> getAppEmptyList() {
        return new ArrayList();
    }

    public static RequestManager with(Context context) {
        if (context == null) {
            return Glide.with(getContext());
        }
        if (context instanceof Activity) {
            return with((Activity) context);
        }
        return Glide.with(context);
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            return Glide.with(getContext());
        }
        return with((Activity) fragmentActivity);
    }

    public static RequestManager with(Activity activity) {
        if (activity == null) {
            return Glide.with(getContext());
        }
        if (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed()) {
            return Glide.with(activity);
        }
        return Glide.with(activity.getApplicationContext());
    }

    public static BroadcastReceiver.PendingResult goAsync(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver == null) {
            return null;
        }
        if (!((Boolean) m28436a(TOGGLE_APM_FIREBASEINSTANCEIDRECEIVER, true)).booleanValue()) {
            return broadcastReceiver.goAsync();
        }
        f37718m.info("PendingResult#goAsync via apm SystemUtils", new Object[0]);
        return FirebaseInstanceIdReceiverHelper.goAsync(broadcastReceiver);
    }

    public static void pendingResultFinish(BroadcastReceiver.PendingResult pendingResult) {
        if (pendingResult != null) {
            try {
                f37718m.info("PendingResult#finish via apm SystemUtils", new Object[0]);
                PendingResultHelper.finish(pendingResult);
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    String message = e.getMessage();
                    if (!TextUtils.isEmpty(message) && message.contains("Broadcast already finished")) {
                        Log.e(f37706a, "PendingResult#finish must be call once,after Hook PendingResult#finish may called several times, so catch this error!");
                    }
                }
            }
        }
    }

    public static void showToast(Toast toast) {
        if (((Boolean) m28436a(f37714i, true)).booleanValue()) {
            ToastCompat.showToast(toast);
            return;
        }
        if (!ToastCompatHelper.sIsInit) {
            ToastCompatHelper.hook();
        }
        toast.show();
    }

    public static void showDialog(Dialog dialog) {
        if (dialog != null) {
            if (!((Boolean) m28436a(f37711f, true)).booleanValue()) {
                try {
                    dialog.show();
                } catch (Exception e) {
                    Log.d(f37706a, "showDialog", e);
                }
            } else {
                Context context = dialog.getContext();
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    if (context instanceof ContextWrapper) {
                        ContextWrapper contextWrapper = (ContextWrapper) context;
                        if ((contextWrapper.getBaseContext() instanceof Activity) && ((Activity) contextWrapper.getBaseContext()).isFinishing()) {
                            Log.w(f37706a, "showDialog: activity isFinishing ");
                            return;
                        }
                    }
                    try {
                        dialog.show();
                    } catch (Exception e2) {
                        Log.d(f37706a, "showDialog", e2);
                    }
                } else {
                    Log.w(f37706a, "showDialog: activity isFinishing ");
                }
            }
        }
    }

    public static void showDialogFragmentManager(DialogFragment dialogFragment, FragmentManager fragmentManager, String str) {
        if (dialogFragment != null && fragmentManager != null && str != null) {
            if (!((Boolean) m28436a(f37711f, true)).booleanValue()) {
                try {
                    dialogFragment.show(fragmentManager, str);
                } catch (Exception e) {
                    Log.d(f37706a, "showDialogFragmentManager", e);
                }
            } else {
                Activity activity = dialogFragment.getActivity();
                if (activity == null) {
                    Log.w(f37706a, "showDialogFragment: activity is null ");
                } else if (activity.isFinishing()) {
                    Log.w(f37706a, "showDialogFragment: activity isFinishing ");
                } else {
                    try {
                        dialogFragment.show(fragmentManager, str);
                    } catch (Exception e2) {
                        Log.d(f37706a, "showDialogFragmentManager", e2);
                    }
                }
            }
        }
    }

    public static int showDialogFragmentTransaction(DialogFragment dialogFragment, FragmentTransaction fragmentTransaction, String str) {
        if (dialogFragment == null || fragmentTransaction == null || str == null) {
            return 0;
        }
        if (!((Boolean) m28436a(f37711f, true)).booleanValue()) {
            return dialogFragment.show(fragmentTransaction, str);
        }
        Activity activity = dialogFragment.getActivity();
        if (activity == null) {
            Log.w(f37706a, "showDialogFragment: activity is null ");
            return 0;
        } else if (!activity.isFinishing()) {
            return dialogFragment.show(fragmentTransaction, str);
        } else {
            Log.w(f37706a, "showDialogFragment: activity isFinishing ");
            return 0;
        }
    }

    public static void showSupportDialogFragmentManager(androidx.fragment.app.DialogFragment dialogFragment, androidx.fragment.app.FragmentManager fragmentManager, String str) {
        if (dialogFragment != null && fragmentManager != null && str != null) {
            if (!((Boolean) m28436a(f37711f, true)).booleanValue()) {
                try {
                    dialogFragment.show(fragmentManager, str);
                } catch (Exception e) {
                    Log.d(f37706a, "showSupportDialogFragmentManager", e);
                }
            } else {
                FragmentActivity activity = dialogFragment.getActivity();
                if (activity == null) {
                    Log.w(f37706a, "showDialogFragment: activity is null ");
                } else if (activity.isFinishing()) {
                    Log.w(f37706a, "showDialogFragment: activity isFinishing ");
                } else {
                    try {
                        dialogFragment.show(fragmentManager, str);
                    } catch (Exception e2) {
                        Log.d(f37706a, "showSupportDialogFragmentManager", e2);
                    }
                }
            }
        }
    }

    public static int showSupportDialogFragmentTransaction(androidx.fragment.app.DialogFragment dialogFragment, androidx.fragment.app.FragmentTransaction fragmentTransaction, String str) {
        if (dialogFragment == null || fragmentTransaction == null || str == null) {
            return 0;
        }
        if (!((Boolean) m28436a(f37711f, true)).booleanValue()) {
            return dialogFragment.show(fragmentTransaction, str);
        }
        FragmentActivity activity = dialogFragment.getActivity();
        if (activity == null) {
            Log.w(f37706a, "showDialogFragment: activity is null ");
            return 0;
        } else if (!activity.isFinishing()) {
            return dialogFragment.show(fragmentTransaction, str);
        } else {
            Log.w(f37706a, "showDialogFragment: activity isFinishing ");
            return 0;
        }
    }

    public static boolean commitSharedPreferencesEditor(SharedPreferences.Editor editor) {
        if (!((Boolean) m28436a(f37708c, false)).booleanValue()) {
            return editor.commit();
        }
        editor.apply();
        return true;
    }

    public static int log(int i, String str, String str2, Throwable th, String str3, int i2) {
        LoggerFactory.getLogger(str).log(i == 4 ? 3 : i, str2, th, str3, i2);
        return 0;
    }

    public static int log(int i, String str, String str2, String str3, int i2) {
        LoggerFactory.getLogger(str).log(i == 4 ? 3 : i, str2, (Throwable) null, str3, i2);
        return 0;
    }

    public static Object getSystemService(Context context, String str) {
        Objects.requireNonNull(context);
        Objects.requireNonNull(str);
        if (((Boolean) m28436a(f37712g, false)).booleanValue()) {
            return SystemServiceHelper.m28433a(context, str);
        }
        return context.getSystemService(str);
    }

    public static NetworkInfo getActiveNetworkInfo(ConnectivityManager connectivityManager) {
        Objects.requireNonNull(connectivityManager);
        if (((Boolean) m28436a(f37713h, true)).booleanValue()) {
            return SystemServiceHelper.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    public static void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        ThreadUtils.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public static void setThreadPriority(Thread thread, int i) {
        ThreadUtils.setPriority(thread, i);
    }

    public static void setProcessThreadPriority(int i) {
        ThreadUtils.setProcessThreadPriority(i);
    }

    public static void setProcessThreadPriority(int i, int i2) {
        ThreadUtils.setProcessThreadPriority(i, i2);
    }

    public static void startThread(Thread thread) {
        if (((Boolean) m28436a(f37715j, false)).booleanValue()) {
            ThreadUtils.start(thread);
        } else {
            thread.start();
        }
    }

    public static void excuteThreadPool(ThreadPoolExecutor threadPoolExecutor, Runnable runnable) {
        if (((Boolean) m28436a(f37715j, false)).booleanValue()) {
            ThreadUtils.excuteThreadPool(threadPoolExecutor, runnable);
        } else {
            threadPoolExecutor.execute(runnable);
        }
    }

    public static void startActivity(Fragment fragment, Intent intent) {
        Objects.requireNonNull(fragment);
        C12710b.m28459a(fragment, intent);
    }

    public static void startActivity(Fragment fragment, Intent intent, Bundle bundle) {
        Objects.requireNonNull(fragment);
        C12710b.m28462a(fragment, intent, bundle);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i) {
        Objects.requireNonNull(fragment);
        C12710b.m28460a(fragment, intent, i);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i, Bundle bundle) {
        Objects.requireNonNull(fragment);
        C12710b.m28461a(fragment, intent, i, bundle);
    }

    public static void startIntentSenderForResult(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Objects.requireNonNull(fragment);
        C12710b.m28463a(fragment, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void startActivity(android.app.Fragment fragment, Intent intent) {
        Objects.requireNonNull(fragment);
        C12710b.m28454a(fragment, intent);
    }

    public static void startActivity(android.app.Fragment fragment, Intent intent, Bundle bundle) {
        Objects.requireNonNull(fragment);
        C12710b.m28457a(fragment, intent, bundle);
    }

    public static void startActivityForResult(android.app.Fragment fragment, Intent intent, int i) {
        Objects.requireNonNull(fragment);
        C12710b.m28455a(fragment, intent, i);
    }

    public static void startActivityForResult(android.app.Fragment fragment, Intent intent, int i, Bundle bundle) {
        Objects.requireNonNull(fragment);
        C12710b.m28456a(fragment, intent, i, bundle);
    }

    public static void startIntentSenderForResult(android.app.Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        Objects.requireNonNull(fragment);
        C12710b.m28458a(fragment, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public static void hookOnlyFullscreenOpaque(Activity activity) {
        if (activity != null) {
            FullscreenOpaqueHelper.hookOnlyFullscreenOpaque(activity);
        }
    }

    public static int saveLayer(Canvas canvas, RectF rectF, Paint paint, int i) {
        return CanvasHelper.saveLayer(canvas, rectF, paint, i);
    }

    public static void hookSetRequestedOrientation(Activity activity, int i) {
        if (activity != null) {
            FullscreenOpaqueHelper.hookSetRequestedOrientation(activity, i);
        }
    }

    public static boolean isNetworkChangedByAsyncExecute() {
        return ((Boolean) m28436a(TOGGLE_NETWORK_CHANGED_RECEIVER_AB, false)).booleanValue();
    }

    public static boolean isFirebaseInstanceIdReceiverByAsyncExecute() {
        return ((Boolean) m28436a(TOGGLE_FIREBASEINSTANCE_ID_RECEIVER_AB, false)).booleanValue();
    }

    public static File getExternalStorageDirectory() {
        return SystemServiceHelper.Environment.getExternalStorageDirectory();
    }

    /* renamed from: a */
    private static void m28438a(Intent intent) {
        if (intent != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("action", intent.getAction());
                hashMap.put("extras", intent.getExtras() != null ? intent.getExtras().toString() : "");
                LoggerFactory.getLogger("Firebase").info("zza enter", (Map<?, ?>) hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isOrderedBroadcast(CloudMessagingReceiver cloudMessagingReceiver) {
        Log.d(f37706a, "isOrderedBroadcast:" + cloudMessagingReceiver);
        if (((Boolean) m28436a(TOGGLE_FIREBASE_HOOK, false)).booleanValue()) {
            int intValue = ((Integer) Apollo.getToggle(TOGGLE_FIREBASE_HOOK).getExperiment().getParam("delay", 2000)).intValue();
            Log.d(f37706a, "firebase hook enter:" + intValue);
            final BroadcastReceiver.PendingResult goAsync = cloudMessagingReceiver.goAsync();
            f37722q.postDelayed(new Runnable() {
                public void run() {
                    Log.d(SystemUtils.f37706a, "isOrderedBroadcast:  finish:" + goAsync);
                    PendingResultHelper.finish(goAsync);
                }
            }, (long) intValue);
            Log.d(f37706a, "firebase hook leave");
        }
        return cloudMessagingReceiver.isOrderedBroadcast();
    }
}
