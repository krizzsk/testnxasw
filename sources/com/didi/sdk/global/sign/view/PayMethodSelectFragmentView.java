package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.LayoutParamsUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.view.helper.GuideViewHelper;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.sdk.global.sign.view.helper.RedDotViewHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PayMethodSelectFragmentView extends PayMethodBaseFragmentView implements View.OnClickListener {

    /* renamed from: a */
    private LinearLayout f39097a;

    /* renamed from: b */
    private LinearLayout f39098b;

    /* renamed from: c */
    private LinearLayout f39099c;

    /* renamed from: d */
    private PaySelPageData f39100d;

    /* renamed from: e */
    private EnterprisePayway f39101e;

    /* renamed from: f */
    private RelativeLayout f39102f;

    /* renamed from: g */
    private TextView f39103g;

    /* renamed from: h */
    private AccountFreezeData f39104h = null;

    public PayMethodSelectFragmentView(Context context) {
        super(context);
        m29440a(context);
    }

    public PayMethodSelectFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29440a(context);
    }

    /* renamed from: a */
    private void m29440a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_paymethod_select, this, true);
        this.f39099c = (LinearLayout) findViewById(R.id.ll_paymethod_container);
        this.f39097a = (LinearLayout) findViewById(R.id.ll_empty);
        this.f39098b = (LinearLayout) findViewById(R.id.ll_content);
        this.f39102f = (RelativeLayout) findViewById(R.id.freeze_banner_container);
        this.f39103g = (TextView) findViewById(R.id.banner_title_tv);
        this.f39097a.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mPayMethodPageEventListener != null) {
            if (view.getId() == R.id.freeze_banner_container) {
                AccountFreezeData accountFreezeData = this.f39104h;
                this.mPayMethodPageEventListener.onPageUrlClicked((accountFreezeData == null || !accountFreezeData.isJumpable(0)) ? "" : this.f39104h.getLink(0));
                return;
            }
            this.mPayMethodPageEventListener.onPageClickEvent(view, this.f39100d);
        }
    }

    public void updateContentView(PaySelPageData paySelPageData, DidiGlobalPayMethodListData.Entrance entrance, EnterprisePayway enterprisePayway) {
        this.f39100d = paySelPageData;
        this.f39101e = enterprisePayway;
        if (paySelPageData == null || paySelPageData.payMethodList == null || paySelPageData.payMethodList.size() == 0) {
            showEmptyView();
            return;
        }
        showContentView();
        this.f39104h = paySelPageData.accountFreezeData;
        if (!WalletApolloUtil.isNewPayMethodListEnable() || CollectionUtil.isEmpty((Collection<?>) paySelPageData.groupList)) {
            this.mCardViewManager.insertPayMethodView(this.f39099c, paySelPageData.payMethodList, enterprisePayway);
        } else {
            m29441a(this.f39104h);
            this.mCardViewManager.insertPayMethodViewByGroup(this.f39099c, paySelPageData.payMethodList, paySelPageData.groupList, enterprisePayway);
        }
        PayMethodSelectHelper.checkCombine(this.mPayMethodViewList);
        RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
        GuideViewHelper.showGuideView(this.mContext, this.mPayMethodViewList);
    }

    /* renamed from: a */
    private void m29441a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData != null && accountFreezeData.isBannerValid()) {
            this.f39102f.setVisibility(0);
            LayoutParamsUtil.resetLayoutMarginInV(this, 0, -9999);
            this.f39103g.setText(accountFreezeData.getTitle(0));
            if (!accountFreezeData.isJumpable(0)) {
                this.f39102f.findViewById(R.id.gotodetail_img).setVisibility(8);
            } else {
                this.f39102f.setOnClickListener(this);
            }
        }
    }

    public int getEnterpriseFlag() {
        EnterprisePayway enterprisePayway = this.f39101e;
        if (enterprisePayway == null) {
            return 1;
        }
        return enterprisePayway.toggle ? 3 : 2;
    }

    public void showEmptyView() {
        this.f39098b.setVisibility(8);
        this.f39097a.setVisibility(0);
    }

    public void showContentView() {
        this.f39098b.setVisibility(0);
        this.f39097a.setVisibility(8);
    }

    public List<PaySelItemData> getSelectedPayMethod() {
        ArrayList arrayList = new ArrayList();
        if (!(this.mPayMethodViewList == null || this.mPayMethodViewList.size() == 0)) {
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if (payMethodCardView.getIsSelected()) {
                    arrayList.add(payMethodCardView.getPayMethodItemInfo());
                }
            }
        }
        return arrayList;
    }

    public boolean hasSelectablePayMethod() {
        if (!(this.mPayMethodViewList == null || this.mPayMethodViewList.size() == 0)) {
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if ((payMethodCardView.getPayMethodItemInfo().style == 3 || payMethodCardView.getPayMethodItemInfo().style == 1) && payMethodCardView.getPayMethodItemInfo().isEnabled && payMethodCardView.getPayMethodItemInfo().isSufficient) {
                    return true;
                }
            }
        }
        return false;
    }

    public void doPayMethodPerformClick(PaySelItemData paySelItemData) {
        PaySelPageData paySelPageData;
        if (paySelItemData != null) {
            SystemUtils.log(3, "wallet", "Replay click on item: " + paySelItemData.toString(), (Throwable) null, "com.didi.sdk.global.sign.view.PayMethodSelectFragmentView", 212);
            if (this.mPayMethodViewList != null && this.mPayMethodViewList.size() != 0 && (paySelPageData = this.f39100d) != null && paySelPageData.payMethodList != null && this.f39100d.payMethodList.size() != 0) {
                for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                    if (paySelItemData.channelId == payMethodCardView.getChannelId()) {
                        PaySelItemData payMethodItemInfo = payMethodCardView.getPayMethodItemInfo();
                        if (TextUtil.isEmpty(paySelItemData.cardIndex) || paySelItemData.cardIndex.equalsIgnoreCase(payMethodItemInfo.cardIndex)) {
                            payMethodCardView.performClick();
                            return;
                        }
                    }
                }
            }
        }
    }

    public void doEnterprisePayMethodPerformClick(int i) {
        PaySelPageData paySelPageData;
        if (this.mPayMethodViewList != null && this.mPayMethodViewList.size() != 0 && (paySelPageData = this.f39100d) != null && paySelPageData.payMethodList != null && this.f39100d.payMethodList.size() != 0) {
            PaySelItemData paySelItemData = null;
            for (PayMethodCardView payMethodCardView : this.mPayMethodViewList) {
                if (i == payMethodCardView.getChannelId()) {
                    paySelItemData = payMethodCardView.getPayMethodItemInfo();
                }
            }
            if (paySelItemData != null) {
                for (PayMethodCardView payMethodCardView2 : this.mPayMethodViewList) {
                    if (i == payMethodCardView2.getChannelId()) {
                        payMethodCardView2.setIsSelected(true);
                    } else if (!m29442a(payMethodCardView2.getPayMethodItemInfo(), paySelItemData)) {
                        payMethodCardView2.setIsSelected(false);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m29442a(PaySelItemData paySelItemData, PaySelItemData paySelItemData2) {
        return (paySelItemData == null || paySelItemData.allowedCombineTags == null || !paySelItemData.allowedCombineTags.contains(Integer.valueOf(paySelItemData2.combineTag))) ? false : true;
    }
}
