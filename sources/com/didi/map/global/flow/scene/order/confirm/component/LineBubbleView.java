package com.didi.map.global.flow.scene.order.confirm.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.markers.view.ILabelView;
import com.taxis99.R;

public class LineBubbleView implements ILabelView {

    /* renamed from: a */
    private View f29100a;

    /* renamed from: b */
    private TextView f29101b;

    public /* synthetic */ View getView(Context context, String str) {
        return ILabelView.CC.$default$getView(this, context, str);
    }

    public /* synthetic */ View getView(Context context, String str, int i) {
        return ILabelView.CC.$default$getView(this, context, str, i);
    }

    public View getView(Context context, String str, int i, boolean z) {
        if (this.f29100a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.line_bubble_view, (ViewGroup) null, false);
            this.f29100a = inflate;
            this.f29101b = (TextView) inflate.findViewById(R.id.bubble_content);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f29101b.setText(str);
        }
        if (z) {
            this.f29101b.setTextColor(context.getResources().getColor(R.color.multi_line_bubble_strong_text_color));
            this.f29100a.setBackground(context.getResources().getDrawable(R.drawable.map_bubble_bg_shadow_selected));
        } else {
            this.f29101b.setTextColor(context.getResources().getColor(R.color.multi_line_bubble_weak_text_color));
            this.f29100a.setBackground(context.getResources().getDrawable(R.drawable.map_bubble_bg_shadow_normal));
        }
        if (i == 8) {
            this.f29101b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_right_top));
        } else if (i == 2) {
            this.f29101b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_left_top));
        } else if (i == 32) {
            this.f29101b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_right_bottom));
        } else if (i == 128) {
            this.f29101b.setBackground(context.getResources().getDrawable(R.drawable.shape_map_bubble_left_bottom));
        }
        return this.f29100a;
    }
}
