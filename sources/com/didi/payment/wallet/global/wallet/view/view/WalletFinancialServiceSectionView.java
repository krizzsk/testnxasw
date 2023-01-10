package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletFinancialServiceEnterAdapter;
import com.taxis99.R;
import java.util.ArrayList;

public class WalletFinancialServiceSectionView extends WalletAbsSectionView<WalletPageQueryResp.FinanceSection, IWalletMainListEventListener> implements WalletFinancialServiceEnterAdapter.FinanceItemClickListener {

    /* renamed from: a */
    private TextView f34955a;

    /* renamed from: b */
    private RecyclerView f34956b;

    /* renamed from: c */
    private WalletFinancialServiceEnterAdapter f34957c;

    public WalletFinancialServiceSectionView(Context context) {
        super(context);
    }

    public WalletFinancialServiceSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletFinancialServiceSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onFinanceItemClick(WalletPageQueryResp.FinanceItem financeItem) {
        if (this.mListener != null) {
            ((IWalletMainListEventListener) this.mListener).onFinanceItemClick(financeItem);
        }
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_consume_enter_section, this, true);
        this.f34955a = (TextView) findViewById(R.id.wallet_consume_enter_title);
        this.f34956b = (RecyclerView) findViewById(R.id.wallet_consume_enter_rl);
        this.f34957c = new WalletFinancialServiceEnterAdapter(context, this);
        this.f34956b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f34956b.setAdapter(this.f34957c);
        this.f34956b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletPageQueryResp.FinanceSection financeSection) {
        if (financeSection == null || financeSection.entryList == null || financeSection.entryList.isEmpty()) {
            setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WalletPageQueryResp.FinanceItem next : financeSection.entryList) {
            if (next.enabled) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f34955a.setText(financeSection.title);
        this.f34957c.setData(arrayList);
    }
}
