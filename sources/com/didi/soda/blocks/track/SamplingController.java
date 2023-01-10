package com.didi.soda.blocks.track;

import com.didi.soda.blocks.sdk.BlocksEngine;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/soda/blocks/track/SamplingController;", "", "()V", "RATE_DEFAULT", "", "RATE_NEVER_HIT", "mSamplerMap", "", "", "Lcom/didi/soda/blocks/track/Sampler;", "mTrackConfig", "Lcom/didi/soda/blocks/track/TrackConfig;", "doIfHit", "", "templateId", "block", "Lkotlin/Function0;", "getSampler", "getSamplingRate", "getTrackConfig", "isOpen", "", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: SamplingController.kt */
public final class SamplingController {
    public static final SamplingController INSTANCE = new SamplingController();
    private static final int RATE_DEFAULT = 3;
    private static final int RATE_NEVER_HIT = 0;
    private static Map<String, Sampler> mSamplerMap = new LinkedHashMap();
    private static TrackConfig mTrackConfig;

    private SamplingController() {
    }

    public final void doIfHit(String str, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, "templateId");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        if (isOpen() && getSampler(str).isHitSampling()) {
            function0.invoke();
        }
    }

    private final boolean isOpen() {
        return getTrackConfig().isOpen();
    }

    private final Sampler getSampler(String str) {
        int samplingRate = getSamplingRate(str);
        if (mSamplerMap.containsKey(str)) {
            Sampler sampler = mSamplerMap.get(str);
            if (sampler != null) {
                return sampler;
            }
            return new Sampler(samplingRate);
        }
        Sampler sampler2 = new Sampler(samplingRate);
        mSamplerMap.put(str, sampler2);
        return sampler2;
    }

    private final int getSamplingRate(String str) {
        if (!getTrackConfig().getRateConfigMap().containsKey(str)) {
            return 3;
        }
        Integer num = getTrackConfig().getRateConfigMap().get(str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final TrackConfig getTrackConfig() {
        if (mTrackConfig == null) {
            TrackConfig trackConfig = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getConfig().getTrackConfig();
            mTrackConfig = trackConfig;
            if (trackConfig == null) {
                mTrackConfig = new TrackConfig();
            }
        }
        TrackConfig trackConfig2 = mTrackConfig;
        if (trackConfig2 == null) {
            Intrinsics.throwNpe();
        }
        return trackConfig2;
    }
}
