package com.didichuxing.mlcp.drtc.models;

import com.didichuxing.mlcp.drtc.enums.DrtcCameraType;
import com.didichuxing.mlcp.drtc.enums.DrtcMode;

/* renamed from: com.didichuxing.mlcp.drtc.models.a */
/* compiled from: DrtcMediaConstraints */
public class C16700a {

    /* renamed from: a */
    private boolean f50893a = true;

    /* renamed from: b */
    private boolean f50894b = true;

    /* renamed from: c */
    private boolean f50895c = true;

    /* renamed from: d */
    private boolean f50896d = false;

    /* renamed from: e */
    private DrtcMode f50897e = DrtcMode.Standard;

    /* renamed from: f */
    private DrtcCameraType f50898f = DrtcCameraType.FrontFace;

    /* renamed from: g */
    private C16702c f50899g = new C16702c();

    private C16700a() {
    }

    /* renamed from: i */
    public static C16700a m37988i() {
        return new C16700a();
    }

    /* renamed from: a */
    public void mo125495a(DrtcMode drtcMode) {
        this.f50897e = drtcMode;
        if (drtcMode == DrtcMode.OnlyAudio) {
            mo125496a((C16702c) null);
            mo125501d(true);
            mo125498b(true);
            mo125499c(false);
            this.f50896d = false;
        }
        if (drtcMode == DrtcMode.OnlyVideo) {
            mo125501d(false);
            mo125498b(false);
            this.f50896d = false;
        }
    }

    /* renamed from: b */
    public void mo125498b(boolean z) {
        this.f50895c = z;
    }

    /* renamed from: c */
    public void mo125499c(boolean z) {
        this.f50894b = z;
    }

    /* renamed from: d */
    public void mo125501d(boolean z) {
        this.f50893a = z;
    }

    /* renamed from: e */
    public boolean mo125503e() {
        return this.f50894b;
    }

    /* renamed from: f */
    public boolean mo125504f() {
        return this.f50893a;
    }

    /* renamed from: g */
    public Boolean mo125505g() {
        return Boolean.valueOf(this.f50899g != null);
    }

    /* renamed from: h */
    public C16702c mo125506h() {
        return this.f50899g;
    }

    /* renamed from: b */
    public DrtcCameraType mo125497b() {
        return this.f50898f;
    }

    /* renamed from: c */
    public boolean mo125500c() {
        return this.f50896d;
    }

    /* renamed from: d */
    public boolean mo125502d() {
        return this.f50895c;
    }

    /* renamed from: a */
    public DrtcMode mo125493a() {
        return this.f50897e;
    }

    /* renamed from: a */
    public C16700a mo125494a(boolean z) {
        this.f50896d = z;
        return this;
    }

    /* renamed from: a */
    public void mo125496a(C16702c cVar) {
        this.f50899g = cVar;
    }
}
