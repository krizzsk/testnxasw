package com.didi.payment.utilities.input;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.base.widget.FastCheckOnClickListener;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.utilities.CsBoletoCheckUtil;
import com.didi.payment.utilities.CsBoletoClipboardChecker;
import com.didi.payment.utilities.CsInputFilter;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsOmegaUtils;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.payment.utilities.editAmount.CsEditAmountActivity;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletUriParam;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.rpc.RpcService;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IThemeRes;
import com.taxis99.R;
import java.io.IOException;

public class CsManualInputActivity extends CsBaseActivity {

    /* renamed from: a */
    private TextView f34160a;

    /* renamed from: b */
    private ImageView f34161b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f34162c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageView f34163d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f34164e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f34165f;

    /* renamed from: g */
    private TextView f34166g;

    /* renamed from: h */
    private View.OnClickListener f34167h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CsInputFilter f34168i = new CsInputFilter();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f34169j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f34170k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Runnable f34171l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public LimitRiskReminderVo f34172m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LimitRiskReminderHandler f34173n = new LimitRiskReminderHandler();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_utilities_layout);
        m26056a();
        this.f34170k = WalletApolloUtil.isBoletoScanOptEnable();
        m26064b();
    }

    /* renamed from: a */
    private void m26056a() {
        Intent intent = getIntent();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebill_number_sw", WalletExtraConstant.Key.PUB_PAGE_FROM, (intent == null || TextUtils.isEmpty(intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM))) ? "" : intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM));
    }

    /* renamed from: b */
    private void m26064b() {
        this.f34160a = (TextView) findViewById(R.id.tv_right);
        this.f34161b = (ImageView) findViewById(R.id.iv_left);
        this.f34162c = (EditText) findViewById(R.id.cs_utilities_input_et);
        this.f34163d = (ImageView) findViewById(R.id.cs_utilities_scan_btn);
        this.f34165f = (TextView) findViewById(R.id.cs_utilities_submit_btn);
        this.f34166g = (TextView) findViewById(R.id.tv_cs_utilities_activity);
        this.f34164e = (ImageView) findViewById(R.id.cs_utilities_clear_btn);
        if (this.f34170k) {
            this.f34162c.setHint("81800000001-2\n53875701200-0\n93010000074-3\n51440029929-0");
        }
        this.f34165f.setTextColor(ContextCompat.getColorStateList(this, ((IThemeRes) DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_THEME)).getThemeColorResData().getCsUtilitiesSubmitBtnBgResId()));
        m26072f();
        m26080j();
        m26065c();
        m26057a(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        CsBoletoClipboardChecker.postClipboardCheckerRunnable(this, "wallet_boleto_input");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        CsBoletoClipboardChecker.removeClipboardCheckerRunnable("wallet_boleto_input");
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m26057a(intent);
    }

    /* renamed from: a */
    private void m26057a(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.BARCODE);
            this.f34172m = (LimitRiskReminderVo) intent.getSerializableExtra(WalletExtraConstant.Key.RISK_LIMIT_REMINDER);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.f34162c.setText(stringExtra);
                m26069e();
                m26060a((Consumer<Integer>) null);
                return;
            }
            m26067d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26060a(final Consumer<Integer> consumer) {
        if (this.f34172m == null) {
            return false;
        }
        findViewById(16908290).post(new Runnable() {
            public void run() {
                CsManualInputActivity.this.f34173n.show(CsManualInputActivity.this.f34172m, CsManualInputActivity.this, (String) null, -1, consumer);
            }
        });
        return true;
    }

    /* renamed from: c */
    private void m26065c() {
        Intent intent = getIntent();
        final String stringExtra = intent.getStringExtra("activity_url");
        String stringExtra2 = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
        if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
            this.f34166g.setVisibility(0);
            this.f34166g.setText(stringExtra2);
            this.f34166g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebBrowserUtil.startInternalWebActivity(CsManualInputActivity.this, stringExtra, "");
                }
            });
        }
    }

    /* renamed from: d */
    private void m26067d() {
        this.f34162c.requestFocus();
    }

    /* renamed from: e */
    private void m26069e() {
        if (getWindow() != null) {
            getWindow().setSoftInputMode(3);
        }
    }

    /* renamed from: f */
    private void m26072f() {
        this.f34167h = new DoubleCheckOnClickListener(800) {
            public void doClick(View view) {
                if (view.getId() == R.id.iv_left) {
                    CsManualInputActivity.this.m26077i();
                } else if (view.getId() == R.id.tv_right) {
                    CsOmegaUtils.trackHistoryBtnClicked("number");
                    CsRouter.startHistoryListActivity4Boleto(CsManualInputActivity.this, 606);
                } else if (view.getId() == R.id.cs_utilities_submit_btn) {
                    CsManualInputActivity.this.m26073g();
                } else if (view.getId() == R.id.cs_utilities_scan_btn) {
                    CsManualInputActivity.this.m26076h();
                } else if (view.getId() == R.id.cs_utilities_clear_btn) {
                    CsManualInputActivity.this.f34162c.setText("");
                }
            }
        };
        this.f34165f.setOnClickListener(new FastCheckOnClickListener(2000) {
            public void doClick(View view) {
                if (!CsManualInputActivity.this.m26060a((Consumer<Integer>) new Consumer<Integer>() {
                    public void accept(Integer num) {
                        if (num.intValue() == 1) {
                            CsManualInputActivity.this.m26073g();
                        }
                    }
                })) {
                    CsManualInputActivity.this.m26073g();
                }
            }
        });
        this.f34163d.setOnClickListener(this.f34167h);
        this.f34164e.setOnClickListener(this.f34167h);
        this.f34162c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (!CsManualInputActivity.this.f34169j) {
                    String removeNonNumber = CsInputFilter.removeNonNumber(editable.toString());
                    CsManualInputActivity.this.m26059a(removeNonNumber);
                    String wrapperString = CsManualInputActivity.this.f34168i.wrapperString(removeNonNumber);
                    boolean unused = CsManualInputActivity.this.f34169j = true;
                    CsManualInputActivity.this.f34162c.setText(wrapperString);
                    if (CsManualInputActivity.this.f34162c.getText() != null) {
                        CsManualInputActivity.this.f34162c.setSelection(CsManualInputActivity.this.f34162c.getText().length());
                    }
                    boolean unused2 = CsManualInputActivity.this.f34169j = false;
                    if (CsManualInputActivity.this.f34170k) {
                        if (TextUtils.isEmpty(CsManualInputActivity.this.f34162c.getText())) {
                            CsManualInputActivity.this.f34164e.setVisibility(8);
                            CsManualInputActivity.this.f34163d.setVisibility(0);
                        } else {
                            CsManualInputActivity.this.f34164e.setVisibility(0);
                            CsManualInputActivity.this.f34163d.setVisibility(8);
                        }
                    }
                    CsManualInputActivity.this.f34165f.setEnabled(!TextUtils.isEmpty(CsManualInputActivity.this.f34162c.getText()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26059a(String str) {
        if (this.f34170k && CsBoletoCheckUtil.checkBoletoTypableLength(str)) {
            final String copyValueOf = String.copyValueOf(str.toCharArray());
            Runnable runnable = this.f34171l;
            if (runnable != null) {
                UiThreadHandler.removeCallbacks(runnable);
            }
            C118736 r0 = new Runnable() {
                public void run() {
                    int i;
                    try {
                        i = CsBoletoCheckUtil.validBoletoCode(copyValueOf);
                    } catch (Exception e) {
                        e.printStackTrace();
                        i = 0;
                    }
                    if (i == 1) {
                        PayTracker.trackEvent("ibt_didipay_pay_boleto_toast_error_sw");
                        WalletToastNew.showFailedMsg(CsManualInputActivity.this.getContext(), ResourcesHelper.getString(CsManualInputActivity.this.getContext(), R.string.cs_boleto_input_error_length));
                    } else if (i == 2) {
                        PayTracker.trackEvent("ibt_didipay_pay_boleto_toast_error_sw");
                        WalletToastNew.showFailedMsg(CsManualInputActivity.this.getContext(), ResourcesHelper.getString(CsManualInputActivity.this.getContext(), R.string.cs_boleto_input_error_content));
                    }
                    Runnable unused = CsManualInputActivity.this.f34171l = null;
                }
            };
            this.f34171l = r0;
            UiThreadHandler.postOnceDelayed(r0, 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m26073g() {
        CsOmegaUtils.trackConfirmBtnClicked("number", (String) null, (String) null);
        String removeNonNumber = CsInputFilter.removeNonNumber(this.f34162c.getText().toString());
        if (!this.f34170k && !CsBoletoCheckUtil.checkBoletoLength(removeNonNumber)) {
            WalletToastNew.showFailedMsg(this, getResources().getString(R.string.cs_boleto_input_error_length));
        } else if (this.f34170k && !CsBoletoCheckUtil.checkBoletoTypableLength(removeNonNumber)) {
            PayTracker.trackEvent("ibt_didipay_pay_boleto_toast_length_error_sw");
            WalletToastNew.showFailedMsg(this, getResources().getString(R.string.cs_boleto_input_error_length));
        } else if (!WalletCommonParamsUtil.isDriverClient() || WalletApolloUtil.isDriverNativeWallet()) {
            showLoadingDialog();
            C118747 r0 = new RpcService.Callback<CsGetBillResp>() {
                public void onSuccess(CsGetBillResp csGetBillResp) {
                    CsManualInputActivity.this.dismissLoadingDialog();
                    if (csGetBillResp != null) {
                        KycOmega.Companion.fin_tech_wallet_http_req_lite_en(csGetBillResp.errno, csGetBillResp.errmsg, "api/v0/didipay/bill");
                    }
                    if (csGetBillResp != null && csGetBillResp.errno != 0 && !TextUtils.isEmpty(csGetBillResp.errmsg)) {
                        WalletToastNew.showFailedMsg(CsManualInputActivity.this, csGetBillResp.errmsg);
                    } else if (csGetBillResp != null && csGetBillResp.data != null) {
                        if (!TextUtils.isEmpty(csGetBillResp.data.linkUrl)) {
                            Uri parse = Uri.parse(csGetBillResp.data.linkUrl);
                            String findUrlStrParam = WalletUriParam.findUrlStrParam(parse, "crashPageTitle");
                            String findUrlStrParam2 = WalletUriParam.findUrlStrParam(parse, "crashPageText");
                            ((Request) ((Request) ((Request) DRouter.build(csGetBillResp.data.linkUrl).putExtra(WalletExtraConstant.Key.CRASH_PAGE_TITLE, findUrlStrParam)).putExtra(WalletExtraConstant.Key.CRASH_PAGE_SUBTITLE, findUrlStrParam2)).putExtra(WalletExtraConstant.Key.CRASH_TYPE, WalletUriParam.findUrlStrParam(parse, "crashType"))).start(CsManualInputActivity.this.getContext());
                            CsManualInputActivity.this.finish();
                        } else if (!TextUtils.isEmpty(csGetBillResp.data.orderId)) {
                            Intent intent = new Intent(CsManualInputActivity.this.getContext(), WalletTopUpPayResultActivity.class);
                            intent.putExtra("product_line", 606);
                            intent.putExtra("order_id", csGetBillResp.data.orderId);
                            intent.putExtra("order_type", -1);
                            intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 260);
                            CsManualInputActivity.this.startActivity(intent);
                        } else if (csGetBillResp.data.needToJumpZeroBill) {
                            CsEditAmountActivity.launch(CsManualInputActivity.this.getContext(), csGetBillResp.data.maxBillAmountLimit, csGetBillResp.data.minBillAmountLimit, csGetBillResp.data.amountInputSubTitle, csGetBillResp);
                        } else {
                            CsManualInputActivity.this.finish();
                            PayTracker.putGlobal("wallet_channel_id", "-1");
                            CsBillDetailActivity.startActivity(csGetBillResp, (Context) CsManualInputActivity.this, OmegaComParams.BOLETO_MANUAL_PAGE);
                        }
                    }
                }

                public void onFailure(IOException iOException) {
                    CsManualInputActivity.this.dismissLoadingDialog();
                    KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "api/v0/didipay/bill");
                }
            };
            CsNetModel.getIns(this).getBillInfo(606, CsInputFilter.removeNonNumber(this.f34162c.getText().toString()), r0);
        } else {
            WebBrowserUtil.startInternalWebActivity(this, "https://page.99taxis.mobi/pay_intl_driver/wallet99_bank_transfer_boleto_payment/wallet99_bank_transfer_boleto_payment.html?jumpTo=BoletoNativeSDK&barcode=" + removeNonNumber, "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m26076h() {
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebill_number_camera_ck");
        CsRouter.startScanActivity(this);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m26077i() {
        if (this.f34170k) {
            CsRouter.startUtilitiesActivity(this);
        }
        finish();
    }

    public void onBackPressed() {
        m26077i();
    }

    /* access modifiers changed from: protected */
    public View getLoadingAnchorView() {
        return findViewById(R.id.history_contacts_title_bar);
    }

    /* renamed from: j */
    private void m26080j() {
        this.f34161b.setOnClickListener(this.f34167h);
        if (!this.f34170k) {
            this.f34160a.setVisibility(0);
            this.f34160a.setText(getResources().getString(R.string.cs_history_page_enter));
            this.f34160a.setOnClickListener(this.f34167h);
            return;
        }
        this.f34160a.setVisibility(4);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f34173n.destroy();
        super.onDestroy();
    }
}
