package com.didi.soda.customer.biz.order;

import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import com.didi.soda.customer.app.ApplicationForegroundListener;
import com.didi.soda.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.soda.customer.biz.order.OrderMonitorLooper;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.push.LongConnectionProvider;
import com.didi.soda.customer.foundation.push.model.AbsPushModel;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.TypeUtil;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import java.lang.reflect.Type;

public final class OrderMixService {

    /* renamed from: a */
    private static final String f43006a = "OrderMixService";

    /* renamed from: b */
    private static final int f43007b = 1;

    /* renamed from: c */
    private OrderMonitorLooper f43008c;

    /* renamed from: d */
    private int f43009d;

    /* renamed from: e */
    private MessageListener f43010e;

    /* renamed from: f */
    private OrderMonitorLooper.MonitorLooperListener f43011f;

    /* renamed from: g */
    private ApplicationForegroundListener f43012g;

    private OrderMixService() {
        this.f43009d = 30000;
        this.f43010e = new MessageListener() {
            public int getPushKey() {
                return 3793;
            }

            public void onReceive(final Response response) {
                UiHandlerUtil.post(new Runnable() {
                    public void run() {
                        String str = new String(response.getData());
                        LogUtil.m32588i("DPushListenerImp", "data: " + str);
                        try {
                            AbsPushModel absPushModel = (AbsPushModel) GsonUtil.fromJson(str, (Type) new TypeUtil.ParameterizedTypeImpl((Type) null, AbsPushModel.class, OrderInfoEntity.class));
                            if (1 == absPushModel.type) {
                                LogUtil.m32588i(OrderMixService.f43006a, "order status push data,before update repo:" + ((OrderInfoEntity) absPushModel.data).toString());
                                OrderMixService.this.updatePushOrderData((OrderInfoEntity) absPushModel.data);
                            }
                        } catch (Exception e) {
                            LogUtil.m32586e(OrderMixService.f43006a, "pushBody  push_topic:259  convert data Error:" + e.getMessage());
                        }
                    }
                });
            }
        };
        this.f43011f = new OrderMonitorLooper.MonitorLooperListener() {
            public void looperWork() {
                OrderMixService.this.doWork();
            }
        };
        this.f43012g = new ApplicationForegroundListener() {
            public void onBecomeBackground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f43006a).setMessage("ApplicationForegroundListener --> onBecomeBackground").setOtherParam("currentBackgroundTime", Long.valueOf(j)).setOtherParam("lastForegroundTime", Long.valueOf(j2)).build().info();
                OrderMixService.this.pause();
            }

            public void onBecomeForeground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f43006a).setMessage("ApplicationForegroundListener --> onBecomeForeground").setOtherParam("currentForegroundTime", Long.valueOf(j)).setOtherParam("lastBackgroundTime", Long.valueOf(j2)).setOtherParam("isLoopWorking", Boolean.valueOf(OrderMixService.this.isLoopWorking())).build().info();
                if (!OrderMixService.this.isLoopWorking()) {
                    OrderMixService.this.reset();
                }
            }
        };
        m32145a();
    }

    public static OrderMixService getInstance() {
        return InstanceHolder.HOLDER;
    }

    public void setPeriod(int i) {
        this.f43008c.mo108394a(i);
    }

    public boolean isLoopWorking() {
        return this.f43008c.mo108396a();
    }

    public void pause() {
        LogUtil.m32588i(f43006a, "pause");
        this.f43008c.mo108400d();
    }

    public void reset() {
        LogUtil.m32588i(f43006a, "reset");
        this.f43008c.mo108397b();
    }

    public void start() {
        LogUtil.m32588i(f43006a, "start");
        this.f43008c.mo108395a(this.f43011f);
        this.f43008c.mo108394a(this.f43009d);
        this.f43008c.mo108399c();
        LongConnectionProvider.getInstance().registerMessageListener(this.f43010e);
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f43012g);
    }

    public void stop() {
        LogUtil.m32588i(f43006a, "stop");
        this.f43008c.mo108398b(this.f43011f);
        this.f43008c.mo108400d();
        LongConnectionProvider.getInstance().unRegisterMessageListener(this.f43010e);
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f43012g);
    }

    /* access modifiers changed from: protected */
    public void doWork() {
        LogUtil.m32588i(f43006a, "order status looper, doWork()");
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateAllOrdersInMonitor();
    }

    /* access modifiers changed from: protected */
    public void updatePushOrderData(OrderInfoEntity orderInfoEntity) {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).addOrderEntity2Monitor(orderInfoEntity, 3);
    }

    /* renamed from: a */
    private void m32145a() {
        this.f43008c = new OrderMonitorLooper();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OrderMixService HOLDER = new OrderMixService();

        private InstanceHolder() {
        }
    }
}
