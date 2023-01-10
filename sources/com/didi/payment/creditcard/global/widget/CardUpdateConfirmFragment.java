package com.didi.payment.creditcard.global.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class CardUpdateConfirmFragment extends BaseDialogFragment {

    /* renamed from: a */
    private LinearLayout f33072a;

    /* renamed from: b */
    private LinearLayout f33073b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View.OnClickListener f33074c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f33075d;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.one_payment_creditcard_global_dialog_update_confirm, (ViewGroup) null, false);
        this.f33072a = (LinearLayout) inflate.findViewById(R.id.ll_confirm);
        this.f33073b = (LinearLayout) inflate.findViewById(R.id.ll_cancel);
        this.f33072a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardUpdateConfirmFragment.this.dismissAllowingStateLoss();
                if (CardUpdateConfirmFragment.this.f33074c != null) {
                    CardUpdateConfirmFragment.this.f33074c.onClick(view);
                }
            }
        });
        this.f33073b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardUpdateConfirmFragment.this.dismissAllowingStateLoss();
                if (CardUpdateConfirmFragment.this.f33075d != null) {
                    CardUpdateConfirmFragment.this.f33075d.onClick(view);
                }
            }
        });
        return inflate;
    }

    public void setConfirmClickListener(View.OnClickListener onClickListener) {
        this.f33074c = onClickListener;
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        this.f33075d = onClickListener;
    }
}
