package com.didi.sdk.sidebar.history.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class CountrySelectDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private List<PopupSelectModel> f40120a;

    /* renamed from: b */
    private String f40121b;

    /* renamed from: c */
    private String f40122c;

    /* renamed from: d */
    private PopupSelectView f40123d;

    /* renamed from: e */
    private PopupSelectView.OnPopupSelectListClickListener f40124e;

    /* renamed from: f */
    private int f40125f = -1;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.country_select_dialog_layout;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        PopupSelectView popupSelectView = (PopupSelectView) this.mRootView.findViewById(R.id.popup_select_recycler_view);
        this.f40123d = popupSelectView;
        popupSelectView.setItems(this.f40120a);
        if (!TextUtils.isEmpty(this.f40121b)) {
            this.f40123d.setTitle(this.f40121b);
        }
        if (!TextUtils.isEmpty(this.f40122c)) {
            this.f40123d.setContent(this.f40122c);
        }
        this.f40123d.setOnPopupSelectListClickListener(this.f40124e);
        int i = this.f40125f;
        if (i >= 0) {
            this.f40123d.setSelectedPosition(i);
        }
    }

    public void setTitle(String str) {
        this.f40121b = str;
    }

    public void setContent(String str) {
        this.f40122c = str;
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f40120a = list;
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f40124e = onPopupSelectListClickListener;
    }

    public void setSelectedPosition(int i) {
        this.f40125f = i;
    }
}
