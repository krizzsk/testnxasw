package com.didi.app.nova.skeleton;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.app.nova.skeleton.internal.ScopeContextActivityImpl;
import com.didi.sdk.apm.SystemUtils;

public abstract class SkeletonActivity extends AppCompatActivity implements ILive {

    /* renamed from: a */
    private ScopeContextBase f10106a;

    /* renamed from: b */
    private ComponentGroup f10107b = new ComponentGroup();

    /* renamed from: c */
    private boolean f10108c;

    public abstract PageInstrument getPageInstrument();

    /* access modifiers changed from: protected */
    public abstract void onAfterCreate(Bundle bundle);

    /* access modifiers changed from: protected */
    public void setupComponents() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        ScopeContextBase onCreateScopeContext = onCreateScopeContext();
        this.f10106a = onCreateScopeContext;
        onCreateScopeContext.addObserver(this.f10107b);
        this.f10108c = true;
        onAfterCreate(bundle);
        setupComponents();
        this.f10106a.onCreate(this);
    }

    /* access modifiers changed from: protected */
    public ScopeContextBase onCreateScopeContext() {
        return new ScopeContextActivityImpl(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f10108c = true;
        this.f10106a.onStart(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f10108c = true;
        this.f10106a.onResume(this);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f10108c = false;
        this.f10106a.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f10108c = false;
        this.f10106a.onStop(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f10108c = false;
        this.f10106a.onDestroy(this);
        this.f10106a.detachAll();
        this.f10106a.removeObserver(this.f10107b);
        this.f10106a = null;
    }

    public boolean isActive() {
        return this.f10108c;
    }

    /* access modifiers changed from: protected */
    public final boolean addComponent(Component component) {
        component.attachScopeContext(getScopeContext());
        if (this.f10107b.addComponent(component)) {
            return true;
        }
        component.attachScopeContext((ScopeContext) null);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean removeComponent(Component component) {
        if (!this.f10107b.removeComponent(component)) {
            return false;
        }
        component.attachScopeContext((ScopeContext) null);
        return true;
    }

    public final Component getComponent(Class<? extends Component> cls) {
        return this.f10107b.getComponent(cls);
    }

    public ScopeContext getScopeContext() {
        return this.f10106a;
    }

    public String alias() {
        return getClass().getName();
    }
}
