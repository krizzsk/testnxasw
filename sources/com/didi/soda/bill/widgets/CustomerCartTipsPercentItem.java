package com.didi.soda.bill.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.soda.bill.widgets.CustomerCartTipsGroupView;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.taxis99.R;

public class CustomerCartTipsPercentItem extends AppCompatTextView {

    /* renamed from: a */
    private Context f41999a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f42000b;

    /* renamed from: c */
    private TipFeeViewModel f42001c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CustomerCartTipsGroupView.OnselectTipListener f42002d;

    public CustomerCartTipsPercentItem(Context context, int i) {
        super(context);
        this.f41999a = context;
        this.f42000b = i;
        m31506a(context);
    }

    public CustomerCartTipsPercentItem setTips(TipFeeViewModel tipFeeViewModel) {
        if (tipFeeViewModel.mTips < 0) {
            this.f42001c = tipFeeViewModel;
            setText(getResources().getString(R.string.customer_cart_tips_custom_input));
            return this;
        } else if (!TextUtils.isEmpty(tipFeeViewModel.mCurrency)) {
            this.f42001c = tipFeeViewModel;
            if (tipFeeViewModel.mTipFeeType == 1) {
                if (this.f42001c.mTips % 100 == 0) {
                    setText(LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(this.f42001c.mTips, this.f42001c.mCurrency));
                } else {
                    setText(LocalizationUtils.CurrencyUtils.getCurrency(this.f42001c.mTips, this.f42001c.mCurrency));
                }
            } else if (this.f42001c.mTipFeeType == 2) {
                setText(this.f42001c.mTips + "%");
            }
            return this;
        } else {
            throw new IllegalStateException("Please set currency type first");
        }
    }

    public CustomerCartTipsPercentItem setOnSelectTipListener(CustomerCartTipsGroupView.OnselectTipListener onselectTipListener) {
        this.f42002d = onselectTipListener;
        return this;
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        if (z) {
            setTextColor(SkinUtil.getBrandPrimaryColor());
            getPaint().setFakeBoldText(true);
            return;
        }
        setTextColor(this.f41999a.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        getPaint().setFakeBoldText(false);
    }

    /* renamed from: a */
    private void m31506a(Context context) {
        setGravity(17);
        setTextSize((float) 16);
        setLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setPadding(8, 0, 8, 0);
        setAutoSizeTextTypeUniformWithConfiguration(12, 16, 1, 2);
        setTextColor(context.getResources().getColor(R.color.rf_color_gery_2_40_666666));
        setBackgroundResource(R.drawable.customer_skin_selector_cart_tips_bg);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CustomerCartTipsPercentItem.this.setSelected(true);
                if (CustomerCartTipsPercentItem.this.f42002d != null) {
                    CustomerCartTipsPercentItem.this.f42002d.onSelectTip(CustomerCartTipsPercentItem.this.f42000b);
                }
            }
        });
    }

    public static class TipFeeViewModel {
        public String mCurrency;
        public long mOrderPrice;
        public int mTipFeeType = -1;
        public long mTips;

        public TipFeeViewModel() {
        }

        public TipFeeViewModel(long j, int i, String str, long j2) {
            this.mTipFeeType = i;
            this.mTips = j;
            this.mCurrency = str;
            this.mOrderPrice = j2;
        }
    }
}
