package com.didi.component.estimatepass;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.estimatepass.IEstimatePassView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.app.BusinessContext;
import com.taxis99.R;

public class EstimateView implements View.OnClickListener, IEstimatePassView {

    /* renamed from: a */
    private EstimatePassPresenter f15141a;

    /* renamed from: b */
    private Context f15142b;

    /* renamed from: c */
    private final View f15143c;

    /* renamed from: d */
    private LinearLayout f15144d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ImageView f15145e = ((ImageView) this.f15143c.findViewById(R.id.estimate_pass_check_iv));

    /* renamed from: f */
    private final TextView f15146f = ((TextView) this.f15143c.findViewById(R.id.estimate_pass_info_tv));

    /* renamed from: g */
    private ImageView f15147g = ((ImageView) this.f15143c.findViewById(R.id.estimate_pass_more_iv));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IEstimatePassView.OnCheckChangeListener f15148h;

    public EstimateView(BusinessContext businessContext, ViewGroup viewGroup) {
        Context context = businessContext.getContext();
        this.f15142b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.estimate_pass_layout, viewGroup, false);
        this.f15143c = inflate;
        this.f15144d = (LinearLayout) inflate.findViewById(R.id.estimate_pass_ll);
        this.f15145e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = !EstimateView.this.f15145e.isSelected();
                EstimateView.this.setCheck(z);
                if (EstimateView.this.f15148h != null) {
                    EstimateView.this.f15148h.onCheckChange(z);
                }
            }
        });
        this.f15147g.setOnClickListener(this);
    }

    public void showPassToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            LEGOToastHelper.showShortPosToast(this.f15142b, str);
        }
    }

    public void setOnCheckChangeListener(IEstimatePassView.OnCheckChangeListener onCheckChangeListener) {
        this.f15148h = onCheckChangeListener;
    }

    public View getView() {
        return this.f15143c;
    }

    public void setPresenter(EstimatePassPresenter estimatePassPresenter) {
        this.f15141a = estimatePassPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.estimate_pass_more_iv) {
            this.f15141a.openPassWebView();
        }
    }

    public void setPassInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15146f.setText(str);
        }
    }

    public void setPassRichInfo(LEGORichInfo lEGORichInfo) {
        lEGORichInfo.bindTextView(this.f15146f);
    }

    public void setCheck(boolean z) {
        this.f15145e.setSelected(z);
    }

    public void setCheckBoxVisibility(int i) {
        this.f15145e.setVisibility(i);
    }

    public void setVisibility(int i) {
        this.f15143c.setVisibility(i);
    }

    public void setArrowVisibility(int i) {
        this.f15147g.setVisibility(i);
    }
}
