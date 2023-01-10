package com.didichuxing.xpanel.xcard.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class ToastUtils {

    /* renamed from: a */
    View f52211a;

    /* renamed from: b */
    Context f52212b;

    /* renamed from: c */
    private Handler f52213c = new Handler(Looper.getMainLooper());

    public enum Type {
        NONE,
        ERROR,
        LOADING,
        SUCCESS,
        WARN,
        CONFIRM
    }

    public ToastUtils(Context context) {
        this.f52212b = context;
    }

    /* renamed from: a */
    private Hud m39301a(View view, Type type, String str) {
        ObjectAnimator objectAnimator = null;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean z = view instanceof RelativeLayout;
        boolean z2 = view instanceof FrameLayout;
        if (!z && !z2) {
            return null;
        }
        View inflate = ((LayoutInflater) this.f52212b.getSystemService("layout_inflater")).inflate(R.layout.layout_toast_with_icon, (ViewGroup) null);
        this.f52211a = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_img);
        ((TextView) this.f52211a.findViewById(R.id.toast_txt)).setText(str);
        imageView.setImageResource(m39300a(type));
        if (type == Type.LOADING) {
            objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 360.0f});
            objectAnimator.setRepeatMode(1);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setDuration(3000);
            objectAnimator.start();
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            viewGroup.addView(this.f52211a, layoutParams);
        } else if (z2) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            viewGroup.addView(this.f52211a, layoutParams2);
        }
        return new Hud(this.f52211a, objectAnimator);
    }

    public static void dismiss(Hud hud) {
        if (hud.f52214ra != null) {
            hud.f52214ra.cancel();
        }
        removeViewFromParent(hud.dialogView);
    }

    public static void removeViewFromParent(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.setClickable(true);
            viewGroup.removeView(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39302a() {
        View view = this.f52211a;
        if (view != null && view.getParent() != null && (this.f52211a.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f52211a.getParent()).removeView(this.f52211a);
        }
    }

    public Hud loading(View view, String str) {
        view.setClickable(false);
        return m39301a(view, Type.LOADING, str);
    }

    public void toastError(View view, String str) {
        this.f52213c.removeCallbacksAndMessages((Object) null);
        m39302a();
        m39301a(view, Type.ERROR, str);
        this.f52213c.postDelayed(new Runnable() {
            public void run() {
                ToastUtils.this.m39302a();
            }
        }, 1000);
    }

    /* renamed from: a */
    private static int m39300a(Type type) {
        int ordinal = type.ordinal();
        if (ordinal == 1) {
            return R.drawable.toast_icon_warn;
        }
        if (ordinal == 2) {
            return R.drawable.toast_icon_loading;
        }
        if (ordinal != 3) {
            return -1;
        }
        return R.drawable.toast_icon_right;
    }

    public static class Hud {
        public View dialogView;

        /* renamed from: ra */
        public ObjectAnimator f52214ra;

        public Hud(View view, ObjectAnimator objectAnimator) {
            this.dialogView = view;
            this.f52214ra = objectAnimator;
        }
    }
}
