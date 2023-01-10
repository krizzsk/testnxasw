package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletHomeConsumeEnterAdapter;
import com.taxis99.R;

public class WalletConsumeSectionView extends WalletAbsSectionView<WalletHomeResp.ConsumeSection, IWalletMainListEventListener> implements WalletHomeConsumeEnterAdapter.AdapterItemCallback {

    /* renamed from: a */
    private TextView f34952a;

    /* renamed from: b */
    private RecyclerView f34953b;

    /* renamed from: c */
    private WalletHomeConsumeEnterAdapter f34954c;

    public WalletConsumeSectionView(Context context) {
        super(context);
    }

    public WalletConsumeSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletConsumeSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_consume_enter_section, this, true);
        this.f34952a = (TextView) findViewById(R.id.wallet_consume_enter_title);
        this.f34953b = (RecyclerView) findViewById(R.id.wallet_consume_enter_rl);
        WalletHomeConsumeEnterAdapter walletHomeConsumeEnterAdapter = new WalletHomeConsumeEnterAdapter(getContext(), this);
        this.f34954c = walletHomeConsumeEnterAdapter;
        walletHomeConsumeEnterAdapter.setInternalActionInterceptor(new WalletHomeConsumeEnterAdapter.OnActionInterceptor() {
            public boolean onIntercept(int i, WalletHomeResp.ConsumeItem consumeItem) {
                return WalletConsumeSectionView.this.mListener != null && ((IWalletMainListEventListener) WalletConsumeSectionView.this.mListener).onConsumeItemClickIntercept(consumeItem);
            }
        });
        this.f34953b.setLayoutManager(new GridLayoutManager(this.mContext, 2));
        this.f34953b.setAdapter(this.f34954c);
        this.f34953b.setNestedScrollingEnabled(false);
    }

    public void updateContent(WalletHomeResp.ConsumeSection consumeSection) {
        if (consumeSection == null || consumeSection.entryList == null || consumeSection.entryList.size() < 2) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f34952a.setText(consumeSection.title);
        this.f34954c.setData(consumeSection.entryList);
    }

    public void onConsumeEntryItemClicked(WalletHomeResp.ConsumeItem consumeItem) {
        if (this.mListener != null) {
            ((IWalletMainListEventListener) this.mListener).onConsumeItemClicked(consumeItem);
        }
    }
}
