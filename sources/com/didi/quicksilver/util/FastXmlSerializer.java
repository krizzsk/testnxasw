package com.didi.quicksilver.util;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;

public class FastXmlSerializer implements XmlSerializer {

    /* renamed from: a */
    private static final String[] f35825a = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: b */
    private static final int f35826b = 8192;

    /* renamed from: c */
    private static String f35827c = "                                                              ";

    /* renamed from: d */
    private final char[] f35828d = new char[8192];

    /* renamed from: e */
    private int f35829e;

    /* renamed from: f */
    private Writer f35830f;

    /* renamed from: g */
    private OutputStream f35831g;

    /* renamed from: h */
    private CharsetEncoder f35832h;

    /* renamed from: i */
    private ByteBuffer f35833i = ByteBuffer.allocate(8192);

    /* renamed from: j */
    private boolean f35834j = false;

    /* renamed from: k */
    private boolean f35835k;

    /* renamed from: l */
    private int f35836l = 0;

    /* renamed from: m */
    private boolean f35837m = true;

    /* renamed from: a */
    private void m26988a(char c) throws IOException {
        int i = this.f35829e;
        if (i >= 8191) {
            flush();
            i = this.f35829e;
        }
        this.f35828d[i] = c;
        this.f35829e = i + 1;
    }

    /* renamed from: a */
    private void m26991a(String str, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m26991a(str, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f35829e;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f35829e;
        }
        str.getChars(i, i + i2, this.f35828d, i5);
        this.f35829e = i5 + i2;
    }

    /* renamed from: a */
    private void m26992a(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 8192) {
            int i3 = i2 + i;
            while (i < i3) {
                int i4 = i + 8192;
                m26992a(cArr, i, i4 < i3 ? 8192 : i3 - i);
                i = i4;
            }
            return;
        }
        int i5 = this.f35829e;
        if (i5 + i2 > 8192) {
            flush();
            i5 = this.f35829e;
        }
        System.arraycopy(cArr, i, this.f35828d, i5, i2);
        this.f35829e = i5 + i2;
    }

    /* renamed from: a */
    private void m26990a(String str) throws IOException {
        m26991a(str, 0, str.length());
    }

    /* renamed from: a */
    private void m26989a(int i) throws IOException {
        int i2 = i * 4;
        if (i2 > f35827c.length()) {
            i2 = f35827c.length();
        }
        m26991a(f35827c, 0, i2);
    }

    /* renamed from: b */
    private void m26993b(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f35825a;
        char length2 = (char) strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i2 < i) {
                    m26991a(str, i2, i - i2);
                }
                i2 = i + 1;
                m26990a(str2);
            }
            i++;
        }
        if (i2 < i) {
            m26991a(str, i2, i - i2);
        }
    }

    /* renamed from: b */
    private void m26994b(char[] cArr, int i, int i2) throws IOException {
        String str;
        String[] strArr = f35825a;
        char length = (char) strArr.length;
        int i3 = i2 + i;
        int i4 = i;
        while (i < i3) {
            char c = cArr[i];
            if (c < length && (str = strArr[c]) != null) {
                if (i4 < i) {
                    m26992a(cArr, i4, i - i4);
                }
                i4 = i + 1;
                m26990a(str);
            }
            i++;
        }
        if (i4 < i) {
            m26992a(cArr, i4, i - i4);
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        m26988a(' ');
        if (str != null) {
            m26990a(str);
            m26988a(':');
        }
        m26990a(str2);
        m26990a("=\"");
        m26993b(str3);
        m26988a((char) Typography.quote);
        this.f35837m = false;
        return this;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        int i = this.f35836l - 1;
        this.f35836l = i;
        if (this.f35835k) {
            m26990a(" />\n");
        } else {
            if (this.f35834j && this.f35837m) {
                m26989a(i);
            }
            m26990a("</");
            if (str != null) {
                m26990a(str);
                m26988a(':');
            }
            m26990a(str2);
            m26990a(">\n");
        }
        this.f35837m = true;
        this.f35835k = false;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    private void m26987a() throws IOException {
        int position = this.f35833i.position();
        if (position > 0) {
            this.f35833i.flip();
            this.f35831g.write(this.f35833i.array(), 0, position);
            this.f35833i.clear();
        }
    }

    public void flush() throws IOException {
        int i = this.f35829e;
        if (i > 0) {
            if (this.f35831g != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f35828d, 0, i);
                CoderResult encode = this.f35832h.encode(wrap, this.f35833i, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        m26987a();
                        encode = this.f35832h.encode(wrap, this.f35833i, true);
                    } else {
                        m26987a();
                        this.f35831g.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f35830f.write(this.f35828d, 0, i);
            this.f35830f.flush();
            this.f35829e = 0;
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        if (str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            this.f35834j = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f35832h = Charset.forName(str).newEncoder();
                this.f35831g = outputStream;
            } catch (IllegalCharsetNameException e) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
            } catch (UnsupportedCharsetException e2) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f35830f = writer;
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb.append(bool.booleanValue() ? "yes" : "no");
        sb.append("' ?>\n");
        m26990a(sb.toString());
        this.f35837m = true;
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f35835k) {
            m26990a(">\n");
        }
        if (this.f35834j) {
            m26989a(this.f35836l);
        }
        this.f35836l++;
        m26988a((char) Typography.less);
        if (str != null) {
            m26990a(str);
            m26988a(':');
        }
        m26990a(str2);
        this.f35835k = true;
        this.f35837m = false;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f35835k) {
            m26990a(IMTextUtils.STREET_IMAGE_TAG_END);
            this.f35835k = false;
        }
        m26994b(cArr, i, i2);
        if (this.f35834j) {
            if (cArr[(i + i2) - 1] == 10) {
                z = true;
            }
            this.f35837m = z;
        }
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        boolean z = false;
        if (this.f35835k) {
            m26990a(IMTextUtils.STREET_IMAGE_TAG_END);
            this.f35835k = false;
        }
        m26993b(str);
        if (this.f35834j) {
            if (str.length() > 0 && str.charAt(str.length() - 1) == 10) {
                z = true;
            }
            this.f35837m = z;
        }
        return this;
    }
}
