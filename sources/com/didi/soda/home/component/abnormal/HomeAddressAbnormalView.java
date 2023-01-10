package com.didi.soda.home.component.abnormal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.soda.home.widget.HomeNoAddressView;

public class HomeAddressAbnormalView extends IView<HomeAddressAbnormalPresenter> {

    /* renamed from: a */
    private HomeNoAddressView f45033a;

    /* renamed from: b */
    private ViewGroup f45034b;

    public void showAbnormal(boolean z) {
        if (this.f45033a == null) {
            HomeNoAddressView homeNoAddressView = new HomeNoAddressView(getContext());
            this.f45033a = homeNoAddressView;
            this.f45034b.addView(homeNoAddressView);
        }
        this.f45033a.showAbnormal(z);
    }

    public void hideAbnormal() {
        this.f45034b.removeAllViews();
        this.f45033a = null;
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f45034b = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        viewGroup.addView(this.f45034b);
        return this.f45034b;
    }
}
