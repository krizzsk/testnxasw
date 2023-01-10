package com.didi.dimina.container.bridge.permission;

import org.json.JSONObject;

public class PermissionDescInfo {

    /* renamed from: a */
    private String f18639a;

    /* renamed from: b */
    private String f18640b = "";

    /* renamed from: c */
    private String f18641c;

    /* renamed from: d */
    private String f18642d = "";

    public PermissionDescInfo() {
    }

    public PermissionDescInfo(String str, String str2) {
        this.f18640b = str;
        this.f18642d = str2;
    }

    public String getTitle() {
        return this.f18640b;
    }

    public void setTitle(String str) {
        this.f18640b = str;
    }

    public String getContent() {
        return this.f18642d;
    }

    public void setContent(String str) {
        this.f18642d = str;
    }

    public String getIcon() {
        return this.f18639a;
    }

    public void setIcon(String str) {
        this.f18639a = str;
    }

    public String getSubTitle() {
        return this.f18641c;
    }

    public void setSubTitle(String str) {
        this.f18641c = this.f18641c;
    }

    public static PermissionDescInfo parse(JSONObject jSONObject) {
        PermissionDescInfo permissionDescInfo = new PermissionDescInfo();
        permissionDescInfo.f18640b = jSONObject.optString("title");
        permissionDescInfo.f18639a = jSONObject.optString("icon");
        permissionDescInfo.f18641c = jSONObject.optString("subTitle");
        permissionDescInfo.f18642d = jSONObject.optString("desc");
        return permissionDescInfo;
    }
}
