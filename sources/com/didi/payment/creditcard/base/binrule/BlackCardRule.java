package com.didi.payment.creditcard.base.binrule;

import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class BlackCardRule {

    /* renamed from: a */
    private static final String f32730a = "[627780,506722,589916,603689,439267,506776,421870]";

    /* renamed from: b */
    private List<String> f32731b;

    public BlackCardRule(Context context, String str) {
        m24770a(str);
    }

    /* renamed from: a */
    private void m24770a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f32731b = m24772c(m24771b(str));
        }
    }

    public boolean isBlackCard(String str) {
        List<String> list;
        if (TextUtils.isEmpty(str) || str.length() < 6 || (list = this.f32731b) == null) {
            return false;
        }
        return list.contains(str.substring(0, 6));
    }

    /* renamed from: b */
    private String m24771b(String str) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str);
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return null;
        }
        return (String) experiment.getParam("bin", "");
    }

    /* renamed from: c */
    private List<String> m24772c(String str) {
        return (List) new Gson().fromJson(str, new TypeToken<List<String>>() {
        }.getType());
    }
}
