package com.didi.soda.pay.pospay;

import android.os.Bundle;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.pay.model.PayMethodInfoModel;
import java.io.Serializable;

public class PosListPresenter extends ICustomerPresenter<PosListView> {

    /* renamed from: a */
    private PayMethodInfoModel f46196a;

    public void onSelectPos(PayMethodInfoModel.CardInfoModel cardInfoModel) {
        if (this.f46196a != null) {
            PayChannelEntity payChannelEntity = new PayChannelEntity();
            payChannelEntity.channelId = Integer.parseInt(this.f46196a.mChannelId);
            payChannelEntity.cardSuffix = cardInfoModel.cardSuffix;
            payChannelEntity.alias = cardInfoModel.alias;
            payChannelEntity.cardIndex = cardInfoModel.cardIndex;
            payChannelEntity.cardOrg = cardInfoModel.cardOrg;
            payChannelEntity.cardName = cardInfoModel.cardName;
            payChannelEntity.cardType = cardInfoModel.cardType;
            Bundle bundle = new Bundle();
            bundle.putSerializable(Const.BundleKey.SELECT_PAYMENT_METHOD, payChannelEntity);
            getScopeContext().getNavigator().finish(bundle);
            return;
        }
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m34324a();
    }

    /* renamed from: a */
    private void m34324a() {
        Bundle bundle = getScopeContext().getBundle();
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("pos_page_param");
            if (serializable instanceof PayMethodInfoModel) {
                PayMethodInfoModel payMethodInfoModel = (PayMethodInfoModel) serializable;
                this.f46196a = payMethodInfoModel;
                ((PosListView) getLogicView()).setTitle(payMethodInfoModel.mPayTypeDesc);
                ((PosListView) getLogicView()).updateData(payMethodInfoModel.mCardInfoList);
            }
        }
    }
}
