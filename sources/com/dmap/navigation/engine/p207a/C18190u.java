package com.dmap.navigation.engine.p207a;

import com.didichuxing.apollo.sdk.IToggle;
import com.dmap.navigation.jni.swig.ApolloExperiment;
import com.dmap.navigation.jni.swig.ApolloToggle;

/* renamed from: com.dmap.navigation.engine.a.u */
/* compiled from: NavApolloToggle */
public final class C18190u extends ApolloToggle {

    /* renamed from: a */
    private IToggle f54390a = null;

    public C18190u(IToggle iToggle) {
        this.f54390a = iToggle;
    }

    public final ApolloExperiment getExperiment() {
        IToggle iToggle = this.f54390a;
        if (iToggle == null || !iToggle.allow()) {
            return null;
        }
        return new C18188s(this.f54390a.getExperiment());
    }

    public final boolean allow() {
        IToggle iToggle = this.f54390a;
        if (iToggle != null) {
            return iToggle.allow();
        }
        return false;
    }
}
