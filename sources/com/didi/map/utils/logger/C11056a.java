package com.didi.map.utils.logger;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.map.utils.logger.a */
/* compiled from: LoggerPrinter */
class C11056a implements Printer {

    /* renamed from: a */
    private static final int f31518a = 2;

    /* renamed from: b */
    private final ThreadLocal<String> f31519b = new ThreadLocal<>();

    /* renamed from: c */
    private final List<LogAdapter> f31520c = new ArrayList();

    C11056a() {
    }

    /* renamed from: t */
    public Printer mo85895t(String str) {
        if (str != null) {
            this.f31519b.set(str);
        }
        return this;
    }

    /* renamed from: d */
    public void mo85889d(String str, Object... objArr) {
        m24067a(3, (Throwable) null, str, objArr);
    }

    /* renamed from: d */
    public void mo85888d(Object obj) {
        m24067a(3, (Throwable) null, C11057b.m24077a(obj), new Object[0]);
    }

    /* renamed from: e */
    public void mo85890e(String str, Object... objArr) {
        mo85891e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public void mo85891e(Throwable th, String str, Object... objArr) {
        m24067a(6, th, str, objArr);
    }

    /* renamed from: w */
    public void mo85897w(String str, Object... objArr) {
        m24067a(5, (Throwable) null, str, objArr);
    }

    /* renamed from: i */
    public void mo85892i(String str, Object... objArr) {
        m24067a(4, (Throwable) null, str, objArr);
    }

    /* renamed from: v */
    public void mo85896v(String str, Object... objArr) {
        m24067a(2, (Throwable) null, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        m24067a(7, (Throwable) null, str, objArr);
    }

    public void json(String str) {
        if (C11057b.m24079a((CharSequence) str)) {
            mo85888d("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith(Const.joLeft)) {
                mo85888d(new JSONObject(trim).toString(2));
            } else if (trim.startsWith(Const.jaLeft)) {
                mo85888d(new JSONArray(trim).toString(2));
            } else {
                mo85890e("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            mo85890e("Invalid Json", new Object[0]);
        }
    }

    public void xml(String str) {
        if (C11057b.m24079a((CharSequence) str)) {
            mo85888d("Empty/Null xml content");
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            mo85888d(streamResult.getWriter().toString().replaceFirst(IMTextUtils.STREET_IMAGE_TAG_END, ">\n"));
        } catch (TransformerException unused) {
            mo85890e("Invalid xml", new Object[0]);
        }
    }

    public synchronized void log(int i, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + C11057b.m24078a(th);
        }
        if (th != null && str2 == null) {
            str2 = C11057b.m24078a(th);
        }
        if (C11057b.m24079a((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        for (LogAdapter next : this.f31520c) {
            if (next.isLoggable(i, str)) {
                next.log(i, str, str2);
            }
        }
    }

    public void clearLogAdapters() {
        this.f31520c.clear();
    }

    public void addAdapter(LogAdapter logAdapter) {
        this.f31520c.add((LogAdapter) C11057b.m24081b(logAdapter));
    }

    /* renamed from: a */
    private synchronized void m24067a(int i, Throwable th, String str, Object... objArr) {
        C11057b.m24081b(str);
        log(i, m24065a(), m24066a(str, objArr), th);
    }

    /* renamed from: a */
    private String m24065a() {
        String str = this.f31519b.get();
        if (str == null) {
            return null;
        }
        this.f31519b.remove();
        return str;
    }

    /* renamed from: a */
    private String m24066a(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
