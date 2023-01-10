package com.didi.entrega.home.component.feed.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.home.component.feed.entity.HomeCouponEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, mo148868d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeCouponRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "couponTip", "", "getCouponTip", "()Ljava/lang/String;", "setCouponTip", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeCouponRvModel.kt */
public final class HomeCouponRvModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f22541a;

    /* renamed from: b */
    private String f22542b;

    public final String getCouponTip() {
        return this.f22541a;
    }

    public final void setCouponTip(String str) {
        this.f22541a = str;
    }

    public final String getUrl() {
        return this.f22542b;
    }

    public final void setUrl(String str) {
        this.f22542b = str;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/home/component/feed/binder/model/HomeCouponRvModel$Companion;", "", "()V", "convertRvModel", "Lcom/didi/entrega/home/component/feed/binder/model/HomeCouponRvModel;", "entity", "Lcom/didi/entrega/home/component/feed/entity/HomeCouponEntity;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HomeCouponRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeCouponRvModel convertRvModel(HomeCouponEntity homeCouponEntity) {
            Intrinsics.checkNotNullParameter(homeCouponEntity, "entity");
            HomeCouponRvModel homeCouponRvModel = new HomeCouponRvModel();
            homeCouponRvModel.setUrl(homeCouponEntity.getUrl());
            homeCouponRvModel.setCouponTip(homeCouponEntity.getCouponTip());
            return homeCouponRvModel;
        }
    }
}
