package com.didi.sdk.global.enterprise.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class EnterprisePaymentListAdapter extends RecyclerView.Adapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<EnterpriseItem> f38917a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnItemSelectListener f38918b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f38919c = -1;

    public interface OnItemSelectListener {
        void onItemSelect(int i, EnterpriseItem enterpriseItem, boolean z);
    }

    /* renamed from: a */
    private void m29273a(String str) {
        if (str == null) {
            this.f38919c = -1;
            return;
        }
        int i = 0;
        Iterator<EnterpriseItem> it = this.f38917a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().getId().equals(str)) {
                this.f38919c = i;
                break;
            } else {
                i++;
            }
        }
        if (i >= this.f38917a.size()) {
            this.f38919c = -1;
        }
    }

    public void refresh(List<EnterpriseItem> list, String str) {
        if (list != null) {
            this.f38917a.clear();
            this.f38917a.addAll(list);
            m29273a(str);
            notifyDataSetChanged();
        }
    }

    public void setItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.f38918b = onItemSelectListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_payment_adapter_enterprise_list_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).bind(i);
        }
    }

    public int getItemCount() {
        return this.f38917a.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivCheck;
        private TextView tvTitle;

        public ViewHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.ivCheck = (ImageView) view.findViewById(R.id.iv_check);
            view.setOnClickListener(this);
        }

        public void bind(int i) {
            this.tvTitle.setText(((EnterpriseItem) EnterprisePaymentListAdapter.this.f38917a.get(i)).getName());
            this.ivCheck.setImageResource(EnterprisePaymentListAdapter.this.f38919c == i ? R.drawable.one_payment_global_list_select : 0);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            boolean z = EnterprisePaymentListAdapter.this.f38919c == getAdapterPosition();
            if (!z) {
                int unused = EnterprisePaymentListAdapter.this.f38919c = getAdapterPosition();
                EnterprisePaymentListAdapter.this.notifyDataSetChanged();
            }
            if (EnterprisePaymentListAdapter.this.f38918b != null) {
                EnterprisePaymentListAdapter.this.f38918b.onItemSelect(EnterprisePaymentListAdapter.this.f38919c, (EnterpriseItem) EnterprisePaymentListAdapter.this.f38917a.get(EnterprisePaymentListAdapter.this.f38919c), z);
            }
        }
    }
}
