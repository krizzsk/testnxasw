package com.didi.soda.goodsV2.component.multilevel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.soda.goodsV2.component.multilevel.Contract;
import com.taxis99.R;

/* renamed from: com.didi.soda.goodsV2.component.multilevel.b */
/* compiled from: MultiLevelView */
class C14705b extends Contract.AbsMultiLevelView {

    /* renamed from: a */
    private ViewTreeObserver.OnGlobalLayoutListener f44936a;

    C14705b() {
    }

    public void onCreate() {
        super.onCreate();
        this.mBottomButton.changeAddButtonText(getString(R.string.customer_dialog_confirm));
        this.mShadowConstrain.setVisibility(0);
        this.f44936a = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                C14705b.this.m33304a();
            }
        };
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f44936a);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m33304a() {
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f44936a);
        this.mSmoothScroller.setOffset(this.mTitleView.getBottom());
        this.mTitleView.setBackgroundColor(-1);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_goods_purchase_v2, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f44936a);
    }
}
