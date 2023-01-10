package com.didi.component.homedestination.net;

import android.content.Context;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.didi.component.homedestination.model.HomeCpfAwareResponse;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.OrderBanCardInfo;
import java.util.Map;

public class HomeCardListWrapperRequest extends HomeGetRecRequest {

    /* renamed from: a */
    private HomeGetRecRequest f15935a;

    /* renamed from: b */
    private HomeOrderBanRequest f15936b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HomeCardListResponse f15937c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OrderBanCardInfo f15938d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f15939e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HomeCpfAwareResponse f15940f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OrderBanCardInfo f15941g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Runnable f15942h;

    public HomeCardListWrapperRequest(Context context) {
        super(context);
        this.f15935a = new HomeGetRecRequest(context);
        this.f15936b = new HomeOrderBanRequest(context);
    }

    public void getRecRequest(Map map, ResponseListener<HomeCardListResponse> responseListener) {
        this.f15937c = null;
        this.f15938d = null;
        this.f15939e = null;
        this.f15935a.getRecRequest(map, m13215a(responseListener));
        this.f15936b.getOrderBanRequest(map, m13214a());
    }

    /* renamed from: a */
    private ResponseListener<HomeCardListResponse> m13215a(final ResponseListener<HomeCardListResponse> responseListener) {
        return new ResponseListener<HomeCardListResponse>() {
            public void onFinish(HomeCardListResponse homeCardListResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCardListResponse == null) {
                    homeCardListResponse = new HomeCardListResponse();
                }
                HomeCardListResponse unused = homeCardListWrapperRequest.f15937c = homeCardListResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f15939e = new Runnable() {
                    public void run() {
                        responseListener.onFinish(HomeCardListWrapperRequest.this.f15937c);
                    }
                };
                HomeCardListWrapperRequest.this.m13221b();
            }
        };
    }

    /* renamed from: a */
    private ResponseListener<OrderBanCardInfo> m13214a() {
        return new ResponseListener<OrderBanCardInfo>() {
            public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (orderBanCardInfo == null) {
                    orderBanCardInfo = new OrderBanCardInfo();
                }
                OrderBanCardInfo unused = homeCardListWrapperRequest.f15938d = orderBanCardInfo;
                HomeCardListWrapperRequest.this.m13221b();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13221b() {
        OrderBanCardInfo orderBanCardInfo;
        HomeCardListResponse homeCardListResponse = this.f15937c;
        if (homeCardListResponse != null && (orderBanCardInfo = this.f15938d) != null && this.f15939e != null) {
            homeCardListResponse.orderBanCardInfo = orderBanCardInfo;
            this.f15939e.run();
        }
    }

    /* renamed from: b */
    private ResponseListener<HomeCpfAwareResponse> m13218b(final ResponseListener<HomeCpfAwareResponse> responseListener) {
        return new ResponseListener<HomeCpfAwareResponse>() {
            public void onSuccess(HomeCpfAwareResponse homeCpfAwareResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCpfAwareResponse == null) {
                    homeCpfAwareResponse = new HomeCpfAwareResponse();
                }
                HomeCpfAwareResponse unused = homeCardListWrapperRequest.f15940f = homeCpfAwareResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f15942h = new Runnable() {
                    public void run() {
                        responseListener.onSuccess(HomeCardListWrapperRequest.this.f15940f);
                    }
                };
                HomeCardListWrapperRequest.this.m13225d();
            }

            public void onFail(HomeCpfAwareResponse homeCpfAwareResponse) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (homeCpfAwareResponse == null) {
                    homeCpfAwareResponse = new HomeCpfAwareResponse();
                }
                HomeCpfAwareResponse unused = homeCardListWrapperRequest.f15940f = homeCpfAwareResponse;
                Runnable unused2 = HomeCardListWrapperRequest.this.f15942h = new Runnable() {
                    public void run() {
                        responseListener.onFail(HomeCardListWrapperRequest.this.f15940f);
                    }
                };
                HomeCardListWrapperRequest.this.m13225d();
            }
        };
    }

    /* renamed from: c */
    private ResponseListener<OrderBanCardInfo> m13224c() {
        return new ResponseListener<OrderBanCardInfo>() {
            public void onFinish(OrderBanCardInfo orderBanCardInfo) {
                HomeCardListWrapperRequest homeCardListWrapperRequest = HomeCardListWrapperRequest.this;
                if (orderBanCardInfo == null) {
                    orderBanCardInfo = new OrderBanCardInfo();
                }
                OrderBanCardInfo unused = homeCardListWrapperRequest.f15941g = orderBanCardInfo;
                HomeCardListWrapperRequest.this.m13225d();
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m13225d() {
        OrderBanCardInfo orderBanCardInfo;
        HomeCpfAwareResponse homeCpfAwareResponse = this.f15940f;
        if (homeCpfAwareResponse != null && (orderBanCardInfo = this.f15941g) != null && this.f15942h != null) {
            homeCpfAwareResponse.orderBanCardInfo = orderBanCardInfo;
            this.f15942h.run();
        }
    }
}
