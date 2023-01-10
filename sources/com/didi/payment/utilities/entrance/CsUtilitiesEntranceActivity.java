package com.didi.payment.utilities.entrance;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Consumer;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.base.utils.TextHighlightUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.helper.AccountFreezeConfirmDialogHelper;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.utilities.CsBoletoClipboardChecker;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsNetModel;
import com.didi.payment.utilities.base.CsOmegaUtils;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.utilities.resp.CsBoletoChannels;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.risk.LimitRiskReminderHandler;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.foundation.rpc.RpcService;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IThemeRes;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsUtilitiesEntranceActivity extends CsBaseActivity implements View.OnClickListener {

    /* renamed from: a */
    private TextView f34150a;

    /* renamed from: b */
    private TextView f34151b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f34152c;

    /* renamed from: d */
    private View f34153d;

    /* renamed from: e */
    private TextView f34154e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CsBoletoChannels f34155f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LEGODrawer f34156g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AccountFreezeData f34157h;

    /* renamed from: i */
    private final LimitRiskReminderHandler f34158i = new LimitRiskReminderHandler();

    /* renamed from: j */
    private List<Integer> f34159j = new ArrayList();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        PayTracker.trackEvent("ibt_didipay_pay_boleto_method_sw");
        setContentView((int) R.layout.cs_activity_utilities_entrance_layout);
        m26039b();
        m26033a();
    }

    /* renamed from: a */
    private void m26033a() {
        IThemeRes iThemeRes = (IThemeRes) DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_THEME);
        ((TextView) findViewById(R.id.tv_utilities_entrance_guide_content)).setText(iThemeRes.getThemeStrResData().getCsGuideContentResId());
        ((ImageView) findViewById(R.id.iv_utilities_entrance_top_icon)).setImageResource(iThemeRes.getThemeImgResData().getCsUtilitiesEntranceTopIconResId());
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        super.initProgressDialog(this, WalletApolloUtil.isBoletoUnpaidBillReminder() ? R.id.title_layout_reminder_unpaid : R.id.title_layout);
        CsBoletoClipboardChecker.postClipboardCheckerRunnable(this, "wallet_boleto_method");
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        CsBoletoClipboardChecker.removeClipboardCheckerRunnable("wallet_boleto_method");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        showLoadingDialog();
        CsNetModel.getIns(getContext()).requestBoletoChannels(new RpcService.Callback<CsBoletoChannels>() {
            public void onSuccess(CsBoletoChannels csBoletoChannels) {
                CsUtilitiesEntranceActivity.this.dismissLoadingDialog();
                if (csBoletoChannels != null && csBoletoChannels.data != null) {
                    CsBoletoChannels unused = CsUtilitiesEntranceActivity.this.f34155f = csBoletoChannels;
                    if (WalletApolloUtil.isBoletoUnpaidBillReminder()) {
                        CsUtilitiesEntranceActivity.this.m26035a(csBoletoChannels);
                    }
                    AccountFreezeData unused2 = CsUtilitiesEntranceActivity.this.f34157h = csBoletoChannels.data.accountFreezeData;
                    CsUtilitiesEntranceActivity csUtilitiesEntranceActivity = CsUtilitiesEntranceActivity.this;
                    if (csUtilitiesEntranceActivity.m26037a(csUtilitiesEntranceActivity.f34157h)) {
                        CsUtilitiesEntranceActivity.this.m26036a(Integer.valueOf(R.id.ll_utilities_entrance_scan), Integer.valueOf(R.id.ll_utilities_entrance_input), Integer.valueOf(R.id.ll_utilities_entrance_photo_input));
                    }
                } else if (CsUtilitiesEntranceActivity.this.f34152c != null) {
                    CsUtilitiesEntranceActivity.this.f34152c.setVisibility(0);
                }
            }

            public void onFailure(IOException iOException) {
                CsUtilitiesEntranceActivity.this.dismissLoadingDialog();
                if (CsUtilitiesEntranceActivity.this.f34152c != null) {
                    CsUtilitiesEntranceActivity.this.f34152c.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: b */
    private void m26039b() {
        ((TextView) findViewById(R.id.tv_title)).setText(R.string.cs_utilities_entrance_top_title);
        findViewById(R.id.iv_left).setOnClickListener(this);
        int i = 0;
        if (!WalletCommonParamsUtil.isDriverClient()) {
            TextView textView = (TextView) findViewById(R.id.tv_right);
            textView.setVisibility(0);
            textView.setText(R.string.cs_utilities_entrance_top_right);
            textView.setOnClickListener(this);
        }
        findViewById(R.id.ll_utilities_entrance_scan).setOnClickListener(this);
        findViewById(R.id.ll_utilities_entrance_input).setOnClickListener(this);
        View findViewById = findViewById(R.id.ll_utilities_entrance_photo_input);
        findViewById.setOnClickListener(this);
        findViewById(R.id.ll_utilities_entrance_guide).setOnClickListener(this);
        findViewById(R.id.ll_utilities_entrance_tc).setOnClickListener(this);
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.riv_utilities_entrance_guide_icon);
        roundedImageView.setCornerType(3);
        roundedImageView.setRectAdius((float) UIUtil.dip2px(this, 20.0f));
        View findViewById2 = findViewById(R.id.title_layout);
        ViewStub viewStub = (ViewStub) findViewById(R.id.title_layout_unpaid);
        if (WalletApolloUtil.isBoletoUnpaidBillReminder()) {
            findViewById2.setVisibility(8);
            View inflate = viewStub.inflate();
            this.f34150a = (TextView) inflate.findViewById(R.id.unpaid_bills_count);
            this.f34151b = (TextView) inflate.findViewById(R.id.boleto_bills_text);
            View findViewById3 = inflate.findViewById(R.id.title_back);
            this.f34152c = findViewById3;
            findViewById3.setOnClickListener(this);
            inflate.findViewById(R.id.order_history).setOnClickListener(this);
        }
        if (!WalletApolloUtil.isBoletoPhotoInput()) {
            i = 8;
        }
        findViewById.setVisibility(i);
        this.f34154e = (TextView) findViewById(R.id.utilities_entrance_account_info);
        View findViewById4 = findViewById(R.id.utilities_entrance_account_info_layout);
        this.f34153d = findViewById4;
        findViewById4.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26036a(Integer... numArr) {
        if (numArr != null && numArr.length > 0) {
            this.f34159j.addAll(Arrays.asList(numArr));
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (!this.f34159j.contains(Integer.valueOf(id)) || !m26037a(this.f34157h)) {
            CsBoletoChannels csBoletoChannels = this.f34155f;
            LimitRiskReminderVo limitRiskReminderVo = (csBoletoChannels == null || csBoletoChannels.data == null) ? null : this.f34155f.data.limitRiskReminder;
            if (id == R.id.iv_left) {
                finish();
            } else if (id == R.id.tv_right) {
                m26042c();
            } else if (id == R.id.ll_utilities_entrance_scan) {
                PayTracker.trackEvent("ibt_didipay_pay_boleto_scan_ck");
                if (limitRiskReminderVo != null) {
                    this.f34158i.show(limitRiskReminderVo, this, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_IMPORT_METHOD, 606, new Consumer<Integer>() {
                        public void accept(Integer num) {
                            if (num.intValue() == 1) {
                                CsUtilitiesEntranceActivity.this.m26044d();
                            }
                        }
                    });
                } else {
                    m26044d();
                }
            } else if (id == R.id.ll_utilities_entrance_input) {
                PayTracker.trackEvent("ibt_didipay_pay_boleto_manual_input_ck");
                if (limitRiskReminderVo != null) {
                    this.f34158i.show(limitRiskReminderVo, this, GlobalOmegaConstant.SkuRiskLimit.PUB_PAGE_BOLETO_IMPORT_METHOD, 606, new Consumer<Integer>() {
                        public void accept(Integer num) {
                            if (num.intValue() == 1) {
                                CsUtilitiesEntranceActivity.this.m26047e();
                            }
                        }
                    });
                } else {
                    m26047e();
                }
            } else if (id == R.id.ll_utilities_entrance_guide) {
                PayTracker.trackEvent("ibt_didipay_pay_boleto_learn_ck");
                m26048f();
            } else if (id == R.id.ll_utilities_entrance_tc) {
                m26050g();
            } else if (id == R.id.ll_utilities_entrance_photo_input) {
                if (PaySharedPreferencesUtil.isBoletoPhotoInputGuideShown(this)) {
                    m26051h();
                } else {
                    m26052i();
                }
                CsOmegaUtils.trackBoletoPhotoInputCk(PermissionUtil.checkPermissionAllGranted((Context) this, Permission.WRITE_EXTERNAL_STORAGE));
            } else if (id == R.id.title_back) {
                finish();
            } else if (id == R.id.order_history) {
                m26042c();
                CsBoletoChannels csBoletoChannels2 = this.f34155f;
                if (csBoletoChannels2 != null && csBoletoChannels2.data != null) {
                    CsOmegaUtils.trackBoletoHistoryButtonCk(this.f34155f.data.count);
                }
            } else if (id == R.id.utilities_entrance_account_info_layout) {
                m26053j();
            }
        }
    }

    /* renamed from: c */
    private void m26042c() {
        CsOmegaUtils.trackHistoryBtnClicked("code");
        CsBoletoChannels csBoletoChannels = this.f34155f;
        CsRouter.startHistoryListActivity4Boleto(this, 606, (csBoletoChannels == null || csBoletoChannels.data == null) ? 0 : this.f34155f.data.count);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m26044d() {
        String str;
        Intent intent = getIntent();
        String str2 = null;
        if (intent != null) {
            str2 = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
            str = intent.getStringExtra("activity_url");
        } else {
            str = null;
        }
        CsRouter.startScanActivity(this, str2, str);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m26047e() {
        String str;
        String str2;
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WalletExtraConstant.Key.ACTIVITY_TEXT);
            str = intent.getStringExtra("activity_url");
            str2 = stringExtra;
        } else {
            str2 = null;
            str = null;
        }
        CsRouter.startManualInputActivity(this, str2, str, "", (LimitRiskReminderVo) null, OmegaComParams.BOLETO_HOME);
        finish();
    }

    /* renamed from: f */
    private void m26048f() {
        WebBrowserUtil.startInternalWebActivity(this, WalletConstant.URL.H5_UTILITIES_GUIDE, "");
    }

    /* renamed from: g */
    private void m26050g() {
        WebBrowserUtil.startInternalWebActivity(this, WalletConstant.URL.H5_99PAY_TERM_CONDITIONS, "");
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m26051h() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    CsRouter.startPhotoInputActivity(CsUtilitiesEntranceActivity.this.getContext());
                    return;
                }
                if (!ActivityCompat.shouldShowRequestPermissionRationale(CsUtilitiesEntranceActivity.this, Permission.WRITE_EXTERNAL_STORAGE)) {
                    CsUtilitiesEntranceActivity csUtilitiesEntranceActivity = CsUtilitiesEntranceActivity.this;
                    WalletToastNew.showFailedMsg(csUtilitiesEntranceActivity, csUtilitiesEntranceActivity.getString(R.string.GRider_reminder_Access_to_HDhQ));
                    CsOmegaUtils.trackBoletoNoPhotoPermissionSw();
                }
                PayTracker.getTracker().trackEvent("ibt_didipay_pay_boleto_no_photo_permission_sw");
            }
        }, new String[]{Permission.WRITE_EXTERNAL_STORAGE}, false);
    }

    /* renamed from: i */
    private void m26052i() {
        try {
            if (this.f34156g != null && this.f34156g.isShowing()) {
                this.f34156g.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f34156g = LEGOUICreator.showDrawerTemplate(this, new LEGODrawerModel1(getString(R.string.GRider_reminder_Select_a_UeVg), new LEGOBtnTextAndCallback(getString(R.string.GRider_reminder_I_see_YkJW), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (CsUtilitiesEntranceActivity.this.f34156g != null && CsUtilitiesEntranceActivity.this.f34156g.isShowing()) {
                    CsUtilitiesEntranceActivity.this.f34156g.dismiss();
                }
                CsUtilitiesEntranceActivity.this.m26051h();
                CsOmegaUtils.trackBoletoAlbumGuideCk(PermissionUtil.checkPermissionAllGranted(CsUtilitiesEntranceActivity.this.getContext(), Permission.WRITE_EXTERNAL_STORAGE));
            }
        })).setIsShowCloseImg(true).setSubTitle(getString(R.string.GRider_reminder_Make_sure_cGYu)));
        PaySharedPreferencesUtil.setBoletoPhotoInputGuideShown(this, true);
        CsOmegaUtils.trackBoletoAlbumGuideSw(PermissionUtil.checkPermissionAllGranted((Context) this, Permission.WRITE_EXTERNAL_STORAGE));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26035a(CsBoletoChannels csBoletoChannels) {
        TextView textView;
        TextView textView2;
        if (csBoletoChannels != null && csBoletoChannels.data != null) {
            this.f34155f = csBoletoChannels;
            View view = this.f34152c;
            if (view != null) {
                view.setVisibility(0);
            }
            if (!TextUtils.isEmpty(csBoletoChannels.data.countMessage) && (textView2 = this.f34151b) != null) {
                textView2.setText(csBoletoChannels.data.countMessage);
            }
            if (csBoletoChannels.data.count <= 0 || (textView = this.f34150a) == null) {
                this.f34150a.setVisibility(8);
            } else {
                textView.setText(String.valueOf(csBoletoChannels.data.count));
                this.f34150a.setVisibility(0);
            }
            CsOmegaUtils.trackBoletoHistoryButtonSw(csBoletoChannels.data.count);
            if (1 == csBoletoChannels.data.status || TextUtils.isEmpty(csBoletoChannels.data.statusMessage)) {
                this.f34153d.setVisibility(8);
            } else {
                TextView textView3 = this.f34154e;
                textView3.setText(TextHighlightUtil.highlight(csBoletoChannels.data.statusMessage + " >", Color.parseColor("#5C6166"), Color.parseColor("#FF8040")));
                this.f34153d.setVisibility(0);
                CsOmegaUtils.trackRiskNoKycCk();
            }
            PayTracker.putGlobal("wallet_account_status", Integer.valueOf(csBoletoChannels.data.status));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26037a(AccountFreezeData accountFreezeData) {
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        return AccountFreezeConfirmDialogHelper.showAccountFrozenConfirmDialog2(this, (AccountFreezeData) AccountFreezeData.Builder.from(accountFreezeData).btnPos(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Details_cscc)).btnNeg(ResourcesHelper.getString(this, R.string.GRider_Unfreeze_Confirmation_bqam)).putExtra("entrance", -1).build());
    }

    /* renamed from: j */
    private void m26053j() {
        CsBoletoChannels csBoletoChannels = this.f34155f;
        if (csBoletoChannels != null && csBoletoChannels.data != null && this.f34155f.data.accountStatus != null) {
            OmegaComParams.Companion.setKYC_RESOURCE_ID(DiFaceLogger.EVENT_ID_EXIT_SDK);
            if (this.f34155f.data.status == 0) {
                DRouter.build("99pay://one/register").start(this);
            } else if (this.f34155f.data.status == 3) {
                IWalletService.AccountInfo accountInfo = new IWalletService.AccountInfo();
                accountInfo.title = this.f34155f.data.accountStatus.title;
                accountInfo.subTitle = this.f34155f.data.accountStatus.subTitle;
                WalletRouter.gotoFailedReasonPage(this, accountInfo);
            } else if (this.f34155f.data.status == 2) {
                IWalletService.AccountInfo accountInfo2 = new IWalletService.AccountInfo();
                accountInfo2.title = this.f34155f.data.accountStatus.title;
                accountInfo2.subTitle = this.f34155f.data.accountStatus.subTitle;
                WalletRouter.gotoSignUpWaitingPage(this, accountInfo2);
                CsOmegaUtils.trackBoletoKycPendingSw();
            }
            CsOmegaUtils.trackRiskNoKycSw();
        }
    }
}
