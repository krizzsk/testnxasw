package com.didichuxing.apollo.sdk.dataprovider;

import android.content.Context;
import android.os.SystemClock;
import com.didi.global.fintech.cashier.core.GlobalCashierCoreModule;
import com.didichuxing.apollo.sdk.IAppInfoDelegate;
import com.didichuxing.apollo.sdk.IUserInfoDelegate;
import com.didichuxing.apollo.sdk.dataprovider.IDataProvider;
import com.didichuxing.apollo.sdk.log.ILogDelegate;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.apollo.sdk.model.ResponseObj;
import com.didichuxing.apollo.sdk.model.ToggleData;
import com.didichuxing.apollo.sdk.net.HttpRequest;
import com.didichuxing.apollo.sdk.net.ObjectCallback;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.utils.HotPatchUtil;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataProvider implements IDataProvider<ToggleData> {

    /* renamed from: a */
    private static final String f48262a = "cache_key_last_response";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ExecutorService f48263b = Executors.newSingleThreadExecutor();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final HashMap<String, String> f48264c = new HashMap<>();

    /* renamed from: d */
    private String f48265d = "";

    /* renamed from: e */
    private IUserInfoDelegate f48266e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IAppInfoDelegate f48267f;

    /* renamed from: g */
    private RequestHandler f48268g;

    /* renamed from: h */
    private UpdatePolicy f48269h = new UpdatePolicy();

    /* renamed from: i */
    private ILogDelegate f48270i;

    /* renamed from: j */
    private long f48271j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ResponseObj f48272k;

    /* renamed from: l */
    private Context f48273l;

    public static class UpdatePolicy {
        public long minUpdateInterval;
    }

    public DataProvider(Context context, String str, IUserInfoDelegate iUserInfoDelegate, IAppInfoDelegate iAppInfoDelegate, RequestHandler requestHandler) {
        this.f48273l = context;
        if (str != null) {
            this.f48265d = str;
        }
        this.f48266e = iUserInfoDelegate;
        this.f48267f = iAppInfoDelegate;
        this.f48268g = requestHandler;
        DCache.init(this.f48273l);
    }

    public void setUpdatePolicy(UpdatePolicy updatePolicy) {
        if (updatePolicy != null) {
            this.f48269h = updatePolicy;
        }
    }

    public void setLogDelegate(ILogDelegate iLogDelegate) {
        this.f48270i = iLogDelegate;
    }

    public void getData(IDataProvider.IGetCallback<ToggleData> iGetCallback) {
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "dp getData start");
        if (HotPatchUtil.enable()) {
            ResponseObj responseObj = (ResponseObj) DCache.getObject(f48262a, ResponseObj.class);
            if (responseObj == null || responseObj.getToggleMap().size() <= 0) {
                iGetCallback.onFail();
            } else {
                if (LogUtils.DEBUG) {
                    LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "getData " + responseObj);
                }
                this.f48272k = responseObj;
                iGetCallback.onGetData(new ToggleData(responseObj.key, responseObj.getToggleMap()));
                return;
            }
        }
        LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "dp getData end");
    }

    public void update(IDataProvider.IUpdateCallback<ToggleData> iUpdateCallback) {
        if (!m36174c()) {
            iUpdateCallback.onFail();
            return;
        }
        if (this.f48272k == null) {
            this.f48272k = (ResponseObj) DCache.getObject(f48262a, ResponseObj.class);
        }
        ResponseObj responseObj = this.f48272k;
        String str = (responseObj == null || responseObj.code != 0) ? "" : this.f48272k.md5;
        final String valueOf = String.valueOf(SystemClock.uptimeMillis());
        f48264c.put(str, valueOf);
        final String str2 = str;
        final IDataProvider.IUpdateCallback<ToggleData> iUpdateCallback2 = iUpdateCallback;
        HttpRequest.getApolloConfig(this.f48273l, this.f48265d, str, this.f48266e, this.f48267f, this.f48268g, new ObjectCallback<ResponseObj>(ResponseObj.class) {
            public void onComplete(ResponseObj responseObj) {
                if (!valueOf.equals(DataProvider.f48264c.get(str2))) {
                    iUpdateCallback2.onFail();
                    return;
                }
                LogUtils.m36178d("ObjectCallback#onComplete ResponseObj: " + responseObj);
                if (responseObj == null) {
                    iUpdateCallback2.onFail();
                } else if (responseObj.code == 0) {
                    ResponseObj unused = DataProvider.this.f48272k = responseObj;
                    if (DataProvider.this.f48267f != null) {
                        responseObj.appFullVersion = DataProvider.this.f48267f.getFullVersion();
                    }
                    DataProvider.f48263b.execute(new OneShotDumpTask(responseObj));
                    iUpdateCallback2.onUpdate(new ToggleData(responseObj.key, responseObj.getToggleMap()));
                } else if (responseObj.code == -1) {
                    iUpdateCallback2.onFail();
                } else if (responseObj.code == 304) {
                    iUpdateCallback2.onNoChange();
                } else {
                    iUpdateCallback2.onFail();
                }
            }

            public void onError(Exception exc) {
                LogUtils.m36178d("ObjectCallback#onError");
                exc.printStackTrace();
                iUpdateCallback2.onFail();
            }
        });
        this.f48271j = System.currentTimeMillis();
    }

    public void clear() {
        this.f48272k = null;
        DCache.clearCache(f48262a);
    }

    /* renamed from: c */
    private boolean m36174c() {
        if (this.f48269h != null && System.currentTimeMillis() - this.f48271j <= this.f48269h.minUpdateInterval) {
            return false;
        }
        return true;
    }

    public void setmRequestHandler(RequestHandler requestHandler) {
        this.f48268g = requestHandler;
    }

    public String getFullAppVersionWhenCached() {
        ResponseObj responseObj = this.f48272k;
        if (responseObj == null) {
            return "";
        }
        return responseObj.appFullVersion;
    }

    private class OneShotDumpTask implements Runnable {

        /* renamed from: r */
        ResponseObj f48274r;

        OneShotDumpTask(ResponseObj responseObj) {
            this.f48274r = responseObj;
        }

        public void run() {
            LogUtils.m36179d(GlobalCashierCoreModule.APOLLO, "dump cache to file" + this.f48274r);
            DCache.putObject(DataProvider.f48262a, this.f48274r);
        }
    }
}
