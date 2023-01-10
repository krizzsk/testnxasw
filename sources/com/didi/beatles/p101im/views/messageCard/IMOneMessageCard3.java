package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOneMessageCard3 */
public class IMOneMessageCard3 extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12176a;

    /* renamed from: b */
    private ImageView f12177b;

    public IMOneMessageCard3(Context context) {
        super(context);
        this.f12176a = context;
        m10451a();
    }

    public IMOneMessageCard3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12176a = context;
        m10451a();
    }

    /* renamed from: a */
    private void m10451a() {
        this.f12177b = (ImageView) inflate(this.f12176a, R.layout.onemessage_profile_card_template3, this).findViewById(R.id.onemessage_image);
    }

    public void bindViewData(final IMNewstandResponse.NewStandMessage newStandMessage, int i) {
        if (newStandMessage != null) {
            if (i == 2) {
                findViewById(R.id.driver_line).setVisibility(8);
            }
            BtsImageLoader.getInstance().loadRoundInto(newStandMessage.image, this.f12177b);
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMOneMessageCard3.this.f12176a, newStandMessage.action);
                }
            });
        }
    }
}
