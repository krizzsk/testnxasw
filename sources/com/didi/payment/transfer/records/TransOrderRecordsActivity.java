package com.didi.payment.transfer.records;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.payment.transfer.records.TransHistoryRcyAdapter;
import com.didi.payment.transfer.records.presenter.ITransRecordPresenter;
import com.didi.payment.transfer.records.presenter.TransRecordPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class TransOrderRecordsActivity extends TransBaseActivity<ITransRecordPresenter> implements ITransRecordPageView {

    /* renamed from: b */
    private CommonTitleBar f34024b;

    /* renamed from: c */
    private RecyclerView f34025c;

    /* renamed from: d */
    private View f34026d;

    /* renamed from: e */
    private TextView f34027e;

    /* renamed from: f */
    private TransHistoryRcyAdapter f34028f;

    /* renamed from: g */
    private int f34029g;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_history_root_lay;
    }

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return true;
    }

    public void loadHistoryRecords() {
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.trans_history_titlebar;
    }

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, TransOrderRecordsActivity.class);
        intent.putExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, i);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, TransOrderRecordsActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.f34024b = (CommonTitleBar) findViewById(R.id.trans_history_titlebar);
        this.f34025c = (RecyclerView) findViewById(R.id.trans_history_ry);
        this.f34026d = findViewById(R.id.trans_history_empty_layout);
        this.f34027e = (TextView) findViewById(R.id.trans_history_empty_tv);
        this.f34028f = new TransHistoryRcyAdapter(this, new TransHistoryRcyAdapter.HistoryListCallback() {
            public void onLastItemShowed() {
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadHistoryData(false);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadNextPage();
            }
        }, new TransHistoryRcyAdapter.HistoryListItemClickListener() {
            public void onItemClick(TransHistoryListResp.HistoryItem historyItem) {
                if (historyItem == null) {
                    SystemUtils.log(3, "wallet", "click item null", (Throwable) null, "com.didi.payment.transfer.records.TransOrderRecordsActivity$2", 80);
                    return;
                }
                SystemUtils.log(3, "hgl_tag", "click item: " + historyItem.name, (Throwable) null, "com.didi.payment.transfer.records.TransOrderRecordsActivity$2", 84);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).handleItemClick(historyItem);
            }
        });
        this.f34025c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f34025c.setAdapter(this.f34028f);
        m25924b();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m25922a();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
    }

    /* renamed from: a */
    private void m25922a() {
        this.f34029g = getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 606);
        ((ITransRecordPresenter) this.mPresenter).loadHistoryData(true);
    }

    /* renamed from: b */
    private void m25924b() {
        this.f34024b.setLeftImage(ResourcesHelper.getDrawable(this, R.drawable.one_payment_creditcard_global_btn_title_back_selector), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).handleBackClick();
            }
        });
        this.f34024b.setTitle(getResources().getString(R.string.GRider_PAX_Transfers_records_IXzB));
    }

    public void appendHistoryItem(TransHistoryListResp.DataModel dataModel) {
        this.f34025c.setVisibility(0);
        this.f34028f.addData(dataModel.orders);
    }

    public void pageFinish() {
        finish();
    }

    public void showEmptyView(int i) {
        this.f34025c.setVisibility(8);
        this.f34026d.setVisibility(0);
        this.f34026d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (TransOrderRecordsActivity.this.mPresenter != null) {
                    ((ITransRecordPresenter) TransOrderRecordsActivity.this.mPresenter).loadHistoryData(true);
                }
            }
        });
        this.f34027e.setText(i);
    }

    /* access modifiers changed from: protected */
    public ITransRecordPresenter onCreatePresenter() {
        return new TransRecordPresenter(this, this);
    }
}
