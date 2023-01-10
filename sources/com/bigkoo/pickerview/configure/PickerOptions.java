package com.bigkoo.pickerview.configure;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.contrarywind.view.WheelView;
import com.taxis99.R;
import java.util.Calendar;

public class PickerOptions {
    public static final int TYPE_PICKER_OPTIONS = 1;
    public static final int TYPE_PICKER_TIME = 2;

    /* renamed from: a */
    private static final int f2075a = -16417281;

    /* renamed from: b */
    private static final int f2076b = -657931;

    /* renamed from: c */
    private static final int f2077c = -16777216;

    /* renamed from: d */
    private static final int f2078d = -1;
    public int bgColorTitle = f2076b;
    public int bgColorWheel = -1;
    public View.OnClickListener cancelListener;
    public boolean cancelable = true;
    public Context context;
    public CustomListener customListener;
    public boolean cyclic = false;
    public boolean cyclic1 = false;
    public boolean cyclic2 = false;
    public boolean cyclic3 = false;
    public Calendar date;
    public ViewGroup decorView;
    public int dividerColor = -2763307;
    public WheelView.DividerType dividerType = WheelView.DividerType.FILL;
    public Calendar endDate;
    public int endYear;
    public Typeface font = Typeface.MONOSPACE;
    public boolean isAlphaGradient = false;
    public boolean isCenterLabel = false;
    public boolean isDialog;
    public boolean isLunarCalendar = false;
    public boolean isRestoreItem = false;
    public int itemsVisibleCount = 9;
    public String label1;
    public String label2;
    public String label3;
    public String label_day;
    public String label_hours;
    public String label_minutes;
    public String label_month;
    public String label_seconds;
    public String label_year;
    public int layoutRes;
    public float lineSpacingMultiplier = 1.6f;
    public int option1;
    public int option2;
    public int option3;
    public OnOptionsSelectChangeListener optionsSelectChangeListener;
    public OnOptionsSelectListener optionsSelectListener;
    public int outSideColor = -1;
    public Calendar startDate;
    public int startYear;
    public int textColorCancel = f2075a;
    public int textColorCenter = -14013910;
    public int textColorConfirm = f2075a;
    public int textColorOut = -5723992;
    public int textColorTitle = -16777216;
    public String textContentCancel;
    public String textContentConfirm;
    public String textContentTitle;
    public int textGravity = 17;
    public int textSizeContent = 18;
    public int textSizeSubmitCancel = 17;
    public int textSizeTitle = 18;
    public OnTimeSelectChangeListener timeSelectChangeListener;
    public OnTimeSelectListener timeSelectListener;
    public boolean[] type = {true, true, true, false, false, false};
    public int x_offset_day;
    public int x_offset_hours;
    public int x_offset_minutes;
    public int x_offset_month;
    public int x_offset_one;
    public int x_offset_seconds;
    public int x_offset_three;
    public int x_offset_two;
    public int x_offset_year;

    public PickerOptions(int i) {
        if (i == 1) {
            this.layoutRes = R.layout.pickerview_options;
        } else {
            this.layoutRes = R.layout.pickerview_time;
        }
    }
}
