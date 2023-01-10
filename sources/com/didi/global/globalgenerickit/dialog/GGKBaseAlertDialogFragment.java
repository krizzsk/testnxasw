package com.didi.global.globalgenerickit.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.taxis99.R;

public abstract class GGKBaseAlertDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private GGKDialogFragmentManager f23976a = GGKDialogFragmentManager.getInstance();

    /* access modifiers changed from: protected */
    public abstract View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f23976a.addDialogFragment(this);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f23976a.restoreDialogFragment();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                window.getAttributes().windowAnimations = R.style.common_dialog_anim_style;
            }
        }
        return getRootView(layoutInflater, viewGroup);
    }
}
