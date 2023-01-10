package jumio.core;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.C20921a;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import java.lang.Thread;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.u */
/* compiled from: ExceptionHandler.kt */
public final class C19508u implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final Thread.UncaughtExceptionHandler f55407a;

    public C19508u(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f55407a = uncaughtExceptionHandler;
        Log.m43660v(Analytics.LOGTAG, Intrinsics.stringPlus("Wrapping handler :", uncaughtExceptionHandler == null ? null : uncaughtExceptionHandler.getClass()));
    }

    /* renamed from: a */
    public final void mo148740a() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            Thread.setDefaultUncaughtExceptionHandler(this.f55407a);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(th, "ex");
        if (th instanceof Exception) {
            Log.m43645d(Analytics.LOGTAG, Intrinsics.stringPlus("uncaught exception: ", th));
            Analytics.Companion companion = Analytics.Companion;
            companion.add(MobileEvents.exception((Exception) th));
            companion.add(MobileEvents.lifecycle$default(C20921a.ABORTED, (Object) null, 2, (Object) null));
            companion.flush();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f55407a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
