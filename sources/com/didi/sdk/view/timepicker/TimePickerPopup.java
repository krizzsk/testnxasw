package com.didi.sdk.view.timepicker;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.log.Logger;
import com.didi.sdk.log.Printer;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.sdk.view.TimePickerMode;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.didi.sdk.view.titlebar.CommonPopupTitleBar;
import com.didi.sdk.view.wheel.Wheel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Deprecated
public class TimePickerPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f40912a = "miracle-debug";

    /* renamed from: b */
    private static final int f40913b = 0;

    /* renamed from: c */
    private static final int f40914c = 1;

    /* renamed from: d */
    private Wheel f40915d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Wheel f40916e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Wheel f40917f;

    /* renamed from: g */
    private String[] f40918g;

    /* renamed from: h */
    private boolean f40919h = false;

    /* renamed from: i */
    private OnTimeSelectedListener f40920i;

    /* renamed from: j */
    private long f40921j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f40922k;

    /* renamed from: l */
    private Locale f40923l = ProductControllerStyleManager.getInstance().getLocaleDelegate().getLocale();

    /* renamed from: m */
    private CommonPopupTitleBar f40924m;

    /* renamed from: n */
    private CharSequence f40925n;

    /* renamed from: o */
    private String f40926o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TimePickerView f40927p;

    /* renamed from: q */
    private View.OnClickListener f40928q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public View.OnClickListener f40929r;

    /* renamed from: s */
    private TimeStrategy f40930s = new TimeStrategy();

    /* renamed from: t */
    private TextView f40931t;

    /* renamed from: u */
    private TextView f40932u;

    /* renamed from: v */
    private View f40933v;

    public interface OnTimeSelectedListener {
        void onTimeSelected(long j);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.timepicker_popup;
    }

    public CommonPopupTitleBar getmTitleBar() {
        return this.f40924m;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        m30671a();
        m30674a(this.mRootView);
        m30690f();
    }

    public void setConfirmListener(View.OnClickListener onClickListener) {
        this.f40928q = onClickListener;
    }

    public void setCancelListener(View.OnClickListener onClickListener) {
        this.f40929r = onClickListener;
    }

    public void setEarliestDelta(int i) {
        if (i >= 0) {
            this.f40930s.setEarliestDelta(i);
            return;
        }
        throw new IllegalArgumentException("earliestDelta can not negative");
    }

    public void setTitle(CharSequence charSequence) {
        CommonPopupTitleBar commonPopupTitleBar = this.f40924m;
        if (commonPopupTitleBar == null || charSequence == null) {
            this.f40925n = charSequence;
        } else {
            commonPopupTitleBar.setTitle(charSequence.toString());
        }
    }

    public void setMessage(String str) {
        if (this.f40924m == null || TextUtils.isEmpty(str)) {
            this.f40926o = str;
        } else {
            this.f40924m.setMessage(str);
        }
    }

    public void setLastSelectedTime(long j) {
        this.f40921j = j;
    }

    public void setBeginHourInDay(int i) {
        this.f40930s.setBeginHourInDay(i);
    }

    public void setBeginMinInDay(int i) {
        this.f40930s.setBeginMinInDay(i);
    }

    public void setEndHourInDay(int i) {
        this.f40930s.setEndHourInDay(i);
    }

    public void setEndMinInDay(int i) {
        this.f40930s.setEndMinInDay(i);
    }

    /* renamed from: a */
    private void m30671a() {
        this.f40918g = m30681b();
    }

    /* renamed from: b */
    private String[] m30681b() {
        LinkedList linkedList = new LinkedList();
        if (this.f40922k) {
            linkedList.add(getResources().getString(R.string.now));
        }
        Calendar instance = Calendar.getInstance();
        int i = 0;
        while (i < 3) {
            instance.setTimeInMillis(System.currentTimeMillis() + ((long) (i * 24 * 3600 * 1000)));
            linkedList.add(TimeStrategy.formatTimeMillionsToMonthDayWeek(getResources(), instance, this.f40923l, i == 0));
            i++;
        }
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public void setIsSupportNow(boolean z) {
        this.f40922k = z;
        this.f40930s.setIsSupportNow(z);
    }

    public void setAppointmentDay(int i) {
        if (i > 0) {
            this.f40930s.setAppointmentDay(i);
            return;
        }
        throw new IllegalArgumentException("appointmentDay can not negative");
    }

    /* renamed from: a */
    private void m30674a(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.dismiss();
            }
        });
        this.f40924m = (CommonPopupTitleBar) view.findViewById(R.id.title_bar);
        this.f40931t = (TextView) view.findViewById(R.id.title_bar2);
        this.f40933v = view.findViewById(R.id.rl_root);
        View findViewById = view.findViewById(R.id.containertitle_bar);
        CharSequence charSequence = this.f40925n;
        if (charSequence != null) {
            this.f40924m.setTitle(charSequence.toString());
            this.f40931t.setText(this.f40925n.toString());
        }
        if (!TextUtils.isEmpty(this.f40926o)) {
            this.f40924m.setMessage(this.f40926o);
        }
        this.f40924m.setRight(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.m30679b(view);
            }
        });
        this.f40932u = (TextView) view.findViewById(R.id.tv_confirm2);
        if (ProductControllerStyleManager.getInstance().getProductThemeStyle().getTimePickerMode() == TimePickerMode.Global) {
            this.f40924m.setVisibility(8);
            this.f40932u.setVisibility(0);
            findViewById.setVisibility(0);
            this.f40933v.setBackgroundResource(R.drawable.globalcommon_dialog_bg_shape);
        } else {
            this.f40924m.setVisibility(0);
            this.f40932u.setVisibility(8);
            findViewById.setVisibility(8);
            this.f40933v.setBackgroundResource(R.drawable.common_dialog_bg);
        }
        view.findViewById(R.id.tv_confirm2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TimePickerPopup.this.m30679b(view);
            }
        });
        this.f40924m.setLeft(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TraceLogUtil.addLogWithTab("theone_ppx_call01_ck", new String[0]);
                if (TimePickerPopup.this.f40929r != null) {
                    TimePickerPopup.this.f40929r.onClick(view);
                }
                TimePickerPopup.this.dismiss();
            }
        });
        this.f40927p = (TimePickerView) view.findViewById(R.id.time_picker);
        this.f40915d = (Wheel) view.findViewById(R.id.day_picker);
        this.f40916e = (Wheel) view.findViewById(R.id.hour_picker);
        this.f40917f = (Wheel) view.findViewById(R.id.minute_picker);
        this.f40915d.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    if (!TimePickerPopup.this.f40922k || i != 0) {
                        TimePickerPopup.this.f40916e.setSuffix(TimePickerPopup.this.getString(R.string.time_picker_hour));
                        TimePickerPopup.this.f40917f.setSuffix(TimePickerPopup.this.getString(R.string.time_picker_min));
                        TimePickerPopup.this.m30672a(0);
                    } else {
                        TimePickerPopup.this.f40916e.setSuffix("");
                        TimePickerPopup.this.f40917f.setSuffix("");
                        TimePickerPopup.this.m30687e();
                    }
                    TimePickerPopup.this.f40927p.setContentDescription(TimePickerPopup.this.m30683c());
                    TimePickerPopup.this.f40927p.sendAccessibilityEvent(128);
                }
            }
        });
        this.f40916e.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    TimePickerPopup.this.m30672a(1);
                    TimePickerPopup.this.f40927p.setContentDescription(TimePickerPopup.this.m30683c());
                    TimePickerPopup.this.f40927p.sendAccessibilityEvent(128);
                }
            }
        });
        this.f40917f.setOnItemSelectedListener(new Wheel.OnItemChangedListener() {
            public void onItemChanged(int i) {
                if (TimePickerPopup.this.isAdded()) {
                    TimePickerPopup.this.f40927p.setContentDescription(TimePickerPopup.this.m30683c());
                    TimePickerPopup.this.f40927p.sendAccessibilityEvent(128);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30679b(View view) {
        TraceLogUtil.addLogWithTab("theone_ppx_call02_ck", new String[0]);
        if (this.f40920i != null) {
            m30686d();
        }
        View.OnClickListener onClickListener = this.f40928q;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public String m30683c() {
        String selectedValue = this.f40915d.getSelectedValue();
        String selectedValue2 = this.f40916e.getSelectedValue();
        String selectedValue3 = this.f40917f.getSelectedValue();
        return selectedValue + selectedValue2 + getString(R.string.time_picker_hour) + selectedValue3 + getString(R.string.time_picker_min);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m30686d() {
        /*
            r4 = this;
            java.util.Calendar r0 = java.util.Calendar.getInstance()
            com.didi.sdk.view.wheel.Wheel r1 = r4.f40915d
            int r1 = r1.getSelectedIndex()
            boolean r2 = r4.f40922k
            if (r2 == 0) goto L_0x0010
            if (r1 == 0) goto L_0x0050
        L_0x0010:
            com.didi.sdk.view.wheel.Wheel r1 = r4.f40915d
            int r1 = r1.getSelectedIndex()
            r4.m30677a((java.util.Calendar) r0, (int) r1)
            com.didi.sdk.view.wheel.Wheel r1 = r4.f40917f
            java.lang.String r1 = r1.getSelectedValue()
            com.didi.sdk.view.wheel.Wheel r2 = r4.f40916e
            java.lang.String r2 = r2.getSelectedValue()
            boolean r3 = com.didi.sdk.util.TextUtil.isDigit(r1)
            if (r3 == 0) goto L_0x0050
            boolean r3 = com.didi.sdk.util.TextUtil.isDigit(r2)
            if (r3 == 0) goto L_0x0050
            r3 = 12
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r1 = r1.intValue()
            r0.set(r3, r1)
            r1 = 11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r2 = r2.intValue()
            r0.set(r1, r2)
            long r0 = r0.getTimeInMillis()
            goto L_0x0052
        L_0x0050:
            r0 = 0
        L_0x0052:
            com.didi.sdk.view.timepicker.TimePickerPopup$OnTimeSelectedListener r2 = r4.f40920i
            if (r2 == 0) goto L_0x0059
            r2.onTimeSelected(r0)
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.view.timepicker.TimePickerPopup.m30686d():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m30687e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.time_picker_now));
        this.f40916e.setData(arrayList);
        this.f40917f.setData(arrayList);
        this.f40916e.setSelectedIndex(0);
        this.f40917f.setSelectedIndex(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30672a(int i) {
        String selectedValue = this.f40916e.getSelectedValue();
        String selectedValue2 = this.f40917f.getSelectedValue();
        if (i == 0 && getString(R.string.time_picker_now).equals(selectedValue)) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(getLatestAvailableTime());
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(System.currentTimeMillis());
            m30677a(instance2, this.f40915d.getSelectedIndex());
            instance2.set(11, instance.get(11));
            instance2.set(12, instance.get(12));
            m30673a(instance.get(11), instance.get(12), instance2);
        } else if (!getString(R.string.time_picker_now).equals(selectedValue) && TextUtil.isDigit(selectedValue) && TextUtil.isDigit(selectedValue2)) {
            Calendar instance3 = Calendar.getInstance();
            m30677a(instance3, this.f40915d.getSelectedIndex());
            instance3.set(12, Integer.valueOf(selectedValue2).intValue());
            instance3.set(11, Integer.valueOf(selectedValue).intValue());
            if (isInvalid(instance3.getTimeInMillis())) {
                m30694i();
                this.f40915d.setSelectedIndex(this.f40922k ? 1 : 0);
                return;
            }
            m30673a(Integer.valueOf(selectedValue).intValue(), Integer.valueOf(selectedValue2).intValue(), instance3);
        }
    }

    /* renamed from: a */
    private void m30677a(Calendar calendar, int i) {
        calendar.add(5, this.f40922k ? ((m30691g() - 1) + i) - 1 : (m30691g() - 1) + i);
    }

    /* renamed from: a */
    private void m30673a(int i, int i2, Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        int i3 = this.f40922k;
        while (true) {
            if (i3 >= this.f40915d.getData().size()) {
                break;
            } else if (instance.get(5) == calendar.get(5)) {
                this.f40915d.setSelectedIndex(i3);
                break;
            } else {
                instance.add(5, 1);
                i3++;
            }
        }
        instance.setTimeInMillis(getLatestAvailableTime());
        if (instance.get(5) == calendar.get(5)) {
            int i4 = instance.get(11);
            m30678b(i4);
            int intValue = Integer.valueOf(this.f40916e.getSelectedValue()).intValue() - Integer.valueOf(i).intValue();
            if (intValue < 0) {
                this.f40916e.setSelectedIndex(-intValue);
            }
            if (i4 == calendar.get(11)) {
                m30684c(instance.get(12));
            } else {
                m30684c(0);
            }
            int intValue2 = Integer.valueOf(this.f40917f.getSelectedValue()).intValue() - Integer.valueOf(i2).intValue();
            if (intValue2 < 0) {
                this.f40917f.setSelectedIndex((-intValue2) / 10);
                return;
            }
            return;
        }
        m30678b(0);
        m30684c(0);
        int intValue3 = Integer.valueOf(this.f40916e.getSelectedValue()).intValue() - Integer.valueOf(i).intValue();
        if (intValue3 < 0) {
            this.f40916e.setSelectedIndex(-intValue3);
        }
        int intValue4 = Integer.valueOf(this.f40917f.getSelectedValue()).intValue() - Integer.valueOf(i2).intValue();
        if (intValue4 < 0) {
            this.f40917f.setSelectedIndex((-intValue4) / 10);
        }
    }

    public void setTimeListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.f40920i = onTimeSelectedListener;
    }

    public long getLatestAvailableTime() {
        return this.f40930s.getLatestAvailableTime();
    }

    /* renamed from: f */
    private void m30690f() {
        long j = this.f40921j;
        if (j != 0 && !isInvalid(j)) {
            this.f40916e.setSuffix(getString(R.string.time_picker_hour));
            this.f40917f.setSuffix(getString(R.string.time_picker_min));
            m30694i();
            long j2 = this.f40921j;
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            m30673a(instance.get(11), instance.get(12), instance);
        } else if (this.f40921j == 0 && this.f40922k) {
            m30693h();
            m30687e();
        } else if (isInvalid(this.f40921j)) {
            this.f40916e.setSuffix(getString(R.string.time_picker_hour));
            this.f40917f.setSuffix(getString(R.string.time_picker_min));
            m30694i();
            this.f40915d.setSelectedIndex(this.f40922k ? 1 : 0);
        }
        this.f40927p.setContentDescription(m30683c());
    }

    /* renamed from: b */
    private void m30678b(int i) {
        List<String> hour = this.f40930s.getHour(i);
        Printer t = Logger.m29541t(f40912a);
        t.mo98893d("init hours = " + hour.toString(), new Object[0]);
        this.f40916e.setData(hour);
    }

    /* renamed from: c */
    private void m30684c(int i) {
        List<String> minute = this.f40930s.getMinute(i);
        Printer t = Logger.m29541t(f40912a);
        t.mo98893d("init minutes = " + minute.toString(), new Object[0]);
        this.f40917f.setData(minute);
    }

    public boolean isInvalid(long j) {
        return this.f40930s.isInvalid(j);
    }

    /* renamed from: g */
    private int m30691g() {
        return this.f40930s.getEarliesDay();
    }

    /* renamed from: h */
    private void m30693h() {
        List<String> day = this.f40930s.getDay(getResources(), this.f40918g, this.f40922k);
        if (day != null) {
            this.f40915d.setData(day);
        }
    }

    /* renamed from: i */
    private void m30694i() {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(getLatestAvailableTime());
        int i = instance.get(11);
        int i2 = instance.get(12);
        m30693h();
        m30678b(i);
        m30684c(i2);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}
