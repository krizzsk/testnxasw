package com.didi.component.comp_new_xpanel.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.taxis99.R;

public class XpanelLoadingView {

    /* renamed from: a */
    private View f14187a;

    /* renamed from: b */
    private LottieAnimationView f14188b = ((LottieAnimationView) this.f14187a.findViewById(R.id.animation_expect_loading_view));

    /* renamed from: c */
    private TextView f14189c;

    /* renamed from: d */
    private LottieAnimationView f14190d = ((LottieAnimationView) this.f14187a.findViewById(R.id.animation_default_loading_view1));

    /* renamed from: e */
    private LottieAnimationView f14191e = ((LottieAnimationView) this.f14187a.findViewById(R.id.animation_default_loading_view2));

    public XpanelLoadingView(Context context) {
        View inflate = View.inflate(context, R.layout.g_xp_loading, (ViewGroup) null);
        this.f14187a = inflate;
        this.f14189c = (TextView) inflate.findViewById(R.id.title_text);
    }

    public View getView() {
        return this.f14187a;
    }

    public void showDefaultLoading() {
        this.f14187a.setVisibility(0);
        this.f14189c.setVisibility(8);
        this.f14188b.setVisibility(8);
        this.f14190d.setVisibility(0);
        this.f14191e.setVisibility(0);
        this.f14190d.setRepeatCount(-1);
        this.f14190d.playAnimation();
        this.f14191e.setRepeatCount(-1);
        this.f14191e.playAnimation();
    }

    public void showExpectLoading() {
        this.f14187a.setVisibility(0);
        this.f14189c.setVisibility(0);
        this.f14188b.setVisibility(0);
        this.f14190d.setVisibility(8);
        this.f14191e.setVisibility(8);
        this.f14188b.setRepeatCount(-1);
        this.f14188b.playAnimation();
    }

    public void hideLoading() {
        this.f14188b.cancelAnimation();
        this.f14190d.cancelAnimation();
        this.f14191e.cancelAnimation();
    }
}
