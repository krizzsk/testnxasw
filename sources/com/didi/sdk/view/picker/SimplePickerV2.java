package com.didi.sdk.view.picker;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.picker.IPickerData;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.taxis99.R;
import java.util.List;

public class SimplePickerV2<T extends IPickerData> extends PickerBaseTree<T> {

    /* renamed from: a */
    private CommonPopupTitleBar f40832a;

    /* renamed from: b */
    private CharSequence f40833b;

    /* renamed from: c */
    private String f40834c;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.picker_local_global;
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

    /* access modifiers changed from: protected */
    public void initView() {
        super.initView();
        m30619a(this.mRootView);
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f40832a;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f40833b = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f40832a == null || TextUtils.isEmpty(str)) {
            this.f40834c = str;
        } else {
            this.f40832a.setMessage(str);
        }
    }

    /* renamed from: a */
    private void m30619a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.dismiss();
            }
        });
        this.f40832a = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        TextView textView = (TextView) view.findViewById(R.id.title_bar2);
        View findViewById = view.findViewById(R.id.rl_root);
        View findViewById2 = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f40833b;
        if (charSequence != null) {
            this.f40832a.setTitle(charSequence.toString());
            textView.setText(this.f40833b.toString());
        }
        if (!TextUtils.isEmpty(this.f40834c)) {
            this.f40832a.setMessage(this.f40834c);
        }
        this.f40832a.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.m30618a();
            }
        });
        this.f40832a.setVisibility(8);
        ((TextView) view.findViewById(R.id.tv_confirm2)).setVisibility(0);
        findViewById2.setVisibility(0);
        findViewById.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.m30618a();
            }
        });
        this.f40832a.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SimplePickerV2.this.dismiss();
            }
        });
        ((FrameLayout) view.findViewById(R.id.time_picker)).addView(this.mPickerLayout);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30618a() {
        confirmSelectAndCallback();
        dismiss();
    }
}
