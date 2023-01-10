package com.didi.map.global.component.departure.canoe.card;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.map.global.component.departure.view.RichTextInfo;
import com.taxis99.R;

public class CanoeDepartureCardView extends FrameLayout {

    /* renamed from: a */
    private TextView f27226a;

    /* renamed from: b */
    private TextView f27227b;

    /* renamed from: c */
    private ImageView f27228c;

    /* renamed from: d */
    private TextView f27229d;

    /* renamed from: e */
    private TextView f27230e;

    /* renamed from: f */
    private TextView f27231f;

    /* renamed from: g */
    private int f27232g;

    public CanoeDepartureCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CanoeDepartureCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CanoeDepartureCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27232g = 0;
        m21530a(context);
    }

    /* renamed from: a */
    private void m21530a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.canoe_card_view_layout, this, true);
        this.f27226a = (TextView) inflate.findViewById(R.id.canoe_card_title);
        this.f27227b = (TextView) inflate.findViewById(R.id.canoe_card_subtitle);
        this.f27228c = (ImageView) inflate.findViewById(R.id.canoe_card_address_icon);
        this.f27229d = (TextView) inflate.findViewById(R.id.canoe_card_address_name);
        this.f27230e = (TextView) inflate.findViewById(R.id.canoe_card_search);
        this.f27231f = (TextView) inflate.findViewById(R.id.canoe_card_confirm);
    }

    public void setCardStyle(int i) {
        int i2;
        int i3;
        int i4;
        if (i != 1) {
            i2 = R.drawable.canoe_card_start_icon;
            i4 = R.string.GRider_Sug_2020_map_button_pickup;
            i3 = R.string.GRider_Sug_2020_map_title_pickup;
        } else {
            i2 = R.drawable.canoe_card_end_icon;
            i4 = R.string.GRider_Sug_2020_map_button_whereTo;
            i3 = R.string.GRider_Sug_2020_map_title_whereTo;
        }
        ImageView imageView = this.f27228c;
        if (imageView != null) {
            imageView.setImageDrawable(getContext().getResources().getDrawable(i2));
        }
        TextView textView = this.f27231f;
        if (textView != null) {
            textView.setText(getContext().getResources().getString(i4));
        }
        TextView textView2 = this.f27226a;
        if (textView2 != null) {
            textView2.setText(getContext().getResources().getString(i3));
        }
    }

    public void setSearchClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f27229d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
        TextView textView2 = this.f27230e;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }

    public void setConfirmClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f27231f;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setLoading(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f27229d.setText(str);
        }
        this.f27231f.setEnabled(false);
    }

    public void showLoadding() {
        setLoading(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress));
        this.f27229d.setTextColor(getResources().getColor(R.color.light_gray));
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f27226a);
            return;
        }
        this.f27226a.setText("");
    }

    public void setSubTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f27227b);
            return;
        }
        this.f27227b.setText("");
    }

    public void setAddress(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f27229d.setText(charSequence);
            this.f27229d.setTextColor(getResources().getColor(R.color.confirm_departure_point_color));
            this.f27231f.setEnabled(true);
        }
    }
}
