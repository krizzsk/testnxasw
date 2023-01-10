package com.didi.unifiedPay.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import java.util.HashMap;

public class UnipayAppUtil {

    /* renamed from: a */
    private static HashMap<String, String> f47275a = new HashMap<>();

    private UnipayAppUtil() {
    }

    public static String getMetaDataByKey(Context context, String str) {
        Object obj;
        if (!TextUtil.isEmpty(f47275a.get(str))) {
            return f47275a.get(str);
        }
        String str2 = "";
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 16512);
            if (!(packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (obj = packageInfo.applicationInfo.metaData.get(str)) == null)) {
                str2 = obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f47275a.put(str, str2);
        return str2;
    }
}
