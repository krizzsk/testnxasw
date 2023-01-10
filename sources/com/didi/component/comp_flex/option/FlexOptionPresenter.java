package com.didi.component.comp_flex.option;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.common.common.xengine.XEngineRegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;

public class FlexOptionPresenter extends IPresenter<AbsFlexOptionView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f14043a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<Boolean> f14044b = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!bool.booleanValue()) {
                ((AbsFlexOptionView) FlexOptionPresenter.this.mView).dismissPopupWindow();
                FlexOptionPresenter.this.f14043a.info("lxslxs: hideFlex", new Object[0]);
            }
        }
    };

    /* renamed from: c */
    private XEResponseCallback f14045c = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null && xEngineData.jsonObject != null) {
                JsonObject jsonObject = xEngineData.jsonObject;
                Logger b = FlexOptionPresenter.this.f14043a;
                b.info("onSuccess:FlexOptionPresenter " + jsonObject, new Object[0]);
                if (jsonObject.has("data")) {
                    JsonObject asJsonObject = jsonObject.get("data").getAsJsonObject();
                    ((AbsFlexOptionView) FlexOptionPresenter.this.mView).setOperationPanelModel((OperationPanelModel) new Gson().fromJson(asJsonObject.toString(), OperationPanelModel.class));
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            FlexOptionPresenter.this.f14043a.info("onFailed: FlexOptionPresenter ", new Object[0]);
        }
    };

    public FlexOptionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XEngineRegister.register(m11645b());
        subscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f14044b);
    }

    /* renamed from: b */
    private XERegisterModel m11645b() {
        return new XERegisterModel(XERequestKey.REQUEST_KEY_FLEX_OPERATION_PANEL, XERequestKey.SCENE_TRIP, this.f14045c);
    }

    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, this.f14044b);
        ((AbsFlexOptionView) this.mView).onDestroy();
        XEngineRegister.unregister(XERequestKey.REQUEST_KEY_FLEX_OPERATION_PANEL);
    }
}
