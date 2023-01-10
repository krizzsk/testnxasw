package com.didi.component.dispatchfee.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.dispatchfee.AbsDispatchFeePresenter;
import com.didi.component.dispatchfee.IDispatchFeeView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class DispatchFeeView implements View.OnClickListener, IDispatchFeeView {

    /* renamed from: a */
    private View f14638a;

    /* renamed from: b */
    private ImageView f14639b = ((ImageView) this.f14638a.findViewById(R.id.iv_dispatch_fee));

    /* renamed from: c */
    private AbsDispatchFeePresenter f14640c;

    /* renamed from: d */
    private Context f14641d;
    public TextView mDispatchFeeTv;

    public DispatchFeeView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f14641d = componentParams.bizCtx.getContext();
        View inflate = LayoutInflater.from(componentParams.bizCtx.getContext()).inflate(R.layout.global_dispatch_fee_new_ui_layout, viewGroup, false);
        this.f14638a = inflate;
        this.mDispatchFeeTv = (TextView) inflate.findViewById(R.id.tv_dispatch_fee_msg);
        this.f14638a.setOnClickListener(this);
    }

    public View getView() {
        return this.f14638a;
    }

    public void setPresenter(AbsDispatchFeePresenter absDispatchFeePresenter) {
        this.f14640c = absDispatchFeePresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        AbsDispatchFeePresenter absDispatchFeePresenter = this.f14640c;
        if (absDispatchFeePresenter != null) {
            absDispatchFeePresenter.onClick(view);
        }
    }

    public void setDispatchFee(String str) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTextColor(int i) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setClickable(boolean z) {
        View view = this.f14638a;
        if (view != null) {
            view.setClickable(z);
        }
    }

    public void bindDispatchFee(GlobalRichInfo globalRichInfo) {
        TextView textView = this.mDispatchFeeTv;
        if (textView != null) {
            globalRichInfo.bindTextView(textView);
        }
    }

    public void setDispatchIcon(String str) {
        if (this.f14639b != null) {
            ((RequestBuilder) Glide.with(this.f14641d).load(str).placeholder((int) R.drawable.global_dispatchfee_service_icon_dispatching_fee)).into(this.f14639b);
        }
    }
}
