package com.didi.entrega.info.helper;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, mo148868d2 = {"Lcom/didi/entrega/info/helper/OmegaUtils;", "", "()V", "DEFAULT_DURATION", "", "sLastTrackTime", "isFastSwTrack", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OmegaUtils.kt */
public final class OmegaUtils {
    public static final OmegaUtils INSTANCE = new OmegaUtils();

    /* renamed from: a */
    private static final long f22642a = 500;

    /* renamed from: b */
    private static long f22643b;

    private OmegaUtils() {
    }

    public final boolean isFastSwTrack() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f22643b < 500;
        if (!z) {
            f22643b = currentTimeMillis;
        }
        return z;
    }
}
