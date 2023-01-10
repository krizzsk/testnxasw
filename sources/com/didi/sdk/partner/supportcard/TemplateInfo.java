package com.didi.sdk.partner.supportcard;

public class TemplateInfo {

    /* renamed from: a */
    private String f39680a;

    /* renamed from: b */
    private String f39681b;

    /* renamed from: c */
    private Class<ITemplateView> f39682c;

    public TemplateInfo(String str, String str2, Class cls) {
        this.f39680a = str;
        this.f39681b = str2;
        this.f39682c = cls;
    }

    public String getId() {
        return this.f39680a;
    }

    public void setId(String str) {
        this.f39680a = str;
    }

    public String getTemplate_name() {
        return this.f39681b;
    }

    public void setTemplate_name(String str) {
        this.f39681b = str;
    }

    public Class<ITemplateView> getTemplate_view() {
        return this.f39682c;
    }

    public void setTemplate_view(Class<ITemplateView> cls) {
        this.f39682c = cls;
    }
}
