package com.didi.global.globaluikit.drawer;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.taxis99.R;

public class LEGOPopupWindow extends PopupWindow {

    /* renamed from: a */
    private View f24491a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f24492b;

    /* renamed from: c */
    private boolean f24493c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGODrawerDismissListener f24494d;

    public LEGOPopupWindow(View view, int i, int i2, View view2, Context context, boolean z, LEGODrawerDismissListener lEGODrawerDismissListener) {
        super(view, i, i2);
        this.f24491a = view2;
        this.f24492b = context;
        this.f24493c = z;
        this.f24494d = lEGODrawerDismissListener;
    }

    public void dismiss() {
        if (this.f24493c) {
            dismissBySelf();
        }
    }

    public void dismissBySelf() {
        View view = this.f24491a;
        if (view != null) {
            view.startAnimation(AnimationUtils.loadAnimation(this.f24492b, R.anim.lego_drawer_bottom_out));
            this.f24491a.requestLayout();
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                Activity activity = null;
                try {
                    if (LEGOPopupWindow.this.f24492b instanceof Activity) {
                        activity = (Activity) LEGOPopupWindow.this.f24492b;
                    }
                    if (activity == null) {
                        return;
                    }
                    if (!activity.isFinishing()) {
                        LEGOPopupWindow.super.dismiss();
                        if (LEGOPopupWindow.this.f24494d != null) {
                            LEGOPopupWindow.this.f24494d.onDismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 250);
    }

    public void setDismissListener(LEGODrawerDismissListener lEGODrawerDismissListener) {
        this.f24494d = lEGODrawerDismissListener;
    }
}
