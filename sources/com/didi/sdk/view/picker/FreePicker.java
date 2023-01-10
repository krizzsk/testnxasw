package com.didi.sdk.view.picker;

import android.view.View;
import android.widget.FrameLayout;
import com.didi.sdk.view.picker.IPickerData;
import com.taxis99.R;
import java.util.List;

public class FreePicker<T extends IPickerData> extends C14068a<T> {

    /* renamed from: a */
    private FrameLayout f40711a;

    /* renamed from: b */
    private FrameLayout f40712b;

    /* renamed from: c */
    private View f40713c;

    /* renamed from: d */
    private View f40714d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.picker_free;
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(int[] iArr) {
        super.setInitialSelect(iArr);
    }

    public /* bridge */ /* synthetic */ void setInitialSelect(IPickerData[] iPickerDataArr) {
        super.setInitialSelect((T[]) iPickerDataArr);
    }

    public /* bridge */ /* synthetic */ void setPickerData(List list) {
        super.setPickerData(list);
    }

    public /* bridge */ /* synthetic */ void setPickerData(IPickerDataInject[] iPickerDataInjectArr) {
        super.setPickerData((IPickerDataInject<T>[]) iPickerDataInjectArr);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        this.f40711a = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_top);
        this.f40712b = (FrameLayout) this.mRootView.findViewById(R.id.time_picker_bottom);
        View view = this.f40713c;
        if (view != null) {
            this.f40711a.addView(view);
        }
        View view2 = this.f40714d;
        if (view2 != null) {
            this.f40712b.addView(view2);
        }
        ((FrameLayout) this.mRootView.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    public void setHeadView(View view) {
        this.f40713c = view;
    }

    public void setBottomView(View view) {
        this.f40714d = view;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f40711a.removeAllViews();
        this.f40712b.removeAllViews();
    }
}
