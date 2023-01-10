package com.didi.sdk.view.picker;

import android.content.res.Resources;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TimeStrategy {

    /* renamed from: a */
    private static final int f40845a = 60;

    /* renamed from: b */
    private static final int f40846b = 24;

    /* renamed from: c */
    private static final int f40847c = 30;

    /* renamed from: d */
    private static final int f40848d = 10;

    /* renamed from: e */
    private int f40849e = 30;

    /* renamed from: f */
    private int f40850f = 10;

    /* renamed from: g */
    private int f40851g = 0;

    /* renamed from: h */
    private int f40852h = 0;

    /* renamed from: i */
    private int f40853i = 24;

    /* renamed from: j */
    private int f40854j = 60;

    /* renamed from: k */
    private int f40855k = 3;

    /* renamed from: l */
    private Locale f40856l = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: m */
    private TimeZone f40857m = TimeZone.getDefault();

    /* renamed from: n */
    private Calendar f40858n;

    public Calendar getLatestAvailableCalendar() {
        Calendar calendar = this.f40858n;
        if (calendar != null) {
            return (Calendar) calendar.clone();
        }
        return null;
    }

    public Calendar getLastAvailableCalendar() {
        Calendar calendar = (Calendar) this.f40858n.clone();
        int i = this.f40855k;
        if (i > 1) {
            calendar.add(5, i - 1);
        }
        return m30634b(calendar.getTimeInMillis());
    }

    public List<String> getDay(Resources resources, String[] strArr) {
        boolean z = strArr.length == 4;
        ArrayList arrayList = new ArrayList();
        int b = m30633b();
        if (b == -1) {
            return null;
        }
        if (z) {
            arrayList.add(strArr[0]);
        }
        if (b < 4) {
            for (int i = z ? b : b - 1; i < strArr.length; i++) {
                arrayList.add(strArr[i]);
            }
        }
        m30632a(resources, arrayList, b);
        return arrayList;
    }

    public List<String> getHour(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f40853i;
        for (int max = Math.max(this.f40851g, i); max < i2; max++) {
            arrayList.add(String.valueOf(max));
        }
        return arrayList;
    }

    public List<String> getMinute(int i) {
        ArrayList arrayList = new ArrayList();
        int a = m30629a(Math.max(this.f40852h, i));
        while (a < this.f40854j) {
            arrayList.add(String.valueOf(a));
            a += this.f40850f;
        }
        return arrayList;
    }

    public long getLatestAvailableTime() {
        Calendar calendar = this.f40858n;
        if (calendar != null) {
            return calendar.getTimeInMillis();
        }
        long a = m30630a();
        Calendar instance = Calendar.getInstance(this.f40857m);
        this.f40858n = instance;
        instance.setTimeInMillis(a);
        Calendar a2 = m30631a(a);
        if (instance.compareTo(m30634b(a)) >= 0) {
            instance.add(5, 1);
            instance.set(11, this.f40851g);
            instance.set(12, this.f40852h);
            return instance.getTimeInMillis();
        } else if (instance.compareTo(a2) >= 0) {
            return a;
        } else {
            instance.set(11, this.f40851g);
            instance.set(12, this.f40852h);
            return instance.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private long m30630a() {
        Calendar instance = Calendar.getInstance(this.f40857m);
        instance.setTimeInMillis(Calendar.getInstance(this.f40857m).getTimeInMillis() + ((long) (this.f40849e * 60 * 1000)));
        instance.set(13, 0);
        instance.set(14, 0);
        int a = m30629a(instance.get(12));
        if (a == 60) {
            instance.add(11, 1);
            instance.set(12, 0);
        } else {
            instance.set(12, a);
        }
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    private int m30629a(int i) {
        int i2 = this.f40850f;
        int i3 = i % i2;
        int i4 = i / i2;
        if (i3 != 0) {
            i4++;
        }
        return i4 * this.f40850f;
    }

    /* renamed from: a */
    private Calendar m30631a(long j) {
        Calendar instance = Calendar.getInstance(this.f40857m);
        instance.setTimeInMillis(j);
        instance.set(11, this.f40851g);
        instance.set(12, this.f40852h);
        return instance;
    }

    /* renamed from: b */
    private Calendar m30634b(long j) {
        Calendar instance = Calendar.getInstance(this.f40857m);
        instance.setTimeInMillis(j);
        int i = this.f40853i;
        if (i == 24) {
            instance.add(5, 1);
            instance.set(11, 0);
            instance.set(12, 0);
        } else {
            instance.set(11, i);
            instance.set(12, this.f40854j);
        }
        return instance;
    }

    /* renamed from: b */
    private int m30633b() {
        Calendar instance = Calendar.getInstance(this.f40857m);
        instance.setTimeInMillis(getLatestAvailableTime());
        Calendar instance2 = Calendar.getInstance(this.f40857m);
        for (int i = 1; i < 100; i++) {
            if (instance2.get(5) == instance.get(5)) {
                return i;
            }
            instance2.add(5, 1);
        }
        return -1;
    }

    /* renamed from: a */
    private void m30632a(Resources resources, List<String> list, int i) {
        int i2;
        int i3 = 3;
        if (i < 4) {
            i2 = this.f40855k - ((3 - i) + 1);
        } else {
            i3 = i - 1;
            i2 = this.f40855k;
        }
        Calendar instance = Calendar.getInstance(this.f40857m);
        instance.add(5, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            list.add(formatTimeMillionsToMonthDayWeek(resources, instance, false));
            instance.add(5, 1);
        }
        if (i2 < 0) {
            int i5 = i2 * -1;
            for (int i6 = 0; i6 < i5; i6++) {
                int size = list.size() - 1;
                if (size >= 0) {
                    list.remove(size);
                }
            }
        }
    }

    public String formatTimeMillionsToMonthDayWeek(Resources resources, Calendar calendar, boolean z) {
        String displayName = calendar.getDisplayName(2, 1, this.f40856l);
        int i = calendar.get(5);
        String displayName2 = calendar.getDisplayName(7, this.f40856l == Locale.US ? 1 : 2, this.f40856l);
        String string = resources.getString(R.string.today);
        Locale locale = this.f40856l;
        Object[] objArr = new Object[3];
        objArr[0] = displayName;
        objArr[1] = Integer.valueOf(i);
        if (z) {
            displayName2 = string;
        }
        objArr[2] = displayName2;
        return String.format(locale, resources.getString(R.string.time_picker_date_format, objArr), new Object[0]);
    }

    public void setAppointmentDay(int i) {
        this.f40855k = i;
    }

    public void setEarliestDelta(int i) {
        this.f40849e = i;
    }

    public void setMinuteDelta(int i) {
        this.f40850f = i;
    }

    public void setBeginMinInDay(int i) {
        this.f40852h = i;
    }

    public void setBeginHourInDay(int i) {
        this.f40851g = i;
    }

    public void setEndMinInDay(int i) {
        this.f40854j = i;
    }

    public void setEndHourInDay(int i) {
        this.f40853i = i;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.f40857m = timeZone;
    }

    public int getAppointmentDay() {
        return this.f40855k;
    }
}
