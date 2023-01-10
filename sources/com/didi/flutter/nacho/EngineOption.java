package com.didi.flutter.nacho;

import java.util.ArrayList;
import java.util.List;

public class EngineOption {

    /* renamed from: a */
    boolean f22931a;

    /* renamed from: b */
    String f22932b;

    /* renamed from: c */
    List<String> f22933c = new ArrayList();

    /* renamed from: d */
    boolean f22934d = false;

    public EngineOption createByGroup(boolean z) {
        this.f22934d = z;
        return this;
    }

    public EngineOption(String str) {
        this.f22932b = str;
    }

    public EngineOption addArg(String str) {
        this.f22933c.add(str);
        return this;
    }

    public EngineOption addArgs(List<String> list) {
        this.f22933c.addAll(list);
        return this;
    }

    public EngineOption enableBufferingIncomingMessages(boolean z) {
        this.f22931a = z;
        return this;
    }
}
