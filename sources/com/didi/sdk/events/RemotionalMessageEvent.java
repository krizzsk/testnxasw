package com.didi.sdk.events;

import com.didi.sdk.sidebar.model.SidebarResponse;

public class RemotionalMessageEvent {

    /* renamed from: a */
    private String f38647a;

    /* renamed from: b */
    private String f38648b;

    /* renamed from: c */
    private String f38649c;

    /* renamed from: d */
    private SidebarResponse.DidiPassData f38650d;

    public String getText() {
        return this.f38647a;
    }

    public String getNumber() {
        return this.f38648b;
    }

    public String getType() {
        return this.f38649c;
    }

    public SidebarResponse.DidiPassData getDidiPassData() {
        return this.f38650d;
    }

    public RemotionalMessageEvent(String str, String str2, String str3, SidebarResponse.DidiPassData didiPassData) {
        this.f38647a = str;
        this.f38648b = str2;
        this.f38649c = str3;
        this.f38650d = didiPassData;
    }
}
