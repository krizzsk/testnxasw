package com.didi.travel.psnger.biz.waitornot;

import android.content.Context;
import com.didi.travel.psnger.HostConstants;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.UpdateOrderInfoModel;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public class NearbyWaitRequest extends BaseRequest {

    /* renamed from: a */
    private static NearbyWaitRequest f46686a;

    /* renamed from: b */
    private INearbyWaitRpcService f46687b;

    /* renamed from: c */
    private Context f46688c;

    public static NearbyWaitRequest getInstance(Context context) {
        if (f46686a == null) {
            synchronized (NearbyWaitRequest.class) {
                if (f46686a == null) {
                    f46686a = new NearbyWaitRequest(context.getApplicationContext());
                }
            }
        }
        return f46686a;
    }

    private NearbyWaitRequest(Context context) {
        this.f46688c = context;
        this.f46687b = (INearbyWaitRpcService) new RpcServiceFactory(context).newRpcService(INearbyWaitRpcService.class, HostConstants.getHostApi());
    }

    public void confirmNearbyWait(Context context, Map<String, Object> map, ResponseListener<NearbyWaitPerception> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(context);
        createBaseParams.putAll(map);
        this.f46687b.confirmNearbyWait(createBaseParams, getRpcCallback(responseListener, new NearbyWaitPerception()));
    }

    public void updateCompanyOrderInfo(Map<String, Object> map, ResponseListener<UpdateOrderInfoModel> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46688c);
        createBaseParams.putAll(map);
        this.f46687b.updateCompanyOrderInfo(createBaseParams, getRpcCallback(responseListener, new UpdateOrderInfoModel()));
    }
}
