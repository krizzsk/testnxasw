package com.didi.global.globaluikit.datepicker.time;

import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import java.util.Calendar;

public class LEGODayModel {

    /* renamed from: a */
    private int f24372a;

    /* renamed from: b */
    private int f24373b;

    /* renamed from: c */
    private int f24374c;

    /* renamed from: d */
    private int f24375d;

    /* renamed from: e */
    private String f24376e;

    public LEGODayModel(int i, int i2, int i3, int i4, String str) {
        this.f24372a = i3;
        this.f24373b = i;
        this.f24374c = i2;
        this.f24375d = i4;
        this.f24376e = str;
    }

    public String getDayString() {
        return toString();
    }

    public String toString() {
        Calendar instance = Calendar.getInstance();
        instance.set(this.f24373b, this.f24374c, this.f24372a);
        Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(System.currentTimeMillis());
        int i = dateTimeCalendar.get(1);
        int i2 = dateTimeCalendar.get(2);
        int i3 = dateTimeCalendar.get(5);
        if (i == this.f24373b && i2 == this.f24374c && i3 == this.f24372a) {
            return C9239a.f24392a;
        }
        return Elvish.Companion.getInstance().formatDateTime(instance.getTimeInMillis() / 1000, DateStyle.DATE_DD_MTH, TimeStyle.NONE, true);
    }

    public int getDay() {
        return this.f24372a;
    }

    public int getYear() {
        return this.f24373b;
    }

    public int getMonth() {
        return this.f24374c;
    }

    public int getDate() {
        return this.f24375d;
    }

    public boolean equals(Object obj) {
        LEGODayModel lEGODayModel = (LEGODayModel) obj;
        return this.f24373b == lEGODayModel.getYear() && this.f24374c == lEGODayModel.getMonth() && this.f24372a == lEGODayModel.getDay();
    }
}
