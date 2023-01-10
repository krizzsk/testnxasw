package com.didi.component.company;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.company.model.CompanyInfo;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class NewCompanyView implements View.OnClickListener, ICompanyView {

    /* renamed from: a */
    private View f14393a;

    /* renamed from: b */
    private TextView f14394b = ((TextView) this.f14393a.findViewById(R.id.tv_global_form_company_label));

    /* renamed from: c */
    private ImageView f14395c = ((ImageView) this.f14393a.findViewById(R.id.iv_global_form_company_icon));

    /* renamed from: d */
    private AbsCompanyPresenter f14396d;

    /* renamed from: e */
    private Activity f14397e;

    /* renamed from: f */
    private GlobalTipsContainer f14398f;

    public void clearTips() {
    }

    public void setCompany(CompanyInfo companyInfo) {
    }

    public void setEnable(boolean z) {
    }

    public NewCompanyView(Activity activity, ViewGroup viewGroup) {
        this.f14397e = activity;
        View inflate = activity.getLayoutInflater().inflate(R.layout.new_global_form_company_select, viewGroup, false);
        this.f14393a = inflate;
        inflate.setOnClickListener(this);
    }

    public View getView() {
        return this.f14393a;
    }

    public void setPresenter(AbsCompanyPresenter absCompanyPresenter) {
        this.f14396d = absCompanyPresenter;
    }

    public void setIcon(String str) {
        if (!StringUtil.isNullOrEmpty(str) && this.f14395c != null) {
            Glide.with(this.f14397e.getApplicationContext()).load(str).into(this.f14395c);
        }
    }

    public void setLabel(String str) {
        TextView textView = this.f14394b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bindRichInfo(GlobalRichInfo globalRichInfo) {
        if (this.f14394b != null && !TextUtils.isEmpty(globalRichInfo.getContent())) {
            globalRichInfo.bindTextView(this.f14394b);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            AbsCompanyPresenter absCompanyPresenter = this.f14396d;
            if (absCompanyPresenter != null) {
                absCompanyPresenter.showCompanySelectPage();
            }
            clearTips();
        }
    }
}
