package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;
import rui.util.ViewUtils;

public class CustomerRateDialog extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DialogBuilder.CustomerDialogModel f44373a;

    /* renamed from: b */
    private View f44374b;

    /* renamed from: c */
    private ImageView f44375c;

    /* renamed from: d */
    private Context f44376d;

    /* renamed from: e */
    private TextView f44377e;

    /* renamed from: f */
    private TextView f44378f;

    /* renamed from: g */
    private TextView f44379g;

    /* renamed from: h */
    private TextView f44380h;

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    public CustomerRateDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f44373a = customerDialogModel;
        this.f44376d = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f44374b = layoutInflater.inflate(R.layout.customer_dialog_rate, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) ViewUtils.m7249dp(this.f44376d, 50.0f);
        layoutParams.rightMargin = (int) ViewUtils.m7249dp(this.f44376d, 50.0f);
        this.f44374b.setLayoutParams(layoutParams);
        m32991e();
        return this.f44374b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f44377e.setText(charSequence);
    }

    public void setContent(CharSequence charSequence) {
        this.f44378f.setText(charSequence);
    }

    /* renamed from: e */
    private void m32991e() {
        this.f44375c = (ImageView) this.f44374b.findViewById(R.id.customer_iv_dialog_icon);
        this.f44377e = (TextView) this.f44374b.findViewById(R.id.customer_tv_dialog_title);
        this.f44378f = (TextView) this.f44374b.findViewById(R.id.customer_tv_dialog_content);
        this.f44379g = (TextView) this.f44374b.findViewById(R.id.customer_tv_common_dialog_sub_action1);
        this.f44380h = (TextView) this.f44374b.findViewById(R.id.customer_tv_common_dialog_sub_action2);
        if (!TextUtils.isEmpty(this.f44373a.title)) {
            setTitle(this.f44373a.title);
        }
        if (!TextUtils.isEmpty(this.f44373a.content)) {
            setContent(this.f44373a.content);
        }
        if (this.f44373a.mSubAction1 != null) {
            this.f44379g.setText(this.f44373a.mSubAction1.mActionName);
        }
        if (this.f44373a.mSubAction2 != null) {
            this.f44380h.setText(this.f44373a.mSubAction2.mActionName);
        }
        this.f44379g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!(CustomerRateDialog.this.f44373a.mSubAction1 == null || CustomerRateDialog.this.f44373a.mSubAction1.mListener == null)) {
                    CustomerRateDialog.this.f44373a.mSubAction1.mListener.onClick(view);
                }
                CustomerRateDialog.this.dismiss();
            }
        });
        this.f44380h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerRateDialog.this.dismiss();
            }
        });
    }
}
