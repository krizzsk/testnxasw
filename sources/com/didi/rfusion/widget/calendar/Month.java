package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

final class Month implements Parcelable, Comparable<Month> {
    public static final Parcelable.Creator<Month> CREATOR = new Parcelable.Creator<Month>() {
        public Month createFromParcel(Parcel parcel) {
            return Month.m27200a(parcel.readInt(), parcel.readInt());
        }

        public Month[] newArray(int i) {
            return new Month[i];
        }
    };

    /* renamed from: a */
    final int f36160a;

    /* renamed from: b */
    final int f36161b = this.f36165f.get(1);

    /* renamed from: c */
    final int f36162c = this.f36165f.getMaximum(7);

    /* renamed from: d */
    final int f36163d = this.f36165f.getActualMaximum(5);

    /* renamed from: e */
    final long f36164e = this.f36165f.getTimeInMillis();

    /* renamed from: f */
    private final Calendar f36165f;

    /* renamed from: g */
    private String f36166g;

    public int describeContents() {
        return 0;
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b = C12368e.m27293b(calendar);
        this.f36165f = b;
        this.f36160a = b.get(2);
    }

    /* renamed from: a */
    static Month m27201a(long j) {
        Calendar c = C12368e.m27295c();
        c.setTimeInMillis(j);
        return new Month(c);
    }

    /* renamed from: a */
    static Month m27200a(int i, int i2) {
        Calendar c = C12368e.m27295c();
        c.set(1, i);
        c.set(2, i2);
        return new Month(c);
    }

    /* renamed from: a */
    static Month m27199a() {
        return new Month(C12368e.m27292b());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo93956b() {
        int firstDayOfWeek = this.f36165f.get(7) - this.f36165f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f36162c : firstDayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.f36160a == month.f36160a && this.f36161b == month.f36161b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36160a), Integer.valueOf(this.f36161b)});
    }

    /* renamed from: a */
    public int compareTo(Month month) {
        return this.f36165f.compareTo(month.f36165f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo93958b(Month month) {
        if (this.f36165f instanceof GregorianCalendar) {
            return ((month.f36161b - this.f36161b) * 12) + (month.f36160a - this.f36160a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo93960c() {
        return this.f36165f.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo93954a(int i) {
        Calendar b = C12368e.m27293b(this.f36165f);
        b.set(5, i);
        return b.getTimeInMillis();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo93957b(long j) {
        Calendar b = C12368e.m27293b(this.f36165f);
        b.setTimeInMillis(j);
        return b.get(5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Month mo93959b(int i) {
        Calendar b = C12368e.m27293b(this.f36165f);
        b.add(2, i);
        return new Month(b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo93955a(Context context) {
        if (this.f36166g == null) {
            this.f36166g = C12364a.m27251a(context, this.f36165f.getTimeInMillis());
        }
        return this.f36166g;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f36161b);
        parcel.writeInt(this.f36160a);
    }
}
