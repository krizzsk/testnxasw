package com.didi.rfusion.widget.calendar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import com.didi.rfusion.widget.calendar.RFCalendarItemStyle;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/rfusion/widget/calendar/RFCalendarStyle;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "day", "Lcom/didi/rfusion/widget/calendar/RFCalendarItemStyle;", "getDay", "()Lcom/didi/rfusion/widget/calendar/RFCalendarItemStyle;", "invalidDay", "getInvalidDay", "rangeFill", "Landroid/graphics/Paint;", "getRangeFill", "()Landroid/graphics/Paint;", "selectedDay", "getSelectedDay", "selectedYear", "getSelectedYear", "todayDay", "getTodayDay", "todayYear", "getTodayYear", "year", "getYear", "r-fusion_ninePhoneRelease"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: RFCalendarStyle.kt */
public final class RFCalendarStyle {

    /* renamed from: a */
    private final RFCalendarItemStyle f36204a;

    /* renamed from: b */
    private final RFCalendarItemStyle f36205b;

    /* renamed from: c */
    private final RFCalendarItemStyle f36206c;

    /* renamed from: d */
    private final RFCalendarItemStyle f36207d;

    /* renamed from: e */
    private final RFCalendarItemStyle f36208e;

    /* renamed from: f */
    private final RFCalendarItemStyle f36209f;

    /* renamed from: g */
    private final RFCalendarItemStyle f36210g;

    /* renamed from: h */
    private final Paint f36211h;

    public RFCalendarStyle(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        RFCalendarItemStyle.Companion companion = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList, "context.resources.getCol…_color_white_100_alpha_0)");
        ColorStateList colorStateList2 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList2, "context.resources.getCol…rf_color_gery_1_0_000000)");
        ColorStateList colorStateList3 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList3, "context.resources.getCol…_color_white_100_alpha_0)");
        this.f36204a = companion.create$r_fusion_ninePhoneRelease(colorStateList, colorStateList2, colorStateList3, 1, context.getResources().getDimension(R.dimen.rf_calendar_day_width), new Rect(0, 0, 0, 0));
        RFCalendarItemStyle.Companion companion2 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList4 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList4, "context.resources.getCol…_color_white_100_alpha_0)");
        ColorStateList colorStateList5 = context.getResources().getColorStateList(R.color.rf_color_gery_4_80_CCCCCC);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList5, "context.resources.getCol…f_color_gery_4_80_CCCCCC)");
        ColorStateList colorStateList6 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList6, "context.resources.getCol…_color_white_100_alpha_0)");
        this.f36210g = companion2.create$r_fusion_ninePhoneRelease(colorStateList4, colorStateList5, colorStateList6, 1, context.getResources().getDimension(R.dimen.rf_calendar_day_width), new Rect(0, 0, 0, 0));
        RFCalendarItemStyle.Companion companion3 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList7 = context.getResources().getColorStateList(R.color.rf_color_brands_1_100);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList7, "context.resources.getCol…or.rf_color_brands_1_100)");
        ColorStateList colorStateList8 = context.getResources().getColorStateList(R.color.rf_color_white_100_FFFFFF);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList8, "context.resources.getCol…f_color_white_100_FFFFFF)");
        ColorStateList colorStateList9 = context.getResources().getColorStateList(R.color.rf_color_brands_1_100);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList9, "context.resources.getCol…or.rf_color_brands_1_100)");
        this.f36205b = companion3.create$r_fusion_ninePhoneRelease(colorStateList7, colorStateList8, colorStateList9, 1, context.getResources().getDimension(R.dimen.rf_calendar_day_width), new Rect(0, 0, 0, 0));
        RFCalendarItemStyle.Companion companion4 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList10 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList10, "context.resources.getCol…_color_white_100_alpha_0)");
        ColorStateList colorStateList11 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList11, "context.resources.getCol…rf_color_gery_1_0_000000)");
        ColorStateList colorStateList12 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList12, "context.resources.getCol…rf_color_gery_1_0_000000)");
        this.f36206c = companion4.create$r_fusion_ninePhoneRelease(colorStateList10, colorStateList11, colorStateList12, 1, context.getResources().getDimension(R.dimen.rf_calendar_day_width), new Rect(0, 0, 0, 0));
        ColorStateList colorStateList13 = context.getResources().getColorStateList(R.color.rf_color_background_1_100);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList13, "context.resources.getCol…f_color_background_1_100)");
        RFCalendarItemStyle.Companion companion5 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList14 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList14, "context.resources.getCol…_color_white_100_alpha_0)");
        ColorStateList colorStateList15 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList15, "context.resources.getCol…rf_color_gery_1_0_000000)");
        ColorStateList colorStateList16 = context.getResources().getColorStateList(R.color.rf_color_white_100_FFFFFF);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList16, "context.resources.getCol…f_color_white_100_FFFFFF)");
        this.f36207d = companion5.create$r_fusion_ninePhoneRelease(colorStateList14, colorStateList15, colorStateList16, 1, context.getResources().getDimension(R.dimen.rf_dimen_36), new Rect(0, 0, 0, 0));
        RFCalendarItemStyle.Companion companion6 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList17 = context.getResources().getColorStateList(R.color.rf_color_brands_1_100);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList17, "context.resources.getCol…or.rf_color_brands_1_100)");
        ColorStateList colorStateList18 = context.getResources().getColorStateList(R.color.rf_color_white_100_FFFFFF);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList18, "context.resources.getCol…f_color_white_100_FFFFFF)");
        ColorStateList colorStateList19 = context.getResources().getColorStateList(R.color.rf_color_brands_1_100);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList19, "context.resources.getCol…or.rf_color_brands_1_100)");
        this.f36208e = companion6.create$r_fusion_ninePhoneRelease(colorStateList17, colorStateList18, colorStateList19, 1, context.getResources().getDimension(R.dimen.rf_dimen_36), new Rect(0, 0, 0, 0));
        RFCalendarItemStyle.Companion companion7 = RFCalendarItemStyle.Companion;
        ColorStateList colorStateList20 = context.getResources().getColorStateList(R.color.rf_color_white_100_alpha_0);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList20, "context.resources.getCol…_color_white_100_alpha_0)");
        ColorStateList colorStateList21 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList21, "context.resources.getCol…rf_color_gery_1_0_000000)");
        ColorStateList colorStateList22 = context.getResources().getColorStateList(R.color.rf_color_gery_1_0_000000);
        Intrinsics.checkExpressionValueIsNotNull(colorStateList22, "context.resources.getCol…rf_color_gery_1_0_000000)");
        this.f36209f = companion7.create$r_fusion_ninePhoneRelease(colorStateList20, colorStateList21, colorStateList22, 1, context.getResources().getDimension(R.dimen.rf_dimen_36), new Rect(0, 0, 0, 0));
        Paint paint = new Paint();
        this.f36211h = paint;
        paint.setColor(colorStateList13.getDefaultColor());
    }

    public final RFCalendarItemStyle getDay() {
        return this.f36204a;
    }

    public final RFCalendarItemStyle getSelectedDay() {
        return this.f36205b;
    }

    public final RFCalendarItemStyle getTodayDay() {
        return this.f36206c;
    }

    public final RFCalendarItemStyle getYear() {
        return this.f36207d;
    }

    public final RFCalendarItemStyle getSelectedYear() {
        return this.f36208e;
    }

    public final RFCalendarItemStyle getTodayYear() {
        return this.f36209f;
    }

    public final RFCalendarItemStyle getInvalidDay() {
        return this.f36210g;
    }

    public final Paint getRangeFill() {
        return this.f36211h;
    }
}
