package com.didi.unifylogin.utils;

import androidx.fragment.app.FragmentActivity;
import com.didi.unifylogin.base.view.ProgressDialogFragment;

public class LoginProgressDialog {

    /* renamed from: a */
    private static ProgressDialogFragment f47597a;

    public static synchronized void showDialog(FragmentActivity fragmentActivity, String str, boolean z) {
        synchronized (LoginProgressDialog.class) {
            if (fragmentActivity != null) {
                if (f47597a == null) {
                    f47597a = new ProgressDialogFragment();
                }
                if (!f47597a.isAdded()) {
                    try {
                        f47597a.setContent(str, z);
                        f47597a.show(fragmentActivity.getSupportFragmentManager(), (String) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        return;
    }

    public static synchronized void dismissProgressDialogFragmentSafely() {
        synchronized (LoginProgressDialog.class) {
            try {
                if (f47597a != null) {
                    f47597a.dismiss();
                }
                f47597a = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return;
    }
}
