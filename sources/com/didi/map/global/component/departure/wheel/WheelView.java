package com.didi.map.global.component.departure.wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.wheel.internal.BaseWheelAdapter;
import com.didi.map.global.component.departure.wheel.internal.CommonStyleWheelDrawable;
import com.didi.map.global.component.departure.wheel.internal.SimpleWheelAdapter;
import com.didi.map.global.component.departure.wheel.internal.WheelConstants;
import com.didi.map.global.component.departure.wheel.internal.WheelUtils;
import com.didi.map.global.component.departure.wheel.internal.WheelViewException;
import java.util.List;

public class WheelView<T> extends ListView implements IWheelView<T> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f27667a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f27668b = 3;

    /* renamed from: c */
    private List<T> f27669c = null;

    /* renamed from: d */
    private int f27670d = -1;

    /* renamed from: e */
    private String f27671e;

    /* renamed from: f */
    private int f27672f;

    /* renamed from: g */
    private int f27673g;

    /* renamed from: h */
    private int f27674h;

    /* renamed from: i */
    private boolean f27675i;

    /* renamed from: j */
    private boolean f27676j = false;

    /* renamed from: k */
    private Paint f27677k;

    /* renamed from: l */
    private WheelViewStyle f27678l;

    /* renamed from: m */
    private BaseWheelAdapter<T> f27679m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public OnWheelItemSelectedListener<T> f27680n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public OnWheelItemClickListener<T> f27681o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f27682p = false;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Handler f27683q = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 256 && WheelView.this.f27680n != null) {
                WheelView.this.f27680n.onItemSelected(WheelView.this.getCurrentPosition(), WheelView.this.getSelectionItem(), WheelView.this.f27682p ? 2 : 1);
                boolean unused = WheelView.this.f27682p = false;
            }
        }
    };

    /* renamed from: r */
    private AdapterView.OnItemClickListener f27684r = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
            if (WheelView.this.f27681o != null) {
                WheelView.this.f27681o.onItemClick(WheelView.this.getCurrentPosition(), WheelView.this.getSelectionItem());
            }
        }
    };

    /* renamed from: s */
    private View.OnTouchListener f27685s = $$Lambda$WheelView$ruIXI3_FKPNDIqbFVy2nOwP0xcc.INSTANCE;

    /* renamed from: t */
    private AbsListView.OnScrollListener f27686t = new AbsListView.OnScrollListener() {
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                boolean unused = WheelView.this.f27682p = true;
                WheelView.this.f27683q.removeMessages(256);
                WheelView.this.f27683q.sendEmptyMessageDelayed(256, 300);
                View childAt = WheelView.this.getChildAt(0);
                if (childAt != null) {
                    float y = childAt.getY();
                    if (y != 0.0f && WheelView.this.f27667a != 0) {
                        if (Math.abs(y) < ((float) (WheelView.this.f27667a >> 1))) {
                            WheelView.this.smoothScrollBy(WheelView.this.m21865a(y), 50);
                            return;
                        }
                        WheelView wheelView = WheelView.this;
                        WheelView.this.smoothScrollBy(wheelView.m21865a(((float) wheelView.f27667a) + y), 50);
                    }
                }
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            WheelView.this.m21874a(false);
        }
    };

    public interface OnWheelItemClickListener<T> {
        void onItemClick(int i, T t);
    }

    public interface OnWheelItemSelectedListener<T> {
        void onItemSelected(int i, T t, int i2);
    }

    public interface WheelViewEventCode {
        public static final int AUTO = 1;
        public static final int HAND = 2;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }

    public WheelView(Context context) {
        super(context);
        m21869a();
    }

    public WheelView(Context context, WheelViewStyle wheelViewStyle) {
        super(context);
        setStyle(wheelViewStyle);
        m21869a();
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21869a();
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21869a();
    }

    public void setOnWheelItemSelectedListener(OnWheelItemSelectedListener<T> onWheelItemSelectedListener) {
        this.f27680n = onWheelItemSelectedListener;
    }

    public void setOnWheelItemClickListener(OnWheelItemClickListener<T> onWheelItemClickListener) {
        this.f27681o = onWheelItemClickListener;
    }

    /* renamed from: a */
    private void m21869a() {
        if (this.f27678l == null) {
            this.f27678l = new WheelViewStyle();
        }
        this.f27677k = new Paint(1);
        setTag(WheelConstants.TAG);
        setVerticalScrollBarEnabled(false);
        setScrollingCacheEnabled(false);
        setCacheColorHint(0);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setDividerHeight(0);
        setOnItemClickListener(this.f27684r);
        setOnScrollListener(this.f27686t);
        setOnTouchListener(this.f27685s);
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        m21877b();
    }

    /* renamed from: b */
    private void m21877b() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    WheelView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    WheelView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (WheelView.this.getChildCount() > 0 && WheelView.this.f27667a == 0) {
                    WheelView wheelView = WheelView.this;
                    int unused = wheelView.f27667a = wheelView.getChildAt(0).getHeight();
                    if (WheelView.this.f27667a != 0) {
                        WheelView.this.getLayoutParams().height = WheelView.this.f27667a * WheelView.this.f27668b;
                        WheelView wheelView2 = WheelView.this;
                        wheelView2.m21870a(wheelView2.getFirstVisiblePosition(), WheelView.this.getCurrentPosition() + (WheelView.this.f27668b / 2), WheelView.this.f27668b / 2);
                        WheelView.this.m21882c();
                        return;
                    }
                    throw new WheelViewException("wheel item is error.");
                }
            }
        });
    }

    public WheelViewStyle getStyle() {
        return this.f27678l;
    }

    public void setStyle(WheelViewStyle wheelViewStyle) {
        this.f27678l = wheelViewStyle;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m21882c() {
        int width = getWidth();
        int i = this.f27667a;
        int i2 = this.f27668b;
        CommonStyleWheelDrawable commonStyleWheelDrawable = new CommonStyleWheelDrawable(width, i * i2, this.f27678l, i2, i);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(commonStyleWheelDrawable);
        } else {
            setBackgroundDrawable(commonStyleWheelDrawable);
        }
    }

    public void setWheelSize(int i) {
        if ((i & 1) != 0) {
            this.f27668b = i;
            BaseWheelAdapter<T> baseWheelAdapter = this.f27679m;
            if (baseWheelAdapter != null) {
                baseWheelAdapter.setWheelSize(i);
                return;
            }
            return;
        }
        throw new WheelViewException("wheel size must be an odd number.");
    }

    public void setWheelClickable(boolean z) {
        if (z != this.f27676j) {
            this.f27676j = z;
            BaseWheelAdapter<T> baseWheelAdapter = this.f27679m;
            if (baseWheelAdapter != null) {
                baseWheelAdapter.setClickable(z);
            }
        }
    }

    public void setClickToPosition(boolean z) {
        if (z) {
            this.f27679m.setOnClickListener(new BaseWheelAdapter.OnClickListener() {
                public void onPositionClick(int i) {
                    int currentPosition = i - WheelView.this.getCurrentPosition();
                    WheelView wheelView = WheelView.this;
                    wheelView.smoothScrollBy(wheelView.f27667a * currentPosition, 400);
                }
            });
        } else {
            this.f27679m.setOnClickListener((BaseWheelAdapter.OnClickListener) null);
        }
    }

    public int getSelection() {
        return this.f27670d;
    }

    public void setSelection(final int i) {
        DLog.m10773d("sfs", "setSelection(): " + i, new Object[0]);
        this.f27682p = false;
        this.f27670d = i;
        postDelayed(new Runnable() {
            public void run() {
                WheelView.super.setSelection(i);
                WheelView.this.m21874a(true);
            }
        }, 200);
    }

    public int getCurrentPosition() {
        return this.f27670d;
    }

    public T getSelectionItem() {
        int max = Math.max(getCurrentPosition(), 0);
        List<T> list = this.f27669c;
        if (list == null || list.size() <= max) {
            return null;
        }
        return this.f27669c.get(max);
    }

    @Deprecated
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof BaseWheelAdapter) {
            setWheelAdapter((BaseWheelAdapter) listAdapter);
            return;
        }
        throw new WheelViewException("please invoke setWheelAdapter method.");
    }

    public void setWheelAdapter(BaseWheelAdapter<T> baseWheelAdapter) {
        super.setAdapter(baseWheelAdapter);
        this.f27679m = baseWheelAdapter;
        baseWheelAdapter.setData(this.f27669c).setWheelSize(this.f27668b).setClickable(this.f27676j);
    }

    public void setWheelData(List<T> list) {
        if (!WheelUtils.isEmpty(list)) {
            this.f27669c = list;
            BaseWheelAdapter<T> baseWheelAdapter = this.f27679m;
            if (baseWheelAdapter != null) {
                baseWheelAdapter.setData(list);
            }
        }
    }

    public void setExtraText(String str, int i, int i2, int i3) {
        setExtraText(str, i, i2, i3, false);
    }

    public void setExtraText(String str, int i, int i2, int i3, boolean z) {
        this.f27671e = str;
        this.f27672f = i;
        this.f27673g = i2;
        this.f27674h = i3;
        this.f27675i = z;
    }

    public int getWheelCount() {
        if (!WheelUtils.isEmpty(this.f27669c)) {
            return this.f27669c.size();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m21865a(float f) {
        if (Math.abs(f) <= 2.0f) {
            return (int) f;
        }
        if (Math.abs(f) < 12.0f) {
            return f > 0.0f ? 2 : -2;
        }
        return (int) (f / 6.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21874a(boolean z) {
        if (getChildAt(0) != null && this.f27667a != 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int i = Math.abs(getChildAt(0).getY()) <= ((float) (this.f27667a >> 1)) ? firstVisiblePosition : firstVisiblePosition + 1;
            int i2 = this.f27668b;
            m21870a(firstVisiblePosition, (i2 / 2) + i, i2 / 2);
            if (z) {
                this.f27683q.removeMessages(256);
                this.f27683q.sendEmptyMessageDelayed(256, 300);
            }
            if (i != this.f27670d) {
                this.f27670d = i;
                this.f27679m.setCurrentPosition(i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21870a(int i, int i2, int i3) {
        for (int i4 = i2 - i3; i4 <= i2 + i3; i4++) {
            View childAt = getChildAt(i4 - i);
            if (childAt != null) {
                if (this.f27679m instanceof SimpleWheelAdapter) {
                    m21871a(i4, i2, childAt, (TextView) childAt.findViewWithTag(101));
                } else {
                    TextView findTextView = WheelUtils.findTextView(childAt);
                    if (findTextView != null) {
                        m21871a(i4, i2, childAt, findTextView);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0043  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m21871a(int r12, int r13, android.view.View r14, android.widget.TextView r15) {
        /*
            r11 = this;
            com.didiglobal.font.DIDIFontUtils$Companion r0 = com.didiglobal.font.DIDIFontUtils.Companion
            android.content.Context r1 = r11.getContext()
            r0.setTypeface(r1, r15)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1098907648(0x41800000, float:16.0)
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = -1
            if (r13 != r12) goto L_0x0063
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.selectedTextColor
            if (r12 == r3) goto L_0x001e
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r2 = r12.selectedTextColor
        L_0x001c:
            r7 = r2
            goto L_0x002b
        L_0x001e:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.textColor
            if (r12 == r3) goto L_0x0029
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r2 = r12.textColor
            goto L_0x001c
        L_0x0029:
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x002b:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.textSize
            if (r12 == r3) goto L_0x0036
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.textSize
            float r1 = (float) r12
        L_0x0036:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.selectedTextSize
            if (r12 == r3) goto L_0x0043
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            int r12 = r12.selectedTextSize
            float r12 = (float) r12
            r8 = r12
            goto L_0x0052
        L_0x0043:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            float r12 = r12.selectedTextZoom
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 == 0) goto L_0x0051
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            float r12 = r12.selectedTextZoom
            float r1 = r1 * r12
        L_0x0051:
            r8 = r1
        L_0x0052:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r12 = r11.f27678l
            boolean r10 = r12.selectedTextBold
            r12 = 2
            r15.setMaxLines(r12)
            r9 = 1065353216(0x3f800000, float:1.0)
            r4 = r11
            r5 = r14
            r6 = r15
            r4.m21872a(r5, r6, r7, r8, r9, r10)
            goto L_0x00a9
        L_0x0063:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r4 = r11.f27678l
            int r4 = r4.textColor
            if (r4 == r3) goto L_0x006f
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r2 = r11.f27678l
            int r2 = r2.textColor
            r7 = r2
            goto L_0x0071
        L_0x006f:
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0071:
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r2 = r11.f27678l
            int r2 = r2.textSize
            if (r2 == r3) goto L_0x007e
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r1 = r11.f27678l
            int r1 = r1.textSize
            float r1 = (float) r1
            r8 = r1
            goto L_0x0080
        L_0x007e:
            r8 = 1098907648(0x41800000, float:16.0)
        L_0x0080:
            int r12 = r12 - r13
            int r12 = java.lang.Math.abs(r12)
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r13 = r11.f27678l
            float r13 = r13.textAlpha
            int r13 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r13 == 0) goto L_0x0093
            com.didi.map.global.component.departure.wheel.WheelView$WheelViewStyle r13 = r11.f27678l
            float r13 = r13.textAlpha
            double r0 = (double) r13
            goto L_0x0098
        L_0x0093:
            r0 = 4604480258916220928(0x3fe6666660000000, double:0.699999988079071)
        L_0x0098:
            double r12 = (double) r12
            double r12 = java.lang.Math.pow(r0, r12)
            float r9 = (float) r12
            r12 = 1
            r15.setMaxLines(r12)
            r10 = 0
            r4 = r11
            r5 = r14
            r6 = r15
            r4.m21872a(r5, r6, r7, r8, r9, r10)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.departure.wheel.WheelView.m21871a(int, int, android.view.View, android.widget.TextView):void");
    }

    /* renamed from: a */
    private void m21872a(View view, TextView textView, int i, float f, float f2, boolean z) {
        textView.setTextColor(i);
        textView.setTextSize(2, f);
        view.setAlpha(f2);
        try {
            textView.getPaint().setFakeBoldText(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!TextUtils.isEmpty(this.f27671e)) {
            Rect rect = new Rect(0, this.f27667a * (this.f27668b / 2), getWidth(), this.f27667a * ((this.f27668b / 2) + 1));
            this.f27677k.setTextSize((float) this.f27673g);
            this.f27677k.setColor(this.f27672f);
            Paint.FontMetricsInt fontMetricsInt = this.f27677k.getFontMetricsInt();
            int i = (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2;
            this.f27677k.setTextAlign(Paint.Align.CENTER);
            try {
                this.f27677k.setFakeBoldText(this.f27675i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            canvas.drawText(this.f27671e, (float) (rect.centerX() + this.f27674h), (float) i, this.f27677k);
        }
    }

    public static class WheelViewStyle {
        public int backgroundColor = -1;
        public int holoBorderColor = -1;
        public int holoBorderWidth = -1;
        public boolean selectedTextBold;
        public int selectedTextColor = -1;
        public int selectedTextSize = -1;
        public float selectedTextZoom = -1.0f;
        public float textAlpha = -1.0f;
        public int textColor = -1;
        public int textSize = -1;

        public WheelViewStyle() {
        }

        public WheelViewStyle(WheelViewStyle wheelViewStyle) {
            this.backgroundColor = wheelViewStyle.backgroundColor;
            this.holoBorderColor = wheelViewStyle.holoBorderColor;
            this.holoBorderWidth = wheelViewStyle.holoBorderWidth;
            this.textColor = wheelViewStyle.textColor;
            this.selectedTextColor = wheelViewStyle.selectedTextColor;
            this.textSize = wheelViewStyle.textSize;
            this.selectedTextSize = wheelViewStyle.selectedTextSize;
            this.textAlpha = wheelViewStyle.textAlpha;
            this.selectedTextZoom = wheelViewStyle.selectedTextZoom;
            this.selectedTextBold = wheelViewStyle.selectedTextBold;
        }
    }
}
