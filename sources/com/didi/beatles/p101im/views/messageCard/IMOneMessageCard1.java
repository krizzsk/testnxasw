package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.card.HighlightHelper;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.sofa.utils.TimeUtils;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOneMessageCard1 */
public class IMOneMessageCard1 extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12165a;

    /* renamed from: b */
    private TextView f12166b;

    /* renamed from: c */
    private TextView f12167c;

    /* renamed from: d */
    private TextView f12168d;

    /* renamed from: e */
    private View f12169e;

    public IMOneMessageCard1(Context context) {
        super(context);
        this.f12165a = context;
        m10447a();
    }

    public IMOneMessageCard1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12165a = context;
        m10447a();
    }

    /* renamed from: a */
    private void m10447a() {
        View inflate = inflate(this.f12165a, R.layout.onemessage_profile_card_template1, this);
        this.f12166b = (TextView) inflate.findViewById(R.id.onemessage_title);
        this.f12167c = (TextView) inflate.findViewById(R.id.onemessage_content);
        this.f12168d = (TextView) inflate.findViewById(R.id.onemessage_time);
        this.f12169e = inflate.findViewById(R.id.im_look_more_btn);
    }

    public void bindViewData(final IMNewstandResponse.NewStandMessage newStandMessage, int i) {
        if (newStandMessage != null) {
            if (!TextUtils.isEmpty(newStandMessage.title)) {
                this.f12166b.setText(newStandMessage.title);
            } else {
                this.f12166b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newStandMessage.content)) {
                this.f12167c.setText(HighlightHelper.processHighlight(newStandMessage.content));
            } else {
                this.f12167c.setVisibility(8);
            }
            if (newStandMessage.timestamp == 0) {
                this.f12168d.setVisibility(8);
            } else {
                this.f12168d.setText(new SimpleDateFormat(TimeUtils.YEAR_HOUR).format(new Date(newStandMessage.timestamp)));
            }
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMOneMessageCard1.this.f12165a, newStandMessage.action);
                }
            });
            if (TextUtils.isEmpty(newStandMessage.action)) {
                this.f12169e.setVisibility(8);
            } else {
                this.f12169e.setVisibility(0);
            }
        }
    }
}
