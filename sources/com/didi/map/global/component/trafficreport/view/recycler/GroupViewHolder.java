package com.didi.map.global.component.trafficreport.view.recycler;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;

public class GroupViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final TextView f28776a;

    public GroupViewHolder(View view) {
        super(view);
        this.f28776a = (TextView) view.findViewById(R.id.title);
    }

    public void updateTitle(String str) {
        TextView textView = this.f28776a;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
