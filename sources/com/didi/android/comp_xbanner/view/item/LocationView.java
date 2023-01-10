package com.didi.android.comp_xbanner.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.template.mdel.XBannerNativeModel;
import com.didiglobal.xbanner.template.view.XBannerNativeView;
import com.taxis99.R;

public class LocationView extends ConstraintLayout implements XBannerNativeView {

    /* renamed from: a */
    private TextView f9963a;

    /* renamed from: b */
    private TextView f9964b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f9965c;

    public View createView(Context context, XBannerNativeModel xBannerNativeModel, int i) {
        return this;
    }

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
    }

    public LocationView(Context context, int i) {
        super(context);
        init(context);
        this.f9965c = i;
    }

    public LocationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LocationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.xbanner_location_item, this);
        this.f9963a = (TextView) findViewById(R.id.location_item_title);
        this.f9964b = (TextView) findViewById(R.id.location_item_content);
        this.f9963a.setText(R.string.global_location_service_disabled);
        this.f9964b.setText(R.string.global_location_click_2_open);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("ibt_gp_locationoperationcard_ck");
                DRouter.build("taxis99onetravel://one/syssettings?permission=android.permission.ACCESS_FINE_LOCATION&type=" + LocationView.this.f9965c).start(context);
            }
        });
    }

    public XBannerNativeModel getNativeModel() {
        return new LocationViewData();
    }
}
