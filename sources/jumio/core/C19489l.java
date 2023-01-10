package jumio.core;

import com.jumio.commons.PersistWith;
import com.jumio.core.credentials.C20951b;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.enums.JumioScanSide;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

@PersistWith("CredentialsDataModel")
/* renamed from: jumio.core.l */
/* compiled from: CredentialDataModel.kt */
public class C19489l implements StaticModel {

    /* renamed from: a */
    public final String f55373a;

    /* renamed from: b */
    public final JumioCredentialCategory f55374b;

    /* renamed from: c */
    public final ArrayList<C20951b> f55375c;

    /* renamed from: d */
    public final SortedMap<JumioScanSide, ScanPartModel> f55376d = new TreeMap();

    /* renamed from: e */
    public ScanPartModel f55377e;

    /* renamed from: f */
    public JumioScanSide f55378f;

    public C19489l(String str, JumioCredentialCategory jumioCredentialCategory, ArrayList<C20951b> arrayList) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(jumioCredentialCategory, "category");
        Intrinsics.checkNotNullParameter(arrayList, "capabilities");
        this.f55373a = str;
        this.f55374b = jumioCredentialCategory;
        this.f55375c = arrayList;
    }

    /* renamed from: a */
    public final void mo148666a(ScanPartModel scanPartModel) {
        this.f55377e = scanPartModel;
    }

    /* renamed from: b */
    public final ScanPartModel mo148668b() {
        return this.f55377e;
    }

    /* renamed from: c */
    public final ArrayList<C20951b> mo148669c() {
        return this.f55375c;
    }

    /* renamed from: d */
    public final JumioCredentialCategory mo148670d() {
        return this.f55374b;
    }

    /* renamed from: e */
    public final String mo148671e() {
        return this.f55373a;
    }

    /* renamed from: f */
    public final SortedMap<JumioScanSide, ScanPartModel> mo148672f() {
        return this.f55376d;
    }

    /* renamed from: g */
    public final boolean mo148673g() {
        boolean z = this.f55376d.size() != 0;
        for (Map.Entry next : this.f55376d.entrySet()) {
            JumioScanSide jumioScanSide = (JumioScanSide) next.getKey();
            if (!((ScanPartModel) next.getValue()).getImageData().getImage().getHasPath()) {
                return false;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final JumioScanSide mo148665a() {
        return this.f55378f;
    }

    /* renamed from: a */
    public final void mo148667a(JumioScanSide jumioScanSide) {
        this.f55378f = jumioScanSide;
    }
}
