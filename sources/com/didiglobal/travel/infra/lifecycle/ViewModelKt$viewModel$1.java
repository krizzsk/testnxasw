package com.didiglobal.travel.infra.lifecycle;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelStore;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: ViewModel.kt */
public final class ViewModelKt$viewModel$1 extends Lambda implements Function0<ViewModelStore> {
    final /* synthetic */ ComponentActivity $this_viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelKt$viewModel$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModel = componentActivity;
    }

    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_viewModel.getViewModelStore();
        Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
