package com.didi.safetoolkit.dialog;

import android.os.Build;
import androidx.fragment.app.FragmentActivity;

public class LoadingProgressDialog {

    /* renamed from: a */
    private static DiDiLoadingDialog f37282a;

    /* renamed from: a */
    private static boolean m28107a(FragmentActivity fragmentActivity) {
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
            if (f37282a == null) {
                f37282a = new DiDiLoadingDialog(fragmentActivity);
            }
            f37282a.showLoadingDialog(z, str);
        }
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (LoadingProgressDialog.class) {
            if (f37282a != null) {
                f37282a.removeLoadingDialog();
                f37282a = null;
            }
        }
    }
}
