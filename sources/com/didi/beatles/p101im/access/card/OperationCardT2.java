package com.didi.beatles.p101im.access.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.beatles.p101im.access.msg.OperationMsgT2;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.event.IMSkipToMainActivityEvent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.OmegaUtil;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.imageView.IMRoundedImageView;
import com.didi.beatles.p101im.views.messageCard.IMBaseRenderView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.access.card.OperationCardT2 */
public class OperationCardT2 extends IMBaseRenderView {

    /* renamed from: a */
    private TextView f10561a;

    /* renamed from: b */
    private TextView f10562b;

    /* renamed from: c */
    private IMRoundedImageView f10563c;

    /* renamed from: d */
    private ImageView f10564d;

    /* renamed from: e */
    private ImageView f10565e;

    /* renamed from: f */
    private View f10566f;

    /* renamed from: g */
    private View f10567g;

    /* renamed from: h */
    private View f10568h;

    /* renamed from: i */
    private boolean f10569i;

    /* renamed from: j */
    private OperationMsgT2 f10570j;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public OperationCardT2(Context context, MessageAdapter messageAdapter) {
        super(context, 1, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.onemessage_operation_card_template2, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f10561a = (TextView) findViewById(R.id.onemessage_title);
        this.f10562b = (TextView) findViewById(R.id.onemessage_content);
        this.f10563c = (IMRoundedImageView) findViewById(R.id.onemessage_image);
        this.f10564d = (ImageView) findViewById(R.id.onemessage_new_flag);
        this.f10565e = (ImageView) findViewById(R.id.onemessage_over_time_flag);
        this.f10566f = findViewById(R.id.onemessage_image_container);
        this.f10568h = findViewById(R.id.overtime_cover);
        this.f10567g = findViewById(R.id.im_look_more_btn);
        this.f10563c.setCornerType(1);
        this.f10564d.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_onemessage_flag_new));
        this.f10565e.setImageResource(IMResource.getDrawableID(R.drawable.im_overtime_icon));
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        OperationMsgT2 operationMsgT2 = (OperationMsgT2) IMJsonUtil.objectFromJson(iMMessage.getContent(), OperationMsgT2.class);
        this.f10570j = operationMsgT2;
        if (operationMsgT2 != null) {
            int windowWidth = IMViewUtil.getWindowWidth(getContext()) - IMViewUtil.dp2px(getContext(), 20.0f);
            ViewGroup.LayoutParams layoutParams = this.f10563c.getLayoutParams();
            layoutParams.width = windowWidth;
            if (this.f10570j.imageWidth == 0 || this.f10570j.imageHeight == 0) {
                layoutParams.height = (windowWidth * 264) / 710;
            } else {
                layoutParams.height = (int) (((float) windowWidth) * (((float) this.f10570j.imageHeight) / ((float) this.f10570j.imageWidth)));
            }
            this.f10563c.setLayoutParams(layoutParams);
            if (this.f10570j.overTime == 0 || System.currentTimeMillis() <= this.f10570j.overTime * 1000) {
                this.f10569i = false;
                this.f10568h.setVisibility(8);
                this.f10565e.setVisibility(8);
            } else {
                this.f10568h.setVisibility(0);
                this.f10565e.setVisibility(0);
                this.f10569i = true;
            }
            if (this.f10570j.title == null || this.f10570j.title.equals("")) {
                this.f10561a.setVisibility(8);
            } else {
                this.f10561a.setVisibility(0);
                this.f10561a.setText(this.f10570j.title);
            }
            if (this.f10570j.content == null || this.f10570j.content.equals("")) {
                this.f10562b.setVisibility(8);
            } else {
                this.f10562b.setVisibility(0);
                this.f10562b.setText(HighlightHelper.processHighlight(this.f10570j.content));
            }
            if (this.f10570j.image == null || this.f10570j.image.equals("")) {
                this.f10566f.setVisibility(8);
                this.f10563c.setVisibility(8);
                this.f10564d.setVisibility(8);
            } else {
                this.f10566f.setVisibility(0);
                this.f10563c.setVisibility(0);
                this.f10563c.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
                if (this.f10570j.image.endsWith(".gif")) {
                    BtsImageLoader.getInstance().loadIntoAsGif(this.f10570j.image, this.f10563c, new Callback() {
                        public void onFailed() {
                        }

                        public void onStart() {
                        }

                        public void onSuccess(Bitmap bitmap) {
                        }
                    });
                } else {
                    BtsImageLoader.getInstance().loadInto((Object) this.f10570j.image, (View) this.f10563c, IMResource.getDrawableID(R.drawable.im_nomix_onemessage_imagebg));
                }
                if (iMMessage.isRead() || this.f10569i) {
                    this.f10564d.setVisibility(8);
                } else {
                    this.f10564d.setVisibility(0);
                }
            }
            if (TextUtils.isEmpty(this.f10570j.action)) {
                this.f10567g.setVisibility(8);
            } else {
                this.f10567g.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        IMLog.m10021e("OperationCardT2", "T2 onViewClick");
        OmegaUtil.trackOperationOmega(1002, this.message);
        if (!this.message.isRead()) {
            this.message.setIsRead(true);
            IMManager.getInstance().updateMessage(this.message);
            this.f10564d.setVisibility(8);
        }
        OperationMsgT2 operationMsgT2 = this.f10570j;
        String str = operationMsgT2 != null ? operationMsgT2.action : "";
        if (this.f10570j != null && !TextUtils.isEmpty(str)) {
            if (this.f10570j.overTime == 0 || System.currentTimeMillis() <= this.f10570j.overTime * 1000) {
                if (this.f10570j.luncherMode == 1) {
                    EventBus.getDefault().post(new IMSkipToMainActivityEvent(str));
                } else {
                    IMCommonUtil.startUriActivity(this.context, str);
                }
                OmegaUtil.trackOperationOmegaNew(this.message);
                return;
            }
            SystemUtils.showToast(IMTipsToast.makeText(getContext(), (CharSequence) IMResource.getString(R.string.im_over_time_tip), 1));
        }
    }
}
