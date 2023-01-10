package com.didi.payment.transfer.accounts;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.accounts.presenter.ITransAccountHomePresenter;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.accounts.presenter.TransAccountHomePresenter;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.common.model.TransBankInfo;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransCfmAmountFragment;
import com.didi.payment.transfer.historyaccounts.TransHistoryAccountFragment;
import com.didi.payment.transfer.newaccount.BankDataModel;
import com.didi.payment.transfer.newaccount.Trans2BankModel;
import com.didi.payment.transfer.newaccount.TransAllBankListFragment;
import com.didi.payment.transfer.newaccount.TransNewAccountFragment;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TransAccountRecordActivity extends TransBaseActivity<ITransAccountHomePresenter> implements ITransAccountHomeView {

    /* renamed from: b */
    private ImageView f33833b;

    /* renamed from: c */
    private View f33834c;

    /* renamed from: d */
    private PayEventPublisher.OnEventListener<IConfirmTransferInfo> f33835d = new PayEventPublisher.OnEventListener<IConfirmTransferInfo>() {
        public void onEvent(String str, IConfirmTransferInfo iConfirmTransferInfo) {
            TransAccountRecordActivity.this.m25691a(iConfirmTransferInfo);
        }
    };

    /* renamed from: e */
    private PayEventPublisher.OnEventListener<NNPayAccount> f33836e = new PayEventPublisher.OnEventListener<NNPayAccount>() {
        public void onEvent(String str, NNPayAccount nNPayAccount) {
            TransAccountRecordActivity.this.m25691a((IConfirmTransferInfo) nNPayAccount);
        }
    };

    /* renamed from: f */
    private PayEventPublisher.OnEventListener<Trans2BankModel> f33837f = new PayEventPublisher.OnEventListener<Trans2BankModel>() {
        public void onEvent(String str, Trans2BankModel trans2BankModel) {
            TransAccountRecordActivity.this.m25691a((IConfirmTransferInfo) trans2BankModel);
        }
    };

    /* renamed from: g */
    private PayEventPublisher.OnEventListener<BankDataModel> f33838g = new PayEventPublisher.OnEventListener<BankDataModel>() {
        public void onEvent(String str, BankDataModel bankDataModel) {
            TransAccountRecordActivity.this.m25692a(bankDataModel);
        }
    };

    /* access modifiers changed from: protected */
    public int getFragContainerId() {
        return R.id.fragment_container;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_account_records_actlay;
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.history_contacts_title_bar;
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_left);
        this.f33833b = imageView;
        imageView.setImageResource(R.drawable.common_title_back_arrow);
        this.f33833b.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransAccountRecordActivity.this.onBackPressed();
            }
        });
        View findViewById = findViewById(R.id.trans_pageerr_retry2load_rl_root);
        this.f33834c = findViewById;
        findViewById.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                ((ITransAccountHomePresenter) TransAccountRecordActivity.this.mPresenter).loadTransferAccountRecords(1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25691a(IConfirmTransferInfo iConfirmTransferInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 651));
        bundle.putSerializable(TransferContants.IntentKey.INTENT_PARAM_KEY_TRANS_CFM_AMOUNT_MODEL, iConfirmTransferInfo);
        forwardFragment(TransCfmAmountFragment.getInstance(bundle), true, "confirm_trans_amount_fragment");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25692a(BankDataModel bankDataModel) {
        if (bankDataModel != null && !CollectionUtil.isEmpty((Map<?, ?>) bankDataModel.fullValues)) {
            TransAllBankListFragment transAllBankListFragment = new TransAllBankListFragment();
            Bundle bundle = new Bundle();
            ArrayList<TransBankInfo> arrayList = new ArrayList<>();
            for (TransBankInfo add : bankDataModel.fullValues.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            String[] strArr = new String[arrayList.size()];
            int i = 0;
            for (TransBankInfo transBankInfo : arrayList) {
                strArr[i] = transBankInfo.toString();
                i++;
            }
            bundle.putStringArray("bank_list_inarray", strArr);
            transAllBankListFragment.setArguments(bundle);
            forwardFragment(transAllBankListFragment, true, "banklist_fragment_tag");
        }
    }

    /* access modifiers changed from: protected */
    public void registeEventListeners() {
        subscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33835d);
        subscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33836e);
        subscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33837f);
        subscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_BANKLIST_TRANAMOUNT, this.f33838g);
    }

    /* access modifiers changed from: protected */
    public void unregisteEventListeners() {
        unsubscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33835d);
        unsubscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33836e);
        unsubscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_CONFIRM_TRANAMOUNT, this.f33837f);
        unsubscribe(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_BANKLIST_TRANAMOUNT, this.f33838g);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (extras == null || !extras.containsKey("pix_transfer")) {
            ((ITransAccountHomePresenter) this.mPresenter).loadTransferAccountRecords(1);
        } else {
            TransNewAccountFragment transNewAccountFragment = new TransNewAccountFragment();
            transNewAccountFragment.setArguments(extras);
            attactRootFragment(transNewAccountFragment, "new_account_fragment");
        }
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public ITransAccountHomePresenter onCreatePresenter() {
        return new TransAccountHomePresenter(getContext(), this);
    }

    public void onHistoryDataLoaded(List<NNPayAccount> list) {
        if (this.f33834c.getVisibility() == 0) {
            this.f33834c.setVisibility(8);
        }
        m25693a(list);
    }

    /* renamed from: a */
    private void m25693a(List<NNPayAccount> list) {
        if (!(!CollectionUtil.isEmpty((Collection<?>) list))) {
            Bundle extras = getIntent().getExtras();
            TransNewAccountFragment transNewAccountFragment = new TransNewAccountFragment();
            if (extras != null && extras.containsKey(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION)) {
                transNewAccountFragment.setArguments(extras);
            }
            attactRootFragment(transNewAccountFragment, "new_account_fragment");
            return;
        }
        Bundle bundle = new Bundle();
        NNPayAccount[] nNPayAccountArr = new NNPayAccount[list.size()];
        int i = 0;
        for (NNPayAccount nNPayAccount : list) {
            nNPayAccountArr[i] = nNPayAccount;
            i++;
        }
        bundle.putParcelableArray("account_record_array", nNPayAccountArr);
        TransHistoryAccountFragment transHistoryAccountFragment = new TransHistoryAccountFragment();
        transHistoryAccountFragment.setArguments(bundle);
        attactRootFragment(transHistoryAccountFragment, "history_account_list_fragment");
    }

    public void onHistoryDataLoadFail() {
        this.f33834c.setVisibility(0);
    }

    public void toNewAccountPage() {
        Bundle extras = getIntent().getExtras();
        TransNewAccountFragment transNewAccountFragment = new TransNewAccountFragment();
        if (extras != null && extras.containsKey(TransferContants.IntentKey.INTENT_PARAMS_KEY_2BANK_NEW_VERSION)) {
            transNewAccountFragment.setArguments(extras);
        }
        forwardFragment(transNewAccountFragment, true, "new_account_fragment");
    }
}
