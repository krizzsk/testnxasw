package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.datepicker.LEGODatePickerCallback;
import com.didi.global.globaluikit.datepicker.model.LEGODatePickerModel;
import com.didi.global.globaluikit.datepicker.time.LEGODaysPicker;
import com.didi.global.globaluikit.datepicker.time.LEGOHourPicker;
import com.didi.global.globaluikit.drawer.LEGOAbsDrawer;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.Calendar;

public class LEGODatePicker extends LEGOAbsDrawer {

    /* renamed from: p */
    private static final int f24354p = 4;

    /* renamed from: q */
    private static final int f24355q = 2;

    /* renamed from: r */
    private static final int f24356r = 1;

    /* renamed from: a */
    private final LEGODatePickerModel f24357a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LEGODatePickerCallback f24358b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public LEGODaysPicker f24359c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LEGOHourPicker f24360d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public LEGOMinutePicker f24361e;

    /* renamed from: f */
    private TextView f24362f;

    /* renamed from: g */
    private ImageView f24363g;

    /* renamed from: h */
    private TextView f24364h;

    /* renamed from: i */
    private TextView f24365i;

    /* renamed from: j */
    private int f24366j;

    /* renamed from: k */
    private int f24367k;

    /* renamed from: l */
    private int f24368l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f24369m;

    /* renamed from: n */
    private int f24370n;

