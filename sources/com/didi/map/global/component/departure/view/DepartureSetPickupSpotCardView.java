package com.didi.map.global.component.departure.view;

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

public class DepartureSetPickupSpotCardView extends FrameLayout {

    /* renamed from: a */
    private TextView f27598a;

    /* renamed from: b */
    private TextView f27599b;

    /* renamed from: c */
    private TextView f27600c;

    /* renamed from: d */
    private View f27601d;

    /* renamed from: e */
    private TextView f27602e;

    /* renamed from: f */
    private TextView f27603f;

    /* renamed from: g */
    private boolean f27604g;

    public @interface DepartureMapPoiSelectCardStyle {
        public static final int SELECT_COMPANY = 6;
        public static final int SELECT_END = 2;
        public static final int SELECT_FAVORITE = 7;
        public static final int SELECT_HOME = 5;
        public static final int SELECT_START = 1;
        public static final int SELECT_WAYPOINT_1 = 3;
        public static final int SELECT_WAYPOINT_2 = 4;
    }

    public DepartureSetPickupSpotCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureSetPickupSpotCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DepartureSetPickupSpotCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27604g = true;
        m21824a(context);
    }

    /* renamed from: a */
    private void m21824a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.card_view_pickup_spot_layout, this);
        this.f27598a = (TextView) inflate.findViewById(R.id.tv_confirm_departure_point_title);
        this.f27599b = (TextView) inflate.findViewById(R.id.tv_confirm_departure_point_subtitle);
        this.f27602e = (TextView) inflate.findViewById(R.id.tvInputAddress);
        this.f27603f = (TextView) inflate.findViewById(R.id.tvSearch);
        this.f27600c = (TextView) inflate.findViewById(R.id.btnPoiSelect);
        this.f27601d = inflate.findViewById(R.id.vAddrPrefixImg);
        try {
            this.f27600c.setTextColor(ContextCompat.getColorStateList(getContext(), DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_text_color_selector)));
            this.f27600c.setBackground(DidiThemeManager.getIns().getResPicker(getContext()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoiSelectButtonText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f27600c.setText(str);
        }
    }

    public void requestPoiSelectCardFeature(int i) {
        switch (i) {
            case 1:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_pickup));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_pickup));
                setInputDotIconGrren();
                return;
            case 2:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_whereTo));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_whereTo));
                setInputDotIconOrange();
                return;
            case 3:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_stop1));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_stop1));
                setInputDotIconOrange();
                return;
            case 4:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_stop2));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_stop2));
                setInputDotIconOrange();
                return;
            case 5:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_home));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_home));
                setInputDotIconGrren();
                return;
            case 6:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_work));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_work));
                setInputDotIconGrren();
                return;
            case 7:
                this.f27598a.setText(getResources().getString(R.string.GRider_Sug_2020_map_title_favorite));
                this.f27600c.setText(getResources().getString(R.string.GRider_Sug_2020_map_button_favorite));
                setInputDotIconGrren();
                return;
            default:
                return;
        }
    }

    public void setSearchOnClickListener(View.OnClickListener onClickListener) {
        this.f27603f.setOnClickListener(onClickListener);
        this.f27602e.setOnClickListener(onClickListener);
    }

    public void setButtonOnClickListener(View.OnClickListener onClickListener) {
        this.f27600c.setOnClickListener(m21822a(onClickListener));
    }

    /* renamed from: a */
    private View.OnClickListener m21822a(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            return new View.OnClickListener(onClickListener) {
                public final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DepartureSetPickupSpotCardView.this.m21825a(this.f$1, view);
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21825a(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null && this.f27604g) {
            onClickListener.onClick(view);
        }
    }

    public void setInputDotIcon(int i) {
        this.f27601d.setBackgroundResource(i);
    }

    public void setInputDotIconGrren() {
        this.f27601d.setBackgroundResource(R.drawable.com_icon_pickup);
    }

    public void setInputDotIconOrange() {
        this.f27601d.setBackgroundResource(R.drawable.com_icon_dest);
    }

    public void setInputDotIconDisable() {
        this.f27601d.setBackgroundResource(R.drawable.map_input_icon_pick_up_dis);
    }

    public void setLoadding(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f27602e.setText(str);
        }
        m21823a();
    }

    /* renamed from: a */
    private void m21823a() {
        this.f27600c.setEnabled(false);
        this.f27604g = false;
    }

    /* renamed from: b */
    private void m21826b() {
        this.f27600c.setEnabled(true);
        this.f27604g = true;
    }

    public void setMainTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f27598a);
            return;
        }
        this.f27598a.setText("");
    }

    public void setSubTitle(CharSequence charSequence) {
        if (charSequence != null) {
            RichTextInfo richTextInfo = new RichTextInfo();
            richTextInfo.setInfo(charSequence.toString());
            richTextInfo.bindTo(this.f27599b);
            return;
        }
        this.f27599b.setText("");
    }

    public void setAddress(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f27602e.setText(charSequence);
            this.f27602e.setTextColor(getResources().getColor(R.color.confirm_departure_point_color));
            m21826b();
        }
    }

    public void showLoadding(CharSequence charSequence, int i) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f27602e.setText(charSequence);
            if (i != 0) {
                this.f27602e.setTextColor(i);
            }
            m21823a();
        }
    }

    public void showLoadding() {
        showLoadding(getResources().getString(R.string.GRider_Sug_2020_map_searchingAddress), getResources().getColor(R.color.light_gray));
    }

    public void showNoParking() {
        showNoParking(getResources().getString(R.string.GRider_Homepage0714_No_parking_JAWz), -65536);
    }

    public void showNoParking(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f27602e.setText(str);
            if (i != 0) {
                this.f27602e.setTextColor(i);
            } else {
                this.f27602e.setTextColor(-65536);
            }
        }
    }

    public TextView getMainTitle() {
        return this.f27598a;
    }

    public TextView getSubtitle() {
        return this.f27599b;
    }

    public TextView getButton() {
        return this.f27600c;
    }

    public TextView getSearchButton() {
        return this.f27603f;
    }
}
