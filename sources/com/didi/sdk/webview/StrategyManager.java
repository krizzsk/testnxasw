package com.didi.sdk.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.sdk.nation.NationTypeUtil;

public class StrategyManager {

    /* renamed from: a */
    private static final String[] f41109a = new String[0];

    /* renamed from: b */
    private static volatile StrategyManager f41110b;

    private StrategyManager() {
    }

    public static StrategyManager getInstance() {
        if (f41110b == null) {
            synchronized (StrategyManager.class) {
                if (f41110b == null) {
                    f41110b = new StrategyManager();
                }
            }
        }
        return f41110b;
    }

    public boolean isHostInWhiteList(String str) {
        for (String equalsIgnoreCase : f41109a) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlInWhiteList(String str) {
        Uri parse;
        if (str == null || (parse = Uri.parse(str)) == null) {
            return false;
        }
        return isHostInWhiteList(parse.getHost());
    }

    public String appendToken(String str) {
        if (str == null) {
            return str;
        }
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        if (TextUtils.isEmpty(token)) {
            return str;
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("token", token).toString();
    }
}
