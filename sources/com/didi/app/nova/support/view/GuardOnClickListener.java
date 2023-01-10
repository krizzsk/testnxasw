package com.didi.app.nova.support.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

public abstract class GuardOnClickListener implements View.OnClickListener {

    /* renamed from: a */
    static boolean f10384a = true;

    /* renamed from: b */
    private static final Runnable f10385b = new Runnable() {
        public void run() {
            GuardOnClickListener.f10384a = true;
        }
    };

    public abstract void doClick(View view);

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (f10384a) {
            f10384a = false;
            view.post(f10385b);
            doClick(view);
        }
    }
}
