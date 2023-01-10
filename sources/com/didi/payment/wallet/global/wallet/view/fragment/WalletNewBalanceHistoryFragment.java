package com.didi.payment.wallet.global.wallet.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.model.resp.WalletBalanceOption;
import com.didi.payment.wallet.global.utils.WalletDateUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalanceHistoryPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletNewBalanceHistoryAdapter;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletTopUpOmegaUtil;
import com.didi.payment.wallet.global.wallet.view.widget.BalanceDateDialogFragment;
import com.didi.payment.wallet.global.wallet.view.widget.BalanceTypeDialogFragment;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.greenrobot.eventbus.EventBus;

public class WalletNewBalanceHistoryFragment extends Fragment implements WalletNewBalanceHistoryContract.View {

    /* renamed from: a */
    final LinearLayoutManager f34884a = new LinearLayoutManager(this.f34893j);

    /* renamed from: b */
    BalanceDateDialogFragment f34885b;

    /* renamed from: c */
    BalanceTypeDialogFragment f34886c;

    /* renamed from: d */
    WalletBalanceOption f34887d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public WalletNewBalanceHistoryContract.Presenter f34888e;

    /* renamed from: f */
    private RecyclerView f34889f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f34890g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f34891h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletNewBalanceHistoryAdapter f34892i;

    /* renamed from: j */
    private FragmentActivity f34893j;

