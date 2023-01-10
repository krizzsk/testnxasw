package com.didi.hawaii.p120ar.core.modle;

import com.didi.hawaii.p120ar.jni.DARCAskResponse;
import com.didi.hawaii.p120ar.utils.ARCoreCheckerAndGenerator;

/* renamed from: com.didi.hawaii.ar.core.modle.DiARNavViewCAResponseData */
public class DiARNavViewCAResponseData {

    /* renamed from: a */
    private ARCoreCheckerAndGenerator.CheckOption f25333a;

    /* renamed from: b */
    private DARCAskResponse f25334b;

    public void setArRequestOption(ARCoreCheckerAndGenerator.CheckOption checkOption) {
        this.f25333a = checkOption;
    }

    public void setcResData(DARCAskResponse dARCAskResponse) {
        this.f25334b = dARCAskResponse;
    }

    public ARCoreCheckerAndGenerator.CheckOption getArRequestOption() {
        return this.f25333a;
    }

    public DARCAskResponse getcResData() {
        return this.f25334b;
    }
}
