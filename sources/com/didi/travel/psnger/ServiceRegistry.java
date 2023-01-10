package com.didi.travel.psnger;

import com.didi.travel.psnger.core.estimate.EstimateService;
import com.didi.travel.psnger.core.matchinfo.MatchInfoService;
import com.didi.travel.psnger.core.order.OrderService;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.HashMap;

class ServiceRegistry {

    /* renamed from: a */
    private static final HashMap<String, ServiceFetcher<?>> f46678a = new HashMap<>();

    interface ServiceFetcher<T> {
        T getService(String str);
    }

    static {
        m34838a("estimate", EstimateService.class, new StaticContextServiceFetcher<EstimateService>() {
            public EstimateService createService(String str) {
                return (EstimateService) ServiceLoader.load(EstimateService.class, str).get();
            }
        });
        m34838a("order", OrderService.class, new StaticContextServiceFetcher<OrderService>() {
            public OrderService createService(String str) {
                return (OrderService) ServiceLoader.load(OrderService.class, str).get();
            }
        });
        m34838a(TravelSDK.MATCH_INFO_SERVICE, MatchInfoService.class, new StaticContextServiceFetcher<MatchInfoService>() {
            public MatchInfoService createService(String str) {
                return (MatchInfoService) ServiceLoader.load(MatchInfoService.class, str).get();
            }
        });
    }

    private ServiceRegistry() {
    }

    /* renamed from: a */
    public static Object m34836a(String str) {
        return m34837a(str, "");
    }

    /* renamed from: a */
    public static Object m34837a(String str, String str2) {
        ServiceFetcher serviceFetcher = f46678a.get(str);
        if (serviceFetcher != null) {
            return serviceFetcher.getService(str2);
        }
        return null;
    }

    /* renamed from: a */
    private static <T> void m34838a(String str, Class<T> cls, ServiceFetcher<T> serviceFetcher) {
        f46678a.put(str, serviceFetcher);
    }

    static abstract class StaticContextServiceFetcher<T> implements ServiceFetcher<T> {
        private T mCachedInstance;

        public abstract T createService(String str);

        StaticContextServiceFetcher() {
        }

        public final T getService(String str) {
            T t;
            synchronized (this) {
                if (this.mCachedInstance == null) {
                    this.mCachedInstance = createService(str);
                }
                t = this.mCachedInstance;
            }
            return t;
        }
    }
}
