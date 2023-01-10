package com.didi.component.service.activity.risk;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class RiskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* renamed from: a */
    ImageView f17567a;

    /* renamed from: b */
    TextView f17568b;

    /* renamed from: c */
    TextView f17569c;

    /* renamed from: d */
    private OnClickListener f17570d;

    public interface OnClickListener {
        void onClick(View view, RiskViewHolder riskViewHolder, int i);
    }

    public RiskViewHolder(View view) {
        super(view);
        this.f17567a = (ImageView) view.findViewById(R.id.risk_user_icon);
        this.f17568b = (TextView) view.findViewById(R.id.risk_user_title);
        this.f17569c = (TextView) view.findViewById(R.id.risk_user_error_label);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OnClickListener onClickListener = this.f17570d;
        if (onClickListener != null) {
            onClickListener.onClick(view, this, getAdapterPosition());
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f17570d = onClickListener;
        this.itemView.setOnClickListener(this);
    }
}
