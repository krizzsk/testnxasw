package com.didiglobal.travel.infra.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: View.kt */
public final class ViewKt$onLongClick$1 implements View.OnLongClickListener {
    final /* synthetic */ Function1 $block;

    public ViewKt$onLongClick$1(Function1 function1) {
        this.$block = function1;
    }

    public final boolean onLongClick(View view) {
        Function1 function1 = this.$block;
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        return ((Boolean) function1.invoke(view)).booleanValue();
    }
}
