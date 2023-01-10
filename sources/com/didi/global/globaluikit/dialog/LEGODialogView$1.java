package com.didi.global.globaluikit.dialog;

import android.widget.CompoundButton;
import com.didi.autotracker.AutoTrackHelper;

class LEGODialogView$1 implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ C9243a this$0;

    LEGODialogView$1(C9243a aVar) {
        this.this$0 = aVar;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AutoTrackHelper.trackViewOnClick(compoundButton, z);
        this.this$0.f24413a.mIsChecked = z;
        this.this$0.f24413a.mCheckListener.onCheckedChanged(z);
    }
}
