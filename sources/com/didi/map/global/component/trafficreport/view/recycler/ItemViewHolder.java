package com.didi.map.global.component.trafficreport.view.recycler;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import com.taxis99.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final TextView f28777a;

    /* renamed from: b */
    private final ImageView f28778b;

    public ItemViewHolder(View view) {
        super(view);
        this.f28777a = (TextView) view.findViewById(R.id.report_item_title);
        this.f28778b = (ImageView) view.findViewById(R.id.report_icon);
    }

    public void update(Context context, ReportItem reportItem) {
        TextView textView = this.f28777a;
        if (textView != null) {
            textView.setText(reportItem.getItemTitle());
        }
        if (reportItem != null) {
            Glide.with(context).load(reportItem.getItemIcon()).into(this.f28778b);
        }
    }
}