    /* renamed from: o */
    private int f24371o;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.lego_layout_date_picker;
    }

    public LEGODatePicker(Context context, LEGODatePickerModel lEGODatePickerModel, LEGODatePickerCallback lEGODatePickerCallback) {
        super(context);
        this.f24357a = lEGODatePickerModel;
        if (lEGODatePickerModel != null) {
            if (!TextUtils.isEmpty(lEGODatePickerModel.today)) {
                C9239a.f24392a = lEGODatePickerModel.today;
            }
            if (!TextUtils.isEmpty(lEGODatePickerModel.now)) {
                C9239a.f24393b = lEGODatePickerModel.now;
            }
            this.f24357a.beginTimeSecond = lEGODatePickerModel.beginTimeSecond * 1000;
            this.f24357a.endTimeSecond = lEGODatePickerModel.endTimeSecond * 1000;
            this.f24357a.defaultScrolledSecond = lEGODatePickerModel.defaultScrolledSecond * 1000;
        }
        this.f24358b = lEGODatePickerCallback;
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        this.f24359c = (LEGODaysPicker) this.mRealView.findViewById(R.id.dayPicker_layout_time);
        this.f24360d = (LEGOHourPicker) this.mRealView.findViewById(R.id.hourPicker_layout_time);
        this.f24361e = (LEGOMinutePicker) this.mRealView.findViewById(R.id.minutePicker_layout_time);
        this.f24362f = (TextView) this.mRealView.findViewById(R.id.date_picker_title);
        this.f24363g = (ImageView) this.mRealView.findViewById(R.id.date_picker_close_icon);
        this.f24364h = (TextView) this.mRealView.findViewById(R.id.date_picker_confirm);
        this.f24365i = (TextView) this.mRealView.findViewById(R.id.lego_date_picker_symbol);
        this.f24363g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODatePicker.this.dismiss();
                if (LEGODatePicker.this.f24358b != null) {
                    LEGODatePicker.this.f24358b.onCancelClick();
                }
            }
        });
        this.f24364h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Calendar instance = Calendar.getInstance();
                LEGODayModel selectedDay = LEGODatePicker.this.f24359c.getSelectedDay();
                instance.set(selectedDay.getYear(), selectedDay.getMonth(), selectedDay.getDay(), LEGODatePicker.this.f24360d.getSelectedHour(), LEGODatePicker.this.f24361e.getSelectedMinute());
                long timeInMillis = instance.getTimeInMillis();
                if (LEGODatePicker.this.f24360d.getSelectedHour() == -1) {
                    timeInMillis = 0;
                }
                if (LEGODatePicker.this.f24358b != null) {
                    LEGODatePicker.this.f24358b.onConfirmClick(timeInMillis / 1000);
                }
                LEGODatePicker.this.dismiss();
            }
        });
        m19576a();
        return true;
    }

    /* renamed from: a */
    private void m19576a() {
        LEGODatePickerModel lEGODatePickerModel = this.f24357a;
        if (lEGODatePickerModel != null) {
            if (lEGODatePickerModel.title != null) {
                this.f24357a.title.bindTextView(this.f24362f);
            }
            if (this.f24357a.confirmTitle != null) {
                this.f24357a.confirmTitle.bindTextView(this.f24364h);
            }
            this.f24359c.init(this.f24357a.beginTimeSecond);
            this.f24359c.setOnDaySelectedListener(new LEGODaysPicker.OnDaySelectedListener() {
                public void onDaySelected(LEGODayModel lEGODayModel) {
                    int date = lEGODayModel.getDate();
                    if (lEGODayModel.getYear() > LEGODatePicker.this.f24369m) {
                        date += 366;
                    }
                    LEGODatePicker.this.m19587b(date);
                }
            });
            this.f24360d.setOnHourSelectedListener(new LEGOHourPicker.OnHourSelectedListener() {
                public void onHourSelected(int i) {
                    LEGODatePicker.this.m19577a(i);
                }
            });
            Calendar dateTimeCalendar = Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.beginTimeSecond);
            this.f24367k = dateTimeCalendar.get(6);
            this.f24368l = dateTimeCalendar.get(11);
            this.f24369m = dateTimeCalendar.get(1);
            Calendar dateTimeCalendar2 = Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.endTimeSecond);
            this.f24370n = dateTimeCalendar2.get(6);
            if (dateTimeCalendar2.get(1) > this.f24369m) {
                this.f24370n += 366;
            }
            this.f24371o = dateTimeCalendar2.get(11);
            int g = m19600g(this.f24357a.intervalSecond);
            this.f24366j = g;
            this.f24361e.setDelta(g);
            m19592c(7);
            m19593c(true);
            m19586b();
            if (this.f24357a.defaultScrolledSecond > 0 && this.f24357a.defaultScrolledSecond >= this.f24357a.beginTimeSecond && this.f24357a.defaultScrolledSecond <= this.f24357a.endTimeSecond) {
                m19578a(this.f24357a.defaultScrolledSecond);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19577a(int i) {
        boolean z = true;
        m19593c(this.f24360d.getSelectedHour() == -1);
        m19592c(1);
        if (this.f24359c.getSelectedDay().getDate() == this.f24367k) {
            if (i <= this.f24368l) {
                m19592c(1);
                if (i != this.f24368l) {
                    z = false;
                }
                m19583a(z);
                this.f24361e.setCurrentPosition(0);
            }
        } else if (this.f24359c.getSelectedDay().getDate() == this.f24370n && i >= this.f24371o) {
            m19595d(i);
            this.f24361e.setCurrentPosition(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19587b(int i) {
        boolean z = false;
        if (i >= this.f24370n) {
            m19595d(this.f24357a.serviceBeginSecond);
            this.f24360d.setCurrentPosition(0);
            this.f24361e.setCurrentPosition(0);
        } else if (i > this.f24367k) {
            m19592c(3);
        } else {
            m19586b();
            this.f24360d.setCurrentPosition(0);
            this.f24361e.setCurrentPosition(0);
        }
        if (i == this.f24367k) {
            z = true;
        }
        m19593c(z);
    }

    /* renamed from: a */
    private void m19578a(long j) {
        m19579a(j, Elvish.Companion.getInstance().getDateTimeCalendar(j));
    }

    /* renamed from: a */
    private void m19579a(long j, final Calendar calendar) {
        this.f24359c.setSelectedDay(j);
        int i = calendar.get(6);
        if (calendar.get(1) > this.f24369m) {
            i += 366;
        }
        m19587b(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LEGODatePicker.this.m19582a(calendar);
            }
        }, 500);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19582a(final Calendar calendar) {
        int i = calendar.get(11);
        this.f24360d.setSelectedHour(i, true);
        m19577a(i);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                LEGODatePicker.this.f24361e.setSelectedMinute(calendar.get(12), true);
            }
        }, 500);
    }

    /* renamed from: c */
    private void m19592c(int i) {
        if ((i & 4) == 4) {
            this.f24359c.setMinDay(this.f24357a.beginTimeSecond);
            this.f24359c.setMaxDay(this.f24357a.endTimeSecond);
            this.f24359c.updateDay();
            this.f24359c.setCurrentPosition(0, true);
        }
        if ((i & 2) == 2) {
            this.f24360d.setBeginHourInDay(m19599f(this.f24357a.serviceBeginSecond), false, false);
            this.f24360d.setEndHourInDay(m19599f(this.f24357a.serviceEndSecond));
            this.f24360d.updateHour();
            m19593c(false);
            this.f24360d.setCurrentPosition(0, true);
        }
        if ((i & 1) == 1) {
            this.f24361e.setBeginMinuteInHour(0);
            this.f24361e.setEndMinuteInHour(59);
            this.f24361e.updateMinute();
            this.f24361e.setCurrentPosition(0, true);
        }
    }

    /* renamed from: d */
    private void m19595d(int i) {
        m19589b(m19598e(i));
    }

    /* renamed from: b */
    private void m19586b() {
        m19583a(false);
    }

    /* renamed from: a */
    private void m19583a(boolean z) {
        m19584a(m19596d(), z);
        m19591c();
    }

    /* renamed from: c */
    private void m19591c() {
        this.f24359c.setMinDay(Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.beginTimeSecond).getTimeInMillis());
        this.f24359c.updateDay();
    }

    /* renamed from: a */
    private void m19584a(boolean z, boolean z2) {
        int f = m19599f(this.f24357a.serviceBeginSecond);
        int f2 = m19599f(this.f24357a.serviceEndSecond);
        int max = Math.max(Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.beginTimeSecond).get(11), f) + (z ? 1 : 0);
        boolean z3 = max > f2;
        LEGOHourPicker lEGOHourPicker = this.f24360d;
        if (z3) {
            max = -1;
        }
        lEGOHourPicker.setBeginHourInDay(max, true, z2);
        LEGOHourPicker lEGOHourPicker2 = this.f24360d;
        if (z3) {
            f2 = -1;
        }
        lEGOHourPicker2.setEndHourInDay(f2);
        this.f24360d.updateHour();
    }

    /* renamed from: e */
    private boolean m19598e(int i) {
        int f = m19599f(this.f24357a.serviceBeginSecond);
        int min = Math.min(Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.endTimeSecond).get(11), m19599f(this.f24357a.serviceEndSecond));
        this.f24360d.setBeginHourInDay(f, false, false);
        this.f24360d.setEndHourInDay(min);
        this.f24360d.updateHour(true);
        if (i == min) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m19589b(boolean z) {
        int i = 1;
        if (z) {
            int i2 = Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.endTimeSecond).get(12);
            int i3 = this.f24366j;
            int i4 = i2 / i3;
            if (i2 % i3 == 0) {
                i = 0;
            }
            this.f24361e.setBeginMinuteInHour(0);
            this.f24361e.setEndMinuteInHour(Math.max(i3 * (i4 - i), 0));
            this.f24361e.updateMinute();
            return;
        }
        m19592c(1);
    }

    /* renamed from: c */
    private void m19593c(boolean z) {
        int i = 4;
        this.f24365i.setVisibility(z ? 4 : 0);
        LEGOMinutePicker lEGOMinutePicker = this.f24361e;
        if (!z) {
            i = 0;
        }
        lEGOMinutePicker.setVisibility(i);
    }

    /* renamed from: d */
    private boolean m19596d() {
        int i = Elvish.Companion.getInstance().getDateTimeCalendar(this.f24357a.beginTimeSecond).get(12);
        int i2 = this.f24366j;
        boolean z = true;
        int i3 = 0;
        int i4 = i2 * ((i / i2) + (i % i2 != 0 ? 1 : 0));
        if (i4 <= 59) {
            z = false;
        }
        LEGOMinutePicker lEGOMinutePicker = this.f24361e;
        if (!z) {
            i3 = i4;
        }
        lEGOMinutePicker.setBeginMinuteInHour(i3);
        this.f24361e.updateMinute();
        return z;
    }

    /* renamed from: f */
    private int m19599f(int i) {
        if (i <= 0) {
            return 0;
        }
        int i2 = (i / 60) / 60;
        if (i2 > 23) {
            return 23;
        }
        return i2;
    }

    /* renamed from: g */
    private int m19600g(int i) {
        if (i <= 0 || i % 60 != 0) {
            return 1;
        }
        return i / 60;
    }

    public void show() {
        super.show();
    }
}
