package com.didi.map.sdk.nav.inertia;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloCache {

    /* renamed from: a */
    private static final String f30875a = "ApolloCache";

    /* renamed from: b */
    private int f30876b = 6;

    /* renamed from: c */
    private int f30877c = 20;

    /* renamed from: d */
    private int f30878d = 2;

    /* renamed from: e */
    private int f30879e = 150;

    /* renamed from: f */
    private int f30880f = 1;

    /* renamed from: g */
    private int f30881g = 4;

    /* renamed from: h */
    private int f30882h = 3;

    /* renamed from: i */
    private int f30883i = 2;

    /* renamed from: j */
    private int f30884j = 300;

    /* renamed from: k */
    private int f30885k = 4;

    /* renamed from: l */
    private boolean f30886l = false;

    /* renamed from: m */
    private IToggle f30887m;

    /* renamed from: n */
    private IExperiment f30888n;

    public ApolloCache() {
        IToggle toggle = Apollo.getToggle("global_inertia_simulate_param_toggle_all");
        this.f30887m = toggle;
        if (toggle != null && toggle.allow()) {
            this.f30888n = this.f30887m.getExperiment();
        }
        this.f30876b = m23726a("listsize", this.f30876b);
        this.f30877c = m23726a("maxspeed", this.f30877c);
        this.f30878d = m23726a("minspeed", this.f30878d);
        this.f30879e = m23726a("allow_dis", this.f30879e);
        this.f30880f = m23726a("standstill_speed", this.f30880f);
        this.f30881g = m23726a("coefficient", this.f30881g);
        this.f30882h = m23726a("failbinding_slowspeed", this.f30882h);
        this.f30883i = m23726a("catchspeed", this.f30883i);
        this.f30884j = m23726a("catch_dis", this.f30884j);
        this.f30885k = m23726a("netpoint_speed", this.f30885k);
        this.f30886l = isEvaluateEnabled();
        DLog.m10773d(f30875a, "listSize = %s ,maxSpeed= %s, minSpeed=%s, allow_dis=%s, standstill_speed=%s, coefficient=%s,failbinding_slowspeed=%s , catchspeed=%s, catch_dis=%s, netpoint_speed=%s, isEvaluate=%b", Integer.valueOf(this.f30876b), Integer.valueOf(this.f30877c), Integer.valueOf(this.f30878d), Integer.valueOf(this.f30879e), Integer.valueOf(this.f30880f), Integer.valueOf(this.f30881g), Integer.valueOf(this.f30882h), Integer.valueOf(this.f30883i), Integer.valueOf(this.f30884j), Integer.valueOf(this.f30885k), Boolean.valueOf(this.f30886l));
    }

    public int getListSize() {
        return this.f30876b;
    }

    public int getMaxSpeed() {
        return this.f30877c;
    }

    public int getMinSpeed() {
        return this.f30878d;
    }

    public int getAllow_dis() {
        return this.f30879e;
    }

    public int getStandstill_speed() {
        return this.f30880f;
    }

    public float getCoefficient() {
        return ((float) this.f30881g) * 0.1f;
    }

    public int getFailbinding_slowspeed() {
        return this.f30882h;
    }

    public int getCatchspeed() {
        return this.f30883i;
    }

    public int getCatch_dis() {
        return this.f30884j;
    }

    public int getNetpoint_speed() {
        return this.f30885k;
    }

    public boolean isEvaluate() {
        return this.f30886l;
    }

    public boolean isEvaluateEnabled() {
        IToggle toggle = Apollo.getToggle("global_sctx_mock_online_evaluate");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private int m23726a(String str, int i) {
        IExperiment iExperiment = this.f30888n;
        return iExperiment != null ? ((Integer) iExperiment.getParam(str, Integer.valueOf(i))).intValue() : i;
    }
}
