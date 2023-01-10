package com.didi.sdk.config;

import android.content.Context;
import android.util.Xml;
import com.didi.sdk.nation.NationTypeUtil;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class GlobalConfigCenter {

    /* renamed from: a */
    private static GlobalConfigCenter f38461a = new GlobalConfigCenter();

    /* renamed from: b */
    private static final Config[] f38462b = {new Config("about", "email")};

    /* renamed from: c */
    private static final Config[] f38463c = new Config[0];

    /* renamed from: d */
    private String f38464d;

    /* renamed from: e */
    private PushParameter f38465e;

    /* renamed from: f */
    private String f38466f;

    /* renamed from: g */
    private Context f38467g;

    public static class PushParameter {

        /* renamed from: ip */
        public String f38468ip;
        public int port;
    }

    public static GlobalConfigCenter getConfigCenter() {
        return f38461a;
    }

    public void loadConfig(Context context, String str) {
        this.f38466f = str;
        this.f38467g = context.getApplicationContext();
        if (f38463c.length > 0) {
            m29014b(context, str + "_config.xml");
        }
    }

    /* renamed from: a */
    private void m29012a(Context context, String str) {
        if (f38462b.length > 0) {
            m29014b(context, str + "_config_lazy.xml");
        }
    }

    /* renamed from: b */
    private void m29014b(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(open, "UTF-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if (newPullParser.getName().equals("about")) {
                        this.f38464d = m29011a("email", newPullParser);
                    }
                }
            }
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    private String m29011a(String str, XmlPullParser xmlPullParser) {
        int attributeCount = xmlPullParser.getAttributeCount();
        String str2 = "";
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                str2 = xmlPullParser.getAttributeValue(i);
            }
        }
        return str2;
    }

    public PushParameter getPushParameter() {
        if (this.f38465e == null) {
            PushParameter pushParameter = new PushParameter();
            this.f38465e = pushParameter;
            pushParameter.port = NationTypeUtil.getNationComponentData().getPushConfig().getPort();
            this.f38465e.f38468ip = NationTypeUtil.getNationComponentData().getPushConfig().getIp();
        }
        return this.f38465e;
    }

    public String getAboutEmail() {
        m29013a(this.f38464d);
        return this.f38464d;
    }

    /* renamed from: a */
    private void m29013a(Object obj) {
        if (obj == null) {
            m29012a(this.f38467g, this.f38466f);
        }
    }

    static class Config {
        String attrs;
        String tag;

        public Config(String str, String str2) {
            this.tag = str;
            this.attrs = str2;
        }
    }
}
