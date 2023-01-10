package com.jumio.core.credentials;

import com.jumio.core.data.ScanMode;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentPart;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.data.document.DocumentVariant;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioScanSide;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import jumio.core.C19495o;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.jumio.core.credentials.a */
/* compiled from: CountrySelection.kt */
public final class C20950a implements Serializable {

    /* renamed from: a */
    public final SettingsModel f57498a;

    /* renamed from: b */
    public final C19495o f57499b;

    /* renamed from: c */
    public ArrayList<Country> f57500c;

    /* renamed from: d */
    public ArrayList<JumioDocumentType> f57501d;

    /* renamed from: e */
    public JumioDocumentVariant f57502e;

    /* renamed from: f */
    public Country f57503f;

    /* renamed from: g */
    public DocumentType f57504g;

    /* renamed from: h */
    public DocumentVariant f57505h;

    public C20950a(SettingsModel settingsModel, C19495o oVar) {
        JumioDocument l;
        Intrinsics.checkNotNullParameter(settingsModel, "settingsModel");
        Intrinsics.checkNotNullParameter(oVar, "credentialsDataModel");
        this.f57498a = settingsModel;
        this.f57499b = oVar;
        this.f57501d = oVar.mo148689i();
        this.f57502e = oVar.mo148690j();
        ArrayList<Country> a = settingsModel.getCountryModel().mo172209a(this.f57501d, this.f57502e);
        ArrayList<String> h = oVar.mo148688h();
        if (h != null && (h.isEmpty() ^ true)) {
            ArrayList<Country> arrayList = new ArrayList<>();
            for (T next : a) {
                if (this.f57499b.mo148688h().contains(((Country) next).getIsoCode())) {
                    arrayList.add(next);
                }
            }
            a = arrayList;
        }
        this.f57500c = a;
        if (a == null || a.isEmpty()) {
            this.f57501d = null;
            this.f57502e = null;
            this.f57500c = this.f57498a.getCountryModel().mo172209a((ArrayList<JumioDocumentType>) null, (JumioDocumentVariant) null);
        }
        ArrayList<Country> arrayList2 = this.f57500c;
        if (arrayList2 != null) {
            CollectionsKt.sort(arrayList2);
        }
        Map<String, List<JumioDocument>> a2 = mo171989a();
        Country a3 = (a2.size() != 1 || !mo171994b((String) CollectionsKt.first(a2.keySet()))) ? null : mo171987a((String) CollectionsKt.first(a2.keySet()));
        this.f57503f = a3;
        this.f57504g = null;
        this.f57505h = null;
        if (a3 != null) {
            ArrayList<DocumentType> a4 = this.f57498a.getCountryModel().mo172208a(a3, this.f57501d, this.f57502e);
            if (a4.size() == 1) {
                this.f57504g = a4.get(0);
            }
            DocumentType documentType = this.f57504g;
            if (documentType != null) {
                JumioDocumentVariant jumioDocumentVariant = this.f57502e;
                if (jumioDocumentVariant != null) {
                    Intrinsics.checkNotNull(jumioDocumentVariant);
                    if (documentType.hasVariant(jumioDocumentVariant)) {
                        JumioDocumentVariant jumioDocumentVariant2 = this.f57502e;
                        Intrinsics.checkNotNull(jumioDocumentVariant2);
                        this.f57505h = documentType.getVariant(jumioDocumentVariant2);
                    }
                }
                if (documentType.getVariants().size() == 1) {
                    this.f57505h = documentType.getVariants().get(0);
                }
            }
        }
        String k = this.f57499b.mo148691k();
        if (k != null && (l = this.f57499b.mo148692l()) != null) {
            mo171993b(k, l);
        }
    }

    /* renamed from: a */
    public final Map<String, List<JumioDocument>> mo171989a() {
        HashMap hashMap = new HashMap();
        ArrayList<Country> arrayList = this.f57500c;
        if (!(arrayList == null || arrayList == null)) {
            for (Country country : arrayList) {
                ArrayList arrayList2 = new ArrayList();
                for (DocumentType documentType : mo171988a(country)) {
                    for (DocumentVariant documentVariant : documentType.getVariants()) {
                        if ((this.f57502e != null && documentVariant.getVariant() == this.f57502e) || this.f57502e == null) {
                            arrayList2.add(new JumioDocument(documentType.getIdType(), documentVariant.getVariant()));
                        }
                    }
                }
                String isoCode = country.getIsoCode();
                List unmodifiableList = Collections.unmodifiableList(arrayList2);
                Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(documentList)");
                hashMap.put(isoCode, unmodifiableList);
            }
        }
        Map<String, List<JumioDocument>> unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(countryMap)");
        return unmodifiableMap;
    }

