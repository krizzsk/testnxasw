package com.didiglobal.ddmirror;

import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.ddmirror.uichecker.UiChecker;
import com.didiglobal.ddmirror.utils.DDMirrorDebugger;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: DDMirror.kt */
final class DDMirror$Companion$doCheck$1 implements Runnable {
    final /* synthetic */ String $eventId;

    DDMirror$Companion$doCheck$1(String str) {
        this.$eventId = str;
    }

    public final void run() {
        String doCheck = new UiChecker().doCheck(this.$eventId);
        if (doCheck != null && DDMirrorDebugger.isDebuggable()) {
            SystemUtils.log(3, "UiChecker", "check " + this.$eventId + "; result: \n " + doCheck, (Throwable) null, "com.didiglobal.ddmirror.DDMirror$Companion$doCheck$1", 57);
        }
    }
}
