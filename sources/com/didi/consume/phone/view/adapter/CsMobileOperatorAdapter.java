package com.didi.consume.phone.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.payment.base.utils.GlideUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsMobileOperatorAdapter extends RecyclerView.Adapter<AmountHolder> implements View.OnClickListener {

    /* renamed from: a */
    private final List<CsOperatorListResp.Operator> f18158a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final OnOperatorClickListener f18159b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f18160c;

    public interface OnOperatorClickListener {
        void onClick(CsOperatorListResp.Operator operator);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public CsMobileOperatorAdapter(Context context, List<CsOperatorListResp.Operator> list, OnOperatorClickListener onOperatorClickListener) {
        ArrayList arrayList = new ArrayList();
        this.f18158a = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f18159b = onOperatorClickListener;
        this.f18160c = context;
    }

    public void refreshSelectOperator(CsOperatorListResp.Operator operator) {
        Iterator<CsOperatorListResp.Operator> it = this.f18158a.iterator();
        while (it.hasNext()) {
            CsOperatorListResp.Operator next = it.next();
            next.selected = next == operator;
        }
        notifyDataSetChanged();
    }

    public CsOperatorListResp.Operator getCurrentSelectItem() {
        for (CsOperatorListResp.Operator next : this.f18158a) {
            if (next.selected) {
                return next;
            }
        }
        return null;
    }

    public AmountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AmountHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cs_fragment_operator_item, viewGroup, false), this.f18159b);
    }

    public void onBindViewHolder(AmountHolder amountHolder, int i) {
        amountHolder.bind(this.f18158a.get(i));
    }

    public int getItemCount() {
        return this.f18158a.size();
    }

    public class AmountHolder extends RecyclerView.ViewHolder {
        private ImageView mIVCarrier;
        private View mVSelected;

        public AmountHolder(View view, OnOperatorClickListener onOperatorClickListener) {
            super(view);
            this.mIVCarrier = (ImageView) view.findViewById(R.id.iv_operator_icon);
            this.mVSelected = view.findViewById(R.id.v_operator_selected);
        }

        public void bind(final CsOperatorListResp.Operator operator) {
            GlideUtils.with2load2into(CsMobileOperatorAdapter.this.f18160c, operator.iconUrl, this.mIVCarrier);
            if (operator.selected) {
                this.mVSelected.setVisibility(0);
            } else {
                this.mVSelected.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (CsMobileOperatorAdapter.this.f18159b != null) {
                        CsMobileOperatorAdapter.this.f18159b.onClick(operator);
                    }
                }
            });
        }
    }
}
