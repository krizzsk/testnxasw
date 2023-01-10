package net.sourceforge.pinyin4j;

import com.p226hp.hpl.sparta.Document;
import com.p226hp.hpl.sparta.ParseException;
import com.p226hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class PinyinRomanizationResource {

    /* renamed from: a */
    private Document f6912a;

    /* renamed from: a */
    private void m6676a(Document document) {
        this.f6912a = document;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Document mo29784a() {
        return this.f6912a;
    }

    private PinyinRomanizationResource() {
        m6678c();
    }

    /* renamed from: c */
    private void m6678c() {
        try {
            m6676a(Parser.parse("", (InputStream) C2972e.m6686a("/pinyindb/pinyin_mapping.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParseException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    static PinyinRomanizationResource m6677b() {
        return PinyinRomanizationSystemResourceHolder.theInstance;
    }

    private static class PinyinRomanizationSystemResourceHolder {
        static final PinyinRomanizationResource theInstance = new PinyinRomanizationResource();

        private PinyinRomanizationSystemResourceHolder() {
        }
    }
}
