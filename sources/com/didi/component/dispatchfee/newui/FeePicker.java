package com.didi.component.dispatchfee.newui;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;

public class FeePicker<T extends IPickerData> extends FeeBasePicker<T> {

    /* renamed from: a */
    private FrameLayout f14647a;

    /* renamed from: b */
    private FrameLayout f14648b;

    /* renamed from: c */
    private View f14649c;

    /* renamed from: d */
    private View f14650d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_dispatchfee_picker_free;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f14647a = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_top);
        this.f14648b = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_bottom);
        View view = this.f14649c;
        if (view != null) {
            this.f14647a.addView(view);
        }
        View view2 = this.f14650d;
        if (view2 != null) {
            this.f14648b.addView(view2);
        }
        ((FrameLayout) this.mRootView.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    public void setHeadView(View view) {
        this.f14649c = view;
    }

    public void setBottomView(View view) {
        this.f14650d = view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f14647a.removeAllViews();
        this.f14648b.removeAllViews();
    }
}
