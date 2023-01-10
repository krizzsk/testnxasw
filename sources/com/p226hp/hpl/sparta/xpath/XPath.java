package com.p226hp.hpl.sparta.xpath;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import org.apache.commons.p074io.IOUtils;

/* renamed from: com.hp.hpl.sparta.xpath.XPath */
public class XPath {

    /* renamed from: a */
    private static final int f56826a = 0;

    /* renamed from: e */
    private static Hashtable f56827e = new Hashtable();

    /* renamed from: b */
    private Stack f56828b;

    /* renamed from: c */
    private boolean f56829c;

    /* renamed from: d */
    private String f56830d;

    private XPath(boolean z, Step[] stepArr) {
        this.f56828b = new Stack();
        for (Step addElement : stepArr) {
            this.f56828b.addElement(addElement);
        }
        this.f56829c = z;
        this.f56830d = null;
    }

    private XPath(String str) throws XPathException {
        this(str, (Reader) new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004b A[Catch:{ IOException -> 0x0072 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[Catch:{ IOException -> 0x0072 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[Catch:{ IOException -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private XPath(java.lang.String r6, java.io.Reader r7) throws com.p226hp.hpl.sparta.xpath.XPathException {
        /*
            r5 = this;
            r5.<init>()
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r5.f56828b = r0
            r5.f56830d = r6     // Catch:{ IOException -> 0x0072 }
            com.hp.hpl.sparta.xpath.SimpleStreamTokenizer r6 = new com.hp.hpl.sparta.xpath.SimpleStreamTokenizer     // Catch:{ IOException -> 0x0072 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0072 }
            r7 = 47
            r6.ordinaryChar(r7)     // Catch:{ IOException -> 0x0072 }
            r0 = 46
            r6.ordinaryChar(r0)     // Catch:{ IOException -> 0x0072 }
            r0 = 58
            r6.wordChars(r0, r0)     // Catch:{ IOException -> 0x0072 }
            r0 = 95
            r6.wordChars(r0, r0)     // Catch:{ IOException -> 0x0072 }
            int r0 = r6.nextToken()     // Catch:{ IOException -> 0x0072 }
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L_0x003a
            r5.f56829c = r1     // Catch:{ IOException -> 0x0072 }
            int r0 = r6.nextToken()     // Catch:{ IOException -> 0x0072 }
            if (r0 != r7) goto L_0x003c
            r6.nextToken()     // Catch:{ IOException -> 0x0072 }
            r0 = 1
            goto L_0x003d
        L_0x003a:
            r5.f56829c = r2     // Catch:{ IOException -> 0x0072 }
        L_0x003c:
            r0 = 0
        L_0x003d:
            java.util.Stack r3 = r5.f56828b     // Catch:{ IOException -> 0x0072 }
            com.hp.hpl.sparta.xpath.Step r4 = new com.hp.hpl.sparta.xpath.Step     // Catch:{ IOException -> 0x0072 }
            r4.<init>(r5, r0, r6)     // Catch:{ IOException -> 0x0072 }
            r3.push(r4)     // Catch:{ IOException -> 0x0072 }
        L_0x0047:
            int r0 = r6.ttype     // Catch:{ IOException -> 0x0072 }
            if (r0 != r7) goto L_0x0062
            int r0 = r6.nextToken()     // Catch:{ IOException -> 0x0072 }
            if (r0 != r7) goto L_0x0056
            r6.nextToken()     // Catch:{ IOException -> 0x0072 }
            r0 = 1
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            java.util.Stack r3 = r5.f56828b     // Catch:{ IOException -> 0x0072 }
            com.hp.hpl.sparta.xpath.Step r4 = new com.hp.hpl.sparta.xpath.Step     // Catch:{ IOException -> 0x0072 }
            r4.<init>(r5, r0, r6)     // Catch:{ IOException -> 0x0072 }
            r3.push(r4)     // Catch:{ IOException -> 0x0072 }
            goto L_0x0047
        L_0x0062:
            int r7 = r6.ttype     // Catch:{ IOException -> 0x0072 }
            r0 = -1
            if (r7 != r0) goto L_0x0068
            return
        L_0x0068:
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException     // Catch:{ IOException -> 0x0072 }
            java.lang.String r0 = "at end of XPATH expression"
            java.lang.String r1 = "end of expression"
            r7.<init>(r5, r0, r6, r1)     // Catch:{ IOException -> 0x0072 }
            throw r7     // Catch:{ IOException -> 0x0072 }
        L_0x0072:
            r6 = move-exception
            com.hp.hpl.sparta.xpath.XPathException r7 = new com.hp.hpl.sparta.xpath.XPathException
            r7.<init>((com.p226hp.hpl.sparta.xpath.XPath) r5, (java.lang.Exception) r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p226hp.hpl.sparta.xpath.XPath.<init>(java.lang.String, java.io.Reader):void");
    }

    public String toString() {
        if (this.f56830d == null) {
            this.f56830d = m42834a();
        }
        return this.f56830d;
    }

    /* renamed from: a */
    private String m42834a() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f56828b.elements();
        boolean z = true;
        while (elements.hasMoreElements()) {
            Step step = (Step) elements.nextElement();
            if (!z || this.f56829c) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                if (step.isMultiLevel()) {
                    stringBuffer.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
            }
            stringBuffer.append(step.toString());
            z = false;
        }
        return stringBuffer.toString();
    }

    public boolean isAbsolute() {
        return this.f56829c;
    }

    public boolean isStringValue() {
        return ((Step) this.f56828b.peek()).isStringValue();
    }

    public Enumeration getSteps() {
        return this.f56828b.elements();
    }

    public String getIndexingAttrName() throws XPathException {
        BooleanExpr predicate = ((Step) this.f56828b.peek()).getPredicate();
        if (predicate instanceof AttrExistsExpr) {
            return ((AttrExistsExpr) predicate).getAttrName();
        }
        throw new XPathException(this, "has no indexing attribute name (must end with predicate of the form [@attrName]");
    }

    public String getIndexingAttrNameOfEquals() throws XPathException {
        BooleanExpr predicate = ((Step) this.f56828b.peek()).getPredicate();
        if (predicate instanceof AttrEqualsExpr) {
            return ((AttrEqualsExpr) predicate).getAttrName();
        }
        return null;
    }

    public Object clone() {
        int size = this.f56828b.size();
        Step[] stepArr = new Step[size];
        Enumeration elements = this.f56828b.elements();
        for (int i = 0; i < size; i++) {
            stepArr[i] = (Step) elements.nextElement();
        }
        return new XPath(this.f56829c, stepArr);
    }

    public static XPath get(String str) throws XPathException {
        XPath xPath;
        synchronized (f56827e) {
            xPath = (XPath) f56827e.get(str);
            if (xPath == null) {
                xPath = new XPath(str);
                f56827e.put(str, xPath);
            }
        }
        return xPath;
    }

    public static XPath get(boolean z, Step[] stepArr) {
        XPath xPath = new XPath(z, stepArr);
        String xPath2 = xPath.toString();
        synchronized (f56827e) {
            XPath xPath3 = (XPath) f56827e.get(xPath2);
            if (xPath3 != null) {
                return xPath3;
            }
            f56827e.put(xPath2, xPath);
            return xPath;
        }
    }

    public static boolean isStringValue(String str) throws XPathException, IOException {
        return get(str).isStringValue();
    }
}
