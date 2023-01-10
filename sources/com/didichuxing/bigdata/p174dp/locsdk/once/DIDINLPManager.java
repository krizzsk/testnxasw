package com.didichuxing.bigdata.p174dp.locsdk.once;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.LocData;
import com.didichuxing.bigdata.p174dp.locsdk.SensorMonitor;
import com.didichuxing.bigdata.p174dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p174dp.locsdk.once.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.once.util.ApolloProxy;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager */
public class DIDINLPManager {
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final int f48735j = NetworkLocTask.class.hashCode();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f48736a;

    /* renamed from: b */
    private boolean f48737b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DIDINetworkLocateProxy f48738c;

    /* renamed from: d */
    private WifiManagerWrapper f48739d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public long f48740e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile DIDILocation f48741f = null;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile long f48742g = 0;

    /* renamed from: h */
    private CellManager f48743h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LocData f48744i = null;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public volatile long f48745k = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager$DIDINLPLocationCallback */
    interface DIDINLPLocationCallback {
        void onDIDINLPLocationFail(ErrInfo errInfo);

        void onDIDINLPLocationSucc(DIDILocation dIDILocation);
    }

    public DIDINLPManager(Context context) {
        this.f48736a = context;
        this.f48738c = new DIDINetworkLocateProxy(context);
    }

    public synchronized void start() {
        if (!this.f48737b) {
            m36582b();
            m36591f();
            this.f48738c.cleanHistory(false);
            m36581a(true);
        }
    }

    public synchronized void stop() {
        if (this.f48737b) {
            m36587d();
            m36585c();
            m36581a(false);
        }
    }

    /* renamed from: b */
    private void m36582b() {
        if (this.f48743h == null) {
            CellManager instance = CellManager.getInstance();
            this.f48743h = instance;
            instance.init(this.f48736a);
            this.f48743h.getCellLocation();
        }
    }

