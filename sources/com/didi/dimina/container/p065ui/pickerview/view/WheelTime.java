package com.didi.dimina.container.p065ui.pickerview.view;

import android.view.View;
import com.didi.dimina.container.p065ui.pickerview.adapter.ArrayWheelAdapter;
import com.didi.dimina.container.p065ui.pickerview.adapter.NumericWheelAdapter;
import com.didi.dimina.container.p065ui.pickerview.listener.ISelectTimeCallback;
import com.didi.dimina.container.p065ui.pickerview.utils.ChinaDate;
import com.didi.dimina.container.p065ui.pickerview.utils.LunarCalendar;
import com.didi.dimina.container.p065ui.wheelview.listener.OnItemSelectedListener;
import com.didi.dimina.container.p065ui.wheelview.view.WheelView;
import com.taxis99.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.view.WheelTime */
public class WheelTime {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: k */
    private static final int f19515k = 1900;

    /* renamed from: l */
    private static final int f19516l = 2100;

    /* renamed from: m */
    private static final int f19517m = 1;

    /* renamed from: n */
    private static final int f19518n = 12;

    /* renamed from: o */
    private static final int f19519o = 1;

    /* renamed from: p */
    private static final int f19520p = 31;

    /* renamed from: q */
    private static final int f19521q = 0;

    /* renamed from: r */
    private static final int f19522r = 23;

    /* renamed from: s */
    private static final int f19523s = 0;

    /* renamed from: t */
    private static final int f19524t = 59;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f19525A = 1;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f19526B = 31;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f19527C = 1;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public int f19528D = 31;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f19529E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public int f19530F;

    /* renamed from: G */
    private final int f19531G;

    /* renamed from: H */
    private boolean f19532H = false;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public ISelectTimeCallback f19533I;

    /* renamed from: a */
    int f19534a;

    /* renamed from: b */
    private final View f19535b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WheelView f19536c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WheelView f19537d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WheelView f19538e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WheelView f19539f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WheelView f19540g;

    /* renamed from: h */
    private WheelView f19541h;

    /* renamed from: i */
    private final int f19542i;

    /* renamed from: j */
    private final boolean[] f19543j;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f19544u = 1900;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f19545v = 2100;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f19546w = 1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f19547x = 12;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f19548y = 1;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f19549z = 31;

    public WheelTime(View view, boolean[] zArr, int i, int i2) {
        this.f19535b = view;
        this.f19543j = zArr;
        this.f19542i = i;
        this.f19531G = i2;
    }

    public void setLunarMode(boolean z) {
        this.f19532H = z;
    }

    public boolean isLunarMode() {
        return this.f19532H;
    }

    public void setPicker(int i, int i2, int i3) {
        setPicker(i, i2, i3, 0, 0, 0);
    }

