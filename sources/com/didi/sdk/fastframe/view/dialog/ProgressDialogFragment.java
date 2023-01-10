package com.didi.sdk.fastframe.view.dialog;

import android.content.DialogInterface;
import android.os.Bundle;

public class ProgressDialogFragment extends com.didi.sdk.view.dialog.ProgressDialogFragment {

    /* renamed from: b */
    private static final String f38691b = "message";

    /* renamed from: a */
    private DialogInterface.OnCancelListener f38692a = null;

    /* renamed from: c */
    private String f38693c;

    public void setContent(String str, boolean z) {
        this.f38693c = str;
        setCancelable(z);
        super.setContent(str, z);
    }

    public void setmCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.f38692a = onCancelListener;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("message", this.f38693c);
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        m29169a(bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m29169a(bundle);
    }

    /* renamed from: a */
    private void m29169a(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("message");
            this.f38693c = string;
            super.setContent(string, isCancelable());
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnCancelListener onCancelListener = this.f38692a;
        if (onCancelListener != null) {
            onCancelListener.onCancel(getDialog());
        }
    }
}
