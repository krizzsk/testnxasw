package com.didi.entrega.home.component.feed.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.home.component.feed.entity.HomeOrderEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, mo148868d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeOrderCardRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "orderDesc", "", "getOrderDesc", "()Ljava/lang/String;", "setOrderDesc", "(Ljava/lang/String;)V", "orderIds", "", "getOrderIds", "()Ljava/util/List;", "setOrderIds", "(Ljava/util/List;)V", "type", "", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeOrderCardRvModel.kt */
public final class HomeOrderCardRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private Integer f22543a;

    /* renamed from: b */
    private String f22544b;

    /* renamed from: c */
    private List<String> f22545c;

    public final Integer getType() {
        return this.f22543a;
    }

    public final void setType(Integer num) {
        this.f22543a = num;
    }

    public final String getOrderDesc() {
        return this.f22544b;
    }

    public final void setOrderDesc(String str) {
        this.f22544b = str;
    }

    public final List<String> getOrderIds() {
        return this.f22545c;
    }

    public final void setOrderIds(List<String> list) {
        this.f22545c = list;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeOrderCardRvModel$Companion;", "", "()V", "convertRvModel", "Lcom/didi/entrega/home/component/feed/binder/model/HomeOrderCardRvModel;", "entity", "Lcom/didi/entrega/home/component/feed/entity/HomeOrderEntity;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeOrderCardRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeOrderCardRvModel convertRvModel(HomeOrderEntity homeOrderEntity) {
            Intrinsics.checkNotNullParameter(homeOrderEntity, "entity");
            HomeOrderCardRvModel homeOrderCardRvModel = new HomeOrderCardRvModel();
            homeOrderCardRvModel.setType(homeOrderEntity.getType());
            homeOrderCardRvModel.setOrderDesc(homeOrderEntity.getOrderDesc());
            homeOrderCardRvModel.setOrderIds(homeOrderEntity.getOrderIds());
            return homeOrderCardRvModel;
        }
    }
}
