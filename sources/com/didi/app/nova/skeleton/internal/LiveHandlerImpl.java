package com.didi.app.nova.skeleton.internal;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.LiveHandler;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.ArrayList;
import java.util.List;

public final class LiveHandlerImpl implements IScopeLifecycle, LiveHandler {

    /* renamed from: a */
    private IScopeLifecycle.PageStatus f10316a;

    /* renamed from: b */
    private List<Cancelable> f10317b = new ArrayList();

    /* renamed from: c */
    private List<IScopeLifecycle> f10318c = new ArrayList();

    public void onCreate(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Create;
        m9066a(iLive);
    }

    public void onStart(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Start;
        m9066a(iLive);
    }

    public void onResume(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Resume;
        m9066a(iLive);
    }

    public void onPause(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Pause;
        m9066a(iLive);
    }

    public void onStop(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Stop;
        m9066a(iLive);
    }

    public void onDestroy(ILive iLive) {
        this.f10316a = IScopeLifecycle.PageStatus.Destroy;
        m9066a(iLive);
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        return this.f10318c.add(iScopeLifecycle);
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        return this.f10318c.remove(iScopeLifecycle);
    }

    public void bind(Cancelable cancelable) {
        if (cancelable != null) {
            if (isDestroyed()) {
                cancelable.cancel();
                TraceUtil.trace("LiveHandler", this + "#bind cancel: " + cancelable);
            } else if (!this.f10317b.contains(cancelable)) {
                this.f10317b.add(cancelable);
            }
        }
    }

    public boolean isActive() {
        return this.f10316a == IScopeLifecycle.PageStatus.Create || this.f10316a == IScopeLifecycle.PageStatus.Start || this.f10316a == IScopeLifecycle.PageStatus.Resume;
    }

    public boolean isDestroyed() {
        return this.f10316a == IScopeLifecycle.PageStatus.Destroy;
    }

    /* renamed from: a */
    private void m9066a(ILive iLive) {
        m9067b(iLive);
        if (isDestroyed()) {
            m9065a();
        }
    }

    /* renamed from: b */
    private void m9067b(ILive iLive) {
        for (IScopeLifecycle iScopeLifecycle : new ArrayList(this.f10318c)) {
            if (this.f10316a == IScopeLifecycle.PageStatus.Create) {
                iScopeLifecycle.onCreate(iLive);
            } else if (this.f10316a == IScopeLifecycle.PageStatus.Start) {
                iScopeLifecycle.onStart(iLive);
            } else if (this.f10316a == IScopeLifecycle.PageStatus.Resume) {
                iScopeLifecycle.onResume(iLive);
            } else if (this.f10316a == IScopeLifecycle.PageStatus.Pause) {
                iScopeLifecycle.onPause(iLive);
            } else if (this.f10316a == IScopeLifecycle.PageStatus.Stop) {
                iScopeLifecycle.onStop(iLive);
            } else if (this.f10316a == IScopeLifecycle.PageStatus.Destroy) {
                iScopeLifecycle.onDestroy(iLive);
            }
        }
    }

    /* renamed from: a */
    private void m9065a() {
        for (Cancelable cancelable : new ArrayList(this.f10317b)) {
            if (cancelable != null) {
                cancelable.cancel();
                TraceUtil.trace("LiveHandler", this + "#dispatchDestroyed cancel: " + cancelable);
            }
        }
        this.f10317b.clear();
        this.f10318c.clear();
    }
}
