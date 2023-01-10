package com.didi.soda.jadux;

import com.didi.soda.jadux.utils.ActionTypes;

public class Action<T> implements AbsAction {

    /* renamed from: a */
    private String f45900a = ActionTypes.UNKNOW;

    /* renamed from: b */
    private T f45901b;

    public Action(String str, T t) {
        this.f45900a = str;
        this.f45901b = t;
    }

    public T getPayload() {
        return this.f45901b;
    }

    public String getType() {
        return this.f45900a;
    }
}
