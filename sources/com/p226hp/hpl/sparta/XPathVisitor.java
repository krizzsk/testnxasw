package com.p226hp.hpl.sparta;

import com.p226hp.hpl.sparta.xpath.AllElementTest;
import com.p226hp.hpl.sparta.xpath.AttrEqualsExpr;
import com.p226hp.hpl.sparta.xpath.AttrExistsExpr;
import com.p226hp.hpl.sparta.xpath.AttrGreaterExpr;
import com.p226hp.hpl.sparta.xpath.AttrLessExpr;
import com.p226hp.hpl.sparta.xpath.AttrNotEqualsExpr;
import com.p226hp.hpl.sparta.xpath.AttrTest;
import com.p226hp.hpl.sparta.xpath.BooleanExpr;
import com.p226hp.hpl.sparta.xpath.ElementTest;
import com.p226hp.hpl.sparta.xpath.ParentNodeTest;
import com.p226hp.hpl.sparta.xpath.PositionEqualsExpr;
import com.p226hp.hpl.sparta.xpath.Step;
import com.p226hp.hpl.sparta.xpath.TextEqualsExpr;
import com.p226hp.hpl.sparta.xpath.TextExistsExpr;
import com.p226hp.hpl.sparta.xpath.TextNotEqualsExpr;
import com.p226hp.hpl.sparta.xpath.TextTest;
import com.p226hp.hpl.sparta.xpath.ThisNodeTest;
import com.p226hp.hpl.sparta.xpath.TrueExpr;
import com.p226hp.hpl.sparta.xpath.Visitor;
import com.p226hp.hpl.sparta.xpath.XPath;
import com.p226hp.hpl.sparta.xpath.XPathException;
import java.util.Enumeration;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.XPathVisitor */
class XPathVisitor implements Visitor {

    /* renamed from: a */
    private static final Boolean f56727a = new Boolean(true);

    /* renamed from: b */
    private static final Boolean f56728b = new Boolean(false);

    /* renamed from: c */
    private final C20732f f56729c;

    /* renamed from: d */
    private Vector f56730d;

    /* renamed from: e */
    private Enumeration f56731e;

    /* renamed from: f */
    private Object f56732f;

    /* renamed from: g */
    private final BooleanStack f56733g;

    /* renamed from: h */
    private Node f56734h;

    /* renamed from: i */
    private boolean f56735i;

    /* renamed from: j */
    private XPath f56736j;

    private XPathVisitor(XPath xPath, Node node) throws XPathException {
        this.f56729c = new C20732f();
        this.f56730d = new Vector();
        this.f56731e = null;
        this.f56732f = null;
        this.f56733g = new BooleanStack();
        this.f56736j = xPath;
        this.f56734h = node;
        Vector vector = new Vector(1);
        this.f56730d = vector;
        vector.addElement(this.f56734h);
        Enumeration steps = xPath.getSteps();
        while (steps.hasMoreElements()) {
            Step step = (Step) steps.nextElement();
            this.f56735i = step.isMultiLevel();
            this.f56731e = null;
            step.getNodeTest().accept(this);
            this.f56731e = this.f56729c.mo171205a();
            this.f56730d.removeAllElements();
            BooleanExpr predicate = step.getPredicate();
            while (this.f56731e.hasMoreElements()) {
                this.f56732f = this.f56731e.nextElement();
                predicate.accept(this);
                if (this.f56733g.pop().booleanValue()) {
                    this.f56730d.addElement(this.f56732f);
                }
            }
        }
    }

    public XPathVisitor(Element element, XPath xPath) throws XPathException {
        this(xPath, (Node) element);
        if (xPath.isAbsolute()) {
            throw new XPathException(xPath, "Cannot use element as context node for absolute xpath");
        }
    }

    public XPathVisitor(Document document, XPath xPath) throws XPathException {
        this(xPath, (Node) document);
    }

    public void visit(ThisNodeTest thisNodeTest) {
        this.f56729c.mo171208b();
        this.f56729c.mo171206a(this.f56734h, 1);
    }

    public void visit(ParentNodeTest parentNodeTest) throws XPathException {
        this.f56729c.mo171208b();
        Element parentNode = this.f56734h.getParentNode();
        if (parentNode != null) {
            this.f56729c.mo171206a(parentNode, 1);
            return;
        }
        throw new XPathException(this.f56736j, "Illegal attempt to apply \"..\" to node with no parent.");
    }

