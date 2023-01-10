package com.didi.component.estimate.newui.view.one;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.estimate.newui.view.viewholder.ItemClickListener;
import com.didi.component.estimate.presenter.AbsEstimatePresenter;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class NewEstimateChooseOneCarView extends FrameLayout {

    /* renamed from: a */
    private Context f14985a;

    /* renamed from: b */
    private View f14986b;

    /* renamed from: c */
    private RecyclerView f14987c;

    /* renamed from: d */
    private OneVerticalAdapter f14988d;

    /* renamed from: e */
    private List<EstimateItemModel> f14989e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SelectItemListener f14990f;

    /* renamed from: g */
    private ItemClickListener f14991g;

    /* renamed from: h */
    private int f14992h;

    /* renamed from: i */
    private View f14993i;

    public interface SelectItemListener {
        void selectItem(EstimateItemModel estimateItemModel, boolean z);
    }

    public NewEstimateChooseOneCarView(Context context) {
        super(context);
        this.f14985a = context;
        initView();
    }

    public NewEstimateChooseOneCarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14985a = context;
        initView();
    }

    public NewEstimateChooseOneCarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14985a = context;
        initView();
    }

    public void initView() {
        View inflate = LayoutInflater.from(this.f14985a).inflate(R.layout.estimate_one_car_view_layout, this, true);
        this.f14986b = inflate;
        this.f14987c = (RecyclerView) inflate.findViewById(R.id.one_car_estimate_list);
        C60431 r0 = new ItemClickListener() {
            public void itemClick(EstimateItemModel estimateItemModel, int i, boolean z) {
                if (NewEstimateChooseOneCarView.this.f14990f != null) {
                    NewEstimateChooseOneCarView.this.f14990f.selectItem(estimateItemModel, z);
                }
            }
        };
        this.f14991g = r0;
        OneVerticalAdapter oneVerticalAdapter = new OneVerticalAdapter(this.f14985a, r0);
        this.f14988d = oneVerticalAdapter;
        this.f14987c.setAdapter(oneVerticalAdapter);
        this.f14987c.setLayoutManager(new LinearLayoutManager(this.f14985a, 1, false));
        this.f14993i = this.f14986b.findViewById(R.id.one_car_loading);
    }

    public void setData(EstimateItemModel estimateItemModel, AbsEstimatePresenter absEstimatePresenter) {
        this.f14989e.clear();
        this.f14992h = estimateItemModel.viewType;
        estimateItemModel.viewType = 3;
        this.f14989e.add(estimateItemModel);
        this.f14988d.setPresenter(absEstimatePresenter);
        this.f14988d.setData(this.f14989e);
        this.f14988d.notifyDataSetChanged();
    }

    public void leave() {
        List<EstimateItemModel> list = this.f14989e;
        if (list != null && list.size() > 0) {
            this.f14989e.get(0).viewType = this.f14992h;
        }
    }

    public void updateItems() {
        this.f14988d.notifyDataSetChanged();
    }

    public void setSelectItemListener(SelectItemListener selectItemListener) {
        this.f14990f = selectItemListener;
    }

    public void showLoading() {
        View view = this.f14993i;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void hideLoading() {
        View view = this.f14993i;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
