package com.didi.component.matchtogo20.ontrip.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.matchtogo20.ontrip.AbsMTGOnTripPresenter;
import com.didi.component.matchtogo20.ontrip.model.MatchOnTripModel;
import com.didi.component.matchtogo20.ontrip.view.IMTGOnTripView;
import com.didi.travel.psnger.model.event.UpdateWaitTimeEvent;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.List;

public class MTGOnTripPresenter extends AbsMTGOnTripPresenter implements IXpCardBindDataReady {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f16389a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f16390b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent> f16391c = new BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent>() {
        public void onEvent(String str, UpdateWaitTimeEvent updateWaitTimeEvent) {
            if (updateWaitTimeEvent != null && MTGOnTripPresenter.this.mView != null) {
                ((IMTGOnTripView) MTGOnTripPresenter.this.mView).updateWaitTiem(updateWaitTimeEvent.intWaitTime);
            }
        }
    };

    /* renamed from: d */
    private XEResponseCallback f16392d = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            for (XEComponent next : list) {
                if (XERequestKey.REQUEST_KEY_MATCH_ON_TRIP.equals(next.getId())) {
                    MatchOnTripModel matchOnTripModel = new MatchOnTripModel();
                    matchOnTripModel.parse(next.getData().toString());
                    if (matchOnTripModel.isHasContent() && MTGOnTripPresenter.this.f16389a && MTGOnTripPresenter.this.mView != null && matchOnTripModel.isHasContent()) {
                        boolean unused = MTGOnTripPresenter.this.isUpdateAccept = false;
                        ((IMTGOnTripView) MTGOnTripPresenter.this.mView).setOnTripMode(matchOnTripModel, MTGOnTripPresenter.this.f16390b);
                        MTGOnTripPresenter.this.addViewToXpanel();
                        MTGOnTripPresenter.this.doPublish(BaseEventKeys.WaitRsp.EVENT_MTG_WAIT_ACCEPT_PANEL_SHOW, true);
                        return;
                    }
                    return;
                }
            }
        }
    };

    /* renamed from: e */
    private final BaseEventPublisher.OnEventListener<Long> f16393e = new BaseEventPublisher.OnEventListener<Long>() {
        public void onEvent(String str, Long l) {
            boolean unused = MTGOnTripPresenter.this.f16389a = true;
            long unused2 = MTGOnTripPresenter.this.f16390b = l.longValue();
            XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
        }
    };

    public MTGOnTripPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.businessContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.isUpdateAccept = false;
        subscribe(BaseEventKeys.WaitRsp.EVENT_MTG_MATCH_ON_TRIP_PANEL, this.f16393e);
        subscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f16391c);
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.REQUEST_KEY_XPANEL, XERequestKey.SCENE_TRIP, this.f16392d));
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_MTG_MATCH_ON_TRIP_PANEL, this.f16393e);
        unsubscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f16391c);
        this.isUpdateAccept = false;
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        this.mXpanelController = iXpCardBindDataReadyCallback;
        if (!this.f16389a) {
            removeViewFromXpanel();
        }
        GLog.m11353d("sm  all viewBindBizDataReady showCard: " + this.f16389a);
    }
}
