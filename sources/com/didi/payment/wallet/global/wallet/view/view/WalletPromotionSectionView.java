package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.helper.WalletLineViewHelper;
import com.taxis99.R;
import java.util.List;

public class WalletPromotionSectionView extends WalletAbsSectionView<WalletPageInfo.PromotionSection, IWalletMainListEventListener> {

    /* renamed from: a */
    private Context f35017a;

    /* renamed from: b */
    private TextView f35018b;

    /* renamed from: c */
    private LinearLayout f35019c;

    public WalletPromotionSectionView(Context context) {
        super(context);
    }

    public WalletPromotionSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletPromotionSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f35017a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_promotion_section, this, true);
        this.f35018b = (TextView) inflate.findViewById(R.id.tv_promotion_title);
        this.f35019c = (LinearLayout) inflate.findViewById(R.id.ll_promotion_entry_container);
    }

    public void updateContent(WalletPageInfo.PromotionSection promotionSection) {
        if (promotionSection == null || promotionSection.promotionItems == null || promotionSection.promotionItems.size() <= 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f35018b.setText(promotionSection.title);
        m26709a(promotionSection.promotionItems);
    }

    /* renamed from: a */
    private void m26709a(List<WalletPageInfo.PromotionItem> list) {
        this.f35019c.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            final WalletPageInfo.PromotionItem promotionItem = list.get(i);
            View inflate = LayoutInflater.from(this.f35017a).inflate(R.layout.wallet_global_v_promotion_section_item, (ViewGroup) null, false);
            inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this.f35017a, 60.0f)));
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_promotion_icon);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_promotion_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_promotion_desc);
            if (!TextUtils.isEmpty(promotionItem.iconUrl)) {
                GlideUtils.with2load2into(getContext(), promotionItem.iconUrl, imageView);
            }
            textView.setText(promotionItem.title);
            if (TextUtils.isEmpty(promotionItem.desc)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(promotionItem.desc);
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletPromotionSectionView.this.mListener != null) {
                        ((IWalletMainListEventListener) WalletPromotionSectionView.this.mListener).onPromotionItemClickEvent(promotionItem);
                    }
                }
            });
            this.f35019c.addView(inflate);
            if (i != list.size() - 1) {
                WalletLineViewHelper.addLeftMarginLineView(this.f35017a, this.f35019c);
            }
        }
    }
}
