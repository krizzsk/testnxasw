package com.didi.entrega.customer.map;

import android.os.Looper;
import android.os.MessageQueue;
import com.didi.common.map.Map;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;

public final class MapLazyLoader {
    public static final int MAP_DEFAULT_DELAY = 5000;

    /* renamed from: a */
    private static final String f22034a = "MapLazyLoader";

    /* renamed from: b */
    private static MapLazyLoader f22035b = new MapLazyLoader();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f22036c = false;
    public boolean mLazyloadApolloOn = false;

    private MapLazyLoader() {
        boolean isMapLazyLoadOn = CustomerApolloUtil.isMapLazyLoadOn();
        this.mLazyloadApolloOn = isMapLazyLoadOn;
        LogUtil.m18185i(f22034a, isMapLazyLoadOn ? "lazyload apollo on" : "lazyload apollo off");
    }

    public static MapLazyLoader getLoader() {
        return f22035b;
    }

    public void resetMapLazyLoader() {
        this.f22036c = false;
    }

    public boolean loadMapDelayed(int i) {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        UiHandlerUtil.postDelayed(new Runnable() {
            public void run() {
                if (!MapLazyLoader.this.f22036c) {
                    LogUtil.m18185i(MapLazyLoader.f22034a, "loadMapDelayed");
                    MapLazyLoader.this.m18281a();
                    boolean unused = MapLazyLoader.this.f22036c = true;
                }
            }
        }, (long) i);
        return true;
    }

    public boolean loadMapNextIdle() {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        if (this.f22036c) {
            return true;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                LogUtil.m18185i(MapLazyLoader.f22034a, "loadMapNextIdle");
                MapLazyLoader.this.m18281a();
                return false;
            }
        });
        this.f22036c = true;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18281a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                RecordTracker.Builder.create().setTag(MapLazyLoader.f22034a).setLogModule("m-map|").setMessage("onMapInitFinish").setLogCategory("c-state|").build().info();
            }
        });
    }
}
