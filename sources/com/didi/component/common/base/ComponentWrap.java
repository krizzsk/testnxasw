package com.didi.component.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.core.IComponent;

public class ComponentWrap {

    /* renamed from: a */
    private String f13307a;

    /* renamed from: b */
    private Bundle f13308b;

    /* renamed from: c */
    private IComponent f13309c;

    /* renamed from: d */
    private boolean f13310d;

    /* renamed from: e */
    private boolean f13311e;

    public ComponentWrap() {
        this.f13310d = true;
        this.f13311e = false;
    }

    public ComponentWrap(String str) {
        this(str, (Bundle) null, true);
    }

    public ComponentWrap(String str, boolean z) {
        this(str, (Bundle) null, z);
    }

    public ComponentWrap(String str, Bundle bundle) {
        this(str, bundle, true);
    }

    public ComponentWrap(String str, Bundle bundle, boolean z) {
        this.f13310d = true;
        this.f13311e = false;
        this.f13307a = str;
        this.f13308b = bundle;
        this.f13310d = z;
    }

    public String getType() {
        return this.f13307a;
    }

    public void setType(String str) {
        this.f13307a = str;
    }

    public Bundle getBundle() {
        return this.f13308b;
    }

    public void setBundle(Bundle bundle) {
        this.f13308b = bundle;
    }

    public IComponent getComponent() {
        return this.f13309c;
    }

    public void setComponent(IComponent iComponent) {
        this.f13309c = iComponent;
    }

    public boolean isUseMask() {
        return this.f13310d;
    }

    public void setUseMask(boolean z) {
        this.f13310d = z;
    }

    public boolean isClickMaskHide() {
        return this.f13311e;
    }

    public void setClickMaskHide(boolean z) {
        this.f13311e = z;
    }

    public IComponent getComponent(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.f13307a)) {
            return this.f13309c;
        }
        return null;
    }

    public void setComponent(String str, IComponent iComponent) {
        if (!TextUtils.isEmpty(str)) {
            this.f13307a = str;
            this.f13309c = iComponent;
        }
    }
}
