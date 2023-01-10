package com.didi.sdk.global.sign.view.helper;

import android.content.Context;
import android.view.View;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.PayMethodCardView;
import com.didi.sdk.pay.util.PaymentSharedPreferencesUtil;
import java.util.List;

public class RedDotViewHelper {

    /* renamed from: a */
    private static final String f39120a = "KEY_PAY_METHOD_HOT_POINT_CLICKED_";

    public static final void clickRedDotItem(Context context, View view, PaySelItemData paySelItemData) {
        if ((view instanceof PayMethodCardView) && paySelItemData.hasRedPoint) {
            PaymentSharedPreferencesUtil.putBoolean(context, m29455a(paySelItemData), true);
            ((PayMethodCardView) view).setRedDotVisibility(false);
        }
    }

    public static final void showRedDot(Context context, List<PayMethodCardView> list) {
        if (list != null && list.size() > 0) {
            for (PayMethodCardView next : list) {
                next.setRedDotVisibility(m29456a(context, next.getPayMethodItemInfo()));
            }
        }
    }

    /* renamed from: a */
    private static String m29455a(PaySelItemData paySelItemData) {
        return f39120a + paySelItemData.channelId;
    }

    /* renamed from: a */
    private static boolean m29456a(Context context, PaySelItemData paySelItemData) {
        if (paySelItemData == null || context == null || !paySelItemData.isEnabled) {
            return false;
        }
        String a = m29455a(paySelItemData);
        if (paySelItemData.hasRedPoint) {
            return !PaymentSharedPreferencesUtil.getBoolean(context, a, false);
        }
        return false;
    }
}
