package com.pay99.diff_base;

import com.didi.drouter.api.DRouter;
import com.pay99.diff_base.base.IDiff;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, mo148868d2 = {"Lcom/pay99/diff_base/DiffUtil;", "", "()V", "diffContain", "Lcom/pay99/diff_base/DiffContain;", "isInit", "", "()Z", "setInit", "(Z)V", "getDiffValue", "Lcom/pay99/diff_base/base/IDiff;", "key", "", "putDiffValue", "value", "diff-base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DiffUtil.kt */
public final class DiffUtil {
    public static final DiffUtil INSTANCE = new DiffUtil();

    /* renamed from: a */
    private static boolean f58571a;

    /* renamed from: b */
    private static final DiffContain f58572b = new DiffContain();

    private DiffUtil() {
    }

    public final boolean isInit() {
        return f58571a;
    }

    public final void setInit(boolean z) {
        f58571a = z;
    }

    public final IDiff getDiffValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!f58571a) {
            DRouter.build(DiffConstantsKt.ROUTER_DIFF_INDEX).start();
        }
        IDiff contain = f58572b.getContain(str);
        return contain == null ? new DiffUtil$getDiffValue$1() : contain;
    }

    public final IDiff putDiffValue(String str, IDiff iDiff) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(iDiff, "value");
        return f58572b.putContain(str, iDiff);
    }
}
