package com.didi.map.global.sctx;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.sctx.SctxService;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.event_reveal.TrafficEventModel;
import com.didi.map.global.sctx.model.PushInfo;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.global.sctx.server.IDataCallback;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.global.sctx.server.SctxDataProviderFactory;
import com.didi.map.google.model.PageCachedApolloValue;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;

public abstract class AbstractSctxService implements SctxService {

    /* renamed from: a */
    Map f29898a;

    /* renamed from: b */
    Context f29899b;

    /* renamed from: c */
    String f29900c;

    /* renamed from: d */
    SctxService.SctxCallback f29901d;

    /* renamed from: e */
    SctxTripParam f29902e;

    /* renamed from: f */
    SctxService.SctxSearchGetter f29903f;

    /* renamed from: g */
    SctxService.SctxOraNetAgent f29904g;

    /* renamed from: h */
    PageCachedApolloValue f29905h;

    /* renamed from: i */
    SctxCaseParser f29906i;

    /* renamed from: j */
    RuntimeErrorCollect f29907j;

    /* renamed from: k */
    boolean f29908k = false;

    /* renamed from: l */
    boolean f29909l = true;

    /* renamed from: m */
    long f29910m;

    /* renamed from: n */
    int f29911n = 0;

    /* renamed from: o */
    long f29912o;

    /* renamed from: p */
    IDataCallback f29913p;

    /* renamed from: q */
    private ISctxDataProvider f29914q;

    /* renamed from: r */
    private String f29915r;

    /* access modifiers changed from: protected */
    public long checkInterval(long j) {
        if (j == 0) {
            return 3000;
        }
        if (j < 1000) {
            return 1000;
        }
        if (j > 15000) {
            return 15000;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public abstract PassengerOrderRouteReq getOraRequestBytes();

    /* access modifiers changed from: protected */
    public long getOraRequestInterval() {
        return 3000;
    }

    public void handleTriggerEventDialog(TrafficEventModel trafficEventModel, int i) {
    }

    /* access modifiers changed from: protected */
    public void onDataSyncFail(String str) {
    }

    /* access modifiers changed from: protected */
    public void onDataSyncStart() {
    }

    /* access modifiers changed from: protected */
    public void onDataSyncSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPreStart();

    public AbstractSctxService(SctxTripParam sctxTripParam) {
        initBaseParam(sctxTripParam);
        m23152a();
    }

    /* access modifiers changed from: protected */
    public void initBaseParam(SctxTripParam sctxTripParam) {
        this.f29902e = sctxTripParam;
        this.f29907j = new RuntimeErrorCollect();
        this.f29906i = new SctxCaseParser();
        this.f29898a = this.f29902e.getMap();
        this.f29899b = this.f29902e.getContext();
        this.f29900c = this.f29902e.getPassengerPhone();
        this.f29903f = this.f29902e.getSctxSearchGetter();
        this.f29905h = new PageCachedApolloValue();
    }

    /* renamed from: a */
    private void m23152a() {
        ISctxDataProvider createSctxDataProvider = SctxDataProviderFactory.createSctxDataProvider(m23153b(), this.f29907j, this.f29906i);
        this.f29914q = createSctxDataProvider;
        createSctxDataProvider.setCallback(m23154c());
        this.f29914q.setInterval(this.f29902e.getOraRequestInterval());
    }

    /* renamed from: b */
    private ISctxDataProvider.DataSearchOptions m23153b() {
        return new ISctxDataProvider.DataSearchOptions() {
            public PushInfo getPushInfo() {
                return null;
            }

            public PassengerOrderRouteReq getRequestBody() {
                return AbstractSctxService.this.getOraRequestBytes();
            }

            public String getUrl() {
                return AbstractSctxService.this.f29905h.getOraRequestUrl(AbstractSctxService.this.f29899b);
            }

            public Context getContext() {
                if (AbstractSctxService.this.f29899b != null) {
                    return AbstractSctxService.this.f29899b.getApplicationContext();
                }
                return null;
            }
        };
    }

    /* renamed from: c */
    private IDataCallback m23154c() {
        C106042 r0 = new IDataCallback() {
            public void onStart() {
                if (!AbstractSctxService.this.f29909l) {
                    AbstractSctxService.this.onDataSyncStart();
                }
            }

            public void onSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes) {
                if (!AbstractSctxService.this.f29909l) {
                    AbstractSctxService.this.onDataSyncSuccess(mapPassengeOrderRouteRes);
                }
            }

            public void onError(String str) {
                if (!AbstractSctxService.this.f29909l) {
                    AbstractSctxService.this.onDataSyncFail(str);
                }
            }
        };
        this.f29913p = r0;
        return r0;
    }

    /* access modifiers changed from: protected */
    public long getRouteExtensionAnimationDuration() {
        long routeExtensionAnimationDuration = this.f29902e.getRouteExtensionAnimationDuration();
        if (routeExtensionAnimationDuration <= 0) {
            return 3000;
        }
        return routeExtensionAnimationDuration;
    }

    /* access modifiers changed from: protected */
    public void refreshSyncInterval() {
        this.f29914q.setInterval(getOraRequestInterval());
    }

    public void setSctxOraNetAgent(SctxService.SctxOraNetAgent sctxOraNetAgent) {
        this.f29904g = sctxOraNetAgent;
    }

    public void registerSctxCallback(SctxService.SctxCallback sctxCallback) {
        this.f29901d = sctxCallback;
    }

    /* renamed from: d */
    private String m23155d() {
        if (TextUtils.isEmpty(this.f29915r)) {
            this.f29915r = getClass().getSimpleName();
        }
        return this.f29915r;
    }

    public void enter() {
        start();
    }

    /* access modifiers changed from: protected */
    public void start() {
        DLog.m10773d(m23155d(), "start...", new Object[0]);
        if (this.f29909l) {
            this.f29909l = false;
            onPreStart();
            this.f29914q.startSync();
        }
        m23156e();
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.f29909l = true;
        DLog.m10773d(m23155d(), "stop...", new Object[0]);
        this.f29914q.stopSync();
        m23156e();
    }

    public void resume() {
        DLog.m10773d(m23155d(), "resume...", new Object[0]);
        this.f29908k = false;
        if (!this.f29909l) {
            this.f29914q.resumeSync();
        }
        m23156e();
    }

    public void pause() {
        DLog.m10773d(m23155d(), "pause...", new Object[0]);
        this.f29908k = true;
        m23156e();
        this.f29914q.pauseSync();
    }

    public void leave() {
        DLog.m10773d(m23155d(), "leave...", new Object[0]);
        stop();
    }

    public long getRouteId() {
        return this.f29910m;
    }

    /* access modifiers changed from: protected */
    public boolean isRunning() {
        return this.f29914q.isRunning();
    }

    public void runImmediately() {
        try {
            this.f29914q.runImmediately(getOraRequestBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    private void m23156e() {
        if (this.f29909l || this.f29908k) {
            this.f29912o = 0;
        } else {
            this.f29912o = System.currentTimeMillis();
        }
        DLog.m10773d("ccc", "updateSctxUseableTime mPaused:" + this.f29908k + ", mIsStop:" + this.f29909l + ",mSctxAvailableTime=" + this.f29912o, new Object[0]);
    }
}
