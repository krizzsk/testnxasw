package com.didi.payment.utilities.scan;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.dqr.common.StringUtils;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel1;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel2;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel3;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.router.CodeScan;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.utils.KycOmega;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.utilities.CsBoletoCheckUtil;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.payment.utilities.editAmount.CsEditAmountActivity;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.utilities.scan.CsScanGuideDialog;
import com.didi.payment.utilities.scan.widget.CsI25ZBarScannerView;
import com.didi.payment.utilities.scan.widget.CsScanView;
import com.didi.payment.utilities.scan.widget.CsViewFinderView;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;
import p068me.dm7.barcodescanner.zbar.Result;

public class CsScanActivity extends CsBaseActivity implements SensorEventListener, View.OnClickListener, CsI25ZBarScannerView.EventListener, CsI25ZBarScannerView.ResultHandler, CsViewFinderView.OnFrameRectUpdatedListener {

    /* renamed from: a */
    boolean f34188a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsScanView f34189b;

    /* renamed from: c */
    private TextView f34190c;

    /* renamed from: d */
    private ImageView f34191d;

    /* renamed from: e */
    private ViewGroup f34192e;

    /* renamed from: f */
    private long f34193f;

    /* renamed from: g */
    private boolean f34194g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f34195h;

    /* renamed from: i */
    private boolean f34196i;

    /* renamed from: j */
    private SensorManager f34197j;

    /* renamed from: k */
    private CsScanGuideDialog f34198k;

    /* renamed from: l */
    private GGKDialogFragment f34199l;

    /* renamed from: m */
    private GGKDialogFragment f34200m;

    /* renamed from: n */
    private String f34201n;

    /* renamed from: o */
    private boolean f34202o;

