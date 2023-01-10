package com.didi.travel.psnger.core.order;

import android.text.TextUtils;
import androidx.collection.ArraySet;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.audiorecorder.Constants;
import com.didi.travel.psnger.AppLifecycleManager;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.model.request.BaseOrderDetailParams;
import com.didi.travel.psnger.core.model.request.OrderStatusParams;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.core.order.OrderEventManager;
import com.didi.travel.psnger.core.poll.BasePoller;
import com.didi.travel.psnger.core.poll.IPollCallbackProtocol;
import com.didi.travel.psnger.core.poll.adapter.PollCallbackAdapter;
import com.didi.travel.psnger.core.poll.impl.DefaultPoller;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.UIThreadHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class OrderPollingManager {

    /* renamed from: a */
    AppLifecycleManager.AppStateListener f46841a = new AppLifecycleManager.AppStateListener() {
        public void onStateChanged(int i) {
            if (i == 1) {
                LogUtil.m34919fi("mAppStateListener#onActive");
                if (DDTravelOrderStore.getOrder() != null) {
                    OrderPollingManager.this.f46850j.set(true);
                    OrderPollingManager.this.m34866a(0);
                    return;
                }
                return;
            }
            LogUtil.m34919fi("mAppStateListener#INACTIVE");
        }
    };

    /* renamed from: b */
    private int f46842b = Constants.TIME_DAY;

    /* renamed from: c */
    private BasePoller f46843c;

    /* renamed from: d */
    private OrderService f46844d;

    /* renamed from: e */
    private OrderEventManager.DiDiEventReceiver<DTSDKOrderStatus> f46845e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ArraySet<IDiDiCoreCallback> f46846f;

    /* renamed from: g */
    private boolean f46847g = false;

    /* renamed from: h */
    private IPollCallbackProtocol f46848h = new PollCallbackAdapter() {
        public void onSendRequest(int i) {
            SystemUtils.log(6, "lhm", "spendtime ... = " + i, (Throwable) null, "com.didi.travel.psnger.core.order.OrderPollingManager$2", 227);
            if (TextUtils.isEmpty(TravelSDK.travelParam() != null ? TravelSDK.travelParam().token() : null)) {
                OrderPollingManager.this.m34870a("mOrderStatusOrderLoopCallback#onSendRequest");
                UIThreadHandler.post(new Runnable() {
                    public void run() {
                        Iterator it = OrderPollingManager.this.f46846f.iterator();
                        while (it.hasNext()) {
                            IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                            if (iDiDiCoreCallback != null) {
                                iDiDiCoreCallback.onOrderStatusTimeOut();
                            }
                        }
                    }
                });
                return;
            }
            OrderPollingManager.this.m34866a(1);
        }

        public void onNotifyUpdateUI(final int i) {
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    Iterator it = OrderPollingManager.this.f46846f.iterator();
                    while (it.hasNext()) {
                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                        if (iDiDiCoreCallback != null) {
                            iDiDiCoreCallback.onOrderPollTimeChange(i);
                        }
                    }
                }
            });
        }

        public void onPollTimeout() {
            OrderPollingManager.this.m34870a("mOrderStatusOrderLoopCallback#onPollTimeout");
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    Iterator it = OrderPollingManager.this.f46846f.iterator();
                    while (it.hasNext()) {
                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                        if (iDiDiCoreCallback != null) {
                            iDiDiCoreCallback.onOrderStatusTimeOut();
                        }
                    }
                }
            });
        }
    };

    /* renamed from: i */
    private ResponseListener<IOrderStatus> f46849i = new ResponseListener<IOrderStatus>() {
        public void onSuccess(IOrderStatus iOrderStatus) {
            LogUtil.m34919fi("queryOrderStatusListener status = " + iOrderStatus.status() + " substatus = " + iOrderStatus.subStatus());
            OrderPollingManager.this.onOrderStatusGot(iOrderStatus, false);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AtomicBoolean f46850j = new AtomicBoolean(false);

    /* renamed from: a */
    private void m34871a(String str, int i, int i2, boolean z) {
    }

    public OrderPollingManager(OrderService orderService) {
        this.f46844d = orderService;
        this.f46843c = createOrderStatusPoller();
        this.f46846f = new ArraySet<>(2);
        this.f46845e = new OrderEventManager.DiDiEventReceiver<DTSDKOrderStatus>() {
            public void onReceive(String str, DTSDKOrderStatus dTSDKOrderStatus) {
                LogUtil.m34919fi("mOrderStatusEventReceiver status = " + dTSDKOrderStatus.status + " substatus = " + dTSDKOrderStatus.subStatus);
                OrderPollingManager.this.onOrderStatusGot(dTSDKOrderStatus, true);
            }
        };
    }

    /* access modifiers changed from: protected */
    public BasePoller createOrderStatusPoller() {
        return new DefaultPoller();
    }

    public void setOrderStatusPoller(BasePoller basePoller) {
        this.f46843c = basePoller;
    }

    public BasePoller getOrderStatusPoller() {
        return this.f46843c;
    }

    public void setBackDoorOpen(boolean z) {
        this.f46847g = z;
    }

    public void addCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f46846f.add(iDiDiCoreCallback);
    }

    public void removeCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        this.f46846f.remove(iDiDiCoreCallback);
    }

    public void registerOrderStatusPush() {
        OrderEventManager.m34856a().mo116769a("didi_travel_event_push_order_status", (OrderEventManager.DiDiEventReceiver) this.f46845e);
    }

    public void unregisterOrderStatusPush() {
        OrderEventManager.m34856a().mo116771b("didi_travel_event_push_order_status", (OrderEventManager.DiDiEventReceiver) this.f46845e);
    }

    public void start(boolean z, long j) {
        if (DDTravelOrderStore.getOrder() != null) {
            m34872a(z, j);
            AppLifecycleManager.getInstance().registerAppStateListener(this.f46841a);
        }
    }

    /* renamed from: a */
    private void m34872a(boolean z, long j) {
        int i;
        ICarOrder order = DDTravelOrderStore.getOrder();
        if (!z || order == null) {
            i = 0;
        } else {
            i = ((int) (System.currentTimeMillis() - order.getCreateTime())) / 1000;
            if (i > this.f46842b || i < 0) {
                i = 0;
            }
            this.f46842b -= i;
        }
        long j2 = (long) (this.f46842b - i);
        long j3 = (long) (i * 1000);
        LogUtil.m34919fi("startOrderStatusPoll maxTimeThreshold=" + j2 + ", frequencyTime=" + j + ", diffMaxTime=" + j3);
        BasePoller basePoller = this.f46843c;
        if (basePoller == null) {
            return;
        }
        if (basePoller.checkPollerRunning()) {
            m34866a(0);
            return;
        }
        this.f46843c.registerPollCallback(this.f46848h);
        this.f46843c.startPoll(j2, j, j3);
    }

    public void stopOrderStatusPoll() {
        BasePoller basePoller = this.f46843c;
        if (basePoller != null) {
            basePoller.stopPoll();
        }
        AppLifecycleManager.getInstance().unregisterAppStateListener(this.f46841a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34870a(String str) {
        stopOrderStatusPoll();
        orderStatusOmegaTrace("tech_pax_order_status_finish", str);
    }

    public static void orderStatusOmegaTrace(String str, String str2) {
        HashMap hashMap = new HashMap();
        ICarOrder order = DDTravelOrderStore.getOrder();
        if (order != null) {
            hashMap.put("oid", order.getOid());
            hashMap.put("status", Integer.valueOf(order.getStatus()));
            hashMap.put(ParamKeys.PARAM_SUB_STATUS, Integer.valueOf(order.getSubStatus()));
        }
        hashMap.put("is_push", 0);
        hashMap.put("from", "OrderPollingManager#" + str2);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private boolean m34873a() {
        BasePoller basePoller = this.f46843c;
        if (basePoller != null) {
            return basePoller.checkPollerRunning();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02d7, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onOrderStatusGot(final com.didi.travel.psnger.core.model.response.IOrderStatus r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            boolean r0 = r10 instanceof com.didi.travel.psnger.core.model.response.DTSDKOrderStatus     // Catch:{ all -> 0x02d8 }
            r1 = 2003(0x7d3, float:2.807E-42)
            r2 = 2
            if (r0 == 0) goto L_0x0030
            int r0 = r10.status()     // Catch:{ all -> 0x02d8 }
            if (r0 != r2) goto L_0x0030
            int r0 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            if (r0 != r1) goto L_0x0030
            r0 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r0 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r0     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = r0.newOrderId     // Catch:{ all -> 0x02d8 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02d8 }
            if (r0 != 0) goto L_0x0030
            com.didi.travel.psnger.core.order.OrderReassignInfo r0 = com.didi.travel.psnger.core.order.OrderReassignInfo.getInstance()     // Catch:{ all -> 0x02d8 }
            r3 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r3 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r3     // Catch:{ all -> 0x02d8 }
            java.lang.String r3 = r3.oid     // Catch:{ all -> 0x02d8 }
            r4 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r4 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r4     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = r4.newOrderId     // Catch:{ all -> 0x02d8 }
            r0.store(r3, r4)     // Catch:{ all -> 0x02d8 }
        L_0x0030:
            com.didi.travel.psnger.core.model.response.ICarOrder r0 = com.didi.travel.psnger.store.DDTravelOrderStore.getOrder()     // Catch:{ all -> 0x02d8 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d8 }
            r3.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = "onOrderStatusGot ... status="
            r3.append(r4)     // Catch:{ all -> 0x02d8 }
            int r4 = r10.status()     // Catch:{ all -> 0x02d8 }
            r3.append(r4)     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = " subStatus="
            r3.append(r4)     // Catch:{ all -> 0x02d8 }
            int r4 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            r3.append(r4)     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = " isPush="
            r3.append(r4)     // Catch:{ all -> 0x02d8 }
            r3.append(r11)     // Catch:{ all -> 0x02d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r3)     // Catch:{ all -> 0x02d8 }
            boolean r3 = r10.isTimeout()     // Catch:{ all -> 0x02d8 }
            if (r3 == 0) goto L_0x0089
            java.lang.String r11 = "onOrderStatusGot timeout"
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r11)     // Catch:{ all -> 0x02d8 }
            int r10 = r10.status()     // Catch:{ all -> 0x02d8 }
            r11 = 7
            if (r10 != r11) goto L_0x0087
            if (r0 == 0) goto L_0x007a
            int r10 = r0.getStatus()     // Catch:{ all -> 0x02d8 }
            if (r10 != r11) goto L_0x0087
        L_0x007a:
            java.lang.String r10 = "onOrderStatusGot"
            r9.m34870a((java.lang.String) r10)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.order.OrderPollingManager$4 r10 = new com.didi.travel.psnger.core.order.OrderPollingManager$4     // Catch:{ all -> 0x02d8 }
            r10.<init>()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.UIThreadHandler.post(r10)     // Catch:{ all -> 0x02d8 }
        L_0x0087:
            monitor-exit(r9)
            return
        L_0x0089:
            boolean r3 = r10 instanceof com.didi.travel.psnger.core.model.response.DTSDKOrderStatus     // Catch:{ all -> 0x02d8 }
            if (r3 == 0) goto L_0x00e7
            int r3 = r10.status()     // Catch:{ all -> 0x02d8 }
            if (r3 != r2) goto L_0x00e7
            int r2 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            if (r2 != r1) goto L_0x00e7
            if (r0 == 0) goto L_0x00e7
            java.lang.String r1 = r0.getOid()     // Catch:{ all -> 0x02d8 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x02d8 }
            if (r1 != 0) goto L_0x00e7
            java.lang.String r1 = r0.getOid()     // Catch:{ all -> 0x02d8 }
            r2 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r2 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r2     // Catch:{ all -> 0x02d8 }
            java.lang.String r2 = r2.newOrderId     // Catch:{ all -> 0x02d8 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x02d8 }
            if (r1 == 0) goto L_0x00e7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d8 }
            r11.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r1 = "CarOrder.getOid = "
            r11.append(r1)     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = r0.getOid()     // Catch:{ all -> 0x02d8 }
            r11.append(r0)     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = ", state.oid = "
            r11.append(r0)     // Catch:{ all -> 0x02d8 }
            r0 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r0 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r0     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = r0.oid     // Catch:{ all -> 0x02d8 }
            r11.append(r0)     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = ", state.newOrderId = "
            r11.append(r0)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r10 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r10     // Catch:{ all -> 0x02d8 }
            java.lang.String r10 = r10.newOrderId     // Catch:{ all -> 0x02d8 }
            r11.append(r10)     // Catch:{ all -> 0x02d8 }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.LogUtil.m34918fe(r10)     // Catch:{ all -> 0x02d8 }
            monitor-exit(r9)
            return
        L_0x00e7:
            boolean r1 = r9.m34873a()     // Catch:{ all -> 0x02d8 }
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x01c2
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x02d8 }
            r4.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "oid"
            java.lang.String r6 = r0.getOid()     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "status"
            int r6 = r0.getStatus()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "sub_status"
            int r6 = r0.getSubStatus()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "s_status"
            int r6 = r10.status()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "s_sub_status"
            int r6 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "is_push"
            if (r11 == 0) goto L_0x013b
            r6 = 1
            goto L_0x013c
        L_0x013b:
            r6 = 0
        L_0x013c:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "is_poll"
            if (r1 == 0) goto L_0x0149
            r6 = 1
            goto L_0x014a
        L_0x0149:
            r6 = 0
        L_0x014a:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r5, r6)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.IOrderStatus r5 = r0.getOrderStatus()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r5 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r5     // Catch:{ all -> 0x02d8 }
            r6 = r10
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r6 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r6     // Catch:{ all -> 0x02d8 }
            if (r6 == 0) goto L_0x0173
            java.lang.String r7 = "s_md5"
            java.lang.String r8 = r6.md5     // Catch:{ all -> 0x02d8 }
            r4.put(r7, r8)     // Catch:{ all -> 0x02d8 }
            java.lang.String r7 = r6.newOrderId     // Catch:{ all -> 0x02d8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02d8 }
            if (r7 != 0) goto L_0x0173
            java.lang.String r7 = "new_oid"
            java.lang.String r8 = r6.newOrderId     // Catch:{ all -> 0x02d8 }
            r4.put(r7, r8)     // Catch:{ all -> 0x02d8 }
        L_0x0173:
            if (r5 == 0) goto L_0x0191
            if (r6 == 0) goto L_0x0191
            java.lang.String r7 = r5.md5     // Catch:{ all -> 0x02d8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02d8 }
            if (r7 != 0) goto L_0x0191
            java.lang.String r7 = r6.md5     // Catch:{ all -> 0x02d8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02d8 }
            if (r7 != 0) goto L_0x0191
            java.lang.String r7 = r5.md5     // Catch:{ all -> 0x02d8 }
            java.lang.String r6 = r6.md5     // Catch:{ all -> 0x02d8 }
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x02d8 }
            r6 = r6 ^ r3
            goto L_0x0192
        L_0x0191:
            r6 = 0
        L_0x0192:
            java.lang.String r7 = "md5changed"
            if (r6 == 0) goto L_0x0198
            r6 = 1
            goto L_0x0199
        L_0x0198:
            r6 = 0
        L_0x0199:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x02d8 }
            r4.put(r7, r6)     // Catch:{ all -> 0x02d8 }
            if (r5 == 0) goto L_0x01bc
            java.lang.String r6 = "o_status"
            int r7 = r5.status()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x02d8 }
            r4.put(r6, r7)     // Catch:{ all -> 0x02d8 }
            java.lang.String r6 = "o_sub_status"
            int r5 = r5.subStatus()     // Catch:{ all -> 0x02d8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02d8 }
            r4.put(r6, r5)     // Catch:{ all -> 0x02d8 }
        L_0x01bc:
            java.lang.String r5 = "tech_pax_order_status_changed"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r5, (java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ all -> 0x02d8 }
        L_0x01c2:
            if (r0 == 0) goto L_0x02b8
            if (r1 == 0) goto L_0x02b8
            com.didi.travel.psnger.core.model.response.IOrderStatus r1 = r0.getOrderStatus()     // Catch:{ all -> 0x02d8 }
            if (r1 != 0) goto L_0x01e2
            java.lang.String r1 = "onOrderStatusGot status is null"
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r1)     // Catch:{ all -> 0x02d8 }
            r0.setOrderStatus(r10)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.store.DDTravelOrderStore.setOrder(r0)     // Catch:{ all -> 0x02d8 }
            boolean r0 = r0.isDirty()     // Catch:{ all -> 0x02d8 }
            if (r0 == 0) goto L_0x02cc
            r9.m34874b()     // Catch:{ all -> 0x02d8 }
            goto L_0x02cc
        L_0x01e2:
            java.lang.String r1 = r10.lineMD5()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.IOrderStatus r4 = r0.getOrderStatus()     // Catch:{ all -> 0x02d8 }
            java.lang.String r4 = r4.lineMD5()     // Catch:{ all -> 0x02d8 }
            boolean r1 = android.text.TextUtils.equals(r1, r4)     // Catch:{ all -> 0x02d8 }
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x01fd
            com.didi.travel.psnger.core.order.OrderPollingManager$5 r1 = new com.didi.travel.psnger.core.order.OrderPollingManager$5     // Catch:{ all -> 0x02d8 }
            r1.<init>()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.UIThreadHandler.post(r1)     // Catch:{ all -> 0x02d8 }
        L_0x01fd:
            int r1 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.IOrderStatus r4 = r0.getOrderStatus()     // Catch:{ all -> 0x02d8 }
            int r4 = r4.subStatus()     // Catch:{ all -> 0x02d8 }
            if (r1 == r4) goto L_0x020d
            r1 = 1
            goto L_0x020e
        L_0x020d:
            r1 = 0
        L_0x020e:
            int r4 = r10.status()     // Catch:{ all -> 0x02d8 }
            if (r4 <= 0) goto L_0x0224
            int r4 = r10.status()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.core.model.response.IOrderStatus r5 = r0.getOrderStatus()     // Catch:{ all -> 0x02d8 }
            int r5 = r5.status()     // Catch:{ all -> 0x02d8 }
            if (r4 == r5) goto L_0x0224
            r4 = 1
            goto L_0x0225
        L_0x0224:
            r4 = 0
        L_0x0225:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d8 }
            r5.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r6 = "onOrderStatusGot ... isSubStatusChanged="
            r5.append(r6)     // Catch:{ all -> 0x02d8 }
            r5.append(r1)     // Catch:{ all -> 0x02d8 }
            java.lang.String r1 = " isStatusChanged="
            r5.append(r1)     // Catch:{ all -> 0x02d8 }
            r5.append(r4)     // Catch:{ all -> 0x02d8 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r1)     // Catch:{ all -> 0x02d8 }
            r0.setOrderStatus(r10)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.store.DDTravelOrderStore.setOrder(r0)     // Catch:{ all -> 0x02d8 }
            boolean r1 = r0.isDirty()     // Catch:{ all -> 0x02d8 }
            if (r1 == 0) goto L_0x0252
            r9.m34874b()     // Catch:{ all -> 0x02d8 }
            goto L_0x02cc
        L_0x0252:
            int r1 = r10.subStatus()     // Catch:{ all -> 0x02d8 }
            int r4 = r0.getSubStatus()     // Catch:{ all -> 0x02d8 }
            if (r1 == r4) goto L_0x025e
            r1 = 1
            goto L_0x025f
        L_0x025e:
            r1 = 0
        L_0x025f:
            int r4 = r10.status()     // Catch:{ all -> 0x02d8 }
            if (r4 <= 0) goto L_0x0270
            int r4 = r10.status()     // Catch:{ all -> 0x02d8 }
            int r5 = r0.getStatus()     // Catch:{ all -> 0x02d8 }
            if (r4 == r5) goto L_0x0270
            goto L_0x0271
        L_0x0270:
            r3 = 0
        L_0x0271:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d8 }
            r4.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r5 = "onOrderStatusGot ... isDetailSubStatusChanged="
            r4.append(r5)     // Catch:{ all -> 0x02d8 }
            r4.append(r1)     // Catch:{ all -> 0x02d8 }
            java.lang.String r1 = " isDetailStatusChanged="
            r4.append(r1)     // Catch:{ all -> 0x02d8 }
            r4.append(r3)     // Catch:{ all -> 0x02d8 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r1)     // Catch:{ all -> 0x02d8 }
            boolean r1 = r0.isDirty()     // Catch:{ all -> 0x02d8 }
            if (r1 == 0) goto L_0x0297
            r9.m34874b()     // Catch:{ all -> 0x02d8 }
            goto L_0x02cc
        L_0x0297:
            com.didi.travel.psnger.model.response.OrderRealtimePriceCount r0 = r0.getRealtimePriceCount()     // Catch:{ all -> 0x02d8 }
            if (r0 == 0) goto L_0x02af
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.f46850j     // Catch:{ all -> 0x02d8 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x02d8 }
            if (r0 == 0) goto L_0x02a6
            goto L_0x02af
        L_0x02a6:
            com.didi.travel.psnger.core.order.OrderPollingManager$6 r0 = new com.didi.travel.psnger.core.order.OrderPollingManager$6     // Catch:{ all -> 0x02d8 }
            r0.<init>(r10)     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.UIThreadHandler.post(r0)     // Catch:{ all -> 0x02d8 }
            goto L_0x02cc
        L_0x02af:
            java.util.concurrent.atomic.AtomicBoolean r0 = r9.f46850j     // Catch:{ all -> 0x02d8 }
            r0.set(r2)     // Catch:{ all -> 0x02d8 }
            r9.m34878d()     // Catch:{ all -> 0x02d8 }
            goto L_0x02cc
        L_0x02b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02d8 }
            r0.<init>()     // Catch:{ all -> 0x02d8 }
            java.lang.String r2 = "onOrderStatusGot checkPollerRunning="
            r0.append(r2)     // Catch:{ all -> 0x02d8 }
            r0.append(r1)     // Catch:{ all -> 0x02d8 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02d8 }
            com.didi.travel.psnger.utils.LogUtil.m34919fi(r0)     // Catch:{ all -> 0x02d8 }
        L_0x02cc:
            if (r11 != 0) goto L_0x02d6
            int r11 = r10.intervalTime()     // Catch:{ all -> 0x02d8 }
            long r0 = (long) r11     // Catch:{ all -> 0x02d8 }
            r9.m34867a((long) r0, (com.didi.travel.psnger.core.model.response.IOrderStatus) r10)     // Catch:{ all -> 0x02d8 }
        L_0x02d6:
            monitor-exit(r9)
            return
        L_0x02d8:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.core.order.OrderPollingManager.onOrderStatusGot(com.didi.travel.psnger.core.model.response.IOrderStatus, boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34866a(int i) {
        LogUtil.m34919fi("doQueryOrderStatus type " + i);
        ICarOrder order = DDTravelOrderStore.getOrder();
        if (order != null && !TextUtils.isEmpty(order.getOid()) && order.getStartAddress() != null) {
            if (AppLifecycleManager.getInstance().isAppFront() || order.getStatus() != 4 || this.f46847g) {
                LogUtil.m34919fi("doQueryOrderStatus oid " + order.getOid());
                OrderStatusParams orderStatusParams = new OrderStatusParams();
                orderStatusParams.setOid(order.getOid());
                orderStatusParams.setType(i);
                orderStatusParams.setCurrentStatus(order.getStatus());
                orderStatusParams.setCurrentSubStatus(order.getSubStatus());
                this.f46844d.getOrderStatus(TravelSDK.appContext(), orderStatusParams, this.f46849i);
            }
        }
    }

    /* renamed from: b */
    private void m34874b() {
        ICarOrder order = DDTravelOrderStore.getOrder();
        if (order != null && !TextUtils.isEmpty(order.getOid())) {
            LogUtil.m34919fi("doQueryOrderDetail ..." + order.getOid());
            BaseOrderDetailParams baseOrderDetailParams = new BaseOrderDetailParams();
            baseOrderDetailParams.setBusinessId(order.getProductId());
            baseOrderDetailParams.setOid(order.getOid());
            this.f46844d.getOrderDetail(TravelSDK.appContext(), baseOrderDetailParams, new ITravelOrderListener() {
                public void onTimeout(String str) {
                }

                public void onSuccess(ICarOrder iCarOrder) {
                    OrderPollingManager.this.m34878d();
                }

                public void onError(int i, String str) {
                    LogUtil.m34919fi("doQueryOrderDetail onError errNo=" + i + " errMsg=" + str);
                }

                public void onFail(int i, String str) {
                    LogUtil.m34919fi("doQueryOrderDetail onFail errNo=" + i + " errMsg=" + str);
                }
            });
        }
    }

    /* renamed from: c */
    private void m34877c() {
        ICarOrder order = DDTravelOrderStore.getOrder();
        if (order != null && !TextUtils.isEmpty(order.getOid())) {
            this.f46844d.getOnServiceRealtimePrice(TravelSDK.appContext(), order.getOid(), new ResponseListener<OrderRealtimePriceCount>() {
                public void onSuccess(final OrderRealtimePriceCount orderRealtimePriceCount) {
                    LogUtil.m34919fi("getOnServiceRealtimePrice received");
                    ICarOrder order = DDTravelOrderStore.getOrder();
                    if (order != null && !TextUtils.isEmpty(order.getOid()) && order.getOid().equals(orderRealtimePriceCount.oid)) {
                        order.setRealtimePriceCount(orderRealtimePriceCount);
                        DDTravelOrderStore.setOrder(order);
                        UIThreadHandler.post(new Runnable() {
                            public void run() {
                                Iterator it = OrderPollingManager.this.f46846f.iterator();
                                while (it.hasNext()) {
                                    IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                                    if (iDiDiCoreCallback != null) {
                                        iDiDiCoreCallback.onRealtimePriceRefresh(orderRealtimePriceCount);
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m34867a(long j, IOrderStatus iOrderStatus) {
        BasePoller basePoller;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            m34870a("dealStatusPollIntervalTime");
        } else if (i > 0 && (basePoller = this.f46843c) != null) {
            basePoller.updatePollFrequenceTime(j * 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34878d() {
        ICarOrder order = DDTravelOrderStore.getOrder();
        final IOrderStatus orderStatus = order.getOrderStatus();
        if (order != null && orderStatus != null) {
            if (orderStatus.status() == 4 && orderStatus.subStatus() == 4006) {
                m34877c();
            }
            UIThreadHandler.post(new Runnable() {
                public void run() {
                    Iterator it = OrderPollingManager.this.f46846f.iterator();
                    while (it.hasNext()) {
                        IDiDiCoreCallback iDiDiCoreCallback = (IDiDiCoreCallback) it.next();
                        if (iDiDiCoreCallback != null) {
                            LogUtil.m34919fi("onOrderDetailFinished:" + orderStatus.oid() + " " + orderStatus.status() + "-" + orderStatus.subStatus());
                            iDiDiCoreCallback.onOrderStatusChange(orderStatus);
                        }
                    }
                }
            });
        }
    }
}
