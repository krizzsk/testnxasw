package com.didi.entrega.home.component.abnormal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.mvp.IView;

public class HomeAddressAbnormalView extends IView<HomeAddressAbnormalPresenter> {

    /* renamed from: a */
    private HomeNoAddressView f22489a;

    /* renamed from: b */
    private ViewGroup f22490b;

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f22490b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(this.f22490b);
        return this.f22490b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66659a() {
        if (this.f22489a == null) {
            HomeNoAddressView homeNoAddressView = new HomeNoAddressView(getContext());
            this.f22489a = homeNoAddressView;
            this.f22490b.addView(homeNoAddressView);
        }
        this.f22489a.showAbnormal();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66660b() {
        this.f22490b.removeAllViews();
        this.f22489a = null;
    }
}
