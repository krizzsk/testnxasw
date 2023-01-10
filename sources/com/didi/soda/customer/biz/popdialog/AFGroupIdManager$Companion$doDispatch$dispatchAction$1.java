package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.soda.customer.biz.popdialog.AFGroupIdManager;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AFGroupIdManager.kt */
final class AFGroupIdManager$Companion$doDispatch$dispatchAction$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Uri $uri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AFGroupIdManager$Companion$doDispatch$dispatchAction$1(Uri uri) {
        super(0);
        this.$uri = uri;
    }

    public final void invoke() {
        Function2 access$getTrack$cp = AFGroupIdManager.f43046f;
        if (access$getTrack$cp != null) {
            String uri = this.$uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "uri.toString()");
            access$getTrack$cp.invoke(uri, "");
            AFGroupIdManager.Companion companion = AFGroupIdManager.Companion;
            AFGroupIdManager.f43046f = null;
        }
        SchemeHelper.dispatchMsg(this.$uri, true);
    }
}
