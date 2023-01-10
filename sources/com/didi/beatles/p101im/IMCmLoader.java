package com.didi.beatles.p101im;

import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.view.IMCmViewUtil;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.beatles.im.IMCmLoader */
public class IMCmLoader {

    /* renamed from: a */
    private static final String f10516a = "IMCmLoader";

    /* renamed from: b */
    private static IMCmLoader f10517b = new IMCmLoader();

    /* renamed from: c */
    private IMCmViewUtil f10518c;

    public static IMCmLoader getInstance() {
        return f10517b;
    }

    public IMCmViewUtil getViewUtil() {
        IMCmViewUtil iMCmViewUtil = this.f10518c;
        if (iMCmViewUtil != null) {
            return iMCmViewUtil;
        }
        IMCmViewUtil iMCmViewUtil2 = (IMCmViewUtil) ServiceLoader.load(IMCmViewUtil.class).iterator().next();
        this.f10518c = iMCmViewUtil2;
        if (iMCmViewUtil2 == null) {
            IMLog.m10021e(f10516a, "init fail not found IMCmViewUtil spi");
            this.f10518c = IMCmViewUtil.empty;
        }
        return this.f10518c;
    }
}
