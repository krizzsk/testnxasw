package com.didi.addressnew.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.didi.addressnew.framework.animator.EaseCubicInterpolator;
import com.didi.common.map.util.DisplayUtils;
import com.didi.passenger.C11267R;
import com.didi.sdk.util.ToastUtil;
import com.taxis99.R;

public class SugViewLayout extends FrameLayout {
    public static final int ENTER_ANIMATION_INTERVAL = 500;

    /* renamed from: a */
    private View f9404a;

    /* renamed from: b */
    private FrameLayout f9405b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnSugViewDragListener f9406c;

    /* renamed from: d */
    private boolean f9407d = false;

    /* renamed from: e */
    private int f9408e;

    /* renamed from: f */
    private int f9409f = 0;

    /* renamed from: g */
    private PointF f9410g = new PointF();

    /* renamed from: h */
    private boolean f9411h = false;

    /* renamed from: i */
    private int f9412i = 0;

    /* renamed from: j */
    private View f9413j;

    /* renamed from: k */
    private boolean f9414k = false;

    /* renamed from: l */
    private int f9415l;

    /* renamed from: m */
    private float f9416m = 0.6f;

    /* renamed from: n */
    private long f9417n = System.currentTimeMillis();

    /* renamed from: o */
    private int f9418o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f9419p = false;

    public interface OnSugViewDragListener {
        void onSugViewIsClose();

        void onSugViewIsReset();

        void onSugViewIsStartMove();

        void onSugViewStartClose();
    }

