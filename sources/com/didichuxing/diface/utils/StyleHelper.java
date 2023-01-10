package com.didichuxing.diface.utils;

import android.app.Activity;
import android.content.Context;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.DFBioassayFailedAct;
import com.didichuxing.diface.biz.bioassay.alpha.p182br.BRDFBioassayFailedAct;
import com.didichuxing.diface.biz.guide.DiFaceGuideActivity;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.biz.guide.p184br.BRDiFaceGuideActivity;
import com.didichuxing.diface.data.PreGuideContent;

public class StyleHelper {

    /* renamed from: BR */
    public static final String f50108BR = "BR";

    /* renamed from: a */
    private static String f50109a;

    public static String getCountry() {
        return f50109a;
    }

    public static void setCountry(String str) {
        f50109a = str;
    }

    /* renamed from: a */
    private static boolean m37471a() {
        return "BR".equalsIgnoreCase(f50109a);
    }

    public static void toGuide(Activity activity, GuideResult guideResult, PreGuideContent preGuideContent) {
        if (m37471a()) {
            BRDiFaceGuideActivity.realStart(activity, guideResult, preGuideContent);
        } else {
            DiFaceGuideActivity.realStart(activity, guideResult, preGuideContent);
        }
    }

    public static void toBioassayFailedAct(Context context, int i, String str, AppealParam appealParam) {
        if (m37471a()) {
            BRDFBioassayFailedAct.realStart(context, i, str, appealParam);
        } else {
            DFBioassayFailedAct.realStart(context, i, str, appealParam);
        }
    }
}
