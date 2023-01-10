package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.os.Handler;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.flow.scene.order.confirm.normal.line.BubblePageCache;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.EstimatedPriceRoute;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class BubblePageCache {

    /* renamed from: c */
    private static volatile BubblePageCache f29192c;

    /* renamed from: a */
    private List<Value> f29193a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private final String f29194b = "BubblePageCache";

    /* renamed from: d */
    private boolean f29195d;

    /* renamed from: e */
    private ClearCacheHandler f29196e;

    private BubblePageCache() {
        readApollo();
    }

    public void readApollo() {
        this.f29195d = MapFlowApolloUtils.enableMultiLineCache();
    }

    public static BubblePageCache getInstance() {
        if (f29192c == null) {
            synchronized (BubblePageCache.class) {
                if (f29192c == null) {
                    f29192c = new BubblePageCache();
                }
            }
        }
        return f29192c;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22682a() {
        List<Value> list;
        if (f29192c != null && (list = this.f29193a) != null) {
            list.clear();
        }
    }

    public void addBubblePageToCache(LatLng latLng, LatLng latLng2, List<LatLng> list, BubblePageRes bubblePageRes) {
        if (this.f29195d) {
            Key key = new Key(latLng, latLng2, list);
            List<Value> list2 = this.f29193a;
            if (list2 != null && bubblePageRes != null) {
                list2.clear();
                this.f29193a.add(new Value(key, bubblePageRes));
                if (this.f29196e == null) {
                    this.f29196e = new ClearCacheHandler(f29192c);
                }
                this.f29196e.removeCallbacksAndMessages((Object) null);
                this.f29196e.clearCache();
                DLog.m10773d("BubblePageCache", "添加到缓存", new Object[0]);
            }
        }
    }

    public BubblePageRes getBubblePageInCache(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        List<Value> list2;
        if (this.f29195d && (list2 = this.f29193a) != null) {
            for (Value next : list2) {
                Key key = new Key(latLng, latLng2, list);
                if (next != null && next.key != null && m22684a(next.key, key)) {
                    DLog.m10773d("BubblePageCache", "使用缓存数据", new Object[0]);
                    return next.res;
                }
            }
        }
        return null;
    }

    public long getDefaultRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        if (!this.f29195d) {
            return 0;
        }
        for (Value next : this.f29193a) {
            Key key = new Key(latLng, latLng2, list);
            if (next == null || next.key == null || !m22684a(next.key, key)) {
                DLog.m10773d("BubblePageCache", "起终途径点不一致，没有缓存", new Object[0]);
            } else {
                DLog.m10773d("BubblePageCache", "缓存default route id:" + next.defaultRouteId, new Object[0]);
                return next.defaultRouteId;
            }
        }
        return 0;
    }

    public long getSelectedRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list) {
        if (!this.f29195d) {
            return 0;
        }
        for (Value next : this.f29193a) {
            Key key = new Key(latLng, latLng2, list);
            if (next == null || next.key == null || !m22684a(next.key, key)) {
                DLog.m10773d("BubblePageCache", "起终途径点不一致，没有缓存", new Object[0]);
            } else {
                DLog.m10773d("BubblePageCache", "缓存selected route id:" + next.selectedRouteId, new Object[0]);
                return next.selectedRouteId;
            }
        }
        return 0;
    }

    /* renamed from: a */
    private boolean m22684a(Key key, Key key2) {
        if (key == null || key2 == null) {
            DLog.m10773d("BubblePageCache", "路线参数为空", new Object[0]);
            return false;
        } else if (!LatLngUtils.isSameLatLng(key.start, key2.start) || !LatLngUtils.isSameLatLng(key.end, key2.end)) {
            DLog.m10773d("BubblePageCache", "起终点不一致", new Object[0]);
            return false;
        } else if (key.wayPoint == null && key2.wayPoint == null) {
            return true;
        } else {
            if (key.wayPoint == null || key2.wayPoint == null) {
                DLog.m10773d("BubblePageCache", "途经点不同", new Object[0]);
                return false;
            } else if (key.wayPoint.size() != key2.wayPoint.size()) {
                DLog.m10773d("BubblePageCache", "途经点个数不一致", new Object[0]);
                return false;
            } else {
                for (int i = 0; i < key.wayPoint.size(); i++) {
                    if (!LatLngUtils.isSameLatLng(key.wayPoint.get(i), key2.wayPoint.get(i))) {
                        DLog.m10773d("BubblePageCache", "途经点不同", new Object[0]);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public void updateSelectedRouteId(LatLng latLng, LatLng latLng2, List<LatLng> list, long j) {
        if (this.f29195d) {
            for (Value next : this.f29193a) {
                Key key = new Key(latLng, latLng2, list);
                if (!(next == null || next.key == null || !m22684a(next.key, key))) {
                    next.updateSelectedRouteId(j);
                }
            }
        }
    }

    private static class ClearCacheHandler extends Handler {
        private long destroyCacheDelayTime = TimeUnit.MINUTES.toMillis((long) MapFlowApolloUtils.getMultiLineCacheTime());
        private SoftReference<BubblePageCache> instanceSoftReference;

        public ClearCacheHandler(BubblePageCache bubblePageCache) {
            this.instanceSoftReference = new SoftReference<>(bubblePageCache);
        }

        public void clearCache() {
            postDelayed(new Runnable() {
                public final void run() {
                    BubblePageCache.ClearCacheHandler.this.lambda$clearCache$0$BubblePageCache$ClearCacheHandler();
                }
            }, this.destroyCacheDelayTime);
        }

        public /* synthetic */ void lambda$clearCache$0$BubblePageCache$ClearCacheHandler() {
            if (this.instanceSoftReference.get() != null) {
                this.instanceSoftReference.get().m22682a();
            }
        }
    }

    private static class Key {
        LatLng end;
        LatLng start;
        List<LatLng> wayPoint;

        public Key(LatLng latLng, LatLng latLng2, List<LatLng> list) {
            this.start = latLng;
            this.end = latLng2;
            this.wayPoint = list;
        }
    }

    private static class Value {
        long defaultRouteId;
        Key key;
        BubblePageRes res;
        List<Long> routes = new ArrayList();
        long selectedRouteId;

        public Value(Key key2, BubblePageRes bubblePageRes) {
            this.key = key2;
            this.res = bubblePageRes;
            if (bubblePageRes != null && bubblePageRes.estimateInfo != null && bubblePageRes.estimateInfo.route != null) {
                if (bubblePageRes.estimateInfo.route.size() > 0) {
                    long longValue = bubblePageRes.estimateInfo.route.get(0).routeID.longValue();
                    this.defaultRouteId = longValue;
                    this.selectedRouteId = longValue;
                }
                for (EstimatedPriceRoute estimatedPriceRoute : bubblePageRes.estimateInfo.route) {
                    this.routes.add(estimatedPriceRoute.routeID);
                }
            }
        }

        public void updateSelectedRouteId(long j) {
            if (this.routes.contains(Long.valueOf(j))) {
                this.selectedRouteId = j;
            }
        }
    }
}
