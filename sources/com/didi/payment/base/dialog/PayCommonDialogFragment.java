package com.didi.payment.base.dialog;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class PayCommonDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f32334a;

    /* renamed from: b */
    private TextView f32335b;

    /* renamed from: c */
    private TextView f32336c;

    /* renamed from: d */
    private TextView f32337d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnButtonClickedListener f32338e;

    /* renamed from: f */
    private String f32339f;

    /* renamed from: g */
    private String f32340g;

    /* renamed from: h */
    private String f32341h;

    /* renamed from: i */
    private String f32342i;

    public interface OnButtonClickedListener {
        void onNegButtonClicked(PayCommonDialogFragment payCommonDialogFragment);

        void onPosButtonClicked(PayCommonDialogFragment payCommonDialogFragment);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.pay_base_dialog_common;
    }

    public static void show(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, OnButtonClickedListener onButtonClickedListener) {
        PayCommonDialogFragment payCommonDialogFragment = new PayCommonDialogFragment();
        payCommonDialogFragment.f32339f = str;
        payCommonDialogFragment.f32340g = str2;
        payCommonDialogFragment.f32341h = str3;
        payCommonDialogFragment.f32342i = str4;
        payCommonDialogFragment.f32338e = onButtonClickedListener;
        payCommonDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "pay_base_dialog_common");
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f32334a = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_title);
        this.f32335b = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_content);
        this.f32336c = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_pos);
        this.f32337d = (TextView) this.mRootView.findViewById(R.id.tv_pay_base_dialog_common_neg);
        this.f32334a.setText(this.f32339f);
        if (!TextUtils.isEmpty(this.f32340g)) {
            this.f32335b.setVisibility(0);
        } else {
            this.f32335b.setVisibility(8);
        }
        this.f32335b.setText(this.f32340g);
        this.f32336c.setText(this.f32341h);
        this.f32337d.setText(this.f32342i);
        this.f32336c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PayCommonDialogFragment.this.f32338e != null) {
                    PayCommonDialogFragment.this.f32338e.onPosButtonClicked(PayCommonDialogFragment.this);
                }
            }
        });
        this.f32337d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (PayCommonDialogFragment.this.f32338e != null) {
                    PayCommonDialogFragment.this.f32338e.onNegButtonClicked(PayCommonDialogFragment.this);
                }
            }
        });
    }
}
