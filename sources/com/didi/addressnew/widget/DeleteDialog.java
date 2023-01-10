package com.didi.addressnew.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.addressnew.framework.widget.loadingbutton.LoadableButton;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class DeleteDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f9479a;

    /* renamed from: b */
    private OnDeleteDialogClickListener f9480b;

    /* renamed from: c */
    private LoadableButton f9481c;

    public interface OnDeleteDialogClickListener {
        void onCancelClick();

        void onConfirmClick();
    }

    public DeleteDialog(Context context) {
        this(context, -1);
    }

    public DeleteDialog(Context context, int i) {
        super(context, i);
        m8232a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.addFlags(2);
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    private void m8232a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bottom_delete_dialog_layout, (ViewGroup) null);
        this.f9479a = (TextView) inflate.findViewById(R.id.dialog_title);
        inflate.findViewById(R.id.dialog_cancel).setOnClickListener(this);
        LoadableButton loadableButton = (LoadableButton) inflate.findViewById(R.id.dialog_confirm);
        this.f9481c = loadableButton;
        loadableButton.setText(getContext().getResources().getString(R.string.GRider_Sug_2020_delete));
        this.f9481c.setTextSize(20);
        this.f9481c.setTextStyle(Typeface.DEFAULT_BOLD);
        this.f9481c.setOnClickListener(this);
        setContentView(inflate);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.dialog_cancel) {
            OnDeleteDialogClickListener onDeleteDialogClickListener = this.f9480b;
            if (onDeleteDialogClickListener != null) {
                onDeleteDialogClickListener.onCancelClick();
            }
        } else if (id == R.id.dialog_confirm && this.f9480b != null) {
            this.f9481c.playAnim();
            this.f9480b.onConfirmClick();
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f9479a.setText(str);
        }
    }

    public void refreshConfirmBtn() {
        this.f9481c.reset();
    }

    public void setOnDeleteDialogClickListener(OnDeleteDialogClickListener onDeleteDialogClickListener) {
        this.f9480b = onDeleteDialogClickListener;
    }
}
