package com.didi.map.global.sctx.event_reveal;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u00010\fH\u0016¨\u0006\r"}, mo148868d2 = {"com/didi/map/global/sctx/event_reveal/TrafficEventsController$downloadIcon$1", "Lcom/bumptech/glide/request/target/CustomTarget;", "Landroid/graphics/Bitmap;", "onLoadCleared", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "onLoadFailed", "errorDrawable", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventsController.kt */
public final class TrafficEventsController$downloadIcon$1 extends CustomTarget<Bitmap> {
    final /* synthetic */ Function1<Bitmap, Unit> $callback;

    public void onLoadCleared(Drawable drawable) {
    }

    TrafficEventsController$downloadIcon$1(Function1<? super Bitmap, Unit> function1) {
        this.$callback = function1;
    }

    public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
        Intrinsics.checkNotNullParameter(bitmap, "resource");
        Function1<Bitmap, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(bitmap);
        }
    }

    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        Function1<Bitmap, Unit> function1 = this.$callback;
        if (function1 != null) {
            function1.invoke(null);
        }
    }
}
