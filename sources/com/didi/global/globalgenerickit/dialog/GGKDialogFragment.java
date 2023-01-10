package com.didi.global.globalgenerickit.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GGKDialogFragment extends GGKBaseAlertDialogFragment {

    /* renamed from: a */
    private GGKBaseDialogModel f23982a;

    public static GGKDialogFragment newInstance(GGKBaseDialogModel gGKBaseDialogModel) {
        GGKDialogFragment gGKDialogFragment = new GGKDialogFragment();
        gGKDialogFragment.f23982a = gGKBaseDialogModel;
        return gGKDialogFragment;
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f23982a == null) {
            return null;
        }
        return new C9177a(getContext(), this.f23982a.mo71738a()).mo71774a();
    }
}
