package com.iproov.sdk.cameray;

import android.content.Context;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.core.C20869else;
import com.iproov.sdk.core.exception.CameraException;
import java.util.Arrays;
import p235do.C21821case;
import p235do.C21825goto;
import p237final.C21836if;

/* renamed from: com.iproov.sdk.cameray.class */
/* compiled from: CameraProvider */
public class C20758class {

    /* renamed from: a */
    private final C21836if f56857a;

    /* renamed from: b */
    private final C20776try.C20777do f56858b;

    /* renamed from: c */
    private final C21825goto f56859c;

    /* renamed from: d */
    private final C20752break[] f56860d;

    public C20758class(C21836if ifVar, C20776try.C20777do doVar, C21825goto gotoR, C20752break... breakArr) {
        this.f56857a = ifVar;
        this.f56858b = doVar;
        this.f56859c = gotoR;
        this.f56860d = breakArr;
    }

    /* renamed from: do */
    public C20776try mo171298do(Context context) throws CameraException {
        C20762else a = C20754c.m42861a();
        try {
            C20757catch catchR = a.mo171314do(context);
            if (catchR != null) {
                C20763final finalR = a.mo171315do(context, m42865a(this.f56857a, catchR));
                C20752break[] breakArr = this.f56857a.mo180469do() == null ? this.f56860d : new C20752break[]{this.f56857a.mo180469do()};
                if (finalR != null) {
                    C21821case caseR = finalR.mo171318do(breakArr);
                    if (caseR != null) {
                        return a.mo171316do(context, caseR, this.f56858b, new C20869else(), this.f56859c);
                    }
                    throw new CameraException(context, "No cameras available for lensFacing: " + Arrays.toString(breakArr) + " from: " + finalR.toString());
                }
                throw new CameraException(context, "No cameras available");
            }
            throw new CameraException(context, "No cameras available");
        } catch (C20755case e) {
            e.printStackTrace();
            throw new CameraException(context, e.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    private C20759const m42865a(C21836if ifVar, C20757catch catchR) {
        if (ifVar.m48243goto()) {
            return ifVar.mo180473if();
        }
        return catchR.mo171297do(C20757catch.CAMERA2_LIMITED) ? C20759const.CAMERA2 : C20759const.CAMERA1;
    }
}
