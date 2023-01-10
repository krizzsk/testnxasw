package com.didi.payment.creditcard.global.utils;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class GlobalCreditPayTipDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f32925a;

    /* renamed from: b */
    private TextView f32926b;

    /* renamed from: c */
    private Button f32927c;

    /* renamed from: d */
    private Button f32928d;

    /* renamed from: e */
    private LinearLayout f32929e;

    /* renamed from: f */
    private String f32930f;

    /* renamed from: g */
    private String f32931g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PayTipDialogEventListener f32932h;

    public interface PayTipDialogEventListener {
        void onFaqClick();

        void onNegativeClick();

        void onPositiveClick();
    }

    public void setTip(String str) {
        this.f32931g = str;
    }

    public void setContent(String str) {
        this.f32930f = str;
    }

    public void setPayTipDialogEventListener(PayTipDialogEventListener payTipDialogEventListener) {
        this.f32932h = payTipDialogEventListener;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_pay_tip, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m25034a(view);
        m25033a();
    }

    /* renamed from: a */
    private void m25034a(View view) {
        this.f32925a = (TextView) view.findViewById(R.id.tv_dialog_content);
        this.f32926b = (TextView) view.findViewById(R.id.tv_dialog_tip);
        this.f32927c = (Button) view.findViewById(R.id.btn_confirm);
        this.f32928d = (Button) view.findViewById(R.id.btn_cancel);
        this.f32929e = (LinearLayout) view.findViewById(R.id.ll_faq_tip);
    }

    /* renamed from: a */
    private void m25033a() {
        this.f32925a.setText(this.f32930f);
        this.f32926b.setText(this.f32931g);
        this.f32927c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f32932h != null) {
                    GlobalCreditPayTipDialogFragment.this.f32932h.onPositiveClick();
                }
            }
        });
        this.f32928d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f32932h != null) {
                    GlobalCreditPayTipDialogFragment.this.f32932h.onNegativeClick();
                }
            }
        });
        this.f32929e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditPayTipDialogFragment.this.dismissAllowingStateLoss();
                if (GlobalCreditPayTipDialogFragment.this.f32932h != null) {
                    GlobalCreditPayTipDialogFragment.this.f32932h.onFaqClick();
                }
            }
        });
    }
}
