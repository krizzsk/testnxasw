package com.didi.component.service.activity.rgltaxiguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.AbsNormalFragment;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class RegularTaxiGuideFragment extends AbsNormalFragment implements IRegularTaxiGuideView {

    /* renamed from: a */
    private RegularTaxiGuidePresenter f17545a;

    /* renamed from: b */
    private CommonTitleBar f17546b;

    /* renamed from: c */
    private View f17547c;

    /* renamed from: d */
    private ViewGroup f17548d;

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public PresenterGroup onCreateTopPresenter() {
        RegularTaxiGuidePresenter regularTaxiGuidePresenter = new RegularTaxiGuidePresenter(getContext(), getArguments());
        this.f17545a = regularTaxiGuidePresenter;
        return regularTaxiGuidePresenter;
    }

    /* access modifiers changed from: protected */
    public View onCreateViewImpl(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.global_regular_taxi_guide_fragment, viewGroup, false);
        this.f17548d = viewGroup2;
        m14872a(viewGroup2);
        FormStore.getInstance().setSkipEstimateGet(true);
        return this.f17548d;
    }

    /* renamed from: a */
    private void m14872a(ViewGroup viewGroup) {
        m14873b(viewGroup);
        View findViewById = viewGroup.findViewById(R.id.oc_confirm_btn);
        this.f17547c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RegularTaxiGuideFragment.this.finishWithResultOk();
            }
        });
    }

    /* renamed from: b */
    private void m14873b(ViewGroup viewGroup) {
        CommonTitleBar commonTitleBar = (CommonTitleBar) viewGroup.findViewById(R.id.oc_title_bar);
        this.f17546b = commonTitleBar;
        commonTitleBar.setTitleBarLineVisible(8);
        this.f17546b.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RegularTaxiGuideFragment.this.finishWithResultCancel();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroyViewImpl() {
        super.onDestroyViewImpl();
        this.f17545a = null;
        this.f17548d = null;
        this.f17547c = null;
        this.f17546b = null;
    }

    public void setTitle(String str) {
        this.f17546b.setTitle(str);
    }

    public void finishWithResultOk() {
        getActivity().setResult(-1);
        getActivity().finish();
    }

    public void finishWithResultCancel() {
        getActivity().setResult(0);
        getActivity().finish();
    }
}
