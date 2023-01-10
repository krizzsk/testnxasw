package com.google.android.play.core.splitinstall.testing;

import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallRequest;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import java.util.ArrayList;

/* renamed from: com.google.android.play.core.splitinstall.testing.d */
final /* synthetic */ class C20215d implements C20221j {

    /* renamed from: a */
    private final SplitInstallRequest f56311a;

    C20215d(SplitInstallRequest splitInstallRequest) {
        this.f56311a = splitInstallRequest;
    }

    /* renamed from: a */
    public final SplitInstallSessionState mo164526a(SplitInstallSessionState splitInstallSessionState) {
        SplitInstallRequest splitInstallRequest = this.f56311a;
        int i = FakeSplitInstallManager.f56284a;
        if (splitInstallSessionState == null || splitInstallSessionState.hasTerminalStatus()) {
            return SplitInstallSessionState.create(splitInstallSessionState == null ? 1 : 1 + splitInstallSessionState.sessionId(), 1, 0, 0, 0, splitInstallRequest.getModuleNames(), new ArrayList());
        }
        throw new SplitInstallException(-1);
    }
}
