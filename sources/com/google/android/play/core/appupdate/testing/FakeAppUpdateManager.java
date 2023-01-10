package com.google.android.play.core.appupdate.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.appupdate.C19863a;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;

public class FakeAppUpdateManager implements AppUpdateManager {

    /* renamed from: a */
    private final C19863a f55601a;

    /* renamed from: b */
    private final Context f55602b;

    /* renamed from: c */
    private int f55603c = 0;

    /* renamed from: d */
    private int f55604d = 0;

    /* renamed from: e */
    private boolean f55605e = false;

    /* renamed from: f */
    private int f55606f = 0;

    /* renamed from: g */
    private Integer f55607g = null;

    /* renamed from: h */
    private int f55608h = 0;

    /* renamed from: i */
    private long f55609i = 0;

    /* renamed from: j */
    private long f55610j = 0;

    /* renamed from: k */
    private boolean f55611k = false;

    /* renamed from: l */
    private boolean f55612l = false;

    /* renamed from: m */
    private boolean f55613m = false;

    /* renamed from: n */
    private Integer f55614n;

    public FakeAppUpdateManager(Context context) {
        this.f55601a = new C19863a(context);
        this.f55602b = context;
    }

    /* renamed from: a */
    private final int m41788a() {
        if (!this.f55605e) {
            return 1;
        }
        int i = this.f55603c;
        return (i == 0 || i == 4 || i == 5 || i == 6) ? 2 : 3;
    }

