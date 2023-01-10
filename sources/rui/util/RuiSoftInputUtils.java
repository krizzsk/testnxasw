package rui.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class RuiSoftInputUtils {

    /* renamed from: a */
    private static InputMethodManager f8661a;

    public static void showSoftInputForced(EditText editText) {
        if (f8661a == null) {
            f8661a = (InputMethodManager) editText.getContext().getSystemService("input_method");
        }
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        f8661a.showSoftInput(editText, 2);
    }

    public static boolean hideSoftInputForced(Activity activity, View view) {
        if (!isSoftInputVisible(activity)) {
            return false;
        }
        if (f8661a == null) {
            f8661a = (InputMethodManager) activity.getSystemService("input_method");
        }
        view.clearFocus();
        return f8661a.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean hideSoftInput(View view) {
        if (view == null) {
            return false;
        }
        if (f8661a == null) {
            f8661a = (InputMethodManager) view.getContext().getSystemService("input_method");
        }
        return f8661a.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean hideSoftInput(Activity activity) {
        if (activity == null || activity.getCurrentFocus() == null) {
            return false;
        }
        if (f8661a == null) {
            f8661a = (InputMethodManager) activity.getSystemService("input_method");
        }
        return f8661a.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static boolean isSoftInputVisible(Activity activity) {
        return isSoftInputVisible(activity, 200);
    }

    public static boolean isSoftInputVisible(Activity activity, int i) {
        return m7247a(activity) >= i;
    }

    public static int getSoftInputHeight(Activity activity) {
        Rect rect = new Rect();
        View decorView = activity.getWindow().getDecorView();
        decorView.getWindowVisibleDisplayFrame(rect);
        return decorView.getHeight() - (rect.bottom - rect.top);
    }

    /* renamed from: a */
    private static int m7247a(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        return findViewById.getRootView().getHeight() - rect.height();
    }
}
