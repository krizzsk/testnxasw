package com.didi.component.business.event;

public class OrderServiceEvent {
    public static final int RESULT_ERROR = 2;
    public static final int RESULT_FAIL = 1;
    public static final int RESULT_SUCCESS = 0;

    /* renamed from: a */
    private int f13141a;

    /* renamed from: b */
    private Object f13142b;

    public OrderServiceEvent() {
    }

    public OrderServiceEvent(int i, Object obj) {
        this.f13141a = i;
        this.f13142b = obj;
    }

    public int getEventFlag() {
        return this.f13141a;
    }

    public void setEventFlag(int i) {
        this.f13141a = i;
    }

    public Object getEventResult() {
        return this.f13142b;
    }

    public void setEventResult(Object obj) {
        this.f13142b = obj;
    }
}
