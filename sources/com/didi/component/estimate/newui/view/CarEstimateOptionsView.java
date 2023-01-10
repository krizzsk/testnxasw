package com.didi.component.estimate.newui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.estimate.newui.view.EstimateOptionAdapter;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.Collection;

public class CarEstimateOptionsView extends FrameLayout {

    /* renamed from: a */
    private View f14883a;

    /* renamed from: b */
    private Context f14884b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecyclerView f14885c;

    /* renamed from: d */
    private EstimateOptionAdapter f14886d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ItemClickListener f14887e;

    public CarEstimateOptionsView(Context context) {
        super(context);
        this.f14884b = context;
        initView();
    }

    public CarEstimateOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14884b = context;
        initView();
    }

    public CarEstimateOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14884b = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f14884b).inflate(R.layout.car_estimate_options_layout, this, true);
        this.f14883a = inflate;
        this.f14885c = (RecyclerView) inflate.findViewById(R.id.new_estimate_data_list);
        this.f14886d = new EstimateOptionAdapter(this.f14884b, new EstimateOptionAdapter.EstimateOptionsCallback() {
            public void twoPriceItemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (CarEstimateOptionsView.this.f14887e == null) {
                    return;
                }
                if (z) {
                    CarEstimateOptionsView.this.f14887e.itemClick(estimateItemModel, i, true);
                } else {
                    CarEstimateOptionsView.this.f14887e.itemClick(estimateItemModel, i, false);
                }
            }

            public void optionsListGone() {
                CarEstimateOptionsView.this.f14885c.setVisibility(8);
            }
        });
    }

    public void setPresenter(AbsEstimatePresenter absEstimatePresenter) {
        this.f14886d.setPresenter(absEstimatePresenter);
    }

    public boolean setData(EstimateItemModel estimateItemModel) {
        if (CollectionUtils.isEmpty((Collection) estimateItemModel.carOperation)) {
            this.f14885c.setVisibility(8);
            return false;
        }
        this.f14885c.setVisibility(0);
        this.f14885c.setAdapter((RecyclerView.Adapter) null);
        this.f14885c.setLayoutManager((RecyclerView.LayoutManager) null);
        this.f14886d.onDestroy();
        this.f14885c.setAdapter(this.f14886d);
        this.f14885c.setLayoutManager(new GridLayoutManager(this.f14884b, estimateItemModel.carOperation.size(), 1, false));
        this.f14886d.setData(estimateItemModel.carOperation, estimateItemModel);
        this.f14886d.notifyDataSetChanged();
        return true;
    }

    public void setEstimateItemClick(ItemClickListener itemClickListener) {
        this.f14887e = itemClickListener;
    }
}
