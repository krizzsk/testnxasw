package com.didi.consume.phone.view.picker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class WheelView extends ScrollView {
    public static final int OFF_SET_DEFAULT = 1;
    public static final String TAG = WheelView.class.getSimpleName();

    /* renamed from: o */
    private static final int f18230o = 0;

    /* renamed from: p */
    private static final int f18231p = 1;

    /* renamed from: a */
    List<String> f18232a;

    /* renamed from: b */
    int f18233b = 1;

    /* renamed from: c */
    int f18234c;

    /* renamed from: d */
    int f18235d = 1;

    /* renamed from: e */
    int f18236e;

    /* renamed from: f */
    Runnable f18237f;

    /* renamed from: g */
    int f18238g = 50;

    /* renamed from: h */
    int f18239h = 0;

    /* renamed from: i */
    int[] f18240i;

    /* renamed from: j */
    Paint f18241j;

    /* renamed from: k */
    int f18242k;

    /* renamed from: l */
    private Context f18243l;

    /* renamed from: m */
    private LinearLayout f18244m;

    /* renamed from: n */
    private int f18245n = -1;

    /* renamed from: q */
    private OnWheelViewListener f18246q;

    public static class OnWheelViewListener {
        public void onSelected(int i, String str) {
        }
    }

    public WheelView(Context context) {
        super(context);
        m15420a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15420a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15420a(context);
    }

    private List<String> getItems() {
        return this.f18232a;
    }

    public void setItems(List<String> list) {
        if (this.f18232a == null) {
            this.f18232a = new ArrayList();
        }
        this.f18232a.clear();
        this.f18232a.addAll(list);
        for (int i = 0; i < this.f18233b; i++) {
            this.f18232a.add(0, "");
            this.f18232a.add("");
        }
        m15418a();
    }

    public int getOffset() {
        return this.f18233b;
    }

    public void setOffset(int i) {
        this.f18233b = i;
    }

    /* renamed from: a */
    private void m15420a(Context context) {
        this.f18243l = context;
        String str = TAG;
        SystemUtils.log(3, str, "parent: " + getParent(), (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 100);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f18244m = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f18244m);
        this.f18237f = new Runnable() {
            public void run() {
                if (WheelView.this.f18236e - WheelView.this.getScrollY() == 0) {
                    final int i = WheelView.this.f18236e % WheelView.this.f18239h;
                    final int i2 = WheelView.this.f18236e / WheelView.this.f18239h;
                    if (i == 0) {
                        WheelView wheelView = WheelView.this;
                        wheelView.f18235d = i2 + wheelView.f18233b;
                        WheelView.this.m15424c();
                    } else if (i > WheelView.this.f18239h / 2) {
                        WheelView.this.post(new Runnable() {
                            public void run() {
                                WheelView.this.smoothScrollTo(0, (WheelView.this.f18236e - i) + WheelView.this.f18239h);
                                WheelView.this.f18235d = i2 + WheelView.this.f18233b + 1;
                                WheelView.this.m15424c();
                            }
                        });
                    } else {
                        WheelView.this.post(new Runnable() {
                            public void run() {
                                WheelView.this.smoothScrollTo(0, WheelView.this.f18236e - i);
                                WheelView.this.f18235d = i2 + WheelView.this.f18233b;
                                WheelView.this.m15424c();
                            }
                        });
                    }
                } else {
                    WheelView wheelView2 = WheelView.this;
                    wheelView2.f18236e = wheelView2.getScrollY();
                    WheelView wheelView3 = WheelView.this;
                    wheelView3.postDelayed(wheelView3.f18237f, (long) WheelView.this.f18238g);
                }
            }
        };
    }

    public void startScrollerTask() {
        this.f18236e = getScrollY();
        postDelayed(this.f18237f, (long) this.f18238g);
    }

    /* renamed from: a */
    private void m15418a() {
        this.f18234c = (this.f18233b * 2) + 1;
        for (String a : this.f18232a) {
            this.f18244m.addView(m15417a(a));
        }
        m15419a(0);
    }

    /* renamed from: a */
    private TextView m15417a(String str) {
        TextView textView = new TextView(this.f18243l);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 18.0f);
        textView.setText(str);
        textView.setGravity(17);
        int a = m15415a(15.0f);
        textView.setPadding(a, a, a, a);
        if (this.f18239h == 0) {
            this.f18239h = m15416a((View) textView);
            String str2 = TAG;
            SystemUtils.log(3, str2, "itemHeight: " + this.f18239h, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 191);
            this.f18244m.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f18239h * this.f18234c));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.f18239h * this.f18234c));
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m15419a(i2);
        if (i2 > i4) {
            this.f18245n = 1;
        } else {
            this.f18245n = 0;
        }
    }

    /* renamed from: a */
    private void m15419a(int i) {
        int i2 = this.f18239h;
        int i3 = this.f18233b;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f18244m.getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            TextView textView = (TextView) this.f18244m.getChildAt(i7);
            if (textView != null) {
                if (i4 == i7) {
                    textView.setTextColor(Color.parseColor("#000000"));
                } else {
                    textView.setTextColor(Color.parseColor("#999999"));
                }
                i7++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int[] m15422b() {
        if (this.f18240i == null) {
            int[] iArr = new int[2];
            this.f18240i = iArr;
            int i = this.f18239h;
            int i2 = this.f18233b;
            iArr[0] = i * i2;
            iArr[1] = i * (i2 + 1);
        }
        return this.f18240i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f18242k == 0) {
            this.f18242k = ((Activity) this.f18243l).getWindowManager().getDefaultDisplay().getWidth();
            String str = TAG;
            SystemUtils.log(3, str, "viewWidth: " + this.f18242k, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 314);
        }
        if (this.f18241j == null) {
            Paint paint = new Paint();
            this.f18241j = paint;
            paint.setColor(Color.parseColor("#10000000"));
            this.f18241j.setStrokeWidth((float) m15415a(1.0f));
        }
        super.setBackgroundDrawable(new Drawable() {
            public int getOpacity() {
                return 0;
            }

            public void setAlpha(int i) {
            }

            public void setColorFilter(ColorFilter colorFilter) {
            }

            public void draw(Canvas canvas) {
                Canvas canvas2 = canvas;
                canvas2.drawLine((float) ((WheelView.this.f18242k * 1) / 6), (float) WheelView.this.m15422b()[0], (float) ((WheelView.this.f18242k * 5) / 6), (float) WheelView.this.m15422b()[0], WheelView.this.f18241j);
                canvas2.drawLine((float) ((WheelView.this.f18242k * 1) / 6), (float) WheelView.this.m15422b()[1], (float) ((WheelView.this.f18242k * 5) / 6), (float) WheelView.this.m15422b()[1], WheelView.this.f18241j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        String str = TAG;
        SystemUtils.log(3, str, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, (Throwable) null, "com.didi.consume.phone.view.picker.WheelView", 354);
        this.f18242k = i;
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m15424c() {
        OnWheelViewListener onWheelViewListener = this.f18246q;
        if (onWheelViewListener != null) {
            int i = this.f18235d;
            onWheelViewListener.onSelected(i, this.f18232a.get(i));
        }
    }

    public void setSeletion(final int i) {
        this.f18235d = this.f18233b + i;
        post(new Runnable() {
            public void run() {
                WheelView wheelView = WheelView.this;
                wheelView.smoothScrollTo(0, i * wheelView.f18239h);
            }
        });
    }

    public String getSeletedItem() {
        return this.f18232a.get(this.f18235d);
    }

    public int getSeletedIndex() {
        return this.f18235d - this.f18233b;
    }

    public void fling(int i) {
        super.fling(i / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    public OnWheelViewListener getOnWheelViewListener() {
        return this.f18246q;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.f18246q = onWheelViewListener;
    }

    /* renamed from: a */
    private int m15415a(float f) {
        return (int) ((f * this.f18243l.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private int m15416a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
