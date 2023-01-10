package com.didi.map.global.sctx.server;

import com.didi.common.map.util.DLog;
import com.didi.common.map.util.NetUtils;
import com.didi.common.map.util.NetworkUtils;
import com.didi.map.global.sctx.case_parser.SctxCaseParser;
import com.didi.map.global.sctx.model.RuntimeErrorCollect;
import com.didi.map.global.sctx.server.ISctxDataProvider;
import com.didi.map.google.config.Config;
import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;
import com.didi.map.sdk.proto.driver_gl.PassengerOrderRouteReq;
import com.didi.map.utils.HttpNetUtils;
import com.didi.map.utils.logger.Logger;
import com.squareup.wire.Wire;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.didi.map.global.sctx.server.a */
/* compiled from: SctxOraDataProvider */
class C10641a extends BaseSctxDataProvider {

    /* renamed from: a */
    private static final String f30146a = C10641a.class.getSimpleName();

    /* renamed from: d */
    private static final long f30147d = 10;

    /* renamed from: b */
    private long f30148b;

    /* renamed from: c */
    private ExecutorService f30149c = Executors.newCachedThreadPool();

    public C10641a(ISctxDataProvider.DataSearchOptions dataSearchOptions, RuntimeErrorCollect runtimeErrorCollect, SctxCaseParser sctxCaseParser) {
        super(dataSearchOptions, runtimeErrorCollect, sctxCaseParser);
    }

    /* access modifiers changed from: protected */
    public void doSyncInBackground(PassengerOrderRouteReq passengerOrderRouteReq) {
        m23448a(passengerOrderRouteReq);
    }

    /* renamed from: a */
    private void m23448a(PassengerOrderRouteReq passengerOrderRouteReq) {
        byte[] bArr;
        byte[] bArr2;
        try {
            if (this.mRuntimeErrorCollect != null) {
                this.mRuntimeErrorCollect.checkAndReport();
                this.mRuntimeErrorCollect.reset();
                if (!NetworkUtils.checkNetworkConnected(getDataSearchOptions().getContext())) {
                    this.mRuntimeErrorCollect.setErrorCode(101);
                }
            }
            long j = -1;
            if (passengerOrderRouteReq == null) {
                PassengerOrderRouteReq requestBody = getDataSearchOptions().getRequestBody();
                if (requestBody != null) {
                    bArr = requestBody.toByteArray();
                    if (requestBody.curRouteId != null) {
                        j = requestBody.curRouteId.longValue();
                    }
                } else {
                    bArr = null;
                }
            } else {
                bArr = passengerOrderRouteReq.toByteArray();
                if (passengerOrderRouteReq.curRouteId != null) {
                    j = passengerOrderRouteReq.curRouteId.longValue();
                }
            }
            if (bArr != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (Logger.isLoggable()) {
                    Logger.m24040d("doPost start...");
                }
                if (Config.DEBUG_ORA) {
                    bArr2 = (byte[]) this.f30149c.submit(new Callable(Config.DEBUG_ORA_URL, bArr) {
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ byte[] f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final Object call() {
                            return HttpNetUtils.Instance().doPost(this.f$0, this.f$1);
                        }
                    }).get(10, TimeUnit.SECONDS);
                } else {
                    bArr2 = (byte[]) this.f30149c.submit(new Callable(getDataSearchOptions().getUrl(), bArr) {
                        public final /* synthetic */ String f$0;
                        public final /* synthetic */ byte[] f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final Object call() {
                            return NetUtils.doPost(this.f$0, this.f$1);
                        }
                    }).get(10, TimeUnit.SECONDS);
                }
                if (Logger.isLoggable()) {
                    Logger.m24040d("doPost back...");
                }
                if (mo82325a(currentTimeMillis)) {
                    this.mUIThreadHandler.post(new SctxOraDataProvider$1(this, bArr2, j));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.mRuntimeErrorCollect != null) {
                if (th instanceof TimeoutException) {
                    this.mRuntimeErrorCollect.setErrorCode(103);
                } else {
                    this.mRuntimeErrorCollect.setErrorCode(102);
                }
            }
            String message = th.getMessage();
            DLog.m10773d(f30146a, "onOraResponse err:%s", message);
            this.mUIThreadHandler.post(new SctxOraDataProvider$2(this, th, message));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23449a(byte[] bArr, long j) {
        if (bArr != null) {
            if (Logger.isLoggable()) {
                Logger.m24040d("handleSyncResult result");
            }
            try {
                MapPassengeOrderRouteRes mapPassengeOrderRouteRes = (MapPassengeOrderRouteRes) new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, MapPassengeOrderRouteRes.class);
                if (mapPassengeOrderRouteRes == null) {
                    DLog.m10773d(f30146a, "ora is null", new Object[0]);
                    if (this.mRuntimeErrorCollect != null) {
                        this.mRuntimeErrorCollect.setErrorCode(207);
                        return;
                    }
                    return;
                }
                if (!(mapPassengeOrderRouteRes.ret.intValue() == 0 || this.mRuntimeErrorCollect == null)) {
                    this.mRuntimeErrorCollect.setErrorCode(205);
                }
                if (j == 0 && ((mapPassengeOrderRouteRes.routePoints == null || mapPassengeOrderRouteRes.routePoints.dlats == null || mapPassengeOrderRouteRes.routePoints.dlats.size() == 0) && this.mRuntimeErrorCollect != null)) {
                    this.mRuntimeErrorCollect.setErrorCode(201);
                }
                if (!(this.sctxCaseParser == null || !this.sctxCaseParser.isEnable() || mapPassengeOrderRouteRes.routePoints == null || mapPassengeOrderRouteRes.routePoints.dlats == null || mapPassengeOrderRouteRes.routePoints.dlats.isEmpty())) {
                    this.sctxCaseParser.addNewRoutePath(mapPassengeOrderRouteRes.routePoints);
                }
                if (this.mDataCallback != null) {
                    this.mDataCallback.onSuccess(mapPassengeOrderRouteRes);
                }
            } catch (Throwable th) {
                DLog.m10773d(f30146a, "onOraResponse parse err:%s", th.getMessage());
                if (this.mRuntimeErrorCollect != null) {
                    this.mRuntimeErrorCollect.setErrorCode(204);
                }
                if (this.mDataCallback != null) {
                    this.mDataCallback.onError(th.getMessage());
                }
            }
        } else if (Logger.isLoggable()) {
            Logger.m24040d("handleSyncResult result is null");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo82325a(long j) {
        if (j < this.f30148b) {
            return false;
        }
        this.f30148b = j;
        return true;
    }

    public void startSync() {
        super.startSync();
        if (this.f30149c.isShutdown()) {
            this.f30149c = Executors.newCachedThreadPool();
        }
    }

    public void stopSync() {
        super.stopSync();
        this.f30149c.shutdown();
    }
}
