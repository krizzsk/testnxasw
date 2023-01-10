package jumio.core;

import com.jumio.core.credentials.C20951b;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.o */
/* compiled from: CredentialDataModel.kt */
public final class C19495o extends C19489l {

    /* renamed from: g */
    public final ArrayList<String> f55392g;

    /* renamed from: h */
    public final ArrayList<JumioDocumentType> f55393h;

    /* renamed from: i */
    public final JumioDocumentVariant f55394i;

    /* renamed from: j */
    public String f55395j;

    /* renamed from: k */
    public JumioDocument f55396k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19495o(String str, ArrayList<C20951b> arrayList, ArrayList<String> arrayList2, ArrayList<JumioDocumentType> arrayList3, JumioDocumentVariant jumioDocumentVariant) {
        super(str, JumioCredentialCategory.ID, arrayList);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f55392g = arrayList2;
        this.f55393h = arrayList3;
        this.f55394i = jumioDocumentVariant;
    }

    /* renamed from: a */
    public final void mo148687a(String str) {
        this.f55395j = str;
    }

    /* renamed from: h */
    public final ArrayList<String> mo148688h() {
        return this.f55392g;
    }

    /* renamed from: i */
    public final ArrayList<JumioDocumentType> mo148689i() {
        return this.f55393h;
    }

    /* renamed from: j */
    public final JumioDocumentVariant mo148690j() {
        return this.f55394i;
    }

    /* renamed from: k */
    public final String mo148691k() {
        return this.f55395j;
    }

    /* renamed from: l */
    public final JumioDocument mo148692l() {
        return this.f55396k;
    }

    /* renamed from: a */
    public final void mo148686a(JumioDocument jumioDocument) {
        this.f55396k = jumioDocument;
    }
}
