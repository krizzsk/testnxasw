package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMRichInfoMsgBody;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMParseUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMRichInfoRenderView */
public class IMRichInfoRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f12201a;

    /* renamed from: b */
    private TextView f12202b;

    /* renamed from: c */
    private View f12203c;

    /* renamed from: d */
    private TextView f12204d;

    /* renamed from: e */
    private IMRichInfoMsgBody f12205e;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMRichInfoRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        View inflate = this.inflater.inflate(R.layout.im_rich_info_msg_view, viewGroup, false);
        if (inflate != null) {
            if (this.isMine) {
                inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_white_bubble_selector));
            } else {
                inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
            }
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12201a = (TextView) findViewById(R.id.im_rich_info_title);
        this.f12202b = (TextView) findViewById(R.id.im_rich_info_content);
        this.f12203c = findViewById(R.id.im_rich_info_divider);
        this.f12204d = (TextView) findViewById(R.id.im_rich_info_anchor);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        IMRichInfoMsgBody iMRichInfoMsgBody = (IMRichInfoMsgBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMRichInfoMsgBody.class);
        this.f12205e = iMRichInfoMsgBody;
        if (iMRichInfoMsgBody == null) {
            this.f12201a.setVisibility(8);
            this.f12203c.setVisibility(8);
            this.f12204d.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(iMRichInfoMsgBody.title)) {
            this.f12201a.setVisibility(0);
            int parseColor = IMParseUtil.parseColor(iMRichInfoMsgBody.titleColor);
            if (parseColor > 0) {
                this.f12201a.setTextColor(parseColor);
            }
            this.f12201a.setText(iMRichInfoMsgBody.title);
        } else {
            this.f12201a.setVisibility(8);
        }
        if (!iMRichInfoMsgBody.isEmpty()) {
            this.f12202b.setVisibility(0);
            iMRichInfoMsgBody.bindView(this.f12202b);
        } else {
            this.f12202b.setText("");
        }
        if (iMRichInfoMsgBody.linkInfo == null || TextUtils.isEmpty(iMRichInfoMsgBody.linkInfo.uri)) {
            this.f12203c.setVisibility(8);
            this.f12204d.setVisibility(8);
            return;
        }
        this.f12203c.setVisibility(0);
        this.f12204d.setVisibility(0);
        int parseColor2 = IMParseUtil.parseColor(iMRichInfoMsgBody.linkInfo.anchorColor);
        if (parseColor2 > 0) {
            this.f12204d.setTextColor(parseColor2);
        }
        this.f12204d.setText(iMRichInfoMsgBody.linkInfo.anchor);
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        IMRichInfoMsgBody iMRichInfoMsgBody = this.f12205e;
        if (iMRichInfoMsgBody != null && iMRichInfoMsgBody.linkInfo != null) {
            IMCommonUtil.startUriActivity(this.context, this.f12205e.linkInfo.uri, (Object) null);
        }
    }
}
