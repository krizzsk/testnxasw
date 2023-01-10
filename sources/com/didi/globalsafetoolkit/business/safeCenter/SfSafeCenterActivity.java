package com.didi.globalsafetoolkit.business.safeCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.business.safeCenter.SfSafeCenterAdapter;
import com.didi.globalsafetoolkit.business.safeCenter.model.SfCenterCardModel;
import com.didi.globalsafetoolkit.business.safeCenter.response.SfSafetyCenterResponse;
import com.didi.globalsafetoolkit.business.safeCenter.store.SfCenterStore;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.didi.globalsafetoolkit.widget.SfCommonTitleBar;
import com.taxis99.R;
import java.util.List;

public class SfSafeCenterActivity extends BaseActivityWithUIStuff {

    /* renamed from: a */
    private RecyclerView f25071a;

    /* renamed from: b */
    private SfCommonTitleBar f25072b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfSafeCenterAdapter f25073c;

    /* renamed from: d */
    private SfCenterStore f25074d;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_safe_center_activity;
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f25071a = (RecyclerView) findViewById(R.id.center_rv);
        SfCommonTitleBar sfCommonTitleBar = (SfCommonTitleBar) findViewById(R.id.center_title_bar);
        this.f25072b = sfCommonTitleBar;
        sfCommonTitleBar.setTitleText(SfStringGetter.getString(R.string.sf_safety_center));
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        this.f25073c = new SfSafeCenterAdapter();
        this.f25071a.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f25071a.setAdapter(this.f25073c);
        this.f25074d = new SfCenterStore();
        this.f25073c.setCardClickListener(new SfSafeCenterAdapter.CardClickListener() {
            public void onClick(SfCenterCardModel sfCenterCardModel) {
                SfSafeCenterActivity.this.m20078a(sfCenterCardModel);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20078a(SfCenterCardModel sfCenterCardModel) {
        if (sfCenterCardModel != null) {
            if (sfCenterCardModel.typeLocal == 1) {
                GlobalSfBusinessInterface.handleUri(this, sfCenterCardModel.url);
            } else if (sfCenterCardModel.typeLocal == 2) {
                GlobalSafeToolKit.getIns().startContactsManagerPage(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        C95192 r0 = new SfCenterStore.Callback() {
            public void onSuccess(List<SfCenterCardModel> list) {
                SfSafeCenterActivity.this.closePDialog();
                SfSafeCenterActivity.this.f25073c.setData(list);
            }

            public void onFailed(SfSafetyCenterResponse sfSafetyCenterResponse) {
                SfSafeCenterActivity.this.closePDialog();
                if (sfSafetyCenterResponse != null) {
                    SfSafeCenterActivity.this.showToast(sfSafetyCenterResponse.errmsg);
                }
            }
        };
        showLoading();
        this.f25074d.getLocalData(r0);
        this.f25074d.request(r0);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f25072b.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfSafeCenterActivity.this.onBackPressed();
            }
        });
    }

    public View getFallbackView() {
        return this.f25072b.getLoadingFallback();
    }
}
