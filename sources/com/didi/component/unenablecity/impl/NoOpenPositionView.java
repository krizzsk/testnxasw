package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.component.unenablecity.INoOpenPositionView;
import com.taxis99.R;

public class NoOpenPositionView implements INoOpenPositionView {

    /* renamed from: a */
    private AbsUnableCityPresenter f18069a;

    /* renamed from: b */
    private final View f18070b;

    /* renamed from: c */
    private final TextView f18071c;

    /* renamed from: d */
    private final LinearLayout f18072d = ((LinearLayout) this.f18070b.findViewById(R.id.open_sug_ll));

    public NoOpenPositionView(Activity activity, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.global_no_open_position_service_layout, viewGroup);
        this.f18070b = inflate;
        this.f18071c = (TextView) inflate.findViewById(R.id.enable_service_btn);
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f18069a = absUnableCityPresenter;
    }

    public View getView() {
        return this.f18070b;
    }

    public void setNoPositionEnableListener(View.OnClickListener onClickListener) {
        this.f18071c.setOnClickListener(onClickListener);
    }

    public void setNoPositionManualEnterListener(View.OnClickListener onClickListener) {
        this.f18072d.setOnClickListener(onClickListener);
    }
}
