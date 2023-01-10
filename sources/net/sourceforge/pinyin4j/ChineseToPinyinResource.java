package net.sourceforge.pinyin4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

class ChineseToPinyinResource {

    /* renamed from: a */
    private Properties f6910a;

    /* renamed from: a */
    private void m6661a(Properties properties) {
        this.f6910a = properties;
    }

    /* renamed from: b */
    private Properties m6664b() {
        return this.f6910a;
    }

    private ChineseToPinyinResource() {
        this.f6910a = null;
        m6665c();
    }

    /* renamed from: c */
    private void m6665c() {
        try {
            m6661a(new Properties());
            m6664b().load(C2972e.m6686a("/pinyindb/unicode_to_hanyu_pinyin.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String[] mo29782a(char c) {
        String b = m6663b(c);
        if (b == null) {
            return null;
        }
        return b.substring(b.indexOf("(") + 1, b.lastIndexOf(")")).split(",");
    }

    /* renamed from: a */
    private boolean m6662a(String str) {
        return str != null && !str.equals("(none0)") && str.startsWith("(") && str.endsWith(")");
    }

    /* renamed from: b */
    private String m6663b(char c) {
        String property = m6664b().getProperty(Integer.toHexString(c).toUpperCase());
        if (m6662a(property)) {
            return property;
        }
        return null;
    }

    /* renamed from: a */
    static ChineseToPinyinResource m6660a() {
        return ChineseToPinyinResourceHolder.theInstance;
    }

    private static class ChineseToPinyinResourceHolder {
        static final ChineseToPinyinResource theInstance = new ChineseToPinyinResource();

        private ChineseToPinyinResourceHolder() {
        }
    }

    class Field {
        static final String COMMA = ",";
        static final String LEFT_BRACKET = "(";
        static final String RIGHT_BRACKET = ")";

        Field() {
        }
    }
}
