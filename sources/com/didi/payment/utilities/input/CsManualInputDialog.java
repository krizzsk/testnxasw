package com.didi.payment.utilities.input;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel3;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.utilities.CsBoletoClipboardChecker;
import com.didi.payment.utilities.CsInputFilter;
import com.didi.payment.utilities.base.CsRouter;
import com.didi.payment.wallet.global.model.NightlyLimitSettingModel;
import com.didi.payment.wallet.global.model.resp.BaseResponse;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class CsManualInputDialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f34174a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GGKDialogFragment f34175b;

    /* renamed from: c */
    private NightlyLimitSettingModel f34176c;

    public CsManualInputDialog(FragmentActivity fragmentActivity) {
        this.f34174a = fragmentActivity;
        this.f34176c = new NightlyLimitSettingModel(fragmentActivity.getApplicationContext());
    }

    public void show(final String str, final String str2, final Runnable runnable) {
        HashMap hashMap = new HashMap();
        hashMap.put("boleto_clickboard_popup_from", str2);
        PayTracker.trackEvent("ibt_didipay_pay_boleto_clickboard_popup_sw", hashMap);
        String string = ResourcesHelper.getString(this.f34174a, R.string.cs_boleto_scan_clipboard_dialog_title);
        String string2 = ResourcesHelper.getString(this.f34174a, R.string.cs_boleto_scan_clipboard_dialog_btn_pos);
        String string3 = ResourcesHelper.getString(this.f34174a, R.string.cs_boleto_scan_clipboard_dialog_btn_neg);
        String wrapperString = new CsInputFilter('-', ' ').wrapperString(str);
        if (wrapperString != null && wrapperString.length() > 36) {
            wrapperString = new StringBuilder(wrapperString).insert((wrapperString.length() / 2) + 1, 10).toString();
        }
        GGKDialogFragment gGKDialogFragment = this.f34175b;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
        }
        GGKDialogModel3 gGKDialogModel3 = new GGKDialogModel3(string, wrapperString, new GGKBtnTextAndCallback(string2, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("boleto_clickboard_popup_from", str2);
                PayTracker.putGlobal("entry_timestamp", Long.valueOf(System.currentTimeMillis()));
                PayTracker.trackEvent("ibt_didipay_pay_boleto_clickboard_confirm_ck", hashMap);
                if (CsManualInputDialog.this.f34175b != null) {
                    CsManualInputDialog.this.f34175b.dismiss();
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
                CsManualInputDialog.this.m26087a(str, str2);
                CsBoletoClipboardChecker.clearClipboard(CsManualInputDialog.this.f34174a);
            }
        }));
        gGKDialogModel3.addMinorBtn(new GGKBtnTextAndCallback(string3, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("boleto_clickboard_popup_from", str2);
                PayTracker.trackEvent("ibt_didipay_pay_boleto_clickboard_back_ck", hashMap);
                CsBoletoClipboardChecker.clearClipboard(CsManualInputDialog.this.f34174a);
                if (CsManualInputDialog.this.f34175b != null) {
                    CsManualInputDialog.this.f34175b.dismiss();
                }
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }));
        this.f34175b = GGKUICreatorWithThemeCheck.showDialogModel(this.f34174a, gGKDialogModel3, "boleto_input_dialog");
    }

    public void dismiss() {
        GGKDialogFragment gGKDialogFragment = this.f34175b;
        if (gGKDialogFragment != null) {
            gGKDialogFragment.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26087a(final String str, String str2) {
        if (TextUtils.equals(str2, "wallet_home") || TextUtils.equals(str2, "wallet_sidebar")) {
            this.f34176c.getRiskLimit(606, new RpcService.Callback<BaseResponse<LimitRiskReminderVo>>() {
                public void onSuccess(BaseResponse<LimitRiskReminderVo> baseResponse) {
                    LimitRiskReminderVo limitRiskReminderVo = (LimitRiskReminderVo) baseResponse.data;
                    if (baseResponse.errno == 0) {
                        CsManualInputDialog.this.m26086a(str, limitRiskReminderVo);
                    } else {
                        WalletToastNew.showFailedMsg(CsManualInputDialog.this.f34174a, baseResponse.errmsg);
                    }
                }

                public void onFailure(IOException iOException) {
                    WalletToastNew.showFailedMsg(CsManualInputDialog.this.f34174a, CsManualInputDialog.this.f34174a.getString(R.string.pay_base_network_error));
                }
            });
        } else {
            m26086a(str, (LimitRiskReminderVo) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26086a(String str, LimitRiskReminderVo limitRiskReminderVo) {
        CsRouter.startManualInputActivity(this.f34174a, "", "", str, limitRiskReminderVo, OmegaComParams.BOLETO_DIALOG);
    }
}
