package com.didi.soda.blocks.track;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\r"}, mo148868d2 = {"Lcom/didi/soda/blocks/track/Sampler;", "", "mRate", "", "(I)V", "mRandom", "Ljava/util/Random;", "mRange", "getMRate", "()I", "setMRate", "isHitSampling", "", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Sampler.kt */
public final class Sampler {
    private Random mRandom;
    private int mRange;
    private int mRate;

    public Sampler() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public Sampler(int i) {
        this.mRate = i;
        this.mRange = 1000;
        this.mRandom = new Random();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Sampler(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getMRate() {
        return this.mRate;
    }

    public final void setMRate(int i) {
        this.mRate = i;
    }

    public final boolean isHitSampling() {
        return this.mRandom.nextInt(this.mRange) < this.mRate;
    }
}
