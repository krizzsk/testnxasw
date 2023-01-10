package com.didi.rfusion.material.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class RFDescendantOffsetUtils {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f36032a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f36033b = new ThreadLocal<>();

    public static void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f36032a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f36032a.set(matrix);
        } else {
            matrix.reset();
        }
        m27137a(viewGroup, view, matrix);
        RectF rectF = f36033b.get();
        if (rectF == null) {
            rectF = new RectF();
            f36033b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public static void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        offsetDescendantRect(viewGroup, view, rect);
    }

    /* renamed from: a */
    private static void m27137a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m27137a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
