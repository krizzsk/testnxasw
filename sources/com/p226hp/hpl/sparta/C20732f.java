package com.p226hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* renamed from: com.hp.hpl.sparta.f */
/* compiled from: XPathVisitor */
class C20732f {

    /* renamed from: a */
    private static final Integer f56745a = new Integer(1);

    /* renamed from: b */
    private static final Integer f56746b = new Integer(2);

    /* renamed from: c */
    private static final Integer f56747c = new Integer(3);

    /* renamed from: d */
    private static final Integer f56748d = new Integer(4);

    /* renamed from: e */
    private static final Integer f56749e = new Integer(5);

    /* renamed from: f */
    private static final Integer f56750f = new Integer(6);

    /* renamed from: g */
    private static final Integer f56751g = new Integer(7);

    /* renamed from: h */
    private static final Integer f56752h = new Integer(8);

    /* renamed from: i */
    private static final Integer f56753i = new Integer(9);

    /* renamed from: j */
    private static final Integer f56754j = new Integer(10);

    /* renamed from: k */
    private final Vector f56755k = new Vector();

    /* renamed from: l */
    private Hashtable f56756l = new Hashtable();

    C20732f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Enumeration mo171205a() {
        return this.f56755k.elements();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171208b() {
        this.f56755k.removeAllElements();
        this.f56756l.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171207a(String str) {
        this.f56755k.addElement(str);
    }

    /* renamed from: b */
    private static Integer m42754b(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171206a(Node node, int i) {
        Integer num;
        this.f56755k.addElement(node);
        switch (i) {
            case 1:
                num = f56745a;
                break;
            case 2:
                num = f56746b;
                break;
            case 3:
                num = f56747c;
                break;
            case 4:
                num = f56748d;
                break;
            case 5:
                num = f56749e;
                break;
            case 6:
                num = f56750f;
                break;
            case 7:
                num = f56751g;
                break;
            case 8:
                num = f56752h;
                break;
            case 9:
                num = f56753i;
                break;
            case 10:
                num = f56754j;
                break;
            default:
                num = new Integer(i);
                break;
        }
        this.f56756l.put(m42754b(node), num);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo171204a(Node node) {
        return ((Integer) this.f56756l.get(m42754b(node))).intValue();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f56755k.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    Node node = (Node) nextElement;
                    stringBuffer.append("Node(" + node.toXml() + ")[" + this.f56756l.get(m42754b(node)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
