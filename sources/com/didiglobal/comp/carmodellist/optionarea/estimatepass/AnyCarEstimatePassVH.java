package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.GlobalWebActivity;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.BaseVH;
import com.didiglobal.comp.carmodellist.optionarea.estimatepass.IAnyCarEstimatePassView;
import com.taxis99.R;
import java.util.HashMap;

public class AnyCarEstimatePassVH extends BaseVH<AnyCarEstimateItemModel> implements View.OnClickListener, IAnyCarEstimatePassView {

    /* renamed from: a */
    private AnyCarEstimatePassPresenter f52373a;

    /* renamed from: b */
    private Context f52374b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f52375c;

    /* renamed from: d */
    private TextView f52376d;

    /* renamed from: e */
    private ImageView f52377e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IAnyCarEstimatePassView.OnCheckChangeListener f52378f;

    /* renamed from: g */
    private AnyCarEstimateItemModel f52379g;

    public AnyCarEstimatePassVH(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.car_model_estimate_pass_layout, viewGroup, false));
        this.f52374b = viewGroup.getContext();
        m39365a();
    }

    /* renamed from: a */
    private void m39365a() {
        this.f52375c = (ImageView) this.itemView.findViewById(R.id.estimate_pass_check_iv);
        this.f52376d = (TextView) this.itemView.findViewById(R.id.estimate_pass_info_tv);
        this.f52377e = (ImageView) this.itemView.findViewById(R.id.estimate_pass_more_iv);
        this.f52375c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = !AnyCarEstimatePassVH.this.f52375c.isSelected();
                AnyCarEstimatePassVH.this.setCheck(z);
                if (AnyCarEstimatePassVH.this.f52378f != null) {
                    AnyCarEstimatePassVH.this.f52378f.onCheckChange(z);
                }
            }
        });
        this.f52377e.setOnClickListener(this);
        this.f52373a = new AnyCarEstimatePassPresenter(this);
    }

    public void showPassToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            LEGOToastHelper.showShortPosToast(this.f52374b, str);
        }
    }

    public void setOnCheckChangeListener(IAnyCarEstimatePassView.OnCheckChangeListener onCheckChangeListener) {
        this.f52378f = onCheckChangeListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.estimate_pass_more_iv) {
            openPassWebView();
        }
    }

    public void openPassWebView() {
        HashMap hashMap = new HashMap();
        AnyCarEstimateItemModel anyCarEstimateItemModel = this.f52379g;
        String str = (anyCarEstimateItemModel == null || anyCarEstimateItemModel.estimatePass == null || this.f52379g.estimatePass.operationData == null) ? "" : this.f52379g.estimatePass.operationData.link;
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(this.f52374b, GlobalWebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(GlobalWebUrl.buildUrl(str, hashMap)));
            this.f52374b.startActivity(intent);
            ((Activity) this.f52374b).overridePendingTransition(R.anim.side_right_in, R.anim.anim_none);
            GlobalOmegaUtils.trackEvent("ibt_gp_bubblepagepurchase_arrow_click_ck");
        }
    }

    public void setPassRichInfo(LEGORichInfo lEGORichInfo) {
        lEGORichInfo.bindTextView(this.f52376d);
    }

    public void setCheck(boolean z) {
        this.f52375c.setSelected(z);
    }

    public void setCheckBoxVisibility(int i) {
        this.f52375c.setVisibility(i);
    }

    public void setVisibility(int i) {
        this.itemView.setVisibility(i);
    }

    public void setArrowVisibility(int i) {
        this.f52377e.setVisibility(i);
    }

    public void bindData(AnyCarEstimateItemModel anyCarEstimateItemModel) {
        this.f52379g = anyCarEstimateItemModel;
        this.f52373a.bindData(anyCarEstimateItemModel);
    }
}
