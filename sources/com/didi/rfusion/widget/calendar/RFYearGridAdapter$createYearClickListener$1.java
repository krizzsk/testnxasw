package com.didi.rfusion.widget.calendar;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.rfusion.widget.calendar.RFCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFYearGridAdapter.kt */
final class RFYearGridAdapter$createYearClickListener$1 implements View.OnClickListener {
    final /* synthetic */ int $year;
    final /* synthetic */ RFYearGridAdapter this$0;

    RFYearGridAdapter$createYearClickListener$1(RFYearGridAdapter rFYearGridAdapter, int i) {
        this.this$0 = rFYearGridAdapter;
        this.$year = i;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Month a = Month.m27200a(this.$year, this.this$0.f36229a.getCurrentMonth$r_fusion_ninePhoneRelease().f36160a);
        Intrinsics.checkExpressionValueIsNotNull(a, "Month.create(year, mater….getCurrentMonth().month)");
        Month b = this.this$0.f36229a.getCalendarConstraints().mo93990b(a);
        RFCalendar access$getMaterialCalendar$p = this.this$0.f36229a;
        Intrinsics.checkExpressionValueIsNotNull(b, "moveTo");
        access$getMaterialCalendar$p.setCurrentMonth$r_fusion_ninePhoneRelease(b);
        this.this$0.f36229a.setSelector$r_fusion_ninePhoneRelease(RFCalendar.CalendarSelector.DAY);
    }
}
