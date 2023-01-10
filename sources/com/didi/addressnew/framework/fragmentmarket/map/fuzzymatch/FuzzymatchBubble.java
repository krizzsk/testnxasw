package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class FuzzymatchBubble implements ILabelView {

    /* renamed from: a */
    private View f9003a;

    /* renamed from: b */
    private TextView f9004b;

    /* renamed from: c */
    private int f9005c;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public FuzzymatchBubble(int i) {
        this.f9005c = i;
    }

    public View getView(Context context, String str, int i) {
        if (this.f9003a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.fuzzy_bubble_view_layout, (ViewGroup) null, false);
            this.f9003a = inflate;
            this.f9004b = (TextView) inflate.findViewById(R.id.fuzzy_bubble_text);
        }
        if (this.f9005c == 1) {
            this.f9004b.setTextColor(context.getResources().getColor(R.color.map_sug_fuzzy_marker_label_start));
        } else {
            this.f9004b.setTextColor(context.getResources().getColor(R.color.map_sug_fuzzy_marker_label_end));
        }
        if (!TextUtils.isEmpty(str)) {
            this.f9004b.setText(str);
        }
        return this.f9003a;
    }
}
