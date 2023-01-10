package com.didi.safetoolkit.business.safeCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISfUriDispatcherServices;
import com.didi.safetoolkit.business.safeCenter.SfSafeCenterAdapter;
import com.didi.safetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.safetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.safetoolkit.business.safeCenter.store.SfCenterStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.taxis99.R;
import java.util.List;

public class SfSafeCenterActivity extends BaseActivityWithUIStuff {

    /* renamed from: a */
    private RecyclerView f37167a;

    /* renamed from: b */
    private SfCommonTitleBar f37168b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfSafeCenterAdapter f37169c;

    /* renamed from: d */
    private SfCenterStore f37170d;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_safe_center_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f37167a = (RecyclerView) findViewById(R.id.center_rv);
        SfCommonTitleBar sfCommonTitleBar = (SfCommonTitleBar) findViewById(R.id.center_title_bar);
        this.f37168b = sfCommonTitleBar;
        sfCommonTitleBar.setTitleText(SfStringGetter.getString(R.string.sf_safety_center));
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        this.f37169c = new SfSafeCenterAdapter();
        this.f37167a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f37167a.setAdapter(this.f37169c);
        this.f37170d = new SfCenterStore();
        this.f37169c.setCardClickListener(new SfSafeCenterAdapter.CardClickListener() {
            public void onClick(SfCenterCardModel sfCenterCardModel) {
                SfSafeCenterActivity.this.m28059a(sfCenterCardModel);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28059a(SfCenterCardModel sfCenterCardModel) {
        if (sfCenterCardModel != null) {
            if (sfCenterCardModel.typeLocal == 1) {
                ISfUriDispatcherServices iSfUriDispatcherServices = (ISfUriDispatcherServices) ServiceLoader.load(ISfUriDispatcherServices.class, SafeToolKit.getIns().getBusinessType()).get();
                if (iSfUriDispatcherServices != null) {
                    iSfUriDispatcherServices.handleUri(this, sfCenterCardModel.url);
                }
            } else if (sfCenterCardModel.typeLocal == 2) {
                SafeToolKit.getIns().startContactsManagerPage(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        C125522 r0 = new SfCenterStore.Callback() {
            public void onSuccess(List<SfCenterCardModel> list) {
                SfSafeCenterActivity.this.closePDialog();
                SfSafeCenterActivity.this.f37169c.setData(list);
            }

            public void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse) {
                SfSafeCenterActivity.this.closePDialog();
                if (sfSafetyCenterResponse != null) {
                    SfSafeCenterActivity.this.showToast(sfSafetyCenterResponse.errmsg);
                }
            }
        };
        showLoading();
        this.f37170d.getLocalData(r0);
        this.f37170d.request(r0);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f37168b.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfSafeCenterActivity.this.onBackPressed();
            }
        });
    }

    public View getFallbackView() {
        return this.f37168b.getLoadingFallback();
    }
}
