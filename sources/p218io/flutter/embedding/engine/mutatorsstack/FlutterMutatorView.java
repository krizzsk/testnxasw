package p218io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import p218io.flutter.embedding.android.AndroidTouchProcessor;

/* renamed from: io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView */
public class FlutterMutatorView extends FrameLayout {

    /* renamed from: a */
    ViewTreeObserver.OnGlobalFocusChangeListener f60436a;

    /* renamed from: b */
    private FlutterMutatorsStack f60437b;

    /* renamed from: c */
    private float f60438c;

    /* renamed from: d */
    private int f60439d;

    /* renamed from: e */
    private int f60440e;

    /* renamed from: f */
    private int f60441f;

    /* renamed from: g */
    private int f60442g;

    /* renamed from: h */
    private final AndroidTouchProcessor f60443h;

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public FlutterMutatorView(Context context, float f, AndroidTouchProcessor androidTouchProcessor) {
        super(context, (AttributeSet) null);
        this.f60438c = f;
        this.f60443h = androidTouchProcessor;
    }

    public FlutterMutatorView(Context context) {
        this(context, 1.0f, (AndroidTouchProcessor) null);
    }

    public static boolean childHasFocus(View view) {
        if (view == null) {
            return false;
        }
        if (view.hasFocus()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (childHasFocus(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f60436a == null) {
            C220851 r1 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    View view3 = this;
                    onFocusChangeListener.onFocusChange(view3, FlutterMutatorView.childHasFocus(view3));
                }
            };
            this.f60436a = r1;
            viewTreeObserver.addOnGlobalFocusChangeListener(r1);
        }
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.f60436a) != null) {
            this.f60436a = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public void readyToDisplay(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f60437b = flutterMutatorsStack;
        this.f60439d = i;
        this.f60440e = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f60437b.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset((float) (-this.f60439d), (float) (-this.f60440e));
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f60437b.getFinalMatrix());
        float f = this.f60438c;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate((float) (-this.f60439d), (float) (-this.f60440e));
        return matrix;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f60443h == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i = this.f60439d;
            this.f60441f = i;
            int i2 = this.f60440e;
            this.f60442g = i2;
            matrix.postTranslate((float) i, (float) i2);
        } else if (action != 2) {
            matrix.postTranslate((float) this.f60439d, (float) this.f60440e);
        } else {
            matrix.postTranslate((float) this.f60441f, (float) this.f60442g);
            this.f60441f = this.f60439d;
            this.f60442g = this.f60440e;
        }
        return this.f60443h.onTouchEvent(motionEvent, matrix);
    }
}
