package net.sourceforge.pinyin4j;

import com.p226hp.hpl.sparta.Document;
import com.p226hp.hpl.sparta.ParseException;
import com.p226hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class GwoyeuRomatzyhResource {

    /* renamed from: a */
    private Document f6911a;

    /* renamed from: a */
    private void m6667a(Document document) {
        this.f6911a = document;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Document mo29783a() {
        return this.f6911a;
    }

    private GwoyeuRomatzyhResource() {
        m6669c();
    }

    /* renamed from: c */
    private void m6669c() {
        try {
            m6667a(Parser.parse("", (InputStream) C2972e.m6686a("/pinyindb/pinyin_gwoyeu_mapping.xml")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (ParseException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: b */
    static GwoyeuRomatzyhResource m6668b() {
        return GwoyeuRomatzyhSystemResourceHolder.theInstance;
    }

    private static class GwoyeuRomatzyhSystemResourceHolder {
        static final GwoyeuRomatzyhResource theInstance = new GwoyeuRomatzyhResource();

        private GwoyeuRomatzyhSystemResourceHolder() {
        }
    }
}
