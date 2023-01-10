package com.didi.entrega.order.pool;

import com.didi.entrega.customer.app.ApplicationForegroundListener;
import com.didi.entrega.customer.app.CustomerApplicationLifecycleHandler;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.push.LongConnectionProvider;
import com.didi.entrega.customer.foundation.push.model.AbsPushModel;
import com.didi.entrega.customer.foundation.rpc.entity.order.PushOrderEntity;
import com.didi.entrega.customer.foundation.rpc.net.TypeUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.order.pool.OrderMonitorLooper;
import com.didi.foundation.sdk.liveconnection.MessageListener;
import com.didi.foundation.sdk.liveconnection.Response;
import java.lang.reflect.Type;

public final class OrderMixService {

    /* renamed from: a */
    private static final String f22771a = "EntregaOrderMixService";

    /* renamed from: c */
    private static final int f22772c = 2;

    /* renamed from: d */
    private static final int f22773d = 30000;

    /* renamed from: b */
    private OrderMonitorLooper f22774b;

    /* renamed from: e */
    private MessageListener f22775e;

    /* renamed from: f */
    private OrderMonitorLooper.MonitorLooperListener f22776f;

    /* renamed from: g */
    private ApplicationForegroundListener f22777g;

    private OrderMixService() {
        this.f22775e = new MessageListener() {
            public int getPushKey() {
                return 3794;
            }

            public void onReceive(final Response response) {
                UiHandlerUtil.post(new Runnable() {
                    public void run() {
                        String str = new String(response.getData());
                        LogUtil.m18185i("DPushListenerImp", "data: " + str);
                        try {
                            AbsPushModel absPushModel = (AbsPushModel) GsonUtil.fromJson(str, (Type) new TypeUtil.ParameterizedTypeImpl((Type) null, AbsPushModel.class, PushOrderEntity.class));
                            if (2 == absPushModel.type) {
                                LogUtil.m18185i(OrderMixService.f22771a, "order status push data,before update repo:" + ((PushOrderEntity) absPushModel.data).toString());
                                ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(((PushOrderEntity) absPushModel.data).getOrderId(), 3);
                            }
                        } catch (Exception e) {
                            LogUtil.m18183e(OrderMixService.f22771a, "pushBody  push_topic: order changed,  convert data Error:" + e.getMessage());
                        }
                    }
                });
            }
        };
        this.f22776f = new OrderMonitorLooper.MonitorLooperListener() {
            public void looperWork() {
                OrderMixService.this.doWork();
            }
        };
        this.f22777g = new ApplicationForegroundListener() {
            public void onBecomeBackground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f22771a).setMessage("ApplicationForegroundListener --> onBecomeBackground").setOtherParam("currentBackgroundTime", Long.valueOf(j)).setOtherParam("lastForegroundTime", Long.valueOf(j2)).build().info();
                OrderMixService.this.pause();
            }

            public void onBecomeForeground(long j, long j2) {
                RecordTracker.Builder.create().setTag(OrderMixService.f22771a).setMessage("ApplicationForegroundListener --> onBecomeForeground").setOtherParam("currentForegroundTime", Long.valueOf(j)).setOtherParam("lastBackgroundTime", Long.valueOf(j2)).setOtherParam("isLoopWorking", Boolean.valueOf(OrderMixService.this.isLoopWorking())).build().info();
                if (!OrderMixService.this.isLoopWorking()) {
                    OrderMixService.this.reset();
                }
            }
        };
        m18752a();
    }

    public static OrderMixService getInstance() {
        return InstanceHolder.HOLDER;
    }

    public void setPeriod(int i) {
        this.f22774b.mo67478a(i);
    }

    public boolean isLoopWorking() {
        return this.f22774b.mo67480a();
    }

    public void pause() {
        LogUtil.m18185i(f22771a, "pause");
        this.f22774b.mo67484d();
    }

    public void reset() {
        LogUtil.m18185i(f22771a, "reset");
        this.f22774b.mo67481b();
    }

    public void start() {
        LogUtil.m18185i(f22771a, "start");
        this.f22774b.mo67479a(this.f22776f);
        this.f22774b.mo67478a(30000);
        this.f22774b.mo67483c();
        LongConnectionProvider.getInstance().registerMessageListener(this.f22775e);
        CustomerApplicationLifecycleHandler.getInstance().registerForegroundListener(this.f22777g);
    }

    public void stop() {
        LogUtil.m18185i(f22771a, "stop");
        this.f22774b.mo67482b(this.f22776f);
        this.f22774b.mo67484d();
        LongConnectionProvider.getInstance().unRegisterMessageListener(this.f22775e);
        CustomerApplicationLifecycleHandler.getInstance().unregisterForegroundListener(this.f22777g);
    }

    /* access modifiers changed from: protected */
    public void doWork() {
        LogUtil.m18185i(f22771a, "order status looper, doWork()");
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateAllOrdersInMonitor();
    }

    /* renamed from: a */
    private void m18752a() {
        this.f22774b = new OrderMonitorLooper();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OrderMixService HOLDER = new OrderMixService();

        private InstanceHolder() {
        }
    }
}
