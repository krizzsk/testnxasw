package com.didichuxing.dfbasesdk.ottoevent;

public class H5AppealDoneEvent {

    /* renamed from: a */
    private int f49322a;
    public final int code;
    public final String msg;

    public H5AppealDoneEvent(int i, String str) {
        this.code = i;
        this.msg = str;
        m37000a(i);
    }

    /* renamed from: a */
    private void m37000a(int i) {
        if (i == 100000) {
            this.f49322a = 1;
        } else if (i == 100004) {
            this.f49322a = 2;
        } else {
            this.f49322a = 3;
        }
    }

    public int getStatus() {
        return this.f49322a;
    }
}
