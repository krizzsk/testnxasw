package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.global.globaluikit.datepicker.LEGOWheelPicker;
import com.global.didi.elvish.Elvish;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LEGODaysPicker extends LEGOWheelPicker<LEGODayModel> {

    /* renamed from: a */
    SimpleDateFormat f24377a;

    /* renamed from: b */
    private long f24378b;

    /* renamed from: c */
    private long f24379c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGODayModel f24380d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnDaySelectedListener f24381e;

    public interface OnDaySelectedListener {
        void onDaySelected(LEGODayModel lEGODayModel);
    }

    public LEGODaysPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGODaysPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGODaysPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24377a = new SimpleDateFormat("yyyy-MM-dd");
        setOnWheelChangeListener(new LEGOWheelPicker.OnWheelChangeListener<LEGODayModel>() {
            public void onWheelSelected(LEGODayModel lEGODayModel, int i) {
                LEGODayModel unused = LEGODaysPicker.this.f24380d = lEGODayModel;
                if (LEGODaysPicker.this.f24381e != null) {
                    LEGODaysPicker.this.f24381e.onDaySelected(lEGODayModel);
                }
            }
        });
    }

    public void init(long j) {
        this.f24378b = j;
        this.f24379c = j;
        Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(j);
        updateDay();
        LEGODayModel lEGODayModel = new LEGODayModel(dateTimeCalendar.get(1), dateTimeCalendar.get(2), dateTimeCalendar.get(5), dateTimeCalendar.get(6), this.f24377a.format(dateTimeCalendar.getTime()));
        this.f24380d = lEGODayModel;
        setSelectedDay(lEGODayModel, false);
    }

    public LEGODayModel getSelectedDay() {
        return this.f24380d;
    }

    public void setSelectedDay(LEGODayModel lEGODayModel) {
        setSelectedDay(lEGODayModel, false);
    }

    public void setSelectedDay(long j) {
        Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(j);
        setSelectedDay(new LEGODayModel(dateTimeCalendar.get(1), dateTimeCalendar.get(2), dateTimeCalendar.get(5), dateTimeCalendar.get(6), this.f24377a.format(dateTimeCalendar.getTime())), true);
    }

    public void setSelectedDay(LEGODayModel lEGODayModel, boolean z) {
        this.f24380d = lEGODayModel;
        setCurrentItem(lEGODayModel, z);
    }

    public void setMaxDay(long j) {
        this.f24379c = j;
    }

    public void setMinDay(long j) {
        this.f24378b = j;
    }

    public void setOnDaySelectedListener(OnDaySelectedListener onDaySelectedListener) {
        this.f24381e = onDaySelectedListener;
    }

    public void updateDay() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(this.f24379c);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(this.f24378b);
        long timeInMillis = (instance.getTimeInMillis() - instance2.getTimeInMillis()) / 86400000;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; ((long) i) <= timeInMillis; i++) {
            Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(this.f24378b);
            dateTimeCalendar.add(5, i);
            arrayList.add(new LEGODayModel(dateTimeCalendar.get(1), dateTimeCalendar.get(2), dateTimeCalendar.get(5), dateTimeCalendar.get(6), this.f24377a.format(dateTimeCalendar.getTime())));
        }
        setDataList(arrayList);
    }
}
