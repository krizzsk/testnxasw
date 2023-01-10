package com.didichuxing.mlcp.drtc.models;

import com.didichuxing.mlcp.drtc.enums.DrtcEnvType;
import com.didichuxing.mlcp.drtc.utils.ApiServer;

/* renamed from: com.didichuxing.mlcp.drtc.models.b */
/* compiled from: DrtcSDKConfig */
public class C16701b {

    /* renamed from: a */
    public int f50900a;

    /* renamed from: b */
    public String f50901b;

    /* renamed from: c */
    public String f50902c;

    /* renamed from: d */
    public String f50903d;

    /* renamed from: e */
    public String f50904e;

    /* renamed from: f */
    public String f50905f;

    /* renamed from: g */
    public String f50906g;

    /* renamed from: h */
    public DrtcEnvType f50907h;

    /* renamed from: i */
    private SessionConnInfo f50908i;

    /* renamed from: j */
    private String f50909j;

    public C16701b() {
        mo125507a(DrtcEnvType.ENV_GLOBAL);
    }

    /* renamed from: a */
    public C16701b mo125507a(DrtcEnvType drtcEnvType) {
        if (drtcEnvType.equals(DrtcEnvType.ENV_GLOBAL)) {
            this.f50901b = m38003a("drtc-api.didiglobal.com");
            this.f50904e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_PROD_US)) {
            this.f50901b = m38003a("drtc-api.didiglobal.com");
            this.f50904e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_CN)) {
            this.f50901b = m38003a("drtc-api.didiglobal.com");
            this.f50904e = "43.135.216.69";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_US)) {
            this.f50901b = m38003a("43.130.116.113:8188");
            this.f50904e = "43.130.119.78";
        } else if (drtcEnvType.equals(DrtcEnvType.ENV_TEST_BR)) {
            this.f50901b = m38003a("43.135.216.69:8188");
            this.f50904e = "43.130.119.78";
        }
        this.f50900a = 1234;
        this.f50903d = "janus-protocol";
        this.f50902c = "janus";
        this.f50905f = "itsolar";
        this.f50906g = "didichuxing01";
        this.f50907h = drtcEnvType;
        return this;
    }

    public C16701b(String str) {
        this.f50909j = str;
        this.f50908i = null;
        this.f50907h = DrtcEnvType.ENV_CUSTOM;
    }

    /* renamed from: a */
    public boolean mo125508a(int i) {
        this.f50900a = i;
        if (this.f50907h == DrtcEnvType.ENV_CUSTOM) {
            return m38004a();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m38004a() {
        SessionConnInfo sessionConnInfo = ApiServer.getInstance().getSessionConnInfo(this.f50909j, String.valueOf(this.f50900a));
        this.f50908i = sessionConnInfo;
        if (sessionConnInfo == null) {
            return false;
        }
        if (sessionConnInfo.mo125489a() == null) {
            this.f50901b = "drtc-api.didiglobal.com";
        } else {
            this.f50901b = "wss://" + this.f50908i.mo125489a() + "/" + "janus";
        }
        this.f50902c = "janus";
        this.f50903d = "janus-protocol";
        this.f50904e = this.f50908i.mo125491c();
        this.f50905f = this.f50908i.mo125492d();
        this.f50906g = this.f50908i.mo125490b();
        return true;
    }

    /* renamed from: a */
    private String m38003a(String str) {
        return String.format("wss://%s/janus", new Object[]{str});
    }
}
