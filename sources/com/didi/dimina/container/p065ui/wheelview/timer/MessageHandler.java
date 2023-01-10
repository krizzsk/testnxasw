package com.didi.dimina.container.p065ui.wheelview.timer;

import android.os.Handler;
import android.os.Message;
import com.didi.dimina.container.p065ui.wheelview.view.WheelView;

/* renamed from: com.didi.dimina.container.ui.wheelview.timer.MessageHandler */
public final class MessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;

    /* renamed from: a */
    private final WheelView f19747a;

    public MessageHandler(WheelView wheelView) {
        this.f19747a = wheelView;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f19747a.invalidate();
        } else if (i == 2000) {
            this.f19747a.smoothScroll(WheelView.ACTION.FLING);
        } else if (i == 3000) {
            this.f19747a.onItemSelected();
        }
    }
}