    /* renamed from: b */
    public final SelectionModel mo171992b() {
        if (!mo171996d()) {
            return null;
        }
        Country country = this.f57503f;
        Intrinsics.checkNotNull(country);
        DocumentType documentType = this.f57504g;
        Intrinsics.checkNotNull(documentType);
        DocumentVariant documentVariant = this.f57505h;
        Intrinsics.checkNotNull(documentVariant);
        return new SelectionModel(country, documentType, documentVariant);
    }

    /* renamed from: c */
    public final String mo171995c() {
        if (mo171994b(this.f57498a.getCountryForIp())) {
            return this.f57498a.getCountryForIp();
        }
        return null;
    }

    /* renamed from: d */
    public final boolean mo171996d() {
        return (this.f57503f == null || this.f57504g == null || this.f57505h == null) ? false : true;
    }

    /* renamed from: b */
    public final void mo171993b(String str, JumioDocument jumioDocument) throws IllegalArgumentException {
        boolean z;
        T t;
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        Country a = mo171987a(str);
        if (a != null) {
            this.f57503f = a;
            Iterator<T> it = mo171988a(a).iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((DocumentType) t).getIdType() == jumioDocument.getType()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            DocumentType documentType = (DocumentType) t;
            this.f57504g = documentType;
            if (documentType != null) {
                if (documentType != null && documentType.hasVariant(jumioDocument.getVariant())) {
                    z = true;
                }
                if (z) {
                    DocumentType documentType2 = this.f57504g;
                    if (documentType2 != null) {
                        this.f57505h = documentType2.getVariant(jumioDocument.getVariant());
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Unsupported document variant".toString());
            }
            throw new IllegalArgumentException("Unsupported document type".toString());
        }
        throw new IllegalArgumentException("Unsupported country code".toString());
    }

    /* renamed from: b */
    public final boolean mo171994b(String str) {
        return mo171987a(str) != null;
    }

    /* renamed from: a */
    public final boolean mo171991a(String str, JumioDocument jumioDocument) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "isoCode");
        Intrinsics.checkNotNullParameter(jumioDocument, "document");
        Country a = mo171987a(str);
        if (a == null) {
            return false;
        }
        Iterator<T> it = mo171988a(a).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((DocumentType) t).getIdType() == jumioDocument.getType()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        DocumentType documentType = (DocumentType) t;
        if (documentType == null) {
            return false;
        }
        return documentType.hasVariant(jumioDocument.getVariant());
    }

    /* renamed from: a */
    public final void mo171990a(SortedMap<JumioScanSide, ScanPartModel> sortedMap) {
        DocumentVariant documentVariant;
        Intrinsics.checkNotNullParameter(sortedMap, "scanData");
        sortedMap.clear();
        SelectionModel b = mo171992b();
        if (b != null && (documentVariant = this.f57505h) != null) {
            for (DocumentPart documentPart : documentVariant.getParts()) {
                JumioScanSide side = documentPart.getSide();
                JumioScanSide side2 = documentPart.getSide();
                ScanMode scanMode = documentPart.getExtraction().get(0);
                Intrinsics.checkNotNullExpressionValue(scanMode, "documentPart.extraction[0]");
                sortedMap.put(side, new IDScanPartModel(side2, scanMode, documentVariant.getFormat(), b));
            }
        }
    }

    /* renamed from: a */
    public final Country mo171987a(String str) {
        ArrayList<Country> arrayList;
        T t = null;
        if (str == null || (arrayList = this.f57500c) == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual((Object) ((Country) next).getIsoCode(), (Object) str)) {
                t = next;
                break;
            }
        }
        return (Country) t;
    }

    /* renamed from: a */
    public final ArrayList<DocumentType> mo171988a(Country country) {
        return this.f57498a.getCountryModel().mo172208a(country, this.f57501d, this.f57502e);
    }
}
