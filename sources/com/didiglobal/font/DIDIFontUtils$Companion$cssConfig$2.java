package com.didiglobal.font;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.font.iface.IFontConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: DIDIFontUtils.kt */
final class DIDIFontUtils$Companion$cssConfig$2 extends Lambda implements Function0<String> {
    public static final DIDIFontUtils$Companion$cssConfig$2 INSTANCE = new DIDIFontUtils$Companion$cssConfig$2();

    DIDIFontUtils$Companion$cssConfig$2() {
        super(0);
    }

    public final String invoke() {
        ServiceLoader<S> load = ServiceLoader.load(IFontConfig.class);
        Intrinsics.checkExpressionValueIsNotNull(load, "support");
        for (S s : load) {
            Intrinsics.checkExpressionValueIsNotNull(s, "it");
            String cssConfig = s.getCssConfig();
            String access$getTAG$cp = DIDIFontUtils.f52724a;
            SystemUtils.log(3, access$getTAG$cp, "@@@@@ is cssconfig " + cssConfig, (Throwable) null, "com.didiglobal.font.DIDIFontUtils$Companion$cssConfig$2", 66);
            if (!TextUtils.isEmpty(cssConfig)) {
                return cssConfig;
            }
        }
        return "javascript:!function(){s=document.createElement('style');s.innerHTML=\"@font-face{font-family:DiDiSans;font-weight:normal;font-style: normal;src:url('**injection**/DiDiSans-Regular.otf');}@font-face{font-family:DiDiSans;font-weight:400;font-style: normal;src:url('**injection**/DiDiSans-Regular.otf');}@font-face{font-family:DiDiSans;font-weight:bold;font-style: normal;src:url('**injection**/DiDiSans-Bold.otf');}@font-face{font-family:DiDiSans;font-weight: 500;font-style: normal;src:url('**injection**/DiDiSans-Medium.otf');}@font-face{font-family:DiDiSans;font-weight: 600;font-style: normal;src:url('**injection**/DiDiSans-Bold.otf');}@font-face{font-family:DiDiSans;font-weight: 700;font-style: normal;src:url('**injection**/DiDiSans-Bold.otf');}@font-face{font-family:DiDiSans;font-weight: 800;font-style: normal;src:url('**injection**/DiDiSans-Bold.otf');}@font-face{font-family:DiDiSans;font-weight:normal;font-style:italic;src:url('**injection**/DiDiSans-RegularItalic.otf');}@font-face{font-family:DiDiSans;font-weight:400;font-style:italic;src:url('**injection**/DiDiSans-RegularItalic.otf');}@font-face{font-family:DiDiSans; font-weight:bold;font-style:italic;src:url('**injection**/DiDiSans-BoldItalic.otf');}@font-face{font-family:DiDiSans; font-weight: 500;font-style:italic;src:url('**injection**/DiDiSans-MediumItalic.otf');}@font-face{font-family:DiDiSans; font-weight: 600;font-style:italic;src:url('**injection**/DiDiSans-BoldItalic.otf');}@font-face{font-family:DiDiSans; font-weight: 700;font-style:italic;src:url('**injection**/DiDiSans-BoldItalic.otf');}@font-face{font-family:DiDiSans; font-weight: 800;font-style:italic;src:url('**injection**/DiDiSans-BoldItalic.otf');} *{font-family:DiDiSans !important;}\";document.getElementsByTagName('head')[0].appendChild(s);}()";
    }
}
