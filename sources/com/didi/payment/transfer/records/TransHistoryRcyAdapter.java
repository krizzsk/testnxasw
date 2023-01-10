package com.didi.payment.transfer.records;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.List;

public class TransHistoryRcyAdapter extends RecyclerView.Adapter<HistoryViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HistoryListItemClickListener f34020a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f34021b;

    /* renamed from: c */
    private HistoryListCallback f34022c;

    /* renamed from: d */
    private List<TransHistoryListResp.HistoryItem> f34023d;

    public interface HistoryListCallback {
        void onLastItemShowed();
    }

    public interface HistoryListItemClickListener {
        void onItemClick(TransHistoryListResp.HistoryItem historyItem);
    }

    public TransHistoryRcyAdapter(Context context, HistoryListCallback historyListCallback, HistoryListItemClickListener historyListItemClickListener) {
        this.f34021b = context;
        this.f34022c = historyListCallback;
        this.f34020a = historyListItemClickListener;
    }

    public void addData(List<TransHistoryListResp.HistoryItem> list) {
        List<TransHistoryListResp.HistoryItem> list2 = this.f34023d;
        if (list2 == null) {
            this.f34023d = list;
            notifyDataSetChanged();
            return;
        }
        int size = list2.size();
        this.f34023d.addAll(list);
        notifyItemInserted(size);
    }

    public HistoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new HistoryViewHolder(LayoutInflater.from(this.f34021b).inflate(R.layout.trans_history_item_lay, viewGroup, false));
    }

    public void onBindViewHolder(HistoryViewHolder historyViewHolder, int i) {
        HistoryListCallback historyListCallback;
        historyViewHolder.bindData(this.f34023d.get(i));
        if (i == this.f34023d.size() - 1 && (historyListCallback = this.f34022c) != null) {
            historyListCallback.onLastItemShowed();
        }
    }

    public int getItemCount() {
        List<TransHistoryListResp.HistoryItem> list = this.f34023d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TransHistoryListResp.HistoryItem mItem;
        private TextView mNameTv;
        private TextView mOrderIdTv;
        private TextView mOrderTimeTv;
        private TextView mPayTypeTv;
        private TextView mPriceTv;
        private TextView mStatusDescTv;

        public HistoryViewHolder(View view) {
            super(view);
            this.mNameTv = (TextView) view.findViewById(R.id.trans_history_item_name_tv);
            this.mOrderIdTv = (TextView) view.findViewById(R.id.trans_history_item_orderId_tv);
            this.mOrderTimeTv = (TextView) view.findViewById(R.id.trans_history_item_time_tv);
            this.mPriceTv = (TextView) view.findViewById(R.id.trans_history_item_price_tv);
            this.mPayTypeTv = (TextView) view.findViewById(R.id.trans_history_item_pay_type_tv);
            this.mStatusDescTv = (TextView) view.findViewById(R.id.trans_history_item_pay_status_tv);
            if (TransHistoryRcyAdapter.this.f34020a != null) {
                view.setOnClickListener(new View.OnClickListener(TransHistoryRcyAdapter.this) {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        TransHistoryRcyAdapter.this.f34020a.onItemClick(HistoryViewHolder.this.mItem);
                    }
                });
            }
        }

        public void bindData(TransHistoryListResp.HistoryItem historyItem) {
            if (historyItem != null) {
                this.mItem = historyItem;
                this.mNameTv.setText(historyItem.name);
                this.mOrderIdTv.setText(historyItem.orderId);
                this.mOrderTimeTv.setText(historyItem.statusTime);
                if (!TextUtil.isEmpty(historyItem.payType)) {
                    this.mPayTypeTv.setText(historyItem.payType);
                } else {
                    this.mPayTypeTv.setVisibility(8);
                }
                this.mPriceTv.setText(String.format(TransHistoryRcyAdapter.this.f34021b.getString(R.string.transfer_record_item_symbal_formater), new Object[]{historyItem.currencySymbol, historyItem.amount}));
                historyItem.statusDesc.bindTextView(this.mStatusDescTv);
            }
        }
    }
}
