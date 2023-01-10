package com.didi.sdk.sidebar.history;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.history.manager.HistoryDeleteCallBack;
import com.didi.sdk.sidebar.history.manager.HistoryManagerBuilder;
import com.didi.sdk.sidebar.history.manager.IHistoryManager;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrdersResponse;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.sidebar.history.util.HistoryUtils;
import com.didi.sdk.sidebar.history.view.DropPinnedHeaderList;
import com.didi.sdk.sidebar.sdk.api.model.CommonDispatchMessage;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.sidebar.util.TimeUtils;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.view.dialog.LongPressDialog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryListFragment extends AbsLoadingFragment {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f39997a = "soda";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public HistoryRecordFragment f39998b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public long f39999c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f40000d = -1;

    /* renamed from: e */
    private List<AbsHistoryOrder> f40001e = new ArrayList();

    /* renamed from: f */
    private List<AbsHistoryOrder> f40002f = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f40003g = 0;

    /* renamed from: h */
    private View f40004h;

    /* renamed from: i */
    private boolean f40005i = true;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public HistoryDeleteCallBack f40006j = new HistoryDeleteCallBack() {
        public void onSuccess(BaseObject baseObject) {
            if (baseObject.errno == 0) {
                HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_DELETE_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(baseObject));
                return;
            }
            HashMap hashMap = new HashMap();
            if (SideBarBusinessUtil.isRedirectToLogin(HistoryListFragment.this.getContext(), baseObject)) {
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "SideBarBusinessUtil.isRedirectToLogin true");
            } else {
                Message errorMessage = CommonDispatchMessage.getErrorMessage(baseObject);
                hashMap.put(DMWebSocketListener.KEY_ERR_MSG, errorMessage.what + "," + errorMessage.obj);
                HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_DELETE_HISTORY_RECORDS, errorMessage);
            }
            OmegaSDKAdapter.trackEvent("tong_p_x_mytrips_delete_error", (Map<String, Object>) hashMap);
        }

        public void onFailure(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put(DMWebSocketListener.KEY_ERR_MSG, str);
            OmegaSDKAdapter.trackEvent("tong_p_x_mytrips_delete_error", (Map<String, Object>) hashMap);
            HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_DELETE_HISTORY_RECORDS, CommonDispatchMessage.getNetworkErrorMessage((Object) null));
        }
    };
    protected DropPinnedHeaderList mHistoryListView;
    protected HistoryRecordAdapterImpl mHistoryRecordAdapter;
    protected boolean mIsMoreHistoryRecords = true;
    protected int mPage = 0;
    protected HistoryOrdersResponse mSodaOrder;
    protected int mSodaPage = 0;
    protected String mTimeMode;
    protected Map<String, Object> params = new HashMap();

    public View getFallbackView() {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f40004h == null) {
            View inflate = layoutInflater.inflate(R.layout.f_history_list, viewGroup, false);
            this.f40004h = inflate;
            DropPinnedHeaderList dropPinnedHeaderList = (DropPinnedHeaderList) inflate.findViewById(R.id.history_record_list);
            this.mHistoryListView = dropPinnedHeaderList;
            dropPinnedHeaderList.setPinnedHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.v_history_record_type, this.mHistoryListView, false));
            this.mHistoryListView.setAutoLoadOnBottom(true);
            this.mHistoryListView.setDropDownStyle(false);
            this.mHistoryListView.setOnBottomStyle(true);
            this.mHistoryListView.setShowFooterWhenNoMore(true);
            this.mHistoryListView.getFooterButton().setVisibility(8);
            this.mHistoryListView.setFooterNoMoreText(getString(R.string.history_no_more_orders));
            this.mHistoryListView.setOnBottomListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HistoryListFragment.this.f39998b.getHistoryRecordByPage(HistoryListFragment.this.f39997a);
                    int unused = HistoryListFragment.this.f40003g = 0;
                }
            });
            setOnItemClickListener();
        }
        return this.f40004h;
    }

    public void setHistoryFragment(HistoryRecordFragment historyRecordFragment) {
        this.f39998b = historyRecordFragment;
    }

    /* access modifiers changed from: protected */
    public void setOnItemClickListener() {
        this.mHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                int itemViewType = HistoryListFragment.this.mHistoryRecordAdapter.getItemViewType(i);
                HistoryRecordAdapterImpl historyRecordAdapterImpl = HistoryListFragment.this.mHistoryRecordAdapter;
                if (itemViewType == 0 && !HistoryListFragment.this.isEditMode() && !HistoryListFragment.this.isInvoiceMode()) {
                    long currentTimeInLong = TimeUtils.getCurrentTimeInLong();
                    if (currentTimeInLong - HistoryListFragment.this.f39999c > 2000) {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_SHOW_LOADING, CommonDispatchMessage.getSuccessMessage((Object) null));
                        long unused = HistoryListFragment.this.f39999c = currentTimeInLong;
                        int unused2 = HistoryListFragment.this.f40003g = i;
                        AbsHistoryOrder item = HistoryListFragment.this.mHistoryRecordAdapter.getItem(i);
                        if (item != null) {
                            HistoryManagerBuilder.getInstance().createHistoryManager(HistoryListFragment.this.f39997a).clickHistoryItemView(HistoryListFragment.this.getContext(), item);
                        }
                    }
                }
            }
        });
        this.mHistoryListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (HistoryListFragment.this.isEditMode()) {
                    return true;
                }
                int itemViewType = HistoryListFragment.this.mHistoryRecordAdapter.getItemViewType(i);
                HistoryRecordAdapterImpl historyRecordAdapterImpl = HistoryListFragment.this.mHistoryRecordAdapter;
                if (itemViewType != 0) {
                    return true;
                }
                IHistoryManager createHistoryManager = HistoryManagerBuilder.getInstance().createHistoryManager(HistoryListFragment.this.f39997a);
                if (createHistoryManager.isSupportLongClickDelete() && HistoryListFragment.this.mHistoryRecordAdapter.isFinishOrderByPosition(i)) {
                    HistoryListFragment.this.m30146a(createHistoryManager, HistoryListFragment.this.mHistoryRecordAdapter.getItem(i));
                    int unused = HistoryListFragment.this.f40000d = i;
                }
                return true;
            }
        });
    }

    public void showHistoryRecords(HistoryOrdersResponse historyOrdersResponse) {
        m30147a(historyOrdersResponse);
        if (!TextUtils.isEmpty(historyOrdersResponse.getToastTips())) {
            ToastHelper.showLongCompleted(getContext(), historyOrdersResponse.getToastTips());
        }
        if (!TextUtils.isEmpty(historyOrdersResponse.getPageTips())) {
            this.mHistoryListView.setFooterNoMoreText(historyOrdersResponse.getPageTips());
        } else if (!TextUtils.isEmpty(historyOrdersResponse.footerText)) {
            this.mHistoryListView.setFooterNoMoreText(historyOrdersResponse.footerText);
        } else {
            this.mHistoryListView.setFooterNoMoreText(getString(R.string.history_no_more_orders));
        }
        if (!this.mIsMoreHistoryRecords) {
            this.mHistoryListView.setHasMore(false);
            this.mHistoryListView.getFooterButton().setVisibility(0);
            this.mHistoryListView.onBottomComplete();
        }
        if (historyOrdersResponse.getHavenext() == 1 && ((historyOrdersResponse.getDoneOrderList() == null || historyOrdersResponse.getDoneOrderList().size() == 0) && (historyOrdersResponse.getWaitingOrderList() == null || historyOrdersResponse.getWaitingOrderList().size() == 0))) {
            this.mHistoryListView.setHasMore(false);
            this.mHistoryListView.postDelayed(new Runnable() {
                public void run() {
                    HistoryListFragment.this.mHistoryListView.setHasMore(true);
                    HistoryListFragment.this.mHistoryListView.onBottomComplete();
                }
            }, 1000);
        }
        HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
        if (historyRecordAdapterImpl != null) {
            historyRecordAdapterImpl.notifyDataSetChanged();
            this.mHistoryListView.onBottomComplete();
            this.mHistoryListView.getFooterButton().setEnabled(true);
            int i = this.f40003g;
            if (i > 1) {
                this.mHistoryListView.setSelection(i - 1);
                this.f40003g = 0;
            }
        }
    }

    /* renamed from: a */
    private void m30147a(HistoryOrdersResponse historyOrdersResponse) {
        if (historyOrdersResponse != null) {
            this.mSodaOrder = historyOrdersResponse;
            List<AbsHistoryOrder> doneOrderList = historyOrdersResponse.getDoneOrderList();
            List<AbsHistoryOrder> waitingOrderList = historyOrdersResponse.getWaitingOrderList();
            if (historyOrdersResponse.getHavenext() == 0) {
                this.mIsMoreHistoryRecords = false;
            }
            this.mTimeMode = historyOrdersResponse.getTimeMode();
            if (!CollectionUtil.isEmpty((Collection<?>) doneOrderList)) {
                m30149a(doneOrderList);
                for (AbsHistoryOrder absHistoryOrder : doneOrderList) {
                    if (!this.f40002f.contains(absHistoryOrder)) {
                        this.f40002f.add(absHistoryOrder);
                    }
                }
            }
            if (!CollectionUtil.isEmpty((Collection<?>) waitingOrderList)) {
                m30149a(waitingOrderList);
                for (AbsHistoryOrder absHistoryOrder2 : waitingOrderList) {
                    if (!this.f40001e.contains(absHistoryOrder2)) {
                        this.f40001e.add(absHistoryOrder2);
                    }
                }
            }
            int i = this.mPage + 1;
            this.mPage = i;
            this.mSodaPage++;
            this.params.put("pagenum", String.valueOf(i));
            this.params.put("pageindex", Integer.valueOf(historyOrdersResponse.nextPageNum));
            this.params.put("pagemonth", historyOrdersResponse.nextPageMouth);
            HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
            if (historyRecordAdapterImpl == null) {
                HistoryRecordAdapterImpl historyRecordAdapterImpl2 = new HistoryRecordAdapterImpl();
                this.mHistoryRecordAdapter = historyRecordAdapterImpl2;
                historyRecordAdapterImpl2.init(getContext(), this.f40001e, this.f40002f, this.f39997a);
                this.mHistoryListView.setAdapter(this.mHistoryRecordAdapter, true);
            } else {
                historyRecordAdapterImpl.updateData(this.f40001e, this.f40002f);
                this.mHistoryRecordAdapter.notifyDataSetChanged();
            }
            if (!TextUtils.isEmpty(historyOrdersResponse.toastText)) {
                ToastHelper.showShortInfo((Context) getActivity(), historyOrdersResponse.toastText);
            }
            m30148a(historyOrdersResponse.footerText);
        }
    }

    /* renamed from: a */
    private void m30148a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mHistoryListView.setFooterDefaultText(str);
            this.mHistoryListView.getFooterButton().setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m30149a(List<AbsHistoryOrder> list) {
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if ("trydrive".equals(Constant.getBusinessIdByProductType(list.get(i).getProduct()))) {
                    list.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    public void setType(String str) {
        this.f39997a = str;
    }

    public AbsHistoryOrder getItem(int i) {
        HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
        if (historyRecordAdapterImpl != null) {
            return historyRecordAdapterImpl.getItem(i);
        }
        return null;
    }

    public boolean isEditMode() {
        HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
        if (historyRecordAdapterImpl != null) {
            return historyRecordAdapterImpl.isEditMode();
        }
        return false;
    }

    public boolean isInvoiceMode() {
        HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
        if (historyRecordAdapterImpl != null) {
            return historyRecordAdapterImpl.isInvoiceMode();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30146a(final IHistoryManager iHistoryManager, final AbsHistoryOrder absHistoryOrder) {
        final LongPressDialog longPressDialog = new LongPressDialog();
        longPressDialog.setupButton(getString(R.string.history_record_title_delete), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HistoryListFragment.this.m30154b(iHistoryManager, absHistoryOrder);
                longPressDialog.dismiss();
            }
        });
        longPressDialog.setCancelable(true);
        try {
            longPressDialog.show(getFragmentManager(), (String) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30154b(final IHistoryManager iHistoryManager, final AbsHistoryOrder absHistoryOrder) {
        new AlertDialogFragment.Builder(getContext()).setMessage(getString(R.string.history_record_delete_tips)).setIcon(AlertController.IconType.INFO).setNegativeButton((int) R.string.cancel, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).setPositiveButton((int) R.string.confirm, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                IHistoryManager iHistoryManager = iHistoryManager;
                if (!(iHistoryManager == null || absHistoryOrder == null)) {
                    iHistoryManager.deleteHistoryDate(HistoryListFragment.this.getContext(), absHistoryOrder, HistoryListFragment.this.f40006j);
                    HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage((Object) null));
                }
                alertDialogFragment.dismiss();
            }
        }).setPositiveButtonDefault().setCancelable(false).create().show(getFragmentManager(), (String) null);
    }

    public void removeItem() {
        int i = this.f40000d;
        if (i >= 0) {
            this.mHistoryRecordAdapter.removeItem(i);
            this.f40000d = -1;
        }
    }

    public int getOrderCount() {
        return this.mHistoryRecordAdapter.getOrderCount();
    }

    public List<AbsHistoryOrder> getFinishedOrderList() {
        HistoryRecordAdapterImpl historyRecordAdapterImpl = this.mHistoryRecordAdapter;
        if (historyRecordAdapterImpl == null) {
            return null;
        }
        return historyRecordAdapterImpl.getFinishedOrderList();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f40004h = null;
        this.f39998b = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f40004h;
        if (view != null && view.getParent() != null) {
            ((ViewGroup) this.f40004h.getParent()).removeView(this.f40004h);
        }
    }

    public String getType() {
        return this.f39997a;
    }

    public void openInvoiceMode(String str) {
        this.mHistoryRecordAdapter.setInvoiceMode(true);
        this.mHistoryRecordAdapter.updateData(new ArrayList(), m30152b(str));
        this.mHistoryRecordAdapter.notifyDataSetChanged();
        this.f40005i = this.mHistoryListView.isHasMore();
        this.mHistoryListView.setHasMore(false);
        this.mHistoryListView.getFooterButton().setVisibility(0);
        this.mHistoryListView.onBottomComplete();
    }

    public void closeInvoiceMode() {
        this.mHistoryRecordAdapter.setInvoiceMode(false);
        this.mHistoryRecordAdapter.updateData(this.f40001e, this.f40002f);
        this.mHistoryRecordAdapter.notifyDataSetChanged();
        if (this.f40005i) {
            this.mHistoryListView.setHasMore(true);
            this.mHistoryListView.getFooterButton().setVisibility(8);
            this.mHistoryListView.onBottomComplete();
        }
    }

    public void updatePinnedHeader() {
        this.mHistoryListView.updateHeaderView(0);
    }

    public void setMarginBottom(int i) {
        DropPinnedHeaderList dropPinnedHeaderList = this.mHistoryListView;
        if (dropPinnedHeaderList != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dropPinnedHeaderList.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.mHistoryListView.setLayoutParams(layoutParams);
        }
    }

    public void showHistoryList(boolean z) {
        DropPinnedHeaderList dropPinnedHeaderList = this.mHistoryListView;
        if (dropPinnedHeaderList != null) {
            dropPinnedHeaderList.setVisibility(z ? 0 : 8);
        }
    }

    public void setAutoLoadOnBottom(boolean z) {
        DropPinnedHeaderList dropPinnedHeaderList = this.mHistoryListView;
        if (dropPinnedHeaderList != null) {
            dropPinnedHeaderList.setAutoLoadOnBottom(z);
        }
    }

    public void showFooterButton(boolean z) {
        DropPinnedHeaderList dropPinnedHeaderList = this.mHistoryListView;
        if (dropPinnedHeaderList != null && dropPinnedHeaderList.getFooterButton() != null) {
            this.mHistoryListView.getFooterButton().setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: b */
    private List<AbsHistoryOrder> m30152b(String str) {
        ArrayList arrayList = new ArrayList();
        List<AbsHistoryOrder> list = this.f40002f;
        if (!(list == null || list.size() == 0 || TextUtils.isEmpty(str))) {
            for (AbsHistoryOrder next : this.f40002f) {
                if (HistoryUtils.canInvoice(next)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }
}
