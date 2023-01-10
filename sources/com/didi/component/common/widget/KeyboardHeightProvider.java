package com.didi.component.common.widget;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.taxis99.R;

public class KeyboardHeightProvider extends PopupWindow {

    /* renamed from: a */
    private static final String f13858a = "sample_KeyboardHeightProvider";

    /* renamed from: b */
    private KeyboardHeightObserver f13859b;

    /* renamed from: c */
    private int f13860c;

    /* renamed from: d */
    private int f13861d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f13862e;

    /* renamed from: f */
    private View f13863f;

    /* renamed from: g */
    private Activity f13864g;

    public interface KeyboardHeightObserver {
        void onKeyboardHeightChanged(int i, int i2);
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.f13864g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.global_keyboard_height_window, (ViewGroup) null, false);
        this.f13862e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f13863f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f13862e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (KeyboardHeightProvider.this.f13862e != null) {
                    KeyboardHeightProvider.this.m11496b();
                }
            }
        });
    }

    public void start() {
        try {
            if (!isShowing() && this.f13863f.getWindowToken() != null) {
                setBackgroundDrawable(new ColorDrawable(0));
                showAtLocation(this.f13863f, 0, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        this.f13859b = null;
        dismiss();
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        this.f13859b = keyboardHeightObserver;
    }

    /* renamed from: a */
    private int m11493a() {
        return this.f13864g.getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11496b() {
        int i;
        int i2;
        Rect rect = new Rect();
        this.f13862e.getWindowVisibleDisplayFrame(rect);
        int a = m11493a();
        View view = this.f13863f;
        if (view == null || view.getBottom() <= 0) {
            Point point = new Point();
            this.f13864g.getWindowManager().getDefaultDisplay().getSize(point);
            i = point.y;
            i2 = rect.bottom;
        } else {
            i = this.f13863f.getBottom();
            i2 = rect.bottom;
        }
        int i3 = i - i2;
        if (a == 1) {
            if (this.f13861d != i3) {
                this.f13861d = i3;
                m11495a(i3, a);
            }
        } else if (this.f13860c != i3) {
            this.f13860c = i3;
            m11495a(i3, a);
        }
    }

    /* renamed from: a */
    private void m11495a(int i, int i2) {
        KeyboardHeightObserver keyboardHeightObserver = this.f13859b;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i, i2);
        }
    }
}
