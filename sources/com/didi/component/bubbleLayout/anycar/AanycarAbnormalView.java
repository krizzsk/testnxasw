package com.didi.component.bubbleLayout.anycar;

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
import java.util.Map;

public class AanycarAbnormalView extends FrameLayout {

    /* renamed from: a */
    private View f12836a;

    /* renamed from: b */
    private Context f12837b;

    /* renamed from: c */
    private ImageView f12838c;

    /* renamed from: d */
    private TextView f12839d;

    /* renamed from: e */
    private TextView f12840e;

    /* renamed from: f */
    private TextView f12841f;

    /* renamed from: g */
    private View f12842g;

    /* renamed from: h */
    private EstimateAbnormalModel f12843h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BtnClickListener f12844i;

    public interface BtnClickListener {
        void click();
    }

    public AanycarAbnormalView(Context context) {
        super(context);
        this.f12837b = context;
        initView();
    }

    public AanycarAbnormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12837b = context;
        initView();
    }

    public AanycarAbnormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12837b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f12837b).inflate(R.layout.anycar_request_error, this, true);
        this.f12836a = inflate;
        inflate.setBackground(this.f12837b.getResources().getDrawable(R.drawable.tab_gradient_bg));
        this.f12836a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f12841f = (TextView) this.f12836a.findViewById(R.id.anycar_abnormal_btn);
        this.f12840e = (TextView) this.f12836a.findViewById(R.id.anycar_abnormal_content);
        this.f12839d = (TextView) this.f12836a.findViewById(R.id.anycar_abnormal_title);
        this.f12838c = (ImageView) this.f12836a.findViewById(R.id.anycar_abnormal_icon);
        this.f12842g = this.f12836a.findViewById(R.id.anycar_abnormal_container);
    }

    public void setData(EstimateAbnormalModel estimateAbnormalModel) {
        this.f12843h = estimateAbnormalModel;
        if (estimateAbnormalModel == null) {
            this.f12841f.setVisibility(0);
            this.f12841f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (AanycarAbnormalView.this.f12844i != null) {
                        AanycarAbnormalView.this.f12844i.click();
                    }
                }
            });
            this.f12838c.setImageDrawable(ResourcesHelper.getDrawable(this.f12837b, R.drawable.new_estimate_error_happen));
            this.f12840e.setText(ResourcesHelper.getString(this.f12837b, R.string.GRider_page_I_suggest_bznI));
            this.f12839d.setText(ResourcesHelper.getString(this.f12837b, R.string.GRider_page_Connection_FZOe));
            this.f12841f.setText(ResourcesHelper.getString(this.f12837b, R.string.GRider_page_Try_again_kabc));
            return;
        }
        this.f12841f.setVisibility(8);
        EstimateAbnormalModel estimateAbnormalModel2 = this.f12843h;
        if (estimateAbnormalModel2 != null && !CollectionUtils.isEmpty((Map) estimateAbnormalModel2.getExtraLog())) {
            GlobalOmegaUtils.trackEvent("ibt_gp_eyeball_exception_sw", this.f12843h.getExtraLog());
        }
        if (!StringUtil.isNullOrEmpty(this.f12843h.abnormalTitle)) {
            this.f12839d.setVisibility(0);
            this.f12839d.setText(this.f12843h.abnormalTitle);
        } else {
            this.f12839d.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(this.f12843h.abnormalContent)) {
            this.f12840e.setVisibility(0);
            this.f12840e.setText(this.f12843h.abnormalContent);
        } else {
            this.f12840e.setVisibility(8);
        }
        if (!StringUtil.isNullOrEmpty(this.f12843h.abnormalIcon)) {
            this.f12838c.setVisibility(0);
            Glide.with(this.f12837b).load(this.f12843h.abnormalIcon).into(this.f12838c);
            return;
        }
        this.f12838c.setVisibility(8);
    }

    public void setClickListener(BtnClickListener btnClickListener) {
        this.f12844i = btnClickListener;
    }
}
