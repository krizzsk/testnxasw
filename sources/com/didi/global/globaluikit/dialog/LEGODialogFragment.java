package com.didi.global.globaluikit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LEGODialogFragment extends LEGOBaseAlertDialogFragment {

    /* renamed from: a */
    private LEGORealUsedModel f24402a;

    public static LEGODialogFragment newInstance(LEGOBaseDialogModel lEGOBaseDialogModel) {
        LEGODialogFragment lEGODialogFragment = new LEGODialogFragment();
        if (lEGOBaseDialogModel != null) {
            lEGODialogFragment.f24402a = lEGOBaseDialogModel.convert();
        }
        return lEGODialogFragment;
    }

    public static LEGODialogFragment newInstance(LEGORealUsedModel lEGORealUsedModel) {
        LEGODialogFragment lEGODialogFragment = new LEGODialogFragment();
        lEGODialogFragment.f24402a = lEGORealUsedModel;
        return lEGODialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f24402a == null) {
            return null;
        }
        return new C9243a(getContext(), this.f24402a).mo72139a();
    }
}
