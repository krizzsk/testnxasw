package com.didi.rfusion.widget.calendar;

import android.view.View;
import android.widget.AdapterView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.rfusion.widget.calendar.RFCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, mo148868d2 = {"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position1", "", "id", "", "onItemClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFMonthsPagerAdapter.kt */
final class RFMonthsPagerAdapter$onBindViewHolder$1 implements AdapterView.OnItemClickListener {
    final /* synthetic */ RFCalendarGridView $monthGrid;
    final /* synthetic */ RFMonthsPagerAdapter this$0;

    RFMonthsPagerAdapter$onBindViewHolder$1(RFMonthsPagerAdapter rFMonthsPagerAdapter, RFCalendarGridView rFCalendarGridView) {
        this.this$0 = rFMonthsPagerAdapter;
        this.$monthGrid = rFCalendarGridView;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        if (this.$monthGrid.getAdapter().mo94097d(i)) {
            RFCalendar.OnDayClickListener access$getOnDayClickListener$p = this.this$0.f36223b;
            Long a = this.$monthGrid.getAdapter().getItem(i);
            if (a == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(a, "monthGrid.adapter.getItem(position1)!!");
            access$getOnDayClickListener$p.onDayClick(a.longValue());
        }
    }
}
