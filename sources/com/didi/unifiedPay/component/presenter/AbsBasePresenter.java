package com.didi.unifiedPay.component.presenter;

import android.os.Bundle;
import com.didi.unifiedPay.component.view.IView;
import com.didi.unifiedPay.util.LogUtil;

public abstract class AbsBasePresenter<T extends IView> implements IPresenter<T> {
    private static final String TAG = "AbsPaymentPresenter";
    /* access modifiers changed from: protected */
    public T mView;

    public void setIView(T t) {
        this.mView = t;
    }

    public void onPageStart() {
        LogUtil.m35171d(TAG, "onPageStart");
    }

    public void onPageResume() {
        LogUtil.m35171d(TAG, "onPageResume");
    }

    public void onPagePause() {
        LogUtil.m35171d(TAG, "onPagePause");
    }

    public void onPageStop() {
        LogUtil.m35171d(TAG, "onPageStop");
    }

    public void onRemove() {
        LogUtil.m35171d(TAG, "onRemove");
    }

    public void onDateClean() {
        LogUtil.m35171d(TAG, "onDateClean");
    }

    public void onPageShow() {
        LogUtil.m35171d(TAG, "onPageShow");
    }

    public void onPageHide() {
        LogUtil.m35171d(TAG, "onPageHide");
    }

    public void onLeaveHome() {
        LogUtil.m35171d(TAG, "onLeaveHome");
    }

    public void onBackHome(Bundle bundle) {
        LogUtil.m35171d(TAG, "onBackHome");
    }
}
