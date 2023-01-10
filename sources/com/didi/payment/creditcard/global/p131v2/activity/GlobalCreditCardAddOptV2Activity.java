package com.didi.payment.creditcard.global.p131v2.activity;

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
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.payment.base.tracker.FinExtAttrBiz;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.base.web.WebSignParam;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.commonsdk.p130ui.helper.NLEGODialogBuilder;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.CardBinRuleFactory;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.activity.GlobalBaseActivity;
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
import com.didi.payment.creditcard.global.p131v2.utils.CheckViewHelperOptV2;
import com.didi.payment.creditcard.global.p131v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.presenter.GlobalAddAccountPresenter;
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
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.payment.creditcard.global.v2.activity.GlobalCreditCardAddOptV2Activity */
public class GlobalCreditCardAddOptV2Activity extends GlobalBaseActivity implements CreditCardAddContract.IView, CardEditText.OnPasteListener, ITMXHost {
    public static final String RESP_EXTRA_CARD_INDEX = "card_index";

    /* renamed from: a */
    private static final String f32980a = "2.0";

    /* renamed from: b */
    private static final String f32981b = "SIGN_PARAM";

    /* renamed from: c */
    private static final int f32982c = 603;

    /* renamed from: d */
    private static final int f32983d = 604;

    /* renamed from: A */
    private CheckViewHelperOptV2 f32984A;

    /* renamed from: B */
    private WatchViewHelperOpt f32985B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public boolean f32986C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public String f32987D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public CheckTipDialogFragment f32988E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ScanCardResult f32989F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public int f32990G;

    /* renamed from: H */
    private ISignErrorHandler f32991H;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public long f32992I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public long f32993J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public boolean f32994K;
    /* access modifiers changed from: private */

    /* renamed from: L */
    public LEGODrawer f32995L;

    /* renamed from: M */
    private FinExtAttrBiz f32996M = new FinExtAttrBiz();
    /* access modifiers changed from: private */

    /* renamed from: N */
    public String f32997N = "0";

