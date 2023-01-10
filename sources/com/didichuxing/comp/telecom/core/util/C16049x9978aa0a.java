package com.didichuxing.comp.telecom.core.util;

import android.media.AudioManager;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo148868d2 = {"<anonymous>", "", "focusChange", "", "onAudioFocusChange"}, mo148869k = 3, mo148870mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.core.util.AudioServiceHelper$registerAudioFocusListener$requestAudioFocus$1 */
/* compiled from: AudioServiceHelper.kt */
final class C16049x9978aa0a implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ AudioServiceHelper this$0;

    C16049x9978aa0a(AudioServiceHelper audioServiceHelper) {
        this.this$0 = audioServiceHelper;
    }

    public final void onAudioFocusChange(int i) {
        String access$getTAG$p = this.this$0.f49058a;
        CallLogUtil.logI(access$getTAG$p, "onAudioFocusChange - " + i);
        if (i == -3 || i == -2 || i == -1) {
            this.this$0.m36774c();
        }
    }
}
