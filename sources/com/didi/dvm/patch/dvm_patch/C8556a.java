package com.didi.dvm.patch.dvm_patch;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.PrintStream;
import java.util.Map;

/* renamed from: com.didi.dvm.patch.dvm_patch.a */
/* compiled from: EventTracker */
class C8556a extends EventTracker {
    C8556a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo63966a(String str, Map map) {
        PrintStream printStream = System.out;
        printStream.println("dvm_patch " + str + ",attr=" + map);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) map);
    }
}
