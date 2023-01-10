package com.didi.entrega.customer.foundation.rpc.entity;

import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CateInfoEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "cateInfo", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfo;", "getCateInfo", "()Ljava/util/List;", "setCateInfo", "(Ljava/util/List;)V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CateInfoEntity.kt */
public final class CateInfoEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4465273832189941718L;
    @SerializedName("cateInfo")
    private List<CommonInfoEntity.CateInfo> cateInfo;

    public final List<CommonInfoEntity.CateInfo> getCateInfo() {
        return this.cateInfo;
    }

    public final void setCateInfo(List<CommonInfoEntity.CateInfo> list) {
        this.cateInfo = list;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/CateInfoEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CateInfoEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
