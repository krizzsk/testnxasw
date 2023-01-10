package com.didi.map.global.component.line.data.cache;

import android.os.Handler;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.data.cache.MultiLineCacheInstance;
import com.didi.map.global.component.line.data.param.MultiRouteLineRequest;
import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;
import com.didichuxing.routesearchsdk.multi.SingleRouteReqParam;
import java.lang.ref.SoftReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiLineCacheInstance {

    /* renamed from: a */
    private static final int f28065a = 10;

    /* renamed from: d */
    private static volatile MultiLineCacheInstance f28066d;

    /* renamed from: b */
    private List<MultiLineRouteCache> f28067b = new CopyOnWriteArrayList();

    /* renamed from: c */
    private final String f28068c = "LineCacheTag";

    private MultiLineCacheInstance() {
    }

    public static MultiLineCacheInstance getCacheInstance() {
        if (f28066d == null) {
            synchronized (MultiLineCacheInstance.class) {
                if (f28066d == null) {
                    f28066d = new MultiLineCacheInstance();
                    new ClearCacheHandler(f28066d).clearCache();
                }
            }
        }
        return f28066d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22083a() {
        List<MultiLineRouteCache> list;
        if (f28066d != null && (list = this.f28067b) != null) {
            list.clear();
            this.f28067b = null;
            f28066d = null;
        }
    }

    public void addRouteToCache(MultiLineRouteCache multiLineRouteCache) {
        List<MultiLineRouteCache> list = this.f28067b;
        if (list != null && multiLineRouteCache != null) {
            if (list.size() >= 10) {
                this.f28067b.remove(0);
            }
            this.f28067b.add(multiLineRouteCache);
        }
    }

    public MultiRoutePlanRes getRouteInCache(MultiRouteLineRequest multiRouteLineRequest) {
        List<MultiLineRouteCache> list = this.f28067b;
        if (list == null) {
            return null;
        }
        for (MultiLineRouteCache next : list) {
            if (next != null && next.param != null && m22085a(next.param, multiRouteLineRequest)) {
                return next.planRes;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m22085a(MultiRouteLineRequest multiRouteLineRequest, MultiRouteLineRequest multiRouteLineRequest2) {
        if (multiRouteLineRequest2 == null || multiRouteLineRequest == null) {
            DLog.m10773d("LineCacheTag", "路线参数为空", new Object[0]);
            return false;
        } else if (multiRouteLineRequest.getLineParams() == null || multiRouteLineRequest2.getLineParams() == null) {
            DLog.m10773d("LineCacheTag", "多路段路线参数为空", new Object[0]);
            return false;
        } else if (multiRouteLineRequest.getLineParams().size() != multiRouteLineRequest2.getLineParams().size()) {
            DLog.m10773d("LineCacheTag", "多路段路线参数个数不一致", new Object[0]);
            return false;
        } else {
            boolean z = false;
            for (int i = 0; i < multiRouteLineRequest.getLineParams().size(); i++) {
                z = m22086a(multiRouteLineRequest2.getLineParams().get(i), multiRouteLineRequest.getLineParams().get(i));
                if (!z) {
                    return false;
                }
            }
            return z;
        }
    }

    /* renamed from: a */
    private boolean m22086a(SingleRouteReqParam singleRouteReqParam, SingleRouteReqParam singleRouteReqParam2) {
        if (!(singleRouteReqParam == null || singleRouteReqParam2 == null)) {
            if (singleRouteReqParam2.getWayPoints() == null && singleRouteReqParam.getWayPoints() == null) {
                return true;
            }
            if (singleRouteReqParam2.getWayPoints() == null || singleRouteReqParam.getWayPoints() == null) {
                DLog.m10773d("LineCacheTag", "途经点不同", new Object[0]);
            } else if (singleRouteReqParam2.getWayPoints().size() != singleRouteReqParam.getWayPoints().size()) {
                DLog.m10773d("LineCacheTag", "途经点个数不一致", new Object[0]);
                return false;
            } else {
                for (int i = 0; i < singleRouteReqParam2.getWayPoints().size(); i++) {
                    if (!LatLngUtils.isSameLatLng(new LatLng((double) singleRouteReqParam2.getWayPoints().get(i).point.lat.floatValue(), (double) singleRouteReqParam2.getWayPoints().get(i).point.lng.floatValue()), new LatLng((double) singleRouteReqParam.getWayPoints().get(i).point.lat.floatValue(), (double) singleRouteReqParam.getWayPoints().get(i).point.lng.floatValue()))) {
                        DLog.m10773d("LineCacheTag", "途经点不同", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static class ClearCacheHandler extends Handler {
        private int destroyCacheDelayTime = 300000;
        private SoftReference<MultiLineCacheInstance> instanceSoftReference;

        public ClearCacheHandler(MultiLineCacheInstance multiLineCacheInstance) {
            this.instanceSoftReference = new SoftReference<>(multiLineCacheInstance);
        }

        public void clearCache() {
            postDelayed(new Runnable() {
                public final void run() {
                    MultiLineCacheInstance.ClearCacheHandler.this.lambda$clearCache$0$MultiLineCacheInstance$ClearCacheHandler();
                }
            }, (long) this.destroyCacheDelayTime);
        }

        public /* synthetic */ void lambda$clearCache$0$MultiLineCacheInstance$ClearCacheHandler() {
            if (this.instanceSoftReference.get() != null) {
                this.instanceSoftReference.get().m22083a();
            }
        }
    }

    public static class MultiLineRouteCache {
        MultiRouteLineRequest param;
        MultiRoutePlanRes planRes;

        public MultiLineRouteCache(MultiRouteLineRequest multiRouteLineRequest, MultiRoutePlanRes multiRoutePlanRes) {
            this.param = multiRouteLineRequest;
            this.planRes = multiRoutePlanRes;
        }
    }
}
