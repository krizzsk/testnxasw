package com.jumio.defaultui.view;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¨\u0006\u0003"}, mo148868d2 = {"Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider$Factory;", "androidx/fragment/app/FragmentViewModelLazyKt$activityViewModels$2", "<anonymous>"}, mo148869k = 3, mo148870mv = {1, 5, 1})
/* compiled from: FragmentViewModelLazy.kt */
public final class NfcScanFragment$special$$inlined$activityViewModels$default$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NfcScanFragment$special$$inlined$activityViewModels$default$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
