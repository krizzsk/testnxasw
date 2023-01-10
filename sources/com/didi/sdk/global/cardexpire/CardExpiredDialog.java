package com.didi.sdk.global.cardexpire;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class CardExpiredDialog extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f38861a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f38862b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View.OnClickListener f38863c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f38864d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.card_expire_intercept_dialog;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        GlideUtils.with2load2into(getContext(), this.f38861a, (ImageView) this.mRootView.findViewById(R.id.iv_card_icon));
        ((TextView) this.mRootView.findViewById(R.id.tv_card_no)).setText(this.f38862b);
        ((TextView) this.mRootView.findViewById(R.id.tv_update_card)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardExpiredDialog.this.dismiss();
                if (CardExpiredDialog.this.f38863c != null) {
                    CardExpiredDialog.this.f38863c.onClick(view);
                }
            }
        });
        ((TextView) this.mRootView.findViewById(R.id.tv_change_payment_method)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardExpiredDialog.this.dismiss();
                if (CardExpiredDialog.this.f38864d != null) {
                    CardExpiredDialog.this.f38864d.onClick(view);
                }
            }
        });
    }

    public static final class Builder {
        private String cardNo;
        private View.OnClickListener changePaymentMethodListener;
        private String icon;
        private View.OnClickListener updateCardListener;

        public Builder setIcon(String str) {
            this.icon = str;
            return this;
        }

        public Builder setCardNo(String str) {
            this.cardNo = str;
            return this;
        }

        public Builder setUpdateCardListener(View.OnClickListener onClickListener) {
            this.updateCardListener = onClickListener;
            return this;
        }

        public Builder setChangePaymentMethodListener(View.OnClickListener onClickListener) {
            this.changePaymentMethodListener = onClickListener;
            return this;
        }

        public CardExpiredDialog builder() {
            CardExpiredDialog cardExpiredDialog = new CardExpiredDialog();
            String unused = cardExpiredDialog.f38861a = this.icon;
            String unused2 = cardExpiredDialog.f38862b = this.cardNo;
            View.OnClickListener unused3 = cardExpiredDialog.f38863c = this.updateCardListener;
            View.OnClickListener unused4 = cardExpiredDialog.f38864d = this.changePaymentMethodListener;
            return cardExpiredDialog;
        }
    }
}
