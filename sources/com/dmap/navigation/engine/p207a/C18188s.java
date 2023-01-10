package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IExperiment;
import com.dmap.navigation.jni.swig.ApolloExperiment;

/* renamed from: com.dmap.navigation.engine.a.s */
/* compiled from: NavApolloExperiment */
public final class C18188s extends ApolloExperiment {

    /* renamed from: a */
    private IExperiment f54389a = null;

    public C18188s(IExperiment iExperiment) {
        this.f54389a = iExperiment;
    }

    public final int getParam(byte[] bArr, int i) {
        return ((Integer) m40474a(bArr, Integer.valueOf(i))).intValue();
    }

    public final float getParam(byte[] bArr, float f) {
        return ((Float) m40474a(bArr, Float.valueOf(f))).floatValue();
    }

    public final String getParam(byte[] bArr, String str) {
        return (String) m40474a(bArr, str);
    }

    /* renamed from: a */
    private <T> T m40474a(byte[] bArr, T t) {
        if (bArr == null || this.f54389a == null) {
            return null;
        }
        return this.f54389a.getParam(new String(bArr), t);
    }
}
