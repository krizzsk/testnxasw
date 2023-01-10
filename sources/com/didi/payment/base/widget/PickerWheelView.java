package com.didi.payment.base.widget;

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

public class PickerWheelView extends ScrollView {
    public static final int OFF_SET_DEFAULT = 1;
    public static final String TAG = PickerWheelView.class.getSimpleName();

    /* renamed from: o */
    private static final int f32584o = 0;

    /* renamed from: p */
    private static final int f32585p = 1;

    /* renamed from: a */
    List<String> f32586a;

    /* renamed from: b */
    int f32587b = 1;

    /* renamed from: c */
    int f32588c;

    /* renamed from: d */
    int f32589d = 1;

    /* renamed from: e */
    int f32590e;

    /* renamed from: f */
    Runnable f32591f;

    /* renamed from: g */
    int f32592g = 50;

    /* renamed from: h */
    int f32593h = 0;

    /* renamed from: i */
    int[] f32594i;

    /* renamed from: j */
    Paint f32595j;

    /* renamed from: k */
    int f32596k;

    /* renamed from: l */
    private Context f32597l;

    /* renamed from: m */
    private LinearLayout f32598m;

    /* renamed from: n */
    private int f32599n = -1;

    /* renamed from: q */
    private OnWheelViewListener f32600q;

    public static class OnWheelViewListener {
        public void onSelected(int i, String str) {
        }
    }

    public PickerWheelView(Context context) {
        super(context);
        m24711a(context);
    }

