package com.didi.component.comp_form_common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.data.form.FormStore;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;

public abstract class AbsFormCommonView implements IFormCommonView {

    /* renamed from: a */
    private ImageView f14058a;

    /* renamed from: b */
    private TextView f14059b;

    /* renamed from: c */
    private View f14060c;
    protected Context mContext;
    protected AbsFormCommonPresenter mPresenter;
    protected View mRootView;

    public AbsFormCommonView(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null && newEstimateItem.showDataPick()) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.select_passenger_vertical, viewGroup, false);
        } else if (newEstimateItem.mFormOperationModel == null || newEstimateItem.mFormOperationModel.items == null || newEstimateItem.mFormOperationModel.items.size() <= 1) {
            this.mRootView = LayoutInflater.from(this.mContext).inflate(R.layout.select_passenger_horizontal, viewGroup, false);
        } else {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.select_passenger_vertical, viewGroup, false);
            this.mRootView = inflate;
            this.f14060c = inflate.findViewById(R.id.divider);
            if (newEstimateItem.mFormOperationModel.items.size() > 1) {
                this.f14060c.setVisibility(0);
            } else {
                this.f14060c.setVisibility(8);
            }
        }
        m11658a();
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(AbsFormCommonPresenter absFormCommonPresenter) {
        this.mPresenter = absFormCommonPresenter;
    }

    /* renamed from: a */
    private void m11658a() {
        this.f14058a = (ImageView) this.mRootView.findViewById(R.id.iv_sp_avatar);
        this.f14059b = (TextView) this.mRootView.findViewById(R.id.tv_sp_text);
        setData(FormStore.getInstance().getSubstituteCallIcon(), FormStore.getInstance().getSubstituteCallText());
    }

    public void setData(String str, String str2) {
        ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder((int) R.drawable.icon_sc_for_me)).error((int) R.drawable.icon_sc_for_me)).into(this.f14058a);
        this.f14059b.setText(str2);
    }

    public void show() {
        this.mRootView.setVisibility(0);
    }

    public void hide() {
        this.mRootView.setVisibility(8);
    }
}
