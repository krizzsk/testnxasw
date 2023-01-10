package com.didi.sdk.log;

import android.text.TextUtils;
import android.util.Log;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.sdk.log.a */
/* compiled from: LoggerPrinter */
final class C13207a implements Printer {

    /* renamed from: a */
    private static final int f39213a = 4000;

    /* renamed from: b */
    private static final int f39214b = 4;

    /* renamed from: c */
    private static final int f39215c = 3;

    /* renamed from: d */
    private static final Settings f39216d = new Settings();

    /* renamed from: e */
    private static final char f39217e = '╔';

    /* renamed from: f */
    private static final char f39218f = '╚';

    /* renamed from: g */
    private static final char f39219g = '╟';

    /* renamed from: h */
    private static final char f39220h = '║';

    /* renamed from: i */
    private static final String f39221i = "════════════════════════════════════════════";

    /* renamed from: j */
    private static final String f39222j = "────────────────────────────────────────────";

    /* renamed from: k */
    private static final String f39223k = "╔════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: l */
    private static final String f39224l = "╚════════════════════════════════════════════════════════════════════════════════════════";

    /* renamed from: m */
    private static final String f39225m = "╟────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: n */
    private static final ThreadLocal<String> f39226n = new ThreadLocal<>();

    /* renamed from: o */
    private static final ThreadLocal<Integer> f39227o = new ThreadLocal<>();

    /* renamed from: p */
    private static String f39228p = Logger.DEFAULT_TAG;

    C13207a() {
    }

    public Settings init(String str) {
        if (str == null) {
            throw new NullPointerException("tag may not be null");
        } else if (str.trim().length() != 0) {
            f39228p = str;
            return f39216d;
        } else {
            throw new IllegalStateException("tag may not be empty");
        }
    }

    public Settings getSettings() {
        return f39216d;
    }

    /* renamed from: t */
    public Printer mo98901t(String str, int i) {
        if (str != null) {
            f39226n.set(str);
        }
        f39227o.set(Integer.valueOf(i));
        return this;
    }

    /* renamed from: d */
    public void mo98893d(String str, Object... objArr) {
        m29559a(3, str, objArr);
    }

    /* renamed from: e */
    public void mo98894e(String str, Object... objArr) {
        mo98895e((Throwable) null, str, objArr);
    }

    /* renamed from: e */
    public void mo98895e(Throwable th, String str, Object... objArr) {
        if (!(th == null || str == null)) {
            str = str + " : " + th.toString();
        }
        if (th != null && str == null) {
            str = th.toString();
        }
        if (str == null) {
            str = "No message/exception is set";
        }
        m29559a(6, str, objArr);
    }

    /* renamed from: w */
    public void mo98903w(String str, Object... objArr) {
        m29559a(5, str, objArr);
    }

    /* renamed from: i */
    public void mo98897i(String str, Object... objArr) {
        m29559a(4, str, objArr);
    }

    /* renamed from: v */
    public void mo98902v(String str, Object... objArr) {
        m29559a(2, str, objArr);
    }

    public void wtf(String str, Object... objArr) {
        m29559a(7, str, objArr);
    }

    public void json(String str) {
        if (TextUtils.isEmpty(str)) {
            mo98893d("Empty/Null json content", new Object[0]);
            return;
        }
        try {
            if (str.startsWith(Const.joLeft)) {
                mo98893d(new JSONObject(str).toString(4), new Object[0]);
            } else if (str.startsWith(Const.jaLeft)) {
                mo98893d(new JSONArray(str).toString(4), new Object[0]);
            }
        } catch (JSONException e) {
            mo98894e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    public void xml(String str) {
        if (TextUtils.isEmpty(str)) {
            mo98893d("Empty/Null xml content", new Object[0]);
            return;
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            newTransformer.transform(streamSource, streamResult);
            mo98893d(streamResult.getWriter().toString().replaceFirst(IMTextUtils.STREET_IMAGE_TAG_END, ">\n"), new Object[0]);
        } catch (TransformerException e) {
            mo98894e(e.getCause().getMessage() + "\n" + str, new Object[0]);
        }
    }

    public void normalLog(String str) {
        if (!TextUtils.isEmpty(str) && f39216d.getLogLevel() != LogLevel.NONE) {
            m29563b(3, m29553a(), str);
        }
    }

    /* renamed from: a */
    private synchronized void m29559a(int i, String str, Object... objArr) {
        f39216d.getLogLevel();
        LogLevel logLevel = LogLevel.NONE;
    }

    /* renamed from: a */
    private void m29556a(int i, String str) {
        m29563b(i, str, f39223k);
    }

    /* renamed from: a */
    private void m29557a(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (f39216d.isShowThreadInfo()) {
            m29563b(i, str, "║ Thread: " + Thread.currentThread().getName());
            m29564c(i, str);
        }
        int a = m29552a(stackTrace) + f39216d.getMethodOffset();
        if (i2 + a > stackTrace.length) {
            i2 = (stackTrace.length - a) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + a;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                m29563b(i, str, "║ " + str2 + m29554a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + " " + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: b */
    private void m29562b(int i, String str) {
        m29563b(i, str, f39224l);
    }

    /* renamed from: c */
    private void m29564c(int i, String str) {
        m29563b(i, str, f39225m);
    }

    /* renamed from: a */
    private void m29558a(int i, String str, String str2) {
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m29563b(i, str, "║ " + str3);
        }
    }

    /* renamed from: b */
    private void m29563b(int i, String str, String str2) {
        String b = m29561b(str);
        if (i == 2) {
            SystemUtils.log(2, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 318);
        } else if (i == 4) {
            SystemUtils.log(4, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 315);
        } else if (i == 5) {
            SystemUtils.log(5, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 321);
        } else if (i == 6) {
            SystemUtils.log(6, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 312);
        } else if (i != 7) {
            SystemUtils.log(3, b, str2, (Throwable) null, "com.didi.sdk.log.LoggerPrinter", 329);
        } else {
            Log.wtf(b, str2);
        }
    }

    /* renamed from: a */
    private String m29554a(String str) {
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: b */
    private String m29561b(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(f39228p, str)) {
            return f39228p;
        }
        return str;
    }

    /* renamed from: a */
    private String m29553a() {
        String str = f39226n.get();
        if (str == null) {
            return f39228p;
        }
        f39226n.remove();
        return str;
    }

    /* renamed from: a */
    private String m29555a(String str, Object... objArr) {
        return objArr.length == 0 ? str : String.format(str, objArr);
    }

    /* renamed from: b */
    private int m29560b() {
        Integer num = f39227o.get();
        int methodCount = f39216d.getMethodCount();
        if (num != null) {
            f39227o.remove();
            methodCount = num.intValue();
        }
        if (methodCount >= 0) {
            return methodCount;
        }
        throw new IllegalStateException("methodCount cannot be negative");
    }

    /* renamed from: a */
    private int m29552a(StackTraceElement[] stackTraceElementArr) {
        for (int i = 3; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(C13207a.class.getName()) && !className.equals(Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }
}
