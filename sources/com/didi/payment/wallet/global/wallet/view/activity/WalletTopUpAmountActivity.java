package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.dialog.VerifyDialogFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.payment.wallet.global.model.resp.WalletTopUpAmountItemsResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.utils.WalletSecuritySPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpAmountContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpAmountPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletTopUpAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;
import java.util.HashMap;

public class WalletTopUpAmountActivity extends WalletBaseActivity implements WalletTopUpAmountContract.View {
    public static final String KEY_FROM = "key_from";
    @Deprecated
    public static final String KEY_FROM_XPANEL = "key_from_wallet";
    public static final int REQUEST_CODE_TOPUP_RESULT_LOADING = 12;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletTopUpAmountContract.Presenter f34740a;

    /* renamed from: b */
    private View f34741b;

    /* renamed from: c */
    private View f34742c;

    /* renamed from: d */
    private TextView f34743d;

    /* renamed from: e */
    private TextView f34744e;

    /* renamed from: f */
    private TextView f34745f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f34746g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RecyclerView f34747h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletTopUpAdapter f34748i;

    /* renamed from: j */
    private TextView f34749j;

    /* renamed from: k */
    private WalletTopUpAdapter.OnAmountClickListener f34750k = new WalletTopUpAdapter.OnAmountClickListener() {
        public void onClick(WalletTopUpAmountItemsResp.TopupItem topupItem, String str) {
            if ("1".equalsIgnoreCase(topupItem.disabled)) {
                if (TextUtil.isEmpty(str)) {
                    str = WalletTopUpAmountActivity.this.getString(R.string.wallet_topup_amount_disable_reason);
                }
                WalletToastNew.showFailedMsg(WalletTopUpAmountActivity.this, str);
                WalletTopUpAmountActivity.this.f34740a.trackOmega(6);
                return;
            }
            WalletTopUpAmountActivity.this.f34748i.refreshSelectAmount(topupItem);
            if (!TextUtils.isEmpty(topupItem.customer)) {
                WalletTopUpAmountActivity.this.f34746g.setEnabled(!TextUtils.isEmpty(topupItem.name));
                WalletTopUpAmountActivity.this.f34740a.trackOmega(3);
                return;
            }
            WalletTopUpAmountActivity.this.f34746g.setEnabled(true);
        }
    };

    /* renamed from: l */
    private WalletTopUpAdapter.OnCustomerAmountChangeListener f34751l = new WalletTopUpAdapter.OnCustomerAmountChangeListener() {
        public void onChange(double d) {
            WalletTopUpAmountActivity.this.f34746g.setEnabled(d != 0.0d);
        }
    };

