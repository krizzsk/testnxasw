package com.didi.payment.creditcard.global.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.home.MapEventKey;
import com.didi.payment.base.event.home.MapEventManager;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.web.WebSignParam;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.CardBinRuleFactory;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.contract.CreditCardAddContract;
import com.didi.payment.creditcard.global.error.ISignErrorHandler;
import com.didi.payment.creditcard.global.error.SignErrorFactory;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.model.bean.OCRVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.SignResult;
import com.didi.payment.creditcard.global.ocr.OcrDialogUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaErrorCounter;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p131v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.presenter.GlobalAddAccountPresenter;
import com.didi.payment.creditcard.global.utils.CheckViewHelperOpt;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.creditcard.global.utils.WatchViewHelperOpt;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardTypeSelectOptView;
import com.didi.payment.creditcard.global.widget.CheckTipDialogFragment;
import com.didi.payment.creditcard.global.widget.CreditCardErrorDialog;
import com.didi.payment.creditcard.global.widget.NoDoubleClickListener;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.pay.sign.util.SignConstant;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didichuxing.gbankcard.ocr.IScanCardCallback;
import com.didichuxing.gbankcard.ocr.ScanCardHelper;
import com.didichuxing.gbankcard.ocr.ScanCardParam;
import com.didichuxing.gbankcard.ocr.ScanCardResult;
import com.didiglobal.pay.paysecure.tmx.ITMXHost;
import com.taxis99.R;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import java.util.HashMap;

public class GlobalCreditCardAddOptActivity extends GlobalBaseActivity implements CreditCardAddContract.IView, CardEditText.OnPasteListener, ITMXHost {
    public static final String RESP_EXTRA_CARD_INDEX = "card_index";

    /* renamed from: a */
    private static final String f32763a = "2.0";

    /* renamed from: b */
    private static final String f32764b = "SIGN_PARAM";

    /* renamed from: c */
    private static final int f32765c = 603;

    /* renamed from: d */
    private static final int f32766d = 604;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f32767A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public String f32768B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public CheckTipDialogFragment f32769C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public ScanCardResult f32770D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public int f32771E;

    /* renamed from: F */
    private ISignErrorHandler f32772F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public long f32773G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public long f32774H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public boolean f32775I;

    /* renamed from: J */
    private FinExtAttrBiz f32776J = new FinExtAttrBiz();
    /* access modifiers changed from: private */

    /* renamed from: K */
    public String f32777K = "0";

