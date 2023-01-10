package com.didi.app.nova.skeleton.dialog;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.app.nova.skeleton.tools.TraceUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class DialogInstrument {

    /* renamed from: a */
    final View.OnTouchListener f10267a = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (DialogInstrument.this.f10269c.mo45804a()) {
                return false;
            }
            if (!DialogInstrument.this.f10269c.mo45807c().mo45802d().isCancelable() || motionEvent.getAction() == 0) {
                return true;
            }
            if (motionEvent.getAction() == 1) {
                return DialogInstrument.this.handleBack();
            }
            return false;
        }
    };

    /* renamed from: b */
    private DialogFrameLayout f10268b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C4280b f10269c = new C4280b();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<String, ChangeAnimationData> f10270d = new HashMap();

    public DialogInstrument(DialogFrameLayout dialogFrameLayout) {
        this.f10268b = dialogFrameLayout;
    }

    public boolean handleBack() {
        if (this.f10269c.mo45804a()) {
            return false;
        }
        if (!this.f10269c.mo45807c().mo45802d().isCancelable() || this.f10269c.mo45807c().mo45802d().onHandleBack()) {
            return true;
        }
        this.f10269c.mo45807c().mo45802d().dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45787a(C4279a aVar) {
        aVar.mo45802d().mo45764a(this);
        C4279a c = this.f10269c.mo45807c();
        this.f10269c.mo45806b(aVar);
        String c2 = aVar.mo45801c();
        TraceUtil.trace(c2, "will show " + aVar.mo45802d());
        m9012a(aVar, c, true);
        this.f10268b.onDialogChange(aVar.mo45802d(), c == null ? null : c.mo45802d(), true);
        if (this.f10269c.mo45805b() == 1) {
            this.f10268b.setOnTouchListener(this.f10267a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo45786a(Dialog dialog) {
        C4279a aVar;
        C4279a c = this.f10269c.mo45807c();
        if (c != null && c.mo45802d() == dialog) {
            this.f10269c.mo45809d();
            TraceUtil.trace(c.mo45801c(), "pop " + c.mo45802d());
            m9012a(this.f10269c.mo45807c(), c, false);
            this.f10268b.onDialogChange(this.f10269c.mo45807c() == null ? null : this.f10269c.mo45807c().mo45802d(), c == null ? null : c.mo45802d(), false);
        } else {
            Iterator<C4279a> it = this.f10269c.iterator();
            C4279a aVar2 = null;
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = it.next();
                if (aVar.mo45802d() == dialog) {
                    aVar2 = aVar;
                } else if (aVar2 != null) {
                    break;
                }
            }
            if (aVar2 != null) {
                this.f10269c.mo45803a(aVar2);
                TraceUtil.trace(aVar2.mo45801c(), "pop " + aVar2.mo45802d());
                m9012a(aVar, aVar2, false);
                this.f10268b.onDialogChange(aVar == null ? null : aVar.mo45802d(), aVar2 == null ? null : aVar2.mo45802d(), false);
            }
        }
        if (this.f10269c.mo45804a()) {
            this.f10268b.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    public void dismissAll() {
        while (!this.f10269c.mo45804a()) {
            mo45786a(this.f10269c.mo45807c().mo45802d());
        }
    }

    public final void onActivityStart() {
        if (!this.f10269c.mo45804a() && !this.f10269c.mo45807c().mo45802d().isAttached()) {
            m9013a(this.f10269c.mo45807c(), (C4279a) null, true, new SimpleTransformAnimation());
        }
    }

    public final void onActivityStop() {
        if (!this.f10269c.mo45804a() && this.f10269c.mo45807c().mo45802d().isAttached()) {
            m9013a((C4279a) null, this.f10269c.mo45807c(), false, new SimpleTransformAnimation(false));
        }
    }

    public final void onActivityDestroy() {
        while (!this.f10269c.mo45804a()) {
            C4279a d = this.f10269c.mo45809d();
            if (d.mo45802d().isAttached()) {
                m9013a((C4279a) null, d, false, new SimpleTransformAnimation());
            } else {
                d.mo45802d().mo45768d();
                String c = d.mo45801c();
                TraceUtil.trace(c, d.mo45802d() + " is destroyed.");
            }
        }
    }

    /* renamed from: a */
    private final void m9012a(C4279a aVar, C4279a aVar2, boolean z) {
        TransformAnimation transformAnimation;
        if (z) {
            transformAnimation = aVar.mo45798a();
        } else {
            transformAnimation = aVar2 != null ? aVar2.mo45800b() : null;
        }
        if (transformAnimation == null) {
            transformAnimation = new SimpleTransformAnimation();
        }
        m9013a(aVar, aVar2, z, transformAnimation);
    }

    /* renamed from: a */
    private final void m9013a(final C4279a aVar, final C4279a aVar2, boolean z, TransformAnimation transformAnimation) {
        View view;
        if (transformAnimation.f10272a) {
            transformAnimation = transformAnimation.copy();
        }
        TransformAnimation transformAnimation2 = transformAnimation;
        transformAnimation2.f10272a = true;
        if (aVar2 != null) {
            if (z) {
                mo45788a(aVar2.mo45802d().mo45762a());
            } else {
                mo45789b(aVar2.mo45802d().mo45762a());
            }
        }
        if (aVar != null) {
            this.f10270d.put(aVar.mo45802d().mo45762a(), new ChangeAnimationData(transformAnimation2, z));
        }
        View view2 = null;
        if (aVar != null) {
            aVar.mo45802d().mo45763a(LayoutInflater.from(this.f10268b.getContext()), this.f10268b);
            view = aVar.mo45802d().getView();
        } else {
            view = null;
        }
        if (aVar2 != null) {
            view2 = aVar2.mo45802d().getView();
        }
        View view3 = view2;
        if (aVar2 != null) {
            aVar2.mo45802d().mo45767c();
            TraceUtil.trace(aVar2.mo45801c(), aVar2.mo45802d() + " will dismiss.");
        }
        transformAnimation2.performChange(this.f10268b, view3, view, z, new TransformAnimation.TransformAnimationListener() {
            public void onAnimationCompleted() {
                if (aVar != null) {
                    DialogInstrument.this.f10270d.remove(aVar.mo45802d().mo45762a());
                    aVar.mo45802d().mo45765b();
                    String c = aVar.mo45801c();
                    TraceUtil.trace(c, aVar.mo45802d() + " had been show.");
                }
                if (aVar2 != null && !DialogInstrument.this.f10269c.mo45808c(aVar2)) {
                    aVar2.mo45802d().mo45768d();
                    String c2 = aVar2.mo45801c();
                    TraceUtil.trace(c2, aVar2.mo45802d() + " is destroyed.");
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo45788a(String str) {
        ChangeAnimationData changeAnimationData = this.f10270d.get(str);
        if (changeAnimationData == null) {
            return false;
        }
        changeAnimationData.animation.completeAnimationImmediately();
        this.f10270d.remove(str);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo45789b(String str) {
        ChangeAnimationData changeAnimationData = this.f10270d.get(str);
        if (changeAnimationData != null) {
            if (changeAnimationData.isPush) {
                changeAnimationData.animation.onAbortPush();
            } else {
                changeAnimationData.animation.completeAnimationImmediately();
            }
            this.f10270d.remove(str);
        }
    }

    static class ChangeAnimationData {
        TransformAnimation animation;
        boolean isPush;

        ChangeAnimationData(TransformAnimation transformAnimation, boolean z) {
            this.animation = transformAnimation;
            this.isPush = z;
        }
    }
}
