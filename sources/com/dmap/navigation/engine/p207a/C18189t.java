package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.Apollo;
import com.dmap.navigation.jni.swig.ApolloCallBack;
import com.dmap.navigation.jni.swig.ApolloToggle;

/* renamed from: com.dmap.navigation.engine.a.t */
/* compiled from: NavApolloImp */
public final class C18189t extends ApolloCallBack {
    public final ApolloToggle getToggle(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new C18190u(Apollo.getToggle(new String(bArr)));
    }

    /* renamed from: k */
    public final long mo131926k() {
        return getCPtr(this);
    }
}