    public PickerWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24711a(context);
    }

    public PickerWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24711a(context);
    }

    private List<String> getItems() {
        return this.f32586a;
    }

    public void setItems(List<String> list) {
        if (this.f32586a == null) {
            this.f32586a = new ArrayList();
        }
        this.f32586a.clear();
        this.f32586a.addAll(list);
        for (int i = 0; i < this.f32587b; i++) {
            this.f32586a.add(0, "");
            this.f32586a.add("");
        }
        m24709a();
    }

    public int getOffset() {
        return this.f32587b;
    }

    public void setOffset(int i) {
        this.f32587b = i;
    }

    /* renamed from: a */
    private void m24711a(Context context) {
        this.f32597l = context;
        String str = TAG;
        SystemUtils.log(3, str, "parent: " + getParent(), (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 105);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f32598m = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f32598m);
        this.f32591f = new Runnable() {
            public void run() {
                if (PickerWheelView.this.f32590e - PickerWheelView.this.getScrollY() == 0) {
                    final int i = PickerWheelView.this.f32590e % PickerWheelView.this.f32593h;
                    final int i2 = PickerWheelView.this.f32590e / PickerWheelView.this.f32593h;
                    if (i == 0) {
                        PickerWheelView pickerWheelView = PickerWheelView.this;
                        pickerWheelView.f32589d = i2 + pickerWheelView.f32587b;
                        PickerWheelView.this.m24715c();
                    } else if (i > PickerWheelView.this.f32593h / 2) {
                        PickerWheelView.this.post(new Runnable() {
                            public void run() {
                                PickerWheelView.this.smoothScrollTo(0, (PickerWheelView.this.f32590e - i) + PickerWheelView.this.f32593h);
                                PickerWheelView.this.f32589d = i2 + PickerWheelView.this.f32587b + 1;
                                PickerWheelView.this.m24715c();
                            }
                        });
                    } else {
                        PickerWheelView.this.post(new Runnable() {
                            public void run() {
                                PickerWheelView.this.smoothScrollTo(0, PickerWheelView.this.f32590e - i);
                                PickerWheelView.this.f32589d = i2 + PickerWheelView.this.f32587b;
                                PickerWheelView.this.m24715c();
                            }
                        });
                    }
                } else {
                    PickerWheelView pickerWheelView2 = PickerWheelView.this;
                    pickerWheelView2.f32590e = pickerWheelView2.getScrollY();
                    PickerWheelView pickerWheelView3 = PickerWheelView.this;
                    pickerWheelView3.postDelayed(pickerWheelView3.f32591f, (long) PickerWheelView.this.f32592g);
                }
            }
        };
    }

    public void startScrollerTask() {
        this.f32590e = getScrollY();
        postDelayed(this.f32591f, (long) this.f32592g);
    }

    /* renamed from: a */
    private void m24709a() {
        this.f32588c = (this.f32587b * 2) + 1;
        for (String a : this.f32586a) {
            this.f32598m.addView(m24708a(a));
        }
        m24710a(0);
    }

    /* renamed from: a */
    private TextView m24708a(String str) {
        TextView textView = new TextView(this.f32597l);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 18.0f);
        textView.setText(str);
        textView.setGravity(17);
        int a = m24706a(15.0f);
        textView.setPadding(a, a, a, a);
        if (this.f32593h == 0) {
            this.f32593h = m24707a((View) textView);
            String str2 = TAG;
            SystemUtils.log(3, str2, "itemHeight: " + this.f32593h, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 196);
            this.f32598m.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f32593h * this.f32588c));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.f32593h * this.f32588c));
        }
        return textView;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        m24710a(i2);
        if (i2 > i4) {
            this.f32599n = 1;
        } else {
            this.f32599n = 0;
        }
    }

    /* renamed from: a */
    private void m24710a(int i) {
        int i2 = this.f32593h;
        int i3 = this.f32587b;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f32598m.getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            TextView textView = (TextView) this.f32598m.getChildAt(i7);
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
    public int[] m24713b() {
        if (this.f32594i == null) {
            int[] iArr = new int[2];
            this.f32594i = iArr;
            int i = this.f32593h;
            int i2 = this.f32587b;
            iArr[0] = i * i2;
            iArr[1] = i * (i2 + 1);
        }
        return this.f32594i;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f32596k == 0) {
            this.f32596k = ((Activity) this.f32597l).getWindowManager().getDefaultDisplay().getWidth();
            String str = TAG;
            SystemUtils.log(3, str, "viewWidth: " + this.f32596k, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 319);
        }
        if (this.f32595j == null) {
            Paint paint = new Paint();
            this.f32595j = paint;
            paint.setColor(Color.parseColor("#10000000"));
            this.f32595j.setStrokeWidth((float) m24706a(1.0f));
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
                canvas2.drawLine((float) ((PickerWheelView.this.f32596k * 1) / 6), (float) PickerWheelView.this.m24713b()[0], (float) ((PickerWheelView.this.f32596k * 5) / 6), (float) PickerWheelView.this.m24713b()[0], PickerWheelView.this.f32595j);
                canvas2.drawLine((float) ((PickerWheelView.this.f32596k * 1) / 6), (float) PickerWheelView.this.m24713b()[1], (float) ((PickerWheelView.this.f32596k * 5) / 6), (float) PickerWheelView.this.m24713b()[1], PickerWheelView.this.f32595j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        String str = TAG;
        SystemUtils.log(3, str, "w: " + i + ", h: " + i2 + ", oldw: " + i3 + ", oldh: " + i4, (Throwable) null, "com.didi.payment.base.widget.PickerWheelView", 359);
        this.f32596k = i;
        setBackgroundDrawable((Drawable) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24715c() {
        OnWheelViewListener onWheelViewListener = this.f32600q;
        if (onWheelViewListener != null) {
            int i = this.f32589d;
            onWheelViewListener.onSelected(i, this.f32586a.get(i));
        }
    }

    public void setSeletion(final int i) {
        this.f32589d = this.f32587b + i;
        post(new Runnable() {
            public void run() {
                PickerWheelView pickerWheelView = PickerWheelView.this;
                pickerWheelView.smoothScrollTo(0, i * pickerWheelView.f32593h);
            }
        });
    }

    public String getSeletedItem() {
        return this.f32586a.get(this.f32589d);
    }

    public int getSeletedIndex() {
        return this.f32589d - this.f32587b;
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
        return this.f32600q;
    }

    public void setOnWheelViewListener(OnWheelViewListener onWheelViewListener) {
        this.f32600q = onWheelViewListener;
    }

    /* renamed from: a */
    private int m24706a(float f) {
        return (int) ((f * this.f32597l.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    private int m24707a(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }
}