    /* renamed from: k */
    private SmartRefreshLayout f34894k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public WalletDateUtil f34895l = new WalletDateUtil();
    public List<WalletBalanceOption> walletBalanceOptionsList = new ArrayList();

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f34893j = getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_new_balance_history, viewGroup, false);
        m26646a(inflate);
        WalletNewBalanceHistoryPresenter walletNewBalanceHistoryPresenter = new WalletNewBalanceHistoryPresenter(this.f34893j, this, this.f34894k);
        this.f34888e = walletNewBalanceHistoryPresenter;
        walletNewBalanceHistoryPresenter.init();
        BalanceDateDialogFragment.Companion.init();
        return inflate;
    }

    /* renamed from: a */
    private void m26646a(View view) {
        this.f34889f = (RecyclerView) view.findViewById(R.id.rv_wallet_new_balance_history_list);
        TextView textView = (TextView) view.findViewById(R.id.tv_balanceTopDate);
        this.f34890g = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "walletbalance");
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_timefilter_ck", hashMap);
                WalletNewBalanceHistoryFragment.this.m26645a();
            }
        });
        TextView textView2 = (TextView) view.findViewById(R.id.tv_balanceTopAll);
        this.f34891h = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put("pub_page", "walletbalance");
                hashMap.put("button_name", ParamKeys.PARAM_COMPLAIN_ENTRY);
                WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_typefilter_ck", hashMap);
                WalletNewBalanceHistoryFragment.this.m26648b();
            }
        });
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.srl_balance);
        this.f34894k = smartRefreshLayout;
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout refreshLayout) {
                long nextRefreshTime = WalletNewBalanceHistoryFragment.this.f34895l.getNextRefreshTime();
                WalletNewBalanceHistoryFragment.this.f34892i.defaultDate = WalletNewBalanceHistoryFragment.this.f34895l.getDateStr();
                WalletNewBalanceHistoryFragment.this.f34890g.setText(WalletNewBalanceHistoryFragment.this.f34895l.getDateStr());
                WalletNewBalanceHistoryFragment.this.f34888e.requestNextData(nextRefreshTime);
            }
        });
        this.f34894k.setOnLoadMoreListener(new OnLoadMoreListener() {
            public void onLoadMore(RefreshLayout refreshLayout) {
                WalletNewBalanceHistoryFragment.this.f34888e.requestData();
            }
        });
        this.f34884a.setOrientation(1);
        this.f34889f.setLayoutManager(this.f34884a);
        this.f34889f.setItemAnimator(new DefaultItemAnimator());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.f34893j, 1);
        dividerItemDecoration.setDrawable(ResourcesHelper.getDrawable(this.f34893j, R.drawable.wallet_balance_history_list_divider));
        this.f34889f.addItemDecoration(dividerItemDecoration);
        WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = new WalletNewBalanceHistoryAdapter(this.f34893j);
        this.f34892i = walletNewBalanceHistoryAdapter;
        walletNewBalanceHistoryAdapter.defaultDate = this.f34895l.getDefaultDate();
        this.f34889f.setAdapter(this.f34892i);
        this.f34889f.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                WalletNewBalanceHistoryFragment.this.f34892i.updateTopItemIndex(WalletNewBalanceHistoryFragment.this.f34884a.findFirstVisibleItemPosition());
                WalletNewBalanceHistoryFragment.this.f34890g.setText(WalletNewBalanceHistoryFragment.this.f34892i.getTopItemDate());
            }
        });
        this.f34892i.setLoadMore(new WalletNewBalanceHistoryAdapter.ILoadMore() {
            public void onLoadMore() {
                WalletNewBalanceHistoryFragment.this.f34892i.removeAtIndex(WalletNewBalanceHistoryFragment.this.f34892i.getBankBalanceItems().size() - 1);
                WalletNewBalanceHistoryFragment.this.f34892i.addItem((WalletNewBalanceHistoryAdapter.HistoryItem) null);
                WalletNewBalanceHistoryFragment.this.f34888e.requestData();
            }
        });
        this.f34892i.setRetryCallback(new WalletNewBalanceHistoryAdapter.INetworkErrorRetry() {
            public void onRetry() {
                WalletNewBalanceHistoryFragment.this.f34888e.retryRequestData();
            }
        });
    }

    public void showLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = true;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void dismissLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = false;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void onNetworkError() {
        this.f34892i.clearAllItems();
        ArrayList arrayList = new ArrayList();
        this.f34894k.setEnableLoadMore(false);
        arrayList.add(m26644a(7, (WalletBalanceHistoryResp.StatementBean) null));
        this.f34892i.addItemList(arrayList);
    }

    public void onBalanceDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z, WalletBalanceHistoryResp.TopUpBtn topUpBtn) {
        this.f34892i.setTipsInfo(topUpBtn);
        ArrayList arrayList = new ArrayList();
        if (list.size() == 0) {
            this.f34890g.setText(this.f34892i.defaultDate);
            this.f34894k.setEnableLoadMore(false);
            arrayList.add(m26644a(6, (WalletBalanceHistoryResp.StatementBean) null));
            this.f34892i.addEmptyItem(arrayList);
            return;
        }
        this.f34894k.setEnableLoadMore(true);
        for (int i = 0; i < list.size(); i++) {
            WalletBalanceHistoryResp.StatementBean statementBean = list.get(i);
            if (statementBean != null) {
                arrayList.add(m26644a(2, statementBean));
            }
        }
        this.f34892i.resetItemList(arrayList, this.f34895l);
        this.f34890g.setText(this.f34892i.getTopItemDate());
    }

    public void onBalanceMoreDataSuccessful(List<WalletBalanceHistoryResp.StatementBean> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(m26644a(2, list.get(i)));
        }
        WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = this.f34892i;
        walletNewBalanceHistoryAdapter.removeAtIndex(walletNewBalanceHistoryAdapter.getBankBalanceItems().size() - 1);
        if (z) {
            arrayList.add(m26644a(3, (WalletBalanceHistoryResp.StatementBean) null));
        } else {
            arrayList.add(m26644a(5, (WalletBalanceHistoryResp.StatementBean) null));
        }
        this.f34892i.addItemList(arrayList);
    }

    public void onBalanceOptionSuccessful(List<WalletBalanceOption> list) {
        this.walletBalanceOptionsList.clear();
        this.walletBalanceOptionsList.addAll(list);
    }

    /* renamed from: a */
    private WalletNewBalanceHistoryAdapter.HistoryItem m26644a(int i, WalletBalanceHistoryResp.StatementBean statementBean) {
        return new WalletNewBalanceHistoryAdapter.HistoryItem(i, statementBean);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26645a() {
        if (this.f34885b == null) {
            this.f34885b = new BalanceDateDialogFragment();
        }
        if (!this.f34885b.isAdded()) {
            this.f34885b.show(getChildFragmentManager(), "dialogDataBuilder");
            this.f34885b.addOnSelectListener(new Function2<Long, String, Unit>() {
                public Unit invoke(Long l, String str) {
                    WalletNewBalanceHistoryFragment.this.f34895l.setTime(l.longValue());
                    WalletNewBalanceHistoryFragment.this.f34892i.defaultDate = str;
                    WalletNewBalanceHistoryFragment.this.f34890g.setText(WalletNewBalanceHistoryFragment.this.f34892i.defaultDate);
                    WalletNewBalanceHistoryFragment.this.f34888e.onSelectedBalanceTime(l.longValue());
                    return null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26648b() {
        if (!this.walletBalanceOptionsList.isEmpty()) {
            if (this.f34886c == null) {
                this.f34886c = new BalanceTypeDialogFragment();
            }
            if (!this.f34886c.isAdded()) {
                this.f34886c.show(getChildFragmentManager(), "dialogTypeBuilder");
                this.f34886c.setDate(this.walletBalanceOptionsList, this.f34887d);
                this.f34886c.addOnSelectListener(new Function1<WalletBalanceOption, Unit>() {
                    public Unit invoke(WalletBalanceOption walletBalanceOption) {
                        WalletNewBalanceHistoryFragment.this.f34887d = walletBalanceOption;
                        String label = walletBalanceOption.getLabel();
                        if (label != null && !label.isEmpty()) {
                            WalletNewBalanceHistoryFragment.this.f34891h.setText(label);
                            HashMap hashMap = new HashMap();
                            hashMap.put("pub_page", "walletbalance");
                            hashMap.put("button_name", label);
                            WalletTopUpOmegaUtil.Companion.trackEvent("fin_walletbalance_typefilter_ck", hashMap);
                        }
                        WalletNewBalanceHistoryFragment.this.f34888e.onSelectedBalanceOption(walletBalanceOption);
                        return null;
                    }
                });
            }
        }
    }
}
