package com.didi.sdk.component.share;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class ShareItemView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f38435a;

    /* renamed from: b */
    private TextView f38436b;

    public ShareItemView(Context context) {
        super(context);
        m28987a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28987a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28987a();
    }

    /* renamed from: a */
    private void m28987a() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.v_share_item, this, true);
        this.f38435a = (ImageView) findViewById(R.id.share_item_icon);
        this.f38436b = (TextView) findViewById(R.id.share_item_name);
    }

    public void setInfo(int i, String str) {
        this.f38435a.setImageResource(i);
        this.f38436b.setText(str);
    }
}
