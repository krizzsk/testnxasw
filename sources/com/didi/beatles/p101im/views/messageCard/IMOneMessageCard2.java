package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.card.HighlightHelper;
import com.didi.beatles.p101im.api.entity.IMNewstandResponse;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMOneMessageCard2 */
public class IMOneMessageCard2 extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12170a;

    /* renamed from: b */
    private TextView f12171b;

    /* renamed from: c */
    private TextView f12172c;

    /* renamed from: d */
    private ImageView f12173d;

    /* renamed from: e */
    private ImageView f12174e;

    /* renamed from: f */
    private View f12175f;

    public IMOneMessageCard2(Context context) {
        super(context);
        this.f12170a = context;
        m10449a();
    }

    public IMOneMessageCard2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12170a = context;
        m10449a();
    }

    /* renamed from: a */
    private void m10449a() {
        View inflate = inflate(this.f12170a, R.layout.onemessage_profile_card_template2, this);
        this.f12171b = (TextView) inflate.findViewById(R.id.onemessage_title);
        this.f12172c = (TextView) inflate.findViewById(R.id.onemessage_content);
        this.f12173d = (ImageView) inflate.findViewById(R.id.onemessage_image);
        this.f12175f = inflate.findViewById(R.id.im_look_more_btn);
    }

    public void bindViewData(final IMNewstandResponse.NewStandMessage newStandMessage, int i) {
        if (newStandMessage != null) {
            if (!TextUtils.isEmpty(newStandMessage.title)) {
                this.f12171b.setText(newStandMessage.title);
            } else {
                this.f12171b.setVisibility(8);
            }
            if (!TextUtils.isEmpty(newStandMessage.content)) {
                this.f12172c.setText(HighlightHelper.processHighlight(newStandMessage.content));
            } else {
                this.f12172c.setVisibility(8);
            }
            BtsImageLoader.getInstance().loadRoundInto(newStandMessage.image, this.f12173d);
            setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMOneMessageCard2.this.f12170a, newStandMessage.action);
                }
            });
            if (TextUtils.isEmpty(newStandMessage.action)) {
                this.f12175f.setVisibility(8);
            } else {
                this.f12175f.setVisibility(0);
            }
        }
    }
}
