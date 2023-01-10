package com.didi.component.never.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenter;
import com.didi.component.never.core.ComponentProxy;
import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.IComponentGroup;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.IViewContainer;
import com.didi.component.never.core.annotation.AnnotationUtil;
import com.didi.component.never.core.container.ContainerComponent;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.node.NodeManager;
import com.didi.component.never.core.page.Page;
import com.didi.component.never.core.proxy.ProxyMap;
import com.didi.component.never.core.util.CLog;
import com.didi.component.never.core.util.FrameworkRegister;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class PageFragment extends Fragment implements NodeManager.OnNodeChangedListener, Page {

    /* renamed from: a */
    private static final String f16470a = PageFragment.class.getSimpleName();

    /* renamed from: b */
    private ViewGroup f16471b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public NodeManager f16472c;

    /* renamed from: d */
    private HashMap<String, IComponent> f16473d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, IComponent> f16474e = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public HashMap<String, IComponent> f16475f = new HashMap<>();

    /* renamed from: g */
    private IViewContainer.IComponentCreator f16476g;

    /* renamed from: h */
    private Activity f16477h;

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getComponentExtraParams();

    /* access modifiers changed from: protected */
    public abstract ForwardOptions getForwardOptions();

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f16477h = (Activity) context;
    }

    public ViewGroup getContainerView() {
        return this.f16471b;
    }

    public NodeManager getNodeManager() {
        return this.f16472c;
    }

    public IComponent inflateComponent(Class<? extends IComponent> cls) {
        IComponent a = m13807a(AnnotationUtil.getComponentName(cls), cls, getContainerView(), (ViewGroup.LayoutParams) null);
        if (a == null) {
            return null;
        }
        String componentName = AnnotationUtil.getComponentName(a.getClass());
        this.f16473d.put(componentName, a);
        this.f16474e.put(componentName, a);
        return a;
    }

    public final void forward() {
        getNodeManager().startNode(getForwardOptions().nodeID, getForwardOptions().launchMode, getForwardOptions().bundle, true);
    }

    public void visibleComponent(IComponent iComponent) {
        String componentName = AnnotationUtil.getComponentName(iComponent.getClass());
        this.f16474e.put(componentName, iComponent);
        if (iComponent.getView() != null && iComponent.getView().getView() != null) {
            SystemUtils.log(6, "tagMelo", "visibleComponent:" + componentName, (Throwable) null, "com.didi.component.never.base.PageFragment", 107);
            iComponent.getView().getView().setVisibility(0);
        }
    }

    public void invisibleComponent(IComponent iComponent) {
        String componentName = AnnotationUtil.getComponentName(iComponent.getClass());
        this.f16474e.remove(componentName);
        if (iComponent.getView() != null && iComponent.getView().getView() != null) {
            SystemUtils.log(6, "tagMelo", "invisibleComponent:" + componentName, (Throwable) null, "com.didi.component.never.base.PageFragment", 117);
            iComponent.getView().getView().setVisibility(8);
        }
    }

    public void removeComponent(IComponent iComponent) {
        m13813a(iComponent);
        m13814a(iComponent, (Map<String, IComponent>) this.f16473d);
        m13814a(iComponent, (Map<String, IComponent>) this.f16474e);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (getCurrentNode() != null) {
            getCurrentNode().getPresenter().onPageHiddenChanged(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13813a(IComponent iComponent) {
        if (iComponent != null && iComponent.getView() != null && iComponent.getView().getView() != null && iComponent.getView().getView().getParent() != null) {
            ((ViewGroup) iComponent.getView().getView().getParent()).removeView(iComponent.getView().getView());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m13814a(com.didi.component.never.core.IComponent r5, java.util.Map<java.lang.String, com.didi.component.never.core.IComponent> r6) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.util.Set r1 = r6.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x000c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0025
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            if (r3 != r5) goto L_0x000c
            java.lang.Object r5 = r2.getKey()
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
        L_0x0025:
            if (r0 == 0) goto L_0x002a
            r6.remove(r0)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.never.base.PageFragment.m13814a(com.didi.component.never.core.IComponent, java.util.Map):void");
    }

    /* renamed from: a */
    private IComponentGroup m13808a(View view, String str, IComponent iComponent) {
        IComponentGroup iComponentGroup = null;
        while (view != null) {
            iComponentGroup = (IComponentGroup) view.getTag(R.string.tag_component);
            if (iComponentGroup != null || !(view.getParent() instanceof View)) {
                break;
            }
            view = (View) view.getParent();
        }
        if (iComponentGroup != null) {
            iComponentGroup.onChildComponentCreated(str, iComponent);
        }
        return iComponentGroup;
    }

    public IViewContainer.IComponentCreator getViewCreator() {
        return this.f16476g;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NodeManager nodeManager = new NodeManager(this, getActivity());
        this.f16472c = nodeManager;
        nodeManager.setOnNodeChangedListener(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.f16471b = (ViewGroup) inflate;
        return inflate;
    }

    public void onResume() {
        super.onResume();
        if (getCurrentNode() != null) {
            getCurrentNode().getPresenter().onPageResume();
        }
    }

    public void changeLayoutParams(String str, ViewGroup.LayoutParams layoutParams) {
        for (int i = 0; i < getContainerView().getChildCount(); i++) {
            Object tag = getContainerView().getChildAt(i).getTag();
            if ((tag instanceof String) && TextUtils.equals((String) tag, str)) {
                getContainerView().getChildAt(i).setLayoutParams(layoutParams);
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (getCurrentNode() != null) {
            getCurrentNode().getPresenter().onPagePause();
        }
    }

    public void onStart() {
        super.onStart();
        if (getCurrentNode() != null) {
            getCurrentNode().getPresenter().onPageStart();
        }
    }

    public void onStop() {
        super.onStop();
        if (getCurrentNode() != null) {
            getCurrentNode().getPresenter().onPageStop();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        m13810a();
    }

    /* renamed from: a */
    private void m13810a() {
        for (IComponent next : this.f16473d.values()) {
            if (!(next == null || next.getPresenter() == null)) {
                next.getPresenter().onRemove();
                List<String> childComponents = next.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onRemove();
                        }
                    }
                }
            }
        }
        this.f16472c.release();
        this.f16472c = null;
    }

    public Node getCurrentNode() {
        return this.f16472c.getActiveNode();
    }

    public Map<String, IComponent> getInflatedComponents() {
        return this.f16473d;
    }

    public Map<String, IComponent> getActiveComponents() {
        return this.f16474e;
    }

    public IComponent findComponentByType(String str) {
        HashMap<String, IComponent> hashMap = this.f16473d;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public IComponent findChildComponentByType(String str) {
        HashMap<String, IComponent> hashMap = this.f16475f;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    public ComponentParams getComponentParams(String str, String str2) {
        ComponentParams type = ComponentParams.from(str).type(str2);
        type.add(isAdded() ? getActivity() : this.f16477h).add((Fragment) this).add((Map) getComponentExtraParams());
        return type;
    }

    /* renamed from: a */
    private void m13815a(IView iView) {
        if (iView instanceof IViewContainer) {
            ((IViewContainer) iView).setComponentCreator(generateComponentCreator());
        }
    }

    /* access modifiers changed from: protected */
    public IViewContainer.IComponentCreator generateComponentCreator() {
        if (this.f16476g == null) {
            this.f16476g = new IViewContainer.IComponentCreator() {
                public IComponent inflateComponent(ComponentPresenter componentPresenter, String str, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, Bundle bundle) {
                    IComponent a = PageFragment.this.m13807a(str, FrameworkRegister.getChildComponentClass(str), viewGroup, layoutParams);
                    if (a == null || a.getPresenter() == null) {
                        return null;
                    }
                    if (componentPresenter != null) {
                        PageFragment.this.f16475f.put(str, a);
                        componentPresenter.addChildComponent(str);
                        PageFragment.this.f16472c.componentSetParent(a);
                        a.getPresenter().onAdd(bundle);
                        return a;
                    }
                    throw new NullPointerException("IViewContainer.getPresenter()can not return null!");
                }

                public IComponent newComponent(ComponentPresenter componentPresenter, String str, ViewGroup viewGroup, Bundle bundle) {
                    IComponent a = PageFragment.this.m13807a(str, FrameworkRegister.getChildComponentClass(str), viewGroup, (ViewGroup.LayoutParams) null);
                    if (a == null || a.getPresenter() == null) {
                        return null;
                    }
                    PageFragment.this.f16475f.put(str, a);
                    componentPresenter.addChildComponent(str);
                    PageFragment.this.f16472c.componentSetParent(a);
                    a.getPresenter().onAdd(bundle);
                    return a;
                }

                public void removeComponent(ComponentPresenter componentPresenter, IComponent iComponent) {
                    PageFragment.this.m13813a(iComponent);
                    if (iComponent.getPresenter() != null) {
                        iComponent.getPresenter().onRemove();
                    }
                    componentPresenter.removeChildComponent(AnnotationUtil.getComponentName(iComponent.getClass()));
                    PageFragment pageFragment = PageFragment.this;
                    pageFragment.m13814a(iComponent, (Map<String, IComponent>) pageFragment.f16475f);
                }

                public void removeComponent(ComponentPresenter componentPresenter, String str) {
                    IComponent findChildComponentByType = PageFragment.this.findChildComponentByType(str);
                    if (findChildComponentByType != null) {
                        removeComponent(componentPresenter, findChildComponentByType);
                    }
                }
            };
        }
        return this.f16476g;
    }

    public void layoutComponents(ContainerComponent containerComponent) {
        LinkedHashMap<String, ViewGroup.LayoutParams> layoutParams = containerComponent.getPresenter().getLayoutParams();
        for (String next : layoutParams.keySet()) {
            IComponent iComponent = this.f16473d.get(next);
            if (iComponent != null) {
                ViewGroup.LayoutParams layoutParams2 = layoutParams.get(next);
                if (!(iComponent.getView() == null || iComponent.getView().getView() == null)) {
                    View view = iComponent.getView().getView();
                    view.setTag(next);
                    ViewGroup containerView = getContainerView();
                    if (!(view.getParent() != null || containerView == null || layoutParams2 == null)) {
                        containerView.addView(view, layoutParams2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public IComponent m13807a(String str, Class<? extends IComponent> cls, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        IComponent iComponent;
        ComponentProxy a;
        View view = null;
        if (cls == null) {
            return null;
        }
        try {
            iComponent = (IComponent) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            iComponent = null;
        }
        if (iComponent == null) {
            CLog.m13856e(f16470a + " " + str + " component is null");
            return null;
        }
        String nodeId = this.f16472c.getInflatedNode() == null ? "" : AnnotationUtil.getNodeId(this.f16472c.getInflatedNode().getClass());
        String componentName = AnnotationUtil.getComponentName(iComponent.getClass());
        ComponentParams componentParams = getComponentParams(nodeId, str);
        CLog.m13855d("component init params is" + componentParams);
        Class<? extends ComponentProxy> proxy = ProxyMap.getProxy(str);
        if (!(proxy == null || (a = m13805a(proxy)) == null)) {
            iComponent.setComponentProxy(a);
        }
        iComponent.init(componentParams, viewGroup);
        IView view2 = iComponent.getView();
        if (view2 != null) {
            view = view2.getView();
            m13815a(view2);
        }
        if (iComponent.needInflate(componentParams)) {
            if (layoutParams == null) {
                layoutParams = iComponent.getLayoutParams(componentParams);
            }
            if (view != null) {
                view.setTag(componentName);
                if (!(viewGroup == null || layoutParams == null)) {
                    viewGroup.addView(view, layoutParams);
                }
            }
        }
        return iComponent;
    }

    /* renamed from: a */
    private ComponentProxy m13805a(Class<? extends ComponentProxy> cls) {
        try {
            return (ComponentProxy) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void nodeChanged(Node node) {
        onNodeChanged(node);
    }

    public void onNodeChanged(Node node) {
        for (IComponent presenter : getActiveComponents().values()) {
            presenter.getPresenter().onNodeChanged(node);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(getNodeManager().getActiveNode() == null || getNodeManager().getActiveNode().getPresenter() == null)) {
            getNodeManager().getActiveNode().getPresenter().onActivityResult(i, i2, intent);
        }
        for (IComponent next : getActiveComponents().values()) {
            if (!(next == null || next.getPresenter() == null)) {
                next.getPresenter().onActivityResult(i, i2, intent);
                List<String> childComponents = next.getPresenter().getChildComponents();
                if (childComponents != null) {
                    for (String findChildComponentByType : childComponents) {
                        IComponent findChildComponentByType2 = getNodeManager().getHostPage().findChildComponentByType(findChildComponentByType);
                        if (!(findChildComponentByType2 == null || findChildComponentByType2.getPresenter() == null)) {
                            findChildComponentByType2.getPresenter().onActivityResult(i, i2, intent);
                        }
                    }
                }
            }
        }
    }

    public boolean handleBackPressed() {
        if (getNodeManager().getActiveNode() == null || getNodeManager().getActiveNode().getPresenter() == null) {
            return false;
        }
        if (getNodeManager().getActiveNode().getPresenter().onBackPressed()) {
            return true;
        }
        if (!this.f16472c.canGoBack()) {
            return false;
        }
        this.f16472c.goBack((Bundle) null);
        return true;
    }
}
