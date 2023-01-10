package com.didi.soda.business.component.image;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import com.didi.app.nova.support.util.DisplayUtils;

public class GestureDetector {

    /* renamed from: a */
    private static final int f42259a = 800;

    /* renamed from: b */
    private static final int f42260b = 100;

    /* renamed from: c */
    private Vector f42261c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f42262d = false;

    /* renamed from: e */
    private boolean f42263e = false;

    /* renamed from: f */
    private Handler f42264f = new Handler();

    /* renamed from: g */
    private Context f42265g;

    /* renamed from: h */
    private OnGestureListener f42266h;

    /* renamed from: i */
    private Runnable f42267i = new Runnable() {
        public void run() {
            boolean unused = GestureDetector.this.f42262d = true;
        }
    };

    public interface OnGestureListener {
        void onClick();

        void onGlide();
    }

    public GestureDetector(Context context, OnGestureListener onGestureListener) {
        this.f42265g = context;
        this.f42266h = onGestureListener;
    }

    public void onMotionEvent(MotionEvent motionEvent, Rect rect) {
        Vector vector;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f42262d = false;
            this.f42263e = false;
            this.f42261c = Vector.creator((int) motionEvent.getX(), (int) motionEvent.getY());
            this.f42264f.postDelayed(this.f42267i, 800);
        } else if (action == 1) {
            this.f42264f.removeCallbacks(this.f42267i);
            Vector creator = Vector.creator((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!this.f42262d && (vector = this.f42261c) != null) {
                Vector subtract = Vector.subtract(creator, vector);
                if (subtract.module() > ((double) DisplayUtils.dip2px(this.f42265g, 100.0f))) {
                    m31769a(subtract);
                }
                if (!this.f42263e && subtract.module() == 0.0d) {
                    m31770a(creator, rect);
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f42264f.removeCallbacks(this.f42267i);
            }
        } else if ((!this.f42263e && motionEvent.getX() != ((float) this.f42261c.f42268x)) || motionEvent.getY() != ((float) this.f42261c.f42269y)) {
            this.f42263e = true;
        }
    }

    /* renamed from: a */
    private void m31769a(Vector vector) {
        OnGestureListener onGestureListener;
        if (vector.f42268x <= vector.f42269y && vector.f42268x >= (-vector.f42269y) && (onGestureListener = this.f42266h) != null) {
            onGestureListener.onGlide();
        }
    }

    /* renamed from: a */
    private void m31770a(Vector vector, Rect rect) {
        OnGestureListener onGestureListener;
        if (rect != null && !m31772b(vector, rect) && (onGestureListener = this.f42266h) != null) {
            onGestureListener.onClick();
        }
    }

    /* renamed from: b */
    private boolean m31772b(Vector vector, Rect rect) {
        return vector.f42268x >= rect.left && vector.f42268x <= rect.right && vector.f42269y >= rect.top && vector.f42269y <= rect.bottom;
    }

    private static class Vector {

        /* renamed from: x */
        int f42268x;

        /* renamed from: y */
        int f42269y;

        private Vector() {
        }

        static Vector creator(int i, int i2) {
            Vector vector = new Vector();
            vector.f42268x = i;
            vector.f42269y = i2;
            return vector;
        }

        static Vector subtract(Vector vector, Vector vector2) {
            Vector vector3 = new Vector();
            vector3.f42268x = vector.f42268x - vector2.f42268x;
            vector3.f42269y = vector.f42269y - vector2.f42269y;
            return vector3;
        }

        /* access modifiers changed from: package-private */
        public double module() {
            int i = this.f42268x;
            int i2 = this.f42269y;
            return Math.sqrt((double) ((i * i) + (i2 * i2)));
        }
    }
}
