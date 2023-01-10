package com.didi.map.global.component.trafficreport.view.recycler;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.component.trafficreport.model.MapEntryItem;
import com.taxis99.R;

public class MapEntryViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final TextView f28779a;

    public MapEntryViewHolder(View view) {
        super(view);
        this.f28779a = (TextView) view.findViewById(R.id.report_item_title);
    }

    public void update(MapEntryItem mapEntryItem, Context context) {
        if (mapEntryItem == null || mapEntryItem.address == null) {
            this.f28779a.setText(R.string.GRider_PassengerReports_mvsN_PQgC);
            this.f28779a.setTextColor(context.getResources().getColor(R.color.red));
            return;
        }
        this.f28779a.setText(mapEntryItem.address.displayName == null ? context.getResources().getString(R.string.GRider_Sug_2020_currentLoc) : mapEntryItem.address.displayName);
        this.f28779a.setTextColor(context.getResources().getColor(R.color.black));
    }
}
