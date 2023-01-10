package com.jumio.core.models;

import com.datadog.android.rum.RumAttributes;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.data.document.DocumentVariant;
import com.jumio.core.model.StaticModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, mo148868d2 = {"Lcom/jumio/core/models/SelectionModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/data/country/Country;", "a", "Lcom/jumio/core/data/country/Country;", "getCountry", "()Lcom/jumio/core/data/country/Country;", "country", "Lcom/jumio/core/data/document/DocumentType;", "b", "Lcom/jumio/core/data/document/DocumentType;", "getDocumentType", "()Lcom/jumio/core/data/document/DocumentType;", "documentType", "Lcom/jumio/core/data/document/DocumentVariant;", "c", "Lcom/jumio/core/data/document/DocumentVariant;", "getVariant", "()Lcom/jumio/core/data/document/DocumentVariant;", "variant", "<init>", "(Lcom/jumio/core/data/country/Country;Lcom/jumio/core/data/document/DocumentType;Lcom/jumio/core/data/document/DocumentVariant;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
@PersistWith("SelectionModel")
/* compiled from: SelectionModel.kt */
public final class SelectionModel implements StaticModel {

    /* renamed from: a */
    public final Country f57697a;

    /* renamed from: b */
    public final DocumentType f57698b;

    /* renamed from: c */
    public final DocumentVariant f57699c;

    public SelectionModel(Country country, DocumentType documentType, DocumentVariant documentVariant) {
        Intrinsics.checkNotNullParameter(country, "country");
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        Intrinsics.checkNotNullParameter(documentVariant, RumAttributes.VARIANT);
        this.f57697a = country;
        this.f57698b = documentType;
        this.f57699c = documentVariant;
    }

    public final Country getCountry() {
        return this.f57697a;
    }

    public final DocumentType getDocumentType() {
        return this.f57698b;
    }

    public final DocumentVariant getVariant() {
        return this.f57699c;
    }
}
