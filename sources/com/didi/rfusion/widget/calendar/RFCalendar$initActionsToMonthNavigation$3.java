package com.didi.rfusion.widget.calendar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo148868d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: RFCalendar.kt */
final class RFCalendar$initActionsToMonthNavigation$3 implements View.OnClickListener {
    final /* synthetic */ RFMonthsPagerAdapter $monthsPagerAdapter;
    final /* synthetic */ RFCalendar this$0;

    RFCalendar$initActionsToMonthNavigation$3(RFCalendar rFCalendar, RFMonthsPagerAdapter rFMonthsPagerAdapter) {
        this.this$0 = rFCalendar;
        this.$monthsPagerAdapter = rFMonthsPagerAdapter;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int findFirstVisibleItemPosition = this.this$0.getLayoutManager().findFirstVisibleItemPosition() + 1;
        RecyclerView.Adapter adapter = RFCalendar.access$getRvMonths$p(this.this$0).getAdapter();
        if (adapter == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(adapter, "rvMonths.adapter!!");
        if (findFirstVisibleItemPosition < adapter.getItemCount()) {
            this.this$0.setCurrentMonth$r_fusion_ninePhoneRelease(this.$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
        }
    }
}
