package com.didi.rfusion.widget.toast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;

/* renamed from: com.didi.rfusion.widget.toast.a */
/* compiled from: RFNormalToast */
class C12414a extends Toast {

    /* renamed from: a */
    private Context f36765a;

    /* renamed from: b */
    private TextView f36766b;

    /* renamed from: c */
    private FrameLayout f36767c;

    public C12414a(Context context) {
        super(context);
        this.f36765a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.rf_toast_layout, (ViewGroup) null);
        this.f36767c = (FrameLayout) inflate.findViewById(R.id.rf_fl_toast_container);
        this.f36766b = (TextView) inflate.findViewById(R.id.rf_tv_toast_msg);
        setView(inflate);
        setGravity(17, 0, 0);
        setDuration(0);
    }

    /* renamed from: a */
    public void mo95017a(String str) {
        this.f36766b.setText(str);
    }

    /* renamed from: a */
    public void mo95016a(int i) {
        int i2;
        int i3;
        if (i != 1) {
            i2 = R.drawable.rf_shape_bg_toast_light;
            i3 = R.color.rf_color_gery_1_0_000000;
        } else {
            i2 = R.drawable.rf_shape_bg_toast_dark;
            i3 = R.color.rf_color_white_100_FFFFFF;
        }
        this.f36767c.setBackground(RFResUtils.getDrawable(this.f36765a, i2));
        this.f36766b.setTextColor(RFResUtils.getColor(this.f36765a, i3));
    }
}
