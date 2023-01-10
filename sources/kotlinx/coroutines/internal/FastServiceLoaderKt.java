package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, mo148868d2 = {"ANDROID_DETECTED", "", "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, mo148869k = 2, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastServiceLoader.kt */
public final class FastServiceLoaderKt {

    /* renamed from: a */
    private static final boolean f6234a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m47938constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m47938constructorimpl(ResultKt.createFailure(th));
        }
        f6234a = Result.m47945isSuccessimpl(obj);
    }

    public static final boolean getANDROID_DETECTED() {
        return f6234a;
    }
}
