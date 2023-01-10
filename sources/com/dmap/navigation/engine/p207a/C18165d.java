package com.dmap.navigation.engine.p207a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.dmap.navigation.api.core.INaviTrafficUpdater;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.jni.swig.APIRequestHelper;
import com.dmap.navigation.jni.swig.APITrafficRequestCallback;
import com.dmap.navigation.jni.swig.NaviInfo;
import com.dmap.navigation.jni.swig.RequestInfo;
import com.dmap.navigation.jni.swig.SWIGTYPE_p_unsigned_char;
import com.dmap.navigation.jni.swig.TrafficNaviAPI;
import com.dmap.navigation.jni.swig.TrafficResponse;
import java.math.BigInteger;

/* renamed from: com.dmap.navigation.engine.a.d */
/* compiled from: TrafficAPIImpl */
public final class C18165d implements INaviTrafficUpdater {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final TrafficNaviAPI f54295a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Handler f54296b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C18181n f54297c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public INaviTrafficUpdater.Callback f54298d;

    /* renamed from: e */
    private final APITrafficRequestCallback f54299e = new APITrafficRequestCallback() {
        public final void onBegin() {
            HWLog.m20433i("nv_t", "onBegin");
            if (C18165d.this.f54298d != null) {
                C18165d.this.f54296b.post(new Runnable() {
                    public final void run() {
                        if (C18165d.this.f54298d != null) {
                            C18165d.this.f54298d.onBegin();
                        }
                    }
                });
            }
        }

        public final void onFinish(TrafficResponse trafficResponse) {
            HWLog.m20433i("nv_t", "onFinish");
            final C18177j jVar = new C18177j(trafficResponse);
            if (C18165d.this.f54298d != null) {
                C18165d.this.f54296b.post(new Runnable() {
                    public final void run() {
                        if (C18165d.this.f54298d != null) {
                            C18165d.this.f54298d.onFinish(jVar);
                        }
                    }
                });
            }
        }
    };

    /* renamed from: f */
    private final APIRequestHelper f54300f = new APIRequestHelper() {
        public final void onPost(int i, final String str, SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i2) {
            HWLog.m20433i("nv_t", "url = " + str + " , body size = " + i2);
            if (!TextUtils.isEmpty(str)) {
                final byte[] a = C18180m.m40466a(sWIGTYPE_p_unsigned_char, i2);
                C18165d.this.f54296b.postDelayed(new Runnable() {
                    public final void run() {
                        AsyncNetUtils.doPost(str, a, new AsyncNetUtils.Callback() {
                            public final void onFailed(int i, Exception exc) {
                            }

                            public final void onSuccess(byte[] bArr) {
                                HWLog.m20433i("nv_t", "result size = " + bArr.length);
                                C18165d.this.f54295a.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
                                HWLog.binary_i((byte) 3, bArr, System.currentTimeMillis());
                            }
                        });
                    }
                }, (long) i);
                return;
            }
            HWLog.m20433i("nv_t", "url = null");
        }

        public final RequestInfo getRequestInfo() {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setTraceId(C18180m.m40465a(C18165d.this.f54297c.f54371aL.getImei()));
            requestInfo.setCurrentTime(BigInteger.valueOf(System.currentTimeMillis()));
            requestInfo.setSessionId(C18165d.this.f54297c.getSessionId());
            requestInfo.setSeq(C18165d.this.f54297c.getSeq());
            requestInfo.setSpanId(C18180m.m40467b(C18165d.this.f54297c.f54371aL.getImei()));
            requestInfo.setLogId(C18180m.m40467b(C18165d.this.f54297c.f54371aL.getImei()) + C18180m.m40467b(C18165d.this.f54297c.f54371aL.getImei()));
            return requestInfo;
        }
    };

    public C18165d(INaviContext iNaviContext, NaviInfo naviInfo) {
        C18181n nVar = (C18181n) iNaviContext;
        this.f54297c = nVar;
        TrafficNaviAPI trafficNaviAPI = new TrafficNaviAPI(nVar.f54372aM, this.f54297c.f54371aL, this.f54297c.f54373aN);
        this.f54295a = trafficNaviAPI;
        trafficNaviAPI.setHelper(this.f54300f);
        this.f54295a.setCallback(this.f54299e);
        if (naviInfo != null) {
            this.f54295a.setNaviInfo(naviInfo);
        }
    }

    public final byte[] getRequestData() {
        return C18180m.m40466a(this.f54295a.getRequestData(), this.f54295a.getRequestDataLength());
    }

    public final void parseData(byte[] bArr, INaviTrafficUpdater.Callback callback) {
        this.f54298d = callback;
        this.f54295a.onResponse(bArr, bArr.length, (int) (System.currentTimeMillis() / 1000));
    }

    public final void enqueue(INaviTrafficUpdater.Callback callback) {
        this.f54298d = callback;
        this.f54295a.execute();
    }

    public final void cancel() {
        this.f54296b.removeCallbacksAndMessages((Object) null);
        this.f54298d = null;
        this.f54295a.cancel();
    }
}
