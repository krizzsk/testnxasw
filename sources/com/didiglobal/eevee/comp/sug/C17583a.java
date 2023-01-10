package com.didiglobal.eevee.comp.sug;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.didi.address.AddressException;
import com.didi.address.model.SugParams;
import com.didi.addressnew.NewAddressApiFactory;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.page.Page;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.event.BaseEventKeys;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.eevee.comp.sug.model.EOpenSugModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.lang.ref.WeakReference;

/* renamed from: com.didiglobal.eevee.comp.sug.a */
/* compiled from: ESugPresenter */
class C17583a extends EeveeCompPresenterImpl<EeveeIView> {

    /* renamed from: a */
    private WeakReference<Activity> f52635a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EOpenSugModel f52636b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<SugParams> f52637c = new ESugPresenter$1(this);

    /* renamed from: d */
    private XEResponseCallback f52638d = new ESugPresenter$2(this);

    public C17583a(ComponentParams componentParams) {
        super(componentParams);
        this.f52635a = new WeakReference<>(componentParams.getActivity());
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Sub.EVENT_EEVEE_OPEN_SUB, this.f52637c);
        XERegister.registerTemplate(new XERegisterModel(ComponentType.COMP_SUG, getNodeEeveeID(), this.f52638d));
    }

    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Sub.EVENT_EEVEE_OPEN_SUB, this.f52637c);
        XERegister.unregisterTemplate(ComponentType.COMP_SUG);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo128997a(SugParams sugParams) {
        Context context;
        PageFragment pageFragment;
        Activity activity = (Activity) this.f52635a.get();
        if (activity == null) {
            if (getNodeParent() != null && getNodeParent().getNodeManager() != null && getNodeParent().getNodeManager().getHostPage() != null) {
                Page hostPage = getNodeParent().getNodeManager().getHostPage();
                if ((hostPage instanceof Fragment) && (pageFragment = (PageFragment) hostPage) != null && pageFragment.getActivity() != null) {
                    activity = pageFragment.getActivity();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        if (this.mContext != null) {
            context = this.mContext;
        } else {
            context = activity.getApplicationContext();
        }
        try {
            NewAddressApiFactory.createDidiAddress(context).startSugActivity(activity, sugParams, new ESugPresenter$3(this));
        } catch (AddressException e) {
            e.printStackTrace();
        }
    }
}
