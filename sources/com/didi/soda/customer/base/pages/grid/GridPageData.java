package com.didi.soda.customer.base.pages.grid;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridPageData;", "", "title", "", "items", "", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "(Ljava/lang/String;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridPresenter.kt */
public final class GridPageData {

    /* renamed from: a */
    private final String f42958a;

    /* renamed from: b */
    private final List<GridItemModel> f42959b;

    public static /* synthetic */ GridPageData copy$default(GridPageData gridPageData, String str, List<GridItemModel> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gridPageData.f42958a;
        }
        if ((i & 2) != 0) {
            list = gridPageData.f42959b;
        }
        return gridPageData.copy(str, list);
    }

    public final String component1() {
        return this.f42958a;
    }

    public final List<GridItemModel> component2() {
        return this.f42959b;
    }

    public final GridPageData copy(String str, List<GridItemModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return new GridPageData(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GridPageData)) {
            return false;
        }
        GridPageData gridPageData = (GridPageData) obj;
        return Intrinsics.areEqual((Object) this.f42958a, (Object) gridPageData.f42958a) && Intrinsics.areEqual((Object) this.f42959b, (Object) gridPageData.f42959b);
    }

    public int hashCode() {
        return (this.f42958a.hashCode() * 31) + this.f42959b.hashCode();
    }

    public String toString() {
        return "GridPageData(title=" + this.f42958a + ", items=" + this.f42959b + VersionRange.RIGHT_OPEN;
    }

    public GridPageData(String str, List<GridItemModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.f42958a = str;
        this.f42959b = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridPageData(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, list);
    }

    public final String getTitle() {
        return this.f42958a;
    }

    public final List<GridItemModel> getItems() {
        return this.f42959b;
    }
}
