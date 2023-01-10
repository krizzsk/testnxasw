package com.lyft.kronos.internal.ntp;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 4, 0})
/* compiled from: SntpService.kt */
final class SntpServiceImpl$syncInBackground$1 implements Runnable {
    final /* synthetic */ SntpServiceImpl this$0;

    SntpServiceImpl$syncInBackground$1(SntpServiceImpl sntpServiceImpl) {
        this.this$0 = sntpServiceImpl;
    }

    public final void run() {
        this.this$0.sync();
    }
}
