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
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.helper.WalletLineViewHelper;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.List;

@Deprecated
public class WalletPayMethodSectionView extends WalletAbsSectionView<WalletPageInfo.PayMethodSection, IWalletMainListEventListener> implements IViewFreezeApplyer {

    /* renamed from: a */
    private static final int f35007a = 6;

    /* renamed from: b */
    private ViewGroup f35008b;

    /* renamed from: c */
    private TextView f35009c;

    /* renamed from: d */
    private ImageView f35010d;

    /* renamed from: e */
    private LinearLayout f35011e;

    /* renamed from: f */
    private LinearLayout f35012f;

    /* renamed from: g */
    private TextView f35013g;

    /* renamed from: h */
    private TextView f35014h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f35015i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalletPageInfo.PayMethodSection f35016j;

    public WalletPayMethodSectionView(Context context) {
        super(context);
    }

    public WalletPayMethodSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletPayMethodSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_paymethod_section, this, true);
        this.f35008b = (ViewGroup) inflate.findViewById(R.id.ll_paymethod_title);
        this.f35009c = (TextView) inflate.findViewById(R.id.tv_paymethod_title);
        this.f35010d = (ImageView) inflate.findViewById(R.id.iv_paymethod_help);
        this.f35011e = (LinearLayout) inflate.findViewById(R.id.ll_paymethod_entry_container);
        this.f35012f = (LinearLayout) inflate.findViewById(R.id.ll_addpay);
        this.f35013g = (TextView) inflate.findViewById(R.id.tv_addpay_title);
        this.f35014h = (TextView) inflate.findViewById(R.id.tv_addpay_desc);
    }

    public void updateContent(final WalletPageInfo.PayMethodSection payMethodSection) {
        if (payMethodSection == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f35016j = payMethodSection;
        if (TextUtils.isEmpty(payMethodSection.title)) {
            this.f35008b.setVisibility(8);
        } else {
            this.f35008b.setVisibility(0);
            this.f35009c.setText(payMethodSection.title);
        }
        if (TextUtils.isEmpty(payMethodSection.helpUrl)) {
            this.f35010d.setVisibility(8);
            this.f35008b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f35010d.setVisibility(0);
            this.f35008b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletPayMethodSectionView.this.mListener != null) {
                        ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodHelpEvent(payMethodSection.helpUrl);
                    }
                }
            });
        }
        if (payMethodSection.signEntry != null) {
            this.f35012f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletPayMethodSectionView.this.mListener != null) {
                        ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodAddEvent(WalletPayMethodSectionView.this.f35016j.signEntry.dialogInfo);
                    }
                }
            });
            this.f35013g.setText(payMethodSection.signEntry.title);
            this.f35014h.setText(payMethodSection.signEntry.desc);
        }
        m26706a(payMethodSection.payMethodItems);
    }

    /* renamed from: a */
    private void m26706a(List<WalletPageInfo.PayMethodItem> list) {
        this.f35011e.removeAllViews();
        if (list != null && list.size() > 0) {
            int size = list.size();
            if (list.size() > 6 && !this.f35015i) {
                size = 6;
            }
            for (int i = 0; i < size; i++) {
                final WalletPageInfo.PayMethodItem payMethodItem = list.get(i);
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_global_v_paymethod_section_item, (ViewGroup) null, false);
                inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this.mContext, 60.0f)));
                TextView textView = (TextView) inflate.findViewById(R.id.tv_paymethod_desc);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_paymethod_right_text);
                View findViewById = inflate.findViewById(R.id.iv_paymethod_check);
                GlideUtils.with2load2into(getContext(), payMethodItem.iconUrl, (ImageView) inflate.findViewById(R.id.iv_paymethod_icon));
                ((TextView) inflate.findViewById(R.id.tv_paymethod_name)).setText(payMethodItem.title);
                if (TextUtils.isEmpty(payMethodItem.desc)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setEnabled(payMethodItem.cardStatus != 1);
                    textView.setText(payMethodItem.desc);
                }
                if (payMethodItem.channelId == 190 || payMethodItem.channelId == 120) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (WalletPayMethodSectionView.this.mListener != null) {
                                ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodItemClickEvent(payMethodItem);
                            }
                        }
                    });
                }
                if (payMethodItem.expired == 1 && !TextUtils.isEmpty(payMethodItem.expiredDesc)) {
                    textView2.setVisibility(0);
                    textView2.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.wallet_boleto_cashin_tv_min_value_red));
                    textView2.setText(payMethodItem.expiredDesc);
                }
                this.f35011e.addView(inflate);
                if (i != size - 1) {
                    WalletLineViewHelper.addLeftMarginLineView(this.mContext, this.f35011e);
                }
            }
            if (list.size() > 6) {
                View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_global_v_paymethod_section_expand, (ViewGroup) null, false);
                inflate2.setLayoutParams(new RelativeLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this.mContext, 45.0f)));
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        WalletPayMethodSectionView walletPayMethodSectionView = WalletPayMethodSectionView.this;
                        boolean unused = walletPayMethodSectionView.f35015i = !walletPayMethodSectionView.f35015i;
                        WalletPayMethodSectionView walletPayMethodSectionView2 = WalletPayMethodSectionView.this;
                        walletPayMethodSectionView2.updateContent(walletPayMethodSectionView2.f35016j);
                    }
                });
                if (this.f35015i) {
                    inflate2.findViewById(R.id.tv_more).setVisibility(8);
                    inflate2.findViewById(R.id.tv_less).setVisibility(0);
                } else {
                    inflate2.findViewById(R.id.tv_more).setVisibility(0);
                    inflate2.findViewById(R.id.tv_less).setVisibility(8);
                }
                this.f35011e.addView(inflate2);
            }
        }
    }

    public void apply(IViewFreezeApplyer.FreezeState freezeState) {
        if (freezeState != null && freezeState.isFreeze) {
            this.f35013g.setTextColor(ResourcesHelper.getColor(getContext(), R.color.pay_base_orange_disable));
            this.f35014h.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_gray_disable));
            this.f35012f.setOnClickListener((View.OnClickListener) null);
        }
    }
}
