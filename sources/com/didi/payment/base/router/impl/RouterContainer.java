package com.didi.payment.base.router.impl;

import java.util.Iterator;
import java.util.Stack;

public class RouterContainer {

    /* renamed from: a */
    private static Stack<IPayRouter> f32395a = new Stack<>();

    public static void push(IPayRouter iPayRouter) {
        if (!f32395a.contains(iPayRouter)) {
            f32395a.push(iPayRouter);
        }
    }

    public static void pop(boolean z) {
        if (!f32395a.empty()) {
            f32395a.pop().destroy();
        }
    }

    public static IPayRouter peek() {
        if (!f32395a.empty()) {
            return f32395a.peek();
        }
        return null;
    }

    public static Iterator<IPayRouter> iterator() {
        if (!f32395a.empty()) {
            return f32395a.iterator();
        }
        return null;
    }

    public static boolean isEmpty() {
        return f32395a.empty();
    }

    public static int size() {
        return f32395a.size();
    }

    public static void clear() {
        if (!f32395a.empty()) {
            f32395a.clear();
        }
    }
}
