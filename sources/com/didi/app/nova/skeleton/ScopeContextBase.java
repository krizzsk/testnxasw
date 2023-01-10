package com.didi.app.nova.skeleton;

import androidx.collection.ArrayMap;
import com.didi.app.nova.skeleton.internal.LiveHandlerImpl;
import java.util.Map;

public abstract class ScopeContextBase implements IScopeLifecycle, ScopeContext {

    /* renamed from: a */
    private INavigator f10098a;

    /* renamed from: b */
    private LiveHandlerImpl f10099b;

    /* renamed from: c */
    private Map<String, Object> f10100c = new ArrayMap();

    public ScopeContext getParent() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract INavigator newNavigator();

    public void onCreate(ILive iLive) {
        m8815a().onCreate(iLive);
    }

    public void onStart(ILive iLive) {
        m8815a().onStart(iLive);
    }

    public void onResume(ILive iLive) {
        m8815a().onResume(iLive);
    }

    public void onPause(ILive iLive) {
        m8815a().onPause(iLive);
    }

    public void onStop(ILive iLive) {
        m8815a().onStop(iLive);
    }

    public void onDestroy(ILive iLive) {
        m8815a().onDestroy(iLive);
    }

    public INavigator getNavigator() {
        if (this.f10098a == null) {
            this.f10098a = newNavigator();
        }
        return this.f10098a;
    }

    public LiveHandler getLiveHandler() {
        return m8815a();
    }

    public boolean addObserver(IScopeLifecycle iScopeLifecycle) {
        return m8815a().addObserver(iScopeLifecycle);
    }

    public boolean removeObserver(IScopeLifecycle iScopeLifecycle) {
        return m8815a().removeObserver(iScopeLifecycle);
    }

    /* renamed from: a */
    private LiveHandlerImpl m8815a() {
        if (this.f10099b == null) {
            this.f10099b = new LiveHandlerImpl();
        }
        return this.f10099b;
    }

    public Object attach(String str, Object obj) {
        return this.f10100c.put(str, obj);
    }

    public Object detach(String str) {
        return this.f10100c.remove(str);
    }

    public Object getObject(String str) {
        return this.f10100c.get(str);
    }

    public void detachAll() {
        this.f10100c.clear();
    }
}
