package com.p226hp.hpl.sparta;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.p226hp.hpl.sparta.Sparta;
import com.p226hp.hpl.sparta.xpath.Step;
import com.p226hp.hpl.sparta.xpath.XPath;
import com.p226hp.hpl.sparta.xpath.XPathException;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.Document */
public class Document extends Node {

    /* renamed from: a */
    static final Enumeration f56704a = new C20731e();

    /* renamed from: b */
    private static final boolean f56705b = false;

    /* renamed from: c */
    private static final Integer f56706c = new Integer(1);

    /* renamed from: d */
    private Element f56707d;

    /* renamed from: e */
    private String f56708e;

    /* renamed from: f */
    private Sparta.Cache f56709f;

    /* renamed from: g */
    private Vector f56710g;

    /* renamed from: h */
    private final Hashtable f56711h;

    /* renamed from: com.hp.hpl.sparta.Document$Observer */
    public interface Observer {
        void update(Document document);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171098a(XPath xPath) throws XPathException {
    }

    Document(String str) {
        this.f56707d = null;
        this.f56709f = Sparta.m42738a();
        this.f56710g = new Vector();
        this.f56711h = null;
        this.f56708e = str;
    }

    public Document() {
        this.f56707d = null;
        this.f56709f = Sparta.m42738a();
        this.f56710g = new Vector();
        this.f56711h = null;
        this.f56708e = "MEMORY";
    }

    public Object clone() {
        Document document = new Document(this.f56708e);
        document.f56707d = (Element) this.f56707d.clone();
        return document;
    }

    public String getSystemId() {
        return this.f56708e;
    }

    public void setSystemId(String str) {
        this.f56708e = str;
        mo171097a();
    }

    public String toString() {
        return this.f56708e;
    }

    public Element getDocumentElement() {
        return this.f56707d;
    }

    public void setDocumentElement(Element element) {
        this.f56707d = element;
        element.mo171141a(this);
        mo171097a();
    }

    /* renamed from: a */
    private XPathVisitor m42721a(String str, boolean z) throws XPathException {
        if (str.charAt(0) != '/') {
            str = "/" + str;
        }
        return mo171096a(XPath.get(str), z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public XPathVisitor mo171096a(XPath xPath, boolean z) throws XPathException {
        if (xPath.isStringValue() == z) {
            return new XPathVisitor(this, xPath);
        }
        String str = z ? "evaluates to element not string" : "evaluates to string not element";
        throw new XPathException(xPath, Const.jsQuote + xPath + "\" evaluates to " + str);
    }

    public Enumeration xpathSelectElements(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath xPath = XPath.get(str);
            mo171098a(xPath);
            return mo171096a(xPath, false).mo171184a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Enumeration xpathSelectStrings(String str) throws ParseException {
        try {
            return m42721a(str, true).mo171184a();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public Element xpathSelectElement(String str) throws ParseException {
        try {
            if (str.charAt(0) != '/') {
                str = "/" + str;
            }
            XPath xPath = XPath.get(str);
            mo171098a(xPath);
            return mo171096a(xPath, false).mo171185b();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public String xpathSelectString(String str) throws ParseException {
        try {
            return m42721a(str, true).mo171186c();
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public boolean xpathEnsure(String str) throws ParseException {
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
            Enumeration steps2 = xPath.getSteps();
            Step step = (Step) steps2.nextElement();
            int i2 = i - 1;
            Step[] stepArr = new Step[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                stepArr[i3] = (Step) steps2.nextElement();
            }
            if (this.f56707d == null) {
                setDocumentElement(mo171140a((Element) null, step, str));
            } else {
                if (xpathSelectElement("/" + step) == null) {
                    throw new ParseException("Existing root element <" + this.f56707d.getTagName() + "...> does not match first step \"" + step + "\" of \"" + str);
                }
            }
            if (i2 == 0) {
                return true;
            }
            return this.f56707d.xpathEnsure(XPath.get(false, stepArr).toString());
        } catch (XPathException e) {
            throw new ParseException(str, (Throwable) e);
        }
    }

    /* renamed from: com.hp.hpl.sparta.Document$Index */
    public class Index implements Observer {
        private final String attrName_;
        private transient Sparta.Cache dict_ = null;
        private final XPath xpath_;

        Index(XPath xPath) throws XPathException {
            this.attrName_ = xPath.getIndexingAttrName();
            this.xpath_ = xPath;
            Document.this.addObserver(this);
        }

        public synchronized Enumeration get(String str) throws ParseException {
            Vector vector;
            if (this.dict_ == null) {
                regenerate();
            }
            vector = (Vector) this.dict_.get(str);
            return vector == null ? Document.f56704a : vector.elements();
        }

        public synchronized int size() throws ParseException {
            if (this.dict_ == null) {
                regenerate();
            }
            return this.dict_.size();
        }

        public synchronized void update(Document document) {
            this.dict_ = null;
        }

        private void regenerate() throws ParseException {
            try {
                this.dict_ = Sparta.m42738a();
                Enumeration a = Document.this.mo171096a(this.xpath_, false).mo171184a();
                while (a.hasMoreElements()) {
                    Element element = (Element) a.nextElement();
                    String attribute = element.getAttribute(this.attrName_);
                    Vector vector = (Vector) this.dict_.get(attribute);
                    if (vector == null) {
                        vector = new Vector(1);
                        this.dict_.put(attribute, vector);
                    }
                    vector.addElement(element);
                }
            } catch (XPathException e) {
                throw new ParseException("XPath problem", (Throwable) e);
            }
        }
    }

    public boolean xpathHasIndex(String str) {
        return this.f56709f.get(str) != null;
    }

    public Index xpathGetIndex(String str) throws ParseException {
        try {
            Index index = (Index) this.f56709f.get(str);
            if (index != null) {
                return index;
            }
            Index index2 = new Index(XPath.get(str));
            this.f56709f.put(str, index2);
            return index2;
        } catch (XPathException e) {
            throw new ParseException("XPath problem", (Throwable) e);
        }
    }

    public void addObserver(Observer observer) {
        this.f56710g.addElement(observer);
    }

    public void deleteObserver(Observer observer) {
        this.f56710g.removeElement(observer);
    }

    public void toString(Writer writer) throws IOException {
        this.f56707d.toString(writer);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171097a() {
        Enumeration elements = this.f56710g.elements();
        while (elements.hasMoreElements()) {
            ((Observer) elements.nextElement()).update(this);
        }
    }

    public void toXml(Writer writer) throws IOException {
        writer.write("<?xml version=\"1.0\" ?>\n");
        this.f56707d.toXml(writer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Document)) {
            return false;
        }
        return this.f56707d.equals(((Document) obj).f56707d);
    }

    /* access modifiers changed from: protected */
    public int computeHashCode() {
        return this.f56707d.hashCode();
    }
}
