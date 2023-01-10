package com.didiglobal.comp.carmodellist.optionarea.estimatepass;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didiglobal.comp.carmodellist.common.AnyCarSelectListener;
import com.taxis99.R;
import java.util.Collection;

public class AnyCarModelEstimateOptionsView extends FrameLayout {

    /* renamed from: a */
    private Context f52384a;

    /* renamed from: b */
    private RecyclerView f52385b;

    /* renamed from: c */
    private AnyCarModelEstimateOptionAdapter f52386c;

    /* renamed from: d */
    private ItemClickListener f52387d;

    public interface ItemClickListener {
        void itemClick(AnyCarEstimateItemModel anyCarEstimateItemModel, int i, boolean z);
    }

    public AnyCarModelEstimateOptionsView(Context context) {
        super(context);
        this.f52384a = context;
        initView();
    }

    public AnyCarModelEstimateOptionsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52384a = context;
        initView();
    }

    public AnyCarModelEstimateOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f52384a = context;
        initView();
    }

    public void initView() {
        LayoutInflater.from(this.f52384a).inflate(R.layout.car_model_estimate_options_layout, this);
        this.f52385b = (RecyclerView) findViewById(R.id.new_estimate_data_list);
        this.f52386c = new AnyCarModelEstimateOptionAdapter(this.f52384a);
    }

    public void setData(AnyCarEstimateItemModel anyCarEstimateItemModel, AnyCarSelectListener anyCarSelectListener) {
        if (!CollectionUtil.isEmpty((Collection<?>) anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation)) {
            this.f52385b.setAdapter(this.f52386c);
            this.f52385b.setLayoutManager(new GridLayoutManager(this.f52384a, anyCarEstimateItemModel.mAnyCarEstimateNetItem.carOperation.size()));
            this.f52386c.setData(anyCarEstimateItemModel, anyCarSelectListener);
            this.f52386c.notifyDataSetChanged();
        }
    }

    public void setEstimateItemClick(ItemClickListener itemClickListener) {
        this.f52387d = itemClickListener;
    }
}
