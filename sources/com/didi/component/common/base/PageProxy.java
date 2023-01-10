package com.didi.component.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.travel.p172v2.TravelSDKV2;
import com.didi.travel.p172v2.session.Session;
import com.didi.travel.p172v2.store.Store;
import com.didi.travel.p172v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p171v2.EventKeys;
import com.didi.travel.psnger.p171v2.IExpress;
import com.didi.travel.psnger.p171v2.TravelConstant;
import com.didi.travel.psnger.p171v2.TravelUtil;
import com.didi.travel.psnger.p171v2.session.OrderEvent;
import com.didi.travel.psnger.p171v2.session.SessionEvent;
import com.didi.travel.psnger.utils.TextUtil;

public class PageProxy {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f13313a = PageProxy.class.getSimpleName();
    protected BaseEventPublisher.OnEventListener<OrderEvent> mOrderEventListener = new BaseEventPublisher.OnEventListener<OrderEvent>() {
        public void onEvent(String str, OrderEvent orderEvent) {
            String a = PageProxy.f13313a;
            LogUtils.m34980i(a, "Order.onEvent : s = " + str + ", event = " + orderEvent + ", mOrderId = " + TravelUtil.getRichOid(PageProxy.this.mOrderId) + ", mTag = " + PageProxy.this.mTag);
            if (orderEvent == null) {
                LogUtils.m34979e(PageProxy.f13313a, "Order.onEvent : event is null");
            } else if (orderEvent.getPageId() != PageProxy.this.mPageCallback.getPageId()) {
                String a2 = PageProxy.f13313a;
                LogUtils.m34982w(a2, "Order.onEvent : page not match, curPageId = " + PageProxy.this.mPageCallback.getPageId() + ", event.pageId = " + orderEvent.getPageId());
            } else if (!EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID.equals(str)) {
                String a3 = PageProxy.f13313a;
                LogUtils.m34979e(a3, "Order.onEvent:invalid event, s = " + str);
            } else if (TextUtils.equals(PageProxy.this.mOrderId, orderEvent.getOrderId())) {
                String a4 = PageProxy.f13313a;
                LogUtils.m34982w(a4, "Order.onEvent:order is equals, mOrderId = " + TravelUtil.getRichOid(PageProxy.this.mOrderId));
            } else {
                PageProxy.this.mPageCallback.beforeOrderIdUpdate();
                PageProxy.this.mOrderId = orderEvent.getOrderId();
                PageProxy.this.mPageCallback.afterOrderIdUpdate();
            }
        }
    };
    protected String mOrderId;
    protected final PageCallback mPageCallback;
    protected Session mSession;
    protected BaseEventPublisher.OnEventListener<SessionEvent> mSessionEventListener = new BaseEventPublisher.OnEventListener<SessionEvent>() {
        public void onEvent(String str, SessionEvent sessionEvent) {
            String a = PageProxy.f13313a;
            LogUtils.m34980i(a, "Session.onEvent:s = " + str + ", event = " + sessionEvent + ", mSession = " + PageProxy.this.mSession + ", mTag = " + PageProxy.this.mTag);
            if (sessionEvent == null) {
                LogUtils.m34979e(PageProxy.f13313a, "Session.onEvent:event is null");
            } else if (EventKeys.Session.EVENT_TRAVEL_SDK_CREATE_SESSION.equals(str)) {
                if (sessionEvent.getPageId() != PageProxy.this.mPageCallback.getPageId()) {
                    String a2 = PageProxy.f13313a;
                    LogUtils.m34982w(a2, "Session.onEvent:create session, page not match, curPageId = " + PageProxy.this.mPageCallback.getPageId() + ", event.pageId = " + sessionEvent.getPageId());
                    return;
                }
                PageProxy.this.mPageCallback.beforeCreateSession();
                PageProxy.this.mSession = TravelSDKV2.createSession(sessionEvent.getSessionTag(), IExpress.class);
                PageProxy.this.mPageCallback.afterCreateSession();
                BaseEventPublisher.getPublisher().publishSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_CREATE_SESSION, new SessionEvent(PageProxy.this.mPageCallback.getPageId(), PageProxy.this.mSession.getTag(), PageProxy.this.mSession.getKey()));
            } else if (!EventKeys.Session.EVENT_TRAVEL_SDK_DESTROY_SESSION.equals(str)) {
                String a3 = PageProxy.f13313a;
                LogUtils.m34979e(a3, "Session.onEvent:invalid biz session event, s = " + str + ", event = " + sessionEvent);
            } else if (PageProxy.this.mSession == null) {
                LogUtils.m34979e(PageProxy.f13313a, "Session.onEvent:destroy session, mSession is null");
            } else if (!TextUtil.equals(PageProxy.this.mSession.getKey(), sessionEvent.getSessionKey())) {
                String a4 = PageProxy.f13313a;
                LogUtils.m34979e(a4, "Session.onEvent:destroy session, session key is not match, mSession.key = " + PageProxy.this.mSession.getKey() + ", event.sessionKey = " + sessionEvent.getSessionKey());
            } else if (sessionEvent.getPageId() != PageProxy.this.mPageCallback.getPageId()) {
                String a5 = PageProxy.f13313a;
                LogUtils.m34982w(a5, "Session.onEvent:destroy session, page not match, curPageId = " + PageProxy.this.mPageCallback.getPageId() + ", event.pageId = " + sessionEvent.getPageId());
            } else {
                SessionEvent sessionEvent2 = new SessionEvent(PageProxy.this.mPageCallback.getPageId(), PageProxy.this.mSession.getTag(), PageProxy.this.mSession.getKey());
                PageProxy.this.mPageCallback.beforeDestroySession();
                PageProxy.this.mSession.getLifecycle().setCurrentState(Lifecycle.State.DESTROYED);
                PageProxy.this.mSession = null;
                PageProxy.this.mPageCallback.afterDestroySession();
                BaseEventPublisher.getPublisher().publishSync(EventKeys.Session.EVENT_TRAVEL_SDK_RETURN_DESTROY_SESSION, sessionEvent2);
            }
        }
    };
    protected final String mTag;

    public static abstract class PageCallback {
        public void afterCreateSession() {
        }

        public void afterDestroySession() {
        }

        public void afterOrderIdUpdate() {
        }

        public void beforeCreateSession() {
        }

        public void beforeDestroySession() {
        }

        public void beforeOrderIdUpdate() {
        }

        public abstract int getPageId();
    }

    public PageProxy(PageCallback pageCallback, String str) {
        if (pageCallback != null) {
            this.mPageCallback = pageCallback;
            this.mTag = str;
            return;
        }
        throw new IllegalArgumentException(f13313a + ".new:callback is null, tag = " + str);
    }

    public String getTag() {
        return this.mTag;
    }

    public int getPageId() {
        return this.mPageCallback.getPageId();
    }

    public Session getSession() {
        return this.mSession;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public CarOrder getCarOrder() {
        if (TextUtils.isEmpty(this.mOrderId)) {
            String str = f13313a;
            LogUtils.m34979e(str, "getCarOrder:mOrderId is empty, tag = " + this.mTag);
            return null;
        }
        String generateCarOrderStoreKey = TravelUtil.generateCarOrderStoreKey(this.mOrderId);
        Store store = Store.getStore(generateCarOrderStoreKey);
        if (store != null) {
            return (CarOrder) store.getData();
        }
        String str2 = f13313a;
        LogUtils.m34979e(str2, "getCarOrder:store is null, storeKey = " + generateCarOrderStoreKey + ", tag = " + this.mTag);
        return null;
    }

    public Bundle getBundle() {
        if (this.mSession == null && TextUtils.isEmpty(this.mOrderId)) {
            return null;
        }
        Bundle bundle = new Bundle();
        Session session = this.mSession;
        if (session != null) {
            bundle.putString(TravelConstant.EXTRA_SESSION_KEY, session.getKey());
        }
        if (!TextUtils.isEmpty(this.mOrderId)) {
            bundle.putString(TravelConstant.EXTRA_ORDER_ID, this.mOrderId);
        }
        return bundle;
    }

    public void onAttach(Bundle bundle) {
        String str = f13313a;
        LogUtils.m34980i(str, "onAttach: bundle = " + bundle + ", mTag = " + this.mTag);
        if (bundle != null) {
            String string = bundle.getString(TravelConstant.EXTRA_SESSION_KEY);
            if (!TextUtils.isEmpty(string)) {
                this.mSession = TravelSDKV2.getSession(string);
            } else {
                this.mSession = null;
            }
            this.mOrderId = bundle.getString(TravelConstant.EXTRA_ORDER_ID);
            String str2 = f13313a;
            LogUtils.m34980i(str2, "onAttach:sessionKey = " + string + ", orderId = " + TravelUtil.getRichOid(this.mOrderId) + ", mTag = " + this.mTag);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_CREATE_SESSION, this.mSessionEventListener);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_DESTROY_SESSION, this.mSessionEventListener);
            BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID, this.mOrderEventListener);
        }
    }

    public void onDetach() {
        String str = f13313a;
        LogUtils.m34980i(str, "onRemove:mSession = " + this.mSession + ", mOrderId = " + TravelUtil.getRichOid(this.mOrderId) + ", mTag = " + this.mTag);
        this.mSession = null;
        this.mOrderId = "";
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_CREATE_SESSION, this.mSessionEventListener);
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_DESTROY_SESSION, this.mSessionEventListener);
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Session.EVENT_TRAVEL_SDK_UPDATE_ORDER_ID, this.mOrderEventListener);
    }
}
