package com.didi.payment.wallet.global.wallet.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.useraccount.balance.view.adapter.BaseViewHolder;
import com.didi.payment.wallet.global.utils.ColorsUtils;
import com.didi.payment.wallet.global.utils.WalletDateUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletNewBalanceHistoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_EMPTY = 6;
    public static final int VIEW_TYPE_END_OF_LIST = 5;
    public static final int VIEW_TYPE_INITIAL_LOAD = 1;
    public static final int VIEW_TYPE_LOADING_PROGRESS = 4;
    public static final int VIEW_TYPE_LOADING_TAB = 3;
    public static final int VIEW_TYPE_NETWORK_ERROR_RETRY = 7;
    public static final int VIEW_TYPE_NORMAL = 2;
    public static final int VIEW_TYPE_TITLE = 0;

    /* renamed from: a */
    private static final String f34851a = "BalanceItemAdapter";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f34852b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<HistoryItem> f34853c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ILoadMore f34854d;
    public String defaultDate = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public INetworkErrorRetry f34855e;

    /* renamed from: f */
    private WalletBalanceHistoryResp.TopUpBtn f34856f;
    public int topPosition = 0;

    public interface Callback {
        void onEmptyViewRetryClick();
    }

    public interface ILoadMore {
        void onLoadMore();
    }

    public interface INetworkErrorRetry {
        void onRetry();
    }

    public List<HistoryItem> getBankBalanceItems() {
        return this.f34853c;
    }

    public WalletNewBalanceHistoryAdapter(Activity activity) {
        this.f34852b = activity;
        this.f34853c = new ArrayList();
    }

    public void setLoadMore(ILoadMore iLoadMore) {
        this.f34854d = iLoadMore;
    }

    public void setRetryCallback(INetworkErrorRetry iNetworkErrorRetry) {
        this.f34855e = iNetworkErrorRetry;
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new TitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_title, viewGroup, false));
        }
        if (i == 1) {
            return new InitalLoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_initial_loading, viewGroup, false));
        }
        if (i == 2) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_list_item, viewGroup, false));
        }
        if (i == 3) {
            return new TabToLoadMoreViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_tab_to_load_more, viewGroup, false));
        }
        if (i == 4) {
            return new LoadingViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_loading_progress, viewGroup, false));
        }
        if (i == 5) {
            return new EndOfListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_end_of_list, viewGroup, false));
        }
        if (i != 7) {
            return new EmptyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_empty_view, viewGroup, false));
        }
        return new NetworkErrorViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_activity_balance_item_network_error, viewGroup, false));
    }

    public int getItemViewType(int i) {
        List<HistoryItem> list = this.f34853c;
        if (list == null || list.size() == 0) {
            return 6;
        }
        if (this.f34853c.get(i) == null) {
            return 4;
        }
        if (this.f34853c.get(i).mItemViewType == 0) {
            return 0;
        }
        if (this.f34853c.get(i).mItemViewType == 1) {
            return 1;
        }
        if (this.f34853c.get(i).mItemViewType == 3) {
            return 3;
        }
        if (this.f34853c.get(i).mItemViewType == 5) {
            return 5;
        }
        if (this.f34853c.get(i).mItemViewType == 6) {
            return 6;
        }
        return this.f34853c.get(i).mItemViewType == 7 ? 7 : 2;
    }

    public int getItemCount() {
        List<HistoryItem> list = this.f34853c;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.f34853c.size();
    }

    public void updateTopItemIndex(int i) {
        this.topPosition = i;
    }

    public String getTopItemDate() {
        int i;
        if (this.topPosition >= this.f34853c.size() || (i = this.topPosition) < 0) {
            return this.defaultDate;
        }
        WalletBalanceHistoryResp.StatementBean statementBean = this.f34853c.get(i).mItem;
        if (statementBean == null || statementBean.transDateTitle == null) {
            return this.defaultDate;
        }
        return statementBean.transDateTitle;
    }

    public String getLastItemDate() {
        if (this.f34853c.isEmpty()) {
            return "";
        }
        List<HistoryItem> list = this.f34853c;
        return list.get(list.size() - 1).mItem.time.toString();
    }

    public void resetItemList(List<HistoryItem> list, WalletDateUtil walletDateUtil) {
        clearAllItems();
        addItemList(list);
        if (!list.isEmpty()) {
            walletDateUtil.setTopTime(list.get(0));
        }
    }

    public void clearAllItems() {
        this.f34853c.clear();
        notifyDataSetChanged();
    }

    public void addEmptyItem(List<HistoryItem> list) {
        this.f34853c.clear();
        this.f34853c.addAll(list);
        notifyDataSetChanged();
    }

    public void addItemList(List<HistoryItem> list) {
        this.f34853c.addAll(list);
        notifyDataSetChanged();
    }

    public void addItem(HistoryItem historyItem) {
        this.f34853c.add(historyItem);
        notifyItemInserted(this.f34853c.size() - 1);
    }

    public void removeAtIndex(int i) {
        this.f34853c.remove(i);
        notifyItemRemoved(i);
    }

    public void setTipsInfo(WalletBalanceHistoryResp.TopUpBtn topUpBtn) {
        this.f34856f = topUpBtn;
    }

    public WalletBalanceHistoryResp.TopUpBtn getTipsInfo() {
        return this.f34856f;
    }

    public class ViewHolder extends BaseViewHolder {
        private TextView mTvAmount;
        private TextView mTvDate;
        private TextView mTvItemTitle;
        private TextView mTvTransId;

        public ViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mTvItemTitle = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_title);
            this.mTvDate = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_date);
            this.mTvAmount = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_amount);
            this.mTvTransId = (TextView) view.findViewById(R.id.tv_balance_activity_list_item_trans_id);
        }

        /* access modifiers changed from: protected */
        public void clear() {
            this.mTvItemTitle.setText("");
            this.mTvDate.setText("");
            this.mTvAmount.setText("");
            this.mTvTransId.setText("");
        }

        public void onBind(int i) {
            super.onBind(i);
            WalletBalanceHistoryResp.StatementBean statementBean = ((HistoryItem) WalletNewBalanceHistoryAdapter.this.f34853c.get(i)).mItem;
            if (statementBean.title != null) {
                this.mTvItemTitle.setText(statementBean.title);
            }
            if (statementBean.transDate != null) {
                this.mTvDate.setText(statementBean.transDate);
            }
            if (statementBean.amountText != null) {
                statementBean.amountText.bindTextView(this.mTvAmount);
            }
            if (statementBean.transId != null) {
                TextView textView = this.mTvTransId;
                textView.setText(WalletNewBalanceHistoryAdapter.this.f34852b.getResources().getString(R.string.wallet_balance_item_id_prefix) + " " + statementBean.transId);
            }
        }
    }

    public static class TitleViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        TitleViewHolder(View view) {
            super(view);
        }
    }

    public static class InitalLoadingViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        InitalLoadingViewHolder(View view) {
            super(view);
        }
    }

    public class TabToLoadMoreViewHolder extends BaseViewHolder implements View.OnClickListener {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        TabToLoadMoreViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            WalletNewBalanceHistoryAdapter.this.f34854d.onLoadMore();
        }
    }

    public static class EndOfListViewHolder extends BaseViewHolder {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        EndOfListViewHolder(View view) {
            super(view);
        }
    }

    public class NetworkErrorViewHolder extends BaseViewHolder implements View.OnClickListener {
        /* access modifiers changed from: protected */
        public void clear() {
        }

        NetworkErrorViewHolder(View view) {
            super(view);
            View findViewById = view.findViewById(R.id.iv_error_image);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.setMargins(0, UIUtil.dp2px(56.0f), 0, 0);
            findViewById.setLayoutParams(marginLayoutParams);
            View findViewById2 = view.findViewById(R.id.tv_balance_network_error);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
            marginLayoutParams2.setMargins(UIUtil.dp2px(22.0f), UIUtil.dp2px(12.0f), UIUtil.dp2px(22.0f), 0);
            findViewById2.setLayoutParams(marginLayoutParams2);
            view.findViewById(R.id.ll_account_balance_retry_btn).setBackground(WalletNewBalanceHistoryAdapter.m26615b());
            view.setOnClickListener(this);
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            WalletNewBalanceHistoryAdapter.this.f34855e.onRetry();
        }
    }

    public static class EmptyViewHolder extends BaseViewHolder implements View.OnClickListener {
        WalletNewBalanceHistoryAdapter adapter;
        TextView mTvEmpty;
        TextView mTvTodo;

        /* access modifiers changed from: protected */
        public void clear() {
        }

        EmptyViewHolder(WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter, View view) {
            super(view);
            this.adapter = walletNewBalanceHistoryAdapter;
            initView(view);
        }

        private void initView(View view) {
            View findViewById = view.findViewById(R.id.iv_empty_image);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById.getLayoutParams();
            marginLayoutParams.setMargins(0, UIUtil.dp2px(56.0f), 0, 0);
            findViewById.setLayoutParams(marginLayoutParams);
            TextView textView = (TextView) view.findViewById(R.id.tv_balance_empty);
            this.mTvEmpty = textView;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams2.setMargins(UIUtil.dp2px(22.0f), UIUtil.dp2px(12.0f), UIUtil.dp2px(22.0f), 0);
            this.mTvEmpty.setLayoutParams(marginLayoutParams2);
            TextView textView2 = (TextView) view.findViewById(R.id.tv_balance_todo);
            this.mTvTodo = textView2;
            textView2.setBackground(WalletNewBalanceHistoryAdapter.m26615b());
            this.mTvTodo.setOnClickListener(this);
        }

        public void onBind(int i) {
            String str;
            String str2;
            WalletBalanceHistoryResp.TopUpBtn tipsInfo;
            super.onBind(i);
            Context context = this.itemView.getContext();
            WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = this.adapter;
            String str3 = "";
            if (walletNewBalanceHistoryAdapter == null || (tipsInfo = walletNewBalanceHistoryAdapter.getTipsInfo()) == null) {
                str2 = str3;
                str = str2;
            } else {
                str = tipsInfo.notice;
                str2 = tipsInfo.text;
            }
            if (TextUtils.isEmpty(str)) {
                if (!WalletApolloUtil.enableTopUp()) {
                    str = context.getString(R.string.Fintech_Payment_SKUs_No_transaction_FAic);
                } else {
                    str = context.getString(R.string.Fintech_Payment_perception_Charge_is_oWlM);
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            } else if (WalletApolloUtil.enableTopUp()) {
                str3 = context.getString(R.string.wallet_balance_type_topup);
            }
            this.mTvEmpty.setText(str);
            this.mTvTodo.setText(str3);
            this.mTvTodo.setVisibility(TextUtils.isEmpty(str3) ? 8 : 0);
        }

        public void onClick(View view) {
            WalletBalanceHistoryResp.TopUpBtn tipsInfo;
            AutoTrackHelper.trackViewOnClick(view);
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", "walletbalance");
            hashMap.put("button_name", "topup");
            FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
            WalletNewBalanceHistoryAdapter walletNewBalanceHistoryAdapter = this.adapter;
            if (walletNewBalanceHistoryAdapter != null && (tipsInfo = walletNewBalanceHistoryAdapter.getTipsInfo()) != null && !TextUtils.isEmpty(tipsInfo.link)) {
                DRouter.build(tipsInfo.link).start();
            }
        }
    }

    public static class LoadingViewHolder extends BaseViewHolder {
        LottieAnimationView mProgressBar;

        /* access modifiers changed from: protected */
        public void clear() {
        }

        public LoadingViewHolder(View view) {
            super(view);
            initView(view);
        }

        private void initView(View view) {
            this.mProgressBar = (LottieAnimationView) view.findViewById(R.id.progress_bar);
        }

        public void onBind(int i) {
            super.onBind(i);
            this.mProgressBar.playAnimation();
        }
    }

    public static class HistoryItem {
        public WalletBalanceHistoryResp.StatementBean mItem;
        public int mItemViewType;

        public HistoryItem(int i, WalletBalanceHistoryResp.StatementBean statementBean) {
            this.mItemViewType = i;
            this.mItem = statementBean;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Drawable m26615b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UIUtil.dp2px(40.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(WalletCommonParamsUtil.isBrazilDriverClient() ? new int[]{ColorsUtils.parseColor("#FFDC14"), ColorsUtils.parseColor("#FFDC14")} : new int[]{ColorsUtils.parseColor("#FFF366"), ColorsUtils.parseColor("#FFC040")});
        return gradientDrawable;
    }
}
