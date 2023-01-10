package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.sdk.view.tips.TipsView;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;

public class WalletBalanceSectionView extends WalletAbsSectionView<WalletPageInfo.BalanceSection, IWalletMainListEventListener> {

    /* renamed from: a */
    private static final String f34940a = "KEY_TOPUP_GUIDE_CLOSED";

    /* renamed from: b */
    private Context f34941b;

    /* renamed from: c */
    private TextView f34942c;

    /* renamed from: d */
    private ImageView f34943d;

    /* renamed from: e */
    private LinearLayout f34944e;

    /* renamed from: f */
    private TextView f34945f;

    /* renamed from: g */
    private TextView f34946g;

    /* renamed from: h */
    private ImageView f34947h;

    /* renamed from: i */
    private TextView f34948i;

    /* renamed from: j */
    private ImageView f34949j;

    /* renamed from: k */
    private LinearLayout f34950k;

    /* renamed from: l */
    private TipsView f34951l;

    public WalletBalanceSectionView(Context context) {
        super(context);
    }

    public WalletBalanceSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletBalanceSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f34941b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_balance_section, this, true);
        this.f34942c = (TextView) inflate.findViewById(R.id.tv_balance_title);
        this.f34943d = (ImageView) inflate.findViewById(R.id.iv_balance_help);
        this.f34945f = (TextView) inflate.findViewById(R.id.tv_balance_symbol);
        this.f34946g = (TextView) inflate.findViewById(R.id.tv_balance_value);
        this.f34946g = (TextView) inflate.findViewById(R.id.tv_balance_value);
        this.f34947h = (ImageView) inflate.findViewById(R.id.tv_balance_value_arrow);
        this.f34948i = (TextView) inflate.findViewById(R.id.tv_tips);
        this.f34949j = (ImageView) inflate.findViewById(R.id.iv_banner);
        this.f34944e = (LinearLayout) inflate.findViewById(R.id.ll_balance_value);
        this.f34951l = (TipsView) findViewById(R.id.v_tips);
        this.f34950k = (LinearLayout) inflate.findViewById(R.id.ll_balance_entry_container);
    }

    public void updateContent(final WalletPageInfo.BalanceSection balanceSection) {
        if (balanceSection == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f34951l.setVisibility(8);
        this.f34949j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.bannerLinkUrl)) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceBannerClickEvent(balanceSection.bannerLinkUrl);
                }
            }
        });
        this.f34943d.setVisibility(TextUtils.isEmpty(balanceSection.helpUrl) ? 8 : 0);
        this.f34943d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.helpUrl)) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceHelpEvent(balanceSection.helpUrl);
                }
            }
        });
        this.f34944e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.linkUrl) && balanceSection.status == 1) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceDetailClickEvent(balanceSection.linkUrl);
                }
            }
        });
        if (balanceSection.status == 1) {
            this.f34945f.setEnabled(true);
            this.f34946g.setEnabled(true);
            this.f34947h.setEnabled(true);
        } else {
            this.f34946g.setEnabled(false);
            this.f34945f.setEnabled(false);
            this.f34947h.setEnabled(false);
        }
        if (TextUtils.isEmpty(balanceSection.desc)) {
            this.f34948i.setVisibility(8);
        } else {
            this.f34948i.setVisibility(0);
            this.f34948i.setText(balanceSection.desc);
        }
        if (!TextUtils.isEmpty(balanceSection.bannerUrl)) {
            this.f34949j.setVisibility(0);
            GlideUtils.loadRoundImage(this.f34941b, balanceSection.bannerUrl, 2, this.f34949j);
        } else {
            this.f34949j.setVisibility(8);
        }
        this.f34942c.setText(balanceSection.title);
        this.f34945f.setText(balanceSection.symbol);
        this.f34946g.setText(balanceSection.value);
        m26679a(balanceSection.menuItems);
    }

    /* renamed from: a */
    private void m26679a(List<WalletPageInfo.BalanceItem> list) {
        this.f34950k.removeAllViews();
        if (list == null || list.size() == 0) {
            this.f34950k.setVisibility(8);
            return;
        }
        this.f34950k.setVisibility(0);
        for (int i = 0; i < list.size(); i++) {
            final WalletPageInfo.BalanceItem balanceItem = list.get(i);
            View inflate = LayoutInflater.from(this.f34941b).inflate(R.layout.wallet_global_v_balance_section_item, (ViewGroup) null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            inflate.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ll_balance_entry_image);
            TextView textView = (TextView) inflate.findViewById(R.id.ll_balance_entry_text);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_sale_tip);
            if (!TextUtils.isEmpty(balanceItem.iconUrl)) {
                GlideUtils.with2load2into(getContext(), balanceItem.iconUrl, imageView);
            }
            if (balanceItem.status == 1) {
                textView.setEnabled(true);
            } else {
                textView.setEnabled(false);
            }
            textView.setText(balanceItem.title);
            if (!TextUtils.isEmpty(balanceItem.promotionText)) {
                textView2.setVisibility(0);
                textView2.setText(balanceItem.promotionText);
            } else {
                textView2.setVisibility(8);
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletBalanceSectionView.this.mListener != null && balanceItem.status == 1) {
                        ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceItemClickEvent(balanceItem);
                    }
                }
            });
            this.f34950k.addView(inflate);
            m26678a(balanceItem, (View) imageView, i, list.size());
        }
    }

    /* renamed from: a */
    private void m26678a(WalletPageInfo.BalanceItem balanceItem, View view, int i, int i2) {
        if (!PaySharedPreferencesUtil.getBoolean(getContext(), f34940a, false) && TextUtils.equals(balanceItem.f34551id, "topup")) {
            m26677a(getContext(), view, i, i2);
        }
    }

    /* renamed from: a */
    private void m26677a(final Context context, View view, int i, int i2) {
        this.f34951l.setVisibility(0);
        this.f34951l.setMoreLineTips(context.getString(R.string.wallet_global_topup_tips));
        this.f34951l.setId(view.hashCode());
        this.f34951l.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PaySharedPreferencesUtil.putBoolean(context, WalletBalanceSectionView.f34940a, true);
            }
        });
        this.f34951l.setPos(1, 2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f34951l.getLayoutParams();
        marginLayoutParams.leftMargin = ((((i * 2) + 1) * UIUtils.getScreenWidth(getContext())) / (i2 * 2)) - UIUtils.dip2px(getContext(), 25.0f);
        this.f34951l.setLayoutParams(marginLayoutParams);
    }
}
