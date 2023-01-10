package com.didi.soda.customer.blocks;

import com.didi.soda.blocks.sdk.config.IBlocksLogger;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t"}, mo148868d2 = {"com/didi/soda/customer/blocks/BlocksManager$initBlocks$1$3", "Lcom/didi/soda/blocks/sdk/config/IBlocksLogger;", "debug", "", "tag", "", "msg", "error", "info", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlocksManager.kt */
public final class BlocksManager$initBlocks$1$3 implements IBlocksLogger {
    BlocksManager$initBlocks$1$3() {
    }

    public void debug(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        LogUtil.m32584d(str, str2);
    }

    public void info(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        LogUtil.m32588i(str, str2);
    }

    public void error(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        LogUtil.m32586e(str, str2);
    }
}
