package com.didiglobal.travel.infra.rxjava2;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo148868d2 = {"<anonymous>", "", "invoke", "com/didiglobal/travel/infra/rxjava2/DisposableHolderKt$obtainHolder$1$1"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: DisposableHolder.kt */
public final class DisposableKt$obtainHolder$$inlined$synchronized$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $key$inlined;
    final /* synthetic */ LifecycleOwner $this_obtainHolder$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DisposableKt$obtainHolder$$inlined$synchronized$lambda$1(LifecycleOwner lifecycleOwner, int i) {
        super(0);
        this.$this_obtainHolder$inlined = lifecycleOwner;
        this.$key$inlined = i;
    }

    public final void invoke() {
        DisposableHolderKt.m40239a(this.$key$inlined);
    }
}
