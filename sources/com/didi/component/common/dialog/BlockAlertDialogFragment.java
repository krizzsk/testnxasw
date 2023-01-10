package com.didi.component.common.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.taxis99.R;

public class BlockAlertDialogFragment extends AlertDialogBase {

    /* renamed from: a */
    private View.OnClickListener f13355a;

    /* renamed from: b */
    private View.OnClickListener f13356b;

    /* renamed from: c */
    private BlockDialogInfo f13357c;

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.comp_dialog_block, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            window.setLayout(displayMetrics.widthPixels, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            window.setAttributes(attributes);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.tv_negative_button).setOnClickListener(this.f13355a);
        view.findViewById(R.id.tv_positive_button).setOnClickListener(this.f13356b);
        updateView(this.f13357c);
    }

    public void updateView(BlockDialogInfo blockDialogInfo) {
        View view = getView();
        if (view != null) {
            ((TextView) view.findViewById(R.id.dialog_title)).setText(blockDialogInfo.f13362a);
            ((TextView) view.findViewById(R.id.dialog_content)).setText(blockDialogInfo.f13363b);
            ((TextView) view.findViewById(R.id.tv_negative_button)).setText(blockDialogInfo.f13364c);
            ((TextView) view.findViewById(R.id.tv_positive_button)).setText(blockDialogInfo.f13365d);
        }
    }

    public void setNegativeClickListener(View.OnClickListener onClickListener) {
        this.f13355a = onClickListener;
    }

    public View.OnClickListener getNegativeClickListener() {
        return this.f13355a;
    }

    public void setPositiveClickListener(View.OnClickListener onClickListener) {
        this.f13356b = onClickListener;
    }

    public View.OnClickListener getPositiveClickListener() {
        return this.f13356b;
    }

    public void setDialogInfo(BlockDialogInfo blockDialogInfo) {
        this.f13357c = blockDialogInfo;
    }

    public BlockDialogInfo getDialogInfo() {
        return this.f13357c;
    }
}
