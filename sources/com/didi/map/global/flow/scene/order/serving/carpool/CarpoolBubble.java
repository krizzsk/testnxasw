package com.didi.map.global.flow.scene.order.serving.carpool;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class CarpoolBubble implements ILabelView {

    /* renamed from: a */
    private View f29240a;

    /* renamed from: b */
    private TextView f29241b;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
        return ILabelView.CC.$default$getView(this, context, str, i, z);
    }

    public View getView(Context context, String str, int i) {
        if (this.f29240a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_carpool_bubble_tip_info_window, (ViewGroup) null, false);
            this.f29240a = inflate;
            this.f29241b = (TextView) inflate.findViewById(R.id.tip);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f29241b.setText(str);
        }
        return this.f29240a;
    }
}
