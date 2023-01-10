package com.didi.component.driverbar.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.driverbar.AvatarEnlargePopup;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.component.driverbar.model.DriverPersonData;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import kotlin.Pair;

public class DriverBarOnServiceView extends DriverBarFieldBase {

    /* renamed from: a */
    private ImageView f14814a = ((ImageView) findView(R.id.driver_card_person_image));

    /* renamed from: b */
    private TextView f14815b = ((TextView) findView(R.id.driver_card_person_name));

    /* renamed from: c */
    private View f14816c = findView(R.id.driver_card_person_info_ll);

    /* renamed from: d */
    private ImageView f14817d = ((ImageView) findView(R.id.driver_card_star_img));

    /* renamed from: e */
    private TextView f14818e = ((TextView) findView(R.id.dot_text1));

    /* renamed from: f */
    private TextView f14819f = ((TextView) findView(R.id.driver_card_trip_num));

    /* renamed from: g */
    private TextView f14820g = ((TextView) findView(R.id.driver_card_star_text));

    public DriverBarOnServiceView(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void inflateView(Context context, ViewGroup viewGroup) {
        this.mContainerView = ViewEx.inflateViewAsync(context, (int) R.layout.driver_bar_v2_on_service_view, viewGroup, false);
    }

    public void setData(final DriverBarV2Model driverBarV2Model) {
        super.setData(driverBarV2Model);
        if (driverBarV2Model != null && driverBarV2Model.farModel != null && driverBarV2Model.farModel.personData != null) {
            DriverPersonData driverPersonData = driverBarV2Model.farModel.personData;
            if (!Utils.isDestroy(this.mContext)) {
                ((RequestBuilder) Glide.with(this.mContext).asBitmap().load(driverPersonData.avatar).placeholder((int) R.drawable.driver_card_default_avatar_v2)).into(this.f14814a);
            }
            if (driverPersonData.nameInfo == null || TextUtils.isEmpty(driverPersonData.nameInfo.getContent())) {
                this.f14815b.setVisibility(8);
            } else {
                this.f14815b.setVisibility(0);
                driverPersonData.nameInfo.bindTextView(this.f14815b);
            }
            if (driverPersonData.score == null || TextUtils.isEmpty(driverPersonData.score.getContent())) {
                this.f14820g.setVisibility(8);
                this.f14817d.setVisibility(8);
            } else {
                this.f14820g.setVisibility(0);
                this.f14817d.setVisibility(0);
                driverPersonData.score.bindTextView(this.f14820g);
            }
            if (driverPersonData.orderCount == null || TextUtils.isEmpty(driverPersonData.orderCount.getContent())) {
                this.f14819f.setVisibility(8);
            } else {
                if (this.f14820g.getVisibility() == 0) {
                    this.f14818e.setVisibility(0);
                } else {
                    this.f14818e.setVisibility(8);
                }
                this.f14819f.setVisibility(0);
                driverPersonData.orderCount.bindTextView(this.f14819f);
            }
            this.f14816c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DriverBarOnServiceView.this.dispatchDriverClicked((Pair<String, String>) null);
                }
            });
            this.f14814a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_driverhead_ck");
                    new AvatarEnlargePopup(DriverBarOnServiceView.this.mContext, LayoutInflater.from(DriverBarOnServiceView.this.mContext).inflate(R.layout.driver_avatar_enlarge_popup, (ViewGroup) null), -1, -1, driverBarV2Model.farModel.personData.avatar).show();
                }
            });
        }
    }
}
