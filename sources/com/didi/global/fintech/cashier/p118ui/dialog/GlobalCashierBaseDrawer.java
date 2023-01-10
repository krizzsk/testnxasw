package com.didi.global.fintech.cashier.p118ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.didi.global.fintech.cashier.p118ui.util.ThemeManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0014"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDialogFragment;", "()V", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierBaseDrawer */
/* compiled from: GlobalCashierBaseDrawer.kt */
public abstract class GlobalCashierBaseDrawer extends GlobalCashierBaseDialogFragment {
    public abstract void initData();

    public abstract void initView(View view);

    public abstract int layout();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutInflater from = LayoutInflater.from(getContext());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return from.cloneInContext(ThemeManager.getContextThemeWrapper(requireContext)).inflate(layout(), viewGroup, false);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        View decorView;
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        onCreateDialog.setCanceledOnTouchOutside(false);
        onCreateDialog.requestWindowFeature(1);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = onCreateDialog.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
        }
        Window window3 = onCreateDialog.getWindow();
        if (!(window3 == null || (decorView = window3.getDecorView()) == null)) {
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window4 = onCreateDialog.getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(R.style.drawer_anim_style);
        }
        Window window5 = onCreateDialog.getWindow();
        if (window5 != null) {
            window5.setLayout(-1, -2);
        }
        return onCreateDialog;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView(view);
        initData();
        setCancelable(false);
    }
}
