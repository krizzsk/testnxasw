package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.access.card.HighlightHelper;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.event.IMShowCustomWordDialogEvent;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.messageCard.IMSysMsgRenderView */
public class IMSysMsgRenderView extends IMBaseRenderView {

    /* renamed from: c */
    private static final String f12221c = "add_custom_expression:";

    /* renamed from: a */
    private TextView f12222a;

    /* renamed from: b */
    private boolean f12223b;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
    }

    public IMSysMsgRenderView(Context context, int i, MessageAdapter messageAdapter, boolean z) {
        super(context, i, messageAdapter);
        this.f12223b = z;
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_message_sys_layout, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12222a = (TextView) findViewById(R.id.time_title);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        SpannableString spannableString;
        if (iMMessage != null && !this.f12223b) {
            if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
                this.f12222a.setTextSize(0, (float) IMViewUtil.dp2px(getContext(), 10.0f));
                this.f12222a.setTextColor(Color.parseColor("#FF919599"));
                this.f12222a.setTypeface(Typeface.DEFAULT_BOLD);
            }
            if (this.message.getMessageExtendInfo() != null) {
                String str = this.message.getMessageExtendInfo().light_str;
                final String str2 = this.message.getMessageExtendInfo().light_link;
                new SpannableString("");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    spannableString = HighlightHelper.processHighlight(str, new ClickableSpan() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (!IMTextUtil.isEmpty(str2)) {
                                if (str2.startsWith(IMSysMsgRenderView.f12221c)) {
                                    EventBus.getDefault().post(new IMShowCustomWordDialogEvent(str2.replace(IMSysMsgRenderView.f12221c, "")));
                                } else if (IMSysMsgRenderView.this.itemListener == null || !IMSysMsgRenderView.this.itemListener.onBubbleClick(IMSysMsgRenderView.this.message)) {
                                    IMCommonUtil.startUriActivity(IMSysMsgRenderView.this.context, str2, (Object) null);
                                }
                            }
                        }

                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setUnderlineText(false);
                            textPaint.setColor(HighlightHelper.processIMHighlightColor());
                        }
                    });
                } else if (TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    spannableString = new SpannableString(this.message.getContent());
                } else {
                    spannableString = HighlightHelper.processHighlight(str);
                }
                this.f12222a.setText(spannableString);
                this.f12222a.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    /* renamed from: com.didi.beatles.im.views.messageCard.IMSysMsgRenderView$IntentSpan */
    class IntentSpan extends ClickableSpan implements ParcelableSpan {
        private Intent mIntent;

        public int describeContents() {
            return 0;
        }

        public int getSpanTypeId() {
            return 100;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        public IntentSpan(Intent intent) {
            this.mIntent = intent;
        }

        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            view.getContext().startActivity(this.mIntent);
        }

        public Intent getIntent() {
            return this.mIntent;
        }
    }
}
