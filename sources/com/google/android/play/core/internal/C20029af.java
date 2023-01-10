package com.google.android.play.core.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.af */
public final class C20029af<StateT> {

    /* renamed from: a */
    protected final Set<StateUpdatedListener<StateT>> f56061a = new HashSet();

    /* renamed from: a */
    public final synchronized void mo164264a(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f56061a.add(stateUpdatedListener);
    }

    /* renamed from: a */
    public final synchronized void mo164265a(StateT statet) {
        for (StateUpdatedListener<StateT> onStateUpdate : this.f56061a) {
            onStateUpdate.onStateUpdate(statet);
        }
    }

    /* renamed from: b */
    public final synchronized void mo164266b(StateUpdatedListener<StateT> stateUpdatedListener) {
        this.f56061a.remove(stateUpdatedListener);
    }
}