    public SugViewLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public SugViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public SugViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public int getScreenHeight(Context context) {
        if (context != null) {
            return getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    public void setContentTopMargin(int i) {
        if (i != 0) {
            this.f9408e = i;
        }
        m8190b();
    }

    public void setContentTopMargin(int i, int i2) {
        if (i != 0) {
            this.f9408e = i;
        }
        this.f9412i = i2;
        m8190b();
    }

    /* renamed from: a */
    private void m8181a() {
        View view = this.f9404a;
        if (view instanceof CardView) {
            this.f9418o = (int) ((CardView) view).getRadius();
        }
        this.f9415l += this.f9418o;
    }

    /* renamed from: b */
    private void m8190b() {
        this.f9415l = this.f9412i - this.f9408e;
        m8181a();
    }

    public void setMaxAlpha(float f) {
        this.f9416m = this.f9416m;
    }

    public void init(Context context, AttributeSet attributeSet) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.sugView);
        this.f9408e = (int) obtainStyledAttributes.getDimension(0, (float) DisplayUtils.dp2px(getContext(), 40.0f));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f9405b = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#666666"));
        this.f9405b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f9405b);
        this.f9405b.setAlpha(0.0f);
        this.f9405b.setContentDescription(getContext().getString(R.string.GRider_0111_Return_rDEY));
        this.f9405b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugViewLayout.this.m8192b(view);
            }
        });
        this.f9404a = View.inflate(context, obtainStyledAttributes.getResourceId(1, R.layout.view_sug_content), (ViewGroup) null);
        addView(this.f9404a, new FrameLayout.LayoutParams(-1, -2));
        View findViewById = this.f9404a.findViewById(R.id.sugPageDragHandle);
        this.f9413j = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SugViewLayout.this.m8183a(view);
            }
        });
        obtainStyledAttributes.recycle();
        this.f9412i = getScreenHeight(getContext());
        m8190b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m8192b(View view) {
        if (this.f9407d && this.f9419p && System.currentTimeMillis() - this.f9417n > 500) {
            startPullAnim();
            this.f9417n = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8183a(View view) {
        if (System.currentTimeMillis() - this.f9417n > 500) {
            startPullAnim();
            this.f9417n = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        try {
            if (getChildCount() == 0) {
                ToastUtil.show(getContext(), (CharSequence) "当前控件必须添加一个contentView 才能使用");
                throw new Exception("当前控件必须添加一个contentView 才能使用");
            } else if (getChildCount() > 3) {
                ToastUtil.show(getContext(), (CharSequence) "当前控件只支持添加一个contentView");
                throw new Exception("当前控件只支持添加一个contentView");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9407d) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        int i = 0;
        if (action == 0) {
            this.f9414k = false;
            this.f9410g.x = motionEvent.getX();
            this.f9410g.y = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY() - this.f9410g.y;
                motionEvent.getX();
                float f = this.f9410g.x;
                this.f9414k = true;
                OnSugViewDragListener onSugViewDragListener = this.f9406c;
                if (onSugViewDragListener != null) {
                    onSugViewDragListener.onSugViewIsStartMove();
                }
                float f2 = 0.0f;
                if (y > 0.0f) {
                    i = 1;
                }
                this.f9409f = i;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9404a.getLayoutParams();
                int i2 = layoutParams.topMargin;
                int i3 = layoutParams.bottomMargin;
                int i4 = (y > 0.0f ? 1 : (y == 0.0f ? 0 : -1));
                int i5 = (int) (((float) i2) + ((i4 >= 0 || i2 > this.f9408e) ? y : 0.0f));
                float f3 = (float) i3;
                if (i4 >= 0 || i5 > this.f9408e) {
                    f2 = y;
                }
                int i6 = (int) (f3 - f2);
                int i7 = this.f9408e;
                if (i5 < i7) {
                    i5 = i7;
                }
                int i8 = this.f9418o;
                if (i6 > (-i8)) {
                    i6 = -i8;
                }
                layoutParams.setMargins(layoutParams.leftMargin, i5, layoutParams.rightMargin, i6);
                this.f9404a.setLayoutParams(layoutParams);
                FrameLayout frameLayout = this.f9405b;
                frameLayout.setAlpha(frameLayout.getAlpha() - ((y / ((float) this.f9415l)) / 1.0f));
                this.f9410g.x = motionEvent.getX();
                this.f9410g.y = motionEvent.getY();
            }
        } else if (!this.f9414k) {
            return false;
        } else {
            if (this.f9409f != 1) {
                m8193c();
            } else if (((FrameLayout.LayoutParams) this.f9404a.getLayoutParams()).bottomMargin < (-this.f9412i) / 5) {
                startPullAnim();
            } else {
                m8193c();
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9404a.getLayoutParams();
        layoutParams.gravity = 80;
        layoutParams.height = this.f9415l;
        layoutParams.width = -1;
        layoutParams.setMargins(layoutParams.leftMargin, this.f9415l, layoutParams.rightMargin, -this.f9415l);
        this.f9404a.setLayoutParams(layoutParams);
        startEnterAnimation();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f9410g.x = motionEvent.getX();
            this.f9410g.y = motionEvent.getY();
            this.f9411h = false;
        } else if (action == 1) {
            this.f9411h = false;
        } else if (action == 2) {
            float y = motionEvent.getY() - this.f9410g.y;
            if (Math.abs(motionEvent.getX() - this.f9410g.x) > 20.0f || Math.abs(y) > 20.0f) {
                this.f9411h = m8187a(motionEvent);
            } else {
                this.f9411h = false;
            }
        }
        if (!this.f9411h || !this.f9407d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m8187a(MotionEvent motionEvent) {
        View view = this.f9404a;
        if (view == null) {
            return false;
        }
        return m8188a(view, motionEvent);
    }

    /* renamed from: a */
    private boolean m8188a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getX() < ((float) i) || motionEvent.getX() > ((float) (i + view.getWidth())) || motionEvent.getY() < ((float) i2) || motionEvent.getY() > ((float) (i2 + (this.f9415l / 4)))) {
            return false;
        }
        return true;
    }

    public void startPullAnim() {
        this.f9405b.setAlpha(0.0f);
        OnSugViewDragListener onSugViewDragListener = this.f9406c;
        if (onSugViewDragListener != null) {
            onSugViewDragListener.onSugViewIsStartMove();
        }
        this.f9405b.setFocusable(true);
        this.f9405b.setFocusableInTouchMode(true);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9404a.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{marginLayoutParams.bottomMargin, -this.f9415l});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(marginLayoutParams) {
            public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m8185a(this.f$1, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (SugViewLayout.this.f9406c != null) {
                    SugViewLayout.this.f9406c.onSugViewIsClose();
                }
            }

            public void onAnimationStart(Animator animator) {
                if (SugViewLayout.this.f9406c != null) {
                    SugViewLayout.this.f9406c.onSugViewStartClose();
                }
                boolean unused = SugViewLayout.this.f9419p = false;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8185a(ViewGroup.MarginLayoutParams marginLayoutParams, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, this.f9415l + intValue, marginLayoutParams.rightMargin, intValue);
        this.f9404a.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: c */
    private void m8193c() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f9404a.getLayoutParams();
        int i = marginLayoutParams.topMargin;
        int i2 = marginLayoutParams.bottomMargin;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, -this.f9418o});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(marginLayoutParams, i, i2) {
            public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m8184a(this.f$1, this.f$2, this.f$3, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f9405b.getAlpha(), this.f9416m});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m8191b(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (SugViewLayout.this.f9406c != null) {
                    SugViewLayout.this.f9406c.onSugViewIsReset();
                }
            }
        });
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SugViewLayout.this.f9419p = true;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8184a(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (i - i2) + intValue, marginLayoutParams.rightMargin, intValue);
        this.f9404a.setLayoutParams(marginLayoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m8191b(ValueAnimator valueAnimator) {
        this.f9405b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void startEnterAnimation() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f9404a.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{layoutParams.bottomMargin, -this.f9418o});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(layoutParams) {
            public final /* synthetic */ FrameLayout.LayoutParams f$1;

            {
                this.f$1 = r2;
            }

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m8186a(this.f$1, valueAnimator);
            }
        });
        ofInt.setInterpolator(new EaseCubicInterpolator(0.28f, 0.96f, 0.3f, 1.0f));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, this.f9416m});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SugViewLayout.this.m8182a(valueAnimator);
            }
        });
        ofFloat.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofInt, ofFloat});
        animatorSet.setDuration(500);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SugViewLayout.this.f9419p = true;
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8186a(FrameLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        layoutParams.setMargins(layoutParams.leftMargin, this.f9415l + intValue, layoutParams.rightMargin, intValue);
        this.f9404a.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m8182a(ValueAnimator valueAnimator) {
        this.f9405b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public void setOnDragCompleteListener(OnSugViewDragListener onSugViewDragListener) {
        this.f9406c = onSugViewDragListener;
    }

    public void setDragEnable(boolean z) {
        this.f9407d = z;
        this.f9413j.setVisibility(z ? 0 : 8);
    }
}
