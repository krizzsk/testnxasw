package com.didi.app.nova.skeleton.internal;

import android.os.Bundle;
import com.didi.app.nova.skeleton.AbstractPage;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.dialog.Dialog;

public class ScopeContextPageImpl extends ScopeContextBase {

    /* renamed from: a */
    AbstractPage f10322a;

    public ScopeContextPageImpl(AbstractPage abstractPage) {
        this.f10322a = abstractPage;
    }

    /* access modifiers changed from: protected */
    public INavigator newNavigator() {
        return new INavigator() {
            public void push(Page page) {
                ScopeContextPageImpl.this.f10322a.push(page);
            }

            public void pushForResult(Page page) {
                ScopeContextPageImpl.this.f10322a.pushForResult(page);
            }

            public void popToRoot() {
                ScopeContextPageImpl.this.f10322a.popToRoot();
            }

            public void finish() {
                ScopeContextPageImpl.this.f10322a.finish();
            }

            public void finish(Bundle bundle) {
                ScopeContextPageImpl.this.f10322a.finish(bundle);
            }

            public void showDialog(Dialog dialog, String str) {
                dialog.show(ScopeContextPageImpl.this.f10322a.getInstrument(), str);
            }
        };
    }

    public String alias() {
        return this.f10322a.alias() + "@" + this;
    }

    public Bundle getBundle() {
        return this.f10322a.getArgs();
    }
}
