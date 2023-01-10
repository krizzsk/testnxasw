package com.didi.hawaii.p120ar.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.hawaii.ar.view.AutoVerticalScrollTextView */
public class AutoVerticalScrollTextView extends TextSwitcher implements ViewSwitcher.ViewFactory {

    /* renamed from: a */
    int f25643a;

    /* renamed from: b */
    int f25644b;

    /* renamed from: c */
    int f25645c;

    /* renamed from: d */
    private Context f25646d;

    /* renamed from: e */
    private Rotate3dAnimation f25647e;

    /* renamed from: f */
    private Rotate3dAnimation f25648f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<String> f25649g;

    /* renamed from: h */
    private float f25650h;

    /* renamed from: i */
    private int f25651i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Handler f25652j;

    public AutoVerticalScrollTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AutoVerticalScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25649g = new ArrayList();
        this.f25650h = 13.0f;
        this.f25651i = Color.parseColor("#4BDAFF");
        this.f25652j = new Handler(Looper.getMainLooper());
        this.f25643a = 0;
        this.f25644b = 0;
        this.f25645c = 0;
        this.f25646d = context;
        m20402a();
    }

    /* renamed from: a */
    private void m20402a() {
        setFactory(this);
        this.f25647e = m20400a(true, true);
        this.f25648f = m20400a(false, true);
        setInAnimation(this.f25647e);
        setOutAnimation(this.f25648f);
    }

    /* renamed from: a */
    private Rotate3dAnimation m20400a(boolean z, boolean z2) {
        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(z, z2);
        rotate3dAnimation.setDuration(600);
        rotate3dAnimation.setFillAfter(false);
        rotate3dAnimation.setInterpolator(new AccelerateInterpolator());
        return rotate3dAnimation;
    }

    public View makeView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        TextView textView = new TextView(this.f25646d);
        textView.setTextSize(1, this.f25650h);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setTextColor(this.f25651i);
        textView.setBackground(getResources().getDrawable(R.drawable.tips_selector));
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getCurrentView().getMeasuredWidth(), getCurrentView().getMeasuredHeight());
        this.f25643a = getCurrentView().getMeasuredWidth();
    }

    public void next() {
        Animation inAnimation = getInAnimation();
        Rotate3dAnimation rotate3dAnimation = this.f25647e;
        if (inAnimation != rotate3dAnimation) {
            setInAnimation(rotate3dAnimation);
        }
        Animation outAnimation = getOutAnimation();
        Rotate3dAnimation rotate3dAnimation2 = this.f25648f;
        if (outAnimation != rotate3dAnimation2) {
            setOutAnimation(rotate3dAnimation2);
        }
    }

    public void setDataList(List<String> list) {
        this.f25649g = new ArrayList(list);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (8 == i) {
            this.f25652j.removeCallbacksAndMessages((Object) null);
        } else if (i == 0) {
            m20404b();
        }
    }

    /* renamed from: b */
    private void m20404b() {
        List<String> list = this.f25649g;
        if (list == null) {
            return;
        }
        if (list.size() > 1) {
            this.f25652j.post(new Runnable() {
                public void run() {
                    AutoVerticalScrollTextView autoVerticalScrollTextView = AutoVerticalScrollTextView.this;
                    autoVerticalScrollTextView.f25644b = autoVerticalScrollTextView.f25645c % AutoVerticalScrollTextView.this.f25649g.size();
                    AutoVerticalScrollTextView.this.f25645c++;
                    final ViewParent parent = AutoVerticalScrollTextView.this.getParent();
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                    View view = (View) parent;
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth = view.getMeasuredWidth();
                    AutoVerticalScrollTextView.this.setText((String) AutoVerticalScrollTextView.this.f25649g.get(AutoVerticalScrollTextView.this.f25644b));
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    int measuredWidth2 = view.getMeasuredWidth();
                    if (parent instanceof LinearLayout) {
                        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{measuredWidth, measuredWidth2});
                        ofInt.setDuration(500);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                ((View) parent).getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                                parent.requestLayout();
                            }
                        });
                        ofInt.addListener(new Animator.AnimatorListener() {
                            public void onAnimationCancel(Animator animator) {
                            }

                            public void onAnimationEnd(Animator animator) {
                            }

                            public void onAnimationRepeat(Animator animator) {
                            }

                            public void onAnimationStart(Animator animator) {
                            }
                        });
                        ofInt.start();
                    }
                    AutoVerticalScrollTextView.this.f25652j.postDelayed(this, 3000);
                }
            });
        } else if (this.f25649g.size() == 1) {
            setText(this.f25649g.get(0));
        }
    }

    /* renamed from: com.didi.hawaii.ar.view.AutoVerticalScrollTextView$Rotate3dAnimation */
    private class Rotate3dAnimation extends Animation {
        private Camera mCamera;
        private float mCenterX;
        private float mCenterY;
        private final boolean mTurnIn;
        private final boolean mTurnUp;

        Rotate3dAnimation(boolean z, boolean z2) {
            this.mTurnIn = z;
            this.mTurnUp = z2;
        }

        public void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.mCamera = new Camera();
            this.mCenterY = (float) AutoVerticalScrollTextView.this.getHeight();
            this.mCenterX = (float) AutoVerticalScrollTextView.this.getWidth();
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            int i = this.mTurnUp ? 1 : -1;
            Matrix matrix = transformation.getMatrix();
            if (this.mTurnIn) {
                matrix.postTranslate(0.0f, ((float) (-i)) * this.mCenterY * (f - 1.0f));
            } else {
                matrix.postTranslate(0.0f, ((float) (-i)) * this.mCenterY * f);
            }
        }
    }

    /* renamed from: com.didi.hawaii.ar.view.AutoVerticalScrollTextView$ViewAnimFactory */
    private static class ViewAnimFactory {
        private View view;

        private ViewAnimFactory() {
        }

        public void setWidth(int i) {
            this.view.getLayoutParams().width = i;
            this.view.requestLayout();
        }

        public void setView(View view2) {
            this.view = view2;
        }

        public void setHeight(int i) {
            this.view.getLayoutParams().height = i;
        }
    }
}
