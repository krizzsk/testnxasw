package com.didi.payment.wallet.global.wallet.view.view.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletHomeConsumeEnterAdapter;
import com.taxis99.R;

public class WalletHomeConsumeSectionView extends WalletHomeAbsSectionView<WalletHomeResp.ConsumeSection, WalletHomeContract.Listener> implements WalletHomeConsumeEnterAdapter.AdapterItemCallback {

    /* renamed from: a */
    private TextView f35123a;

    /* renamed from: b */
    private RecyclerView f35124b;

    /* renamed from: c */
    private WalletHomeConsumeEnterAdapter f35125c;

    public WalletHomeConsumeSectionView(Context context) {
        super(context);
    }

    public WalletHomeConsumeSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletHomeConsumeSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_consume_enter_section, this, true);
        this.f35123a = (TextView) findViewById(R.id.tv_consume_title);
        this.f35124b = (RecyclerView) findViewById(R.id.rv_consume_list);
        this.f35125c = new WalletHomeConsumeEnterAdapter(getContext(), this);
        this.f35124b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f35124b.setAdapter(this.f35125c);
        this.f35124b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletHomeResp.ConsumeSection consumeSection) {
        if (consumeSection == null || consumeSection.entryList == null || consumeSection.entryList.size() < 2) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f35123a.setText(consumeSection.title);
        this.f35125c.setData(consumeSection.entryList);
    }

    public void onConsumeEntryItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
        if (this.mListener != null) {
            ((WalletHomeContract.Listener) this.mListener).onConsumeItemClicked(consumeItem);
        }
    }
}
