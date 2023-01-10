package com.didi.map.global.sctx.server;

import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.model.LatLng;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.global.task.engine.GlobalTaskEngine;
import com.didi.map.google.util.DLog;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import java.util.List;

public abstract class BaseSctxDataProvider implements ISctxDataProvider {

    /* renamed from: a */
    private static final String f30142a = BaseSctxDataProvider.class.getSimpleName();

    /* renamed from: b */
    private ISctxDataProvider.DataSearchOptions f30143b;

    /* renamed from: c */
    private GlobalTaskEngine f30144c;
    protected IDataCallback mDataCallback;
    protected RuntimeErrorCollect mRuntimeErrorCollect;
    protected boolean mStop;
    protected long mSyncInterval;
    protected Handler mUIThreadHandler;
    protected SctxCaseParser sctxCaseParser;

    /* renamed from: a */
    private long mo82325a(long j) {
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
    public abstract void doSyncInBackground(PassengerOrderRouteReq passengerOrderRouteReq);

    public /* synthetic */ List<LatLng> getRoutePoints() {
        return ISctxDataProvider.CC.$default$getRoutePoints(this);
    }

    public /* synthetic */ List<TrafficItem> getTrafficItems() {
        return ISctxDataProvider.CC.$default$getTrafficItems(this);
    }

    public BaseSctxDataProvider(ISctxDataProvider.DataSearchOptions dataSearchOptions, RuntimeErrorCollect runtimeErrorCollect) {
        this(dataSearchOptions, runtimeErrorCollect, (SctxCaseParser) null);
    }

    public BaseSctxDataProvider(ISctxDataProvider.DataSearchOptions dataSearchOptions, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser2) {
        this.mSyncInterval = 3000;
        this.mUIThreadHandler = new Handler(Looper.getMainLooper());
        this.f30143b = dataSearchOptions;
        this.mRuntimeErrorCollect = runtimeErrorCollect;
        this.sctxCaseParser = sctxCaseParser2;
    }

    public void resetDataSearchOptions(ISctxDataProvider.DataSearchOptions dataSearchOptions) {
        this.f30143b = dataSearchOptions;
    }

    public void resetRuntimeErrorCollect(RuntimeErrorCollect runtimeErrorCollect) {
        this.mRuntimeErrorCollect = runtimeErrorCollect;
    }

    /* renamed from: a */
    private void m23443a() {
        if (this.f30144c == null) {
            this.f30144c = new GlobalTaskEngine((int) this.mSyncInterval, new Runnable() {
                public final void run() {
                    BaseSctxDataProvider.this.m23444b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23444b() {
        this.mUIThreadHandler.post(new Runnable() {
            public final void run() {
                BaseSctxDataProvider.this.m23445c();
            }
        });
        doSyncInBackground((PassengerOrderRouteReq) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23445c() {
        IDataCallback iDataCallback = this.mDataCallback;
        if (iDataCallback != null) {
            iDataCallback.onStart();
        }
    }

    public void startSync() {
        DLog.m23519d(f30142a, "BaseSctxDataProvider::startSnc()", new Object[0]);
        this.mStop = false;
        m23443a();
        GlobalTaskEngine globalTaskEngine = this.f30144c;
        if (globalTaskEngine != null) {
            globalTaskEngine.start();
        }
    }

    public void runImmediately(final PassengerOrderRouteReq passengerOrderRouteReq) {
        new Thread() {
            public void run() {
                try {
                    BaseSctxDataProvider.this.doSyncInBackground(passengerOrderRouteReq);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void resumeSync() {
        DLog.m23519d(f30142a, "BaseSctxDataProvider::resumeSync()", new Object[0]);
        this.mStop = false;
        GlobalTaskEngine globalTaskEngine = this.f30144c;
        if (globalTaskEngine != null) {
            globalTaskEngine.resume();
        }
    }

    public void pauseSync() {
        DLog.m23519d(f30142a, "BaseSctxDataProvider::pauseSync()", new Object[0]);
        this.mStop = true;
        GlobalTaskEngine globalTaskEngine = this.f30144c;
        if (globalTaskEngine != null) {
            globalTaskEngine.pause();
        }
    }

    public void stopSync() {
        DLog.m23519d(f30142a, "BaseSctxDataProvider::stopSync()", new Object[0]);
        this.mStop = true;
        GlobalTaskEngine globalTaskEngine = this.f30144c;
        if (globalTaskEngine != null) {
            globalTaskEngine.stop();
            this.f30144c = null;
        }
    }

    public void setInterval(long j) {
        String str = f30142a;
        DLog.m23519d(str, "BaseSctxDataProvider::setInterval() interval: " + j, new Object[0]);
        long a = mo82325a(j);
        if (this.mSyncInterval != a) {
            this.mSyncInterval = a;
            GlobalTaskEngine globalTaskEngine = this.f30144c;
            if (globalTaskEngine != null) {
                globalTaskEngine.setLoopTimeMillis((int) a);
            }
        }
    }

    public synchronized ISctxDataProvider.DataSearchOptions getDataSearchOptions() {
        return this.f30143b;
    }

    public void setCallback(IDataCallback iDataCallback) {
        this.mDataCallback = iDataCallback;
    }

    public boolean isRunning() {
        GlobalTaskEngine globalTaskEngine = this.f30144c;
        return globalTaskEngine != null && globalTaskEngine.isRunning();
    }

    public void destroy() {
        this.mStop = true;
        this.mUIThreadHandler.removeCallbacksAndMessages((Object) null);
        stopSync();
    }
}
