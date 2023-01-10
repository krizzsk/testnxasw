package com.didi.payment.wallet.global.wallet.view.widget;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class TopUpCheckErrorDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f35390a;

    /* renamed from: b */
    private Button f35391b;

    /* renamed from: c */
    private String f35392c;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_top_up_error;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f35390a = (TextView) this.mRootView.findViewById(R.id.tv_title);
        Button button = (Button) this.mRootView.findViewById(R.id.btn_ok);
        this.f35391b = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TopUpCheckErrorDialogFragment.this.dismissAllowingStateLoss();
            }
        });
        m26858a(this.f35392c);
    }

    public void setData(String str) {
        this.f35392c = str;
    }

    /* renamed from: a */
    private void m26858a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f35390a.setText(str);
        }
    }
}
