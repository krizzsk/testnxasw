package com.didiglobal.enginecore.template.temp;

import java.util.Objects;

public class XETemplateComponent {

    /* renamed from: a */
    private Class<? extends IXEView> f52710a;

    /* renamed from: b */
    private Class<? extends IXEViewModel> f52711b;

    /* renamed from: c */
    private String f52712c;

    public XETemplateComponent(String str, Class<? extends IXEView> cls, Class<? extends IXEViewModel> cls2) {
        this.f52710a = cls;
        this.f52711b = cls2;
        this.f52712c = str;
    }

    public Class<? extends IXEView> getViewClass() {
        return this.f52710a;
    }

    public Class<? extends IXEViewModel> getModelClass() {
        return this.f52711b;
    }

    public String getTemplateId() {
        return this.f52712c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f52712c, ((XETemplateComponent) obj).f52712c);
    }
}
