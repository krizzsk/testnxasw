package com.didi.soda.blocks.sdk.config;

import android.content.Context;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.optimize.BlocksOptimizeModel;
import com.didi.soda.blocks.track.TrackConfig;
import com.didi.soda.blocks.widget.Buildable;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\u0018\u0000 b2\u00020\u0001:\u0002abB\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BÉ\u0002\b\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012*\u0010\u000b\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u00010\fj\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u0001`\u000f\u0012*\u0010\u0010\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\r\u0018\u00010\fj\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\r\u0018\u0001`\u000f\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0013\u0018\u00010\u0017\u0012$\b\u0002\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0018\u00010\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&R>\u0010\u0010\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\r\u0018\u00010\fj\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\r\u0018\u0001`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010!\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R.\u0010\u0016\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0013\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00104\"\u0004\bH\u00106R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00104\"\u0004\bN\u00106R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010<\"\u0004\bP\u0010>R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u00104\"\u0004\b^\u00106R>\u0010\u000b\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u00010\fj\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\u0018\u0001`\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010(\"\u0004\b`\u0010*¨\u0006c"}, mo148868d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksConfig;", "", "builder", "Lcom/didi/soda/blocks/sdk/config/BlocksConfig$Builder;", "(Lcom/didi/soda/blocks/sdk/config/BlocksConfig$Builder;)V", "debug", "", "nameSpace", "", "context", "Landroid/content/Context;", "widgetList2Regist", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/didi/soda/blocks/widget/Buildable;", "Lkotlin/collections/ArrayList;", "actionList2Regist", "Lcom/didi/soda/blocks/action/BaseAction;", "widget", "", "logic", "event", "global", "Lkotlin/Function0;", "local", "logger", "Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "tracker", "Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "fontHandler", "Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;", "imageLoader", "Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "fontsAssetsPath", "optimizeModel", "Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;", "trackConfig", "Lcom/didi/soda/blocks/track/TrackConfig;", "(ZLjava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Ljava/util/Map;Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;Ljava/lang/String;Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;Lcom/didi/soda/blocks/track/TrackConfig;)V", "getActionList2Regist", "()Ljava/util/ArrayList;", "setActionList2Regist", "(Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getDebug", "()Z", "setDebug", "(Z)V", "getEvent", "()Ljava/util/Map;", "setEvent", "(Ljava/util/Map;)V", "getFontHandler", "()Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;", "setFontHandler", "(Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;)V", "getFontsAssetsPath", "()Ljava/lang/String;", "setFontsAssetsPath", "(Ljava/lang/String;)V", "getGlobal", "()Lkotlin/jvm/functions/Function0;", "setGlobal", "(Lkotlin/jvm/functions/Function0;)V", "getImageLoader", "()Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "setImageLoader", "(Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;)V", "getLocal", "setLocal", "getLogger", "()Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "setLogger", "(Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;)V", "getLogic", "setLogic", "getNameSpace", "setNameSpace", "getOptimizeModel", "()Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;", "setOptimizeModel", "(Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;)V", "getTrackConfig", "()Lcom/didi/soda/blocks/track/TrackConfig;", "setTrackConfig", "(Lcom/didi/soda/blocks/track/TrackConfig;)V", "getTracker", "()Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "setTracker", "(Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;)V", "getWidget", "setWidget", "getWidgetList2Regist", "setWidgetList2Regist", "Builder", "Companion", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: BlocksConfig.kt */
public final class BlocksConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ArrayList<Class<? extends BaseAction>> actionList2Regist;
    private Context context;
    private boolean debug;
    private Map<String, String> event;
    private IBlocksFontHandler fontHandler;
    private String fontsAssetsPath;

    /* renamed from: global  reason: collision with root package name */
    private Function0<? extends Map<String, ? extends Object>> f62474global;
    private IBlocksImageLoader imageLoader;
    private Map<String, ? extends Map<String, String>> local;
    private IBlocksLogger logger;
    private Map<String, String> logic;
    private String nameSpace;
    private BlocksOptimizeModel optimizeModel;
    private TrackConfig trackConfig;
    private IBlocksTracker tracker;
    private Map<String, String> widget;
    private ArrayList<Class<? extends Buildable>> widgetList2Regist;

    public /* synthetic */ BlocksConfig(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private BlocksConfig(boolean z, String str, Context context2, ArrayList<Class<? extends Buildable>> arrayList, ArrayList<Class<? extends BaseAction>> arrayList2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Function0<? extends Map<String, ? extends Object>> function0, Map<String, ? extends Map<String, String>> map4, IBlocksLogger iBlocksLogger, IBlocksTracker iBlocksTracker, IBlocksFontHandler iBlocksFontHandler, IBlocksImageLoader iBlocksImageLoader, String str2, BlocksOptimizeModel blocksOptimizeModel, TrackConfig trackConfig2) {
        this.debug = z;
        this.nameSpace = str;
        this.context = context2;
        this.widgetList2Regist = arrayList;
        this.actionList2Regist = arrayList2;
        this.widget = map;
        this.logic = map2;
        this.event = map3;
        this.f62474global = function0;
        this.local = map4;
        this.logger = iBlocksLogger;
        this.tracker = iBlocksTracker;
        this.fontHandler = iBlocksFontHandler;
        this.imageLoader = iBlocksImageLoader;
        this.fontsAssetsPath = str2;
        this.optimizeModel = blocksOptimizeModel;
        this.trackConfig = trackConfig2;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final String getNameSpace() {
        return this.nameSpace;
    }

    public final void setNameSpace(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.nameSpace = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        this.context = context2;
    }

    public final ArrayList<Class<? extends Buildable>> getWidgetList2Regist() {
        return this.widgetList2Regist;
    }

    public final void setWidgetList2Regist(ArrayList<Class<? extends Buildable>> arrayList) {
        this.widgetList2Regist = arrayList;
    }

    public final ArrayList<Class<? extends BaseAction>> getActionList2Regist() {
        return this.actionList2Regist;
    }

    public final void setActionList2Regist(ArrayList<Class<? extends BaseAction>> arrayList) {
        this.actionList2Regist = arrayList;
    }

    public final Map<String, String> getWidget() {
        return this.widget;
    }

    public final void setWidget(Map<String, String> map) {
        this.widget = map;
    }

    public final Map<String, String> getLogic() {
        return this.logic;
    }

    public final void setLogic(Map<String, String> map) {
        this.logic = map;
    }

    public final Map<String, String> getEvent() {
        return this.event;
    }

    public final void setEvent(Map<String, String> map) {
        this.event = map;
    }

    public final Function0<Map<String, Object>> getGlobal() {
        return this.f62474global;
    }

    public final void setGlobal(Function0<? extends Map<String, ? extends Object>> function0) {
        this.f62474global = function0;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ BlocksConfig(boolean r21, java.lang.String r22, android.content.Context r23, java.util.ArrayList r24, java.util.ArrayList r25, java.util.Map r26, java.util.Map r27, java.util.Map r28, kotlin.jvm.functions.Function0 r29, java.util.Map r30, com.didi.soda.blocks.sdk.config.IBlocksLogger r31, com.didi.soda.blocks.sdk.config.IBlocksTracker r32, com.didi.soda.blocks.sdk.config.IBlocksFontHandler r33, com.didi.soda.blocks.sdk.config.IBlocksImageLoader r34, java.lang.String r35, com.didi.soda.blocks.optimize.BlocksOptimizeModel r36, com.didi.soda.blocks.track.TrackConfig r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
        /*
            r20 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            r3 = 0
            goto L_0x000b
        L_0x0009:
            r3 = r21
        L_0x000b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r1 = r2
            java.util.Map r1 = (java.util.Map) r1
            r12 = r1
            goto L_0x0017
        L_0x0015:
            r12 = r30
        L_0x0017:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0023
            r1 = r2
            com.didi.soda.blocks.optimize.BlocksOptimizeModel r1 = (com.didi.soda.blocks.optimize.BlocksOptimizeModel) r1
            r18 = r1
            goto L_0x0025
        L_0x0023:
            r18 = r36
        L_0x0025:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0030
            r0 = r2
            com.didi.soda.blocks.track.TrackConfig r0 = (com.didi.soda.blocks.track.TrackConfig) r0
            r19 = r0
            goto L_0x0032
        L_0x0030:
            r19 = r37
        L_0x0032:
            r2 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r13 = r31
            r14 = r32
            r15 = r33
            r16 = r34
            r17 = r35
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.blocks.sdk.config.BlocksConfig.<init>(boolean, java.lang.String, android.content.Context, java.util.ArrayList, java.util.ArrayList, java.util.Map, java.util.Map, java.util.Map, kotlin.jvm.functions.Function0, java.util.Map, com.didi.soda.blocks.sdk.config.IBlocksLogger, com.didi.soda.blocks.sdk.config.IBlocksTracker, com.didi.soda.blocks.sdk.config.IBlocksFontHandler, com.didi.soda.blocks.sdk.config.IBlocksImageLoader, java.lang.String, com.didi.soda.blocks.optimize.BlocksOptimizeModel, com.didi.soda.blocks.track.TrackConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Map<String, Map<String, String>> getLocal() {
        return this.local;
    }

    public final void setLocal(Map<String, ? extends Map<String, String>> map) {
        this.local = map;
    }

    public final IBlocksLogger getLogger() {
        return this.logger;
    }

    public final void setLogger(IBlocksLogger iBlocksLogger) {
        this.logger = iBlocksLogger;
    }

    public final IBlocksTracker getTracker() {
        return this.tracker;
    }

    public final void setTracker(IBlocksTracker iBlocksTracker) {
        this.tracker = iBlocksTracker;
    }

    public final IBlocksFontHandler getFontHandler() {
        return this.fontHandler;
    }

    public final void setFontHandler(IBlocksFontHandler iBlocksFontHandler) {
        this.fontHandler = iBlocksFontHandler;
    }

    public final IBlocksImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final void setImageLoader(IBlocksImageLoader iBlocksImageLoader) {
        this.imageLoader = iBlocksImageLoader;
    }

    public final String getFontsAssetsPath() {
        return this.fontsAssetsPath;
    }

    public final void setFontsAssetsPath(String str) {
        this.fontsAssetsPath = str;
    }

    public final BlocksOptimizeModel getOptimizeModel() {
        return this.optimizeModel;
    }

    public final void setOptimizeModel(BlocksOptimizeModel blocksOptimizeModel) {
        this.optimizeModel = blocksOptimizeModel;
    }

    public final TrackConfig getTrackConfig() {
        return this.trackConfig;
    }

    public final void setTrackConfig(TrackConfig trackConfig2) {
        this.trackConfig = trackConfig2;
    }

    private BlocksConfig(Builder builder) {
        this(builder.getDebug(), builder.getNameSpace(), builder.getContext(), builder.getWidgetList2Regist(), builder.getActionList2Regist(), builder.getWidget(), builder.getLogic(), builder.getEvent(), builder.getGlobal(), builder.getLocal(), builder.getLogger(), builder.getTracker(), builder.getFontHandler(), builder.getImageLoader(), builder.getFontsAssetsPath(), builder.getOptimizeModel(), builder.getTrackConfig());
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksConfig$Companion;", "", "()V", "build", "Lcom/didi/soda/blocks/sdk/config/BlocksConfig;", "block", "Lkotlin/Function1;", "Lcom/didi/soda/blocks/sdk/config/BlocksConfig$Builder;", "", "Lkotlin/ExtensionFunctionType;", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: BlocksConfig.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BlocksConfig build(Function1<? super Builder, Unit> function1) {
            Intrinsics.checkParameterIsNotNull(function1, "block");
            Builder builder = new Builder();
            function1.invoke(builder);
            return builder.build();
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010^\u001a\u00020_R>\u0010\u0003\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u00010\u0004j\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0018\u0001`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010*\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\u0019\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R6\u00106\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001c\"\u0004\b8\u0010\u001eR\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\u001a\u0010B\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010'\"\u0004\bD\u0010)R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001c\"\u0004\bY\u0010\u001eR>\u0010Z\u001a&\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020[0\u0005\u0018\u00010\u0004j\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020[0\u0005\u0018\u0001`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\t\"\u0004\b]\u0010\u000b¨\u0006`"}, mo148868d2 = {"Lcom/didi/soda/blocks/sdk/config/BlocksConfig$Builder;", "", "()V", "actionList2Regist", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/didi/soda/blocks/action/BaseAction;", "Lkotlin/collections/ArrayList;", "getActionList2Regist", "()Ljava/util/ArrayList;", "setActionList2Regist", "(Ljava/util/ArrayList;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "debug", "", "getDebug", "()Z", "setDebug", "(Z)V", "event", "", "", "getEvent", "()Ljava/util/Map;", "setEvent", "(Ljava/util/Map;)V", "fontHandler", "Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;", "getFontHandler", "()Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;", "setFontHandler", "(Lcom/didi/soda/blocks/sdk/config/IBlocksFontHandler;)V", "fontsAssetsPath", "getFontsAssetsPath", "()Ljava/lang/String;", "setFontsAssetsPath", "(Ljava/lang/String;)V", "global", "Lkotlin/Function0;", "getGlobal", "()Lkotlin/jvm/functions/Function0;", "setGlobal", "(Lkotlin/jvm/functions/Function0;)V", "imageLoader", "Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "getImageLoader", "()Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "setImageLoader", "(Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;)V", "local", "getLocal", "setLocal", "logger", "Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "getLogger", "()Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "setLogger", "(Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;)V", "logic", "getLogic", "setLogic", "nameSpace", "getNameSpace", "setNameSpace", "optimizeModel", "Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;", "getOptimizeModel", "()Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;", "setOptimizeModel", "(Lcom/didi/soda/blocks/optimize/BlocksOptimizeModel;)V", "trackConfig", "Lcom/didi/soda/blocks/track/TrackConfig;", "getTrackConfig", "()Lcom/didi/soda/blocks/track/TrackConfig;", "setTrackConfig", "(Lcom/didi/soda/blocks/track/TrackConfig;)V", "tracker", "Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "getTracker", "()Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "setTracker", "(Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;)V", "widget", "getWidget", "setWidget", "widgetList2Regist", "Lcom/didi/soda/blocks/widget/Buildable;", "getWidgetList2Regist", "setWidgetList2Regist", "build", "Lcom/didi/soda/blocks/sdk/config/BlocksConfig;", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: BlocksConfig.kt */
    public static final class Builder {
        private ArrayList<Class<? extends BaseAction>> actionList2Regist;
        private Context context;
        private boolean debug;
        private Map<String, String> event;
        private IBlocksFontHandler fontHandler;
        private String fontsAssetsPath;

        /* renamed from: global  reason: collision with root package name */
        private Function0<? extends Map<String, ? extends Object>> f62475global;
        private IBlocksImageLoader imageLoader;
        private Map<String, ? extends Map<String, String>> local;
        private IBlocksLogger logger;
        private Map<String, String> logic;
        private String nameSpace = Const.ConfigConst.DEFAULT_NAMESPACE;
        private BlocksOptimizeModel optimizeModel;
        private TrackConfig trackConfig;
        private IBlocksTracker tracker;
        private Map<String, String> widget;
        private ArrayList<Class<? extends Buildable>> widgetList2Regist;

        public final boolean getDebug() {
            return this.debug;
        }

        public final void setDebug(boolean z) {
            this.debug = z;
        }

        public final String getNameSpace() {
            return this.nameSpace;
        }

        public final void setNameSpace(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.nameSpace = str;
        }

        public final Context getContext() {
            return this.context;
        }

        public final void setContext(Context context2) {
            this.context = context2;
        }

        public final ArrayList<Class<? extends Buildable>> getWidgetList2Regist() {
            return this.widgetList2Regist;
        }

        public final void setWidgetList2Regist(ArrayList<Class<? extends Buildable>> arrayList) {
            this.widgetList2Regist = arrayList;
        }

        public final ArrayList<Class<? extends BaseAction>> getActionList2Regist() {
            return this.actionList2Regist;
        }

        public final void setActionList2Regist(ArrayList<Class<? extends BaseAction>> arrayList) {
            this.actionList2Regist = arrayList;
        }

        public final Map<String, String> getWidget() {
            return this.widget;
        }

        public final void setWidget(Map<String, String> map) {
            this.widget = map;
        }

        public final Map<String, String> getLogic() {
            return this.logic;
        }

        public final void setLogic(Map<String, String> map) {
            this.logic = map;
        }

        public final Map<String, String> getEvent() {
            return this.event;
        }

        public final void setEvent(Map<String, String> map) {
            this.event = map;
        }

        public final Function0<Map<String, Object>> getGlobal() {
            return this.f62475global;
        }

        public final void setGlobal(Function0<? extends Map<String, ? extends Object>> function0) {
            this.f62475global = function0;
        }

        public final Map<String, Map<String, String>> getLocal() {
            return this.local;
        }

        public final void setLocal(Map<String, ? extends Map<String, String>> map) {
            this.local = map;
        }

        public final IBlocksLogger getLogger() {
            return this.logger;
        }

        public final void setLogger(IBlocksLogger iBlocksLogger) {
            this.logger = iBlocksLogger;
        }

        public final IBlocksTracker getTracker() {
            return this.tracker;
        }

        public final void setTracker(IBlocksTracker iBlocksTracker) {
            this.tracker = iBlocksTracker;
        }

        public final IBlocksFontHandler getFontHandler() {
            return this.fontHandler;
        }

        public final void setFontHandler(IBlocksFontHandler iBlocksFontHandler) {
            this.fontHandler = iBlocksFontHandler;
        }

        public final IBlocksImageLoader getImageLoader() {
            return this.imageLoader;
        }

        public final void setImageLoader(IBlocksImageLoader iBlocksImageLoader) {
            this.imageLoader = iBlocksImageLoader;
        }

        public final String getFontsAssetsPath() {
            return this.fontsAssetsPath;
        }

        public final void setFontsAssetsPath(String str) {
            this.fontsAssetsPath = str;
        }

        public final BlocksOptimizeModel getOptimizeModel() {
            return this.optimizeModel;
        }

        public final void setOptimizeModel(BlocksOptimizeModel blocksOptimizeModel) {
            this.optimizeModel = blocksOptimizeModel;
        }

        public final TrackConfig getTrackConfig() {
            return this.trackConfig;
        }

        public final void setTrackConfig(TrackConfig trackConfig2) {
            this.trackConfig = trackConfig2;
        }

        public final BlocksConfig build() {
            return new BlocksConfig(this, (DefaultConstructorMarker) null);
        }
    }
}
