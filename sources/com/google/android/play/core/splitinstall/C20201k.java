package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.android.play.core.splitcompat.C20164p;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.play.core.splitinstall.k */
public final class C20201k {

    /* renamed from: a */
    private static C20203m f56263a;

    private C20201k() {
    }

    /* renamed from: a */
    static C20198h m42529a(XmlPullParser xmlPullParser, C20197g gVar) {
        String a;
        while (xmlPullParser.next() != 1) {
            try {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("splits")) {
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                if (!xmlPullParser.getName().equals("module") || (a = m42531a("name", xmlPullParser)) == null) {
                                    m42532a(xmlPullParser);
                                } else {
                                    while (xmlPullParser.next() != 3) {
                                        if (xmlPullParser.getEventType() == 2) {
                                            if (xmlPullParser.getName().equals("language")) {
                                                while (xmlPullParser.next() != 3) {
                                                    if (xmlPullParser.getEventType() == 2) {
                                                        if (xmlPullParser.getName().equals(ParamKeys.PARAM_COMPLAIN_ENTRY)) {
                                                            String a2 = m42531a("key", xmlPullParser);
                                                            String a3 = m42531a("split", xmlPullParser);
                                                            m42532a(xmlPullParser);
                                                            if (!(a2 == null || a3 == null)) {
                                                                gVar.mo164513a(a, a2, a3);
                                                            }
                                                        } else {
                                                            m42532a(xmlPullParser);
                                                        }
                                                    }
                                                }
                                            } else {
                                                m42532a(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        m42532a(xmlPullParser);
                    }
                }
            } catch (IOException | IllegalStateException | XmlPullParserException e) {
                SystemUtils.log(6, "SplitInstall", "Error while parsing splits.xml", e, "com.google.android.play.core.splitinstall.k", -1);
                return null;
            }
        }
        return gVar.mo164512a();
    }

    /* renamed from: a */
    public static synchronized C20203m m42530a(Context context) {
        C20203m mVar;
        synchronized (C20201k.class) {
            if (f56263a == null) {
                C20192b bVar = new C20192b((byte[]) null);
                bVar.mo164505a(new C20227y(C20164p.m42450a(context)));
                f56263a = bVar.mo164504a();
            }
            mVar = f56263a;
        }
        return mVar;
    }

    /* renamed from: a */
    private static String m42531a(String str, XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m42532a(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int i = 1;
        while (i != 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}
