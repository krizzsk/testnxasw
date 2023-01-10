package com.didi.component.common.widget.pin;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.taxis99.R;

public class PinShowLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f13917a = 3;

    /* renamed from: b */
    private Context f13918b;

    /* renamed from: c */
    private TextView f13919c;

    /* renamed from: d */
    private TextView f13920d;

    /* renamed from: e */
    private TextView f13921e;

    /* renamed from: f */
    private String f13922f;

    public PinShowLayout(Context context) {
        super(context);
        m11525a(context);
    }

    public PinShowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11525a(context);
    }

    public PinShowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11525a(context);
    }

    /* renamed from: a */
    private void m11525a(Context context) {
        this.f13918b = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        inflate(this.f13918b, R.layout.global_pin_show_layout, this);
        this.f13919c = (TextView) findViewById(R.id.pin_show_digit_text_view_1);
        this.f13920d = (TextView) findViewById(R.id.pin_show_digit_text_view_2);
        this.f13921e = (TextView) findViewById(R.id.pin_show_digit_text_view_3);
    }

    public boolean showPin(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 3) {
            return false;
        }
        this.f13922f = str;
        this.f13919c.setText(str.substring(0, 1));
        this.f13920d.setText(str.substring(1, 2));
        this.f13921e.setText(str.substring(2, 3));
        return true;
    }
}
