package com.didi.payment.commonsdk.basemodel.helper;

import android.app.Activity;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.commonsdk.basemodel.account.IAccountFreezeData;
import java.util.HashMap;

public class AccountFreezeConfirmDialogHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static GGKDrawer f32607a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static LEGODrawer f32608b;

    @Deprecated
    public static boolean showAccountFrozenConfirmDialog(final Activity activity, final AccountFreezeData accountFreezeData) {
        String str;
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(activity, "uid"));
        for (String next : accountFreezeData.getExtras().keySet()) {
            hashMap.put(next, accountFreezeData.getExtras().get(next));
        }
        final boolean isJumpable = accountFreezeData.isJumpable(1);
        if (isJumpable) {
            str = accountFreezeData.getText(IAccountFreezeData.DataType.TYPE_BTN_POS);
        } else {
            str = accountFreezeData.getText(IAccountFreezeData.DataType.TYPE_BTN_NEG);
        }
        C113812 r4 = new GGKDrawerModel1(accountFreezeData.getTitle(1), new GGKBtnTextAndCallback(str, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AccountFreezeConfirmDialogHelper.f32607a != null && AccountFreezeConfirmDialogHelper.f32607a.isShowing()) {
                    AccountFreezeConfirmDialogHelper.f32607a.dismiss();
                }
                if (isJumpable) {
                    PayTracker.trackEvent("pax_freezen_dialog_detailck", hashMap);
                    WebBrowserUtil.startInternalWebActivity(activity, accountFreezeData.getLink(1), "");
                    return;
                }
                PayTracker.trackEvent("pax_freezen_dialog_okck", hashMap);
            }
        })) {
            /* access modifiers changed from: protected */
            public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
                if (isJumpable) {
                    gGKDrawerModel.isTwoBtnHorizontal = true;
                }
                return gGKDrawerModel;
            }
        };
        r4.setSubTitle(accountFreezeData.getSubTitle(1));
        if (isJumpable) {
            r4.addMinorBtn(new GGKBtnTextAndCallback(accountFreezeData.dialogData.btnNeg, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (AccountFreezeConfirmDialogHelper.f32607a != null && AccountFreezeConfirmDialogHelper.f32607a.isShowing()) {
                        AccountFreezeConfirmDialogHelper.f32607a.dismiss();
                    }
                    PayTracker.trackEvent("pax_freezen_dialog_okck", hashMap);
                }
            }));
        }
        GGKDrawer showDrawerModel = GGKUICreatorWithThemeCheck.showDrawerModel(activity, r4);
        f32607a = showDrawerModel;
        showDrawerModel.show();
        PayTracker.trackEvent("pax_freezen_dialog_sw", hashMap);
        return true;
    }

    public static boolean showAccountFrozenConfirmDialog2(final Activity activity, final AccountFreezeData accountFreezeData) {
        String str;
        if (accountFreezeData == null || !accountFreezeData.isDialogValid()) {
            return false;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("passenger_status", Integer.valueOf(accountFreezeData.freezeStatus));
        hashMap.put("passenger_uid", PayBaseParamUtil.getStringParam(activity, "uid"));
        for (String next : accountFreezeData.getExtras().keySet()) {
            hashMap.put(next, accountFreezeData.getExtras().get(next));
        }
        final boolean isJumpable = accountFreezeData.isJumpable(1);
        if (isJumpable) {
            str = accountFreezeData.getText(IAccountFreezeData.DataType.TYPE_BTN_POS);
        } else {
            str = accountFreezeData.getText(IAccountFreezeData.DataType.TYPE_BTN_NEG);
        }
        C113845 r4 = new LEGODrawerModel1(accountFreezeData.getTitle(1), new LEGOBtnTextAndCallback(str, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (AccountFreezeConfirmDialogHelper.f32608b != null && AccountFreezeConfirmDialogHelper.f32608b.isShowing()) {
                    AccountFreezeConfirmDialogHelper.f32608b.dismiss();
                }
                if (isJumpable) {
                    PayTracker.trackEvent("pax_freezen_dialog_detailck", hashMap);
                    DRouter.build(accountFreezeData.getLink(1)).start(activity);
                    return;
                }
                PayTracker.trackEvent("pax_freezen_dialog_okck", hashMap);
            }
        })) {
            /* access modifiers changed from: protected */
            public LEGODrawerModel convertOthers(LEGODrawerModel lEGODrawerModel) {
                if (isJumpable) {
                    lEGODrawerModel.isTwoBtnHorizontal = true;
                }
                return lEGODrawerModel;
            }
        };
        r4.setSubTitle(accountFreezeData.getSubTitle(1));
        if (isJumpable) {
            r4.addMinorBtn(new LEGOBtnTextAndCallback(accountFreezeData.dialogData.btnNeg, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (AccountFreezeConfirmDialogHelper.f32608b != null && AccountFreezeConfirmDialogHelper.f32608b.isShowing()) {
                        AccountFreezeConfirmDialogHelper.f32608b.dismiss();
                    }
                    PayTracker.trackEvent("pax_freezen_dialog_okck", hashMap);
                }
            }));
        }
        f32608b = LEGOUICreator.showDrawerTemplate(activity, r4);
        PayTracker.trackEvent("pax_freezen_dialog_sw", hashMap);
        return true;
    }
}
