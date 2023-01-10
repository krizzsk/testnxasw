package com.didi.app.nova.skeleton.image.glide;

import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.didi.app.nova.skeleton.ScopeContext;
import java.util.Collections;
import java.util.Set;

/* renamed from: com.didi.app.nova.skeleton.image.glide.a */
/* compiled from: GlideSupport */
class C4291a implements RequestManagerTreeNode {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SkeletonLifecycle f10299a = new SkeletonLifecycle();

    /* renamed from: b */
    private SkeletonRequestManager f10300b;

    public C4291a(ScopeContext scopeContext, Context context) {
        this.f10300b = new SkeletonRequestManager(Glide.get(context), this.f10299a, this, context);
        scopeContext.addObserver(new GlideSupport$1(this));
        if (scopeContext.getLiveHandler().isActive()) {
            this.f10299a.mo45852a();
        }
    }

    /* renamed from: a */
    public SkeletonRequestManager mo45855a() {
        return this.f10300b;
    }

    public Set<RequestManager> getDescendants() {
        return Collections.EMPTY_SET;
    }
}
