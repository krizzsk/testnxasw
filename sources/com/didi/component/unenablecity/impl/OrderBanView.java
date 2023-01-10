package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.IOrderBanView;
import com.didi.component.unenablecity.utils.HomeCardOmegaUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.taxis99.R;

public class OrderBanView implements IOrderBanView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsUnableCityPresenter f18073a;

    /* renamed from: b */
    private View f18074b;

    /* renamed from: c */
    private TextView f18075c;

    /* renamed from: d */
    private TextView f18076d = ((TextView) this.f18074b.findViewById(R.id.tv_ban_card_content));

    /* renamed from: e */
    private TextView f18077e = ((TextView) this.f18074b.findViewById(R.id.tv_ban_card_tips));

    /* renamed from: f */
    private TextView f18078f = ((TextView) this.f18074b.findViewById(R.id.tv_ban_card_btn));

    public OrderBanView(Activity activity, ViewGroup viewGroup, BusinessContext businessContext) {
        View inflate = ViewGroup.inflate(activity, R.layout.global_new_home_destination_order_ban_card_view, viewGroup);
        this.f18074b = inflate;
        this.f18075c = (TextView) inflate.findViewById(R.id.tv_ban_card_title);
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f18073a = absUnableCityPresenter;
    }

    public View getView() {
        return this.f18074b;
    }

    public void setOrderBanCardInfo(final OrderBanCardInfo orderBanCardInfo) {
        TextView textView = this.f18075c;
        if (textView != null) {
            textView.setText(orderBanCardInfo.title);
        }
        TextView textView2 = this.f18076d;
        if (textView2 != null) {
            textView2.setText(orderBanCardInfo.content);
        }
        TextView textView3 = this.f18077e;
        if (textView3 != null) {
            textView3.setText(orderBanCardInfo.tips);
        }
        if (this.f18078f != null && !TextUtils.isEmpty(orderBanCardInfo.detailUrl) && !TextUtils.isEmpty(orderBanCardInfo.descLabel)) {
            this.f18078f.setVisibility(0);
            this.f18078f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (OrderBanView.this.f18073a != null) {
                        OrderBanView.this.f18073a.gotoWebPage(orderBanCardInfo.detailUrl);
                    }
                    HomeCardOmegaUtils.sendUnableCityCardCk(HomeCardOmegaUtils.CARD_ID_ORDER_BAN);
                }
            });
            this.f18078f.setText(orderBanCardInfo.descLabel);
        }
    }
}
