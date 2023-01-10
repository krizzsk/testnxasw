package jumio.core;

import com.jumio.core.credentials.C20951b;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.m */
/* compiled from: CredentialDataModel.kt */
public final class C19491m extends C19489l {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19491m(String str, ArrayList<C20951b> arrayList) {
        super(str, JumioCredentialCategory.DOCUMENT, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
    }
}
