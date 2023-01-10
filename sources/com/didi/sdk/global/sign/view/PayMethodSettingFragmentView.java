package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.view.helper.RedDotViewHelper;
import com.taxis99.R;

public class PayMethodSettingFragmentView extends PayMethodBaseFragmentView implements View.OnClickListener {

    /* renamed from: a */
    private LinearLayout f39105a;

    /* renamed from: b */
    private LinearLayout f39106b;

    /* renamed from: c */
    private LinearLayout f39107c;

    /* renamed from: d */
    private LinearLayout f39108d;

    /* renamed from: e */
    private LinearLayout f39109e;

    /* renamed from: f */
    private LinearLayout f39110f;

    /* renamed from: g */
    private TextView f39111g;

    /* renamed from: h */
    private TextView f39112h;

    /* renamed from: i */
    private ImageView f39113i;

    /* renamed from: j */
    private PaySelPageData f39114j;

    public int getEnterpriseFlag() {
        return 0;
    }

    public PayMethodSettingFragmentView(Context context) {
        super(context);
        m29443a(context);
    }

    public PayMethodSettingFragmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m29443a(context);
    }

    /* renamed from: a */
    private void m29443a(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.one_payment_v_global_paymethod_setting, this, true);
        this.f39108d = (LinearLayout) findViewById(R.id.ll_paymethod_container);
        this.f39107c = (LinearLayout) findViewById(R.id.ll_promotion_container);
        this.f39109e = (LinearLayout) findViewById(R.id.ll_paymethod);
        this.f39110f = (LinearLayout) findViewById(R.id.ll_promotion);
        this.f39105a = (LinearLayout) findViewById(R.id.ll_empty);
        this.f39106b = (LinearLayout) findViewById(R.id.ll_content);
        this.f39111g = (TextView) findViewById(R.id.tv_promotion_title);
        this.f39112h = (TextView) findViewById(R.id.tv_paymethod_title);
        ImageView imageView = (ImageView) findViewById(R.id.iv_paymethod_rules);
        this.f39113i = imageView;
        imageView.setOnClickListener(this);
        this.f39105a.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.mPayMethodPageEventListener != null) {
            this.mPayMethodPageEventListener.onPageClickEvent(view, this.f39114j);
        }
    }

    public void showEmptyView() {
        this.f39106b.setVisibility(8);
        this.f39105a.setVisibility(0);
    }

    public void showContentView() {
        this.f39106b.setVisibility(0);
        this.f39105a.setVisibility(8);
    }

    public void updateContentView(PaySelPageData paySelPageData, DidiGlobalPayMethodListData.Entrance entrance, EnterprisePayway enterprisePayway) {
        this.f39114j = paySelPageData;
        if (paySelPageData == null || paySelPageData.payMethodList == null || this.f39114j.payMethodList.size() == 0) {
            showEmptyView();
            return;
        }
        showContentView();
        if (TextUtils.isEmpty(this.f39114j.ruleUrl)) {
            this.f39113i.setVisibility(8);
        }
        if (paySelPageData.payMethodList == null || paySelPageData.payMethodList.size() <= 0) {
            this.f39109e.setVisibility(8);
        } else {
            this.f39109e.setVisibility(0);
            this.f39112h.setText(paySelPageData.payMethodTitle);
            this.mCardViewManager.insertPayMethodView(this.f39108d, paySelPageData.payMethodList, (EnterprisePayway) null);
            RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
        }
        if (paySelPageData.promotionList == null || paySelPageData.promotionList.size() <= 0) {
            this.f39110f.setVisibility(8);
            return;
        }
        this.f39110f.setVisibility(0);
        this.f39111g.setText(paySelPageData.promotionTitle);
        this.mCardViewManager.insertPromotionView(this.f39107c, paySelPageData.promotionList);
        RedDotViewHelper.showRedDot(this.mContext, this.mPayMethodViewList);
    }
}
