package com.didi.component.expectation.view.animation;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo148868d2 = {"<anonymous>", "", "it", "Landroidx/transition/Transition;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ExpectationCardAnimation.kt */
final class ExpectationCardAnimation$collapse$1$2 extends Lambda implements Function1<Transition, Unit> {
    final /* synthetic */ ConstraintLayout $target;
    final /* synthetic */ ExpectationCardAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpectationCardAnimation$collapse$1$2(ExpectationCardAnimation expectationCardAnimation, ConstraintLayout constraintLayout) {
        super(1);
        this.this$0 = expectationCardAnimation;
        this.$target = constraintLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Transition) obj);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(androidx.transition.Transition r5) {
        /*
            r4 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.constraintlayout.widget.ConstraintLayout r5 = r4.$target
            android.view.View r5 = (android.view.View) r5
            r0 = 2131434716(0x7f0b1cdc, float:1.8491254E38)
            android.view.View r5 = r5.findViewById(r0)
            android.widget.TextSwitcher r5 = (android.widget.TextSwitcher) r5
            if (r5 != 0) goto L_0x0015
            goto L_0x003c
        L_0x0015:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            android.view.View r1 = r5.getCurrentView()
            boolean r2 = r1 instanceof android.widget.TextView
            r3 = 0
            if (r2 == 0) goto L_0x0024
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x0025
        L_0x0024:
            r1 = r3
        L_0x0025:
            if (r1 != 0) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r1.setGravity(r0)
        L_0x002b:
            android.view.View r5 = r5.getNextView()
            boolean r1 = r5 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x0036
            r3 = r5
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x0036:
            if (r3 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            r3.setGravity(r0)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.expectation.view.animation.ExpectationCardAnimation$collapse$1$2.invoke(androidx.transition.Transition):void");
    }
}
