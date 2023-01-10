package com.jumio.core;

import android.content.Context;
import android.content.ContextWrapper;
import com.jumio.core.models.AuthorizationModel;
import jumio.core.C19499q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0005\u001a\u00060\u0003R\u00020\u0004H\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, mo148868d2 = {"Lcom/jumio/core/MobileContext;", "Landroid/content/ContextWrapper;", "Ljumio/core/q;", "Lcom/jumio/core/models/AuthorizationModel$SessionKey;", "Lcom/jumio/core/models/AuthorizationModel;", "getSessionKey", "", "b", "I", "getCustomThemeId", "()I", "customThemeId", "Landroid/content/Context;", "base", "authorizationModel", "<init>", "(Landroid/content/Context;Lcom/jumio/core/models/AuthorizationModel;I)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: MobileContext.kt */
public final class MobileContext extends ContextWrapper implements C19499q {

    /* renamed from: a */
    public final AuthorizationModel f57459a;

    /* renamed from: b */
    public final int f57460b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileContext(Context context, AuthorizationModel authorizationModel, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(authorizationModel, "authorizationModel");
        this.f57459a = authorizationModel;
        this.f57460b = i;
    }

    public final int getCustomThemeId() {
        return this.f57460b;
    }

    public AuthorizationModel.SessionKey getSessionKey() {
        return this.f57459a.getSessionKey();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MobileContext(Context context, AuthorizationModel authorizationModel, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, authorizationModel, (i2 & 4) != 0 ? 0 : i);
    }
}
