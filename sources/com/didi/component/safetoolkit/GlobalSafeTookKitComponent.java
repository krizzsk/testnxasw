package com.didi.component.safetoolkit;

import android.view.ViewGroup;
import com.didi.carpool.onservice.CarPoolOnServiceSafeToolkitPresenter;
import com.didi.component.ComponentBinder;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.EndSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.OnServiceSafeToolkitPresenter;
import com.didi.component.safetoolkit.views.SafeToolkitView;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.runtime.reflect.Factory;

@ComponentRegister(product = "ride", type = "safe_toolkit")
public class GlobalSafeTookKitComponent extends BaseComponent<ISafeToolkitView, AbsSafeToolkitPresenter> {

    /* renamed from: a */
    private static /* synthetic */ JoinPoint.StaticPart f17211a;

    static {
        m14421a();
    }

    /* renamed from: a */
    private static /* synthetic */ void m14421a() {
        Factory factory = new Factory("GlobalSafeTookKitComponent.java", GlobalSafeTookKitComponent.class);
        f17211a = factory.makeSJP(JoinPoint.METHOD_EXECUTION, (Signature) factory.makeMethodSig("4", "onCreatePresenter", "com.didi.component.safetoolkit.GlobalSafeTookKitComponent", "com.didi.component.core.ComponentParams", "componentParams", "", "com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter"), 28);
    }

    /* access modifiers changed from: protected */
    public AbsSafeToolkitPresenter onCreatePresenter(ComponentParams componentParams) {
        JoinPoint makeJP = Factory.makeJP(f17211a, (Object) this, (Object) this, (Object) componentParams);
        return (AbsSafeToolkitPresenter) m14420a(this, componentParams, makeJP, ComponentBinder.aspectOf(), (ProceedingJoinPoint) makeJP);
    }

    /* access modifiers changed from: protected */
    public ISafeToolkitView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new SafeToolkitView(componentParams.bizCtx.getContext());
    }

    /* renamed from: a */
    private static final /* synthetic */ AbsSafeToolkitPresenter m14419a(GlobalSafeTookKitComponent globalSafeTookKitComponent, ComponentParams componentParams, JoinPoint joinPoint) {
        if (componentParams.pageID != 1040) {
            return null;
        }
        int i = componentParams.scene;
        if (i == 10402) {
            return new OnServiceSafeToolkitPresenter(componentParams);
        }
        if (i != 10403) {
            return null;
        }
        return new EndSafeToolkitPresenter(componentParams);
    }

    /* renamed from: a */
    private static final /* synthetic */ Object m14420a(GlobalSafeTookKitComponent globalSafeTookKitComponent, ComponentParams componentParams, JoinPoint joinPoint, ComponentBinder componentBinder, ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        if (args == null) {
            return null;
        }
        ComponentParams componentParams2 = (ComponentParams) args[0];
        if (4 == componentParams2.comboType && componentParams2.versionCode >= 0 && componentParams2.versionCode <= 10) {
            if (1010 == componentParams2.scene) {
                return new CarPoolOnServiceSafeToolkitPresenter(componentParams2);
            }
            if (10402 == componentParams2.scene) {
                return new CarPoolOnServiceSafeToolkitPresenter(componentParams2);
            }
        }
        try {
            return m14419a(globalSafeTookKitComponent, componentParams, proceedingJoinPoint);
        } catch (Throwable unused) {
            return null;
        }
    }
}
