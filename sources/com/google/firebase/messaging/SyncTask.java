package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import com.didi.dimina.container.bridge.network.NetWorkStateReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class SyncTask implements Runnable {
    /* access modifiers changed from: private */
    public final FirebaseMessaging firebaseMessaging;
    private final long nextDelaySeconds;
    ExecutorService processorExecutor = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));
    private final PowerManager.WakeLock syncWakeLock;

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {
        @Nullable
        private SyncTask task;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.task = syncTask;
        }

        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.task;
            if (syncTask != null && syncTask.isDeviceConnected()) {
                if (SyncTask.isDebugLogEnabled()) {
                    SystemUtils.log(3, Constants.TAG, "Connectivity changed. Starting background sync.", (Throwable) null, "com.google.firebase.messaging.SyncTask$ConnectivityChangeReceiver", 3);
                }
                this.task.firebaseMessaging.enqueueTaskWithDelaySeconds(this.task, 0);
                try {
                    this.task.getContext().unregisterReceiver(this);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
                this.task = null;
            }
        }

        public void registerReceiver() {
            if (SyncTask.isDebugLogEnabled()) {
                SystemUtils.log(3, Constants.TAG, "Connectivity change received registered", (Throwable) null, "com.google.firebase.messaging.SyncTask$ConnectivityChangeReceiver", 2);
            }
            try {
                this.task.getContext().registerReceiver(this, new IntentFilter(NetWorkStateReceiver.ANDROID_NET_CHANGE_ACTION));
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    public SyncTask(FirebaseMessaging firebaseMessaging2, long j) {
        this.firebaseMessaging = firebaseMessaging2;
        this.nextDelaySeconds = j;
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.syncWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    static boolean isDebugLogEnabled() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Context getContext() {
        return this.firebaseMessaging.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    public boolean isDeviceConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? SystemUtils.getActiveNetworkInfo(connectivityManager) : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: package-private */
    public boolean maybeRefreshToken() throws IOException {
        try {
            if (this.firebaseMessaging.blockingGetToken() == null) {
                SystemUtils.log(6, Constants.TAG, "Token retrieval failed: null", (Throwable) null, "com.google.firebase.messaging.SyncTask", 2);
                return false;
            } else if (!Log.isLoggable(Constants.TAG, 3)) {
                return true;
            } else {
                SystemUtils.log(3, Constants.TAG, "Token successfully retrieved", (Throwable) null, "com.google.firebase.messaging.SyncTask", 4);
                return true;
            }
        } catch (IOException e) {
            if (GmsRpc.isErrorMessageForRetryableError(e.getMessage())) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                sb.append("Token retrieval failed: ");
                sb.append(message);
                sb.append(". Will retry token retrieval");
                SystemUtils.log(5, Constants.TAG, sb.toString(), (Throwable) null, "com.google.firebase.messaging.SyncTask", 7);
                return false;
            } else if (e.getMessage() == null) {
                SystemUtils.log(5, Constants.TAG, "Token retrieval failed without exception message. Will retry token retrieval", (Throwable) null, "com.google.firebase.messaging.SyncTask", 9);
                return false;
            } else {
                throw e;
            }
        } catch (SecurityException unused) {
            SystemUtils.log(5, Constants.TAG, "Token retrieval failed with SecurityException. Will retry token retrieval", (Throwable) null, "com.google.firebase.messaging.SyncTask", 5);
            return false;
        }
    }

    public void run() {
        if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
            this.syncWakeLock.acquire();
        }
        try {
            this.firebaseMessaging.setSyncScheduledOrRunning(true);
            if (!this.firebaseMessaging.isGmsCorePresent()) {
                this.firebaseMessaging.setSyncScheduledOrRunning(false);
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            } else if (!ServiceStarter.getInstance().hasAccessNetworkStatePermission(getContext()) || isDeviceConnected()) {
                if (maybeRefreshToken()) {
                    this.firebaseMessaging.setSyncScheduledOrRunning(false);
                } else {
                    this.firebaseMessaging.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                    return;
                }
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            SystemUtils.log(6, Constants.TAG, sb.toString(), (Throwable) null, "com.google.firebase.messaging.SyncTask", 16);
            this.firebaseMessaging.setSyncScheduledOrRunning(false);
            if (!ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                return;
            }
        } catch (Throwable th) {
            if (ServiceStarter.getInstance().hasWakeLockPermission(getContext())) {
                this.syncWakeLock.release();
            }
            throw th;
        }
        this.syncWakeLock.release();
    }
}
