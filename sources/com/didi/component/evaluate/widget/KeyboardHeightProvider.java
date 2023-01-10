package com.didi.component.evaluate.widget;

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
    private static final String f15304a = "sample_KeyboardHeightProvider";

    /* renamed from: b */
    private KeyboardHeightObserver f15305b;

    /* renamed from: c */
    private int f15306c;

    /* renamed from: d */
    private int f15307d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f15308e;

    /* renamed from: f */
    private View f15309f;

    /* renamed from: g */
    private Activity f15310g;

    public interface KeyboardHeightObserver {
        void onKeyboardHeightChanged(int i, int i2);
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.f15310g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.global_evaluate_popupwindow, (ViewGroup) null, false);
        this.f15308e = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f15309f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.f15308e.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (KeyboardHeightProvider.this.f15308e != null) {
                    KeyboardHeightProvider.this.m12609b();
                }
            }
        });
    }

    public void start() {
        try {
            if (!isShowing() && this.f15309f.getWindowToken() != null) {
                setBackgroundDrawable(new ColorDrawable(0));
                showAtLocation(this.f15309f, 0, 0, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        this.f15305b = null;
        dismiss();
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        this.f15305b = keyboardHeightObserver;
    }

    /* renamed from: a */
    private int m12606a() {
        return this.f15310g.getResources().getConfiguration().orientation;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12609b() {
        int i;
        int i2;
        Rect rect = new Rect();
        this.f15308e.getWindowVisibleDisplayFrame(rect);
        int a = m12606a();
        View view = this.f15309f;
        if (view == null || view.getBottom() <= 0) {
            Point point = new Point();
            this.f15310g.getWindowManager().getDefaultDisplay().getSize(point);
            i = point.y;
            i2 = rect.bottom;
        } else {
            i = this.f15309f.getBottom();
            i2 = rect.bottom;
        }
        int i3 = i - i2;
        if (a == 1) {
            if (this.f15307d != i3) {
                this.f15307d = i3;
                m12608a(i3, a);
            }
        } else if (this.f15306c != i3) {
            this.f15306c = i3;
            m12608a(i3, a);
        }
    }

    /* renamed from: a */
    private void m12608a(int i, int i2) {
        KeyboardHeightObserver keyboardHeightObserver = this.f15305b;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i, i2);
        }
    }
}
