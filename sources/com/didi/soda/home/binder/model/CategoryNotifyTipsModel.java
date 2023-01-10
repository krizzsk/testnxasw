package com.didi.soda.home.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/soda/home/binder/model/CategoryNotifyTipsModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "backColor", "", "getBackColor", "()Ljava/lang/String;", "setBackColor", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "imgUrl", "getImgUrl", "setImgUrl", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CategoryNotifyTipsModel.kt */
public final class CategoryNotifyTipsModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f45022a;

    /* renamed from: b */
    private String f45023b;

    /* renamed from: c */
    private String f45024c;

    public final String getBackColor() {
        return this.f45022a;
    }

    public final void setBackColor(String str) {
        this.f45022a = str;
    }

    public final String getContent() {
        return this.f45023b;
    }

    public final void setContent(String str) {
        this.f45023b = str;
    }

    public final String getImgUrl() {
        return this.f45024c;
    }

    public final void setImgUrl(String str) {
        this.f45024c = str;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/home/binder/model/CategoryNotifyTipsModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/binder/model/CategoryNotifyTipsModel;", "tip", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CategoryNotifyTipsModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CategoryNotifyTipsModel convert(TagEntity tagEntity) {
            Intrinsics.checkNotNullParameter(tagEntity, "tip");
            CategoryNotifyTipsModel categoryNotifyTipsModel = new CategoryNotifyTipsModel();
            categoryNotifyTipsModel.setBackColor(tagEntity.getBackColor());
            categoryNotifyTipsModel.setContent(tagEntity.getContent());
            categoryNotifyTipsModel.setImgUrl(tagEntity.getImgUrl());
            return categoryNotifyTipsModel;
        }
    }
}
