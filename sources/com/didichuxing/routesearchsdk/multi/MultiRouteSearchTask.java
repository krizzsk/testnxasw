package com.didichuxing.routesearchsdk.multi;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.common.map.util.NetUtils;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanReq;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didi.map.sdk.proto.driver_gl.SingleRouteReq;
import com.didichuxing.routesearchsdk.RouteSearchUrls;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;

public class MultiRouteSearchTask extends AsyncTask<MultiRouteSearchParam, Integer, MultiRoutePlanRes> {

    /* renamed from: a */
    private IMultiRouteSearchCallback f51125a;

    /* renamed from: b */
    private String f51126b = "";

    /* renamed from: c */
    private int f51127c;

    public MultiRouteSearchTask(int i, IMultiRouteSearchCallback iMultiRouteSearchCallback) {
        this.f51125a = iMultiRouteSearchCallback;
        this.f51127c = i;
    }

    public MultiRouteSearchTask(IMultiRouteSearchCallback iMultiRouteSearchCallback) {
        this.f51125a = iMultiRouteSearchCallback;
    }

    /* access modifiers changed from: protected */
    public MultiRoutePlanRes doInBackground(MultiRouteSearchParam... multiRouteSearchParamArr) {
        if (multiRouteSearchParamArr == null || multiRouteSearchParamArr.length <= 0) {
            this.f51126b = "request param is null";
            return null;
        }
        this.f51126b = "";
        try {
            byte[] doPost = NetUtils.doPost(m38245a(), m38247a(multiRouteSearchParamArr[0]));
            if (doPost != null) {
                return (MultiRoutePlanRes) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, MultiRoutePlanRes.class);
            }
            this.f51126b = "response is null";
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            this.f51126b = e.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        IMultiRouteSearchCallback iMultiRouteSearchCallback = this.f51125a;
        if (iMultiRouteSearchCallback != null) {
            iMultiRouteSearchCallback.onBeginToSearch();
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(MultiRoutePlanRes multiRoutePlanRes) {
        IMultiRouteSearchCallback iMultiRouteSearchCallback = this.f51125a;
        if (iMultiRouteSearchCallback != null) {
            iMultiRouteSearchCallback.onFinishToSearch(multiRoutePlanRes, this.f51126b);
            this.f51125a.onFinishToSearch(multiRoutePlanRes, this.f51126b, this.f51127c);
        }
    }

    /* renamed from: a */
    private String m38245a() {
        return RouteSearchUrls.getMultiRoutePlanUrl();
    }

    /* renamed from: a */
    private byte[] m38247a(MultiRouteSearchParam multiRouteSearchParam) {
        if (multiRouteSearchParam == null) {
            return null;
        }
        String str = "";
        MultiRoutePlanReq.Builder caller = new MultiRoutePlanReq.Builder().routeReq(m38246a(multiRouteSearchParam.getRouteReq())).token(multiRouteSearchParam.getToken()).productId(multiRouteSearchParam.getProductId()).phoneNum(TextUtils.isEmpty(multiRouteSearchParam.getPhoneNum()) ? str : multiRouteSearchParam.getPhoneNum()).caller(multiRouteSearchParam.getCaller() != null ? multiRouteSearchParam.getCaller().toString() : str);
        if (!TextUtils.isEmpty(multiRouteSearchParam.getCountryId())) {
            str = multiRouteSearchParam.getCountryId();
        }
        return caller.countryId(str).passengerId(Long.valueOf(multiRouteSearchParam.getPassengerId())).orderStage(Integer.valueOf(multiRouteSearchParam.getOrderStage())).didiVersion(multiRouteSearchParam.getDidiVersion()).orderId(multiRouteSearchParam.getOrderId()).build().toByteArray();
    }

    /* renamed from: a */
    private List<SingleRouteReq> m38246a(List<SingleRouteReqParam> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (SingleRouteReqParam next : list) {
                if (next != null) {
                    arrayList.add(new SingleRouteReq(next.getStart(), next.getEnd(), next.getWayPoints(), next.getTravelMode(), Integer.valueOf(next.getExpectStyle())));
                }
            }
        }
        return arrayList;
    }
}
