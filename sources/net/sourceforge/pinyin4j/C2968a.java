package net.sourceforge.pinyin4j;

import com.p226hp.hpl.sparta.Element;
import com.p226hp.hpl.sparta.ParseException;

/* renamed from: net.sourceforge.pinyin4j.a */
/* compiled from: GwoyeuRomatzyhTranslator */
class C2968a {

    /* renamed from: a */
    private static String[] f6913a = {"_I", "_II", "_III", "_IV", "_V"};

    C2968a() {
    }

    /* renamed from: a */
    static String m6680a(String str) {
        String b = C2973f.m6688b(str);
        String a = C2973f.m6687a(str);
        try {
            Element xpathSelectElement = GwoyeuRomatzyhResource.m6668b().mo29783a().xpathSelectElement("//" + C2971d.f6914a.mo29785a() + "[text()='" + b + "']");
            if (xpathSelectElement == null) {
                return null;
            }
            return xpathSelectElement.xpathSelectString("../" + C2971d.f6919f.mo29785a() + f6913a[Integer.parseInt(a) - 1] + "/text()");
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
