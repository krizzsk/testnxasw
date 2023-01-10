package com.didi.sdk.event;

import android.os.Bundle;
import android.os.Message;

public class DefaultEvent implements Event {

    /* renamed from: a */
    Bundle f38602a;
    public int arg1;
    public int arg2;

    /* renamed from: b */
    private String f38603b;
    public Object obj;
    public int what;

    public DefaultEvent(String str) {
        this.f38603b = str;
    }

    public DefaultEvent(String str, int i) {
        this.f38603b = str;
        this.what = i;
    }

    public DefaultEvent(String str, int i, int i2, int i3) {
        this.f38603b = str;
        this.what = i;
        this.arg1 = i2;
        this.arg2 = i3;
    }

    public DefaultEvent(String str, int i, int i2, int i3, Object obj2) {
        this.f38603b = str;
        this.what = i;
        this.arg1 = i2;
        this.arg2 = i3;
        this.obj = obj2;
    }

    public DefaultEvent(String str, int i, Object obj2) {
        this.f38603b = str;
        this.what = i;
        this.obj = obj2;
    }

    public DefaultEvent(DefaultEvent defaultEvent) {
        this.f38603b = defaultEvent.f38603b;
        this.what = defaultEvent.what;
        this.arg1 = defaultEvent.arg1;
        this.arg2 = defaultEvent.arg2;
        this.obj = defaultEvent.obj;
        if (defaultEvent.f38602a != null) {
            this.f38602a = new Bundle(defaultEvent.f38602a);
        }
    }

    public String getType() {
        return this.f38603b;
    }

    public Bundle getData() {
        if (this.f38602a == null) {
            this.f38602a = new Bundle();
        }
        return this.f38602a;
    }

    public Bundle peekData() {
        return this.f38602a;
    }

    public void setData(Bundle bundle) {
        this.f38602a = bundle;
    }

    @Deprecated
    public static DefaultEvent obtainDefaultEvent(String str, Message message) {
        DefaultEvent defaultEvent = new DefaultEvent(str, message.what, message.arg1, message.arg2, message.obj);
        if (message.peekData() != null) {
            defaultEvent.setData(new Bundle(message.peekData()));
        }
        message.recycle();
        return defaultEvent;
    }

    @Deprecated
    public Message obtainAndroidMessage() {
        Message obtain = Message.obtain();
        obtain.what = this.what;
        obtain.arg1 = this.arg1;
        obtain.arg2 = this.arg2;
        obtain.obj = this.obj;
        if (this.f38602a != null) {
            obtain.setData(new Bundle(this.f38602a));
        }
        return obtain;
    }

    public String toString() {
        return "DefaultEvent{" + "type='" + this.f38603b + '\'' + ", what=" + this.what + ", arg1=" + this.arg1 + ", arg2=" + this.arg2 + ", obj=" + this.obj + ", data=" + this.f38602a + '}';
    }
}
