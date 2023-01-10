package com.didi.soda.blocks.track;

import com.didi.soda.blocks.constant.TrackConst;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.sdk.config.IBlocksTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: BlocksTrackHelper.kt */
final class BlocksTrackHelper$Companion$trackCosumedTimeForNodeBuilding$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $duration;
    final /* synthetic */ long $exprDuration;
    final /* synthetic */ String $templateId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlocksTrackHelper$Companion$trackCosumedTimeForNodeBuilding$1(String str, long j, long j2) {
        super(0);
        this.$templateId = str;
        this.$duration = j;
        this.$exprDuration = j2;
    }

    public final void invoke() {
        Pair[] pairArr = new Pair[3];
        String str = this.$templateId;
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.m41339to("template_id", str);
        pairArr[1] = TuplesKt.m41339to("duration", Long.valueOf(this.$duration));
        pairArr[2] = TuplesKt.m41339to(TrackConst.Params.EXPR_DURATION, Long.valueOf(this.$exprDuration));
        Map mutableMapOf = MapsKt.mutableMapOf(pairArr);
        IBlocksTracker tracker = BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getTracker();
        if (tracker != null) {
            tracker.track(TrackConst.Event.TECH_SAILING_C_X_AETHER_NODE_TREE_CREATION, mutableMapOf);
        }
    }
}
