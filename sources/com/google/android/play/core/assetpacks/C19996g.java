package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.g */
final /* synthetic */ class C19996g implements OnSuccessListener {

    /* renamed from: a */
    private final C19917bb f56006a;

    private C19996g(C19917bb bbVar) {
        this.f56006a = bbVar;
    }

    /* renamed from: a */
    static OnSuccessListener m42070a(C19917bb bbVar) {
        return new C19996g(bbVar);
    }

    public final void onSuccess(Object obj) {
        this.f56006a.mo164099a((List<String>) (List) obj);
    }
}
