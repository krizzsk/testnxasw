package com.didi.map.global.component.recmarker.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class SingleRecMarkerBubble {

    /* renamed from: a */
    private static SingleRecMarkerBubble f28402a;

    /* renamed from: b */
    private View f28403b;

    /* renamed from: c */
    private TextView f28404c;

    private SingleRecMarkerBubble() {
    }

    public static SingleRecMarkerBubble getInstance() {
        if (f28402a == null) {
            f28402a = new SingleRecMarkerBubble();
        }
        return f28402a;
    }

    public View getView(Context context, String str) {
        if (this.f28403b == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.comprecmarker_departure_recommend_view, (ViewGroup) null);
            this.f28403b = inflate;
            this.f28404c = (TextView) inflate.findViewById(R.id.tv_content);
            if (!TextUtils.isEmpty(str)) {
                this.f28404c.setText(str);
            }
        }
        return this.f28403b;
    }
}
