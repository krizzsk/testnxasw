package com.didi.travel.psnger.p171v2.api;

import com.didi.travel.p172v2.biz.api.RemoteCallback;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.ICarOrder;

/* renamed from: com.didi.travel.psnger.v2.api.GetOrderDetailBffCallbackAdapter */
public class GetOrderDetailBffCallbackAdapter extends RemoteCallback<DTSDKOrderDetail> implements ITravelOrderListener {

    /* renamed from: a */
    private ITravelOrderListener f46907a;

    public GetOrderDetailBffCallbackAdapter(ITravelOrderListener iTravelOrderListener) {
        this.f46907a = iTravelOrderListener;
    }

    public void onSuccess(ICarOrder iCarOrder) {
        ITravelOrderListener iTravelOrderListener = this.f46907a;
        if (iTravelOrderListener != null) {
            iTravelOrderListener.onSuccess(iCarOrder);
        }
    }

    public void onError(int i, String str) {
        ITravelOrderListener iTravelOrderListener = this.f46907a;
        if (iTravelOrderListener != null) {
            iTravelOrderListener.onError(i, str);
        }
    }

    public void onFail(int i, String str) {
        ITravelOrderListener iTravelOrderListener = this.f46907a;
        if (iTravelOrderListener != null) {
            iTravelOrderListener.onFail(i, str);
        }
    }

    public void onTimeout(String str) {
        ITravelOrderListener iTravelOrderListener = this.f46907a;
        if (iTravelOrderListener != null) {
            iTravelOrderListener.onTimeout(str);
        }
    }
}
