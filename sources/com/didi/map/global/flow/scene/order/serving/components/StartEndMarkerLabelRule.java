package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.flow.scene.order.serving.components.LabelMarker;

public class StartEndMarkerLabelRule implements LabelMarker.ILabelRule {

    /* renamed from: a */
    private boolean f29345a = false;

    /* renamed from: b */
    private int f29346b;

    /* renamed from: c */
    private int f29347c;

    public StartEndMarkerLabelRule(Context context) {
        boolean z = false;
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = context.getResources().getDisplayMetrics().heightPixels;
            if (i <= 640 && i2 <= 960) {
                z = true;
            }
            this.f29345a = z;
            this.f29346b = DisplayUtils.dp2px(context, 148.0f);
            this.f29347c = DisplayUtils.dp2px(context, 10.0f);
        }
    }

    public String applyLabelRule(TextView textView, String str) {
        if (this.f29345a) {
            return "";
        }
        textView.setMaxLines(4);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(3);
        textView.setMaxWidth(this.f29346b);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.setMargins(this.f29347c, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        return str;
    }
}
