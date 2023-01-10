package com.didi.map.global.component.floatingwindow;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.didi.map.global.component.floatingwindow.util.C10272Util;
import com.didi.map.global.component.floatingwindow.view.IFWView;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, mo148868d2 = {"com/didi/map/global/component/floatingwindow/FWController$1$3", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "compFloatingWindow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FWController.kt */
public final class FWController$1$3 extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ FWController this$0;

    FWController$1$3(FWController fWController) {
        this.this$0 = fWController;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        Intrinsics.checkNotNullParameter(motionEvent, "e1");
        Intrinsics.checkNotNullParameter(motionEvent2, "e2");
        if (!this.this$0.f27853E) {
            return false;
        }
        SystemUtils.log(3, C10272Util.TAG, "onFling", (Throwable) null, "com.didi.map.global.component.floatingwindow.FWController$1$3", 203);
        if (((float) this.this$0.f27869l.x) <= (-this.this$0.f27882y) && f > 0.0f && (this.this$0.f27874q == IFWView.FWShapeState.EXPAND || this.this$0.f27874q == IFWView.FWShapeState.EXPAND_HANDLE_DRAG || this.this$0.f27874q == IFWView.FWShapeState.EXPAND_NORMAL_DRAG)) {
            this.this$0.m21994c();
            return true;
        } else if (((float) this.this$0.f27869l.x) >= (-this.this$0.f27882y) || f >= 0.0f || this.this$0.f27874q != IFWView.FWShapeState.ROLL) {
            return true;
        } else {
            this.this$0.m21996d();
            return true;
        }
    }
}
