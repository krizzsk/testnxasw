package com.didi.app;

import android.text.TextUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.drouter.store.IRegister;
import com.didi.drouter.store.RouterKey;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class GeneralPageRouter {
    public static final String EVENT_KEY_DELIVERY_CALLBACK = "event_key_delivery_callback";
    public static final String RECIPIENT_LIST = "recipient_list";

    /* renamed from: b */
    private static final String f10060b = "params";

    /* renamed from: c */
    private static final String f10061c = "response";

    /* renamed from: d */
    private static final String f10062d = "target";

    /* renamed from: e */
    private static final String f10063e = "((taxis99onetravel)|(GlobalOneTravel)|(globalOneTravel)|(taxis99OneTravel)|(globalonetravel))://one/general.*";

    /* renamed from: f */
    private static volatile GeneralPageRouter f10064f;

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<String> f10065a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (GeneralPageRouter.this.f10066g != null) {
                if (!(GeneralPageRouter.this.f10067h == null || str2 == null)) {
                    GeneralPageRouter.this.f10067h.putExtra("response", str2);
                }
                RouterHelper.release(GeneralPageRouter.this.f10066g);
                Request unused = GeneralPageRouter.this.f10066g = null;
                Result unused2 = GeneralPageRouter.this.f10067h = null;
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Request f10066g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Result f10067h;

    /* renamed from: i */
    private IRegister f10068i;

    private GeneralPageRouter() {
    }

    public static GeneralPageRouter getInstance() {
        if (f10064f == null) {
            synchronized (GeneralPageRouter.class) {
                if (f10064f == null) {
                    f10064f = new GeneralPageRouter();
                }
            }
        }
        return f10064f;
    }

    /* renamed from: a */
    private void m8747a() {
        this.f10068i = DRouter.register(RouterKey.build(f10063e).setHold(true), (IRouterHandler) new IRouterHandler() {
            public void handle(Request request, Result result) {
                Request unused = GeneralPageRouter.this.f10066g = request;
                Result unused2 = GeneralPageRouter.this.f10067h = result;
                String queryParameter = request.getUri().getQueryParameter("target");
                if (queryParameter == null) {
                    RouterHelper.release(request);
                    return;
                }
                char c = 65535;
                if (queryParameter.hashCode() == -330539260 && queryParameter.equals(GeneralPageRouter.RECIPIENT_LIST)) {
                    c = 0;
                }
                if (c != 0) {
                    RouterHelper.release(request);
                    return;
                }
                try {
                    DRouter.build(URLDecoder.decode(GeneralPageRouter.this.m8746a(request.getUri().getQueryParameter("params")), "utf-8")).start();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m8746a(String str) {
        StringBuilder sb = new StringBuilder("taxis99OneTravel://one/delivery/delivery_consignee?");
        sb.append("source=1&");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.deleteCharAt(sb.length() - 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private void m8749b() {
        BaseEventPublisher.getPublisher().subscribe(EVENT_KEY_DELIVERY_CALLBACK, this.f10065a);
    }

    public void register() {
        m8749b();
        m8747a();
    }

    /* renamed from: c */
    private void m8750c() {
        BaseEventPublisher.getPublisher().unsubscribe(EVENT_KEY_DELIVERY_CALLBACK, this.f10065a);
    }

    /* renamed from: d */
    private void m8751d() {
        this.f10068i.unregister();
    }

    public void unregister() {
        m8750c();
        m8751d();
    }
}
