package com.didi.beatles.p101im.event;

import com.didi.beatles.p101im.views.dialog.IMAddCommonWordDialog;

/* renamed from: com.didi.beatles.im.event.IMAddCustomWordEvent */
public class IMAddCustomWordEvent {
    public IMAddCommonWordDialog.CustomWord customWord;

    public IMAddCustomWordEvent(IMAddCommonWordDialog.CustomWord customWord2) {
        this.customWord = customWord2;
    }
}
