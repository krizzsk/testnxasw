package com.didi.map.global.component.trafficreport.view.history;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.trafficreport.model.ContributionData;
import com.didi.map.global.component.trafficreport.model.EventHandleStatus;
import com.didi.map.global.component.trafficreport.util.DisplayUtil;
import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ReportHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int STATE_ERROR = 13;
    public static final int STATE_IDLE = 10;
    public static final int STATE_LOADED_ALL = 12;
    public static final int STATE_LOADING = 11;

    /* renamed from: a */
    private final String f28758a = "ReportHistoryAdapter";

    /* renamed from: b */
    private final Context f28759b;

    /* renamed from: c */
    private boolean f28760c;

    /* renamed from: d */
    private int f28761d;

    /* renamed from: e */
    private final List<ContributionData> f28762e;

    public long getItemId(int i) {
        return (long) i;
    }

    public ReportHistoryAdapter(Context context) {
        this.f28759b = context;
        this.f28762e = new ArrayList();
        this.f28761d = 10;
    }

    public void addContributionData(List<ContributionData> list) {
        List<ContributionData> list2;
        if (list != null && list.size() > 0 && (list2 = this.f28762e) != null) {
            int size = list2.size();
            this.f28762e.addAll(list);
            notifyItemRangeChanged(size + 1, list.size());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.f28759b).inflate(R.layout.layout_report_history_item, viewGroup, false);
        if (ItemType.getByValue(i) == null) {
            return new DataViewHolder(inflate);
        }
        int i2 = C104301.f28763x27e03e6f[ItemType.getByValue(i).ordinal()];
        if (i2 == 1) {
            inflate = LayoutInflater.from(this.f28759b).inflate(R.layout.layout_report_history_header, viewGroup, false);
        } else if (i2 == 2) {
            inflate.setBackground(this.f28759b.getDrawable(R.drawable.report_item_bg_white_top));
        } else if (i2 == 3) {
            inflate.setBackground(this.f28759b.getDrawable(R.drawable.report_item_bg_white));
        } else if (i2 != 4) {
            inflate.setBackground(this.f28759b.getDrawable(R.drawable.report_item_bg_white_center));
        } else {
            inflate.setBackground(this.f28759b.getDrawable(R.drawable.report_item_bg_white_bottom));
        }
        if (ItemType.getByValue(i) == ItemType.VIEW_TYPE_HEADER) {
            return new HeaderViewHolder(inflate);
        }
        return new DataViewHolder(inflate);
    }

    /* renamed from: com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$1 */
    static /* synthetic */ class C104301 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$trafficreport$view$history$ReportHistoryAdapter$ItemType */
        static final /* synthetic */ int[] f28763x27e03e6f;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType[] r0 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28763x27e03e6f = r0
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.VIEW_TYPE_HEADER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28763x27e03e6f     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.VIEW_TYPE_FIRST_DATA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28763x27e03e6f     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.VIEW_TYPE_ONLY_ONE_DATA     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28763x27e03e6f     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter$ItemType r1 = com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.ItemType.VIEW_TYPE_END_DATA     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.trafficreport.view.history.ReportHistoryAdapter.C104301.<clinit>():void");
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Context context;
        boolean z = viewHolder instanceof DataViewHolder;
        if (z) {
            if (i > 0) {
                i--;
            }
            ContributionData contributionData = this.f28762e.get(i);
            if (contributionData != null && z) {
                DataViewHolder dataViewHolder = (DataViewHolder) viewHolder;
                dataViewHolder.eventTitleTv.setText(contributionData.getEventTitle());
                dataViewHolder.roadDirection.setText(contributionData.getLine());
                if (TextUtils.isEmpty(contributionData.getRouteName())) {
                    dataViewHolder.roadNameTv.setVisibility(8);
                } else {
                    dataViewHolder.roadNameTv.setVisibility(0);
                    dataViewHolder.roadNameTv.setText(contributionData.getRouteName());
                }
                try {
                    if (contributionData.getTimestamp() > 0) {
                        String formatDateTime = Elvish.Companion.getInstance().formatDateTime(contributionData.getTimestamp(), DateStyle.DATE_DD_MM_YYYY, TimeStyle.TIME_HH_MM, true);
                        if (TextUtils.isEmpty(formatDateTime)) {
                            formatDateTime = "";
                        }
                        dataViewHolder.eventTimeTv.setText(formatDateTime);
                    }
                } catch (Throwable unused) {
                    dataViewHolder.eventTimeTv.setText("2022-11-11");
                    DLog.m10773d("ReportHistoryAdapter", "Elvish err = " + contributionData.getTimestamp(), new Object[0]);
                }
                if (contributionData.getStatus() != null && (context = this.f28759b) != null && context.getResources() != null) {
                    dataViewHolder.handleStatusTv.setText(this.f28759b.getResources().getString(contributionData.getStatus().getNameId()));
                    if (contributionData.getStatus() == EventHandleStatus.ACTIVE) {
                        dataViewHolder.handleStatusTv.setTextColor(this.f28759b.getResources().getColor(R.color.traffic_report_history_item_color));
                        dataViewHolder.resultLayout.setVisibility(0);
                        dataViewHolder.peopleCountTv.setText(DisplayUtil.convertText(contributionData.getNotificationCount()));
                        return;
                    }
                    dataViewHolder.handleStatusTv.setTextColor(this.f28759b.getResources().getColor(R.color.traffic_report_history_item_color_normal));
                    dataViewHolder.peopleCountTv.setText("");
                    dataViewHolder.resultLayout.setVisibility(4);
                }
            }
        }
    }

    public void setState(int i) {
        this.f28761d = i;
        if (i == 13) {
            notifyItemRemoved(getItemCount());
        }
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return ItemType.VIEW_TYPE_HEADER.getValue();
        }
        if (i == 1) {
            if (i == getItemCount() - 1) {
                return ItemType.VIEW_TYPE_ONLY_ONE_DATA.getValue();
            }
            return ItemType.VIEW_TYPE_FIRST_DATA.getValue();
        } else if (i == getItemCount() - 1) {
            return ItemType.VIEW_TYPE_END_DATA.getValue();
        } else {
            return ItemType.VIEW_TYPE_DATA.getValue();
        }
    }

    public int getItemCount() {
        List<ContributionData> list = this.f28762e;
        if (list == null) {
            return 0;
        }
        return list.size() + 1;
    }

    public enum ItemType {
        VIEW_TYPE_HEADER(1),
        VIEW_TYPE_ONLY_ONE_DATA(2),
        VIEW_TYPE_FIRST_DATA(3),
        VIEW_TYPE_END_DATA(4),
        VIEW_TYPE_DATA(5);
        
        private final int value;

        private ItemType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static ItemType getByValue(int i) {
            for (ItemType itemType : values()) {
                if (itemType.getValue() == i) {
                    return itemType;
                }
            }
            return null;
        }
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    protected static class DataViewHolder extends RecyclerView.ViewHolder {
        TextView eventTimeTv;
        TextView eventTitleTv;
        TextView handleStatusTv;
        TextView peopleCountTv;
        LinearLayout resultLayout;
        TextView roadDirection;
        TextView roadNameTv;

        public DataViewHolder(View view) {
            super(view);
            this.eventTitleTv = (TextView) view.findViewById(R.id.tv_event_title);
            this.roadNameTv = (TextView) view.findViewById(R.id.tv_rode_name);
            this.eventTimeTv = (TextView) view.findViewById(R.id.tv_report_time);
            this.handleStatusTv = (TextView) view.findViewById(R.id.tv_handle_status);
            this.peopleCountTv = (TextView) view.findViewById(R.id.tv_contribute_count);
            this.resultLayout = (LinearLayout) view.findViewById(R.id.ll_contribute_result);
            this.roadDirection = (TextView) view.findViewById(R.id.tv_direction);
        }
    }
}
