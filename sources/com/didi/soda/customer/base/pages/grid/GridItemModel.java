package com.didi.soda.customer.base.pages.grid;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.map.setting.common.NavType;
import com.didi.soda.customer.foundation.rpc.entity.grid.GridItemEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "cateId", "", "getCateId", "()Ljava/lang/String;", "setCateId", "(Ljava/lang/String;)V", "img", "getImg", "setImg", "subItems", "getSubItems", "setSubItems", "title", "getTitle", "setTitle", "type", "", "getType", "()I", "setType", "(I)V", "url", "getUrl", "setUrl", "getCateIdForTrack", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridItemModel.kt */
public final class GridItemModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42951a;

    /* renamed from: b */
    private String f42952b;

    /* renamed from: c */
    private String f42953c;

    /* renamed from: d */
    private String f42954d;

    /* renamed from: e */
    private int f42955e;

    /* renamed from: f */
    private String f42956f = "";

    public final String getTitle() {
        return this.f42951a;
    }

    public final void setTitle(String str) {
        this.f42951a = str;
    }

    public final String getImg() {
        return this.f42952b;
    }

    public final void setImg(String str) {
        this.f42952b = str;
    }

    public final String getUrl() {
        return this.f42953c;
    }

    public final void setUrl(String str) {
        this.f42953c = str;
    }

    public final String getSubItems() {
        return this.f42954d;
    }

    public final void setSubItems(String str) {
        this.f42954d = str;
    }

    public final int getType() {
        return this.f42955e;
    }

    public final void setType(int i) {
        this.f42955e = i;
    }

    public final String getCateId() {
        return this.f42956f;
    }

    public final void setCateId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42956f = str;
    }

    public final String getCateIdForTrack() {
        if (this.f42955e == 3) {
            return NavType.OTHER;
        }
        return this.f42956f;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridItemModel$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/grid/GridItemEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: GridItemModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GridItemModel create(GridItemEntity gridItemEntity) {
            Intrinsics.checkNotNullParameter(gridItemEntity, "entity");
            GridItemModel gridItemModel = new GridItemModel();
            gridItemModel.setTitle(gridItemEntity.getTitle());
            gridItemModel.setImg(gridItemEntity.getImg());
            gridItemModel.setUrl(gridItemEntity.getUrl());
            Integer type = gridItemEntity.getType();
            gridItemModel.setType(type == null ? 0 : type.intValue());
            String cateId = gridItemEntity.getCateId();
            if (cateId == null) {
                cateId = "";
            }
            gridItemModel.setCateId(cateId);
            if (gridItemEntity.getSubItems() != null) {
                gridItemModel.setSubItems(GsonUtil.toJson(gridItemEntity.getSubItems()));
            }
            return gridItemModel;
        }
    }
}
