package com.didi.map.global.component.trafficreport.view.recycler;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.map.global.component.trafficreport.model.ReportItem;
import com.taxis99.R;

public class DetailItemViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final TextView f28764a;

    /* renamed from: b */
    private final RadioButton f28765b;

    public DetailItemViewHolder(View view) {
        super(view);
        this.f28764a = (TextView) view.findViewById(R.id.report_item_title);
        this.f28765b = (RadioButton) view.findViewById(R.id.report_item_sel);
    }

    public void update(ReportItem reportItem) {
        TextView textView = this.f28764a;
        if (textView != null) {
            textView.setText(reportItem.getItemTitle());
        }
    }

    public void setButtonState(boolean z) {
        RadioButton radioButton = this.f28765b;
        if (radioButton != null) {
            radioButton.setChecked(z);
        }
    }

    public RadioButton getRadioButton() {
        return this.f28765b;
    }
}
