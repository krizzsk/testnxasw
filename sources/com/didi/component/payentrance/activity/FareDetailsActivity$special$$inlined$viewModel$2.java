package com.didi.component.payentrance.activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo148868d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "VM", "Landroidx/lifecycle/ViewModel;", "invoke", "com/didiglobal/travel/infra/lifecycle/ViewModelKt$viewModel$2"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: ViewModel.kt */
public final class FareDetailsActivity$special$$inlined$viewModel$2 extends Lambda implements Function0<ViewModelProvider.AndroidViewModelFactory> {
    final /* synthetic */ ComponentActivity $this_viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FareDetailsActivity$special$$inlined$viewModel$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModel = componentActivity;
    }

    public final ViewModelProvider.AndroidViewModelFactory invoke() {
        return new ViewModelProvider.AndroidViewModelFactory(this.$this_viewModel.getApplication());
    }
}
