package com.google.android.play.core.splitinstall;

/* renamed from: com.google.android.play.core.splitinstall.s */
final class C20210s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SplitInstallSessionState f56277a;

    /* renamed from: b */
    final /* synthetic */ int f56278b;

    /* renamed from: c */
    final /* synthetic */ int f56279c;

    /* renamed from: d */
    final /* synthetic */ C20211t f56280d;

    C20210s(C20211t tVar, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f56280d = tVar;
        this.f56277a = splitInstallSessionState;
        this.f56278b = i;
        this.f56279c = i2;
    }

    public final void run() {
        C20211t tVar = this.f56280d;
        SplitInstallSessionState splitInstallSessionState = this.f56277a;
        tVar.mo164405a(new C20166a(splitInstallSessionState.sessionId(), this.f56278b, this.f56279c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo164479a(), splitInstallSessionState.mo164480b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo164482c()));
    }
}
