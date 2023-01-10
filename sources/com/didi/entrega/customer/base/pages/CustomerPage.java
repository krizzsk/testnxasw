package com.didi.entrega.customer.base.pages;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.ButterKnife;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.entrega.customer.annotation.SupportInnerDialog;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.listener.PageClickableListener;
import com.didi.entrega.router.HubTable;
import com.didi.entrega.router.IHubHandler;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.Response;
import com.taxis99.R;

public abstract class CustomerPage extends Page implements PageClickableListener, IHubHandler {
    public static final String PAGE_NAME = "PageName";

    /* renamed from: a */
    private static final String f21661a = "CustomerPage";

    /* renamed from: b */
    private CustomerPageDelegate f21662b = new CustomerPageDelegate(this, false);

    /* renamed from: c */
    private DialogInstrument f21663c;

    public boolean getTouchIntercept() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isStatusBarLightning() {
        return false;
    }

    public void onInitialize() {
        super.onInitialize();
        this.f21662b.onInitialize(this);
    }

    public String alias() {
        return HubTable.getPageId(getClass());
    }

    public View getPageView() {
        return getView();
    }

    public ControllerChangeHandler getPopHandler() {
        return this.f21662b.mo64605b();
    }

    public ControllerChangeHandler getPushHandler() {
        return this.f21662b.mo64603a();
    }

    public void onCreate(View view) {
        CustomerSystemUtil.setStatusBarBgLightning(isStatusBarLightning());
        this.f21662b.onCreate();
        getScopeContext().attach("PageName", alias());
        getScopeContext().attach("fromPage", alias());
        super.onCreate(view);
    }

    public boolean onHandleBack() {
        RecordTracker.Builder.create().setTag(alias()).setMessage("onHandleBack").setOtherParam("PageName:", alias()).build().info();
        return super.onHandleBack();
    }

    public void onResume() {
        super.onResume();
        this.f21662b.onResume();
    }

    public void onStart() {
        super.onStart();
        this.f21662b.onStart(getView(), getStatusBarHeight());
    }

    public void onStop() {
        super.onStop();
        this.f21662b.onStop();
    }

    public void openRoute(Request request, Response response) {
        this.f21662b.openRoute(request);
    }

    public void setupComponents(View view) {
        ButterKnife.bind((Object) this, view);
        super.setupComponents(view);
        m18099a();
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: a */
    private void m18099a() {
        if (((SupportInnerDialog) getClass().getAnnotation(SupportInnerDialog.class)) != null) {
            ViewGroup viewGroup = (ViewGroup) getView().findViewWithTag(getResources().getString(R.string.entrega_dialog_container_tag));
            if (viewGroup == null) {
                viewGroup = new FrameLayout(getBaseContext());
                viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ((ViewGroup) getView()).addView(viewGroup);
            }
            DialogFrameLayout dialogFrameLayout = new DialogFrameLayout(getBaseContext());
            dialogFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(dialogFrameLayout);
            this.f21663c = new DialogInstrument(dialogFrameLayout);
            if (getScopeContext() != null) {
                getScopeContext().attach("dialog_instrument", this.f21663c);
                getScopeContext().attach("dialog_instrument_frame", dialogFrameLayout);
            }
        }
    }
}
