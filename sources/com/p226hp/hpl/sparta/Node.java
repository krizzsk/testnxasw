package com.p226hp.hpl.sparta;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.p226hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.p226hp.hpl.sparta.xpath.AttrExistsExpr;
import com.p226hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.p226hp.hpl.sparta.xpath.AttrLessExpr;
import com.p226hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.p226hp.hpl.sparta.xpath.BooleanExprVisitor;
import com.p226hp.hpl.sparta.xpath.ElementTest;
import com.p226hp.hpl.sparta.xpath.NodeTest;
import com.p226hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.p226hp.hpl.sparta.xpath.Step;
import com.p226hp.hpl.sparta.xpath.TextEqualsExpr;
import com.p226hp.hpl.sparta.xpath.TextExistsExpr;
import com.p226hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.p226hp.hpl.sparta.xpath.TrueExpr;
import com.p226hp.hpl.sparta.xpath.XPath;
import com.p226hp.hpl.sparta.xpath.XPathException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.Node */
public abstract class Node {

    /* renamed from: a */
    private Document f56718a = null;

    /* renamed from: b */
    private Element f56719b = null;

    /* renamed from: c */
    private Node f56720c = null;

    /* renamed from: d */
    private Node f56721d = null;

    /* renamed from: e */
    private Object f56722e = null;

    /* renamed from: f */
    private int f56723f = 0;

    public abstract Object clone();

    /* access modifiers changed from: protected */
    public abstract int computeHashCode();

    /* access modifiers changed from: package-private */
    public abstract void toString(Writer writer) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void toXml(Writer writer) throws IOException;

    public abstract Element xpathSelectElement(String str) throws ParseException;

    public abstract Enumeration xpathSelectElements(String str) throws ParseException;

    public abstract String xpathSelectString(String str) throws ParseException;

