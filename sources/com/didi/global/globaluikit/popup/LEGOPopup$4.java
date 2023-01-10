package com.didi.global.globaluikit.popup;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

class LEGOPopup$4 implements View.OnClickListener {
    final /* synthetic */ C9259a this$0;

    LEGOPopup$4(C9259a aVar) {
        this.this$0 = aVar;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
    }
}
