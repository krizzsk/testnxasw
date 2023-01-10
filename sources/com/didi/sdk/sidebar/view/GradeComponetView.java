package com.didi.sdk.sidebar.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.sdk.app.DIDIApplication;
import com.taxis99.R;

public class GradeComponetView extends ComponentView {

    /* renamed from: a */
    private TextView f40185a;

    /* renamed from: b */
    private TextView f40186b;

    /* renamed from: c */
    private ImageView f40187c;

    /* renamed from: d */
    private View f40188d;

    /* renamed from: e */
    private Context f40189e;

    public GradeComponetView(Context context) {
        super(context);
        this.f40189e = context;
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.v_grade_component_view, (ViewGroup) null);
        this.f40185a = (TextView) inflate.findViewById(R.id.sidebar_grade_item_name);
        this.f40186b = (TextView) inflate.findViewById(R.id.sidebar_grade_item_desc);
        this.f40187c = (ImageView) inflate.findViewById(R.id.sidebar_grade_item_icon);
        this.f40188d = inflate.findViewById(R.id.sidebar_grade_item_bg);
        return inflate;
    }

    public void setName(String str) {
        this.f40185a.setText(str);
    }

    public void setDesc(String str, String str2) {
        this.f40186b.setText(str);
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f40186b.setTextColor(Color.parseColor(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBackground(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{-1, Color.parseColor(str)});
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, this.f40189e.getResources().getDrawable(R.color.menu_item_pressed));
                stateListDrawable.addState(new int[0], gradientDrawable);
                this.f40188d.setBackground(stateListDrawable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setGradeIcon(String str) {
        Glide.with((Context) DIDIApplication.getAppContext()).asBitmap().load(str).into(this.f40187c);
    }
}
