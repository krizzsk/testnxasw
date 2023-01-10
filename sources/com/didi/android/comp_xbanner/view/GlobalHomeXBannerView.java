package com.didi.android.comp_xbanner.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.android.comp_xbanner.AbsGlobalXBannerPresenter;
import com.didi.android.comp_xbanner.IGlobalXBannerView;
import com.didi.global.xbanner.view.base.XBannerView;
import com.taxis99.R;

public class GlobalHomeXBannerView implements IGlobalXBannerView {

    /* renamed from: a */
    private View f9960a;

    /* renamed from: b */
    private AbsGlobalXBannerPresenter f9961b;

    /* renamed from: c */
    private XBannerView f9962c;

    public GlobalHomeXBannerView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_home_xbanner_layout, (ViewGroup) null);
        this.f9960a = inflate;
        this.f9962c = (XBannerView) inflate.findViewById(R.id.xbanner);
    }

    public View getView() {
        return this.f9960a;
    }

    public void setPresenter(AbsGlobalXBannerPresenter absGlobalXBannerPresenter) {
        this.f9961b = absGlobalXBannerPresenter;
    }

    public void setTranslationY(int i) {
        View view = this.f9960a;
        if (view != null) {
            view.setTranslationY((float) i);
        }
    }

    public XBannerView getXBannerView() {
        return this.f9962c;
    }
}
