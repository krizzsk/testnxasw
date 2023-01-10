package com.didi.payment.creditcard.global.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalAddCardFailureDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f32913a;

    /* renamed from: b */
    private TextView f32914b;

    /* renamed from: c */
    private Button f32915c;

    /* renamed from: d */
    private Button f32916d;

    /* renamed from: e */
    private String f32917e;

    /* renamed from: f */
    private String f32918f;

    /* renamed from: g */
    private String f32919g;

    /* renamed from: h */
    private String f32920h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public View.OnClickListener f32921i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View.OnClickListener f32922j;

    public void setTitle(String str) {
        this.f32917e = str;
    }

    public void setContent(String str) {
        this.f32918f = str;
    }

    public void setNegativeButton(String str, View.OnClickListener onClickListener) {
        this.f32920h = str;
        this.f32922j = onClickListener;
    }

    public void setPositiveButton(String str, View.OnClickListener onClickListener) {
        this.f32919g = str;
        this.f32921i = onClickListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_failureguide, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            Window window = dialog.getWindow();
            window.setLayout((int) (((double) displayMetrics.widthPixels) * 0.712d), -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.4f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m25030a(view);
        m25029a();
    }

    /* renamed from: a */
    private void m25030a(View view) {
        this.f32913a = (TextView) view.findViewById(R.id.tv_title);
        this.f32914b = (TextView) view.findViewById(R.id.tv_content);
        this.f32915c = (Button) view.findViewById(R.id.btn_confirm);
        this.f32916d = (Button) view.findViewById(R.id.btn_cancel);
    }

    /* renamed from: a */
    private void m25029a() {
        if (!TextUtils.isEmpty(this.f32917e)) {
            this.f32913a.setVisibility(0);
            this.f32913a.setText(this.f32917e);
        }
        if (!TextUtils.isEmpty(this.f32918f)) {
            this.f32914b.setVisibility(0);
            this.f32914b.setText(this.f32918f);
        }
        if (!TextUtils.isEmpty(this.f32919g)) {
            this.f32915c.setVisibility(0);
            this.f32915c.setText(this.f32919g);
            this.f32915c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalAddCardFailureDialogFragment.this.dismiss();
                    if (GlobalAddCardFailureDialogFragment.this.f32921i != null) {
                        GlobalAddCardFailureDialogFragment.this.f32921i.onClick(view);
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(this.f32920h)) {
            this.f32916d.setVisibility(0);
            this.f32916d.setText(this.f32920h);
            this.f32916d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalAddCardFailureDialogFragment.this.dismiss();
                    if (GlobalAddCardFailureDialogFragment.this.f32922j != null) {
                        GlobalAddCardFailureDialogFragment.this.f32922j.onClick(view);
                    }
                }
            });
        }
    }
}
