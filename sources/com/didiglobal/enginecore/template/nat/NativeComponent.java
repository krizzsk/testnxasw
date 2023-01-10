package com.didiglobal.enginecore.template.nat;

import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.constant.XEngineConst;

public class NativeComponent extends XEComponent {
    public String getTemplateId() {
        return XEngineConst.XE_NATIVE_TEMPLATE;
    }

    public String getId() {
        return this.f44019id;
    }

    public void setId(String str) {
        this.f44019id = str;
    }
}
