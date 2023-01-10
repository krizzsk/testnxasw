package com.didi.map.global.component.trafficreport.view.recycler;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.component.trafficreport.model.RemarkItem;
import com.taxis99.R;

public class RemarkViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final EditText f28780a;

    public RemarkViewHolder(View view) {
        super(view);
        this.f28780a = (EditText) view.findViewById(R.id.text_remark);
    }

    public void update(RemarkItem remarkItem) {
        this.f28780a.setText(remarkItem.hint);
    }

    public TextView getRemarkView() {
        return this.f28780a;
    }
}