    /* renamed from: p */
    private String f34203p = "";

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        getWindow().addFlags(1024);
        m26100a();
        this.f34195h = WalletApolloUtil.isBoletoScanOptEnable();
        setContentView((int) R.layout.cs_activity_scan_layout);
        m26112c();
        m26108b();
        m26116d();
    }

    /* renamed from: a */
    private void m26100a() {
        Intent intent = getIntent();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebill_code_sw", WalletExtraConstant.Key.PUB_PAGE_FROM, (intent == null || TextUtils.isEmpty(intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM))) ? "" : intent.getStringExtra(WalletExtraConstant.Key.PUB_PAGE_FROM));
    }

    /* renamed from: b */
    private void m26108b() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.f34203p = getIntent().getExtras().getString(InvitationPageActivity.RESOURCE_ID);
        }
    }

    /* renamed from: c */
    private void m26112c() {
        initProgressDialog(this, R.id.cs_scan_title_bar);
        CsScanView csScanView = (CsScanView) findViewById(R.id.scan_view);
        this.f34189b = csScanView;
        csScanView.setOnFrameUpdatedListener(this);
        ((ImageView) findViewById(R.id.cs_title_bar_left_btn)).setOnClickListener(this);
        ((TextView) findViewById(R.id.cs_scan_page_tap_btn)).setOnClickListener(this);
        ImageView imageView = (ImageView) findViewById(R.id.cs_scan_light_btn);
        this.f34191d = imageView;
        int i = 0;
        imageView.setVisibility(this.f34195h ? 0 : 8);
        this.f34191d.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(R.id.cs_scan_help);
        imageView2.setOnClickListener(this);
        if (!this.f34195h) {
            i = 8;
        }
        imageView2.setVisibility(i);
        this.f34192e = (ViewGroup) findViewById(R.id.cs_scan_bottom_container);
        this.f34201n = getString(R.string.cs_boleto_scan_tips_guide);
        TextView textView = (TextView) findViewById(R.id.cs_scan_tips);
        this.f34190c = textView;
        textView.setText(this.f34201n);
    }

    /* renamed from: d */
    private void m26116d() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    CsScanActivity.this.m26119e();
                    PayTracker.getTracker().trackEvent("ibt_boleto_scan_permission_yes_sw");
                    return;
                }
                PayTracker.getTracker().trackEvent("ibt_boleto_scan_permission_no_sw");
            }
        }, new String[]{Permission.CAMERA}, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m26119e() {
        if (!m26123f()) {
            this.f34189b.setEventListener(this);
            m26128h();
            m26129i();
            m26130j();
            m26131k();
        }
    }

    /* renamed from: f */
    private boolean m26123f() {
        boolean q = m26137q();
        this.f34188a = q;
        if (q) {
            this.f34189b.setMexicoScannerType(m26138r(), m26139s());
        }
        boolean z = !PaySharedPreferencesUtil.isBoletoScanGuideShown(this) && this.f34195h;
        if (!m26140t() && !z) {
            return false;
        }
        this.f34198k = CsScanGuideDialog.show(this, Boolean.valueOf(this.f34188a), new CsScanGuideDialog.Listener() {
            public void onScanGuideShownOver(CsScanGuideDialog csScanGuideDialog) {
                CsScanActivity.this.m26125g();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m26125g() {
        PaySharedPreferencesUtil.setBoletoScanGuideShown(this, true);
        this.f34198k = null;
        this.f34189b.setEventListener(this);
        m26128h();
        m26129i();
        m26130j();
        m26131k();
    }

    /* renamed from: h */
    private void m26128h() {
        this.f34193f = System.currentTimeMillis();
    }

    /* renamed from: i */
    private void m26129i() {
        SensorManager sensorManager;
        Sensor defaultSensor;
        if (this.f34195h && (sensorManager = (SensorManager) getSystemService(ISecurityConf.KEY_SENSOR)) != null && (defaultSensor = sensorManager.getDefaultSensor(5)) != null) {
            sensorManager.registerListener(this, defaultSensor, 3);
            this.f34197j = sensorManager;
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (!this.f34194g && sensorEvent != null && sensorEvent.values != null && sensorEvent.values.length > 0 && sensorEvent.values[0] < 3.0f) {
            try {
                this.f34189b.setFlash(true);
                this.f34191d.setSelected(true);
                this.f34190c.setText(R.string.cs_boleto_scan_tips_action_light_on);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            SensorManager sensorManager = this.f34197j;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        }
    }

    public void onFrameRectUpdated(Rect rect) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f34192e.getLayoutParams();
        marginLayoutParams.topMargin = rect.bottom;
        this.f34192e.setLayoutParams(marginLayoutParams);
        if (!this.f34196i) {
            this.f34196i = true;
            m26122f("ibt_didpay_pay_boleto_pre_scan_guide_sw");
            this.f34190c.setVisibility(0);
        }
    }

    /* renamed from: j */
    private void m26130j() {
        if (this.f34195h) {
            UiThreadHandler.postOnceDelayed(new Runnable() {
                public void run() {
                    CsScanActivity.this.m26133m();
                }
            }, ((long) WalletApolloUtil.getBoletoScanOptTimeoutDelay()) * 1000);
        }
    }

    /* renamed from: k */
    private void m26131k() {
        if (this.f34195h) {
            UiThreadHandler.postOnceDelayed(new Runnable() {
                public void run() {
                    CsScanActivity.this.m26134n();
                }
            }, ((long) WalletApolloUtil.getBoletoScanOptFailedDelay()) * 1000);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.cs_title_bar_left_btn) {
            m26118d("ibt_boleto_back_after_scan_page_sw");
            m26104a((Runnable) new Runnable() {
                public void run() {
                    CsScanActivity.this.m26132l();
                }
            });
        } else if (view.getId() == R.id.cs_scan_page_tap_btn) {
            if (this.f34188a) {
                finish();
                return;
            }
            m26118d("ibt_boleto_manual_mode_after_scan_page_sw");
            m26104a((Runnable) new Runnable() {
                public void run() {
                    CsScanActivity.this.m26106a("");
                }
            });
        } else if (view.getId() == R.id.cs_scan_help) {
            WebBrowserUtil.startInternalWebActivity(this, WalletConstant.URL.H5_UTILITIES_GUIDE, "");
        } else if (view.getId() == R.id.cs_scan_light_btn) {
            boolean z = true;
            this.f34194g = true;
            try {
                this.f34189b.setFlash(!this.f34191d.isSelected());
                ImageView imageView = this.f34191d;
                if (this.f34191d.isSelected()) {
                    z = false;
                }
                imageView.setSelected(z);
                if (this.f34191d.isSelected()) {
                    this.f34190c.setText(R.string.cs_boleto_scan_tips_action_light_on);
                } else {
                    this.f34190c.setText(this.f34201n);
                }
                m26122f("ibt_didpay_pay_boleto_flashlight_ck");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26106a(String str) {
        String str2;
        String str3;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
            str2 = intent.getStringExtra("activity_url");
            str3 = stringExtra;
        } else {
            str3 = null;
            str2 = null;
        }
        CsRouter.startManualInputActivity(this, str3, str2, str, (LimitRiskReminderVo) null, OmegaComParams.BOLETO_SCAN_PAGE);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m26111b(String str) {
        PayTracker.putGlobal("wallet_channel_id", "-1");
        if (!WalletCommonParamsUtil.isDriverClient() || WalletApolloUtil.isDriverNativeWallet()) {
            m26115c(str);
            return;
        }
        WebBrowserUtil.startInternalWebActivity(this, "https://page.99taxis.mobi/pay_intl_driver/wallet99_bank_transfer_boleto_payment/wallet99_bank_transfer_boleto_payment.html?jumpTo=BoletoNativeSDK&barcode=" + str, "");
    }

    /* renamed from: c */
    private void m26115c(String str) {
        showLoadingDialog();
        CsNetModel.getIns(this).getBillInfo(606, str, new RpcService.Callback<CsGetBillResp>() {
            public void onSuccess(CsGetBillResp csGetBillResp) {
                CsScanActivity.this.dismissLoadingDialog();
                if (csGetBillResp != null) {
                    KycOmega.Companion.fin_tech_wallet_http_req_lite_en(csGetBillResp.errno, csGetBillResp.errmsg, "api/v0/didipay/bill1");
                }
                if (csGetBillResp != null && csGetBillResp.errno != 0 && !TextUtils.isEmpty(csGetBillResp.errmsg)) {
                    WalletToastNew.showFailedMsg(CsScanActivity.this, csGetBillResp.errmsg);
                } else if (csGetBillResp != null && csGetBillResp.data != null) {
                    if (!TextUtils.isEmpty(csGetBillResp.data.orderId)) {
                        Intent intent = new Intent(CsScanActivity.this.getContext(), WalletTopUpPayResultActivity.class);
                        intent.putExtra("product_line", 606);
                        intent.putExtra("order_id", csGetBillResp.data.orderId);
                        intent.putExtra("order_type", -1);
                        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 260);
                        CsScanActivity.this.startActivity(intent);
                        CsScanActivity.this.finish();
                    } else if (csGetBillResp.data.needToJumpZeroBill) {
                        CsEditAmountActivity.launch(CsScanActivity.this.getContext(), csGetBillResp.data.maxBillAmountLimit, csGetBillResp.data.minBillAmountLimit, csGetBillResp.data.amountInputSubTitle, csGetBillResp);
                        CsScanActivity.this.finish();
                    } else {
                        CsBillDetailActivity.startActivity(csGetBillResp, (Context) CsScanActivity.this, OmegaComParams.BOLETO_SCAN_PAGE);
                        CsScanActivity.this.finish();
                    }
                }
            }

            public void onFailure(IOException iOException) {
                CsScanActivity.this.dismissLoadingDialog();
                KycOmega.Companion.fin_tech_wallet_http_req_lite_en(-11, "", "api/v0/didipay/bill1");
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m26132l() {
        if (this.f34188a) {
            finish();
            return;
        }
        if (!"1".equals(this.f34203p) && this.f34195h) {
            CsRouter.startUtilitiesActivity(this);
        }
        finish();
    }

    public void onResume() {
        super.onResume();
        this.f34189b.setResultHandler(this);
        this.f34189b.startCamera();
    }

    public void onPause() {
        super.onPause();
        this.f34189b.stopCamera();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f34202o = true;
        SensorManager sensorManager = this.f34197j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        CsScanGuideDialog csScanGuideDialog = this.f34198k;
        if (csScanGuideDialog != null) {
            csScanGuideDialog.dismiss();
        }
        GGKDialogFragment gGKDialogFragment = this.f34199l;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
        }
        GGKDialogFragment gGKDialogFragment2 = this.f34200m;
        if (gGKDialogFragment2 != null) {
            gGKDialogFragment2.dismiss();
        }
    }

    public void onBackPressed() {
        m26118d("ibt_boleto_back_after_scan_page_sw");
        m26104a((Runnable) new Runnable() {
            public void run() {
                CsScanActivity.this.m26132l();
            }
        });
    }

    public void onLowMemory() {
        super.onLowMemory();
        CsScanView csScanView = this.f34189b;
        if (csScanView != null) {
            csScanView.dumpCollectedData(false);
        }
    }

    public View getLoadingAnchorView() {
        return findViewById(R.id.cs_scan_title_bar);
    }

    public void onQRCodeFound() {
        m26135o();
    }

    public void onScanningActionTracked() {
        if (this.f34195h) {
            m26122f("ibt_didipay_pay_boleto_scan_in_progress_sw");
            String string = getString(R.string.cs_boleto_scan_tips_action_tracked);
            this.f34201n = string;
            this.f34190c.setText(string);
        }
    }

    public void onPreviewUploadDone() {
        m26122f("ibt_didipay_pay_boleto_scan_timeout_upload_sucess_sw");
        WalletToastNew.showSuccessMsg(this, getString(R.string.cs_boleto_scan_screen_upload_success));
    }

    public boolean handleResult(Result result) {
        String name;
        this.f34189b.dumpCollectedData(false);
        final String contents = result.getContents();
        String str = "";
        if (!(result.getBarcodeFormat() == null || (name = result.getBarcodeFormat().getName()) == null)) {
            str = name;
        }
        if (this.f34188a) {
            if (CsBoletoCheckUtil.checkMexicoLength(contents)) {
                m26121e(str);
                EventBus.getDefault().post(new CodeScan(contents));
                finish();
                return true;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("cur_length", Integer.valueOf(contents.length()));
            hashMap.put("max_length", Integer.valueOf(m26139s()));
            hashMap.put("min_length", Integer.valueOf(m26138r()));
            FinOmegaSDK.trackEvent("fin_walletscan_barcode_overlimit_sw", hashMap);
            return false;
        } else if (!this.f34195h && !CsBoletoCheckUtil.checkBoletoLength(contents)) {
            m26107a(contents, str);
            WalletToastNew.showFailedMsg(this, getResources().getString(R.string.cs_invalidate_num));
            return false;
        } else if (!this.f34195h || CsBoletoCheckUtil.checkBoletoBarcodeLength(contents)) {
            m26121e(str);
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (CsScanActivity.this.f34195h) {
                        CsScanActivity.this.m26111b(contents);
                    } else {
                        CsScanActivity.this.m26106a(contents);
                    }
                }
            });
            return true;
        } else {
            m26107a(contents, str);
            WalletToastNew.showFailedMsg(this, getResources().getString(R.string.cs_invalidate_num));
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m26133m() {
        if (!this.f34202o && this.f34200m == null && this.f34199l == null) {
            String string = getString(R.string.cs_boleto_scan_timeout_tips_dialog_title);
            String string2 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_content);
            String string3 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_pos);
            String string4 = getString(R.string.cs_boleto_scan_timeout_tips_dialog_neg);
            GGKDialogModel3 gGKDialogModel3 = new GGKDialogModel3(string, string2, new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m26122f("ibt_didipay_pay_boleto_scan_timeout_retry_ck");
                    CsScanActivity.this.m26136p();
                }
            }));
            gGKDialogModel3.addMinorBtn(new GGKBtnTextAndCallback(string4, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m26122f("ibt_didipay_pay_boleto_scan_timeout_upload_ck");
                    CsScanActivity.this.m26136p();
                    CsScanActivity.this.f34189b.doUploadOnceInNextPreview();
                }
            }));
            m26122f("ibt_didipay_pay_boleto_scan_timeout_sw");
            this.f34199l = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel3, "tips_dialog");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m26134n() {
        if (!this.f34202o && this.f34200m == null && this.f34199l == null) {
            String string = getString(R.string.cs_boleto_scan_failed_tips_dialog_content);
            String string2 = getString(R.string.cs_boleto_scan_failed_tips_dialog_pos);
            String string3 = getString(R.string.cs_boleto_scan_failed_tips_dialog_neg);
            GGKDialogModel1 gGKDialogModel1 = new GGKDialogModel1(string, new GGKBtnTextAndCallback(string2, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m26122f("ibt_didipay_pay_boleto_scan_timeout_retry_again_ck");
                    CsScanActivity.this.m26136p();
                }
            }));
            gGKDialogModel1.addMinorBtn(new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    CsScanActivity.this.m26122f("ibt_didipay_pay_boleto_scan_timeout_retry_drop_ck");
                    CsScanActivity.this.m26136p();
                    CsScanActivity.this.m26132l();
                }
            }));
            m26122f("ibt_didipay_pay_boleto_scan_timeout_retry_fail_sw");
            this.f34199l = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel1, "tips_dialog");
        }
    }

    /* renamed from: o */
    private void m26135o() {
        WalletToastNew.showFailedMsg(this, getString(R.string.Fintech_Payment_SKUs_whOr_ahTv));
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m26136p() {
        GGKDialogFragment gGKDialogFragment = this.f34199l;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
            this.f34199l = null;
        }
    }

    /* renamed from: a */
    private void m26104a(final Runnable runnable) {
        if (this.f34189b.hasCollectedData()) {
            String string = getString(R.string.cs_boleto_scan_upload_dialog_content);
            String string2 = getString(R.string.cs_boleto_scan_upload_dialog_btn_yes);
            String string3 = getString(R.string.cs_boleto_scan_upload_dialog_btn_no);
            GGKDialogModel2 gGKDialogModel2 = new GGKDialogModel2(string, new GGKBtnTextAndCallback(string2, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_yes_ck");
                    CsScanActivity.this.m26105a(runnable, true);
                }
            }));
            gGKDialogModel2.addMinorBtn(new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_no_ck");
                    CsScanActivity.this.m26105a(runnable, false);
                }
            }));
            this.f34200m = GGKUICreatorWithThemeCheck.showDialogModel(this, gGKDialogModel2, "collection_dialog");
            PayTracker.trackEvent("ibt_boleto_scan_upload_auth_dialog_sw");
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26105a(Runnable runnable, boolean z) {
        this.f34189b.dumpCollectedData(z);
        if (runnable != null) {
            runnable.run();
        }
        GGKDialogFragment gGKDialogFragment = this.f34200m;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
            this.f34200m = null;
        }
    }

    /* renamed from: d */
    private void m26118d(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f34193f;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        PayTracker.trackEvent(str, hashMap);
    }

    /* renamed from: e */
    private void m26121e(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f34193f;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        hashMap.put("barcode_format", str);
        PayTracker.trackEvent("ibt_boleto_scan_result_valid_sw", hashMap);
    }

    /* renamed from: a */
    private void m26107a(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f34193f;
        HashMap hashMap = new HashMap();
        hashMap.put("interval", Long.valueOf(currentTimeMillis));
        if (StringUtils.isEmpty(str)) {
            str = "";
        }
        hashMap.put("content", str);
        hashMap.put("barcode_format", str2);
        PayTracker.trackEvent("ibt_boleto_scan_result_not_valid_sw", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m26122f(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("flashlight_status", this.f34191d.isSelected() ? "flashlight_on" : "flashlight_off");
        PayTracker.trackEvent(str, hashMap);
    }

    /* renamed from: q */
    private boolean m26137q() {
        return getIntent().getIntExtra("isFromDa", -1) == 1;
    }

    /* renamed from: r */
    private int m26138r() {
        return getIntent().getIntExtra("minLength", -1);
    }

    /* renamed from: s */
    private int m26139s() {
        return getIntent().getIntExtra("maxLength", -1);
    }

    /* renamed from: t */
    private boolean m26140t() {
        return getIntent().getIntExtra("showGuide", -1) == 1;
    }
}
