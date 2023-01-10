package com.didi.dimina.container.p065ui.custom.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.ViewUtil;

/* renamed from: com.didi.dimina.container.ui.custom.input.InputUtil */
class InputUtil {

    /* renamed from: a */
    public int f19402a = 0;

    /* renamed from: b */
    public boolean f19403b = false;

    /* renamed from: c */
    public boolean f19404c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f19405d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ISoftInputChanged f19406e;

    /* renamed from: f */
    private final View.OnLayoutChangeListener f19407f = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int navigationBarHeight = ViewUtil.getNavigationBarHeight(InputUtil.this.f19405d.getContext());
            int height = InputUtil.this.f19405d.getHeight();
            Rect rect = new Rect();
            InputUtil.this.f19405d.getWindowVisibleDisplayFrame(rect);
            LogUtil.m16838d("attachSoftInput", rect.bottom + "--" + height + "--" + navigationBarHeight);
            int i9 = height - navigationBarHeight;
            boolean z = true;
            int i10 = 0;
            if (i9 > rect.bottom) {
                int i11 = i9 - rect.bottom;
                if (InputUtil.this.f19402a != i11) {
                    InputUtil.this.f19403b = true;
                    InputUtil.this.f19402a = i11;
                } else {
                    InputUtil.this.f19403b = false;
                }
                i10 = i11;
            } else {
                z = false;
            }
            LogUtil.m16838d("attachSoftInput", i10 + "--" + InputUtil.this.f19405d.getHeight() + "---" + rect.bottom);
            if (InputUtil.this.f19404c != z || (z && InputUtil.this.f19403b)) {
                if (InputUtil.this.f19406e != null) {
                    InputUtil.this.f19406e.onChanged(z, i10, rect.bottom);
                }
                InputUtil.this.f19404c = z;
            }
        }
    };

    /* renamed from: com.didi.dimina.container.ui.custom.input.InputUtil$ISoftInputChanged */
    public interface ISoftInputChanged {
        void onChanged(boolean z, int i, int i2);
    }

    InputUtil() {
    }

    /* renamed from: a */
    public void mo61201a(View view) {
        view.getRootView().removeOnLayoutChangeListener(this.f19407f);
    }

    /* renamed from: a */
    public void mo61202a(View view, ISoftInputChanged iSoftInputChanged) {
        this.f19406e = iSoftInputChanged;
        this.f19405d = view.getRootView();
        StringBuilder sb = new StringBuilder();
        sb.append("rootView:");
        sb.append(this.f19405d != null);
        LogUtil.m16838d("attachSoftInput", sb.toString());
        View view2 = this.f19405d;
        if (view2 != null) {
            view2.addOnLayoutChangeListener(this.f19407f);
        }
    }

    /* renamed from: b */
    public static void m16465b(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && (inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method")) != null) {
            if (!inputMethodManager.isActive(view)) {
                inputMethodManager.showSoftInput(view, 0);
            }
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    /* renamed from: c */
    public static void m16466c(View view) {
        if (view != null) {
            view.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }
    }

    /* renamed from: a */
    public static int m16461a(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* renamed from: b */
    public static int m16463b(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }
}
