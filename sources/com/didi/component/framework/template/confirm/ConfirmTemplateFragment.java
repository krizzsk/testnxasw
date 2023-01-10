package com.didi.component.framework.template.confirm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.observer.ConfirmAddressListener;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.confirmupdateaddress.ConfirmUpdateAddressComponent;
import com.didi.component.confirmupdateaddress.view.ConfirmUpdateAddressView;
import com.didi.component.framework.template.common.CommonTemplateFragment;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.component.mapflow.MapFlowComponent;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.util.AppUtils;
import com.taxis99.R;

public class ConfirmTemplateFragment extends CommonTemplateFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ConfirmUpdateAddressComponent f15806a;

    /* renamed from: b */
    private ViewGroup f15807b;

    /* renamed from: c */
    private final ConfirmAddressListener f15808c = new ConfirmAddressListener() {
        public void updateAlpha(float f) {
            if (ConfirmTemplateFragment.this.mTitleBackBtn != null) {
                if (ConfirmTemplateFragment.this.mTitleBackBtn.getAlpha() != f) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setAlpha(f);
                }
                int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i == 0 && ConfirmTemplateFragment.this.mTitleBackBtn.getVisibility() != 8) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setVisibility(8);
                }
                if (i > 0 && ConfirmTemplateFragment.this.mTitleBackBtn.getVisibility() != 0) {
                    ConfirmTemplateFragment.this.mTitleBackBtn.setVisibility(0);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public int currentPageId() {
        return 1030;
    }

    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 2;
    }

    public int getRootLayout() {
        return R.layout.global_fragment_confirm_new;
    }

    /* access modifiers changed from: protected */
    public void initComponents(RelativeLayout relativeLayout) {
        inflateViewlessComponents(ComponentType.PAGE_DATA);
        inflateViewlessComponent(ComponentType.GLOBAL_XENGINE, (Bundle) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, UiUtils.dip2px(getContext(), -5.0f), UiUtils.dip2px(getContext(), -10.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        inflateComponent(ComponentType.RESET_LOCATION, relativeLayout, layoutParams);
        Bundle bundle = new Bundle();
        bundle.putInt(MapFlowComponent.SUG_PAGE_CONTAINER_ID, R.id.rl_global_common_sug_container);
        inflateViewlessComponents("service", "deeplink");
        inflateViewlessComponent("map_flow", bundle);
        inflateComponent(ComponentType.BUBBLE_LAYOUT, relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(UIUtils.dip2pxInt(getContext(), 50.0f), AppUtils.getStatusBarHeight(getContext()), -20, 0);
        layoutParams2.addRule(10);
        this.f15806a = (ConfirmUpdateAddressComponent) inflateComponent(ComponentType.CONFIRM_UPDATE_ADDRESS, relativeLayout, layoutParams2);
        GLog.m11354d("lxslxs", "inflate XEngine");
        inflateViewlessComponent("config", (Bundle) null);
        inflateViewlessComponent(ComponentType.SUBSTITUTE_CALL, (Bundle) null);
        inflateComponent(ComponentType.SELECT_SEAT, relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        inflateViewlessComponent(ComponentType.PRE_ORDER_INTERCEPT_EXPO, (Bundle) null);
        inflateViewlessComponent(ComponentType.OFFER_FLEX_PRICE, (Bundle) null);
        if (PageCompDataTransfer.getInstance().getConfirmListener() != null) {
            PageCompDataTransfer.getInstance().getConfirmListener().addConfirmAddressObserver(this.f15808c);
        }
    }

    public View getFallbackView() {
        return this.f15807b;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).setLoadingGravity(48).setMaskBackgroundColor(Color.parseColor("#6625262D")).setWithMaskLayer(true).build();
    }

    public void showLoading() {
        m13086a(true);
        super.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        m13086a(true);
        super.showLoading(loadingConfig);
    }

    public void showMaskLayerLoading() {
        m13086a(true);
        super.showMaskLayerLoading();
    }

    public void hideLoading() {
        m13086a(false);
        super.hideLoading();
    }

    /* renamed from: a */
    private void m13086a(boolean z) {
        ViewGroup viewGroup = this.f15807b;
        if (viewGroup != null) {
            if (z) {
                viewGroup.setVisibility(0);
                this.f15807b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                    }
                });
                return;
            }
            viewGroup.setVisibility(8);
            this.f15807b.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r13) {
        /*
            r12 = this;
            super.onCreate(r13)
            android.os.Bundle r13 = r12.getArguments()
            if (r13 == 0) goto L_0x00d0
            java.lang.String r0 = "estimateParams"
            java.io.Serializable r13 = r13.getSerializable(r0)
            if (r13 == 0) goto L_0x00d0
            boolean r0 = r13 instanceof com.didiglobal.p205sa.biz.estimate.EstimateParams
            if (r0 == 0) goto L_0x00d0
            com.didiglobal.sa.biz.estimate.EstimateParams r13 = (com.didiglobal.p205sa.biz.estimate.EstimateParams) r13
            if (r13 == 0) goto L_0x00ca
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.didi.sdk.address.address.entity.Address r1 = r13.getStartAddress()
            com.didi.sdk.address.address.entity.Address r2 = r13.getEndAddress()
            java.util.List r3 = r13.getmWayPointAddressList()
            r4 = -1
            r5 = 0
            r7 = 1
            r8 = 0
            if (r1 == 0) goto L_0x006b
            com.didi.component.business.data.form.FormStore r9 = com.didi.component.business.data.form.FormStore.getInstance()
            r9.setStartAddress(r1)
            com.didi.sdk.logging.Logger r9 = r12.mLogger
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.String r11 = r1.displayName
            r10[r8] = r11
            java.lang.String r11 = "estimateParams---start_Confirm"
            r9.info((java.lang.String) r11, (java.lang.Object[]) r10)
            int r9 = r1.cityId
            if (r9 == 0) goto L_0x0059
            int r9 = r1.cityId
            if (r9 == r4) goto L_0x0059
            double r9 = r1.latitude
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 == 0) goto L_0x0059
            double r9 = r1.longitude
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 != 0) goto L_0x006b
        L_0x0059:
            com.didi.sdk.logging.Logger r9 = r12.mLogger
            java.lang.Object[] r10 = new java.lang.Object[r8]
            java.lang.String r11 = "sa enter startAddress cityid or latlng error "
            r9.info((java.lang.String) r11, (java.lang.Object[]) r10)
            java.lang.String r1 = r1.searchId
            java.lang.String r9 = "start_search_id"
            r0.put(r9, r1)
            r1 = 1
            goto L_0x006c
        L_0x006b:
            r1 = 0
        L_0x006c:
            if (r2 == 0) goto L_0x00a7
            com.didi.component.business.data.form.FormStore r9 = com.didi.component.business.data.form.FormStore.getInstance()
            r9.setEndAddress(r2)
            com.didi.sdk.logging.Logger r9 = r12.mLogger
            java.lang.Object[] r10 = new java.lang.Object[r7]
            java.lang.String r11 = r2.displayName
            r10[r8] = r11
            java.lang.String r11 = "estimateParams---end_Confirm"
            r9.info((java.lang.String) r11, (java.lang.Object[]) r10)
            int r9 = r2.cityId
            if (r9 == 0) goto L_0x0096
            int r9 = r2.cityId
            if (r9 == r4) goto L_0x0096
            double r9 = r2.latitude
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0096
            double r9 = r2.longitude
            int r4 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00a7
        L_0x0096:
            com.didi.sdk.logging.Logger r1 = r12.mLogger
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.String r5 = "sa enter endAddress cityid or latlng error "
            r1.info((java.lang.String) r5, (java.lang.Object[]) r4)
            java.lang.String r1 = r2.searchId
            java.lang.String r2 = "end_search_id"
            r0.put(r2, r1)
            goto L_0x00a8
        L_0x00a7:
            r7 = r1
        L_0x00a8:
            if (r3 == 0) goto L_0x00b7
            int r1 = r3.size()
            if (r1 <= 0) goto L_0x00b7
            com.didi.component.business.data.form.FormStore r1 = com.didi.component.business.data.form.FormStore.getInstance()
            r1.saveWayPoint(r3)
        L_0x00b7:
            com.didi.component.business.data.form.FormStore r1 = com.didi.component.business.data.form.FormStore.getInstance()
            boolean r13 = r13.isGuessDestination()
            r1.setIsClickGuessDestination(r13)
            if (r7 == 0) goto L_0x00d0
            int r13 = com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.mSceneSaEstimate
            com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.adddressMonitorTrack(r13, r0)
            goto L_0x00d0
        L_0x00ca:
            int r13 = com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.mSceneSaEstimate
            r0 = 0
            com.didiglobal.p205sa.biz.tracker.AddressMonitorTrack.adddressMonitorTrack(r13, r0)
        L_0x00d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.framework.template.confirm.ConfirmTemplateFragment.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
        super.onResumeImpl();
    }

    /* access modifiers changed from: protected */
    public void onPauseImpl() {
        super.onPauseImpl();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        int statusBarHeight = AppUtils.getStatusBarHeight(getContext());
        ViewGroup.LayoutParams layoutParams = this.mTitleBackBtn.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = statusBarHeight;
            this.mTitleBackBtn.setLayoutParams(layoutParams);
        }
        ViewGroup viewGroup = (ViewGroup) this.mRootView.findViewById(R.id.common_loading_layout);
        this.f15807b = viewGroup;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams2.topMargin = statusBarHeight;
        this.f15807b.setLayoutParams(layoutParams2);
    }

    /* access modifiers changed from: protected */
    public void updatePaddingTop() {
        this.mCompContainer.post(new Runnable() {
            public void run() {
                if (!ConfirmTemplateFragment.this.isDestroyed() && ConfirmTemplateFragment.this.f15806a != null) {
                    ConfirmUpdateAddressView confirmUpdateAddressView = (ConfirmUpdateAddressView) ConfirmTemplateFragment.this.f15806a.getView();
                    int bestViewTopPadding = confirmUpdateAddressView.getBestViewTopPadding();
                    GLog.m11353d("updatePaddingRunnable>>>mPaddingTop:" + bestViewTopPadding);
                    if (bestViewTopPadding == 0) {
                        confirmUpdateAddressView.sendGetBestViewTopPaddingEvent();
                    } else if (ConfirmTemplateFragment.this.mTopPresenter != null) {
                        ((CommonTemplatePresenter) ConfirmTemplateFragment.this.mTopPresenter).onPaddingTopChanged(bestViewTopPadding);
                    }
                }
            }
        });
    }
}
