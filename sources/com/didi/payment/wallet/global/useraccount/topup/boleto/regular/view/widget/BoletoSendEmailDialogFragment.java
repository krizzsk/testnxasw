package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletSendEmailContract;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class BoletoSendEmailDialogFragment extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f34532a;

    /* renamed from: b */
    private TextView f34533b;

    /* renamed from: c */
    private String f34534c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WalletSendEmailContract f34535d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_boleto_send_email;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f34532a = (EditText) this.mRootView.findViewById(R.id.tv_boleto_send_email_address);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.btn_boleto_send_email_ok);
        this.f34533b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackBillSendEmailBtnCK();
                if (BoletoSendEmailDialogFragment.this.f34535d != null) {
                    BoletoSendEmailDialogFragment.this.f34535d.onSendClick(BoletoSendEmailDialogFragment.this.f34532a.getText().toString());
                }
            }
        });
        m26325a(this.f34534c);
        m26324a();
    }

    public void setData(String str) {
        this.f34534c = str;
    }

    public void setWalletSendEmailContract(WalletSendEmailContract walletSendEmailContract) {
        this.f34535d = walletSendEmailContract;
    }

    /* renamed from: a */
    private void m26325a(String str) {
        this.f34532a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                BoletoSendEmailDialogFragment.this.m26324a();
            }
        });
        if (!TextUtils.isEmpty(str)) {
            this.f34532a.setText(str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26324a() {
        this.f34533b.setEnabled(m26327b());
    }

    /* renamed from: b */
    private boolean m26327b() {
        return !com.didi.drouter.utils.TextUtils.isEmpty(this.f34532a.getEditableText().toString());
    }

    public void dismissEmailDialog() {
        dismissAllowingStateLoss();
    }
}
