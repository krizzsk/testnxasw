package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\bJ\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo148868d2 = {"Lkshark/SharkLog;", "", "()V", "logger", "Lkshark/SharkLog$Logger;", "getLogger", "()Lkshark/SharkLog$Logger;", "setLogger", "(Lkshark/SharkLog$Logger;)V", "d", "", "message", "Lkotlin/Function0;", "", "throwable", "", "Logger", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: SharkLog.kt */
public final class SharkLog {
    public static final SharkLog INSTANCE = new SharkLog();

    /* renamed from: a */
    private static volatile Logger f6469a;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, mo148868d2 = {"Lkshark/SharkLog$Logger;", "", "d", "", "message", "", "throwable", "", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: SharkLog.kt */
    public interface Logger {
        /* renamed from: d */
        void mo28978d(String str);

        /* renamed from: d */
        void mo28979d(Throwable th, String str);
    }

    private SharkLog() {
    }

    public final Logger getLogger() {
        return f6469a;
    }

    public final void setLogger(Logger logger) {
        f6469a = logger;
    }

    /* renamed from: d */
    public final void mo28975d(Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Logger logger = getLogger();
        if (logger != null) {
            logger.mo28978d(function0.invoke());
        }
    }

    /* renamed from: d */
    public final void mo28974d(Throwable th, Function0<String> function0) {
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Logger logger = getLogger();
        if (logger != null) {
            logger.mo28979d(th, function0.invoke());
        }
    }
}
