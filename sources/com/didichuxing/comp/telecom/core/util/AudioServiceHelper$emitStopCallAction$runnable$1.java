package com.didichuxing.comp.telecom.core.util;

import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManager;
import com.didichuxing.comp.telecom.core.base.ICall;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* compiled from: AudioServiceHelper.kt */
final class AudioServiceHelper$emitStopCallAction$runnable$1 implements Runnable {
    final /* synthetic */ AudioServiceHelper this$0;

    AudioServiceHelper$emitStopCallAction$runnable$1(AudioServiceHelper audioServiceHelper) {
        this.this$0 = audioServiceHelper;
    }

    public final void run() {
        ICall mCurrentCall;
        boolean isPhoneCalling = PhoneCallHelper.Companion.getInstance().isPhoneCalling();
        String access$getTAG$p = this.this$0.f49058a;
        CallLogUtil.logI(access$getTAG$p, "emitStopCallAction - post stop, is phoneCalling:" + isPhoneCalling);
        if (isPhoneCalling && (mCurrentCall = CallManager.Companion.getInstance().getMCurrentCall()) != null) {
            mCurrentCall.forceStop();
        }
    }
}
