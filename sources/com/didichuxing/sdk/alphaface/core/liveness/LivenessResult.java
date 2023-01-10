package com.didichuxing.sdk.alphaface.core.liveness;

import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import java.util.ArrayList;
import java.util.List;

public class LivenessResult {

    /* renamed from: a */
    private final List<ILivenessCallback.PicWithScore> f51277a = new ArrayList();

    /* renamed from: b */
    private final List<ILivenessCallback.PicWithScore> f51278b = new ArrayList();

    /* renamed from: c */
    private final List<ILivenessCallback.PicWithScore> f51279c = new ArrayList();

    /* renamed from: d */
    private final List<ILivenessCallback.PicWithScore> f51280d = new ArrayList();

    LivenessResult() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127148a() {
        this.f51277a.clear();
        this.f51278b.clear();
        this.f51279c.clear();
        this.f51280d.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127150a(List<ILivenessCallback.PicWithScore> list, List<ILivenessCallback.PicWithScore> list2, List<ILivenessCallback.PicWithScore> list3) {
        this.f51277a.addAll(list);
        this.f51279c.addAll(list2);
        this.f51280d.addAll(list3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo127149a(List<ILivenessCallback.PicWithScore> list) {
        this.f51278b.addAll(list);
    }

    public List<ILivenessCallback.PicWithScore> getBestPicList() {
        return this.f51277a;
    }

    public List<ILivenessCallback.PicWithScore> getBestActionPicList() {
        return this.f51278b;
    }

    public List<ILivenessCallback.PicWithScore> getAttackPicList() {
        return this.f51279c;
    }

    public List<ILivenessCallback.PicWithScore> getWaterPicList() {
        return this.f51280d;
    }
}
