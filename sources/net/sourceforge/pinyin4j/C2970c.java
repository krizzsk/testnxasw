package net.sourceforge.pinyin4j;

import com.p226hp.hpl.sparta.Element;
import com.p226hp.hpl.sparta.ParseException;

/* renamed from: net.sourceforge.pinyin4j.c */
/* compiled from: PinyinRomanizationTranslator */
class C2970c {
    C2970c() {
    }

    /* renamed from: a */
    static String m6683a(String str, C2971d dVar, C2971d dVar2) {
        String b = C2973f.m6688b(str);
        String a = C2973f.m6687a(str);
        try {
            Element xpathSelectElement = PinyinRomanizationResource.m6677b().mo29784a().xpathSelectElement("//" + dVar.mo29785a() + "[text()='" + b + "']");
            if (xpathSelectElement == null) {
                return null;
            }
            String xpathSelectString = xpathSelectElement.xpathSelectString("../" + dVar2.mo29785a() + "/text()");
            return xpathSelectString + a;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
