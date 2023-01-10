package com.didi.app.nova.skeleton.internal;

import android.os.Bundle;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.ScopeContextBase;
import com.didi.app.nova.skeleton.dialog.Dialog;

public final class ScopeContextComponentImpl extends ScopeContextBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ScopeContext f10320a;

    /* renamed from: b */
    private String f10321b;

    public ScopeContext getParent() {
        return null;
    }

    public ScopeContextComponentImpl(ScopeContext scopeContext, String str) {
        this.f10320a = scopeContext;
        this.f10321b = str;
    }

    /* access modifiers changed from: protected */
    public INavigator newNavigator() {
        return new INavigator() {
            public void push(Page page) {
                ScopeContextComponentImpl.this.f10320a.getNavigator().push(page);
            }

            public void pushForResult(Page page) {
                ScopeContextComponentImpl.this.f10320a.getNavigator().pushForResult(page);
            }

            public void popToRoot() {
                ScopeContextComponentImpl.this.f10320a.getNavigator().popToRoot();
            }

            public void finish() {
                ScopeContextComponentImpl.this.f10320a.getNavigator().finish();
            }

            public void finish(Bundle bundle) {
                ScopeContextComponentImpl.this.f10320a.getNavigator().finish(bundle);
            }

            public void showDialog(Dialog dialog, String str) {
                ScopeContextComponentImpl.this.f10320a.getNavigator().showDialog(dialog, str);
            }
        };
    }

    public Object getObject(String str) {
        Object object = super.getObject(str);
        return object == null ? this.f10320a.getObject(str) : object;
    }

    public String alias() {
        return this.f10321b + "@" + this;
    }

    public Bundle getBundle() {
        return this.f10320a.getBundle();
    }
}
