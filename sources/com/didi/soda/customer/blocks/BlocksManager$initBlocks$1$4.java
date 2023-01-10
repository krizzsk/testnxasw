package com.didi.soda.customer.blocks;

import android.text.TextUtils;
import com.didi.soda.blocks.sdk.config.IBlocksTracker;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/soda/customer/blocks/BlocksManager$initBlocks$1$4", "Lcom/didi/soda/blocks/sdk/config/IBlocksTracker;", "track", "", "event", "", "params", "", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlocksManager.kt */
public final class BlocksManager$initBlocks$1$4 implements IBlocksTracker {
    BlocksManager$initBlocks$1$4() {
    }

    public void track(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(map, "params");
        if (!TextUtils.isEmpty(str)) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
            if (!map.isEmpty()) {
                create.addAllEventParam(map);
            }
            create.build().track();
        }
    }
}
