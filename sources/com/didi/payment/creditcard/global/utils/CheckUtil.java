package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import android.text.TextUtils;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaErrorCounter;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;
import java.util.Calendar;

public class CheckUtil {

    /* renamed from: a */
    private static final String[] f32901a = {DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE, "37"};

    /* renamed from: b */
    private static final String[] f32902b = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    public static String getCardNoCheckMsg(Context context, String str, ICardBinRule iCardBinRule) {
        String a = m25017a(context, (int) R.string.one_payment_creditcard_global_error_cardnumber);
        String a2 = m25017a(context, (int) R.string.one_payment_creditcard_global_error_cardnumber_length);
        if (!m25019a(str)) {
            GlobalOmegaErrorCounter.addInvalidCardNoCount();
            return a2;
        } else if (m25021b(str)) {
            return "";
        } else {
            GlobalOmegaErrorCounter.addInvalidCardNoCount();
            return a;
        }
    }

    public static String getSafeCodeCheckMsg(Context context, String str, String str2) {
        String a = m25017a(context, (int) R.string.one_payment_creditcard_global_error_safe_code);
        String a2 = m25017a(context, (int) R.string.one_payment_creditcard_global_error_cid_code);
        if (TextUtils.isEmpty(str) || (!str.startsWith(f32901a[0]) && !str.startsWith(f32901a[1]))) {
            if (m25024d(str2)) {
                return "";
            }
            GlobalOmegaErrorCounter.addInvalidCvvCount();
            return a;
        } else if (m25025e(str2)) {
            return "";
        } else {
            GlobalOmegaErrorCounter.addInvalidCidCount();
            return a2;
        }
    }

    public static String getDateCheckMsg(Context context, String str) {
        return !m25023c(str) ? m25017a(context, (int) R.string.one_payment_creditcard_global_error_date) : "";
    }

    public static boolean checkAll(Context context, String str, String str2, String str3, ICardBinRule iCardBinRule, BlackCardRule blackCardRule) {
        return !m25018a(context, str, iCardBinRule, blackCardRule) && m25021b(str) && m25019a(str) && m25023c(str2) && m25020a(str, str3);
    }

    /* renamed from: a */
    private static boolean m25018a(Context context, String str, ICardBinRule iCardBinRule, BlackCardRule blackCardRule) {
        if (context == null || iCardBinRule == null) {
            return true;
        }
        return blackCardRule.isBlackCard(PaymentTextUtil.replaceAllSpace(str));
    }

    /* renamed from: a */
    private static boolean m25019a(String str) {
        if (!TextUtil.isEmpty(str) && str.length() >= 13 && str.length() <= 19) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m25021b(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll(" ", "");
        int length = replaceAll.length() - 1;
        int i = 0;
        boolean z = false;
        while (length >= 0) {
            try {
                int parseInt = Integer.parseInt(replaceAll.substring(length, length + 1));
                if (z && (parseInt = parseInt * 2) > 9) {
                    parseInt = (parseInt % 10) + 1;
                }
                i += parseInt;
                z = !z;
                length--;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m25023c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replaceAll = str.replaceAll("/", "");
        if (replaceAll.length() == 4) {
            String str2 = 20 + replaceAll.substring(2, 4);
            String substring = replaceAll.substring(0, 2);
            if (!m25026f(substring) || !m25022b(str2, substring)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m25020a(String str, String str2) {
        if (TextUtils.isEmpty(str) || (!str.startsWith(f32901a[0]) && !str.startsWith(f32901a[1]))) {
            if (!m25024d(str2)) {
                return false;
            }
        } else if (!m25025e(str2)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private static boolean m25024d(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        if (str.length() == 3 || str.length() == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private static boolean m25025e(String str) {
        if (!TextUtils.isEmpty(str) && str.length() == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private static boolean m25026f(String str) {
        if (TextUtil.isEmpty(str)) {
            return false;
        }
        for (String equals : f32902b) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m25022b(String str, String str2) {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2) + 1;
        int parseInt = Integer.parseInt(str);
        int parseInt2 = Integer.parseInt(str2);
        if (parseInt > i || (parseInt == i && parseInt2 >= i2)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static String m25017a(Context context, int i) {
        return context == null ? "" : context.getString(i);
    }
}
