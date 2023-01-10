package com.android.didi.safetoolkit.fragment;

import android.text.TextUtils;
import android.view.View;
import com.android.didi.safetoolkit.UIStuff;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public abstract class BaseFragmentWithUIStuff extends BaseFragment implements UIStuff {
    public View getFallbackView() {
        return null;
    }

    public void showPDialog() {
        showPDialog(getString(R.string.progress_hint_text), false);
    }

    public void showPDialog(String str) {
        showPDialog(str, true);
    }

    public void showPDialog(String str, boolean z) {
        if (getActivity() != null && !TextUtils.isEmpty(str)) {
            if (z) {
                showLoading();
            } else {
                showMaskLayerLoading();
            }
        }
    }

    public void closePDialog() {
        hideLoading();
    }

    public boolean isWaitDialogShowing() {
        return isLoading();
    }

    public void showToast(String str) {
        showToast(str, 0);
    }

    public void showToast(int i) {
        showToast(getString(i));
    }

    public void showToast(int i, int i2) {
        showToast(getString(i), i2);
    }

    public void showToast(String str, int i) {
        if (getActivity() != null && !TextUtils.isEmpty(str)) {
            ToastHelper.showShortCompleted(getContext(), str);
        }
    }

    public void onDestroy() {
        closePDialog();
        super.onDestroy();
    }
}
