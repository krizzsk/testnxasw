package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.view.CommonAbsSectionView;
import com.didi.payment.commonsdk.view.adapter.OperationBannerAdapter;
import com.didi.payment.commonsdk.view.helper.GravitySnapHelper;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationSection;
import com.didi.payment.wallet.global.wallet.contract.WalletOperationBannerContract;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletOperationBannerAdapter;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;

public class WalletOperationBannerSectionView extends CommonAbsSectionView<WalletOperationSection, WalletOperationBannerContract.Listener> implements OperationBannerAdapter.AdapterItemCallback<WalletOperationItem> {

    /* renamed from: a */
    private TextView f34991a;

    /* renamed from: b */
    private RecyclerView f34992b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletOperationBannerAdapter f34993c;

    public WalletOperationBannerSectionView(Context context) {
        super(context);
    }

    public WalletOperationBannerSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletOperationBannerSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_global_home_operation_banner_section, this, true);
        this.f34991a = (TextView) findViewById(R.id.tv_operation_title);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_operation_list);
        this.f34992b = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.f34992b.setNestedScrollingEnabled(false);
        this.f34992b.addItemDecoration(new RecyclerView.ItemDecoration() {
            int internalSpace = UIUtil.dip2px(WalletOperationBannerSectionView.this.mContext, 10.0f);
            int outSpace = UIUtil.dip2px(WalletOperationBannerSectionView.this.mContext, 15.0f);

            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                rect.left = childAdapterPosition != 0 ? this.internalSpace : this.outSpace;
                if (WalletOperationBannerSectionView.this.f34993c != null && childAdapterPosition == WalletOperationBannerSectionView.this.f34993c.getItemCount() - 1) {
                    rect.right = this.outSpace;
                }
            }
        });
        this.f34992b.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastShownPos = -1;

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int findLastCompletelyVisibleItemPosition;
                if (i == 0 && WalletOperationBannerSectionView.this.f34993c != null && WalletOperationBannerSectionView.this.mListener != null && recyclerView.getLayoutManager() != null && (findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition()) >= 0 && findLastCompletelyVisibleItemPosition != this.lastShownPos) {
                    ((WalletOperationBannerContract.Listener) WalletOperationBannerSectionView.this.mListener).onOperationItemShown(WalletOperationBannerSectionView.this.f34993c.getItem(findLastCompletelyVisibleItemPosition));
                    this.lastShownPos = findLastCompletelyVisibleItemPosition;
                }
            }
        });
        WalletOperationBannerAdapter walletOperationBannerAdapter = new WalletOperationBannerAdapter(getContext(), this);
        this.f34993c = walletOperationBannerAdapter;
        this.f34992b.setAdapter(walletOperationBannerAdapter);
        m26698a();
    }

    /* renamed from: a */
    private void m26698a() {
        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(GravityCompat.START);
        gravitySnapHelper.setSnapToPadding(false);
        gravitySnapHelper.setSnapLastItem(false);
        gravitySnapHelper.setMaxFlingSizeFraction(1.0f);
        gravitySnapHelper.setScrollMsPerInch(50.0f);
        gravitySnapHelper.attachToRecyclerView(this.f34992b);
    }

    public void updateContent(WalletOperationSection walletOperationSection) {
        if (walletOperationSection == null || CollectionUtil.isEmpty((Collection) walletOperationSection.panelList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (TextUtils.isEmpty(walletOperationSection.title)) {
            this.f34991a.setVisibility(8);
        } else {
            this.f34991a.setVisibility(0);
            this.f34991a.setText(walletOperationSection.title);
        }
        this.f34993c.setData(walletOperationSection.panelList);
        if (this.mListener != null) {
            ((WalletOperationBannerContract.Listener) this.mListener).onOperationItemShown(walletOperationSection.panelList.get(0));
        }
    }

    public void onItemClicked(WalletOperationItem walletOperationItem) {
        if (this.mListener != null) {
            ((WalletOperationBannerContract.Listener) this.mListener).onOperationItemClicked(walletOperationItem);
        }
    }
}
