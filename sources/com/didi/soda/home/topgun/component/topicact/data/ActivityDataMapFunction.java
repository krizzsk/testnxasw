package com.didi.soda.home.topgun.component.topicact.data;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.datasource.listener.DataMapFunction;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.parser.FeedPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000bJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006!"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/component/topicact/data/ActivityDataMapFunction;", "Lcom/didi/soda/datasource/listener/DataMapFunction;", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "indexInList", "", "getPayloadProvider", "()Lcom/didi/soda/datasource/listener/PayloadProvider;", "setPayloadProvider", "(Lcom/didi/soda/datasource/listener/PayloadProvider;)V", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "attachContextParams", "", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "pageIndex", "index", "mapData", "", "key", "compInfos", "updateComponentIndex", "payload", "indexInPage", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ActivityDataMapFunction.kt */
public final class ActivityDataMapFunction implements DataMapFunction<ComponentEntity, RecyclerModel> {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f45445a;

    /* renamed from: b */
    private IBlockScope f45446b;

    /* renamed from: c */
    private int f45447c;

    public ActivityDataMapFunction(PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f45445a = payloadProvider;
        this.f45446b = iBlockScope;
    }

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f45445a;
    }

    public final IBlockScope getScope() {
        return this.f45446b;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f45445a = payloadProvider;
    }

    public final void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "<set-?>");
        this.f45446b = iBlockScope;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attachContextParams(com.didi.soda.blocks.model.ComponentModel r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r4.getWidgetNodeModel()
            if (r0 != 0) goto L_0x000d
            goto L_0x00b0
        L_0x000d:
            java.util.HashMap r0 = r0.getContext()
            if (r0 != 0) goto L_0x0015
            goto L_0x00b0
        L_0x0015:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "pageIndex"
            r0.put(r1, r5)
            com.didi.soda.datasource.listener.PayloadProvider r5 = r3.getPayloadProvider()
            java.lang.Object r5 = r5.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r5 = (com.didi.soda.datasource.parser.FeedPayload) r5
            java.lang.String r5 = r5.mPageId
            java.lang.String r1 = "pageId"
            r0.put(r1, r5)
            com.didi.soda.datasource.listener.PayloadProvider r5 = r3.getPayloadProvider()
            java.lang.Object r5 = r5.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r5 = (com.didi.soda.datasource.parser.FeedPayload) r5
            r1 = 0
            if (r5 != 0) goto L_0x003e
            r5 = r1
            goto L_0x0040
        L_0x003e:
            java.lang.String r5 = r5.mPageFilter
        L_0x0040:
            if (r5 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            java.lang.String r5 = ""
        L_0x0045:
            java.lang.String r2 = "filter"
            r0.put(r2, r5)
            java.lang.Object r5 = r4.getDataModel()
            boolean r2 = r5 instanceof com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity
            if (r2 == 0) goto L_0x0055
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r5
            goto L_0x0056
        L_0x0055:
            r5 = r1
        L_0x0056:
            if (r5 != 0) goto L_0x0059
            goto L_0x0065
        L_0x0059:
            java.lang.String r5 = r5.getType()
            if (r5 != 0) goto L_0x0060
            goto L_0x0065
        L_0x0060:
            java.lang.String r2 = "componentType"
            r0.put(r2, r5)
        L_0x0065:
            java.lang.Object r5 = r4.getDataModel()
            boolean r2 = r5 instanceof com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity
            if (r2 == 0) goto L_0x0070
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r5 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r5
            goto L_0x0071
        L_0x0070:
            r5 = r1
        L_0x0071:
            if (r5 != 0) goto L_0x0074
            goto L_0x007e
        L_0x0074:
            java.lang.String r5 = r5.mComponentId
            if (r5 != 0) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            java.lang.String r2 = "componentId"
            r0.put(r2, r5)
        L_0x007e:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)
            java.lang.String r2 = "absolutePosition"
            r0.put(r2, r5)
            java.lang.Object r4 = r4.getDataModel()
            boolean r5 = r4 instanceof com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity
            if (r5 == 0) goto L_0x0092
            r1 = r4
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r1 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r1
        L_0x0092:
            if (r1 != 0) goto L_0x0095
            goto L_0x00a0
        L_0x0095:
            int r4 = r1.mPosition
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "position"
            r0.put(r5, r4)
        L_0x00a0:
            java.lang.String r4 = "pageName"
            java.lang.String r5 = "homepage"
            r0.put(r4, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            java.lang.String r5 = "index"
            r0.put(r5, r4)
        L_0x00b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.data.ActivityDataMapFunction.attachContextParams(com.didi.soda.blocks.model.ComponentModel, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.didi.soda.blocks.model.ComponentModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.didi.soda.blocks.model.ComponentModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v36, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: com.didi.soda.blocks.model.ComponentModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: com.didi.soda.blocks.model.ComponentModel} */
    /* JADX WARNING: type inference failed for: r2v46 */
    /* JADX WARNING: type inference failed for: r2v50, types: [com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel] */
    /* JADX WARNING: type inference failed for: r2v52, types: [com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel> mapData(int r11, java.util.List<? extends com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity> r12) {
        /*
            r10 = this;
            java.lang.String r0 = "compInfos"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r12.size()
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x017a
            r2 = 0
        L_0x0013:
            int r3 = r2 + 1
            java.lang.Object r4 = r12.get(r2)
            com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity r4 = (com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity) r4
            if (r4 != 0) goto L_0x001f
            goto L_0x0174
        L_0x001f:
            com.didi.soda.datasource.listener.PayloadProvider<com.didi.soda.datasource.parser.FeedPayload> r5 = r10.f45445a
            java.lang.Object r5 = r5.providePayload()
            java.lang.String r6 = "payloadProvider.providePayload()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.didi.soda.datasource.parser.FeedPayload r5 = (com.didi.soda.datasource.parser.FeedPayload) r5
            r5.mPageIndex = r11
            r10.m33794a(r5, r2)
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r2 = r4.mComponentV2
            java.lang.String r2 = r2.getTmplId()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r6 = "1"
            java.lang.String r7 = "300"
            r8 = 0
            if (r2 != 0) goto L_0x00f5
            com.google.gson.JsonObject r2 = r4.data
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = r4.getType()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r2 = android.text.TextUtils.equals(r2, r7)
            if (r2 == 0) goto L_0x005f
            com.didi.soda.customer.dynamic.BlocksCommonParser$Companion r2 = com.didi.soda.customer.dynamic.BlocksCommonParser.Companion
            com.didi.soda.blocks.scope.IBlockScope r6 = r10.f45446b
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r2 = r2.parseHeader(r4, r6)
            goto L_0x0067
        L_0x005f:
            com.didi.soda.customer.dynamic.BlocksCommonParser$Companion r2 = com.didi.soda.customer.dynamic.BlocksCommonParser.Companion
            com.didi.soda.blocks.scope.IBlockScope r6 = r10.f45446b
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r2 = r2.parse(r4, r6)
        L_0x0067:
            r8 = r2
            if (r8 != 0) goto L_0x006c
            goto L_0x016f
        L_0x006c:
            r2 = r8
            com.didi.soda.blocks.model.ComponentModel r2 = (com.didi.soda.blocks.model.ComponentModel) r2
            int r4 = r5.mComponentIndex
            r10.attachContextParams(r2, r11, r4)
            goto L_0x016f
        L_0x0076:
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r2 = r4.mComponentV2
            if (r2 == 0) goto L_0x0093
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r2 = r4.mComponentV2
            java.lang.String r2 = r2.getTmplType()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L_0x0093
            com.didi.soda.blocks.model.ComponentModel r2 = com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel.convertRvEntity(r4, r5)
            r8 = r2
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r8 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r8
            goto L_0x016f
        L_0x0093:
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r2 = r4.mComponentV2
            if (r2 != 0) goto L_0x0099
            r2 = r8
            goto L_0x009d
        L_0x0099:
            java.lang.String r2 = r2.getTmplType()
        L_0x009d:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x016f
            com.didi.soda.blocks.model.ComponentModel r2 = new com.didi.soda.blocks.model.ComponentModel
            r2.<init>()
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r2 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r2
            com.google.gson.JsonParser r5 = new com.google.gson.JsonParser
            r5.<init>()
            r6 = r2
            com.didi.soda.blocks.model.ComponentModel r6 = (com.didi.soda.blocks.model.ComponentModel) r6
            r6.setDataModel(r4)
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r7 = r4.mComponentV2
            java.lang.String r7 = r7.getTmplId()
            if (r7 == 0) goto L_0x00f2
            com.didi.soda.blocks.sdk.BlocksEngine$Companion r7 = com.didi.soda.blocks.sdk.BlocksEngine.Companion
            r9 = 1
            com.didi.soda.blocks.sdk.BlocksEngine r7 = com.didi.soda.blocks.sdk.BlocksEngine.Companion.getInstance$default(r7, r8, r9, r8)
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r9 = r4.mComponentV2
            if (r9 != 0) goto L_0x00cb
            goto L_0x00cf
        L_0x00cb:
            java.lang.String r8 = r9.getTmplId()
        L_0x00cf:
            if (r8 == 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            java.lang.String r8 = ""
        L_0x00d4:
            java.lang.String r4 = com.didi.soda.customer.foundation.util.GsonUtil.toJson(r4)
            com.google.gson.JsonElement r4 = r5.parse((java.lang.String) r4)
            if (r4 == 0) goto L_0x00ea
            com.google.gson.JsonObject r4 = (com.google.gson.JsonObject) r4
            com.didi.soda.blocks.scope.IBlockScope r5 = r10.f45446b
            com.didi.soda.blocks.model.WidgetNodeModel r4 = r7.buildWidgetNode(r8, r4, r2, r5)
            r6.setWidgetNodeModel(r4)
            goto L_0x00f2
        L_0x00ea:
            java.lang.NullPointerException r11 = new java.lang.NullPointerException
            java.lang.String r12 = "null cannot be cast to non-null type com.google.gson.JsonObject"
            r11.<init>(r12)
            throw r11
        L_0x00f2:
            r8 = r2
            goto L_0x016f
        L_0x00f5:
            java.lang.String r2 = r4.mType
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 == 0) goto L_0x0109
            com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel r2 = com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel.convertBusinessFromTopic(r4, r5)
            r8 = r2
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r8 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r8
            goto L_0x016f
        L_0x0109:
            java.lang.String r2 = r4.mType
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6 = r7
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r2 = android.text.TextUtils.equals(r2, r6)
            if (r2 != 0) goto L_0x0166
            com.didi.soda.customer.foundation.rpc.entity.TemplateTagEntity r2 = r4.mComponentV2
            if (r2 != 0) goto L_0x011c
            r2 = r8
            goto L_0x0120
        L_0x011c:
            java.lang.String r2 = r2.getTmplType()
        L_0x0120:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r2 = android.text.TextUtils.equals(r2, r7)
            if (r2 == 0) goto L_0x012b
            goto L_0x0166
        L_0x012b:
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity> r2 = r4.mFilterList
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = com.didi.soda.customer.foundation.util.CollectionsUtil.isEmpty(r2)
            if (r2 != 0) goto L_0x014d
            com.didi.soda.home.topgun.binder.model.FilterRvModel r2 = new com.didi.soda.home.topgun.binder.model.FilterRvModel
            r2.<init>()
            com.didi.soda.home.topgun.component.filter.FilterDataManager$Companion r5 = com.didi.soda.home.topgun.component.filter.FilterDataManager.Companion
            r6 = 4
            com.didi.soda.home.topgun.component.filter.FilterDataManager r5 = r5.getInstanceByScene(r6)
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity> r4 = r4.mFilterList
            r5.parseFilterEntity(r4)
            r2.setFilterManager(r5)
            r8 = r2
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r8 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r8
            goto L_0x016f
        L_0x014d:
            com.google.gson.JsonObject r2 = r4.noResult
            if (r2 == 0) goto L_0x016f
            com.didi.soda.datasource.parser.impl.FeedNoResultParser r2 = new com.didi.soda.datasource.parser.impl.FeedNoResultParser
            r2.<init>()
            android.content.Context r6 = com.didi.soda.customer.app.GlobalContext.getContext()
            java.lang.String r7 = "getContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.google.gson.JsonObject r4 = r4.noResult
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r8 = r2.parseUnderdata(r6, r4, r5)
            goto L_0x016f
        L_0x0166:
            com.didi.soda.home.topgun.binder.model.LandingHeaderRvModel$Companion r2 = com.didi.soda.home.topgun.binder.model.LandingHeaderRvModel.Companion
            com.didi.soda.home.topgun.binder.model.LandingHeaderRvModel r2 = r2.convertModel(r4, r5)
            r8 = r2
            com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel r8 = (com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel) r8
        L_0x016f:
            if (r8 == 0) goto L_0x0174
            r0.add(r8)
        L_0x0174:
            if (r3 <= r1) goto L_0x0177
            goto L_0x017a
        L_0x0177:
            r2 = r3
            goto L_0x0013
        L_0x017a:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.topgun.component.topicact.data.ActivityDataMapFunction.mapData(int, java.util.List):java.util.List");
    }

    /* renamed from: a */
    private final void m33794a(FeedPayload feedPayload, int i) {
        if (feedPayload.mPageIndex == 0) {
            this.f45447c = i;
        } else {
            this.f45447c++;
        }
        feedPayload.mComponentIndex = this.f45447c;
    }
}
