package com.didi.map.sdk.sharetrack.google.inner.net;

import android.os.AsyncTask;
import com.didi.map.sdk.proto.driver_gl.DriverOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.DriverOrderRouteRes;
import com.didi.map.sdk.sharetrack.callback.ISearchRouteCallback;
import com.didi.map.sdk.sharetrack.common.NetUtils;
import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import com.didi.map.sdk.sharetrack.google.inner.model.GRoute;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.squareup.wire.Wire;
import java.util.ArrayList;

public class SctxRouteFetcher extends AsyncTask<String, Integer, DriverOrderRouteRes> {

    /* renamed from: a */
    private static final String f31324a = "SctxRouteFetcher";

    /* renamed from: b */
    private DriverOrderRouteReq f31325b;

    /* renamed from: c */
    private ISearchRouteCallback f31326c;

    /* access modifiers changed from: protected */
    public void onProgressUpdate(Integer... numArr) {
    }

    public SctxRouteFetcher(DriverOrderRouteReq driverOrderRouteReq, ISearchRouteCallback iSearchRouteCallback) {
        this.f31325b = driverOrderRouteReq;
        this.f31326c = iSearchRouteCallback;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        ISearchRouteCallback iSearchRouteCallback = this.f31326c;
        if (iSearchRouteCallback != null) {
            iSearchRouteCallback.onBeginToSearch();
        }
    }

    /* access modifiers changed from: protected */
    public DriverOrderRouteRes doInBackground(String... strArr) {
        DriverOrderRouteReq driverOrderRouteReq = this.f31325b;
        if (!(driverOrderRouteReq == null || strArr == null || strArr.length <= 0 || driverOrderRouteReq == null)) {
            try {
                return (DriverOrderRouteRes) new Wire((Class<?>[]) new Class[0]).parseFrom(NetUtils.doPost(strArr[0], driverOrderRouteReq.toByteArray()), DriverOrderRouteRes.class);
            } catch (Exception e) {
                e.printStackTrace();
                DLog.m23962d(f31324a, "DirectionsFetcher doInBackground(),Exception,%s", e.toString());
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(DriverOrderRouteRes driverOrderRouteRes) {
        String str;
        String str2;
        if (this.f31326c != null) {
            ArrayList arrayList = new ArrayList();
            if (driverOrderRouteRes != null) {
                arrayList.add(new NaviRoute(new GRoute(driverOrderRouteRes)));
            }
            Object[] objArr = new Object[2];
            String str3 = "";
            if (driverOrderRouteRes == null) {
                str = str3;
            } else {
                str = str3 + driverOrderRouteRes.ret;
            }
            objArr[0] = str;
            if (driverOrderRouteRes == null) {
                str2 = str3;
            } else {
                str2 = str3 + driverOrderRouteRes.msg;
            }
            objArr[1] = str2;
            DLog.m23962d(f31324a, "DirectionsFetcher doInBackground(),onPostExecute,%s , %s", objArr);
            ISearchRouteCallback iSearchRouteCallback = this.f31326c;
            if (driverOrderRouteRes != null) {
                str3 = str3 + driverOrderRouteRes.ret;
            }
            iSearchRouteCallback.onFinishToSearch(arrayList, str3);
        }
    }
}
