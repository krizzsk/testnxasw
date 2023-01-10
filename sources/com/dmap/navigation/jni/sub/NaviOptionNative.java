package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.ctx.INaviOptionExt;
import com.dmap.navigation.jni.swig.NaviOption;

public class NaviOptionNative extends NaviOption implements INaviOptionExt {

    /* renamed from: a */
    private boolean f54567a;

    /* renamed from: b */
    private boolean f54568b = false;

    /* renamed from: c */
    private boolean f54569c = false;

    /* renamed from: d */
    private boolean f54570d = false;

    /* renamed from: e */
    private boolean f54571e = true;

    /* renamed from: f */
    private boolean f54572f = true;

    /* renamed from: g */
    private float f54573g = 10.0f;

    /* renamed from: h */
    private int f54574h = 2;

    /* renamed from: i */
    private final C18192a f54575i;

    /* renamed from: j */
    private INaviOptionExt.OptionChangedListener f54576j;

    /* renamed from: k */
    private int f54577k = 99;

    public NaviOptionNative() {
        C18192a aVar = new C18192a();
        this.f54575i = aVar;
        setNaviRouteStrategy(aVar);
        setDispatchId("");
        setDispatchType(0);
    }

    public boolean isKeepTrafficEvent() {
        return this.f54567a;
    }

    public boolean isMandatory() {
        return this.f54568b;
    }

    public void setLaneHovGrayEnable(boolean z) {
        this.f54569c = z;
    }

    public void setKeepTrafficEvent(boolean z) {
        this.f54567a = z;
    }

    public boolean isLaneHovGrayEnable() {
        return this.f54569c;
    }

    public void setMandatory(boolean z) {
        this.f54568b = z;
    }

    public void setOptionChangedListener(INaviOptionExt.OptionChangedListener optionChangedListener) {
        this.f54576j = optionChangedListener;
    }

    public C18192a getNaviRouteStrategy() {
        return this.f54575i;
    }

    public boolean isGuideLineEnable() {
        return this.f54570d;
    }

    public void setGuideLineEnable(boolean z) {
        this.f54570d = z;
        m40477a(INaviOptionExt.KEY_GUIDE, String.valueOf(z));
    }

    public void setMainRouteVisible(boolean z) {
        this.f54571e = z;
        m40477a(INaviOptionExt.KEY_MAIN_ROUTE, String.valueOf(z));
    }

    public boolean isMainRouteVisible() {
        return this.f54571e;
    }

    public void setMainRouteBubbleVisible(boolean z) {
        this.f54572f = z;
        m40477a(INaviOptionExt.KEY_MAIN_ROUTE_BUBBLE, String.valueOf(z));
    }

    public boolean isMainRouteBubbleVisible() {
        return this.f54572f;
    }

    public void setMainRouteLineWidth(float f) {
        this.f54573g = f;
    }

    public float getMainRouteLineWidth() {
        return this.f54573g;
    }

    public int getNaviLocLevel() {
        return this.f54574h;
    }

    public void setNaviLocLevel(int i) {
        this.f54574h = i;
    }

    public void setVehicleZIndex(int i) {
        this.f54577k = i;
    }

    public int getVehicleZIndex() {
        return this.f54577k;
    }

    /* renamed from: a */
    private void m40477a(String str, String str2) {
        INaviOptionExt.OptionChangedListener optionChangedListener = this.f54576j;
        if (optionChangedListener != null) {
            optionChangedListener.onChanged(str, str2);
        }
    }
}