    public abstract Enumeration xpathSelectStrings(String str) throws ParseException;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171097a() {
        this.f56723f = 0;
        Document document = this.f56718a;
        if (document != null) {
            document.mo171097a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171141a(Document document) {
        this.f56718a = document;
    }

    public Document getOwnerDocument() {
        return this.f56718a;
    }

    public Element getParentNode() {
        return this.f56719b;
    }

    public Node getPreviousSibling() {
        return this.f56720c;
    }

    public Node getNextSibling() {
        return this.f56721d;
    }

    public Object getAnnotation() {
        return this.f56722e;
    }

    public void setAnnotation(Object obj) {
        this.f56722e = obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171142a(Element element) {
        this.f56719b = element;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo171144c(Node node) {
        this.f56720c = node;
        if (node != null) {
            node.f56721d = this;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171143b() {
        Node node = this.f56720c;
        if (node != null) {
            node.f56721d = this.f56721d;
        }
        Node node2 = this.f56721d;
        if (node2 != null) {
            node2.f56720c = this.f56720c;
        }
        this.f56721d = null;
        this.f56720c = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo171145d(Node node) {
        Node node2 = this.f56720c;
        if (node2 != null) {
            node2.f56721d = node;
        }
        Node node3 = this.f56721d;
        if (node3 != null) {
            node3.f56720c = node;
        }
        node.f56721d = this.f56721d;
        node.f56720c = this.f56720c;
        this.f56721d = null;
        this.f56720c = null;
    }

    public String toXml() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        toXml(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public boolean xpathSetStrings(String str, String str2) throws ParseException {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int i = lastIndexOf + 1;
            if (!str.substring(i).equals("text()")) {
                if (str.charAt(i) != '@') {
                    throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i) + "'");
                }
            }
            boolean z = false;
            String substring = str.substring(0, lastIndexOf);
            if (str.charAt(i) == '@') {
                String substring2 = str.substring(lastIndexOf + 2);
                if (substring2.length() != 0) {
                    Enumeration xpathSelectElements = xpathSelectElements(substring);
                    while (xpathSelectElements.hasMoreElements()) {
                        Element element = (Element) xpathSelectElements.nextElement();
                        if (!str2.equals(element.getAttribute(substring2))) {
                            element.setAttribute(substring2, str2);
                            z = true;
                        }
                    }
                    return z;
                }
                throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
            }
            Enumeration xpathSelectElements2 = xpathSelectElements(substring);
            boolean hasMoreElements = xpathSelectElements2.hasMoreElements();
            while (xpathSelectElements2.hasMoreElements()) {
                Element element2 = (Element) xpathSelectElements2.nextElement();
                Vector vector = new Vector();
                for (Node firstChild = element2.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    if (firstChild instanceof Text) {
                        vector.addElement((Text) firstChild);
                    }
                }
                if (vector.size() == 0) {
                    Text text = new Text(str2);
                    if (text.getData().length() > 0) {
                        element2.appendChild(text);
                        hasMoreElements = true;
                    }
                } else {
                    Text text2 = (Text) vector.elementAt(0);
                    if (!text2.getData().equals(str2)) {
                        vector.removeElementAt(0);
                        text2.setData(str2);
                        hasMoreElements = true;
                    }
                    int i2 = 0;
                    while (i2 < vector.size()) {
                        element2.removeChild((Text) vector.elementAt(i2));
                        i2++;
                        hasMoreElements = true;
                    }
                }
            }
            return hasMoreElements;
        } catch (DOMException e) {
            throw new Error("Assertion failed " + e);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Element mo171140a(Element element, Step step, String str) throws ParseException, XPathException {
        NodeTest nodeTest = step.getNodeTest();
        if (nodeTest instanceof ElementTest) {
            final String tagName = ((ElementTest) nodeTest).getTagName();
            Element element2 = new Element(tagName);
            final Element element3 = element2;
            final Element element4 = element;
            final String str2 = str;
            step.getPredicate().accept(new BooleanExprVisitor() {
                public void visit(TrueExpr trueExpr) {
                }

                public void visit(AttrExistsExpr attrExistsExpr) throws XPathException {
                    element3.setAttribute(attrExistsExpr.getAttrName(), "something");
                }

                public void visit(AttrEqualsExpr attrEqualsExpr) throws XPathException {
                    element3.setAttribute(attrEqualsExpr.getAttrName(), attrEqualsExpr.getAttrValue());
                }

                public void visit(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
                    Element element = element3;
                    String attrName = attrNotEqualsExpr.getAttrName();
                    element.setAttribute(attrName, "not " + attrNotEqualsExpr.getAttrValue());
                }

                public void visit(AttrLessExpr attrLessExpr) throws XPathException {
                    element3.setAttribute(attrLessExpr.getAttrName(), Long.toString(Long.MIN_VALUE));
                }

                public void visit(AttrGreaterExpr attrGreaterExpr) throws XPathException {
                    element3.setAttribute(attrGreaterExpr.getAttrName(), Long.toString(Long.MAX_VALUE));
                }

                public void visit(TextExistsExpr textExistsExpr) throws XPathException {
                    element3.appendChild(new Text("something"));
                }

                public void visit(TextEqualsExpr textEqualsExpr) throws XPathException {
                    element3.appendChild(new Text(textEqualsExpr.getValue()));
                }

                public void visit(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
                    Element element = element3;
                    element.appendChild(new Text("not " + textNotEqualsExpr.getValue()));
                }

                public void visit(PositionEqualsExpr positionEqualsExpr) throws XPathException {
                    int position = positionEqualsExpr.getPosition();
                    if (element4 != null || position == 1) {
                        for (int i = 1; i < position; i++) {
                            element4.appendChild(new Element(tagName));
                        }
                        return;
                    }
                    throw new XPathException(XPath.get(str2), "Position of root node must be 1");
                }
            });
            return element2;
        }
        throw new ParseException(Const.jsQuote + nodeTest + "\" in \"" + str + "\" is not an element test");
    }

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            toString(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    protected static void htmlEncode(Writer writer, String str) throws IOException {
        String str2;
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 128) {
                str2 = "&#" + charAt + ";";
            } else {
                str2 = charAt != '\"' ? charAt != '<' ? charAt != '>' ? charAt != '&' ? charAt != '\'' ? null : "&#39;" : "&amp;" : "&gt;" : "&lt;" : "&quot;";
            }
            if (str2 != null) {
                writer.write(str, i, i2 - i);
                writer.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            writer.write(str, i, length - i);
        }
    }

    public int hashCode() {
        if (this.f56723f == 0) {
            this.f56723f = computeHashCode();
        }
        return this.f56723f;
    }
}
