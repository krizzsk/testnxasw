package com.didi.global.globaluikit.datepicker.time;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.global.globaluikit.datepicker.LEGOWheelPicker;
import com.global.didi.elvish.Elvish;
import java.text.NumberFormat;
import java.util.ArrayList;

public class LEGOHourPicker extends LEGOWheelPicker<C9240b> {
    public static final int sBeginHourInDay = 0;
    public static final int sEndHourInDay = 23;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnHourSelectedListener f24382a;

    /* renamed from: b */
    private int f24383b;

    /* renamed from: c */
    private int f24384c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C9240b f24385d;

    /* renamed from: e */
    private boolean f24386e;

    public interface OnHourSelectedListener {
        void onHourSelected(int i);
    }

    public LEGOHourPicker(Context context) {
        this(context, (AttributeSet) null);
    }

    public LEGOHourPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LEGOHourPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f24385d = new C9240b(0);
        m19605a();
        setOnWheelChangeListener(new LEGOWheelPicker.OnWheelChangeListener<C9240b>() {
            public void onWheelSelected(C9240b bVar, int i) {
                C9240b unused = LEGOHourPicker.this.f24385d = bVar;
                if (LEGOHourPicker.this.f24382a != null) {
                    LEGOHourPicker.this.f24382a.onHourSelected(bVar.mo72114a());
                }
            }
        });
    }

    /* renamed from: a */
    private void m19605a() {
        setItemMaximumWidthText(C9239a.f24393b);
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(2);
        setDataFormat(numberInstance);
        this.f24383b = 0;
        this.f24384c = 23;
        this.f24385d = new C9240b(Elvish.Companion.getInstance().getDateTimeCalendar(System.currentTimeMillis()).get(11));
        updateHour();
    }

    public void updateHour(boolean z) {
        ArrayList arrayList = new ArrayList();
        C9240b bVar = new C9240b(-1);
        if (this.f24386e && !z) {
            arrayList.add(bVar);
        }
        int i = this.f24383b;
        if (i != this.f24384c) {
            while (i <= this.f24384c) {
                arrayList.add(new C9240b(i));
                i++;
            }
        } else if (i != bVar.mo72114a()) {
            arrayList.add(new C9240b(this.f24383b));
        }
        setDataList(arrayList);
    }

    public void updateHour() {
        updateHour(false);
    }

    public int getSelectedHour() {
        return this.f24385d.mo72114a();
    }

    public void setBeginHourInDay(int i, boolean z, boolean z2) {
        this.f24386e = z;
        this.f24383b = i;
        C9240b bVar = this.f24385d;
        if (z) {
            i = -1;
        }
        bVar.mo72115a(i);
        if (z2) {
            this.f24385d.mo72115a(this.f24383b);
        }
    }

    public void setEndHourInDay(int i) {
        this.f24384c = i;
    }

    public void setSelectedHour(int i) {
        setSelectedHour(i, false);
    }

    public void setSelectedHour(int i, boolean z) {
        this.f24385d.mo72115a(i);
        setCurrentItem(this.f24385d, z);
    }

    public void setOnHourSelectedListener(OnHourSelectedListener onHourSelectedListener) {
        this.f24382a = onHourSelectedListener;
    }
}
