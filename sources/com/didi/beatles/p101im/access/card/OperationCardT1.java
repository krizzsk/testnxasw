package com.didi.beatles.p101im.access.card;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.beatles.p101im.access.msg.OperationMsgT1;
import com.didi.beatles.p101im.access.utils.Parser;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.event.IMSkipToMainActivityEvent;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;
import com.didi.sofa.utils.TimeUtils;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.access.card.OperationCardT1 */
public class OperationCardT1 extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10557a;

    /* renamed from: b */
    private TextView f10558b;

    /* renamed from: c */
    private TextView f10559c;

    /* renamed from: d */
    private View f10560d;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public OperationCardT1(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.onemessage_operation_card_template1, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10557a = (TextView) findViewById(R.id.onemessage_title);
        this.f10558b = (TextView) findViewById(R.id.onemessage_content);
        this.f10559c = (TextView) findViewById(R.id.onemessage_time);
        this.f10560d = findViewById(R.id.im_look_more_btn);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        OperationMsgT1 parseOperationMsgT1 = Parser.parseOperationMsgT1(iMMessage.getContent());
        if (parseOperationMsgT1 != null) {
            if (parseOperationMsgT1.title == null || parseOperationMsgT1.title.equals("")) {
                this.f10557a.setVisibility(8);
            } else {
                this.f10557a.setVisibility(0);
                this.f10557a.setText(parseOperationMsgT1.title);
            }
            if (parseOperationMsgT1.content == null || parseOperationMsgT1.content.equals("")) {
                this.f10558b.setVisibility(8);
            } else {
                this.f10558b.setVisibility(0);
                this.f10558b.setText(HighlightHelper.processHighlight(parseOperationMsgT1.content));
            }
            if (parseOperationMsgT1.timeStamp == 0) {
                this.f10559c.setVisibility(8);
                ((ViewGroup.MarginLayoutParams) this.f10558b.getLayoutParams()).topMargin = IMViewUtil.dp2px(this.context, 3.0f);
            } else {
                ((ViewGroup.MarginLayoutParams) this.f10558b.getLayoutParams()).topMargin = IMViewUtil.dp2px(this.context, 9.0f);
                this.f10559c.setVisibility(0);
                this.f10559c.setText(new SimpleDateFormat(TimeUtils.YEAR_HOUR).format(new Date(parseOperationMsgT1.timeStamp)));
            }
            if (TextUtils.isEmpty(parseOperationMsgT1.action)) {
                this.f10560d.setVisibility(8);
            } else {
                this.f10560d.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        IMLog.m10020d("OperationCardT1", "T1 onViewClick");
        OmegaUtil.trackOperationOmega(1001, this.message);
        OperationMsgT1 parseOperationMsgT1 = Parser.parseOperationMsgT1(this.message.getContent());
        String str = parseOperationMsgT1 != null ? parseOperationMsgT1.action : "";
        if (parseOperationMsgT1 != null && !TextUtils.isEmpty(str)) {
            if (parseOperationMsgT1.luncherMode == 1) {
                EventBus.getDefault().post(new IMSkipToMainActivityEvent(str));
            } else {
                IMCommonUtil.startUriActivity(this.context, str);
            }
        }
    }
}
