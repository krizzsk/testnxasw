package com.didi.globalsafetoolkit.dialog;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;

public class LoadingProgressDialog {

    /* renamed from: a */
    private static DiDiLoadingDialog f25172a;

    /* renamed from: a */
    private static boolean m20120a(FragmentActivity fragmentActivity) {
        if (Build.VERSION.SDK_INT <= 17) {
            return !fragmentActivity.isFinishing();
        }
        if (fragmentActivity.isFinishing() || fragmentActivity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        synchronized (LoadingProgressDialog.class) {
            dismissProgressDialogFragmentSafely();
            if (f25172a == null) {
                f25172a = new DiDiLoadingDialog(fragmentActivity);
            }
            f25172a.showLoadingDialog(z, str);
        }
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (LoadingProgressDialog.class) {
            if (f25172a != null) {
                f25172a.removeLoadingDialog();
                f25172a = null;
            }
        }
    }
}
