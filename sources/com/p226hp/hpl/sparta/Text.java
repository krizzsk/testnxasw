package com.p226hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/* renamed from: com.hp.hpl.sparta.Text */
public class Text extends Node {

    /* renamed from: a */
    private StringBuffer f56726a;

    public Text(String str) {
        this.f56726a = new StringBuffer(str);
    }

    public Text(char c) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f56726a = stringBuffer;
        stringBuffer.append(c);
    }

    public Object clone() {
        return new Text(this.f56726a.toString());
    }

    public void appendData(String str) {
        this.f56726a.append(str);
        mo171097a();
    }

    public void appendData(char c) {
        this.f56726a.append(c);
        mo171097a();
    }

    public void appendData(char[] cArr, int i, int i2) {
        this.f56726a.append(cArr, i, i2);
        mo171097a();
    }

    public String getData() {
        return this.f56726a.toString();
    }

    public void setData(String str) {
        this.f56726a = new StringBuffer(str);
        mo171097a();
    }

    /* access modifiers changed from: package-private */
    public void toXml(Writer writer) throws IOException {
        String stringBuffer = this.f56726a.toString();
        if (stringBuffer.length() < 50) {
            htmlEncode(writer, stringBuffer);
            return;
        }
        writer.write("<![CDATA[");
        writer.write(stringBuffer);
        writer.write("]]>");
    }

    /* access modifiers changed from: package-private */
    public void toString(Writer writer) throws IOException {
        writer.write(this.f56726a.toString());
    }

    public Enumeration xpathSelectElements(String str) {
        throw new Error("Sorry, not implemented");
    }

    public Enumeration xpathSelectStrings(String str) {
        throw new Error("Sorry, not implemented");
    }

    public Element xpathSelectElement(String str) {
        throw new Error("Sorry, not implemented");
    }

    public String xpathSelectString(String str) {
        throw new Error("Sorry, not implemented");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Text)) {
            return false;
        }
        return this.f56726a.toString().equals(((Text) obj).f56726a.toString());
    }

    /* access modifiers changed from: protected */
    public int computeHashCode() {
        return this.f56726a.toString().hashCode();
    }
}
