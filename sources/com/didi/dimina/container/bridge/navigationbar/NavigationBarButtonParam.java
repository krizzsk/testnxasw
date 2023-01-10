package com.didi.dimina.container.bridge.navigationbar;

import java.io.Serializable;

public class NavigationBarButtonParam implements Serializable {
    private String iconUrl;

    /* renamed from: id */
    private String f18634id;
    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getId() {
        return this.f18634id;
    }

    public void setId(String str) {
        this.f18634id = str;
    }
}
