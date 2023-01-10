package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;

/* renamed from: com.didi.rfusion.widget.calendar.c */
/* compiled from: RFMonthAdapter */
class C12366c extends BaseAdapter {

    /* renamed from: a */
    static final int f36236a = C12368e.m27295c().getMaximum(4);

    /* renamed from: b */
    final Month f36237b;

    /* renamed from: c */
    final RFDateSelector<?> f36238c;

    /* renamed from: d */
    RFCalendarStyle f36239d;

    /* renamed from: e */
    final RFCalendarConstraints f36240e;

    /* renamed from: f */
    private Collection<Long> f36241f;

    public boolean hasStableIds() {
        return true;
    }

    C12366c(Month month, RFDateSelector<?> rFDateSelector, RFCalendarConstraints rFCalendarConstraints) {
        this.f36237b = month;
        this.f36238c = rFDateSelector;
        this.f36240e = rFCalendarConstraints;
        this.f36241f = rFDateSelector.getSelectedDays();
    }

    /* renamed from: a */
    public Long getItem(int i) {
        if (i < this.f36237b.mo93956b() || i > mo94094b()) {
            return null;
        }
        return Long.valueOf(this.f36237b.mo93954a(mo94095b(i)));
    }

    public long getItemId(int i) {
        return (long) (i / this.f36237b.f36162c);
    }

    public int getCount() {
        return this.f36237b.f36163d + mo94090a();
    }

    /* JADX WARNING: type inference failed for: r7v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.m27261a((android.content.Context) r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L_0x001f
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r0 = 2131626206(0x7f0e08de, float:1.8879642E38)
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x001f:
            int r7 = r5.mo94090a()
            int r7 = r6 - r7
            if (r7 < 0) goto L_0x0078
            com.didi.rfusion.widget.calendar.Month r8 = r5.f36237b
            int r8 = r8.f36163d
            if (r7 < r8) goto L_0x002e
            goto L_0x0078
        L_0x002e:
            r8 = 1
            int r7 = r7 + r8
            com.didi.rfusion.widget.calendar.Month r2 = r5.f36237b
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            com.didi.rfusion.widget.calendar.Month r2 = r5.f36237b
            long r2 = r2.mo93954a((int) r7)
            com.didi.rfusion.widget.calendar.Month r7 = r5.f36237b
            int r7 = r7.f36161b
            com.didi.rfusion.widget.calendar.Month r4 = com.didi.rfusion.widget.calendar.Month.m27199a()
            int r4 = r4.f36161b
            if (r7 != r4) goto L_0x006a
            java.lang.String r7 = com.didi.rfusion.widget.calendar.C12364a.m27254c(r2)
            r0.setContentDescription(r7)
            goto L_0x0071
        L_0x006a:
            java.lang.String r7 = com.didi.rfusion.widget.calendar.C12364a.m27256d(r2)
            r0.setContentDescription(r7)
        L_0x0071:
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            goto L_0x0080
        L_0x0078:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L_0x0080:
            java.lang.Long r6 = r5.getItem((int) r6)
            if (r6 != 0) goto L_0x0087
            return r0
        L_0x0087:
            long r6 = r6.longValue()
            r5.m27262a((android.widget.TextView) r0, (long) r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.calendar.C12366c.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* renamed from: a */
    public void mo94093a(RFCalendarGridView rFCalendarGridView) {
        for (Long longValue : this.f36241f) {
            m27263a(rFCalendarGridView, longValue.longValue());
        }
        RFDateSelector<?> rFDateSelector = this.f36238c;
        if (rFDateSelector != null) {
            for (Long longValue2 : rFDateSelector.getSelectedDays()) {
                m27263a(rFCalendarGridView, longValue2.longValue());
            }
            this.f36241f = this.f36238c.getSelectedDays();
        }
    }

    /* renamed from: a */
    private void m27263a(RFCalendarGridView rFCalendarGridView, long j) {
        if (Month.m27201a(j).equals(this.f36237b)) {
            m27262a((TextView) rFCalendarGridView.getChildAt(rFCalendarGridView.getAdapter().mo94096c(this.f36237b.mo93957b(j)) - rFCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    /* renamed from: a */
    private void m27262a(TextView textView, long j) {
        RFCalendarItemStyle rFCalendarItemStyle;
        if (textView != null) {
            if (this.f36240e.getDateValidator().isValid(j)) {
                textView.setEnabled(true);
                if (m27264a(j)) {
                    rFCalendarItemStyle = this.f36239d.getSelectedDay();
                } else if (C12368e.m27292b().getTimeInMillis() == j) {
                    rFCalendarItemStyle = this.f36239d.getTodayDay();
                } else {
                    rFCalendarItemStyle = this.f36239d.getDay();
                }
            } else {
                textView.setEnabled(false);
                rFCalendarItemStyle = this.f36239d.getInvalidDay();
            }
            rFCalendarItemStyle.styleItem(textView);
        }
    }

    /* renamed from: a */
    private boolean m27264a(long j) {
        for (Long longValue : this.f36238c.getSelectedDays()) {
            if (C12368e.m27281a(j) == C12368e.m27281a(longValue.longValue())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m27261a(Context context) {
        if (this.f36239d == null) {
            this.f36239d = new RFCalendarStyle(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo94090a() {
        return this.f36237b.mo93956b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo94094b() {
        return (this.f36237b.mo93956b() + this.f36237b.f36163d) - 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo94095b(int i) {
        return (i - this.f36237b.mo93956b()) + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo94096c(int i) {
        return mo94090a() + (i - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo94097d(int i) {
        return i >= mo94090a() && i <= mo94094b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo94098e(int i) {
        return i % this.f36237b.f36162c == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo94099f(int i) {
        return (i + 1) % this.f36237b.f36162c == 0;
    }
}