    /* renamed from: O */
    private ISignErrorHandler.Callback f32998O = new ISignErrorHandler.Callback() {
        public void onResult(int i, SignResult signResult) {
            if (i == 1) {
                GlobalCreditCardAddOptV2Activity.this.m25111k();
            } else if (i == 2) {
                GlobalCreditCardAddOptV2Activity.this.m25109j();
            } else if (i == 4) {
                GlobalCreditCardAddOptV2Activity.this.m25080a(signResult);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: P */
    public CheckTipDialogFragment.DialogCallback f32999P = new CheckTipDialogFragment.DialogCallback() {
        private EditText mReOpenSoftEditText;

        public void beforeShow() {
            if (GlobalCreditCardAddOptV2Activity.this.f33013r.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f33013r;
            } else if (GlobalCreditCardAddOptV2Activity.this.f33012q.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f33012q;
            } else if (GlobalCreditCardAddOptV2Activity.this.f33011p.isFocused()) {
                this.mReOpenSoftEditText = GlobalCreditCardAddOptV2Activity.this.f33011p;
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
    public SignCardParam f33000e;

    /* renamed from: f */
    private TextView f33001f;

    /* renamed from: g */
    private TextView f33002g;

    /* renamed from: h */
    private TextView f33003h;

    /* renamed from: i */
    private TextView f33004i;

    /* renamed from: j */
    private ImageView f33005j;

    /* renamed from: k */
    private ImageView f33006k;

    /* renamed from: l */
    private ImageView f33007l;

    /* renamed from: m */
    private ImageView f33008m;

    /* renamed from: n */
    private ImageView f33009n;

    /* renamed from: o */
    private ImageView f33010o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CardEditText f33011p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CardEditText f33012q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public CardEditText f33013r;
    public String retainTips;

    /* renamed from: s */
    private TextView f33014s;
    public String successTips;
    public String successUrl;

    /* renamed from: t */
    private CardTypeSelectOptView f33015t;

    /* renamed from: u */
    private FrameLayout f33016u;

    /* renamed from: v */
    private TextView f33017v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public CreditCardAddContract.IPresenter f33018w;

    /* renamed from: x */
    private ICardBinRule f33019x;

    /* renamed from: y */
    private boolean f33020y;

    /* renamed from: z */
    private String f33021z;

    public void onSignSuccess(String str) {
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
        Intent intent = new Intent(activity, GlobalCreditCardAddOptV2Activity.class);
        intent.putExtra(f32981b, signCardParam);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_creditcard_global_activity_add_opt_v2);
        m25077a();
        m25086b();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: a */
    private void m25077a() {
        String str;
        String str2;
        boolean z;
        String str3;
        int i;
        Intent intent = getIntent();
        if (intent != null) {
            this.f33000e = (SignCardParam) intent.getSerializableExtra(f32981b);
        }
        SignCardParam signCardParam = this.f33000e;
        if (signCardParam == null) {
            traceVendor("", "", "show");
            this.f33000e = new SignCardParam();
        } else {
            traceVendor(signCardParam.resourceId, this.f33000e.vendorType, "show");
        }
        if (TextUtils.isEmpty(this.f33000e.resourceId)) {
            this.f33000e.resourceId = "1";
        }
        this.f32994K = this.f33000e.isUpdateCard();
        this.f33019x = CardBinRuleFactory.createCardBinRule(this, this.f33000e.apolloName);
        GlobalAddAccountPresenter globalAddAccountPresenter = new GlobalAddAccountPresenter(this, f32980a, TextUtils.isEmpty(this.f33000e.discountContent) ^ true ? 1 : 0);
        this.f33018w = globalAddAccountPresenter;
        globalAddAccountPresenter.requestPublicKey(this.f33000e);
        ISignErrorHandler createErrorHandler = SignErrorFactory.createErrorHandler(this, this.f33000e);
        this.f32991H = createErrorHandler;
        createErrorHandler.setCallback(this.f32998O);
        this.f32996M.updateExtAttrs2FinGlobalAttrs(this.f33000e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_V2_INIT);
        SignCardParam signCardParam2 = this.f33000e;
        if (signCardParam2 != null) {
            int i2 = signCardParam2.bindType;
            String str4 = this.f33000e.resourceId;
            String str5 = this.f33000e.appId;
            z = !TextUtils.isEmpty(this.f33000e.discountContent);
            i = i2;
            str3 = str4;
            str2 = str5;
            str = this.f33000e.productId;
        } else {
            str3 = "";
            str2 = str3;
            str = str2;
            i = 0;
            z = false;
        }
        GlobalOmegaUtils.trackAddCardPageSW(this, i, f32980a, str3, z ? 1 : 0, str2, str);
        GlobalOmegaErrorCounter.resetValue();
        this.successTips = this.f33000e.successTips;
        this.successUrl = this.f33000e.successUrl;
        this.retainTips = this.f33000e.retainTips;
    }

    /* renamed from: b */
    private void m25086b() {
        int i = this.f32994K ? R.string.one_payment_creditcard_global_update_card : R.string.one_payment_creditcard_global_title;
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.layout_title_bar);
        commonTitleBar.setTitle(i);
        int i2 = 4;
        commonTitleBar.setRightVisible(4);
        commonTitleBar.setTitleBarLineVisible(8);
        commonTitleBar.setVisibility(0);
        commonTitleBar.setLeftImage((int) R.drawable.common_title_bar_btn_back_selector, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptV2Activity.this.onBackPressed();
            }
        });
        this.f33001f = (TextView) findViewById(R.id.tv_card_no_title_error);
        this.f33002g = (TextView) findViewById(R.id.tv_date_title_error);
        this.f33003h = (TextView) findViewById(R.id.tv_cvv_title_error);
        this.f33004i = (TextView) findViewById(R.id.tv_notice_msg);
        this.f33005j = (ImageView) findViewById(R.id.iv_card_icon);
        this.f33006k = (ImageView) findViewById(R.id.iv_camera_icon);
        this.f33007l = (ImageView) findViewById(R.id.iv_clear_icon);
        this.f33008m = (ImageView) findViewById(R.id.iv_date_tip);
        this.f33009n = (ImageView) findViewById(R.id.iv_cvv_tip);
        this.f33015t = (CardTypeSelectOptView) findViewById(R.id.sv_card_type_select);
        this.f33016u = (FrameLayout) findViewById(R.id.fl_discount);
        this.f33017v = (TextView) findViewById(R.id.tv_discount_content);
        this.f33010o = (ImageView) findViewById(R.id.iv_creditcardLogo);
        CardEditText cardEditText = (CardEditText) findViewById(R.id.et_card);
        this.f33011p = cardEditText;
        cardEditText.setType(CardEditText.TYPE.CARD_NUMBER);
        this.f33011p.setMaxLength(23);
        this.f33011p.setOnPasteListener(this);
        String d = m25096d();
        if (!TextUtil.isEmpty(d)) {
            this.f33011p.setHint(d);
        }
        CardEditText cardEditText2 = (CardEditText) findViewById(R.id.et_date);
        this.f33012q = cardEditText2;
        cardEditText2.setMaxLength(5);
        this.f33012q.setType(CardEditText.TYPE.DATE);
        CardEditText cardEditText3 = (CardEditText) findViewById(R.id.et_cvv);
        this.f33013r = cardEditText3;
        cardEditText3.setType(CardEditText.TYPE.CVV);
        this.f33013r.setMaxLength(4);
        int i3 = this.f32994K ? R.string.one_payment_creditcard_global_update : R.string.one_payment_creditcard_global_btn_confirm;
        TextView textView = (TextView) findViewById(R.id.btn_commit);
        this.f33014s = textView;
        textView.setText(i3);
        this.f33014s.setEnabled(false);
        this.f33014s.setOnClickListener(new DoubleCheckOnClickListener(800) {
            public void doClick(View view) {
                GlobalCreditCardAddOptV2Activity.this.m25099e();
                GlobalCreditCardAddOptV2Activity globalCreditCardAddOptV2Activity = GlobalCreditCardAddOptV2Activity.this;
                globalCreditCardAddOptV2Activity.m25078a(globalCreditCardAddOptV2Activity.f32994K ? 2 : 1);
            }
        });
        this.f33006k.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptV2Activity.this.m25087b(603);
                GlobalOmegaUtils.trackOcrPageOcrCk(GlobalCreditCardAddOptV2Activity.this);
                int unused = GlobalCreditCardAddOptV2Activity.this.f32990G = 1;
            }
        });
        this.f33007l.setOnClickListener(new NoDoubleClickListener() {
            public void onNoDoubleClick(View view) {
                GlobalCreditCardAddOptV2Activity.this.f33011p.setText("");
            }
        });
        this.f32988E = new CheckTipDialogFragment(this);
        this.f33008m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalCreditCardAddOptV2Activity.this.f32988E.show(3, GlobalCreditCardAddOptV2Activity.this.f32999P);
            }
        });
        final String string = getResources().getString(R.string.one_payment_creditcard_code_hint_cid);
        this.f33009n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String trim = GlobalCreditCardAddOptV2Activity.this.f33013r.getHint().toString().trim();
                if (string.equals(trim) || trim.length() > 3) {
                    GlobalCreditCardAddOptV2Activity.this.f32988E.show(2, GlobalCreditCardAddOptV2Activity.this.f32999P);
                } else {
                    GlobalCreditCardAddOptV2Activity.this.f32988E.show(1, GlobalCreditCardAddOptV2Activity.this.f32999P);
                }
            }
        });
        boolean z = this.f33000e.isSupportOcr && ScanCardHelper.supportScan(this);
        ImageView imageView = this.f33006k;
        if (z) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        if (!TextUtils.isEmpty(this.f33000e.noticeMsg)) {
            this.f33004i.setText(this.f33000e.noticeMsg);
        } else {
            this.f33004i.setText(R.string.one_payment_creditcard_global_notice_msg);
        }
        CheckViewHelperOptV2 checkViewHelperOptV2 = new CheckViewHelperOptV2(this, this.f33019x, new BlackCardRule(this, this.f33000e.blackCardApolloName));
        this.f32984A = checkViewHelperOptV2;
        WatchViewHelperOpt watchViewHelperOpt = new WatchViewHelperOpt(this.f33019x, checkViewHelperOptV2);
        this.f32985B = watchViewHelperOpt;
        watchViewHelperOpt.initView(this.f33011p, this.f33012q, this.f33013r, this.f33001f, this.f33002g, this.f33003h, this.f33005j, this.f33015t, this.f33014s);
        this.f32985B.watch();
        InputTools.showKeyboard(this.f33011p);
        m25084a(this.f33000e.discountContent);
        m25093c();
    }

    /* renamed from: c */
    private void m25093c() {
        SignCardParam signCardParam = this.f33000e;
        if (signCardParam != null && signCardParam.didi_icon != null && !this.f33000e.didi_icon.isEmpty()) {
            GlideUtils.with2load2into(this, this.f33000e.didi_icon, this.f33010o);
        }
    }

    /* renamed from: d */
    private String m25096d() {
        String str = this.f33000e.cardNo;
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            return null;
        }
        return String.format("···· ···· ···· %s", new Object[]{str.substring(str.length() - 4)});
    }

    /* renamed from: a */
    private void m25084a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f33016u.setVisibility(0);
            this.f33017v.setText(str);
            CreditCardOmegaUtil.Companion.bindCardPasUpShowTrace(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            this.f33021z = intent.getStringExtra(SignConstant.KEY_ADYEN_ERROR_MSG);
        }
        this.f33018w.pollSignResult();
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
        return this.f33021z;
    }

    public void onSignSuccess(String str, String str2) {
        if (!TextUtils.isEmpty(this.successTips)) {
            m25095c(str);
            return;
        }
        showToastCompleted(str2);
        m25091b(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25091b(String str) {
        Intent intent = new Intent();
        intent.putExtra("card_index", str);
        setResult(-1, intent);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f32996M.updateExtAttrs2FinGlobalAttrs(this.f33000e.extOmegaAttrs, FinExtAttrBiz.FROM_ADD_CARD_V2_RESUME);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        CreditCardAddContract.IPresenter iPresenter = this.f33018w;
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
                GlobalCreditCardAddOptV2Activity.this.m25087b(604);
            }
        });
    }

    public void onOcrVerifyFailure(OCRVerifyInfo oCRVerifyInfo) {
        ScanCardHelper.onOcrVerifyDone(false);
    }

    public void onOcrVerifySuccess() {
        int i = 1;
        ScanCardHelper.onOcrVerifyDone(true);
        if (this.f32994K) {
            i = 2;
        }
        m25078a(i);
    }

    public void showSignFailureGuideDialog(String str, String str2, String str3, String str4) {
        GlobalOmegaUtils.trackAddCardNetErrorPopupSW(this);
        GlobalDialogUtil.showAddCardFailureGuideDialog(this, str, str2, str3, str4, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorBackBtnCK(GlobalCreditCardAddOptV2Activity.this);
                if (ConfigProxyHolder.getGlobalPageRouterProxy() != null) {
                    ConfigProxyHolder.getGlobalPageRouterProxy().toHomeActivity(GlobalCreditCardAddOptV2Activity.this, true);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("com.didi.home");
                    intent.setPackage("com.didiglobal.passenger");
                    intent.setFlags(603979776);
                    GlobalCreditCardAddOptV2Activity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackAddCardNetErrorWaitBtnCK(GlobalCreditCardAddOptV2Activity.this);
            }
        });
    }

    public void showBindFailureDialog(SignResult signResult) {
        CreditCardErrorDialog.Companion.showBindFailureDialog(this, signResult);
    }

    public void showCardUpdateConfirmDialog() {
        this.f32995L = new NLEGODialogBuilder(getActivity()).title(getString(R.string.one_payment_creditcard_dialog_update_confirm_title)).subTitle(getString(R.string.one_payment_creditcard_dialog_update_confirm_content)).confirmAction(getString(R.string.one_payment_creditcard_dialog_update_confirm_positive), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.m25078a(2);
            }
        }).negativeAction(getString(R.string.one_payment_creditcard_dialog_update_confirm_negative), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
            }
        }).build(1).show();
    }

    public void onCybs3DSSuccess(ThreedsCybsDataResponse threedsCybsDataResponse) {
        m25079a(this.f32994K ? 2 : 1, threedsCybsDataResponse);
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.retainTips)) {
            m25112l();
            return;
        }
        setResult(0);
        finish();
    }

    public void finish() {
        super.finish();
        GlobalOmegaErrorCounter.onSignErrorEvent(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25078a(int i) {
        m25079a(i, (ThreedsCybsDataResponse) null);
    }

    /* renamed from: a */
    private void m25079a(int i, ThreedsCybsDataResponse threedsCybsDataResponse) {
        String textWithoutSpace = this.f33011p.getTextWithoutSpace();
        String textWithoutSpace2 = this.f33012q.getTextWithoutSpace();
        String textWithoutSpace3 = this.f33013r.getTextWithoutSpace();
        ICardBinRule createCardBinRule = CardBinRuleFactory.createCardBinRule(getContext(), this.f33000e.apolloName);
        int cardOrg = createCardBinRule.getCardOrg(textWithoutSpace);
        int cardType = this.f33015t.getCardType();
        int cardType2 = cardType == 0 ? createCardBinRule.getCardType(textWithoutSpace) : cardType;
        CreditCardAddContract.IPresenter iPresenter = this.f33018w;
        boolean z = this.f32986C;
        String str = this.f32987D;
        SignCardParam signCardParam = this.f33000e;
        iPresenter.commit(i, textWithoutSpace, textWithoutSpace2, textWithoutSpace3, cardType2, cardOrg, z, str, signCardParam, signCardParam.resourceId, threedsCybsDataResponse, this.f32997N);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25087b(int i) {
        this.f32993J = System.currentTimeMillis();
        this.f32992I = 0;
        String textWithoutSpace = this.f33011p.getTextWithoutSpace();
        final String textWithoutSpace2 = this.f33012q.getTextWithoutSpace();
        final String textWithoutSpace3 = this.f33013r.getTextWithoutSpace();
        final int cardType = this.f33015t.getCardType();
        if (cardType == 0) {
            cardType = this.f33019x.getCardType(textWithoutSpace);
        }
        String g = m25103g();
        ScanCardParam.Builder builder = new ScanCardParam.Builder(i == 603 ? 0 : 1, PayBaseParamUtil.getStringParam(this, "uid"));
        builder.countryCode(PayBaseParamUtil.getStringParam(this, "country"));
        builder.cardBin(g);
        ScanCardHelper.scan(this, builder.build(), new IScanCardCallback() {
            public void onScanResult(ScanCardResult scanCardResult) {
                long unused = GlobalCreditCardAddOptV2Activity.this.f32992I = System.currentTimeMillis() - GlobalCreditCardAddOptV2Activity.this.f32993J;
                if (scanCardResult.code == 0) {
                    ScanCardResult unused2 = GlobalCreditCardAddOptV2Activity.this.f32989F = scanCardResult;
                    boolean unused3 = GlobalCreditCardAddOptV2Activity.this.f32986C = true;
                    String unused4 = GlobalCreditCardAddOptV2Activity.this.f32987D = scanCardResult.cardNum;
                    int i = scanCardResult.type;
                    if (i == 0) {
                        GlobalCreditCardAddOptV2Activity.this.f33011p.setText(GlobalCreditCardAddOptV2Activity.this.f32987D);
                        GlobalCreditCardAddOptV2Activity.this.f33011p.setSelection(GlobalCreditCardAddOptV2Activity.this.f33011p.length());
                    } else if (i == 1) {
                        GlobalCreditCardAddOptV2Activity.this.f33018w.ocrVerify(GlobalCreditCardAddOptV2Activity.this.f32987D, textWithoutSpace2, textWithoutSpace3, cardType, GlobalCreditCardAddOptV2Activity.this.f32986C, GlobalCreditCardAddOptV2Activity.this.f32987D, GlobalCreditCardAddOptV2Activity.this.f33011p.getTextWithoutSpace(), GlobalCreditCardAddOptV2Activity.this.f33000e, GlobalCreditCardAddOptV2Activity.this.f32997N);
                    }
                } else {
                    SystemUtils.log(3, "CardAdd", "start error: code " + scanCardResult.code, (Throwable) null, "com.didi.payment.creditcard.global.v2.activity.GlobalCreditCardAddOptV2Activity$13", 691);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m25099e() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f32990G));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_STATUS, Integer.valueOf(m25100f()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.MANUAL_INPUT, m25103g());
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.OCR_SESSION, Long.valueOf(this.f32992I));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.SAME_CHECK, Integer.valueOf(m25104h()));
        hashMap.put(GlobalOmegaConstant.AddCardPage.EventKey.USER_OCR_RESULT, m25107i());
        GlobalOmegaUtils.trackOcrOperation(this, this.f33000e.bindType, hashMap);
    }

    /* renamed from: f */
    private int m25100f() {
        ScanCardResult scanCardResult = this.f32989F;
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

    /* renamed from: g */
    private String m25103g() {
        String textString = this.f33011p.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        if (textString == null || textString.length() < 6) {
            return "";
        }
        return textString.substring(0, 6);
    }

    /* renamed from: h */
    private int m25104h() {
        String textString = this.f33011p.getTextString();
        if (textString != null) {
            textString = textString.replace(" ", "");
        }
        return TextUtils.equals(textString, this.f32987D) ? 1 : 0;
    }

    /* renamed from: i */
    private String m25107i() {
        String str = this.f32987D;
        if (TextUtils.isEmpty(str) || str.length() < 10) {
            return "";
        }
        String replace = str.replace(" ", "");
        String substring = replace.substring(0, 6);
        String substring2 = replace.substring(replace.length() - 4);
        return substring + substring2;
    }

    public void onSignFail(SignResult signResult) {
        ISignErrorHandler iSignErrorHandler = this.f32991H;
        if (iSignErrorHandler != null) {
            iSignErrorHandler.handleError(signResult);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m25109j() {
        this.f33011p.setText("");
        this.f33013r.setText("");
        this.f33012q.setText("");
        this.f33011p.requestFocus();
        InputTools.showKeyboard(this.f33011p);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m25111k() {
        setResult(-1);
        finish();
        overridePendingTransition(R.anim.one_payment_creditcard_in_from_left, R.anim.one_payment_creditcard_out_to_right);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25080a(SignResult signResult) {
        if (signResult != null && !TextUtils.isEmpty(signResult.faqURL)) {
            WebBrowserUtil.startInternalWebActivity(this, signResult.faqURL, "");
        }
    }

    /* renamed from: l */
    private void m25112l() {
        this.f32995L = new NLEGODialogBuilder(getActivity()).title(this.retainTips).confirmAction(getString(R.string.Fintech_Payment_optimization_Give_up_IWAv), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardGiveUpOkCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.setResult(0);
                GlobalCreditCardAddOptV2Activity.this.finish();
            }
        }).negativeAction(getString(R.string.Fintech_Payment_optimization_Stay_on_mWSQ), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardGiveUpCancelCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
            }
        }).isClickOutsideCanCancel(false).build(1).show();
        CreditCardOmegaUtil.Companion.bindCardGiveUpShowTrace(this.retainTips);
    }

    /* renamed from: c */
    private void m25095c(final String str) {
        this.f32995L = new NLEGODialogBuilder(getActivity()).title(this.successTips).confirmAction(getString(R.string.Fintech_Payment_optimization_To_use_hfam), new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                CreditCardOmegaUtil.Companion.bindCardSuccessCkTrace(GlobalCreditCardAddOptV2Activity.this.retainTips);
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
                if (!TextUtils.isEmpty(GlobalCreditCardAddOptV2Activity.this.successUrl)) {
                    DRouter.build(GlobalCreditCardAddOptV2Activity.this.successUrl).start(GlobalCreditCardAddOptV2Activity.this);
                }
                GlobalCreditCardAddOptV2Activity.this.m25091b(str);
            }
        }).isShowCloseImage(true).closeAction(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (GlobalCreditCardAddOptV2Activity.this.f32995L != null) {
                    GlobalCreditCardAddOptV2Activity.this.f32995L.dismiss();
                }
                GlobalCreditCardAddOptV2Activity.this.m25091b(str);
            }
        }).setImageResource(R.drawable.one_payment_add_car_succeed_icon).isClickOutsideCanCancel(false).build(1).show();
        CreditCardOmegaUtil.Companion.bindCardSuccessShowTrace(this.retainTips);
    }

    public void onPaste() {
        this.f32997N = "1";
    }
}
