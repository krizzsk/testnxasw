package com.didi.global.globalgenerickit.template.misoperation;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import java.util.HashMap;

/* compiled from: MisOperationBinder */
class ViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ C9186a this$0;
    final /* synthetic */ String val$url;

    ViewHolder$1(C9186a aVar, String str) {
        this.this$0 = aVar;
        this.val$url = str;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.this$0.f24115a != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("who", "card");
            this.this$0.f24115a.handleEvent("xpanel_button_ck", this.val$url, hashMap);
        }
    }
}
