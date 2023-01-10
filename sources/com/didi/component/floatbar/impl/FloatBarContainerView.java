package com.didi.component.floatbar.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.floatbar.AbsFloatBarPresenter;
import com.didi.component.floatbar.IFloatBarContainerView;

public class FloatBarContainerView implements View.OnClickListener, IFloatBarContainerView {

    /* renamed from: a */
    private LinearLayout f15573a;

    /* renamed from: b */
    private AbsFloatBarPresenter f15574b;

    /* renamed from: c */
    private Context f15575c;

    public FloatBarContainerView(Context context, ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f15573a = linearLayout;
        linearLayout.setOrientation(1);
        this.f15573a.setGravity(5);
        this.f15575c = context;
    }

    public View getView() {
        return this.f15573a;
    }

    public void setPresenter(AbsFloatBarPresenter absFloatBarPresenter) {
        this.f15574b = absFloatBarPresenter;
    }

    public void setContentView(View view) {
        this.f15573a.removeAllViews();
        this.f15573a.addView(view);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AbsFloatBarPresenter absFloatBarPresenter = this.f15574b;
        if (absFloatBarPresenter != null) {
            absFloatBarPresenter.onFloatBarClicked();
        }
    }
}
