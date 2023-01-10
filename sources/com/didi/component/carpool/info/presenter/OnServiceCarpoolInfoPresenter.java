package com.didi.component.carpool.info.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.PriceUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.carpool.info.model.CarPoolCardInfo;
import com.didi.component.carpool.info.view.ICarpoolInfoView;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import java.util.Collection;
import org.json.JSONObject;

public class OnServiceCarpoolInfoPresenter extends AbsCarpoolInfoPresenter implements XpNewAdapter {

    /* renamed from: a */
    private IXpCardBindDataReadyCallback f13265a;

    /* renamed from: b */
    private final BusinessContext f13266b;

    /* renamed from: c */
    private CarPoolCardInfo f13267c;

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<OrderRealtimePriceCount> f13268d = new BaseEventPublisher.OnEventListener<OrderRealtimePriceCount>() {
        public void onEvent(String str, OrderRealtimePriceCount orderRealtimePriceCount) {
            OnServiceCarpoolInfoPresenter.this.m11137a(orderRealtimePriceCount);
        }
    };

    public void onEditClick() {
    }

    public OnServiceCarpoolInfoPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f13266b = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f13268d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Service.OnService.EVENT_REALTIME_TIME_PRICE_COUNT, this.f13268d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11137a(OrderRealtimePriceCount orderRealtimePriceCount) {
        String str;
        String str2 = "";
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && orderRealtimePriceCount != null) {
            try {
                str = PriceUtils.getFeeDisplay(this.f13266b, (double) Float.parseFloat(orderRealtimePriceCount.totalFee), orderRealtimePriceCount.totalFeeText, false, PriceUtils.TYPE_REALTIME_TOTAL_FEE);
            } catch (Exception e) {
                e.printStackTrace();
                str = str2;
            }
            DTSDKOrderDetail.PaymentsWayInfo paymentsWayInfo = order.payInfo;
            if (paymentsWayInfo != null && !TextUtils.isEmpty(paymentsWayInfo.text)) {
                str2 = paymentsWayInfo.text;
                if (!TextUtils.isEmpty(paymentsWayInfo.suffix)) {
                    str2 = str2 + " " + paymentsWayInfo.suffix;
                }
            }
            ((ICarpoolInfoView) this.mView).setRealtimeFee(str, str2);
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            CarPoolCardInfo carPoolCardInfo = new CarPoolCardInfo();
            this.f13267c = carPoolCardInfo;
            carPoolCardInfo.parse(jSONObject);
            if (!CollectionUtils.isEmpty((Collection) this.f13267c.waitPoints) || !CollectionUtils.isEmpty((Collection) this.f13267c.travelInfoMsgList)) {
                ((ICarpoolInfoView) this.mView).setData(this.f13267c);
                iXpCardBindDataReadyCallback.ready(true);
                return;
            }
            iXpCardBindDataReadyCallback.ready(false);
            return;
        }
        iXpCardBindDataReadyCallback.ready(false);
    }
}
