package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.IView;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.taxis99.R;

public class SafetyTrainView implements IView<AbsUnableCityPresenter> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsUnableCityPresenter f18079a;

    /* renamed from: b */
    private View f18080b;

    /* renamed from: c */
    private TextView f18081c;

    /* renamed from: d */
    private TextView f18082d = ((TextView) this.f18080b.findViewById(R.id.tv_safety_train_card_content));

    /* renamed from: e */
    private TextView f18083e = ((TextView) this.f18080b.findViewById(R.id.tv_safety_train_card_btn));

    /* renamed from: f */
    private ImageView f18084f = ((ImageView) this.f18080b.findViewById(R.id.iv_safety_train_card_icon));

    /* renamed from: g */
    private Context f18085g;

    public SafetyTrainView(Activity activity, ViewGroup viewGroup) {
        this.f18085g = activity;
        View inflate = ViewGroup.inflate(activity, R.layout.global_new_safety_train_card_view, viewGroup);
        this.f18080b = inflate;
        this.f18081c = (TextView) inflate.findViewById(R.id.tv_safety_train_card_title);
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f18079a = absUnableCityPresenter;
    }

    public View getView() {
        return this.f18080b;
    }

    public void setSafetyTrainCardInfo(final SafetyTrainCardInfo safetyTrainCardInfo) {
        TextView textView = this.f18081c;
        if (textView != null) {
            textView.setText(safetyTrainCardInfo.title);
        }
        TextView textView2 = this.f18082d;
        if (textView2 != null) {
            textView2.setText(safetyTrainCardInfo.content);
        }
        if (this.f18083e != null && !TextUtils.isEmpty(safetyTrainCardInfo.detailUrl) && !TextUtils.isEmpty(safetyTrainCardInfo.descLabel)) {
            this.f18083e.setVisibility(0);
            this.f18083e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SafetyTrainView.this.f18079a != null) {
                        SafetyTrainView.this.f18079a.gotoWebPage(safetyTrainCardInfo.detailUrl);
                    }
                }
            });
            this.f18083e.setText(safetyTrainCardInfo.descLabel);
            if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_color)) {
                this.f18083e.setTextColor(Color.parseColor(safetyTrainCardInfo.bg_color));
            }
        }
        if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_color)) {
            this.f18080b.setBackground(m15319a(this.f18085g, safetyTrainCardInfo.bg_color));
        } else {
            this.f18080b.setBackgroundResource(R.drawable.global_safety_train_card_bg);
        }
        if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_image)) {
            Glide.with(this.f18085g).load(safetyTrainCardInfo.bg_image).into(this.f18084f);
        } else {
            this.f18084f.setImageResource(R.drawable.global_safety_train_card_icon);
        }
    }

    /* renamed from: a */
    private GradientDrawable m15319a(Context context, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(context, 20.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }
}
