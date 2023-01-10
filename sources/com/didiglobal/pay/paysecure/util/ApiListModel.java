package com.didiglobal.pay.paysecure.util;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/util/ApiListModel;", "Ljava/io/Serializable;", "lists", "", "", "(Ljava/util/List;)V", "getLists", "()Ljava/util/List;", "setLists", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: PaySecureApollo.kt */
final class ApiListModel implements Serializable {
    @SerializedName("lists")
    private List<String> lists;

    public ApiListModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ApiListModel copy$default(ApiListModel apiListModel, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = apiListModel.lists;
        }
        return apiListModel.copy(list);
    }

    public final List<String> component1() {
        return this.lists;
    }

    public final ApiListModel copy(List<String> list) {
        return new ApiListModel(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ApiListModel) && Intrinsics.areEqual((Object) this.lists, (Object) ((ApiListModel) obj).lists);
        }
        return true;
    }

    public int hashCode() {
        List<String> list = this.lists;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ApiListModel(lists=" + this.lists + ")";
    }

    public ApiListModel(List<String> list) {
        this.lists = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiListModel(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getLists() {
        return this.lists;
    }

    public final void setLists(List<String> list) {
        this.lists = list;
    }
}
