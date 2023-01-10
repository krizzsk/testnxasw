package com.didi.payment.transfer.historyaccounts;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseFragment;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.historyaccounts.TransHistoryAccountAdapter;
import com.didi.payment.transfer.historyaccounts.presenter.ITransHistoryAccountPresenter;
import com.didi.payment.transfer.historyaccounts.presenter.TransHistoryAccountPresenter;
import com.didi.payment.transfer.utils.LoadBankInfoTask;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.payment.transfer.utils.TransStore;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransHistoryAccountFragment extends TransBaseFragment<ITransHistoryAccountPresenter> implements ITransHistoryAccountView {

    /* renamed from: a */
    private View f33936a;

    /* renamed from: b */
    private RecyclerView f33937b;

    /* renamed from: c */
    private TransHistoryAccountAdapter f33938c;

    /* renamed from: d */
    private TextView f33939d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public NNPayAccount f33940e;

    /* renamed from: f */
    private List<NNPayAccount> f33941f = new ArrayList();

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_history_account_list_lay;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Parcelable[] parcelableArray = arguments != null ? arguments.getParcelableArray("account_record_array") : null;
        if (parcelableArray != null) {
            this.f33941f.clear();
            for (Parcelable parcelable : parcelableArray) {
                if (parcelable instanceof NNPayAccount) {
                    this.f33941f.add((NNPayAccount) parcelable);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ITransHistoryAccountPresenter onCreatePresenter() {
        return new TransHistoryAccountPresenter(getContext(), this);
    }

    /* access modifiers changed from: protected */
    public void initViews(View view) {
        super.initViews(view);
        View findViewById = view.findViewById(R.id.trans_history_add_account_entrance_view);
        this.f33936a = findViewById;
        findViewById.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                TransOmegaUtil.trackEvent("ibt_didipay_p2p_bank_account_contact_add_account_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                PayEventPublisher.getPublisher().publish(PayEventKeys.FragmentForward.EVENT_FORWARD_TO_ADDNEW_ACCOUNT);
            }
        });
        this.f33939d = (TextView) view.findViewById(R.id.trans_history_records_title);
        this.f33937b = (RecyclerView) view.findViewById(R.id.trans_history_record_lv);
        TransHistoryAccountAdapter transHistoryAccountAdapter = new TransHistoryAccountAdapter(getActivity(), 1, new ArrayList());
        this.f33938c = transHistoryAccountAdapter;
        transHistoryAccountAdapter.setOnItemclickListener(new TransHistoryAccountAdapter.OnItemClickListener() {
            public void onItemClick(NNPayAccount nNPayAccount) {
                TransOmegaUtil.trackEventWithGlobal("ibt_didipay_p2p_bank_account_existing_payee_ck", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
                NNPayAccount unused = TransHistoryAccountFragment.this.f33940e = nNPayAccount;
                if (TransStore.getInstance().isBankDataPrepared()) {
                    continueToConfirm(TransHistoryAccountFragment.this.f33940e);
                    return;
                }
                TransHistoryAccountFragment.this.onShowPageLoadding();
                new LoadBankInfoTask(TransHistoryAccountFragment.this.getContext().getApplicationContext()) {
                    /* access modifiers changed from: protected */
                    public void onPostExecute(Integer num) {
                        super.onPostExecute(num);
                        TransHistoryAccountFragment.this.onDismissPageLoadding();
                        C117782 r2 = C117782.this;
                        r2.continueToConfirm(TransHistoryAccountFragment.this.f33940e);
                    }
                }.execute(new String[]{TransferContants.BankData.STATIC_BANK_JSON_FILE});
            }

            /* access modifiers changed from: private */
            public void continueToConfirm(NNPayAccount nNPayAccount) {
                if (nNPayAccount != null) {
                    String valueByType = nNPayAccount.getValueByType(IConfirmTransferInfo.ValueType.BANK_CODE);
                    try {
                        nNPayAccount.setTypeValue(IConfirmTransferInfo.ValueType.BANK_NAME, TransStore.getInstance().getBankName(Integer.parseInt(valueByType)));
                    } catch (Exception unused) {
                        SystemUtils.log(3, "trans_log", "can't find b item with c: " + valueByType, (Throwable) null, "com.didi.payment.transfer.historyaccounts.TransHistoryAccountFragment$2", 129);
                    }
                    ((ITransHistoryAccountPresenter) TransHistoryAccountFragment.this.mDefaultPresenter).toConfirmAmount(nNPayAccount);
                }
            }
        });
        this.f33937b.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f33937b.setAdapter(this.f33938c);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TransOmegaUtil.trackEvent("ibt_didipay_p2p_bank_account_contact_sw", TransGlobalOmegaKey.KEY_WALLET_PAGEID, TransGlobalOmegaKey.KEY_ACCOUNT_STATUS);
        updateHistoryTransAccount(this.f33941f);
    }

    public void onShowPageLoadding() {
        notifyParentPageLoading(true);
    }

    public void onDismissPageLoadding() {
        notifyParentPageLoading(false);
    }

    public void updateHistoryTransAccount(List<NNPayAccount> list) {
        this.f33936a.setVisibility(0);
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            SystemUtils.log(3, "trans_tag", "something wrong report this to RD @dominic", (Throwable) null, "com.didi.payment.transfer.historyaccounts.TransHistoryAccountFragment", 162);
            return;
        }
        this.f33939d.setVisibility(0);
        this.f33937b.setVisibility(0);
        this.f33938c.updateData(list);
    }
}