    /* renamed from: c */
    private void m36585c() {
        WifiManagerWrapper wifiManagerWrapper = this.f48739d;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.destroy();
            this.f48739d = null;
        }
    }

    /* renamed from: d */
    private void m36587d() {
        CellManager cellManager = this.f48743h;
        if (cellManager != null) {
            cellManager.destroy();
            this.f48743h = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public synchronized boolean m36589e() {
        return this.f48737b;
    }

    /* renamed from: a */
    private synchronized void m36581a(boolean z) {
        this.f48737b = z;
    }

    public void updateNlpLocation(final DIDILocation dIDILocation) {
        if (this.f48738c != null) {
            ThreadDispatcher.getNetThread().post(new Runnable() {
                public void run() {
                    if (DIDINLPManager.this.f48738c != null) {
                        DIDINLPManager.this.f48738c.setNlpLoc(dIDILocation);
                    }
                }
            });
        }
    }

    public void setLastLoc4Filter(final DIDILocation dIDILocation) {
        if (ThreadDispatcher.getWorkThread().isAlive() && dIDILocation != null) {
            ThreadDispatcher.getWorkThread().post(new Runnable() {
                public void run() {
                    if (DIDINLPManager.this.m36589e()) {
                        DIDINLPManager.this.mo121280a(dIDILocation);
                        ThreadDispatcher.getNetThread().post(new Runnable() {
                            public void run() {
                                if (DIDINLPManager.this.f48738c != null) {
                                    if (TextUtils.equals("gps", dIDILocation.getProvider())) {
                                        DIDINLPManager.this.f48738c.cleanHistoryWithGps(dIDILocation);
                                        DLog.m36225d("loop:gps valid->lastLocData.");
                                        return;
                                    }
                                    DIDINLPManager.this.f48738c.setLastLoc(dIDILocation);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121281a(DIDINLPLocationCallback dIDINLPLocationCallback) {
        if (ThreadDispatcher.getNetThread().isAlive() && dIDINLPLocationCallback != null) {
            ThreadDispatcher.getNetThread().postDelayed(f48735j, new NetworkLocTask(dIDINLPLocationCallback), 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121279a(long j) {
        this.f48745k = j;
        WifiManagerWrapper wifiManagerWrapper = this.f48739d;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.updateWifiScanInterval(j);
        }
    }

    /* renamed from: f */
    private void m36591f() {
        if (this.f48736a != null) {
            WifiManagerWrapper instance = WifiManagerWrapper.getInstance();
            this.f48739d = instance;
            instance.init(this.f48736a);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.DIDINLPManager$NetworkLocTask */
    private class NetworkLocTask implements Runnable {
        /* access modifiers changed from: private */
        public DIDINLPLocationCallback mCallback;

        NetworkLocTask(DIDINLPLocationCallback dIDINLPLocationCallback) {
            this.mCallback = dIDINLPLocationCallback;
        }

        public void run() {
            if (DIDINLPManager.this.m36589e()) {
                ErrInfo errInfo = new ErrInfo();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < DIDINLPManager.this.f48740e || (elapsedRealtime - DIDINLPManager.this.f48740e) + DIDINLPManager.this.f48745k > 8000 || DIDINLPManager.this.f48744i == null) {
                    Handler handler = ThreadDispatcher.getNetThread().getHandler();
                    if (handler == null || !handler.hasMessages(DIDINLPManager.f48735j) || !ApolloProxy.getInstance().isDidiNlpRequestQueueOptmEnabled()) {
                        long unused = DIDINLPManager.this.f48740e = elapsedRealtime;
                        DIDINLPRequester dIDINLPRequester = new DIDINLPRequester(DIDINLPManager.this.f48736a);
                        if (DIDINLPManager.this.f48741f != null && DIDINLPManager.this.f48742g > 0) {
                            dIDINLPRequester.updatePreLocationInfo(DIDINLPManager.this.f48741f, DIDINLPManager.this.f48742g);
                        }
                        dIDINLPRequester.prepareNewRequestData();
                        errInfo.setSource("didi");
                        LocData manage = DIDINLPManager.this.f48738c.manage(dIDINLPRequester, errInfo);
                        if (manage != null) {
                            LocNTPHelper.adjustDIDINLPTimestamp(manage);
                            DIDILocation loadFromLocData = DIDILocation.loadFromLocData(manage, (LocData) null);
                            if ("gps".equals(loadFromLocData.getProvider())) {
                                DLog.m36225d(String.format("loop[network]:use last gps locData: %s", new Object[]{String.valueOf(loadFromLocData)}));
                            }
                            notifyLocationSucc(loadFromLocData);
                        } else {
                            notifyLocationFail(DIDINLPManager.this.m36577a(errInfo, dIDINLPRequester.getRequestData()));
                        }
                        LocData unused2 = DIDINLPManager.this.f48744i = manage;
                        return;
                    }
                    DLog.m36225d("requestQueueOptmEnabled notifyLocationFail");
                    errInfo.setErrNo(306);
                    errInfo.setErrMessage(ErrInfo.ERROR_MSG_HTTP_QUEUE_FULL);
                    notifyLocationFail(errInfo);
                    return;
                }
                DIDILocation loadFromLocData2 = DIDILocation.loadFromLocData(DIDINLPManager.this.f48744i, (LocData) null);
                if (loadFromLocData2 != null && "gps".equals(loadFromLocData2.getProvider())) {
                    DLog.m36225d(String.format("loop[last:%s][now:%s][cache:%s]", new Object[]{Long.valueOf(DIDINLPManager.this.f48740e), Long.valueOf(elapsedRealtime), String.valueOf(loadFromLocData2)}));
                }
                notifyLocationSucc(loadFromLocData2);
            }
        }

        private synchronized void notifyLocationSucc(final DIDILocation dIDILocation) {
            if (this.mCallback != null) {
                ThreadDispatcher.getWorkThread().post(new Runnable() {
                    public void run() {
                        NetworkLocTask.this.mCallback.onDIDINLPLocationSucc(dIDILocation);
                        DIDINLPLocationCallback unused = NetworkLocTask.this.mCallback = null;
                    }
                });
            }
        }

        private synchronized void notifyLocationFail(final ErrInfo errInfo) {
            if (this.mCallback != null) {
                ThreadDispatcher.getWorkThread().post(new Runnable() {
                    public void run() {
                        NetworkLocTask.this.mCallback.onDIDINLPLocationFail(errInfo);
                        DIDINLPLocationCallback unused = NetworkLocTask.this.mCallback = null;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ErrInfo m36577a(ErrInfo errInfo, LocationServiceRequest locationServiceRequest) {
        if (errInfo == null) {
            return null;
        }
        if (!Utils.isLocationPermissionGranted(this.f48736a) || !SensorMonitor.getInstance(this.f48736a).isGpsEnabled()) {
            errInfo.setErrNo(101);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_LOCATION_PERMISSION);
        } else if (locationServiceRequest != null && locationServiceRequest.wifis.size() == 0 && locationServiceRequest.cell.cellid_bsid == 0 && locationServiceRequest.cell.neighcells.size() == 0) {
            errInfo.setErrNo(103);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NO_ELEMENT_FOR_LOCATION);
        } else if (!NetUtils.isNetWorkConnected(this.f48736a)) {
            errInfo.setErrNo(301);
            errInfo.setErrMessage(ErrInfo.ERROR_MSG_NETWORK_CONNECTION);
        } else if (errInfo.getErrNo() == 0) {
            errInfo.setErrNo(1000);
            errInfo.setErrMessage("其他原因引起的定位失败。");
        }
        return errInfo;
    }

    public void cleanLastLocCache() {
        this.f48744i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121280a(DIDILocation dIDILocation) {
        if (TextUtils.equals("gps", dIDILocation.getProvider())) {
            this.f48741f = dIDILocation;
            this.f48742g = dIDILocation.getLocalTime() / 1000;
        }
    }
}