    /* renamed from: L */
    private ISignErrorHandler.Callback f32778L = new ISignErrorHandler.Callback() {
        public void onResult(int i, SignResult signResult) {
            if (i == 1) {
                GlobalCreditCardAddOptActivity.this.m24916j();
            } else if (i == 2) {
                GlobalCreditCardAddOptActivity.this.m24914i();
            } else if (i == 4) {
                GlobalCreditCardAddOptActivity.this.m24893a(signResult);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: M */
    public CheckTipDialogFragment.DialogCallback f32779M = new CheckTipDialogFragment.DialogCallback() {
        private EditText mReOpenSoftEditText;

        public void beforeShow() {
            if (GlobalCreditCardAddOptActivity.this.f32791p.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f32791p;
            } else if (GlobalCreditCardAddOptActivity.this.f32790o.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f32790o;
            } else if (GlobalCreditCardAddOptActivity.this.f32789n.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptActivity.this.f32789n;
            } else {
                this.mReOpenSoftEditText = null;
            }
        }

        public void afterDismiss() {
            EditText editText = this.mReOpenSoftEditText;
            if (editText != null) {
                InputTools.showKeyboard(editText);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SignCardParam f32780e;

    /* renamed from: f */
    private TextView f32781f;

    /* renamed from: g */
    private TextView f32782g;

    /* renamed from: h */
    private TextView f32783h;

    /* renamed from: i */
    private TextView f32784i;

    /* renamed from: j */
    private ImageView f32785j;

    /* renamed from: k */
    private ImageView f32786k;

    /* renamed from: l */
    private ImageView f32787l;

    /* renamed from: m */
    private ImageView f32788m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CardEditText f32789n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public CardEditText f32790o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CardEditText f32791p;

    /* renamed from: q */
    private TextView f32792q;

    /* renamed from: r */
    private CardTypeSelectOptView f32793r;

    /* renamed from: s */
    private FrameLayout f32794s;

    /* renamed from: t */
    private TextView f32795t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public CreditCardAddContract.IPresenter f32796u;

    /* renamed from: v */
    private ICardBinRule f32797v;

    /* renamed from: w */
    private boolean f32798w;

    /* renamed from: x */
    private String f32799x;

    /* renamed from: y */
    private CheckViewHelperOpt f32800y;

    /* renamed from: z */
    private WatchViewHelperOpt f32801z;

    public void onSignSuccess(String str, String str2) {
    }

    public static void launch(Activity activity, int i, SignCardParam signCardParam) {
        if (activity != null) {
            activity.startActivityForResult(getIntent(activity, signCardParam), i);
        }
    }

    public static void launch(Fragment fragment, int i, SignCardParam signCardParam) {
        if (fragment != null && fragment.getActivity() != null) {
            fragment.startActivityForResult(getIntent(fragment.getActivity(), signCardParam), i);
        }
    }

    public static Intent getIntent(Activity activity, SignCardParam signCardParam) {
        Intent intent = new Intent(activity, GlobalCreditCardAddOptActivity.class);
        intent.putExtra(f32764b, signCardParam);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_add_opt);
        m24887a();
        m24896b();
    }

    /* renamed from: a */
    private void m24887a() {
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        Intent intent = getIntent();
        if (intent != null) {
            this.f32780e = (SignCardParam) intent.getSerializableExtra(f32764b);
        }
        SignCardParam signCardParam = this.f32780e;
        if (signCardParam == null) {
            traceVendor("", "", "show");
            this.f32780e = new SignCardParam();
        } else {
            traceVendor(signCardParam.resourceId, this.f32780e.vendorType, "show");
        }
        if (TextUtils.isEmpty(this.f32780e.resourceId)) {
            this.f32780e.resourceId = "1";
        }
        this.f32775I = this.f32780e.isUpdateCard();
        this.f32797v = CardBinRuleFactory.createCardBinRule(this, this.f32780e.apolloName);
        GlobalAddAccountPresenter globalAddAccountPresenter = new GlobalAddAccountPresenter(this, f32763a, TextUtils.isEmpty(this.f32780e.discountContent) ^ true ? 1 : 0);
        this.f32796u = globalAddAccountPresenter;
        globalAddAccountPresenter.requestPublicKey(this.f32780e);
        ISignErrorHandler createErrorHandler = SignErrorFactory.createErrorHandler(this, this.f32780e);
        this.f32772F = createErrorHandler;
        createErrorHandler.setCallback(this.f32778L);
        this.f32776J.updateExtAttrs2FinGlobalAttrs(this.f32780e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_INIT);
        SignCardParam signCardParam2 = this.f32780e;
        if (signCardParam2 != null) {
            int i2 = signCardParam2.bindType;
            String str4 = this.f32780e.resourceId;
            String str5 = this.f32780e.appId;
            z = !TextUtils.isEmpty(this.f32780e.discountContent);
            i = i2;
            str3 = str4;
            str2 = str5;
            str = this.f32780e.productId;
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
            i = 0;
            z = false;
        }
        GlobalOmegaUtils.trackAddCardPageSW(this, i, f32763a, str3, z ? 1 : 0, str2, str);
        GlobalOmegaErrorCounter.resetValue();
    }

    /* renamed from: b */
    private void m24896b() {
        int i = this.f32775I ? R.string.one_payment_creditcard_global_update_card : R.string.one_payment_creditcard_global_title;
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.layout_title_bar);
        commonTitleBar.setTitle(i);
        commonTitleBar.setRightVisible(4);
        int i2 = 8;
        commonTitleBar.setTitleBarLineVisible(8);
        commonTitleBar.setVisibility(0);
        commonTitleBar.setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.onBackPressed();
            }
        });
        this.f32781f = (TextView) findViewById(R.id.tv_card_no_title);
        this.f32782g = (TextView) findViewById(R.id.tv_date_title);
        this.f32783h = (TextView) findViewById(R.id.tv_cvv_title);
        this.f32784i = (TextView) findViewById(R.id.tv_notice_msg);
        this.f32785j = (ImageView) findViewById(R.id.iv_card_icon);
        this.f32786k = (ImageView) findViewById(R.id.iv_camera_icon);
        this.f32787l = (ImageView) findViewById(R.id.iv_date_tip);
        this.f32788m = (ImageView) findViewById(R.id.iv_cvv_tip);
        this.f32793r = (CardTypeSelectOptView) findViewById(R.id.sv_card_type_select);
        this.f32794s = (FrameLayout) findViewById(R.id.fl_discount);
        this.f32795t = (TextView) findViewById(R.id.tv_discount_content);
        CardEditText cardEditText = (CardEditText) findViewById(R.id.et_card);
        this.f32789n = cardEditText;
        cardEditText.setType(CardEditText.TYPE.CARD_NUMBER);
        this.f32789n.setMaxLength(23);
        this.f32789n.setOnPasteListener(this);
        String c = m24901c();
        if (!TextUtil.isEmpty(c)) {
            this.f32789n.setHint(c);
        }
        CardEditText cardEditText2 = (CardEditText) findViewById(R.id.et_date);
        this.f32790o = cardEditText2;
        cardEditText2.setMaxLength(5);
        this.f32790o.setType(CardEditText.TYPE.DATE);
        CardEditText cardEditText3 = (CardEditText) findViewById(R.id.et_cvv);
        this.f32791p = cardEditText3;
        cardEditText3.setType(CardEditText.TYPE.CVV);
        this.f32791p.setMaxLength(4);
        int i3 = this.f32775I ? R.string.one_payment_creditcard_global_update : R.string.one_payment_creditcard_global_btn_confirm;
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f32792q = textView;
        textView.setText(i3);
        this.f32792q.setEnabled(false);
        this.f32792q.setOnClickListener(new DoubleCheckOnClickListener(800) {
            public void doClick(View view) {
                GlobalCreditCardAddOptActivity.this.m24903d();
                GlobalCreditCardAddOptActivity globalCreditCardAddOptActivity = GlobalCreditCardAddOptActivity.this;
                globalCreditCardAddOptActivity.m24888a(globalCreditCardAddOptActivity.f32775I ? 2 : 1);
            }
        });
        this.f32786k.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptActivity.this.m24897b(603);
                GlobalOmegaUtils.trackOcrPageOcrCk(GlobalCreditCardAddOptActivity.this);
                int unused = GlobalCreditCardAddOptActivity.this.f32771E = 1;
            }
        });
        this.f32769C = new CheckTipDialogFragment(this);
        this.f32787l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.f32769C.show(3, GlobalCreditCardAddOptActivity.this.f32779M);
            }
        });
        final String string = getResources().getString(R.string.one_payment_creditcard_code_hint_cid);
        this.f32788m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String trim = GlobalCreditCardAddOptActivity.this.f32791p.getHint().toString().trim();
                if (string.equals(trim) || trim.length() > 3) {
                    GlobalCreditCardAddOptActivity.this.f32769C.show(2, GlobalCreditCardAddOptActivity.this.f32779M);
                } else {
                    GlobalCreditCardAddOptActivity.this.f32769C.show(1, GlobalCreditCardAddOptActivity.this.f32779M);
                }
            }
        });
        boolean z = this.f32780e.isSupportOcr && ScanCardHelper.supportScan(this);
        ImageView imageView = this.f32786k;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        if (!TextUtils.isEmpty(this.f32780e.noticeMsg)) {
            this.f32784i.setText(this.f32780e.noticeMsg);
        } else {
            this.f32784i.setText(R.string.one_payment_creditcard_global_notice_msg);
        }
        CheckViewHelperOpt checkViewHelperOpt = new CheckViewHelperOpt(this, this.f32797v, new BlackCardRule(this, this.f32780e.blackCardApolloName));
        this.f32800y = checkViewHelperOpt;
        WatchViewHelperOpt watchViewHelperOpt = new WatchViewHelperOpt(this.f32797v, checkViewHelperOpt);
        this.f32801z = watchViewHelperOpt;
        watchViewHelperOpt.initView(this.f32789n, this.f32790o, this.f32791p, this.f32781f, this.f32782g, this.f32783h, this.f32785j, this.f32793r, this.f32792q);
        this.f32801z.watch();
        InputTools.showKeyboard(this.f32789n);
        m24894a(this.f32780e.discountContent);
    }

    /* renamed from: c */
    private String m24901c() {
        String str = this.f32780e.cardNo;
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return null;
        }
        return String.format("···· ···· ···· %s", new Object[]{str.substring(str.length() - 4)});
    }

    /* renamed from: a */
    private void m24894a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f32794s.setVisibility(0);
            this.f32795t.setText(str);
            CreditCardOmegaUtil.Companion.bindCardPasUpShowTrace(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            this.f32799x = intent.getStringExtra(SignConstant.KEY_ADYEN_ERROR_MSG);
        }
        this.f32796u.pollSignResult();
    }

    public Context getContext() {
        return super.getContext();
    }

    public void showLoadingDialog(String str) {
        super.showLoadingDialog(str);
    }

    public void dismissLoadingDialog() {
        super.dismissLoadingDialog();
    }

    public void openCreditCardSignPage(String str, String str2, String str3) {
        WebSignParam webSignParam = new WebSignParam();
        webSignParam.activity = this;
        webSignParam.title = getString(R.string.one_payment_creditcard_pagetitle);
        webSignParam.url = str;
        webSignParam.postData = str2;
        webSignParam.backUrl = str3;
        webSignParam.requestCode = 1;
        WebBrowserUtil.startCreditCardWebActivity(webSignParam);
    }

    public String getSignH5ErrMsg() {
        return this.f32799x;
    }

    public void onSignSuccess(String str) {
        Intent intent = new Intent();
        intent.putExtra("card_index", str);
        setResult(-1, intent);
        MapEventManager.INSTANCE.postWalletEvent(MapEventKey.WALLET_HOME_BANK);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f32776J.updateExtAttrs2FinGlobalAttrs(this.f32780e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CreditCardAddContract.IPresenter iPresenter = this.f32796u;
        if (iPresenter != null) {
            iPresenter.onDestory();
        }
        super.onDestroy();
    }

    public void showOcrConfirmDialog() {
        OcrDialogUtil.showOrcConfirmDialog(this, new OcrDialogUtil.Callback() {
            public void onCancel() {
            }

            public void onOk() {
                GlobalCreditCardAddOptActivity.this.m24897b(604);
            }
        });
    }

    public void onOcrVerifyFailure(OCRVerifyInfo oCRVerifyInfo) {
        ScanCardHelper.onOcrVerifyDone(false);
    }

    public void onOcrVerifySuccess() {
        int i = 1;
        ScanCardHelper.onOcrVerifyDone(true);
        if (this.f32775I) {
            i = 2;
        }
        m24888a(i);
    }

    public void showSignFailureGuideDialog(String str, String str2, String str3, String str4) {
        GlobalOmegaUtils.trackAddCardNetErrorPopupSW(this);
        GlobalDialogUtil.showAddCardFailureGuideDialog(this, str, str2, str3, str4, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorBackBtnCK(GlobalCreditCardAddOptActivity.this);
                if (ConfigProxyHolder.getGlobalPageRouterProxy() != null) {
                    ConfigProxyHolder.getGlobalPageRouterProxy().toHomeActivity(GlobalCreditCardAddOptActivity.this, true);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.didi.home");
                    intent.setPackage("com.didiglobal.passenger");
                    intent.setFlags(603979776);
                    GlobalCreditCardAddOptActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorWaitBtnCK(GlobalCreditCardAddOptActivity.this);
            }
        });
    }

    public void showBindFailureDialog(SignResult signResult) {
        CreditCardErrorDialog.Companion.showBindFailureDialog(this, signResult);
    }

    public void showCardUpdateConfirmDialog() {
        GlobalDialogUtil.showCardUpdateDialog(this, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptActivity.this.m24888a(2);
            }
        }, (View.OnClickListener) null);
    }

    public void onCybs3DSSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        m24889a(this.f32775I ? 2 : 1, threedsCybsDataResponse);
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public void finish() {
        super.finish();
        GlobalOmegaErrorCounter.onSignErrorEvent(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24888a(int i) {
        m24889a(i, (ThreedsCybsDataResponse) null);
    }

    /* renamed from: a */
    private void m24889a(int i, ThreedsCybsDataResponse threedsCybsDataResponse) {
        String textWithoutSpace = this.f32789n.getTextWithoutSpace();
        String textWithoutSpace2 = this.f32790o.getTextWithoutSpace();
        String textWithoutSpace3 = this.f32791p.getTextWithoutSpace();
        ICardBinRule createCardBinRule = CardBinRuleFactory.createCardBinRule(getContext(), this.f32780e.apolloName);
        int cardOrg = createCardBinRule.getCardOrg(textWithoutSpace);
        int cardType = this.f32793r.getCardType();
        int cardType2 = cardType == 0 ? createCardBinRule.getCardType(textWithoutSpace) : cardType;
        CreditCardAddContract.IPresenter iPresenter = this.f32796u;
        boolean z = this.f32767A;
        String str = this.f32768B;
        SignCardParam signCardParam = this.f32780e;
        iPresenter.commit(i, textWithoutSpace, textWithoutSpace2, textWithoutSpace3, cardType2, cardOrg, z, str, signCardParam, signCardParam.resourceId, threedsCybsDataResponse, this.f32777K);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m24897b(int i) {
        this.f32774H = System.currentTimeMillis();
        this.f32773G = 0;
        String textWithoutSpace = this.f32789n.getTextWithoutSpace();
        final String textWithoutSpace2 = this.f32790o.getTextWithoutSpace();
        final String textWithoutSpace3 = this.f32791p.getTextWithoutSpace();
        final int cardType = this.f32793r.getCardType();
        if (cardType == 0) {
            cardType = this.f32797v.getCardType(textWithoutSpace);
        }
        String f = m24908f();
        ScanCardParam.Builder builder = new ScanCardParam.Builder(i == 603 ? 0 : 1, PayBaseParamUtil.getStringParam(this, "uid"));
        builder.countryCode(PayBaseParamUtil.getStringParam(this, "country"));
        builder.cardBin(f);
        ScanCardHelper.scan(this, builder.build(), new IScanCardCallback() {
            public void onScanResult(ScanCardResult scanCardResult) {
                long unused = GlobalCreditCardAddOptActivity.this.f32773G = System.currentTimeMillis() - GlobalCreditCardAddOptActivity.this.f32774H;
                if (scanCardResult.code == 0) {
                    ScanCardResult unused2 = GlobalCreditCardAddOptActivity.this.f32770D = scanCardResult;
                    boolean unused3 = GlobalCreditCardAddOptActivity.this.f32767A = true;
                    String unused4 = GlobalCreditCardAddOptActivity.this.f32768B = scanCardResult.cardNum;
                    int i = scanCardResult.type;
                    if (i == 0) {
                        GlobalCreditCardAddOptActivity.this.f32789n.setText(GlobalCreditCardAddOptActivity.this.f32768B);
                        GlobalCreditCardAddOptActivity.this.f32789n.setSelection(GlobalCreditCardAddOptActivity.this.f32789n.length());
                    } else if (i == 1) {
                        GlobalCreditCardAddOptActivity.this.f32796u.ocrVerify(GlobalCreditCardAddOptActivity.this.f32768B, textWithoutSpace2, textWithoutSpace3, cardType, GlobalCreditCardAddOptActivity.this.f32767A, GlobalCreditCardAddOptActivity.this.f32768B, GlobalCreditCardAddOptActivity.this.f32789n.getTextWithoutSpace(), GlobalCreditCardAddOptActivity.this.f32780e, GlobalCreditCardAddOptActivity.this.f32777K);
                    }
                } else {
                    SystemUtils.log(3, "CardAdd", "start error: code " + scanCardResult.code, (Throwable) null, "com.didi.payment.creditcard.global.activity.GlobalCreditCardAddOptActivity$11", 633);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m24903d() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f32771E));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_STATUS, Integer.valueOf(m24905e()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT, m24908f());
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_SESSION, Long.valueOf(this.f32773G));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.SAME_CHECK, Integer.valueOf(m24909g()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.USER_OCR_RESULT, m24912h());
        GlobalOmegaUtils.trackOcrOperation(this, this.f32780e.bindType, hashMap);
    }

    /* renamed from: e */
    private int m24905e() {
        ScanCardResult scanCardResult = this.f32770D;
        if (scanCardResult == null) {
            return 0;
        }
        int i = scanCardResult.code;
        if (i == 0) {
            return 2;
        }
        switch (i) {
            case 103:
            case 104:
            case 106:
                return 1;
            case 105:
                return 4;
            default:
                return 3;
        }
    }

    /* renamed from: f */
    private String m24908f() {
        String textString = this.f32789n.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        if (textString == null || textString.length() < 6) {
            return "";
        }
        return textString.substring(0, 6);
    }

    /* renamed from: g */
    private int m24909g() {
        String textString = this.f32789n.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        return TextUtils.equals(textString, this.f32768B) ? 1 : 0;
    }

    /* renamed from: h */
    private String m24912h() {
        String str = this.f32768B;
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return "";
        }
        String replace = str.replace(" ", "");
        String substring = replace.substring(0, 6);
        String substring2 = replace.substring(replace.length() - 4);
        return substring + substring2;
    }

    public void onSignFail(SignResult signResult) {
        ISignErrorHandler iSignErrorHandler = this.f32772F;
        if (iSignErrorHandler != null) {
            iSignErrorHandler.handleError(signResult);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m24914i() {
        this.f32789n.setText("");
        this.f32791p.setText("");
        this.f32790o.setText("");
        this.f32789n.requestFocus();
        InputTools.showKeyboard(this.f32789n);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m24916j() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24893a(SignResult signResult) {
        if (signResult != null && !TextUtils.isEmpty(signResult.faqURL)) {
            WebBrowserUtil.startInternalWebActivity(this, signResult.faqURL, "");
        }
    }

    public void onPaste() {
        this.f32777K = "1";
    }
}
