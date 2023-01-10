package com.didi.sdk.view.timepicker;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.timepicker.TimePickerPopup;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

@Deprecated
public class GlobalPickerPopup extends SimplePopupBase {

    /* renamed from: a */
    Wheel f40893a;

    /* renamed from: b */
    Wheel f40894b;

    /* renamed from: c */
    Wheel f40895c;

    /* renamed from: d */
    Wheel.OnItemChangedListener f40896d;

    /* renamed from: e */
    Wheel.OnItemChangedListener f40897e;

    /* renamed from: f */
    Wheel.OnItemChangedListener f40898f;

    /* renamed from: g */
    private String[] f40899g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TimePickerView f40900h;

    /* renamed from: i */
    private TimeStrategy f40901i = new TimeStrategy();

    /* renamed from: j */
    private CommonPopupTitleBar f40902j;

    /* renamed from: k */
    private TextView f40903k;

    /* renamed from: l */
    private TextView f40904l;

    /* renamed from: m */
    private View f40905m;

    /* renamed from: n */
    private long f40906n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TimePickerPopup.OnTimeSelectedListener f40907o;

    /* renamed from: p */
    private CharSequence f40908p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<String> f40909q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<String> f40910r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public Calendar f40911s = null;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_timepicker_popup;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f40900h = (TimePickerView) this.mRootView.findViewById(R.id.time_picker);
        this.f40893a = (Wheel) this.mRootView.findViewById(R.id.day_picker);
        this.f40894b = (Wheel) this.mRootView.findViewById(R.id.hour_picker);
        this.f40895c = (Wheel) this.mRootView.findViewById(R.id.minute_picker);
        this.f40902j = (CommonPopupTitleBar) this.mRootView.findViewById(R.id.title_bar);
        this.f40903k = (TextView) this.mRootView.findViewById(R.id.title_bar2);
        this.f40905m = this.mRootView.findViewById(R.id.rl_root);
        this.f40904l = (TextView) this.mRootView.findViewById(R.id.tv_confirm2);
        this.mRootView.findViewById(R.id.containertitle_bar).setVisibility(0);
        this.f40905m.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        this.f40902j.setVisibility(8);
        this.f40904l.setVisibility(0);
        this.f40894b.setSuffix(getString(R.string.time_picker_hour));
        this.f40895c.setSuffix(getString(R.string.time_picker_min));
        this.f40903k.setText(this.f40908p);
        this.mRootView.findViewById(R.id.imageClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalPickerPopup.this.dismiss();
            }
        });
        this.f40897e = new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (GlobalPickerPopup.this.f40893a.getSelectedIndex() == 0 && i == 0) {
                    GlobalPickerPopup.this.f40895c.setVisibility(4);
                } else {
                    GlobalPickerPopup.this.f40895c.setVisibility(0);
                }
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(GlobalPickerPopup.this.getLatestAvailableTime());
                if (GlobalPickerPopup.this.f40893a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f40894b.getSelectedIndex() == 0) {
                    GlobalPickerPopup.this.m30663b(instance.get(12));
                } else if (GlobalPickerPopup.this.f40893a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f40894b.getSelectedIndex() == 1) {
                    GlobalPickerPopup.this.m30663b(instance.get(12));
                } else {
                    GlobalPickerPopup.this.m30663b(0);
                }
                GlobalPickerPopup.this.f40895c.setData(GlobalPickerPopup.this.f40910r);
                GlobalPickerPopup.this.f40900h.setContentDescription(GlobalPickerPopup.this.m30661b());
                GlobalPickerPopup.this.f40900h.sendAccessibilityEvent(128);
            }
        };
        C140743 r0 = new Wheel.OnItemChangedListener() {
            int lastSelectedDate = 0;

            public void onItemChanged(int i) {
                if (i == 0) {
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(GlobalPickerPopup.this.getLatestAvailableTime());
                    GlobalPickerPopup.this.m30659a(instance.get(11));
                    GlobalPickerPopup.this.f40894b.setData(GlobalPickerPopup.this.f40909q);
                    GlobalPickerPopup.this.f40897e.onItemChanged(0);
                } else if (this.lastSelectedDate == 0) {
                    GlobalPickerPopup.this.m30659a(0);
                    GlobalPickerPopup.this.f40894b.setData(GlobalPickerPopup.this.f40909q);
                    GlobalPickerPopup.this.f40897e.onItemChanged(0);
                }
                this.lastSelectedDate = i;
                GlobalPickerPopup.this.f40900h.setContentDescription(GlobalPickerPopup.this.m30661b());
                GlobalPickerPopup.this.f40900h.sendAccessibilityEvent(128);
            }
        };
        this.f40896d = r0;
        this.f40893a.setOnItemSelectedListener(r0);
        this.f40894b.setOnItemSelectedListener(this.f40897e);
        C140754 r02 = new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                GlobalPickerPopup.this.f40900h.setContentDescription(GlobalPickerPopup.this.m30661b());
                GlobalPickerPopup.this.f40900h.sendAccessibilityEvent(128);
            }
        };
        this.f40898f = r02;
        this.f40895c.setOnItemSelectedListener(r02);
        List<String> day = this.f40901i.getDay(getResources(), m30666c(), false);
        if (day != null) {
            this.f40893a.setData(day);
        }
        this.f40893a.setData(day);
        this.f40893a.setSelectedIndex(0);
        this.f40896d.onItemChanged(0);
        this.mRootView.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                long j = 0;
                if (GlobalPickerPopup.this.f40893a.getSelectedIndex() == 0 && GlobalPickerPopup.this.f40894b.getSelectedIndex() == 0) {
                    GlobalPickerPopup.this.f40907o.onTimeSelected(0);
                    return;
                }
                Calendar instance = GlobalPickerPopup.this.f40911s != null ? (Calendar) GlobalPickerPopup.this.f40911s.clone() : Calendar.getInstance();
                instance.add(5, GlobalPickerPopup.this.f40893a.getSelectedIndex());
                String selectedValue = GlobalPickerPopup.this.f40895c.getSelectedValue();
                String selectedValue2 = GlobalPickerPopup.this.f40894b.getSelectedValue();
                if (TextUtil.isDigit(selectedValue) && TextUtil.isDigit(selectedValue2)) {
                    instance.set(12, Integer.valueOf(selectedValue).intValue());
                    instance.set(11, Integer.valueOf(selectedValue2).intValue());
                    j = instance.getTimeInMillis();
                }
                GlobalPickerPopup.this.f40907o.onTimeSelected(j);
            }
        });
        m30658a();
    }

    /* renamed from: a */
    private void m30658a() {
        if (this.f40906n != 0) {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(this.f40906n);
            instance.setTimeInMillis(getLatestAvailableTime());
            int i = 0;
            while (true) {
                if (i >= this.f40893a.getData().size()) {
                    break;
                } else if (instance.get(5) == instance2.get(5)) {
                    this.f40893a.setSelectedIndex(i);
                    this.f40896d.onItemChanged(i);
                    break;
                } else {
                    instance.add(5, 1);
                    i++;
                }
            }
            int i2 = instance2.get(11);
            int i3 = instance2.get(12);
            int i4 = 0;
            while (true) {
                if (i4 >= this.f40894b.getData().size()) {
                    break;
                }
                if (this.f40894b.getData().get(i4).equals(i2 + "")) {
                    this.f40894b.setSelectedIndex(i4);
                    this.f40897e.onItemChanged(i4);
                    if (i4 != 0) {
                        this.f40895c.setVisibility(0);
                    }
                } else {
                    i4++;
                }
            }
            int i5 = ((i3 % 100) / 10) * 10;
            for (int i6 = 0; i6 < this.f40895c.getData().size(); i6++) {
                if (this.f40895c.getData().get(i6).equals(i5 + "")) {
                    this.f40895c.setSelectedIndex(i6);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m30661b() {
        String selectedValue = this.f40893a.getSelectedValue();
        String selectedValue2 = this.f40894b.getSelectedValue();
        String selectedValue3 = this.f40895c.getSelectedValue();
        String str = selectedValue + selectedValue2 + getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min);
        if (this.f40895c.getVisibility() == 0) {
            return str;
        }
        return str.replace(getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min), "");
    }

    public void setTimeListener(TimePickerPopup.OnTimeSelectedListener onTimeSelectedListener) {
        this.f40907o = onTimeSelectedListener;
    }

    public void setBeginHourInDay(int i) {
        this.f40901i.setBeginHourInDay(i);
    }

    public void setBeginMinInDay(int i) {
        this.f40901i.setBeginMinInDay(i);
    }

    public void setEndHourInDay(int i) {
        this.f40901i.setEndHourInDay(i);
    }

    public void setLastSelectedTime(long j) {
        this.f40906n = j;
    }

    public void setAppointmentDay(int i) {
        if (i > 0) {
            this.f40901i.setAppointmentDay(i);
            return;
        }
        throw new IllegalArgumentException("appointmentDay can not negative");
    }

    public void setEarliestDelta(int i) {
        if (i >= 0) {
            this.f40901i.setEarliestDelta(i);
            return;
        }
        throw new IllegalArgumentException("earliestDelta can not negative");
    }

    public long getLatestAvailableTime() {
        return this.f40901i.getLatestAvailableTime();
    }

    public void setTitle(CharSequence charSequence) {
        this.f40908p = charSequence;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30659a(int i) {
        this.f40909q = this.f40901i.getHour(i);
        if (this.f40893a.getSelectedIndex() == 0) {
            this.f40909q.add(0, getResources().getString(R.string.now));
        }
        this.f40894b.setData(this.f40909q);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30663b(int i) {
        List<String> minute = this.f40901i.getMinute(i);
        this.f40910r = minute;
        this.f40895c.setData(minute);
    }

    /* renamed from: c */
    private String[] m30666c() {
        LinkedList linkedList = new LinkedList();
        Calendar instance = Calendar.getInstance();
        int i = 0;
        while (i < 3) {
            instance.setTimeInMillis(System.currentTimeMillis() + ((long) (i * 24 * 3600 * 1000)));
            if (i == 0) {
                Calendar calendar = (Calendar) instance.clone();
                this.f40911s = calendar;
                calendar.add(12, 30);
            }
            linkedList.add(TimeStrategy.formatTimeMillionsToMonthDayWeek(getResources(), instance, ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale(), i == 0));
            i++;
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }
}
