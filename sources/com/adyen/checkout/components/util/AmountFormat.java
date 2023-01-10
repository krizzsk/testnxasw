package com.adyen.checkout.components.util;

import com.adyen.checkout.components.model.payments.Amount;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

public final class AmountFormat {

    /* renamed from: a */
    private static final String f905a = LogUtil.getTag();

    public static BigDecimal toBigDecimal(Amount amount) {
        return toBigDecimal((long) amount.getValue(), amount.getCurrency());
    }

    public static BigDecimal toBigDecimal(long j, String str) {
        return BigDecimal.valueOf(j, m1058a(str));
    }

    /* renamed from: a */
    private static int m1058a(String str) {
        String upperCase = str.replaceAll("[^A-Z]", "").toUpperCase(Locale.ROOT);
        try {
            return CheckoutCurrency.find(upperCase).getFractionDigits();
        } catch (CheckoutException e) {
            String str2 = f905a;
            Logger.m1079e(str2, upperCase + " is an unsupported currency. Falling back to information from java.util.Currency.", e);
            try {
                return Math.max(Currency.getInstance(upperCase).getDefaultFractionDigits(), 0);
            } catch (IllegalArgumentException e2) {
                String str3 = f905a;
                Logger.m1079e(str3, "Could not determine fraction digits for " + upperCase, e2);
                return 0;
            }
        }
    }

    private AmountFormat() {
        throw new NoConstructorException();
    }
}