    public void setPicker(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f19532H) {
            int[] solarToLunar = LunarCalendar.solarToLunar(i, i2 + 1, i3);
            m16569a(solarToLunar[0], solarToLunar[1] - 1, solarToLunar[2], solarToLunar[3] == 1, i4, i5, i6);
            return;
        }
        m16567a(i, i2, i3, i4, i5, i6);
    }

    /* renamed from: a */
    private void m16569a(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.f19535b.findViewById(R.id.year);
        this.f19536c = wheelView;
        wheelView.setAdapter(new ArrayWheelAdapter(ChinaDate.getYears(this.f19544u, this.f19545v)));
        this.f19536c.setLabel("");
        this.f19536c.setCurrentItem(i - this.f19544u);
        this.f19536c.setGravity(this.f19542i);
        WheelView wheelView2 = (WheelView) this.f19535b.findViewById(R.id.month);
        this.f19537d = wheelView2;
        wheelView2.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(i)));
        this.f19537d.setLabel("");
        int leapMonth = ChinaDate.leapMonth(i);
        if (leapMonth == 0 || (i2 <= leapMonth - 1 && !z)) {
            this.f19537d.setCurrentItem(i2);
        } else {
            this.f19537d.setCurrentItem(i2 + 1);
        }
        this.f19537d.setGravity(this.f19542i);
        this.f19538e = (WheelView) this.f19535b.findViewById(R.id.day);
        if (ChinaDate.leapMonth(i) == 0) {
            this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(i, i2))));
        } else {
            this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(i))));
        }
        this.f19538e.setLabel("");
        this.f19538e.setCurrentItem(i3 - 1);
        this.f19538e.setGravity(this.f19542i);
        this.f19536c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int a = i + WheelTime.this.f19544u;
                WheelTime.this.f19537d.setAdapter(new ArrayWheelAdapter(ChinaDate.getMonths(a)));
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f19537d.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f19537d.setCurrentItem(WheelTime.this.f19537d.getCurrentItem());
                } else {
                    WheelTime.this.f19537d.setCurrentItem(WheelTime.this.f19537d.getCurrentItem() + 1);
                }
                int currentItem = WheelTime.this.f19538e.getCurrentItem();
                if (ChinaDate.leapMonth(a) == 0 || WheelTime.this.f19537d.getCurrentItem() <= ChinaDate.leapMonth(a) - 1) {
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f19537d.getCurrentItem() + 1))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f19537d.getCurrentItem() + 1);
                } else if (WheelTime.this.f19537d.getCurrentItem() == ChinaDate.leapMonth(a) + 1) {
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(a))));
                    i2 = ChinaDate.leapDays(a);
                } else {
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(a, WheelTime.this.f19537d.getCurrentItem()))));
                    i2 = ChinaDate.monthDays(a, WheelTime.this.f19537d.getCurrentItem());
                }
                int i3 = i2 - 1;
                if (currentItem > i3) {
                    WheelTime.this.f19538e.setCurrentItem(i3);
                }
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
            }
        });
        this.f19537d.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2;
                int currentItem = WheelTime.this.f19536c.getCurrentItem() + WheelTime.this.f19544u;
                int currentItem2 = WheelTime.this.f19538e.getCurrentItem();
                if (ChinaDate.leapMonth(currentItem) == 0 || i <= ChinaDate.leapMonth(currentItem) - 1) {
                    int i3 = i + 1;
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i3))));
                    i2 = ChinaDate.monthDays(currentItem, i3);
                } else if (WheelTime.this.f19537d.getCurrentItem() == ChinaDate.leapMonth(currentItem) + 1) {
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.leapDays(currentItem))));
                    i2 = ChinaDate.leapDays(currentItem);
                } else {
                    WheelTime.this.f19538e.setAdapter(new ArrayWheelAdapter(ChinaDate.getLunarDays(ChinaDate.monthDays(currentItem, i))));
                    i2 = ChinaDate.monthDays(currentItem, i);
                }
                int i4 = i2 - 1;
                if (currentItem2 > i4) {
                    WheelTime.this.f19538e.setCurrentItem(i4);
                }
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
            }
        });
        this.f19539f = (WheelView) this.f19535b.findViewById(R.id.hour);
        this.f19540g = (WheelView) this.f19535b.findViewById(R.id.min);
        this.f19541h = (WheelView) this.f19535b.findViewById(R.id.second);
        this.f19530F = i4;
        this.f19539f.setAdapter(new NumericWheelAdapter(this.f19525A, this.f19526B));
        this.f19539f.setCurrentItem(i4 - this.f19525A);
        this.f19539f.setGravity(this.f19542i);
        int i7 = this.f19525A;
        int i8 = this.f19526B;
        int i9 = 0;
        if (i7 == i8) {
            this.f19540g.setAdapter(new NumericWheelAdapter(this.f19527C, this.f19528D));
            this.f19540g.setCurrentItem(i5 - this.f19527C);
        } else if (i4 == i7) {
            this.f19540g.setAdapter(new NumericWheelAdapter(this.f19527C, 59));
            this.f19540g.setCurrentItem(i5 - this.f19527C);
        } else if (i4 == i8) {
            this.f19540g.setAdapter(new NumericWheelAdapter(0, this.f19528D));
            this.f19540g.setCurrentItem(i5);
        } else {
            this.f19540g.setAdapter(new NumericWheelAdapter(0, 59));
            this.f19540g.setCurrentItem(i5);
        }
        this.f19540g.setGravity(this.f19542i);
        this.f19541h.setAdapter(new NumericWheelAdapter(0, 59));
        this.f19541h.setCurrentItem(i6);
        this.f19541h.setGravity(this.f19542i);
        this.f19534a = this.f19539f.getCurrentItem();
        this.f19539f.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int f = i + WheelTime.this.f19525A;
                int unused = WheelTime.this.f19530F = f;
                int currentItem = WheelTime.this.f19540g.getCurrentItem();
                if (WheelTime.this.f19534a == 0) {
                    currentItem += WheelTime.this.f19527C;
                }
                if (WheelTime.this.f19525A == WheelTime.this.f19526B) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(WheelTime.this.f19527C, WheelTime.this.f19528D));
                    if (currentItem > WheelTime.this.f19540g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f19540g.getAdapter().getItemsCount();
                    }
                } else if (f == WheelTime.this.f19525A) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(WheelTime.this.f19527C, 59));
                    if (currentItem < WheelTime.this.f19527C) {
                        currentItem = 0;
                    } else {
                        currentItem -= WheelTime.this.f19527C;
                    }
                } else if (f == WheelTime.this.f19526B) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(0, WheelTime.this.f19528D));
                    if (currentItem > WheelTime.this.f19540g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f19540g.getAdapter().getItemsCount();
                    }
                } else {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(0, 59));
                }
                WheelTime.this.f19540g.setCurrentItem(currentItem);
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
                WheelTime wheelTime = WheelTime.this;
                wheelTime.f19534a = wheelTime.f19539f.getCurrentItem();
            }
        });
        m16571a(this.f19538e);
        m16571a(this.f19539f);
        m16571a(this.f19540g);
        m16571a(this.f19541h);
        boolean[] zArr = this.f19543j;
        if (zArr.length == 6) {
            this.f19536c.setVisibility(zArr[0] ? 0 : 8);
            this.f19537d.setVisibility(this.f19543j[1] ? 0 : 8);
            this.f19538e.setVisibility(this.f19543j[2] ? 0 : 8);
            this.f19539f.setVisibility(this.f19543j[3] ? 0 : 8);
            this.f19540g.setVisibility(this.f19543j[4] ? 0 : 8);
            WheelView wheelView3 = this.f19541h;
            if (!this.f19543j[5]) {
                i9 = 8;
            }
            wheelView3.setVisibility(i9);
            m16566a();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m16567a(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9 = i;
        int i10 = i2;
        int i11 = i4;
        int i12 = i5;
        final List asList = Arrays.asList(new String[]{"1", "3", "5", "7", "8", "10", "12"});
        final List asList2 = Arrays.asList(new String[]{"4", "6", "9", "11"});
        this.f19529E = i9;
        WheelView wheelView = (WheelView) this.f19535b.findViewById(R.id.year);
        this.f19536c = wheelView;
        wheelView.setAdapter(new NumericWheelAdapter(this.f19544u, this.f19545v));
        this.f19536c.setCurrentItem(i9 - this.f19544u);
        this.f19536c.setGravity(this.f19542i);
        WheelView wheelView2 = (WheelView) this.f19535b.findViewById(R.id.month);
        this.f19537d = wheelView2;
        int i13 = this.f19544u;
        int i14 = this.f19545v;
        if (i13 == i14) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f19546w, this.f19547x));
            this.f19537d.setCurrentItem((i10 + 1) - this.f19546w);
        } else if (i9 == i13) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.f19546w, 12));
            this.f19537d.setCurrentItem((i10 + 1) - this.f19546w);
        } else if (i9 == i14) {
            wheelView2.setAdapter(new NumericWheelAdapter(1, this.f19547x));
            this.f19537d.setCurrentItem(i10);
        } else {
            wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
            this.f19537d.setCurrentItem(i10);
        }
        this.f19537d.setGravity(this.f19542i);
        this.f19538e = (WheelView) this.f19535b.findViewById(R.id.day);
        int i15 = 0;
        boolean z = (i9 % 4 == 0 && i9 % 100 != 0) || i9 % 400 == 0;
        int i16 = 29;
        if (this.f19544u == this.f19545v && this.f19546w == this.f19547x) {
            int i17 = i10 + 1;
            if (asList.contains(String.valueOf(i17))) {
                if (this.f19549z > 31) {
                    this.f19549z = 31;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, this.f19549z));
            } else if (asList2.contains(String.valueOf(i17))) {
                if (this.f19549z > 30) {
                    this.f19549z = 30;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, this.f19549z));
            } else if (z) {
                if (this.f19549z > 29) {
                    this.f19549z = 29;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, this.f19549z));
            } else {
                if (this.f19549z > 28) {
                    this.f19549z = 28;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, this.f19549z));
            }
            this.f19538e.setCurrentItem(i3 - this.f19548y);
        } else if (i9 == this.f19544u && (i8 = i10 + 1) == this.f19546w) {
            if (asList.contains(String.valueOf(i8))) {
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, 31));
            } else if (asList2.contains(String.valueOf(i8))) {
                this.f19538e.setAdapter(new NumericWheelAdapter(this.f19548y, 30));
            } else {
                WheelView wheelView3 = this.f19538e;
                int i18 = this.f19548y;
                if (!z) {
                    i16 = 28;
                }
                wheelView3.setAdapter(new NumericWheelAdapter(i18, i16));
            }
            this.f19538e.setCurrentItem(i3 - this.f19548y);
        } else if (i9 == this.f19545v && (i7 = i10 + 1) == this.f19547x) {
            if (asList.contains(String.valueOf(i7))) {
                if (this.f19549z > 31) {
                    this.f19549z = 31;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(1, this.f19549z));
            } else if (asList2.contains(String.valueOf(i7))) {
                if (this.f19549z > 30) {
                    this.f19549z = 30;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(1, this.f19549z));
            } else if (z) {
                if (this.f19549z > 29) {
                    this.f19549z = 29;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(1, this.f19549z));
            } else {
                if (this.f19549z > 28) {
                    this.f19549z = 28;
                }
                this.f19538e.setAdapter(new NumericWheelAdapter(1, this.f19549z));
            }
            this.f19538e.setCurrentItem(i3 - 1);
        } else {
            int i19 = i10 + 1;
            if (asList.contains(String.valueOf(i19))) {
                this.f19538e.setAdapter(new NumericWheelAdapter(1, 31));
            } else if (asList2.contains(String.valueOf(i19))) {
                this.f19538e.setAdapter(new NumericWheelAdapter(1, 30));
            } else {
                WheelView wheelView4 = this.f19538e;
                int i20 = this.f19548y;
                if (!z) {
                    i16 = 28;
                }
                wheelView4.setAdapter(new NumericWheelAdapter(i20, i16));
            }
            this.f19538e.setCurrentItem(i3 - 1);
        }
        this.f19538e.setGravity(this.f19542i);
        this.f19536c.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int a = i + WheelTime.this.f19544u;
                int unused = WheelTime.this.f19529E = a;
                int currentItem = WheelTime.this.f19537d.getCurrentItem();
                if (WheelTime.this.f19544u == WheelTime.this.f19545v) {
                    WheelTime.this.f19537d.setAdapter(new NumericWheelAdapter(WheelTime.this.f19546w, WheelTime.this.f19547x));
                    if (currentItem > WheelTime.this.f19537d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f19537d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f19537d.setCurrentItem(currentItem);
                    }
                    int m = currentItem + WheelTime.this.f19546w;
                    if (WheelTime.this.f19546w == WheelTime.this.f19547x) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m16568a(a, m, wheelTime.f19548y, WheelTime.this.f19549z, (List<String>) asList, (List<String>) asList2);
                    } else if (m == WheelTime.this.f19546w) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m16568a(a, m, wheelTime2.f19548y, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (m == WheelTime.this.f19547x) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m16568a(a, m, 1, wheelTime3.f19549z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m16568a(a, m, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f19544u) {
                    WheelTime.this.f19537d.setAdapter(new NumericWheelAdapter(WheelTime.this.f19546w, 12));
                    if (currentItem > WheelTime.this.f19537d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f19537d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f19537d.setCurrentItem(currentItem);
                    }
                    int m2 = currentItem + WheelTime.this.f19546w;
                    if (m2 == WheelTime.this.f19546w) {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m16568a(a, m2, wheelTime4.f19548y, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m16568a(a, m2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (a == WheelTime.this.f19545v) {
                    WheelTime.this.f19537d.setAdapter(new NumericWheelAdapter(1, WheelTime.this.f19547x));
                    if (currentItem > WheelTime.this.f19537d.getAdapter().getItemsCount() - 1) {
                        currentItem = WheelTime.this.f19537d.getAdapter().getItemsCount() - 1;
                        WheelTime.this.f19537d.setCurrentItem(currentItem);
                    }
                    int i2 = 1 + currentItem;
                    if (i2 == WheelTime.this.f19547x) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m16568a(a, i2, 1, wheelTime5.f19549z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime.this.m16568a(a, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else {
                    WheelTime.this.f19537d.setAdapter(new NumericWheelAdapter(1, 12));
                    WheelTime wheelTime6 = WheelTime.this;
                    wheelTime6.m16568a(a, 1 + wheelTime6.f19537d.getCurrentItem(), 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
            }
        });
        this.f19537d.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int i2 = i + 1;
                if (WheelTime.this.f19544u == WheelTime.this.f19545v) {
                    int m = (i2 + WheelTime.this.f19546w) - 1;
                    if (WheelTime.this.f19546w == WheelTime.this.f19547x) {
                        WheelTime wheelTime = WheelTime.this;
                        wheelTime.m16568a(wheelTime.f19529E, m, WheelTime.this.f19548y, WheelTime.this.f19549z, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f19546w == m) {
                        WheelTime wheelTime2 = WheelTime.this;
                        wheelTime2.m16568a(wheelTime2.f19529E, m, WheelTime.this.f19548y, 31, (List<String>) asList, (List<String>) asList2);
                    } else if (WheelTime.this.f19547x == m) {
                        WheelTime wheelTime3 = WheelTime.this;
                        wheelTime3.m16568a(wheelTime3.f19529E, m, 1, WheelTime.this.f19549z, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime4 = WheelTime.this;
                        wheelTime4.m16568a(wheelTime4.f19529E, m, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f19529E == WheelTime.this.f19544u) {
                    int m2 = (i2 + WheelTime.this.f19546w) - 1;
                    if (m2 == WheelTime.this.f19546w) {
                        WheelTime wheelTime5 = WheelTime.this;
                        wheelTime5.m16568a(wheelTime5.f19529E, m2, WheelTime.this.f19548y, 31, (List<String>) asList, (List<String>) asList2);
                    } else {
                        WheelTime wheelTime6 = WheelTime.this;
                        wheelTime6.m16568a(wheelTime6.f19529E, m2, 1, 31, (List<String>) asList, (List<String>) asList2);
                    }
                } else if (WheelTime.this.f19529E != WheelTime.this.f19545v) {
                    WheelTime wheelTime7 = WheelTime.this;
                    wheelTime7.m16568a(wheelTime7.f19529E, i2, 1, 31, (List<String>) asList, (List<String>) asList2);
                } else if (i2 == WheelTime.this.f19547x) {
                    WheelTime wheelTime8 = WheelTime.this;
                    wheelTime8.m16568a(wheelTime8.f19529E, WheelTime.this.f19537d.getCurrentItem() + 1, 1, WheelTime.this.f19549z, (List<String>) asList, (List<String>) asList2);
                } else {
                    WheelTime wheelTime9 = WheelTime.this;
                    wheelTime9.m16568a(wheelTime9.f19529E, WheelTime.this.f19537d.getCurrentItem() + 1, 1, 31, (List<String>) asList, (List<String>) asList2);
                }
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
            }
        });
        this.f19539f = (WheelView) this.f19535b.findViewById(R.id.hour);
        this.f19540g = (WheelView) this.f19535b.findViewById(R.id.min);
        this.f19541h = (WheelView) this.f19535b.findViewById(R.id.second);
        this.f19530F = i11;
        this.f19539f.setAdapter(new NumericWheelAdapter(this.f19525A, this.f19526B));
        this.f19539f.setCurrentItem(i11 - this.f19525A);
        this.f19539f.setGravity(this.f19542i);
        int i21 = this.f19525A;
        int i22 = this.f19526B;
        if (i21 == i22) {
            this.f19540g.setAdapter(new NumericWheelAdapter(this.f19527C, this.f19528D));
            this.f19540g.setCurrentItem(i12 - this.f19527C);
        } else if (i11 == i21) {
            this.f19540g.setAdapter(new NumericWheelAdapter(this.f19527C, 59));
            this.f19540g.setCurrentItem(i12 - this.f19527C);
        } else if (i11 == i22) {
            this.f19540g.setAdapter(new NumericWheelAdapter(0, this.f19528D));
            this.f19540g.setCurrentItem(i12);
        } else {
            this.f19540g.setAdapter(new NumericWheelAdapter(0, 59));
            this.f19540g.setCurrentItem(i12);
        }
        this.f19540g.setGravity(this.f19542i);
        this.f19541h.setAdapter(new NumericWheelAdapter(0, 59));
        this.f19541h.setCurrentItem(i6);
        this.f19541h.setGravity(this.f19542i);
        this.f19534a = this.f19539f.getCurrentItem();
        this.f19539f.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(int i) {
                int f = i + WheelTime.this.f19525A;
                int unused = WheelTime.this.f19530F = f;
                int currentItem = WheelTime.this.f19540g.getCurrentItem();
                if (WheelTime.this.f19534a == 0) {
                    currentItem += WheelTime.this.f19527C;
                }
                if (WheelTime.this.f19525A == WheelTime.this.f19526B) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(WheelTime.this.f19527C, WheelTime.this.f19528D));
                    if (currentItem > WheelTime.this.f19540g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f19540g.getAdapter().getItemsCount();
                    }
                } else if (f == WheelTime.this.f19525A) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(WheelTime.this.f19527C, 59));
                    if (currentItem < WheelTime.this.f19527C) {
                        currentItem = 0;
                    } else {
                        currentItem -= WheelTime.this.f19527C;
                    }
                } else if (f == WheelTime.this.f19526B) {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(0, WheelTime.this.f19528D));
                    if (currentItem > WheelTime.this.f19540g.getAdapter().getItemsCount()) {
                        currentItem = WheelTime.this.f19540g.getAdapter().getItemsCount();
                    }
                } else {
                    WheelTime.this.f19540g.setAdapter(new NumericWheelAdapter(0, 59));
                }
                WheelTime.this.f19540g.setCurrentItem(currentItem);
                if (WheelTime.this.f19533I != null) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
                WheelTime wheelTime = WheelTime.this;
                wheelTime.f19534a = wheelTime.f19539f.getCurrentItem();
            }
        });
        m16571a(this.f19538e);
        m16571a(this.f19539f);
        m16571a(this.f19540g);
        m16571a(this.f19541h);
        boolean[] zArr = this.f19543j;
        if (zArr.length == 6) {
            this.f19536c.setVisibility(zArr[0] ? 0 : 8);
            this.f19537d.setVisibility(this.f19543j[1] ? 0 : 8);
            this.f19538e.setVisibility(this.f19543j[2] ? 0 : 8);
            this.f19539f.setVisibility(this.f19543j[3] ? 0 : 8);
            this.f19540g.setVisibility(this.f19543j[4] ? 0 : 8);
            WheelView wheelView5 = this.f19541h;
            if (!this.f19543j[5]) {
                i15 = 8;
            }
            wheelView5.setVisibility(i15);
            m16566a();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    /* renamed from: a */
    private void m16571a(WheelView wheelView) {
        if (this.f19533I != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i) {
                    WheelTime.this.f19533I.onTimeSelectChanged();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16568a(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f19538e.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f19538e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f19538e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f19538e.setAdapter(new NumericWheelAdapter(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f19538e.setAdapter(new NumericWheelAdapter(i3, i4));
        }
        if (currentItem > this.f19538e.getAdapter().getItemsCount() - 1) {
            this.f19538e.setCurrentItem(this.f19538e.getAdapter().getItemsCount() - 1);
        }
    }

    /* renamed from: a */
    private void m16566a() {
        this.f19538e.setTextSize((float) this.f19531G);
        this.f19537d.setTextSize((float) this.f19531G);
        this.f19536c.setTextSize((float) this.f19531G);
        this.f19539f.setTextSize((float) this.f19531G);
        this.f19540g.setTextSize((float) this.f19531G);
        this.f19541h.setTextSize((float) this.f19531G);
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        if (!this.f19532H) {
            if (str != null) {
                this.f19536c.setLabel(str);
            } else {
                this.f19536c.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_year));
            }
            if (str2 != null) {
                this.f19537d.setLabel(str2);
            } else {
                this.f19537d.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_month));
            }
            if (str3 != null) {
                this.f19538e.setLabel(str3);
            } else {
                this.f19538e.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_day));
            }
            if (str4 != null) {
                this.f19539f.setLabel(str4);
            } else {
                this.f19539f.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_hours));
            }
            if (str5 != null) {
                this.f19540g.setLabel(str5);
            } else {
                this.f19540g.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_minutes));
            }
            if (str6 != null) {
                this.f19541h.setLabel(str6);
            } else {
                this.f19541h.setLabel(this.f19535b.getContext().getString(R.string.dimina_pickerview_seconds));
            }
        }
    }

    public void setTextXOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f19536c.setTextXOffset(i);
        this.f19537d.setTextXOffset(i2);
        this.f19538e.setTextXOffset(i3);
        this.f19539f.setTextXOffset(i4);
        this.f19540g.setTextXOffset(i5);
        this.f19541h.setTextXOffset(i6);
    }

    public void setCyclic(boolean z) {
        this.f19536c.setCyclic(z);
        this.f19537d.setCyclic(z);
        this.f19538e.setCyclic(z);
        this.f19539f.setCyclic(z);
        this.f19540g.setCyclic(z);
        this.f19541h.setCyclic(z);
    }

    public String getTime() {
        if (this.f19532H) {
            return m16574b();
        }
        StringBuilder sb = new StringBuilder();
        if (this.f19529E == this.f19544u) {
            int currentItem = this.f19537d.getCurrentItem();
            int i = this.f19546w;
            if (currentItem + i == i) {
                sb.append(this.f19536c.getCurrentItem() + this.f19544u);
                sb.append("-");
                sb.append(this.f19537d.getCurrentItem() + this.f19546w);
                sb.append("-");
                sb.append(this.f19538e.getCurrentItem() + this.f19548y);
                sb.append(" ");
                sb.append(this.f19539f.getCurrentItem() + this.f19525A);
                sb.append(":");
                if (this.f19539f.getCurrentItem() == 0) {
                    sb.append(this.f19540g.getCurrentItem() + this.f19527C);
                    sb.append(":");
                    sb.append(this.f19541h.getCurrentItem());
                } else {
                    sb.append(this.f19540g.getCurrentItem());
                    sb.append(":");
                    sb.append(this.f19541h.getCurrentItem());
                }
            } else {
                sb.append(this.f19536c.getCurrentItem() + this.f19544u);
                sb.append("-");
                sb.append(this.f19537d.getCurrentItem() + this.f19546w);
                sb.append("-");
                sb.append(this.f19538e.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f19539f.getCurrentItem());
                sb.append(":");
                sb.append(this.f19540g.getCurrentItem());
                sb.append(":");
                sb.append(this.f19541h.getCurrentItem());
            }
        } else {
            sb.append(this.f19536c.getCurrentItem() + this.f19544u);
            sb.append("-");
            sb.append(this.f19537d.getCurrentItem() + 1);
            sb.append("-");
            sb.append(this.f19538e.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f19539f.getCurrentItem());
            sb.append(":");
            sb.append(this.f19540g.getCurrentItem());
            sb.append(":");
            sb.append(this.f19541h.getCurrentItem());
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00ab  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m16574b() {
        /*
            r7 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f19536c
            int r1 = r1.getCurrentItem()
            int r2 = r7.f19544u
            int r1 = r1 + r2
            int r2 = com.didi.dimina.container.p065ui.pickerview.utils.ChinaDate.leapMonth(r1)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L_0x001f
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
        L_0x001c:
            int r2 = r2 + r4
        L_0x001d:
            r5 = 0
            goto L_0x0051
        L_0x001f:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
            int r2 = r2 + r4
            int r5 = com.didi.dimina.container.p065ui.pickerview.utils.ChinaDate.leapMonth(r1)
            int r2 = r2 - r5
            if (r2 > 0) goto L_0x0034
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
            goto L_0x001c
        L_0x0034:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
            int r2 = r2 + r4
            int r5 = com.didi.dimina.container.p065ui.pickerview.utils.ChinaDate.leapMonth(r1)
            int r2 = r2 - r5
            if (r2 != r4) goto L_0x004a
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
            r5 = 1
            goto L_0x0051
        L_0x004a:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19537d
            int r2 = r2.getCurrentItem()
            goto L_0x001d
        L_0x0051:
            com.didi.dimina.container.ui.wheelview.view.WheelView r6 = r7.f19538e
            int r6 = r6.getCurrentItem()
            int r6 = r6 + r4
            int[] r1 = com.didi.dimina.container.p065ui.pickerview.utils.LunarCalendar.lunarToSolar(r1, r2, r6, r5)
            r2 = r1[r3]
            r0.append(r2)
            java.lang.String r2 = "-"
            r0.append(r2)
            r3 = r1[r4]
            r0.append(r3)
            r0.append(r2)
            r2 = 2
            r1 = r1[r2]
            r0.append(r1)
            java.lang.String r1 = " "
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f19539f
            int r1 = r1.getCurrentItem()
            int r2 = r7.f19525A
            int r1 = r1 + r2
            r0.append(r1)
            java.lang.String r1 = ":"
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19539f
            int r2 = r2.getCurrentItem()
            if (r2 != 0) goto L_0x00ab
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19540g
            int r2 = r2.getCurrentItem()
            int r3 = r7.f19527C
            int r2 = r2 + r3
            r0.append(r2)
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f19541h
            int r1 = r1.getCurrentItem()
            r0.append(r1)
            goto L_0x00c0
        L_0x00ab:
            com.didi.dimina.container.ui.wheelview.view.WheelView r2 = r7.f19540g
            int r2 = r2.getCurrentItem()
            r0.append(r2)
            r0.append(r1)
            com.didi.dimina.container.ui.wheelview.view.WheelView r1 = r7.f19541h
            int r1 = r1.getCurrentItem()
            r0.append(r1)
        L_0x00c0:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p065ui.pickerview.view.WheelTime.m16574b():java.lang.String");
    }

    public View getView() {
        return this.f19535b;
    }

    public int getStartYear() {
        return this.f19544u;
    }

    public void setStartYear(int i) {
        this.f19544u = i;
    }

    public int getEndYear() {
        return this.f19545v;
    }

    public void setEndYear(int i) {
        this.f19545v = i;
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.f19544u;
            if (i > i4) {
                this.f19545v = i;
                this.f19547x = i2;
                this.f19549z = i3;
            } else if (i == i4) {
                int i5 = this.f19546w;
                if (i2 > i5) {
                    this.f19545v = i;
                    this.f19547x = i2;
                    this.f19549z = i3;
                } else if (i2 == i5 && i3 > this.f19548y) {
                    this.f19545v = i;
                    this.f19547x = i2;
                    this.f19549z = i3;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i6 = calendar.get(1);
            int i7 = calendar.get(2) + 1;
            int i8 = calendar.get(5);
            int i9 = this.f19545v;
            if (i6 < i9) {
                this.f19546w = i7;
                this.f19548y = i8;
                this.f19544u = i6;
            } else if (i6 == i9) {
                int i10 = this.f19547x;
                if (i7 < i10) {
                    this.f19546w = i7;
                    this.f19548y = i8;
                    this.f19544u = i6;
                } else if (i7 == i10 && i8 < this.f19549z) {
                    this.f19546w = i7;
                    this.f19548y = i8;
                    this.f19544u = i6;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.f19544u = calendar.get(1);
            this.f19545v = calendar2.get(1);
            this.f19546w = calendar.get(2) + 1;
            this.f19547x = calendar2.get(2) + 1;
            this.f19548y = calendar.get(5);
            this.f19549z = calendar2.get(5);
            this.f19525A = calendar.get(11);
            this.f19526B = calendar2.get(11);
            this.f19527C = calendar.get(12);
            this.f19528D = calendar2.get(12);
        }
    }

    public void setLineSpacingMultiplier(float f) {
        this.f19538e.setLineSpacingMultiplier(f);
        this.f19537d.setLineSpacingMultiplier(f);
        this.f19536c.setLineSpacingMultiplier(f);
        this.f19539f.setLineSpacingMultiplier(f);
        this.f19540g.setLineSpacingMultiplier(f);
        this.f19541h.setLineSpacingMultiplier(f);
    }

    public void setDividerColor(int i) {
        this.f19538e.setDividerColor(i);
        this.f19537d.setDividerColor(i);
        this.f19536c.setDividerColor(i);
        this.f19539f.setDividerColor(i);
        this.f19540g.setDividerColor(i);
        this.f19541h.setDividerColor(i);
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.f19538e.setDividerType(dividerType);
        this.f19537d.setDividerType(dividerType);
        this.f19536c.setDividerType(dividerType);
        this.f19539f.setDividerType(dividerType);
        this.f19540g.setDividerType(dividerType);
        this.f19541h.setDividerType(dividerType);
    }

    public void setTextColorCenter(int i) {
        this.f19538e.setTextColorCenter(i);
        this.f19537d.setTextColorCenter(i);
        this.f19536c.setTextColorCenter(i);
        this.f19539f.setTextColorCenter(i);
        this.f19540g.setTextColorCenter(i);
        this.f19541h.setTextColorCenter(i);
    }

    public void setTextColorOut(int i) {
        this.f19538e.setTextColorOut(i);
        this.f19537d.setTextColorOut(i);
        this.f19536c.setTextColorOut(i);
        this.f19539f.setTextColorOut(i);
        this.f19540g.setTextColorOut(i);
        this.f19541h.setTextColorOut(i);
    }

    public void isCenterLabel(boolean z) {
        this.f19538e.isCenterLabel(z);
        this.f19537d.isCenterLabel(z);
        this.f19536c.isCenterLabel(z);
        this.f19539f.isCenterLabel(z);
        this.f19540g.isCenterLabel(z);
        this.f19541h.isCenterLabel(z);
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.f19533I = iSelectTimeCallback;
    }

    public void setItemsVisible(int i) {
        this.f19538e.setItemsVisibleCount(i);
        this.f19537d.setItemsVisibleCount(i);
        this.f19536c.setItemsVisibleCount(i);
        this.f19539f.setItemsVisibleCount(i);
        this.f19540g.setItemsVisibleCount(i);
        this.f19541h.setItemsVisibleCount(i);
    }

    public void setAlphaGradient(boolean z) {
        this.f19538e.setAlphaGradient(z);
        this.f19537d.setAlphaGradient(z);
        this.f19536c.setAlphaGradient(z);
        this.f19539f.setAlphaGradient(z);
        this.f19540g.setAlphaGradient(z);
        this.f19541h.setAlphaGradient(z);
    }
}
