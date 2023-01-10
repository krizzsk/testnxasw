package com.didi.sdk.view.timepicker;

import android.content.res.Resources;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Deprecated
public class TimeStrategy {

    /* renamed from: a */
    private static final int f40946a = 24;

    /* renamed from: b */
    private static final int f40947b = 60;

    /* renamed from: c */
    private static final int f40948c = 10;

    /* renamed from: d */
    private static final int f40949d = 0;

    /* renamed from: e */
    private static final int f40950e = 0;

    /* renamed from: f */
    private static final int f40951f = 24;

    /* renamed from: g */
    private static final int f40952g = 0;

    /* renamed from: h */
    private int f40953h = 10;

    /* renamed from: i */
    private int f40954i = 24;

    /* renamed from: j */
    private int f40955j = 60;

    /* renamed from: k */
    private int f40956k = 3;

    /* renamed from: l */
    private int f40957l;

    /* renamed from: m */
    private int f40958m = 0;

    /* renamed from: n */
    private int f40959n = 0;

    /* renamed from: o */
    private int f40960o = 0;

    /* renamed from: p */
    private int f40961p = 24;

    /* renamed from: q */
    private Locale f40962q = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: r */
    private boolean f40963r;

    public void setIsSupportNow(boolean z) {
        this.f40963r = z;
    }

    public int getAppointmentDay() {
        return this.f40956k;
    }

    public void setAppointmentDay(int i) {
        this.f40956k = i;
    }

    public int getmEarliestDelta() {
        return this.f40957l;
    }

    public void setEarliestDelta(int i) {
        this.f40957l = i;
    }

    public int getBeginHourInDay() {
        return this.f40958m;
    }

    public void setBeginHourInDay(int i) {
        this.f40958m = i;
    }

    public int getBeginMinInDay() {
        return this.f40959n;
    }

    public void setBeginMinInDay(int i) {
        this.f40959n = i;
    }

    public int getEndMinInDay() {
        return this.f40960o;
    }

    public void setEndMinInDay(int i) {
        this.f40960o = i;
    }

    public int getEndHourInDay() {
        return this.f40961p;
    }

    public void setEndHourInDay(int i) {
        this.f40961p = i;
    }

    public boolean isInvalid(long j) {
        if (this.f40963r && j == 0) {
            return false;
        }
        long latestAvailableTime = getLatestAvailableTime();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (j < latestAvailableTime) {
            return true;
        }
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(latestAvailableTime);
        int i = this.f40956k;
        if (i > 1) {
            instance2.add(5, i - 1);
        }
        if (j > m30702b(instance2.getTimeInMillis()).getTimeInMillis()) {
            return true;
        }
        Calendar a = m30700a(j);
        if (!instance.after(m30702b(j)) && !instance.before(a)) {
            return false;
        }
        return true;
    }

    public int getEarliesDay() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        Calendar instance2 = Calendar.getInstance();
        int i = 0;
        int i2 = 1;
        while (i < 100) {
            if (instance2.get(5) == instance.get(5)) {
                return i2;
            }
            i2++;
            i++;
            instance2.add(5, 1);
        }
        return -1;
    }

    public long getLatestAvailableTime() {
        long a = m30699a();
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(a);
        Calendar a2 = m30700a(a);
        if (instance.compareTo(m30702b(a)) >= 0) {
            instance.add(5, 1);
            instance.set(11, this.f40958m);
            instance.set(12, this.f40959n);
            return instance.getTimeInMillis();
        } else if (instance.compareTo(a2) >= 0) {
            return a;
        } else {
            instance.set(11, this.f40958m);
            instance.set(12, this.f40959n);
            return instance.getTimeInMillis();
        }
    }

    /* renamed from: a */
    private long m30699a() {
        long currentTimeMillis = System.currentTimeMillis() + ((long) (this.f40957l * 60 * 1000));
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        instance.set(13, 0);
        instance.set(14, 0);
        int a = m30698a(instance.get(12));
        if (a == this.f40955j) {
            instance.add(11, 1);
            instance.set(12, 0);
        } else {
            instance.set(12, a);
        }
        return instance.getTimeInMillis();
    }

    /* renamed from: a */
    private Calendar m30700a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, this.f40958m);
        instance.set(12, this.f40959n);
        return instance;
    }

    /* renamed from: b */
    private Calendar m30702b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = this.f40961p;
        if (i == this.f40954i) {
            instance.add(5, 1);
            instance.set(11, 0);
            instance.set(12, 0);
        } else {
            instance.set(11, i);
            instance.set(12, this.f40960o);
        }
        return instance;
    }

    /* renamed from: a */
    private int m30698a(int i) {
        int i2 = this.f40953h;
        int i3 = i % i2;
        int i4 = i / i2;
        if (i3 != 0) {
            i4++;
        }
        return i4 * this.f40953h;
    }

    public List<String> getHour(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f40961p;
        int i3 = this.f40954i;
        if (i2 == i3) {
            i2 = i3;
        }
        for (int max = Math.max(this.f40958m, i); max < i2; max++) {
            arrayList.add(String.valueOf(max));
        }
        return arrayList;
    }

    public List<String> getMinute(int i) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (int a = m30698a(i); a < this.f40955j; a += 10) {
            if (a == 0) {
                str = "00";
            } else {
                str = String.valueOf(a);
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    public List<String> getDay(Resources resources, String[] strArr, boolean z) {
        ArrayList arrayList = new ArrayList();
        int earliesDay = getEarliesDay();
        if (z) {
            arrayList.add(strArr[0]);
        }
        if (earliesDay < 4) {
            for (int i = z ? earliesDay : earliesDay - 1; i < strArr.length; i++) {
                arrayList.add(strArr[i]);
            }
        }
        if (earliesDay == -1) {
            return null;
        }
        m30701a(resources, arrayList, earliesDay);
        return arrayList;
    }

    /* renamed from: a */
    private void m30701a(Resources resources, ArrayList<String> arrayList, int i) {
        int i2;
        int i3 = 3;
        if (i < 4) {
            i2 = this.f40956k - ((3 - i) + 1);
        } else {
            i3 = i - 1;
            i2 = this.f40956k;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            arrayList.add(formatTimeMillionsToMonthDayWeek(resources, instance, this.f40962q, false));
            instance.add(5, 1);
        }
        if (i2 < 0) {
            int i5 = i2 * -1;
            for (int i6 = 0; i6 < i5; i6++) {
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    arrayList.remove(size);
                }
            }
        }
    }

    public static String formatTimeMillionsToMonthDayWeek(Resources resources, Calendar calendar, Locale locale, boolean z) {
        String displayName = calendar.getDisplayName(2, 1, locale);
        int i = calendar.get(5);
        String displayName2 = calendar.getDisplayName(7, locale == Locale.US ? 1 : 2, locale);
        String string = resources.getString(R.string.today);
        Object[] objArr = new Object[3];
        objArr[0] = displayName;
        objArr[1] = Integer.valueOf(i);
        if (z) {
            displayName2 = string;
        }
        objArr[2] = displayName2;
        return String.format(locale, resources.getString(R.string.time_picker_date_format, objArr), new Object[0]);
    }
}