    /* renamed from: a */
    private final boolean m41789a(AppUpdateInfo appUpdateInfo, AppUpdateOptions appUpdateOptions) {
        int i;
        if (!appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) && (!AppUpdateOptions.defaultOptions(appUpdateOptions.appUpdateType()).equals(appUpdateOptions) || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions.appUpdateType()))) {
            return false;
        }
        if (appUpdateOptions.appUpdateType() == 1) {
            this.f55612l = true;
            i = 1;
        } else {
            this.f55611k = true;
            i = 0;
        }
        this.f55614n = i;
        return true;
    }

    /* renamed from: b */
    private final void m41790b() {
        this.f55601a.mo164405a(InstallState.m42117a(this.f55603c, this.f55609i, this.f55610j, this.f55604d, this.f55602b.getPackageName()));
    }

    public Task<Void> completeUpdate() {
        int i = this.f55604d;
        if (i != 0) {
            return Tasks.m42595a((Exception) new InstallException(i));
        }
        int i2 = this.f55603c;
        if (i2 != 11) {
            return i2 == 3 ? Tasks.m42595a((Exception) new InstallException(-8)) : Tasks.m42595a((Exception) new InstallException(-7));
        }
        this.f55603c = 3;
        this.f55613m = true;
        Integer num = 0;
        if (num.equals(this.f55614n)) {
            m41790b();
        }
        return Tasks.m42596a(null);
    }

    public void downloadCompletes() {
        int i = this.f55603c;
        if (i == 2 || i == 1) {
            this.f55603c = 11;
            this.f55609i = 0;
            this.f55610j = 0;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
                return;
            }
            Integer num2 = 1;
            if (num2.equals(this.f55614n)) {
                completeUpdate();
            }
        }
    }

    public void downloadFails() {
        int i = this.f55603c;
        if (i == 1 || i == 2) {
            this.f55603c = 5;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
            this.f55614n = null;
            this.f55612l = false;
            this.f55603c = 0;
        }
    }

    public void downloadStarts() {
        if (this.f55603c == 1) {
            this.f55603c = 2;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
        }
    }

    public Task<AppUpdateInfo> getAppUpdateInfo() {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        PendingIntent pendingIntent3;
        PendingIntent pendingIntent4;
        int i = this.f55604d;
        if (i != 0) {
            return Tasks.m42595a((Exception) new InstallException(i));
        }
        if (m41788a() == 2 && this.f55604d == 0) {
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f55602b, 0, new Intent(), 0);
            PendingIntent broadcast2 = PendingIntent.getBroadcast(this.f55602b, 0, new Intent(), 0);
            PendingIntent broadcast3 = PendingIntent.getBroadcast(this.f55602b, 0, new Intent(), 0);
            pendingIntent3 = broadcast;
            pendingIntent4 = broadcast2;
            pendingIntent2 = PendingIntent.getBroadcast(this.f55602b, 0, new Intent(), 0);
            pendingIntent = broadcast3;
        } else {
            pendingIntent4 = null;
            pendingIntent3 = null;
            pendingIntent2 = null;
            pendingIntent = null;
        }
        return Tasks.m42596a(AppUpdateInfo.m41745a(this.f55602b.getPackageName(), this.f55606f, m41788a(), this.f55603c, this.f55607g, this.f55608h, this.f55609i, this.f55610j, 0, 0, pendingIntent4, pendingIntent3, pendingIntent2, pendingIntent));
    }

    public Integer getTypeForUpdateInProgress() {
        return this.f55614n;
    }

    public void installCompletes() {
        if (this.f55603c == 3) {
            this.f55603c = 4;
            this.f55605e = false;
            this.f55606f = 0;
            this.f55607g = null;
            this.f55608h = 0;
            this.f55609i = 0;
            this.f55610j = 0;
            this.f55612l = false;
            this.f55613m = false;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
            this.f55614n = null;
            this.f55603c = 0;
        }
    }

    public void installFails() {
        if (this.f55603c == 3) {
            this.f55603c = 5;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
            this.f55614n = null;
            this.f55613m = false;
            this.f55612l = false;
            this.f55603c = 0;
        }
    }

    public boolean isConfirmationDialogVisible() {
        return this.f55611k;
    }

    public boolean isImmediateFlowVisible() {
        return this.f55612l;
    }

    public boolean isInstallSplashScreenVisible() {
        return this.f55613m;
    }

    public void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f55601a.mo164404a(installStateUpdatedListener);
    }

    public void setBytesDownloaded(long j) {
        if (this.f55603c == 2 && j <= this.f55610j) {
            this.f55609i = j;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
        }
    }

    public void setClientVersionStalenessDays(Integer num) {
        if (this.f55605e) {
            this.f55607g = num;
        }
    }

    public void setInstallErrorCode(int i) {
        this.f55604d = i;
    }

    public void setTotalBytesToDownload(long j) {
        if (this.f55603c == 2) {
            this.f55610j = j;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
        }
    }

    public void setUpdateAvailable(int i) {
        this.f55605e = true;
        this.f55606f = i;
    }

    public void setUpdateNotAvailable() {
        this.f55605e = false;
        this.f55607g = null;
    }

    public void setUpdatePriority(int i) {
        if (this.f55605e) {
            this.f55608h = i;
        }
    }

    public final Task<Integer> startUpdateFlow(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions) {
        return m41789a(appUpdateInfo, appUpdateOptions) ? Tasks.m42596a(-1) : Tasks.m42595a((Exception) new InstallException(-6));
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, Activity activity, int i2) {
        return m41789a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i, IntentSenderForResultStarter intentSenderForResultStarter, int i2) {
        return m41789a(appUpdateInfo, AppUpdateOptions.newBuilder(i).build());
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, Activity activity, AppUpdateOptions appUpdateOptions, int i) {
        return m41789a(appUpdateInfo, appUpdateOptions);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i) {
        return m41789a(appUpdateInfo, appUpdateOptions);
    }

    public void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.f55601a.mo164407b(installStateUpdatedListener);
    }

    public void userAcceptsUpdate() {
        if (this.f55611k || this.f55612l) {
            this.f55611k = false;
            this.f55603c = 1;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
        }
    }

    public void userCancelsDownload() {
        int i = this.f55603c;
        if (i == 1 || i == 2) {
            this.f55603c = 6;
            Integer num = 0;
            if (num.equals(this.f55614n)) {
                m41790b();
            }
            this.f55614n = null;
            this.f55612l = false;
            this.f55603c = 0;
        }
    }

    public void userRejectsUpdate() {
        if (this.f55611k || this.f55612l) {
            this.f55611k = false;
            this.f55612l = false;
            this.f55614n = null;
            this.f55603c = 0;
        }
    }
}
