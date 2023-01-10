package com.didiglobal.eevee.mew.widget.titlebar;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.IComponentEx;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.lang.ref.WeakReference;

/* renamed from: com.didiglobal.eevee.mew.widget.titlebar.a */
/* compiled from: EeveeTopBarPresenter */
class C17608a extends EeveeCompPresenterImpl<EeveeTopBarView> {

    /* renamed from: a */
    private WeakReference<Activity> f52657a;

    /* renamed from: b */
    private WeakReference<Fragment> f52658b;

    /* renamed from: c */
    private IComponentEx f52659c;

    /* renamed from: d */
    private XEResponseCallback f52660d = new EeveeTopBarPresenter$1(this);

    public C17608a(ComponentParams componentParams) {
        super(componentParams);
        this.f52657a = new WeakReference<>(componentParams.getActivity());
        this.f52658b = new WeakReference<>(componentParams.getFragment());
    }

    /* renamed from: a */
    public void mo129010a() {
        ((Fragment) this.f52658b.get()).getFragmentManager().popBackStack();
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_TOP_BAR, getNodeEeveeID(), this.f52660d));
        WeakReference<Fragment> weakReference = this.f52658b;
        if (weakReference != null && weakReference.get() != null && bundle != null && !bundle.getBoolean("is_sa")) {
            Fragment fragment = (Fragment) this.f52658b.get();
            if ((fragment instanceof PageFragment) || this.f52659c != null) {
                ((PageFragment) fragment).invisibleComponent(this.f52659c);
            }
        }
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMP_TOP_BAR);
    }

    /* renamed from: a */
    public void mo129011a(IComponentEx iComponentEx) {
        this.f52659c = iComponentEx;
    }
}
