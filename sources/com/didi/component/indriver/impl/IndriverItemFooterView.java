package com.didi.component.indriver.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.indriver.AbsIndriverPresenter;
import com.taxis99.R;

public class IndriverItemFooterView extends ConstraintLayout {

    /* renamed from: a */
    private View f15992a;

    /* renamed from: b */
    private Context f15993b;

    /* renamed from: c */
    private TextView f15994c;

    /* renamed from: d */
    private ImageView f15995d;

    /* renamed from: e */
    private boolean f15996e = true;
    protected AbsIndriverPresenter mPresenter;

    public IndriverItemFooterView(Context context) {
        super(context);
        this.f15993b = context;
        m13289a(context);
    }

    public IndriverItemFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15993b = context;
        m13289a(context);
    }

    public IndriverItemFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15993b = context;
        m13289a(context);
    }

    public void setPrisenter(AbsIndriverPresenter absIndriverPresenter) {
        this.mPresenter = absIndriverPresenter;
    }

    public void setArrowExpand(boolean z) {
        this.f15996e = z;
    }

    /* renamed from: a */
    private void m13289a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.indriver_item_footer, this, true);
        this.f15992a = inflate;
        this.f15994c = (TextView) inflate.findViewById(R.id.expand_tv);
        this.f15995d = (ImageView) this.f15992a.findViewById(R.id.arrow_iv);
        this.f15992a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IndriverItemFooterView.this.updateHeightWithAnim();
            }
        });
    }

    public boolean isArrowExpand() {
        return this.f15996e;
    }

    public void updateHeightWithAnim() {
        GLog.m11357e("dxt", "updateHeightWithAnim " + this.f15996e);
        AbsIndriverPresenter absIndriverPresenter = this.mPresenter;
        if (absIndriverPresenter != null) {
            absIndriverPresenter.expandView(this.f15996e);
            if (this.f15996e) {
                this.f15995d.setBackgroundResource(R.drawable.arrow_up);
                this.f15994c.setText(getResources().getString(R.string.GDriver_Fix_Collapse_ilot));
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_negotiate_detail_unfold_ck");
            } else {
                GlobalOmegaUtils.trackEvent("ibt_gp_carconfirm_negotiate_detail_pack_ck");
                this.f15995d.setBackgroundResource(R.drawable.arrow_donw);
                this.f15994c.setText(getResources().getString(R.string.GDriver_Fix_Launching_yxfQ));
            }
            this.f15996e = !this.f15996e;
        }
    }
}