    public static void launch(Context context, Bundle bundle, int i) {
        Intent intent = new Intent(context, WalletTopUpAmountActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        GlobalOmegaUtils.trackTopupCardPaymentPageSW();
        setContentView((int) R.layout.wallet_global_activity_topup_amount);
        m26536a();
        WalletTopUpAmountPresenter walletTopUpAmountPresenter = new WalletTopUpAmountPresenter(this, this, this);
        this.f34740a = walletTopUpAmountPresenter;
        walletTopUpAmountPresenter.requestData();
        this.f34740a.trackOmega(0);
        if (bundle != null) {
            String string = bundle.getString("order_id", "");
            if (!TextUtils.isEmpty(string)) {
                this.f34740a.setOrderId(string);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    private void m26536a() {
        this.f34741b = findViewById(R.id.ll_content);
        this.f34742c = findViewById(R.id.ll_empty);
        this.f34747h = (RecyclerView) findViewById(R.id.rv_amount);
        this.f34743d = (TextView) findViewById(R.id.tv_title);
        this.f34744e = (TextView) findViewById(R.id.tv_desc);
        this.f34745f = (TextView) findViewById(R.id.tv_rule);
        this.f34746g = (TextView) findViewById(R.id.bt_topup);
        this.f34749j = (TextView) findViewById(R.id.tv_goto_faq);
        this.f34742c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpAmountActivity.this.f34740a.requestData();
            }
        });
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpAmountActivity.this.f34740a.onBack();
                WalletTopUpAmountActivity.this.finish();
            }
        });
        this.f34741b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InputTools.hideKeyboard(WalletTopUpAmountActivity.this.f34747h);
                if (WalletTopUpAmountActivity.this.f34748i != null) {
                    WalletTopUpAmountActivity.this.f34748i.refreshCustomerAmountUnInputStatus();
                }
            }
        });
        this.f34747h.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == 0 || motionEvent.getAction() != 1) {
                    return false;
                }
                InputTools.hideKeyboard(WalletTopUpAmountActivity.this.f34747h);
                if (WalletTopUpAmountActivity.this.f34748i == null) {
                    return false;
                }
                WalletTopUpAmountActivity.this.f34748i.refreshCustomerAmountUnInputStatus();
                return false;
            }
        });
        initLoadingDialog(this, R.id.layout_title_bar);
    }

    public void refreshUI(final WalletTopUpAmountItemsResp.DataBean dataBean) {
        int i = 0;
        this.f34741b.setVisibility(0);
        this.f34742c.setVisibility(8);
        this.f34744e.setText(dataBean.amountText);
        if (!this.f34740a.isTopupByDriver()) {
            this.f34743d.setText(dataBean.pageTitle);
            if (dataBean.cashinLimitSection != null) {
                this.f34745f.setText(dataBean.cashinLimitSection.selectAmountRuleText);
                final WalletTopUpAmountItemsResp.CashInLimitSection cashInLimitSection = dataBean.cashinLimitSection;
                if (cashInLimitSection.type == 1) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "input_amount");
                    hashMap.put("pub_target", "text");
                    hashMap.put("pub_biz", "fintech");
                    hashMap.put("product_line", Integer.valueOf(dataBean.productLine));
                    hashMap.put("text_theme", "limit_rules");
                    hashMap.put("button_name", "text");
                    hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                    FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_sw", hashMap);
                }
                this.f34745f.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_FF4060));
                this.f34745f.setVisibility(!TextUtils.isEmpty(dataBean.cashinLimitSection.selectAmountRuleText) ? 0 : 8);
                this.f34749j.setText(dataBean.cashinLimitSection.verifyText);
                TextView textView = this.f34749j;
                if (TextUtils.isEmpty(dataBean.cashinLimitSection.verifyText)) {
                    i = 8;
                }
                textView.setVisibility(i);
                this.f34745f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (cashInLimitSection.type == 2) {
                            WebBrowserUtil.startInternalWebActivity(WalletTopUpAmountActivity.this.getContext(), cashInLimitSection.link, "");
                            FinOmegaSDK.trackEvent("ibt_didipay_phone_topup_verify_ck");
                        } else if (cashInLimitSection.type == 1) {
                            DRouter.build(cashInLimitSection.link).start(WalletTopUpAmountActivity.this);
                            HashMap hashMap = new HashMap();
                            hashMap.put("pub_page", "input_amount");
                            hashMap.put("pub_target", "text");
                            hashMap.put("pub_biz", "fintech");
                            hashMap.put("product_line", Integer.valueOf(dataBean.productLine));
                            hashMap.put("text_theme", "limit_rules");
                            hashMap.put("kyc_tag", Integer.valueOf(WalletSecuritySPUtils.getKycTag()));
                            FinOmegaSDK.trackEvent("ibt_fintech_passenger_text_ck", hashMap);
                        }
                    }
                });
            } else {
                this.f34745f.setText(dataBean.ruleText);
                this.f34745f.setTextColor(ResourcesHelper.getColor(getContext(), R.color.oc_color_999999));
            }
        } else {
            this.f34745f.setVisibility(8);
        }
        this.f34746g.setText(dataBean.buttonText);
        this.f34746g.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                WalletTopUpAmountItemsResp.CashInLimitSection cashInLimitSection = dataBean.cashinLimitSection;
                if (cashInLimitSection != null) {
                    try {
                        if (cashInLimitSection.type != 2 || WalletTopUpAmountActivity.this.f34748i.convertStringToInt(WalletTopUpAmountActivity.this.f34748i.getCurrentSelectItem().price) * 100 <= Integer.parseInt(cashInLimitSection.maximumAmount) || cashInLimitSection.dialog == null) {
                            WalletTopUpAmountActivity.this.m26540b();
                        } else {
                            WalletTopUpAmountActivity.this.m26538a(cashInLimitSection.dialog.title, cashInLimitSection.dialog.desc, cashInLimitSection.dialog.kycLink);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    WalletTopUpAmountActivity.this.m26540b();
                }
            }
        });
        WalletTopUpAdapter walletTopUpAdapter = new WalletTopUpAdapter(this, dataBean.items, dataBean.disabledReason, this.f34750k, this.f34751l);
        this.f34748i = walletTopUpAdapter;
        walletTopUpAdapter.setTrackOmegaCallback(new WalletTopUpAdapter.TrackOmegaCallback() {
            public void onTrackOmega(int i) {
                WalletTopUpAmountActivity.this.f34740a.trackOmega(i);
            }
        });
        this.f34747h.setLayoutManager(new GridLayoutManager(this, 2));
        this.f34747h.setAdapter(this.f34748i);
        GlobalOmegaUtils.trackTopUpDetailShow(this);
    }

    public void onNetworkError() {
        this.f34741b.setVisibility(8);
        this.f34742c.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26540b() {
        this.f34740a.handleTopUpClick(this.f34748i.getCurrentSelectItem());
        WalletTopUpAmountItemsResp.TopupItem currentSelectItem = this.f34748i.getCurrentSelectItem();
        if (currentSelectItem != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("chosen_amount", currentSelectItem.price);
            this.f34740a.trackOmega(2, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        dismissLoadingDialog();
        if (i == 12) {
            this.f34740a.onTopupLoadingFinish();
        } else if (i2 != -1) {
        } else {
            if (i == 200) {
                if (intent.getIntExtra("code", 3) == 1) {
                    this.f34740a.onPaySuccess(intent.getStringExtra("message"));
                }
            } else if (intent.getIntExtra("code", 3) == 1) {
                this.f34740a.onPaySuccess(intent.getStringExtra("message"));
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        WalletTopUpAdapter walletTopUpAdapter = this.f34748i;
        if (!(walletTopUpAdapter == null || walletTopUpAdapter.getCurrentSelectItem() == null)) {
            HashMap hashMap = new HashMap();
            hashMap.put("chosen_amount", this.f34748i.getCurrentSelectItem().price);
            this.f34740a.trackOmega(2, hashMap);
        }
        this.f34740a.onBack();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26538a(String str, String str2, final String str3) {
        new VerifyDialogFragment.Builder().showCloseBtn(false).setImageRes(R.drawable.one_pay_base_transfer_failed).setTitle(str).setContent(str2).setClickListener(getString(R.string.wallet_common_btn_verify_now), getString(R.string.wallet_common_btn_next_time), new VerifyDialogFragment.OnClickListener() {
            public void onPositiveClick(VerifyDialogFragment verifyDialogFragment) {
                DRouter.build(str3).start((Context) null);
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_verify_ck");
                verifyDialogFragment.dismiss();
            }

            public void onNegativeClick(VerifyDialogFragment verifyDialogFragment) {
                FinOmegaSDK.trackEvent("ibt_didipay_recharge_details_ck");
                verifyDialogFragment.dismiss();
            }
        }).create().show(getSupportFragmentManager(), "verify_dialog_fragment");
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        WalletTopUpAmountContract.Presenter presenter = this.f34740a;
        if (presenter != null && !TextUtils.isEmpty(presenter.getOrderId())) {
            bundle.putString("order_id", this.f34740a.getOrderId());
        }
    }
}
