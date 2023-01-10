package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.INoOpenPositionView;
import com.didi.component.unenablecity.IOrderBanView;
import com.didi.component.unenablecity.IPreheatCityView;
import com.didi.component.unenablecity.IUnableCityContainerView;
import com.didi.component.unenablecity.IUnopenedCityView;
import com.didi.component.unenablecity.utils.HomeCardOmegaUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.taxis99.R;

public class UnableCityContainerView implements IUnableCityContainerView {

    /* renamed from: a */
    private static final int f18086a = 1;

    /* renamed from: b */
    private static final int f18087b = 2;

    /* renamed from: c */
    private static final int f18088c = 3;

    /* renamed from: d */
    private static final int f18089d = 4;

    /* renamed from: e */
    private static final int f18090e = 5;

    /* renamed from: f */
    private int f18091f = 0;

    /* renamed from: g */
    private Activity f18092g;

    /* renamed from: h */
    private ViewGroup f18093h;

    /* renamed from: i */
    private AbsUnableCityPresenter f18094i;

    /* renamed from: j */
    private IUnopenedCityView f18095j;

    /* renamed from: k */
    private IPreheatCityView f18096k;

    /* renamed from: l */
    private IOrderBanView f18097l;

    /* renamed from: m */
    private SafetyTrainView f18098m;

    /* renamed from: n */
    private INoOpenPositionView f18099n;

    public UnableCityContainerView(Activity activity, ViewGroup viewGroup) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ResourcesHelper.getColor(activity, R.color.trans));
        this.f18093h = linearLayout;
        this.f18092g = activity;
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f18094i = absUnableCityPresenter;
    }

    public View getView() {
        return this.f18093h;
    }

    public void showUnopenedCityView() {
        m15321a();
        NewUnopenedCityView newUnopenedCityView = new NewUnopenedCityView(this.f18092g, this.f18093h);
        this.f18095j = newUnopenedCityView;
        newUnopenedCityView.setPresenter(this.f18094i);
        this.f18091f = 1;
    }

    public void showNoOpenPositionView() {
        m15321a();
        NoOpenPositionView noOpenPositionView = new NoOpenPositionView(this.f18092g, this.f18093h);
        this.f18099n = noOpenPositionView;
        noOpenPositionView.setPresenter(this.f18094i);
        this.f18091f = 5;
    }

    public void showPreheatView() {
        m15321a();
        NewPreheatCityView newPreheatCityView = new NewPreheatCityView(this.f18092g, this.f18093h);
        this.f18096k = newPreheatCityView;
        newPreheatCityView.setPresenter(this.f18094i);
        this.f18091f = 2;
    }

    public void showOrderBanView(OrderBanCardInfo orderBanCardInfo, BusinessContext businessContext) {
        m15321a();
        OrderBanView orderBanView = new OrderBanView(this.f18092g, this.f18093h, businessContext);
        this.f18097l = orderBanView;
        orderBanView.setOrderBanCardInfo(orderBanCardInfo);
        this.f18097l.setPresenter(this.f18094i);
        HomeCardOmegaUtils.sendUnableCityCardSw(HomeCardOmegaUtils.CARD_ID_ORDER_BAN);
        this.f18091f = 3;
    }

    public boolean showSafetyTrainView(SafetyTrainCardInfo safetyTrainCardInfo) {
        if (FormStore.getInstance().isOrderBan() && this.f18091f == 3) {
            return false;
        }
        m15321a();
        SafetyTrainView safetyTrainView = new SafetyTrainView(this.f18092g, this.f18093h);
        this.f18098m = safetyTrainView;
        safetyTrainView.setSafetyTrainCardInfo(safetyTrainCardInfo);
        this.f18098m.setPresenter(this.f18094i);
        HomeCardOmegaUtils.sendUnableCityCardSw(HomeCardOmegaUtils.CARD_ID_EDU);
        this.f18091f = 4;
        return true;
    }

    public boolean hideSafetyTrainView() {
        if (this.f18098m == null || this.f18091f != 4) {
            return false;
        }
        m15321a();
        return true;
    }

    public void cleanType() {
        this.f18091f = 0;
    }

    /* renamed from: a */
    private void m15321a() {
        this.f18093h.removeAllViews();
        this.f18095j = null;
        this.f18096k = null;
        this.f18097l = null;
        this.f18098m = null;
        this.f18099n = null;
    }

    public void setTitle(CharSequence charSequence) {
        IPreheatCityView iPreheatCityView = this.f18096k;
        if (iPreheatCityView != null) {
            iPreheatCityView.setTitle(charSequence);
        }
    }

    public void setContent(CharSequence charSequence) {
        IPreheatCityView iPreheatCityView = this.f18096k;
        if (iPreheatCityView != null) {
            iPreheatCityView.setContent(charSequence);
        }
    }

    public void showImage(String str) {
        IPreheatCityView iPreheatCityView = this.f18096k;
        if (iPreheatCityView != null) {
            iPreheatCityView.showImage(str);
        }
    }

    public void showImage(int i) {
        IPreheatCityView iPreheatCityView = this.f18096k;
        if (iPreheatCityView != null) {
            iPreheatCityView.showImage(i);
        }
    }

    public void setData(GlobalTemplateCardModel globalTemplateCardModel) {
        IUnopenedCityView iUnopenedCityView = this.f18095j;
        if (iUnopenedCityView != null) {
            iUnopenedCityView.setData(globalTemplateCardModel);
        }
    }

    public void setNoPositionEnableListener(View.OnClickListener onClickListener) {
        INoOpenPositionView iNoOpenPositionView = this.f18099n;
        if (iNoOpenPositionView != null) {
            iNoOpenPositionView.setNoPositionEnableListener(onClickListener);
        }
    }

    public void setNoPositionManualEnterListener(View.OnClickListener onClickListener) {
        INoOpenPositionView iNoOpenPositionView = this.f18099n;
        if (iNoOpenPositionView != null) {
            iNoOpenPositionView.setNoPositionManualEnterListener(onClickListener);
        }
    }
}
