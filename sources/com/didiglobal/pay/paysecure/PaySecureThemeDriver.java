package com.didiglobal.pay.paysecure;

import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/PaySecureThemeDriver;", "Lcom/didiglobal/pay/paysecure/PaySecureTheme;", "()V", "getForgetTextColor", "", "getNegativeBtnBg", "getNegativeBtnTextColor", "getPositiveBtnBg", "getPositiveBtnTextColor", "getThemeColor", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecure.kt */
public final class PaySecureThemeDriver implements PaySecureTheme {
    public static final PaySecureThemeDriver INSTANCE = new PaySecureThemeDriver();

    public int getForgetTextColor() {
        return R.color.primary_color_99_driver;
    }

    public int getNegativeBtnBg() {
        return R.drawable.bg_btn_pay_secure_cancel_99_driver;
    }

    public int getNegativeBtnTextColor() {
        return R.color.pay_secure_btn_negative_text_99_driver;
    }

    public int getPositiveBtnBg() {
        return R.drawable.bg_btn_pay_secure_confirm_99_driver;
    }

    public int getPositiveBtnTextColor() {
        return R.color.pay_secure_btn_text_99_driver;
    }

    public int getThemeColor() {
        return R.color.primary_color_99_driver;
    }

    private PaySecureThemeDriver() {
    }
}
