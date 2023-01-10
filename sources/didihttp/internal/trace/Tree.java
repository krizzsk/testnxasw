package didihttp.internal.trace;

import android.os.SystemClock;
import didihttp.Interceptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {

    /* renamed from: a */
    private Node f59678a;

    /* renamed from: b */
    private Node f59679b;

    public void push(Node node) {
        if (IcpStatStrategy.m44971a().mo180164b()) {
            node.startTime = SystemClock.uptimeMillis();
            Node node2 = this.f59678a;
            if (node2 == null) {
                this.f59678a = node;
                this.f59679b = node;
                return;
            }
            node2.children.add(node);
            node.parent = this.f59678a;
            this.f59678a = node;
        }
    }

    public void pop(Node node) {
        if (IcpStatStrategy.m44971a().mo180164b()) {
            node.endTime = SystemClock.uptimeMillis();
            Node node2 = this.f59678a;
            if (node == node2) {
                this.f59678a = node2.parent;
            }
        }
    }

    public void popTo(Interceptor interceptor) {
        if (IcpStatStrategy.m44971a().mo180164b()) {
            while (true) {
                Node node = this.f59678a;
                if (node != null && node.value != interceptor) {
                    this.f59678a.endTime = SystemClock.uptimeMillis();
                    this.f59678a = this.f59678a.parent;
                } else {
                    return;
                }
            }
        }
    }

    public void popAll() {
        if (IcpStatStrategy.m44971a().mo180164b()) {
            while (true) {
                Node node = this.f59678a;
                if (node != null) {
                    node.endTime = SystemClock.uptimeMillis();
                    this.f59678a = this.f59678a.parent;
                } else {
                    return;
                }
            }
        }
    }

    public List<Node> transformToList() {
        ArrayList arrayList = new ArrayList();
        if (IcpStatStrategy.m44971a().mo180164b() && this.f59679b != null) {
            Stack stack = new Stack();
            stack.push(this.f59679b);
            while (!stack.isEmpty()) {
                Node node = (Node) stack.pop();
                if (node != null) {
                    arrayList.add(node);
                    node.cost = node.endTime - node.startTime;
                    for (int size = node.children.size() - 1; size >= 0; size--) {
                        Node node2 = node.children.get(size);
                        node.cost -= node2.endTime - node2.startTime;
                        stack.push(node2);
                    }
                }
            }
        }
        return arrayList;
    }

    public String getIcpCost() {
        return IcpStatStrategy.m44971a().mo180163a(this);
    }
}
