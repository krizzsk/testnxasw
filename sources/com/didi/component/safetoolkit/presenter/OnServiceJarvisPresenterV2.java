package com.didi.component.safetoolkit.presenter;

import android.os.Bundle;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.sdk.app.ActivityStack;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.TextUtil;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.Map;

public class OnServiceJarvisPresenterV2 extends AbsJarvisPresenterV2 {

    /* renamed from: a */
    private ActivityStack.OnStackChangedAdapter f17283a = new ActivityStack.OnStackChangedAdapter() {
        public void onAppResume() {
            super.onAppResume();
            BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, new Boolean(false));
            OnServiceJarvisPresenterV2.this.requestJarvisStatus();
        }
    };

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17284b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            BaseEventPublisher.getPublisher().removeStickyEvent(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY);
            BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.OnService.EVENT_DRIVERBAR_SHARE_VISIBILITY, new Boolean(false));
            OnServiceJarvisPresenterV2.this.requestJarvisStatus();
        }
    };

    public OnServiceJarvisPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        requestJarvisStatus();
        if (GlobalSfManager.getInstance().getPanelData() == null) {
            GlobalSfManager.getInstance().refreshPanelData(0, (Map<String, Object>) null, (BffResponseListener<GlobalSfPanelData>) null);
        }
    }

    /* access modifiers changed from: protected */
    public String getPage() {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (order.status == 4 || order.status == 1) {
                switch (order.substatus) {
                    case 4003:
                    case 4004:
                    case 4007:
                        str = GPageIdConstant.G_PAGE_ID_ARRIVAL;
                        break;
                    case 4006:
                        str = GPageIdConstant.G_PAGE_ID_PROC;
                        break;
                    default:
                        str = "pick";
                        break;
                }
            } else {
                str = "";
            }
            if (!TextUtil.isEmpty(str)) {
                return str;
            }
        }
        Object globalAttr = OmegaSDK.getGlobalAttr("g_PageId");
        if (globalAttr instanceof String) {
            return (String) globalAttr;
        }
        return GPageIdConstant.G_PAGE_ID_PROC;
    }

    /* access modifiers changed from: protected */
    public void register() {
        super.register();
        ActivityStack.addStackChangedListener(this.f17283a);
        subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17284b);
    }

    /* access modifiers changed from: protected */
    public void unRegister() {
        super.unRegister();
        ActivityStack.removeStackChangedListener(this.f17283a);
        unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17284b);
    }
}
