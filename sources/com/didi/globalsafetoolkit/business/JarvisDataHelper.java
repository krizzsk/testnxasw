package com.didi.globalsafetoolkit.business;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.globalsafetoolkit.business.safeCenter.model.GlobalSfPanelData;
import com.didi.globalsafetoolkit.router.SfRouterUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;

public class JarvisDataHelper {
    public static boolean openVoice(GlobalSfPanelData globalSfPanelData) {
        if (globalSfPanelData == null || globalSfPanelData.menus == null || globalSfPanelData.menus.size() <= 0) {
            return false;
        }
        Iterator<JsonElement> it = globalSfPanelData.menus.iterator();
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (next instanceof JsonObject) {
                String asString = ((JsonObject) next).get("action").getAsString();
                if (!TextUtils.isEmpty(asString)) {
                    Uri parse = Uri.parse(asString);
                    String path = parse.getPath();
                    if (!TextUtils.isEmpty(path) && path.equals("/safety/record_audio")) {
                        boolean z = SfRouterUtil.parseInt(parse.getQueryParameter("enable"), 0) == 1;
                        boolean z2 = SfRouterUtil.parseInt(parse.getQueryParameter("can_start_voice"), 0) == 1;
                        if (!z || !z2) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }
}
