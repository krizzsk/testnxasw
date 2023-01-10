package com.didi.component.realtimeprice;

import com.didi.component.core.IView;
import com.didi.component.realtimeprice.model.PayInfo;
import com.didi.component.realtimeprice.model.RealTimePrice;

public interface IRealTimePriceView extends IView<AbsRealTimePricePresenter> {

    public interface OnActionListener {
        void paywayChange(PayInfo payInfo);
    }

    void hideLoading();

    void hideNewbieGuide();

    void hideOnTripCoupon();

    boolean isLoading();

    void setClickable(boolean z);

    void setData(PayInfo payInfo);

    void setData(RealTimePrice realTimePrice);

    void setOnActionListener(OnActionListener onActionListener);

    void setPayWay(String str);

    void showFixedPriceGuidePopup(String str);

    void showLoading();

    void showNewbieGuide(String str);
}
