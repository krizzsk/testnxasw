package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didichuxing.drtl.tookit.DRtlToolkit;
import com.taxis99.R;

public class TextComponentView extends ComponentView {

    /* renamed from: a */
    private TextView f40223a;

    /* renamed from: b */
    private TextView f40224b;

    /* renamed from: c */
    private ImageView f40225c;

    /* renamed from: d */
    private TextView f40226d;

    /* renamed from: e */
    private ImageView f40227e;

    /* renamed from: f */
    private View f40228f;

    /* renamed from: g */
    private TextView f40229g;

    /* renamed from: h */
    private View f40230h;

    public TextComponentView(Context context) {
        super(context);
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.v_sidebar_nav_iteml, (ViewGroup) null);
        this.f40230h = inflate;
        this.f40223a = (TextView) inflate.findViewById(R.id.sidebar_nav_item_name);
        this.f40224b = (TextView) inflate.findViewById(R.id.sidebar_nav_item_right_des);
        this.f40225c = (ImageView) inflate.findViewById(R.id.setting_list_item_arrow);
        this.f40227e = (ImageView) inflate.findViewById(R.id.item_icon);
        this.f40226d = (TextView) inflate.findViewById(R.id.item_tip);
        this.f40228f = inflate.findViewById(R.id.divider);
        this.f40229g = (TextView) inflate.findViewById(R.id.item_right_des_tip);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-1, this.context.getResources().getDimensionPixelOffset(R.dimen.setting_item_height));
        }
        inflate.setLayoutParams(layoutParams);
        inflate.setOnClickListener(this);
        return inflate;
    }

    public void hideDivider() {
        this.f40228f.setVisibility(8);
    }

    public void setName(String str) {
        super.setName(str);
        this.f40223a.setText(str);
    }

    public void setRightDes(String str) {
        this.f40224b.setVisibility(0);
        this.f40224b.setText(str);
    }

    public void setRightDes(String str, boolean z) {
        this.f40224b.setVisibility(0);
        this.f40224b.setText(str);
        if (DRtlToolkit.rtl() && z) {
            this.f40224b.setTextDirection(3);
        }
    }

    public void setRightDesTipVisible() {
        this.f40229g.setVisibility(0);
    }

    public void setRightDesTipVisibility(boolean z) {
        this.f40229g.setVisibility(z ? 0 : 8);
    }

    public void setTip(String str) {
        this.f40226d.setVisibility(0);
        this.f40226d.setText(str);
    }

    public void setIcon(Bitmap bitmap) {
        this.f40227e.setVisibility(0);
        this.f40227e.setImageBitmap(bitmap);
    }

    public void setRightArrowVisible(int i) {
        this.f40225c.setVisibility(i);
    }

    public void setRightIconRes(int i) {
        this.f40227e.setVisibility(0);
        this.f40225c.setImageResource(i);
    }

    public void setVisible(int i) {
        View view = this.f40230h;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
