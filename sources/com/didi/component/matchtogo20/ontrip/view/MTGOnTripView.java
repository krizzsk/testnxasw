package com.didi.component.matchtogo20.ontrip.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
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
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.Utils;
import com.didi.component.common.widget.CircleImageView;
import com.didi.component.matchtogo20.ontrip.AbsMTGOnTripPresenter;
import com.didi.component.matchtogo20.ontrip.model.MatchOnTripModel;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class MTGOnTripView implements IMTGOnTripView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsMTGOnTripPresenter f16394a;

    /* renamed from: b */
    private View f16395b;

    /* renamed from: c */
    private ViewGroup f16396c;

    /* renamed from: d */
    private Context f16397d;

    /* renamed from: e */
    private TextView f16398e;

    /* renamed from: f */
    private TextView f16399f = ((TextView) this.f16395b.findViewById(R.id.tv_sub_content));

    /* renamed from: g */
    private TextView f16400g = ((TextView) this.f16395b.findViewById(R.id.tv_accept_btn));

    /* renamed from: h */
    private TextView f16401h = ((TextView) this.f16395b.findViewById(R.id.tv_accept_time));

    /* renamed from: i */
    private CircleImageView f16402i = ((CircleImageView) this.f16395b.findViewById(R.id.iv_sub_icon));

    /* renamed from: j */
    private int f16403j;

    /* renamed from: k */
    private long f16404k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f16405l;

    public MTGOnTripView(Activity activity, ViewGroup viewGroup) {
        this.f16397d = activity;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.match_to_go_ontrip_layout_20, viewGroup, false);
        this.f16395b = inflate;
        this.f16398e = (TextView) inflate.findViewById(R.id.tv_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f16395b.findViewById(R.id.ll_accept);
        this.f16396c = viewGroup2;
        viewGroup2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                if (MTGOnTripView.this.f16405l) {
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("ibt_gp_share_matchtogo_question_ck", (Map<String, Object>) hashMap);
                    MTGOnTripView.this.f16394a.updateMtgPanel();
                    return;
                }
                hashMap.put("type", 0);
                GlobalOmegaUtils.trackEvent("ibt_gp_share_matchtogo_question_ck", (Map<String, Object>) hashMap);
            }
        });
        this.f16402i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackEvent("ibt_gp_share_matchtogo_question_ck");
                MTGOnTripView.this.f16394a.onShowPriceDetailClicked();
            }
        });
    }

    public View getView() {
        return this.f16395b;
    }

    public void setPresenter(AbsMTGOnTripPresenter absMTGOnTripPresenter) {
        this.f16394a = absMTGOnTripPresenter;
    }

    public void setOnTripMode(MatchOnTripModel matchOnTripModel, long j) {
        if (matchOnTripModel == null) {
            SystemUtils.log(6, "mtg", "ontrip data is null", (Throwable) null, "com.didi.component.matchtogo20.ontrip.view.MTGOnTripView", 85);
            return;
        }
        this.f16398e.setText(matchOnTripModel.main_content);
        this.f16399f.setText(HighlightUtil.highlight((CharSequence) matchOnTripModel.sub_content, -16777216, true));
        this.f16400g.setText(matchOnTripModel.button_content);
        if (TextUtils.isEmpty(matchOnTripModel.sub_icon_url)) {
            this.f16402i.setVisibility(8);
        } else {
            this.f16402i.setVisibility(0);
            ((RequestBuilder) Glide.with(this.f16397d).asBitmap().load(matchOnTripModel.sub_icon_url).error((int) R.drawable.global_driver_car_default_avatar)).into((ImageView) this.f16402i);
        }
        int i = matchOnTripModel.enable_button_time;
        this.f16403j = i;
        this.f16401h.setText(Utils.second2Min(i * 60));
        this.f16404k = j;
        if (System.currentTimeMillis() / 1000 > ((long) (this.f16403j * 60)) + j) {
            this.f16405l = true;
            this.f16401h.setVisibility(8);
            this.f16400g.setTextColor(Color.parseColor("#ffffff"));
            this.f16396c.setBackgroundResource(R.drawable.mtg_accept_button_selector);
            GlobalOmegaUtils.trackEvent("ibt_gp_share_matchtogo_available_sw");
            return;
        }
        this.f16400g.setTextColor(Color.parseColor("#cccccc"));
        this.f16405l = false;
        this.f16401h.setVisibility(0);
        this.f16396c.setBackgroundResource(R.drawable.mtg_accept_button_unable);
    }

    public void updateWaitTiem(int i) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j = this.f16404k;
        int i2 = (int) ((((long) (this.f16403j * 60)) + j) - currentTimeMillis);
        if (i2 > 0 && currentTimeMillis > 0 && j > 0) {
            this.f16405l = false;
            String second2Min = Utils.second2Min(i2);
            this.f16400g.setTextColor(Color.parseColor("#cccccc"));
            this.f16401h.setText(second2Min);
            this.f16401h.setVisibility(0);
            this.f16396c.setBackgroundResource(R.drawable.mtg_accept_button_unable);
        } else if (!this.f16405l && i2 <= 0 && this.f16404k > 0) {
            this.f16405l = true;
            this.f16400g.setTextColor(Color.parseColor("#ffffff"));
            GlobalOmegaUtils.trackEvent("ibt_gp_share_matchtogo_available_sw");
            this.f16401h.setVisibility(8);
            this.f16396c.setBackgroundResource(R.drawable.mtg_accept_button_selector);
        }
    }
}
