package com.didi.sdk.elvish;

import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.global.didi.elvish.Elvish;

public class ElvishInit {

    /* renamed from: a */
    private static Boolean f38594a;

    /* renamed from: b */
    private static boolean f38595b;

    public static boolean isAllowed() {
        Boolean bool = f38594a;
        if (bool != null) {
            return bool.booleanValue();
        }
        IToggle toggle = Apollo.getToggle("global_psg_anr_elvish_init_when_use");
        Boolean valueOf = Boolean.valueOf(toggle != null && toggle.allow());
        f38594a = valueOf;
        return valueOf.booleanValue();
    }

    public static void before() {
        SystemUtils.log(4, "ElvishInit", "before: ", (Throwable) null, "com.didi.sdk.elvish.ElvishInit", 29);
        if (f38595b) {
            SystemUtils.log(4, "ElvishInit", "initialized: ", (Throwable) null, "com.didi.sdk.elvish.ElvishInit", 31);
        } else if (isAllowed()) {
            SystemUtils.log(4, "ElvishInit", "init: ", (Throwable) null, "com.didi.sdk.elvish.ElvishInit", 37);
            init();
        }
    }

    public static void init() {
        f38595b = true;
        Elvish.Companion.init(DIDIApplication.getAppContext(), MultiLocaleStore.getInstance().getLocaleCode(), MultiLocaleUtil.getLanguageModel().getLocale(), NationTypeUtil.getNationComponentData().getLocCountry(), NationTypeUtil.getNationComponentData().getCityId());
    }
}
