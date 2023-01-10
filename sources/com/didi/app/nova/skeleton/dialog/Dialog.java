package com.didi.app.nova.skeleton.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.UUID;

public abstract class Dialog {

    /* renamed from: a */
    private View f10259a;

    /* renamed from: b */
    private boolean f10260b;

    /* renamed from: c */
    private boolean f10261c = false;

    /* renamed from: d */
    private DialogInstrument f10262d;

    /* renamed from: e */
    private String f10263e = UUID.randomUUID().toString();

    /* renamed from: f */
    private boolean f10264f = true;

    public abstract TransformAnimation getEnterAnimation();

    public abstract TransformAnimation getExitAnimation();

    public abstract View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract void onDestroy();

    public abstract void onDismiss();

    public boolean onHandleBack() {
        return false;
    }

    public abstract void onShow();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45764a(DialogInstrument dialogInstrument) {
        this.f10262d = dialogInstrument;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45763a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (this.f10259a == null) {
            View onCreate = onCreate(layoutInflater, viewGroup);
            this.f10259a = onCreate;
            if (onCreate == null) {
                throw new IllegalStateException("Dialog's onCreateView method returned Null.");
            } else if (onCreate == viewGroup) {
                throw new IllegalStateException("Don't set attachToRoot = true");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final String mo45762a() {
        return this.f10263e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo45765b() {
        this.f10261c = true;
        onShow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo45767c() {
        this.f10261c = false;
        onDismiss();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo45768d() {
        if (!this.f10260b) {
            onDestroy();
        }
        this.f10260b = true;
        this.f10259a = null;
        this.f10262d = null;
    }

    public final boolean isCancelable() {
        return this.f10264f;
    }

    public final void setCancelable(boolean z) {
        this.f10264f = z;
    }

    public final boolean isAttached() {
        return this.f10261c;
    }

    public final boolean isDestroyed() {
        return this.f10260b;
    }

    public final View getView() {
        return this.f10259a;
    }

    public final void show(PageInstrument pageInstrument, String str) {
        show(pageInstrument.getDialogInstrument(), str);
    }

    public final void show(DialogInstrument dialogInstrument, String str) {
        if (dialogInstrument == null) {
            TraceUtil.trace("Dialog", "call PageInstrument.attachDialogFragment() first, or activity is destroyed.");
        } else {
            dialogInstrument.mo45787a(C4279a.m9019a(this).mo45799a(str));
        }
    }

    public final void dismiss() {
        DialogInstrument dialogInstrument = this.f10262d;
        if (dialogInstrument == null) {
            TraceUtil.trace("Dialog", this + " isn't in dialog stack.");
            return;
        }
        dialogInstrument.mo45786a(this);
    }

    public final void bind(ScopeContext scopeContext) {
        if (scopeContext.getLiveHandler().isDestroyed()) {
            dismiss();
        } else {
            scopeContext.addObserver(new IScopeLifecycle() {
                public void onCreate(ILive iLive) {
                }

                public void onPause(ILive iLive) {
                }

                public void onResume(ILive iLive) {
                }

                public void onStart(ILive iLive) {
                }

                public void onStop(ILive iLive) {
                }

                public void onDestroy(ILive iLive) {
                    Dialog.this.dismiss();
                }
            });
        }
    }
}
