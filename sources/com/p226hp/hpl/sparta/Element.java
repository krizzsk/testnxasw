package com.p226hp.hpl.sparta;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.p226hp.hpl.sparta.xpath.Step;
import com.p226hp.hpl.sparta.xpath.XPath;
import com.p226hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.Element */
public class Element extends Node {

    /* renamed from: a */
    private static final boolean f56712a = false;

    /* renamed from: b */
    private Node f56713b = null;

    /* renamed from: c */
    private Node f56714c = null;

    /* renamed from: d */
    private Hashtable f56715d = null;

    /* renamed from: e */
    private Vector f56716e = null;

    /* renamed from: f */
    private String f56717f = null;

    /* renamed from: c */
    private void m42727c() {
    }

    public Element(String str) {
        this.f56717f = Sparta.intern(str);
    }

    Element() {
    }

    public Object clone() {
        return cloneElement(true);
    }

    public Element cloneShallow() {
        return cloneElement(false);
    }

    public Element cloneElement(boolean z) {
        Element element = new Element(this.f56717f);
        Vector vector = this.f56716e;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                element.setAttribute(str, (String) this.f56715d.get(str));
            }
        }
        if (z) {
            for (Node node = this.f56713b; node != null; node = node.getNextSibling()) {
                element.appendChild((Node) node.clone());
            }
        }
        return element;
    }

    public String getTagName() {
        return this.f56717f;
    }

    public void setTagName(String str) {
        this.f56717f = Sparta.intern(str);
        mo171097a();
    }

    public Node getFirstChild() {
        return this.f56713b;
    }

    public Node getLastChild() {
        return this.f56714c;
    }

    public Enumeration getAttributeNames() {
        Vector vector = this.f56716e;
        if (vector == null) {
            return Document.f56704a;
        }
        return vector.elements();
    }

    public String getAttribute(String str) {
        Hashtable hashtable = this.f56715d;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public void setAttribute(String str, String str2) {
        if (this.f56715d == null) {
            this.f56715d = new Hashtable();
            this.f56716e = new Vector();
        }
        if (this.f56715d.get(str) == null) {
            this.f56716e.addElement(str);
        }
        this.f56715d.put(str, str2);
        mo171097a();
    }

    public void removeAttribute(String str) {
        Hashtable hashtable = this.f56715d;
        if (hashtable != null) {
            hashtable.remove(str);
            this.f56716e.removeElement(str);
            mo171097a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171121a(Node node) {
        Element parentNode = node.getParentNode();
        if (parentNode != null) {
            parentNode.m42728e(node);
        }
        node.mo171144c(this.f56714c);
        if (this.f56713b == null) {
            this.f56713b = node;
        }
        node.mo171142a(this);
        this.f56714c = node;
        node.mo171141a(getOwnerDocument());
    }

    public void appendChild(Node node) {
        if (!mo171123b(node)) {
            node = (Element) node.clone();
        }
        mo171121a(node);
        mo171097a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo171123b(Node node) {
        if (node == this) {
            return false;
        }
        Element parentNode = getParentNode();
        if (parentNode == null) {
            return true;
        }
        return parentNode.mo171123b(node);
    }

    /* renamed from: e */
    private boolean m42728e(Node node) {
        for (Node node2 = this.f56713b; node2 != null; node2 = node2.getNextSibling()) {
            if (node2.equals(node)) {
                if (this.f56713b == node2) {
                    this.f56713b = node2.getNextSibling();
                }
                if (this.f56714c == node2) {
                    this.f56714c = node2.getPreviousSibling();
                }
                node2.mo171143b();
                node2.mo171142a((Element) null);
                node2.mo171141a((Document) null);
                return true;
            }
        }
        return false;
    }

    public void removeChild(Node node) throws DOMException {
        if (m42728e(node)) {
            mo171097a();
            return;
        }
        throw new DOMException(8, "Cannot find " + node + " in " + this);
    }

    public void replaceChild(Element element, Node node) throws DOMException {
        m42726a((Node) element, node);
        mo171097a();
    }

    public void replaceChild(Text text, Node node) throws DOMException {
        m42726a((Node) text, node);
        mo171097a();
    }

    /* renamed from: a */
    private void m42726a(Node node, Node node2) throws DOMException {
        for (Node node3 = this.f56713b; node3 != null; node3 = node3.getNextSibling()) {
            if (node3 == node2) {
                if (this.f56713b == node2) {
                    this.f56713b = node;
                }
                if (this.f56714c == node2) {
                    this.f56714c = node;
                }
                node2.mo171145d(node);
                node.mo171142a(this);
                node2.mo171142a((Element) null);
                return;
            }
        }
        throw new DOMException(8, "Cannot find " + node2 + " in " + this);
    }

    /* access modifiers changed from: package-private */
    public void toString(Writer writer) throws IOException {
        for (Node node = this.f56713b; node != null; node = node.getNextSibling()) {
            node.toString(writer);
        }
    }

    public void toXml(Writer writer) throws IOException {
        writer.write(IMTextUtils.STREET_IMAGE_TAG_START + this.f56717f);
        Vector vector = this.f56716e;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                writer.write(" " + str + "=\"");
                htmlEncode(writer, (String) this.f56715d.get(str));
                writer.write(Const.jsQuote);
            }
        }
        if (this.f56713b == null) {
            writer.write("/>");
            return;
        }
        writer.write(IMTextUtils.STREET_IMAGE_TAG_END);
        for (Node node = this.f56713b; node != null; node = node.getNextSibling()) {
            node.toXml(writer);
        }
        writer.write("</" + this.f56717f + IMTextUtils.STREET_IMAGE_TAG_END);
    }

    /* renamed from: a */
    private XPathVisitor m42725a(String str, boolean z) throws XPathException {
        XPath xPath = XPath.get(str);
        if (xPath.isStringValue() == z) {
            return new XPathVisitor(this, xPath);
        }
        String str2 = z ? "evaluates to element not string" : "evaluates to string not element";
        throw new XPathException(xPath, Const.jsQuote + xPath + "\" evaluates to " + str2);
    }

    public Enumeration xpathSelectElements(String str) throws ParseException {
        try {
            return m42725a(str, false).mo171184a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Enumeration xpathSelectStrings(String str) throws ParseException {
        try {
            return m42725a(str, true).mo171184a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean xpathEnsure(String str) throws ParseException {
        Element element;
        try {
            if (xpathSelectElement(str) != null) {
                return false;
            }
            XPath xPath = XPath.get(str);
            Enumeration steps = xPath.getSteps();
            int i = 0;
            while (steps.hasMoreElements()) {
                steps.nextElement();
                i++;
            }
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            Enumeration steps2 = xPath.getSteps();
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) steps2.nextElement();
            }
            Step step = (Step) steps2.nextElement();
            if (i2 == 0) {
                element = this;
            } else {
                String xPath2 = XPath.get(xPath.isAbsolute(), stepArr).toString();
                xpathEnsure(xPath2.toString());
                element = xpathSelectElement(xPath2);
            }
            element.mo171121a(mo171140a(element, step, str));
            return true;
        } catch (XPathException e) {
            throw new ParseException(str, (Throwable) e);
        }
    }

    public Element xpathSelectElement(String str) throws ParseException {
        try {
            return m42725a(str, false).mo171185b();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public String xpathSelectString(String str) throws ParseException {
        try {
            return m42725a(str, true).mo171186c();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Element)) {
            return false;
        }
        Element element = (Element) obj;
        if (!this.f56717f.equals(element.f56717f)) {
            return false;
        }
        Hashtable hashtable = this.f56715d;
        int size = hashtable == null ? 0 : hashtable.size();
        Hashtable hashtable2 = element.f56715d;
        if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
            return false;
        }
        Hashtable hashtable3 = this.f56715d;
        if (hashtable3 != null) {
            Enumeration keys = hashtable3.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                if (!((String) this.f56715d.get(str)).equals((String) element.f56715d.get(str))) {
                    return false;
                }
            }
        }
        Node node = this.f56713b;
        Node node2 = element.f56713b;
        while (node != null) {
            if (!node.equals(node2)) {
                return false;
            }
            node = node.getNextSibling();
            node2 = node2.getNextSibling();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public int computeHashCode() {
        int hashCode = this.f56717f.hashCode();
        Hashtable hashtable = this.f56715d;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f56715d.get(str)).hashCode();
            }
        }
        for (Node node = this.f56713b; node != null; node = node.getNextSibling()) {
            hashCode = (hashCode * 31) + node.hashCode();
        }
        return hashCode;
    }
}
