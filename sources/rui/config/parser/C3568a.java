package rui.config.parser;

import rui.config.RConfigConstants;

/* renamed from: rui.config.parser.a */
/* compiled from: RParserHelper */
final class C3568a {
    private C3568a() {
    }

    /* renamed from: a */
    static boolean m7237a(String str) {
        return str.contains(RConfigConstants.KEYWORD_GRADIENT);
    }

    /* renamed from: b */
    static boolean m7238b(String str) {
        return !m7237a(str) && str.contains(RConfigConstants.KEYWORD_COLOR_SIGN);
    }

    /* renamed from: c */
    static boolean m7239c(String str) {
        return !m7237a(str) && !m7238b(str);
    }
}
