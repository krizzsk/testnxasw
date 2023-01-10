package com.didi.component.comp_selectseat.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.GLog;
import com.didi.component.comp_selectseat.model.ScheduleItemModel;
import com.didi.component.comp_selectseat.model.ShiftBean;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleViewHolder> {

    /* renamed from: a */
    private static final String f14224a = "ScheduleAdapter";

    /* renamed from: b */
    private final Context f14225b;

    /* renamed from: c */
    private final List<ScheduleItemModel> f14226c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final FrequencySelectClickListener f14227d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final List<Boolean> f14228e = new ArrayList();

    public ScheduleAdapter(Context context, FrequencySelectClickListener frequencySelectClickListener) {
        this.f14225b = context;
        this.f14227d = frequencySelectClickListener;
    }

    public int getItemViewType(int i) {
        return this.f14226c.get(i).getViewType();
    }

    public ScheduleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ScheduleViewHolder(LayoutInflater.from(this.f14225b).inflate(i == ScheduleItemModel.ITEM_TYPE_TITLE ? R.layout.schedule_title_layout : R.layout.schedule_shift_layout, viewGroup, false), i);
    }

    public void onBindViewHolder(ScheduleViewHolder scheduleViewHolder, final int i) {
        ScheduleItemModel scheduleItemModel = this.f14226c.get(i);
        if (scheduleItemModel == null) {
            m11801a("getShiftsBean is null");
        } else if (scheduleItemModel.getViewType() != ScheduleItemModel.ITEM_TYPE_TITLE) {
            if (this.f14228e.get(i).booleanValue()) {
                scheduleViewHolder.mSelectedIcon.setImageResource(R.drawable.icon_minibus_selected);
            } else {
                scheduleViewHolder.mSelectedIcon.setImageResource(R.drawable.icon_minibus_unselected);
            }
            if (scheduleItemModel.getShiftsBean() != null) {
                final ShiftBean shiftsBean = scheduleItemModel.getShiftsBean();
                if (shiftsBean.pickup == null || TextUtils.isEmpty(shiftsBean.pickup.getContent())) {
                    m11801a("pickup is null");
                } else {
                    shiftsBean.pickup.bindTextView(scheduleViewHolder.mPickup);
                }
                if (shiftsBean.dropoff == null || TextUtils.isEmpty(shiftsBean.dropoff.getContent())) {
                    m11801a("dropoff is null");
                } else {
                    shiftsBean.dropoff.bindTextView(scheduleViewHolder.mDropOff);
                }
                if (shiftsBean.show_travel_mark == 0) {
                    scheduleViewHolder.mStartIcon.setVisibility(8);
                } else {
                    scheduleViewHolder.mStartIcon.setVisibility(0);
                }
                scheduleViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (((Boolean) ScheduleAdapter.this.f14228e.get(i)).booleanValue()) {
                            ScheduleAdapter.this.m11799a(i, false);
                            ScheduleAdapter.this.f14227d.onFrequencySelectClick(false, shiftsBean, i);
                            return;
                        }
                        ScheduleAdapter.this.m11799a(i, true);
                        ScheduleAdapter.this.f14227d.onFrequencySelectClick(true, shiftsBean, i);
                    }
                });
                return;
            }
            m11801a("etTitleBean() is null or content is null");
        } else if (scheduleItemModel.getTitleBean() == null || TextUtils.isEmpty(scheduleItemModel.getTitleBean().getContent())) {
            m11801a("etTitleBean() is null or content is null");
        } else {
            scheduleItemModel.getTitleBean().bindTextView(scheduleViewHolder.mTitle);
        }
    }

    /* renamed from: a */
    private void m11801a(String str) {
        GLog.m11357e(f14224a, str);
    }

    public int getItemCount() {
        return this.f14226c.size();
    }

    public void setDate(List<ScheduleItemModel> list) {
        this.f14226c.clear();
        this.f14226c.addAll(list);
        m11799a(0, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11799a(int i, boolean z) {
        this.f14228e.clear();
        for (int i2 = 0; i2 < this.f14226c.size(); i2++) {
            this.f14228e.add(false);
        }
        if (z) {
            this.f14228e.set(i, true);
        }
        notifyDataSetChanged();
    }
}