    public void visit(AllElementTest allElementTest) {
        Vector vector = this.f56730d;
        this.f56729c.mo171208b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                m42741a((Element) nextElement);
            } else if (nextElement instanceof Document) {
                m42739a((Document) nextElement);
            }
        }
    }

    /* renamed from: a */
    private void m42739a(Document document) {
        Element documentElement = document.getDocumentElement();
        this.f56729c.mo171206a(documentElement, 1);
        if (this.f56735i) {
            m42741a(documentElement);
        }
    }

    /* renamed from: a */
    private void m42741a(Element element) {
        int i = 0;
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Element) {
                i++;
                this.f56729c.mo171206a(firstChild, i);
                if (this.f56735i) {
                    m42741a((Element) firstChild);
                }
            }
        }
    }

    public void visit(TextTest textTest) {
        Vector vector = this.f56730d;
        this.f56729c.mo171208b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Element) {
                for (Node firstChild = ((Element) nextElement).getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                    if (firstChild instanceof Text) {
                        this.f56729c.mo171207a(((Text) firstChild).getData());
                    }
                }
            }
        }
    }

    public void visit(ElementTest elementTest) {
        String tagName = elementTest.getTagName();
        Vector vector = this.f56730d;
        int size = vector.size();
        this.f56729c.mo171208b();
        for (int i = 0; i < size; i++) {
            Object elementAt = vector.elementAt(i);
            if (elementAt instanceof Element) {
                m42742a((Element) elementAt, tagName);
            } else if (elementAt instanceof Document) {
                m42740a((Document) elementAt, tagName);
            }
        }
    }

    /* renamed from: a */
    private void m42740a(Document document, String str) {
        Element documentElement = document.getDocumentElement();
        if (documentElement != null) {
            if (documentElement.getTagName() == str) {
                this.f56729c.mo171206a(documentElement, 1);
            }
            if (this.f56735i) {
                m42742a(documentElement, str);
            }
        }
    }

    /* renamed from: a */
    private void m42742a(Element element, String str) {
        int i = 0;
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild instanceof Element) {
                Element element2 = (Element) firstChild;
                if (element2.getTagName() == str) {
                    i++;
                    this.f56729c.mo171206a(element2, i);
                }
                if (this.f56735i) {
                    m42742a(element2, str);
                }
            }
        }
    }

    public void visit(AttrTest attrTest) {
        String attribute;
        Vector vector = this.f56730d;
        this.f56729c.mo171208b();
        Enumeration elements = vector.elements();
        while (elements.hasMoreElements()) {
            Node node = (Node) elements.nextElement();
            if ((node instanceof Element) && (attribute = ((Element) node).getAttribute(attrTest.getAttrName())) != null) {
                this.f56729c.mo171207a(attribute);
            }
        }
    }

    public void visit(TrueExpr trueExpr) {
        this.f56733g.push(f56727a);
    }

    public void visit(AttrExistsExpr attrExistsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            String attribute = ((Element) obj).getAttribute(attrExistsExpr.getAttrName());
            this.f56733g.push(attribute != null && attribute.length() > 0 ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(AttrEqualsExpr attrEqualsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            this.f56733g.push(attrEqualsExpr.getAttrValue().equals(((Element) obj).getAttribute(attrEqualsExpr.getAttrName())) ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(AttrNotEqualsExpr attrNotEqualsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            this.f56733g.push(attrNotEqualsExpr.getAttrValue().equals(((Element) obj).getAttribute(attrNotEqualsExpr.getAttrName())) ^ true ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(AttrLessExpr attrLessExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            this.f56733g.push((((double) Long.parseLong(((Element) obj).getAttribute(attrLessExpr.getAttrName()))) > attrLessExpr.getAttrValue() ? 1 : (((double) Long.parseLong(((Element) obj).getAttribute(attrLessExpr.getAttrName()))) == attrLessExpr.getAttrValue() ? 0 : -1)) < 0 ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(AttrGreaterExpr attrGreaterExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            this.f56733g.push((((double) Long.parseLong(((Element) obj).getAttribute(attrGreaterExpr.getAttrName()))) > attrGreaterExpr.getAttrValue() ? 1 : (((double) Long.parseLong(((Element) obj).getAttribute(attrGreaterExpr.getAttrName()))) == attrGreaterExpr.getAttrValue() ? 0 : -1)) > 0 ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(TextExistsExpr textExistsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            for (Node firstChild = ((Element) obj).getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild instanceof Text) {
                    this.f56733g.push(f56727a);
                    return;
                }
            }
            this.f56733g.push(f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(TextEqualsExpr textEqualsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            Node firstChild = ((Element) obj).getFirstChild();
            while (firstChild != null) {
                if (!(firstChild instanceof Text) || !((Text) firstChild).getData().equals(textEqualsExpr.getValue())) {
                    firstChild = firstChild.getNextSibling();
                } else {
                    this.f56733g.push(f56727a);
                    return;
                }
            }
            this.f56733g.push(f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(TextNotEqualsExpr textNotEqualsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            Node firstChild = ((Element) obj).getFirstChild();
            while (firstChild != null) {
                if (!(firstChild instanceof Text) || ((Text) firstChild).getData().equals(textNotEqualsExpr.getValue())) {
                    firstChild = firstChild.getNextSibling();
                } else {
                    this.f56733g.push(f56727a);
                    return;
                }
            }
            this.f56733g.push(f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test attribute of document");
    }

    public void visit(PositionEqualsExpr positionEqualsExpr) throws XPathException {
        Object obj = this.f56732f;
        if (obj instanceof Element) {
            this.f56733g.push(this.f56729c.mo171204a((Node) (Element) obj) == positionEqualsExpr.getPosition() ? f56727a : f56728b);
            return;
        }
        throw new XPathException(this.f56736j, "Cannot test position of document");
    }

    /* renamed from: a */
    public Enumeration mo171184a() {
        return this.f56730d.elements();
    }

    /* renamed from: b */
    public Element mo171185b() {
        if (this.f56730d.size() == 0) {
            return null;
        }
        return (Element) this.f56730d.elementAt(0);
    }

    /* renamed from: c */
    public String mo171186c() {
        if (this.f56730d.size() == 0) {
            return null;
        }
        return this.f56730d.elementAt(0).toString();
    }

    /* renamed from: com.hp.hpl.sparta.XPathVisitor$BooleanStack */
    private static class BooleanStack {
        private Item top_;

        private BooleanStack() {
            this.top_ = null;
        }

        /* renamed from: com.hp.hpl.sparta.XPathVisitor$BooleanStack$Item */
        private static class Item {
            final Boolean bool;
            final Item prev;

            Item(Boolean bool2, Item item) {
                this.bool = bool2;
                this.prev = item;
            }
        }

        /* access modifiers changed from: package-private */
        public void push(Boolean bool) {
            this.top_ = new Item(bool, this.top_);
        }

        /* access modifiers changed from: package-private */
        public Boolean pop() {
            Boolean bool = this.top_.bool;
            this.top_ = this.top_.prev;
            return bool;
        }
    }
}
