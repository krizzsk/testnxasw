package com.dmap.navigation.engine.p207a;

import android.content.Context;
import com.didi.hawaii.utils.Md5Util;
import com.didichuxing.omega.sdk.Omega;
import com.dmap.navigation.api.http.ISession;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.ctx.INaviOption;
import com.dmap.navigation.base.ctx.IOrderInfo;
import com.dmap.navigation.base.ctx.IUserInfo;
import com.dmap.navigation.jni.sub.NaviOptionNative;
import com.dmap.navigation.jni.sub.OrderInfoNative;
import com.dmap.navigation.jni.sub.UserInfoNative;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.dmap.navigation.engine.a.n */
/* compiled from: NaviContextImpl */
public final class C18181n implements ISession, INaviContext {

    /* renamed from: a */
    private final Context f54370a;

    /* renamed from: aL */
    public final UserInfoNative f54371aL = new UserInfoNative();

    /* renamed from: aM */
    public final OrderInfoNative f54372aM = new OrderInfoNative();

    /* renamed from: aN */
    public final NaviOptionNative f54373aN = new NaviOptionNative();

    /* renamed from: b */
    private final AtomicInteger f54374b = new AtomicInteger(0);

    /* renamed from: c */
    private String f54375c;

    /* renamed from: d */
    private String f54376d;

    public C18181n(Context context) {
        this.f54370a = context;
        String omegaId = Omega.getOmegaId();
        this.f54371aL.setDeviceId(omegaId == null ? "unknown" : omegaId);
        this.f54373aN.setNgFlag(4);
        this.f54373aN.setNgVersion(5001);
        this.f54373aN.setDiaUpgrade(C18179l.m40460c());
        this.f54373aN.setCameraDisplay(C18179l.m40463f() ? 1 : 0);
        this.f54373aN.setFbRoadName(C18179l.isOpenFbRoadName() ? 1 : 0);
        this.f54373aN.setFishbone(C18179l.m40461d());
        this.f54373aN.setMultiRouteEnable(C18179l.m40462e());
        this.f54373aN.setYawVersion(2);
        this.f54373aN.setVector(C18179l.m40464g() ? 1 : 0);
        this.f54373aN.setNeedTrafficEvent(C18179l.isTrafficEventOpen());
        this.f54373aN.setNeedmission(C18179l.m40459b());
        this.f54373aN.setNeedmjo(true);
        this.f54373aN.setNeedTraffic(true);
        this.f54373aN.setNoNeedRainbow(false);
    }

    public final Context getAndroidContext() {
        return this.f54370a;
    }

    /* renamed from: a */
    private static String m40468a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 20);
        sb.append(str);
        String l = Long.toString(System.currentTimeMillis());
        int length = l.length();
        sb.append(l.substring(length - 10, length));
        sb.append((int) (((Math.random() * 9.0d) + 1.0d) * 1.0E9d));
        return Md5Util.getMD5(sb.toString());
    }

    public final synchronized String getSessionId() {
        if (this.f54375c == null) {
            this.f54375c = m40468a(this.f54371aL.getImei());
        }
        return this.f54375c;
    }

    public final int getSeq() {
        return this.f54374b.incrementAndGet();
    }

    public final synchronized String getTripId() {
        if (this.f54376d == null) {
            this.f54376d = m40468a(this.f54371aL.getImei());
        }
        return this.f54376d;
    }

    public final /* bridge */ /* synthetic */ INaviOption getNaviOption() {
        return this.f54373aN;
    }

    public final /* bridge */ /* synthetic */ IOrderInfo getOrderInfo() {
        return this.f54372aM;
    }

    public final /* bridge */ /* synthetic */ IUserInfo getUserInfo() {
        return this.f54371aL;
    }
}
