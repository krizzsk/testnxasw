package com.didi.soda.home.datasource;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.dynamic.DynamicDataMapFunction;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.datasource.listener.PayloadProvider;
import com.didi.soda.datasource.parser.FeedParser;
import com.didi.soda.datasource.parser.FeedParserFactory;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.datasource.parser.ParseType;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0!H\u0004R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\""}, mo148868d2 = {"Lcom/didi/soda/home/datasource/ShopCateLandingDataMapFunction;", "Lcom/didi/soda/customer/dynamic/DynamicDataMapFunction;", "payloadProvider", "Lcom/didi/soda/datasource/listener/PayloadProvider;", "Lcom/didi/soda/datasource/parser/FeedPayload;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "(Lcom/didi/soda/datasource/listener/PayloadProvider;Lcom/didi/soda/blocks/scope/IBlockScope;)V", "mIndexOffset", "", "getMIndexOffset", "()I", "setMIndexOffset", "(I)V", "getPayloadProvider", "()Lcom/didi/soda/datasource/listener/PayloadProvider;", "setPayloadProvider", "(Lcom/didi/soda/datasource/listener/PayloadProvider;)V", "attachContextParams", "", "componentModel", "Lcom/didi/soda/blocks/model/ComponentModel;", "pageIndex", "index", "isParsable", "", "type", "", "parse", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "itemJsonObject", "Lcom/google/gson/JsonObject;", "receivedDataTypeList", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ShopCateLandingDataMapFunction.kt */
public final class ShopCateLandingDataMapFunction extends DynamicDataMapFunction {

    /* renamed from: a */
    private PayloadProvider<FeedPayload> f45109a;

    /* renamed from: b */
    private int f45110b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopCateLandingDataMapFunction(PayloadProvider<FeedPayload> payloadProvider, IBlockScope iBlockScope) {
        super(iBlockScope);
        Intrinsics.checkNotNullParameter(payloadProvider, "payloadProvider");
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        this.f45109a = payloadProvider;
    }

    public final PayloadProvider<FeedPayload> getPayloadProvider() {
        return this.f45109a;
    }

    public final void setPayloadProvider(PayloadProvider<FeedPayload> payloadProvider) {
        Intrinsics.checkNotNullParameter(payloadProvider, "<set-?>");
        this.f45109a = payloadProvider;
    }

    public int getMIndexOffset() {
        return this.f45110b;
    }

    public void setMIndexOffset(int i) {
        this.f45110b = i;
    }

    public boolean isParsable(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        return receivedDataTypeList().contains(str);
    }

    public RecyclerModel parse(String str, JsonObject jsonObject, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(jsonObject, "itemJsonObject");
        FeedParser feedParser = (FeedParser) FeedParserFactory.getFactory().getParser(str);
        if (feedParser != null) {
            FeedPayload providePayload = this.f45109a.providePayload();
            Intrinsics.checkNotNullExpressionValue(providePayload, "payloadProvider.providePayload()");
            FeedPayload feedPayload = providePayload;
            feedPayload.mPageIndex = i;
            feedPayload.mComponentIndex = i2;
            RecyclerModel parse = feedParser.parse(GlobalContext.getContext(), jsonObject, feedPayload);
            if (parse == null) {
                ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_HOME_CATE_COMPONENT_DATA_ERROR).addModuleName("home").addErrorMsg("component data parse error").addParam("type", str).build().trackError();
            }
            return parse;
        }
        ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_HOME_CATE_COMPONENT_TYPE_ERROR).addModuleName("home").addErrorMsg("Unsupported component type").addParam("type", str).build().trackError();
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.google.gson.JsonObject} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attachContextParams(com.didi.soda.blocks.model.ComponentModel r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.didi.soda.blocks.model.WidgetNodeModel r0 = r5.getWidgetNodeModel()
            if (r0 != 0) goto L_0x000d
            goto L_0x00e8
        L_0x000d:
            java.util.HashMap r0 = r0.getContext()
            if (r0 != 0) goto L_0x0015
            goto L_0x00e8
        L_0x0015:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r1 = "pageIndex"
            r0.put(r1, r6)
            java.lang.String r6 = "page"
            java.lang.String r1 = "specialpage"
            r0.put(r6, r1)
            java.lang.String r6 = "module"
            java.lang.String r1 = "7777"
            r0.put(r6, r1)
            com.didi.soda.datasource.listener.PayloadProvider r6 = r4.getPayloadProvider()
            java.lang.Object r6 = r6.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r6 = (com.didi.soda.datasource.parser.FeedPayload) r6
            java.lang.String r6 = r6.mPageId
            java.lang.String r1 = "pageId"
            r0.put(r1, r6)
            com.didi.soda.datasource.listener.PayloadProvider r6 = r4.getPayloadProvider()
            java.lang.Object r6 = r6.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r6 = (com.didi.soda.datasource.parser.FeedPayload) r6
            r1 = 0
            if (r6 != 0) goto L_0x004c
            r6 = r1
            goto L_0x004e
        L_0x004c:
            java.lang.String r6 = r6.mCateId
        L_0x004e:
            java.lang.String r2 = ""
            if (r6 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r6 = r2
        L_0x0054:
            java.lang.String r3 = "cateId"
            r0.put(r3, r6)
            com.didi.soda.datasource.listener.PayloadProvider r6 = r4.getPayloadProvider()
            java.lang.Object r6 = r6.providePayload()
            com.didi.soda.datasource.parser.FeedPayload r6 = (com.didi.soda.datasource.parser.FeedPayload) r6
            if (r6 != 0) goto L_0x0067
            r6 = r1
            goto L_0x0069
        L_0x0067:
            java.lang.String r6 = r6.mPageFilter
        L_0x0069:
            if (r6 == 0) goto L_0x006c
            r2 = r6
        L_0x006c:
            java.lang.String r6 = "filter"
            r0.put(r6, r2)
            java.lang.Object r6 = r5.getDataModel()
            boolean r2 = r6 instanceof com.google.gson.JsonObject
            if (r2 == 0) goto L_0x007c
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x007d
        L_0x007c:
            r6 = r1
        L_0x007d:
            if (r6 != 0) goto L_0x0080
            goto L_0x0095
        L_0x0080:
            java.lang.String r2 = "type"
            com.google.gson.JsonElement r6 = r6.get(r2)
            if (r6 != 0) goto L_0x0089
            goto L_0x0095
        L_0x0089:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x0090
            goto L_0x0095
        L_0x0090:
            java.lang.String r2 = "componentType"
            r0.put(r2, r6)
        L_0x0095:
            java.lang.Object r6 = r5.getDataModel()
            boolean r2 = r6 instanceof com.google.gson.JsonObject
            if (r2 == 0) goto L_0x00a0
            com.google.gson.JsonObject r6 = (com.google.gson.JsonObject) r6
            goto L_0x00a1
        L_0x00a0:
            r6 = r1
        L_0x00a1:
            if (r6 != 0) goto L_0x00a4
            goto L_0x00b7
        L_0x00a4:
            java.lang.String r2 = "componentId"
            com.google.gson.JsonElement r6 = r6.get(r2)
            if (r6 != 0) goto L_0x00ad
            goto L_0x00b7
        L_0x00ad:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x00b4
            goto L_0x00b7
        L_0x00b4:
            r0.put(r2, r6)
        L_0x00b7:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            java.lang.String r7 = "absolutePosition"
            r0.put(r7, r6)
            java.lang.Object r5 = r5.getDataModel()
            boolean r6 = r5 instanceof com.google.gson.JsonObject
            if (r6 == 0) goto L_0x00cb
            r1 = r5
            com.google.gson.JsonObject r1 = (com.google.gson.JsonObject) r1
        L_0x00cb:
            if (r1 != 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            java.lang.String r5 = "position"
            com.google.gson.JsonElement r6 = r1.get(r5)
            if (r6 != 0) goto L_0x00d7
            goto L_0x00e1
        L_0x00d7:
            java.lang.String r6 = r6.getAsString()
            if (r6 != 0) goto L_0x00de
            goto L_0x00e1
        L_0x00de:
            r0.put(r5, r6)
        L_0x00e1:
            java.lang.String r5 = "pageName"
            java.lang.String r6 = "homepage"
            r0.put(r5, r6)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.datasource.ShopCateLandingDataMapFunction.attachContextParams(com.didi.soda.blocks.model.ComponentModel, int, int):void");
    }

    /* access modifiers changed from: protected */
    public final List<String> receivedDataTypeList() {
        return CollectionsKt.listOf("1", "99", "900", ParseType.TYPE_LANDING_FILTER, ParseType.TYPE_CATEGORY_NOTIFY);
    }
}
