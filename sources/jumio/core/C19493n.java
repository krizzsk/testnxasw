package jumio.core;

import com.jumio.core.credentials.C20951b;
import com.jumio.core.enums.C20952a;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.n */
/* compiled from: CredentialDataModel.kt */
public final class C19493n extends C19489l {

    /* renamed from: g */
    public final ArrayList<C20952a> f55384g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19493n(String str, ArrayList<C20951b> arrayList, ArrayList<C20952a> arrayList2) {
        super(str, JumioCredentialCategory.FACE, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f55384g = arrayList2;
    }

    /* renamed from: h */
    public final ArrayList<C20952a> mo148681h() {
        return this.f55384g;
    }
}
