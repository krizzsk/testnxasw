package com.didi.payment.transfer.historyaccounts;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransHistoryAccountAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int PAGE_TYPE_CFMPHONE = 0;
    public static final int PAGE_TYPE_TRANSFER2BANK = 1;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f33932a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f33933b;

    /* renamed from: c */
    private List<NNPayAccount> f33934c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnItemClickListener f33935d;

    public interface OnItemClickListener {
        void onItemClick(NNPayAccount nNPayAccount);
    }

    public TransHistoryAccountAdapter(Context context, int i, List<NNPayAccount> list) {
        this.f33932a = context;
        this.f33934c = list == null ? new ArrayList<>() : list;
        this.f33933b = i;
    }

    public void updateData(List<NNPayAccount> list) {
        this.f33934c.clear();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            this.f33934c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trans_history_account_item_lay, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bind(!CollectionUtil.isEmpty((Collection<?>) this.f33934c) ? this.f33934c.get(i) : null);
    }

    public int getItemCount() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f33934c)) {
            return 0;
        }
        return this.f33934c.size();
    }

    public void setOnItemclickListener(OnItemClickListener onItemClickListener) {
        this.f33935d = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public NNPayAccount data;
        private TextView mBankCardTv;
        private ImageView mHeadImg;
        private TextView mNameTv;

        public ViewHolder(View view) {
            super(view);
            this.mHeadImg = (ImageView) view.findViewById(R.id.trans_history_account_headicon_img);
            this.mNameTv = (TextView) view.findViewById(R.id.trans_account_item_name_tv);
            this.mBankCardTv = (TextView) view.findViewById(R.id.trans_account_item_tel_tv);
            view.setOnClickListener(new DoubleCheckOnClickListener(TransHistoryAccountAdapter.this) {
                public void doClick(View view) {
                    if (TransHistoryAccountAdapter.this.f33935d != null) {
                        TransHistoryAccountAdapter.this.f33935d.onItemClick(ViewHolder.this.data);
                    }
                }
            });
        }

        public void bind(NNPayAccount nNPayAccount) {
            String str;
            if (nNPayAccount != null) {
                this.data = nNPayAccount;
                GlideUtils.loadCircleImageWithDefaultImg(TransHistoryAccountAdapter.this.f33932a, Uri.parse(nNPayAccount.getValueByType(IConfirmTransferInfo.ValueType.To_IconURL)), R.drawable.pay_icon_contacts, this.mHeadImg);
                String valueByType = nNPayAccount.getValueByType(IConfirmTransferInfo.ValueType.NAME);
                if (TransHistoryAccountAdapter.this.f33933b == 0) {
                    str = nNPayAccount.getValueByType(IConfirmTransferInfo.ValueType.To_Show_Phone);
                } else {
                    str = TextUtil.isEmpty(nNPayAccount.toCardIdSuffix) ? nNPayAccount.getValueByType(IConfirmTransferInfo.ValueType.BANK_CARD) : nNPayAccount.toCardIdSuffix;
                }
                if (!TextUtil.isEmpty(valueByType)) {
                    this.mNameTv.setVisibility(0);
                    this.mNameTv.setText(valueByType);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.mBankCardTv.setVisibility(0);
                    this.mBankCardTv.setText(str);
                }
            }
        }
    }
}
