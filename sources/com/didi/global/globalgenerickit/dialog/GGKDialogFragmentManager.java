package com.didi.global.globalgenerickit.dialog;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import java.util.ArrayDeque;
import java.util.Iterator;

public class GGKDialogFragmentManager {

    /* renamed from: b */
    private static final GGKDialogFragmentManager f23983b = new GGKDialogFragmentManager();

    /* renamed from: a */
    private ArrayDeque<DialogFragment> f23984a;

    private GGKDialogFragmentManager() {
    }

    public static GGKDialogFragmentManager getInstance() {
        return f23983b;
    }

    public void addDialogFragment(GGKBaseAlertDialogFragment gGKBaseAlertDialogFragment) {
        DialogFragment peek;
        Dialog dialog;
        if (this.f23984a == null) {
            this.f23984a = new ArrayDeque<>();
        }
        if (!(this.f23984a.size() <= 0 || (peek = this.f23984a.peek()) == null || (dialog = peek.getDialog()) == null || dialog.getWindow() == null)) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        }
        this.f23984a.push(gGKBaseAlertDialogFragment);
    }

    public void restoreDialogFragment() {
        DialogFragment peek;
        Dialog dialog;
        ArrayDeque<DialogFragment> arrayDeque = this.f23984a;
        if (arrayDeque != null && arrayDeque.size() != 0) {
            this.f23984a.pop();
            if (this.f23984a.size() > 0 && (peek = this.f23984a.peek()) != null && (dialog = peek.getDialog()) != null && dialog.getWindow() != null) {
                Window window = dialog.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = 1.0f;
                window.setAttributes(attributes);
            }
        }
    }

    public void dismissAllGGKDialog() {
        ArrayDeque<DialogFragment> arrayDeque = this.f23984a;
        if (arrayDeque != null && arrayDeque.size() > 0) {
            Iterator<DialogFragment> it = this.f23984a.iterator();
            while (it.hasNext()) {
                it.next().dismiss();
            }
        }
    }
}
