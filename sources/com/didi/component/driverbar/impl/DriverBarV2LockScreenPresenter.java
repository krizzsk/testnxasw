package com.didi.component.driverbar.impl;

import android.os.Bundle;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.core.IMMessageListener;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.IMSessionUnreadCallback;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarV2LockScreenView;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.travel.psnger.core.model.response.DTSDKCarModel;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.TextUtil;
import org.json.JSONObject;

public class DriverBarV2LockScreenPresenter extends AbsDriverBarPresenter implements XpNewAdapter {

    /* renamed from: a */
    private BaseEventPublisher.OnEventListener<DriverBarV2Model> f14821a = new BaseEventPublisher.OnEventListener<DriverBarV2Model>() {
        public void onEvent(String str, DriverBarV2Model driverBarV2Model) {
            ((IDriverBarView) DriverBarV2LockScreenPresenter.this.mView).setData(driverBarV2Model);
            if (DriverBarV2LockScreenPresenter.this.mView instanceof IDriverBarV2LockScreenView) {
                DriverBarV2LockScreenPresenter.this.m12184b();
            }
        }
    };

    /* renamed from: b */
    private long f14822b;
    public DriverBarV2Model cardData;

    /* access modifiers changed from: protected */
    public void buildDriverCarInfo(DTSDKDriverModel dTSDKDriverModel, DTSDKCarModel dTSDKCarModel) {
    }

    /* access modifiers changed from: protected */
    public String getIMGuideText() {
        return null;
    }

    public DriverBarV2LockScreenPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.LockScreen.EVENT_REFRESH_DRIVER_BAR, this.f14821a);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.LockScreen.EVENT_REFRESH_DRIVER_BAR, this.f14821a);
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            DriverBarV2Model driverBarV2Model = new DriverBarV2Model();
            this.cardData = driverBarV2Model;
            driverBarV2Model.parse(jSONObject);
        }
        ((IDriverBarView) this.mView).setData(this.cardData);
        if (this.mView instanceof IDriverBarV2LockScreenView) {
            m12184b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12184b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.carDriver != null) {
            long j = 0;
            int i = order.productid;
            if (order.imBusinessId > 0) {
                i = order.imBusinessId;
            }
            if (!TextUtil.isEmpty(order.carDriver.did)) {
                j = TextUtil.paseLong(order.carDriver.did);
            }
            this.f14822b = IMEngine.generateSessionId(i, j);
            IMManager.getInstance().addMessageListener(new IMMessageListener() {
                public void onMessageArrive() {
                    DriverBarV2LockScreenPresenter.this.m12185c();
                }
            });
            m12185c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12185c() {
        IMManager.getInstance().getUnreadMessageCount(this.f14822b, (IMSessionUnreadCallback) new IMSessionUnreadCallback() {
            public void unReadCount(int i) {
                if (DriverBarV2LockScreenPresenter.this.mView instanceof IDriverBarV2LockScreenView) {
                    ((IDriverBarV2LockScreenView) DriverBarV2LockScreenPresenter.this.mView).setUnreadMsg(i);
                }
            }
        });
    }
}
