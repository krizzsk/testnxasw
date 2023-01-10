package com.didi.globalsafetoolkit.business.areaCode;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.globalsafetoolkit.util.SfHighlightUtil;
import com.taxis99.R;

public class GuideHeadVH extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f24899a = ((TextView) this.itemView.findViewById(R.id.guide_text));

    /* renamed from: b */
    private TextView f24900b = ((TextView) this.itemView.findViewById(R.id.area_code_belonging_text));

    public GuideHeadVH(View view) {
        super(LayoutInflater.from(view.getContext()).inflate(R.layout.sf_mandatory_guide_head_adapter, (ViewGroup) view, false));
    }

    public void setData(String str, String str2) {
        this.f24899a.setText(SfHighlightUtil.highlight((CharSequence) str, Color.parseColor("#FF7733"), false));
        this.f24900b.setText(SfHighlightUtil.highlight((CharSequence) str2, Color.parseColor("#FF7733"), false));
    }
}
