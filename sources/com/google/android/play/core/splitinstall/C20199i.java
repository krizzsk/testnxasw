package com.google.android.play.core.splitinstall;

import android.app.Activity;
import android.content.IntentSender;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C20088ck;
import com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager;
import com.google.android.play.core.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.google.android.play.core.splitinstall.i */
final class C20199i implements SplitInstallManager {

    /* renamed from: a */
    private final C20088ck<C20225w> f56257a;

    /* renamed from: b */
    private final C20088ck<FakeSplitInstallManager> f56258b;

    /* renamed from: c */
    private final C20088ck<File> f56259c;

    C20199i(C20088ck<C20225w> ckVar, C20088ck<FakeSplitInstallManager> ckVar2, C20088ck<File> ckVar3) {
        this.f56257a = ckVar;
        this.f56258b = ckVar2;
        this.f56259c = ckVar3;
    }

    /* renamed from: a */
    private final SplitInstallManager m42527a() {
        return (SplitInstallManager) (this.f56259c.mo164325a() == null ? this.f56257a : this.f56258b).mo164325a();
    }

    public final Task<Void> cancelInstall(int i) {
        return m42527a().cancelInstall(i);
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return m42527a().deferredInstall(list);
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return m42527a().deferredLanguageInstall(list);
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return m42527a().deferredLanguageUninstall(list);
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return m42527a().deferredUninstall(list);
    }

    public final Set<String> getInstalledLanguages() {
        return m42527a().getInstalledLanguages();
    }

    public final Set<String> getInstalledModules() {
        return m42527a().getInstalledModules();
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        return m42527a().getSessionState(i);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        return m42527a().getSessionStates();
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m42527a().registerListener(splitInstallStateUpdatedListener);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return m42527a().startConfirmationDialogForResult(splitInstallSessionState, activity, i);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return m42527a().startConfirmationDialogForResult(splitInstallSessionState, intentSenderForResultStarter, i);
    }

    public final Task<Integer> startInstall(SplitInstallRequest splitInstallRequest) {
        return m42527a().startInstall(splitInstallRequest);
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        m42527a().unregisterListener(splitInstallStateUpdatedListener);
    }
}
