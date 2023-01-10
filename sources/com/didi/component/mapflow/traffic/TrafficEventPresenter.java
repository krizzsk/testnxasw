package com.didi.component.mapflow.traffic;

import android.os.Bundle;
import android.view.View;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.HashMap;
import java.util.List;

public class TrafficEventPresenter extends IPresenter<TrafficEventView> implements IXpCardBindDataReady {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<View> f16342a = new BaseEventPublisher.OnEventListener<View>() {
        public void onEvent(String str, View view) {
            TrafficEventPresenter.this.mLogger.info("mTrafficShowEventListener", new Object[0]);
            View unused = TrafficEventPresenter.this.f16344c = view;
            ((TrafficEventView) TrafficEventPresenter.this.mView).update(view);
            TrafficEventPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NATIVE);
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16343b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            Logger logger = TrafficEventPresenter.this.mLogger;
            logger.info("mTrafficHideEventListener " + TrafficEventPresenter.this.mRemoved, new Object[0]);
            if (!TrafficEventPresenter.this.mRemoved) {
                ((TrafficEventView) TrafficEventPresenter.this.mView).removeView(TrafficEventPresenter.this.f16344c);
                View unused = TrafficEventPresenter.this.f16344c = null;
                TrafficEventPresenter.this.doPublish(BaseEventKeys.NewXpanel.EVENT_REFRESH_XPANEL_NATIVE);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f16344c;
    protected Logger mLogger = LoggerFactory.getLogger(getClass());

    public TrafficEventPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (this.f16344c != null) {
            ((TrafficEventView) this.mView).update(this.f16344c);
            iXpCardBindDataReadyCallback.ready(true);
            return;
        }
        iXpCardBindDataReadyCallback.ready(false);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel("passenger_map_push_card", XERequestKey.SCENE_TRIP, (XEResponseCallback) new XEResponseCallback() {
            public void onFailed(String str, EngineErrorException engineErrorException) {
            }

            public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            }
        });
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                return new HashMap();
            }
        };
        XERegister.registerTemplate(xERegisterModel);
        this.f16344c = null;
        subscribe(BaseEventKeys.Map.EVENT_TRAFFIC_EVENT_SHOW_MAP, this.f16342a);
        subscribe(BaseEventKeys.Map.EVENT_TRAFFIC_EVENT_HIDE_MAP, this.f16343b);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate("passenger_map_push_card");
        if (!(this.mView == null || this.f16344c == null)) {
            ((TrafficEventView) this.mView).removeView(this.f16344c);
        }
        this.f16344c = null;
        unsubscribe(BaseEventKeys.Map.EVENT_TRAFFIC_EVENT_SHOW_MAP, this.f16342a);
        unsubscribe(BaseEventKeys.Map.EVENT_TRAFFIC_EVENT_HIDE_MAP, this.f16343b);
    }
}
