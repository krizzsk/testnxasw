package com.didi.soda.bill.view.item.tipfee;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BillTipsFeeListItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Long FLAG_OF_OTHER_ITEM_VALUE = -1L;
    public static final int VIEW_TYPE_NORMAL_ITEM = 1;
    public static final int VIEW_TYPE_OTHER = 2;

    /* renamed from: a */
    private BillTipModel f41971a;

    /* renamed from: b */
    private String f41972b;

    /* renamed from: c */
    private List<Long> f41973c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnItemClickListener f41974d;

    /* renamed from: e */
    private OnItemBindListener f41975e;

    /* renamed from: f */
    private ScopeContext f41976f;

    public interface OnItemBindListener {
        void onItemBind(View view);
    }

    public interface OnItemClickListener {
        void onItemClick(Long l, int i, int i2);
    }

    public BillTipsFeeListItemAdapter(ScopeContext scopeContext) {
        this.f41976f = scopeContext;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f41974d = onItemClickListener;
    }

    public void setOnItemBindListener(OnItemBindListener onItemBindListener) {
        this.f41975e = onItemBindListener;
    }

    public int getItemViewType(int i) {
        return (i != this.f41973c.size() - 1 || this.f41973c.get(i) == null) ? 1 : 2;
    }

    public int getItemCount() {
        return this.f41973c.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        List<Long> list;
        String str;
        String str2;
        if (viewHolder != null && (list = this.f41973c) != null && i < list.size()) {
            final Long l = this.f41973c.get(i);
            if (this.f41971a != null && l != null) {
                boolean z = false;
                if (getItemViewType(i) == 1) {
                    if (this.f41971a.isPercent()) {
                        str2 = l + "%";
                    } else if (l.longValue() % 100 == 0) {
                        str2 = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(l.longValue(), this.f41972b);
                    } else {
                        str2 = LocalizationUtils.CurrencyUtils.getCurrency(l.longValue(), this.f41972b);
                    }
                    BillTipFeeItemViewHolder billTipFeeItemViewHolder = (BillTipFeeItemViewHolder) viewHolder;
                    String str3 = (this.f41971a.getMSuggestionEntity() == null || i != this.f41971a.getMSuggestionEntity().iconPosition) ? "" : this.f41971a.getMSuggestionEntity().iconUrl;
                    TipsFeeListItemView access$000 = billTipFeeItemViewHolder.mTipFeeItemView;
                    if (l.longValue() == this.f41971a.getTipFeeValue()) {
                        z = true;
                    }
                    access$000.setData(str2, z, str3, this.f41976f);
                    billTipFeeItemViewHolder.mTipFeeItemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (BillTipsFeeListItemAdapter.this.f41974d != null) {
                                BillTipsFeeListItemAdapter.this.f41974d.onItemClick(l, i, 1);
                            }
                        }
                    });
                    return;
                }
                BillTipFeeOtherViewHolder billTipFeeOtherViewHolder = (BillTipFeeOtherViewHolder) viewHolder;
                if (l == FLAG_OF_OTHER_ITEM_VALUE) {
                    str = ResourceHelper.getString(R.string.customer_cart_business_tip_other);
                } else if (this.f41971a.isPercent()) {
                    str = l + "%";
                } else if (l.longValue() % 100 == 0) {
                    str = LocalizationUtils.CurrencyUtils.getSimplifiedCurrencyWithSymbol(l.longValue(), this.f41972b);
                } else {
                    str = LocalizationUtils.CurrencyUtils.getCurrency(l.longValue(), this.f41972b);
                }
                TipsFeeListOtherView access$200 = billTipFeeOtherViewHolder.mTipsOtherView;
                if (l != FLAG_OF_OTHER_ITEM_VALUE) {
                    z = true;
                }
                access$200.setData(str, z, this.f41976f);
                billTipFeeOtherViewHolder.mTipsOtherView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (BillTipsFeeListItemAdapter.this.f41974d != null) {
                            BillTipsFeeListItemAdapter.this.f41974d.onItemClick(l, i, 2);
                        }
                    }
                });
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new BillTipFeeItemViewHolder(new TipsFeeListItemView(viewGroup.getContext()));
        }
        return new BillTipFeeOtherViewHolder(new TipsFeeListOtherView(viewGroup.getContext()));
    }

    public void setData(BillTipModel billTipModel, String str) {
        if (billTipModel != null) {
            this.f41971a = billTipModel;
            this.f41972b = str;
            this.f41973c.clear();
            if (!CollectionsUtil.isEmpty(billTipModel.getTipConfigList())) {
                this.f41973c.addAll(billTipModel.getTipConfigList());
            }
            notifyDataSetChanged();
        }
    }

    static class BillTipFeeItemViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TipsFeeListItemView mTipFeeItemView;

        BillTipFeeItemViewHolder(TipsFeeListItemView tipsFeeListItemView) {
            super(tipsFeeListItemView);
            this.mTipFeeItemView = tipsFeeListItemView;
        }
    }

    static class BillTipFeeOtherViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TipsFeeListOtherView mTipsOtherView;

        BillTipFeeOtherViewHolder(TipsFeeListOtherView tipsFeeListOtherView) {
            super(tipsFeeListOtherView);
            this.mTipsOtherView = tipsFeeListOtherView;
        }
    }
}
