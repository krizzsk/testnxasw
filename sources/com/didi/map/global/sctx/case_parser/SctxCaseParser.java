package com.didi.map.global.sctx.case_parser;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import com.didi.map.google.util.ConvertUtil;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.utils.ApolloUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00160\f\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\fH\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/map/global/sctx/case_parser/SctxCaseParser;", "", "()V", "COMPARE_ROUTES_MAX_POINTS_COUNT", "", "TAG", "", "kotlin.jvm.PlatformType", "jumpCodeSet", "", "Lcom/didi/map/global/sctx/case_parser/model/SctxCaseCode;", "lastPathPoints", "", "Lcom/didi/common/map/model/LatLng;", "addNewRoutePath", "", "points", "Lcom/didi/map/sdk/proto/driver_gl/DiffGeoPoints;", "clearJumpOverData", "getCode", "getCodeDebugInfo", "getShuffledList", "T", "count", "source", "isEnable", "", "recordJumpCode", "caseCode", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxCaseParser.kt */
public final class SctxCaseParser {

    /* renamed from: a */
    private final String f30033a = SctxCaseParser.class.getSimpleName();

    /* renamed from: b */
    private final Set<SctxCaseCode> f30034b = new LinkedHashSet();

    /* renamed from: c */
    private List<LatLng> f30035c;

    /* renamed from: d */
    private final int f30036d = 10;

    public final void recordJumpCode(SctxCaseCode sctxCaseCode) {
        Intrinsics.checkNotNullParameter(sctxCaseCode, "caseCode");
        this.f30034b.add(sctxCaseCode);
        DLog.m10773d(this.f30033a, Intrinsics.stringPlus("new_jump_error: ", sctxCaseCode.getPrimaryMsg()), new Object[0]);
    }

    public final String getCodeDebugInfo() {
        if (!this.f30034b.isEmpty()) {
            return CollectionsKt.joinToString$default(this.f30034b, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SctxCaseParser$getCodeDebugInfo$1.INSTANCE, 30, (Object) null);
        }
        return SctxCaseCode.JUMP_UNKNOWN.getPrimaryMsg();
    }

    public final String getCode() {
        boolean z = true;
        String joinToString$default = this.f30034b.isEmpty() ^ true ? CollectionsKt.joinToString$default(this.f30034b, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SctxCaseParser$getCode$res$1.INSTANCE, 30, (Object) null) : "";
        if (joinToString$default.length() <= 0) {
            z = false;
        }
        if (z) {
            DLog.m10773d(this.f30033a, Intrinsics.stringPlus("jump over info: ", joinToString$default), new Object[0]);
        }
        return joinToString$default;
    }

    public final void clearJumpOverData() {
        this.f30034b.clear();
    }

    public final void addNewRoutePath(DiffGeoPoints diffGeoPoints) {
        Intrinsics.checkNotNullParameter(diffGeoPoints, "points");
        List<Integer> list = diffGeoPoints.dlats;
        Boolean bool = null;
        if (Intrinsics.areEqual((Object) list == null ? null : Boolean.valueOf(!list.isEmpty()), (Object) true)) {
            List<Integer> list2 = diffGeoPoints.dlngs;
            if (Intrinsics.areEqual((Object) list2 == null ? null : Boolean.valueOf(!list2.isEmpty()), (Object) true) && diffGeoPoints.dlats.size() == diffGeoPoints.dlngs.size()) {
                List<LatLng> latLngListFromDiffGeoPoints = ConvertUtil.getLatLngListFromDiffGeoPoints(diffGeoPoints);
                List<LatLng> list3 = this.f30035c;
                if (Intrinsics.areEqual((Object) list3 == null ? null : Boolean.valueOf(!list3.isEmpty()), (Object) true)) {
                    int i = this.f30036d;
                    Intrinsics.checkNotNullExpressionValue(latLngListFromDiffGeoPoints, "curRoutePoints");
                    List<T> a = m23407a(i, latLngListFromDiffGeoPoints);
                    List<LatLng> list4 = this.f30035c;
                    if (list4 != null) {
                        bool = Boolean.valueOf(list4.containsAll(a));
                    }
                    if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                        recordJumpCode(SctxCaseCode.NEW_PATH_SAME_ROUTE);
                    } else {
                        recordJumpCode(SctxCaseCode.NEW_PATH_OFF_COURSE);
                    }
                }
                this.f30035c = latLngListFromDiffGeoPoints;
            }
        }
    }

    /* renamed from: a */
    private final <T> List<T> m23407a(int i, List<? extends T> list) {
        List list2;
        List take = CollectionsKt.take(list, 3);
        if (list.size() > 3) {
            list2 = CollectionsKt.take(CollectionsKt.shuffled(CollectionsKt.takeLast(list, list.size() - 3)), i - 3);
        } else {
            list2 = CollectionsKt.emptyList();
        }
        List<T> mutableList = CollectionsKt.toMutableList(take);
        mutableList.addAll(list2);
        return mutableList;
    }

    public final boolean isEnable() {
        return ApolloUtils.getSctxCaseParserOn();
    }
}
