package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.StringUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.estimate.EstimateAbnormalModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class NewEstimateAbnormalView extends FrameLayout {

    /* renamed from: a */
    private View f14956a;

    /* renamed from: b */
    private Context f14957b;

    /* renamed from: c */
    private ImageView f14958c;

    /* renamed from: d */
    private TextView f14959d;

    /* renamed from: e */
    private TextView f14960e;

    /* renamed from: f */
    private TextView f14961f;

    /* renamed from: g */
    private View f14962g;

    /* renamed from: h */
    private List<EstimateAbnormalModel> f14963h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BtnClickListener f14964i;

    public interface BtnClickListener {
        void click();
    }

    public NewEstimateAbnormalView(Context context) {
        super(context);
        this.f14957b = context;
        initView();
    }

    public NewEstimateAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14957b = context;
        initView();
    }

    public NewEstimateAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14957b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f14957b).inflate(R.layout.new_etsimate_request_error, this, true);
        this.f14956a = inflate;
        inflate.setBackground(this.f14957b.getResources().getDrawable(R.drawable.tab_gradient_bg));
        this.f14961f = (TextView) this.f14956a.findViewById(R.id.new_estimate_abnormal_btn);
        this.f14960e = (TextView) this.f14956a.findViewById(R.id.new_estimate_abnormal_content);
        this.f14959d = (TextView) this.f14956a.findViewById(R.id.new_estimate_abnormal_title);
        this.f14958c = (ImageView) this.f14956a.findViewById(R.id.new_estimate_abnormal_icon);
        this.f14962g = this.f14956a.findViewById(R.id.new_estimate_abnormal_container);
    }

    public void setData(List<EstimateAbnormalModel> list) {
        this.f14963h = list;
        if (CollectionUtils.isEmpty((Collection) list)) {
            this.f14961f.setVisibility(0);
            this.f14961f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (NewEstimateAbnormalView.this.f14964i != null) {
                        NewEstimateAbnormalView.this.f14964i.click();
                    }
                }
            });
            this.f14958c.setImageDrawable(ResourcesHelper.getDrawable(this.f14957b, R.drawable.new_estimate_error_happen));
            this.f14960e.setText(ResourcesHelper.getString(this.f14957b, R.string.GRider_page_I_suggest_bznI));
            this.f14959d.setText(ResourcesHelper.getString(this.f14957b, R.string.GRider_page_Connection_FZOe));
            this.f14961f.setText(ResourcesHelper.getString(this.f14957b, R.string.GRider_page_Try_again_kabc));
            return;
        }
        this.f14961f.setVisibility(8);
        EstimateAbnormalModel estimateAbnormalModel = this.f14963h.get(0);
        if (estimateAbnormalModel != null && !CollectionUtils.isEmpty((Map) estimateAbnormalModel.getExtraLog())) {
            GlobalOmegaUtils.trackEvent("ibt_gp_eyeball_exception_sw", estimateAbnormalModel.getExtraLog());
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalTitle)) {
            this.f14959d.setVisibility(0);
            this.f14959d.setText(estimateAbnormalModel.abnormalTitle);
        } else {
            this.f14959d.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalContent)) {
            this.f14960e.setVisibility(0);
            this.f14960e.setText(estimateAbnormalModel.abnormalContent);
        } else {
            this.f14960e.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(estimateAbnormalModel.abnormalIcon)) {
            this.f14958c.setVisibility(0);
            Glide.with(this.f14957b).load(estimateAbnormalModel.abnormalIcon).into(this.f14958c);
            return;
        }
        this.f14958c.setVisibility(8);
    }

    public void setClickListener(BtnClickListener btnClickListener) {
        this.f14964i = btnClickListener;
    }
}
