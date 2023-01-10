package com.didi.travel.psnger.common.net;

import android.content.Context;
import com.didi.travel.psnger.common.net.base.BaseRequest;
import com.didi.travel.psnger.common.net.base.GsonResponseListener;
import com.didi.travel.psnger.common.net.base.RPCServiceWrapper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.common.net.host.HostGroupManager;
import com.didi.travel.psnger.common.net.rpc.IRouteService;
import com.didi.travel.psnger.common.net.rpc.ISpecialService;
import com.didi.travel.psnger.model.response.ActivityResInfo;
import com.didi.travel.psnger.model.response.CommuteConfig;
import com.didi.travel.psnger.model.response.FixedPriceRouteData;
import com.didi.travel.psnger.model.response.MisBannerResponse;
import com.didi.travel.psnger.model.response.NearDrivers;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.HashMap;
import java.util.Map;

public class SpecialRequest extends BaseRequest {

    /* renamed from: a */
    private static SpecialRequest f46700a;

    /* renamed from: b */
    private Context f46701b;

    /* renamed from: c */
    private ISpecialService f46702c;

    /* renamed from: d */
    private ISpecialService f46703d;

    /* renamed from: e */
    private IRouteService f46704e;

    /* renamed from: f */
    private ISpecialService f46705f;

    private SpecialRequest(Context context) {
        this.f46701b = context;
        RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context);
        this.f46702c = (ISpecialService) RPCServiceWrapper.wrap(this.f46701b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiBizHost()));
        this.f46703d = (ISpecialService) RPCServiceWrapper.wrap(this.f46701b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiCarslidingHost()));
        this.f46705f = (ISpecialService) RPCServiceWrapper.wrap(this.f46701b, (ISpecialService) rpcServiceFactory.newRpcService(ISpecialService.class, HostGroupManager.getInstance().getDiDiResourcesHost()));
        this.f46704e = (IRouteService) RPCServiceWrapper.wrap(this.f46701b, (IRouteService) rpcServiceFactory.newRpcService(IRouteService.class, HostGroupManager.getInstance().getDiDiRouteTrackHost()));
    }

    public static SpecialRequest getInstance(Context context) {
        if (f46700a == null) {
            synchronized (SpecialRequest.class) {
                if (f46700a == null) {
                    f46700a = new SpecialRequest(context.getApplicationContext());
                }
            }
        }
        return f46700a;
    }

    public void reqRoute(byte[] bArr, RpcService.Callback<byte[]> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(IRouteService.KEY_BYTE_ARRAY, bArr);
        this.f46704e.reqRoute(hashMap, callback);
    }

    public void sendLocationCallNearDrivers(Map map, GsonResponseListener<NearDrivers> gsonResponseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        this.f46703d.sendLocationCallNearDrivers(createBaseParams, getGsonRpcCallback(gsonResponseListener, NearDrivers.class));
    }

    public void sendOnServiceNearDrivers(Map map, GsonResponseListener<NearDrivers> gsonResponseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        this.f46703d.sendOnServiceNearDrivers(createBaseParams, getGsonRpcCallback(gsonResponseListener, NearDrivers.class));
    }

    public void requestDriveRoute(byte[] bArr, RpcService.Callback<byte[]> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(IRouteService.KEY_BYTE_ARRAY, bArr);
        this.f46704e.requestDriveRoute(hashMap, callback);
    }

    public void getActivityMulti(String[] strArr, String[] strArr2, Map map, ResponseListener<MisBannerResponse> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        this.f46705f.getActivityMulti(createBaseParams, getRpcCallback(responseListener, new MisBannerResponse(strArr, strArr2)));
    }

    public void getCommuteConfig(Map map, ResponseListener<CommuteConfig> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        this.f46702c.getCommuteConfig(createBaseParams, getRpcCallback(responseListener, new CommuteConfig()));
    }

    public void getActivityRes(Map map, ResponseListener<ActivityResInfo> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        if (createBaseParams.get("token") == null) {
            createBaseParams.remove("token");
        }
        this.f46705f.getActivityRes(createBaseParams, getRpcCallback(responseListener, new ActivityResInfo()));
    }

    public Object getMapRouteInfo(Map map, ResponseListener<FixedPriceRouteData> responseListener) {
        Map<String, Object> createBaseParams = createBaseParams(this.f46701b);
        createBaseParams.putAll(map);
        return this.f46702c.getMapRouteInfo(createBaseParams, getRpcCallback(responseListener, new FixedPriceRouteData()));
    }
}
