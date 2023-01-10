package com.didi.sdk.global.sign.payselect.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.didi.payment.base.utils.UIUtil;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.pay.util.PaymentSharedPreferencesUtil;
import com.taxis99.R;

public class GuidePopViewHelper {

    /* renamed from: a */
    static PopupWindow f39044a = null;

    /* renamed from: b */
    private static final String f39045b = "KEY_GLOBAL_BALANCE_SWITCH_GUIDE_CLOSED";

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29387b(Context context, View view, int i) {
        if (f39044a == null) {
            f39044a = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.payment_paysel_pop_guide_view, (ViewGroup) null), -2, -2);
            int i2 = 0;
            if (i == 190) {
                i2 = UIUtil.dip2px(context, -106.0f);
            } else if (i == 120) {
                i2 = UIUtil.dip2px(context, -132.0f);
            }
            f39044a.showAsDropDown(view, i2, UIUtil.dip2px(context, -84.0f));
            PaymentSharedPreferencesUtil.putBoolean(context, f39045b, true);
        }
    }

    public static void showGuideView(final View view, final PaySelItemData paySelItemData) {
        if (view != null && view.getContext() != null && view.isEnabled() && !paySelItemData.isFrozen && PaySelUtils.INSTANCE.isBalanceChannel(paySelItemData.channelId) && paySelItemData.style == 3) {
            final Context context = view.getContext();
            if (!PaymentSharedPreferencesUtil.getBoolean(context, f39045b, false)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        GuidePopViewHelper.m29387b(context, view, paySelItemData.channelId);
                        view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
        }
    }

    public static void dismiss() {
        PopupWindow popupWindow = f39044a;
        if (popupWindow != null) {
            popupWindow.dismiss();
            f39044a = null;
        }
    }
}
