package com.didi.rfusion.widget.calendar;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
final class RFCalendar$initActionsToMonthNavigation$4 implements View.OnClickListener {
    final /* synthetic */ RFMonthsPagerAdapter $monthsPagerAdapter;
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$initActionsToMonthNavigation$4(RFCalendar rFCalendar, RFMonthsPagerAdapter rFMonthsPagerAdapter) {
        this.this$0 = rFCalendar;
        this.$monthsPagerAdapter = rFMonthsPagerAdapter;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int findLastVisibleItemPosition = this.this$0.getLayoutManager().findLastVisibleItemPosition() - 1;
        if (findLastVisibleItemPosition >= 0) {
            this.this$0.setCurrentMonth$r_fusion_ninePhoneRelease(this.$monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition));
        }
    }
}
