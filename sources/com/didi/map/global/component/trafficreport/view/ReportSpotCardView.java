package com.didi.map.global.component.trafficreport.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.taxis99.R;

public class ReportSpotCardView extends FrameLayout {

    /* renamed from: a */
    private TextView f28703a;

    /* renamed from: b */
    private TextView f28704b;

    /* renamed from: c */
    private TextView f28705c;

    /* renamed from: d */
    private TextView f28706d;

    /* renamed from: e */
    private boolean f28707e;

    public ReportSpotCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ReportSpotCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReportSpotCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28707e = true;
        m22339a(context);
    }

    /* renamed from: a */
    private void m22339a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_report_loc_card_view, this);
        this.f28703a = (TextView) inflate.findViewById(R.id.tv_main_title);
        this.f28705c = (TextView) inflate.findViewById(R.id.tv_report_loc_address_name);
        this.f28704b = (TextView) findViewById(R.id.tv_report_loc_confirm);
        this.f28706d = (TextView) findViewById(R.id.tv_report_loc_cancel);
        try {
            this.f28704b.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f28704b.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestPoiSelectCardFeature() {
        this.f28703a.setText(getResources().getString(R.string.GRider_PassengerReports__fnsT));
        this.f28704b.setText(getResources().getString(R.string.GRider_PassengerReports__iMSD));
    }

    public void setLoading(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f28705c.setText(str);
        }
        m22338a();
    }

    /* renamed from: a */
    private void m22338a() {
        this.f28704b.setEnabled(false);
        this.f28704b.setTextColor(getResources().getColor(R.color.light_gray));
        this.f28704b.setBackground(getResources().getDrawable(R.drawable.report_detail_cancel_button_bg));
        this.f28707e = false;
    }

    /* renamed from: b */
    private void m22341b() {
        this.f28704b.setEnabled(true);
        try {
            this.f28704b.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f28704b.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f28707e = true;
    }

    public void setAddress(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f28705c.setText(charSequence);
            this.f28705c.setTextColor(getResources().getColor(R.color.confirm_departure_point_color));
            m22341b();
        }
    }

    public void showLoading(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f28705c.setText(charSequence);
            if (i != 0) {
                this.f28705c.setTextColor(i);
            }
            m22338a();
        }
    }

    public void showLoading() {
        showLoading(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress), getResources().getColor(R.color.light_gray));
    }

    public void setConfirmOnClickListener(View.OnClickListener onClickListener) {
        this.f28704b.setOnClickListener(m22337a(onClickListener));
    }

    public void setOnCancelOnClickListener(View.OnClickListener onClickListener) {
        this.f28706d.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private View.OnClickListener m22337a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            return new View.OnClickListener(onClickListener) {
                public final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    ReportSpotCardView.this.m22340a(this.f$1, view);
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m22340a(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null && this.f28707e) {
            onClickListener.onClick(view);
        }
    }

    public TextView getMainTitle() {
        return this.f28703a;
    }
}
