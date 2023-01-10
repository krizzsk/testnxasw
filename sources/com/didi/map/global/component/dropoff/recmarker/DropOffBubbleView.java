package com.didi.map.global.component.dropoff.recmarker;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class DropOffBubbleView implements ILabelView {

    /* renamed from: a */
    private View f27844a;

    /* renamed from: b */
    private TextView f27845b;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public View getView(Context context, String str, int i) {
        if (this.f27844a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dropoff_rec_marker_bubble_view, (ViewGroup) null, false);
            this.f27844a = inflate;
            this.f27845b = (TextView) inflate.findViewById(R.id.dropoff_bubble_name);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f27845b.setText(str);
        }
        return this.f27844a;
    }
}
