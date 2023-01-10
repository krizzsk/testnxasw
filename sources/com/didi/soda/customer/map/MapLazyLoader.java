package com.didi.soda.customer.map;

import android.os.Looper;
import android.os.MessageQueue;
import com.didi.common.map.Map;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;

public final class MapLazyLoader {
    public static final int MAP_DEFAULT_DELAY = 5000;

    /* renamed from: a */
    private static final String f43961a = "MapLazyLoader";

    /* renamed from: b */
    private static MapLazyLoader f43962b = new MapLazyLoader();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f43963c = false;
    public boolean mLazyloadApolloOn = false;

    private MapLazyLoader() {
        boolean isMapLazyLoadOn = CustomerApolloUtil.isMapLazyLoadOn();
        this.mLazyloadApolloOn = isMapLazyLoadOn;
        LogUtil.m32588i(f43961a, isMapLazyLoadOn ? "lazyload apollo on" : "lazyload apollo off");
    }

    public static MapLazyLoader getLoader() {
        return f43962b;
    }

    public void resetMapLazyLoader() {
        this.f43963c = false;
    }

    public boolean loadMapDelayed(int i) {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        UiHandlerUtil.postDelayed(new Runnable() {
            public void run() {
                if (!MapLazyLoader.this.f43963c) {
                    LogUtil.m32588i(MapLazyLoader.f43961a, "loadMapDelayed");
                    MapLazyLoader.this.m32794a();
                    boolean unused = MapLazyLoader.this.f43963c = true;
                }
            }
        }, (long) i);
        return true;
    }

    public boolean loadMapNextIdle() {
        if (!this.mLazyloadApolloOn) {
            return false;
        }
        if (this.f43963c) {
            return true;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            public boolean queueIdle() {
                LogUtil.m32588i(MapLazyLoader.f43961a, "loadMapNextIdle");
                MapLazyLoader.this.m32794a();
                return false;
            }
        });
        this.f43963c = true;
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32794a() {
        GlobalContext.initMapView(new OnMapInitCallback() {
            public void onMapInitFinish(Map map) {
                RecordTracker.Builder.create().setTag(MapLazyLoader.f43961a).setLogModule("m-map|").setMessage("onMapInitFinish").setLogCategory("c-state|").build().info();
            }
        });
    }
}
