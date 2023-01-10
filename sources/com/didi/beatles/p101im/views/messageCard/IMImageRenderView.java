package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.event.IMViewImageEvent;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMStreetUtils;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.imageView.IMRoundedImageView;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.messageCard.IMImageRenderView */
public class IMImageRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12155a = IMImageRenderView.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMRoundedImageView f12156b;

    /* renamed from: c */
    private ProgressBar f12157c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f12158d;

    /* renamed from: e */
    private RelativeLayout.LayoutParams f12159e;

    /* renamed from: f */
    private int f12160f;

    /* renamed from: g */
    private View f12161g;

    /* renamed from: h */
    private TextView f12162h;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMImageRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
        this.f12160f = IMViewUtil.dp2px(context, 260.0f);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_mine_image_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12156b = (IMRoundedImageView) findViewById(R.id.img_item_view);
        this.f12157c = (ProgressBar) findViewById(R.id.img_progressBar);
        this.f12158d = (TextView) findViewById(R.id.tv_image_load_failed);
        this.f12161g = findViewById(R.id.img_expired_view);
        this.f12162h = (TextView) findViewById(R.id.illegalTextOnPicture);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        RelativeLayout.LayoutParams a = m10437a((float) iMMessage.getWidth(), (float) iMMessage.getHeight());
        this.f12159e = a;
        this.f12156b.setLayoutParams(a);
        this.f12158d.setText(IMResource.getString(R.string.im_tap_to_reload));
        IMViewUtil.hide((View) this.f12158d);
        if (IMStreetUtils.isExpiredPic(this.message)) {
            IMViewUtil.show(this.f12161g);
            IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getBusinessId());
            if (currentBusinessConfig != null && !TextUtils.isEmpty(currentBusinessConfig.getIllegalTextOnPicture())) {
                this.f12162h.setText(currentBusinessConfig.getIllegalTextOnPicture());
            }
            IMViewUtil.hide((View) this.f12156b);
            this.f12161g.getLayoutParams().width = this.f12159e.width;
            this.f12161g.getLayoutParams().height = this.f12159e.height;
            return;
        }
        IMViewUtil.show((View) this.f12156b);
        IMViewUtil.hide(this.f12161g);
        m10441b();
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (!IMStreetUtils.isExpiredPic(this.message)) {
            if (this.f12158d.getVisibility() == 0) {
                m10441b();
            } else {
                EventBus.getDefault().post(new IMViewImageEvent(this.message));
            }
        }
    }

    private String getFilePath() {
        return TextUtils.isEmpty(this.message.getContent()) ? this.message.getFile_name() : this.message.getContent();
    }

    /* renamed from: b */
    private void m10441b() {
        if (this.mViewLocation == 2) {
            BtsImageLoader.getInstance().download(getFilePath(), this.f12159e.width, this.f12159e.height, new Callback() {
                public void onStart() {
                    IMViewUtil.hide((View) IMImageRenderView.this.f12158d);
                }

                public void onSuccess(Bitmap bitmap) {
                    IMImageRenderView.this.f12156b.setImageBitmap(bitmap);
                }

                public void onFailed() {
                    IMViewUtil.show((View) IMImageRenderView.this.f12158d);
                }
            });
        } else {
            BtsImageLoader.getInstance().loadInto((Object) getFilePath(), (View) this.f12156b, (Callback) new Callback() {
                public void onStart() {
                    IMViewUtil.hide((View) IMImageRenderView.this.f12158d);
                    IMImageRenderView.this.f12156b.setImageResource(R.drawable.im_picture_ic_image);
                    IMImageRenderView.this.m10442c();
                    String a = IMImageRenderView.f12155a;
                    IMLog.m10020d(a, "onStart load " + IMImageRenderView.this.message.getFile_name());
                }

                public void onSuccess(Bitmap bitmap) {
                    IMImageRenderView.this.m10444d();
                    String a = IMImageRenderView.f12155a;
                    IMLog.m10020d(a, "onSuccess load " + IMImageRenderView.this.message.getFile_name());
                }

                public void onFailed() {
                    IMImageRenderView.this.m10444d();
                    IMViewUtil.show((View) IMImageRenderView.this.f12158d);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10442c() {
        if (this.f12157c != null && this.mViewLocation != 2) {
            this.f12157c.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m10444d() {
        ProgressBar progressBar = this.f12157c;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* renamed from: a */
    private RelativeLayout.LayoutParams m10437a(float f, float f2) {
        String str = f12155a;
        IMLog.m10020d(str, "before reSize width= " + f + " height= " + f2);
        int i = this.f12160f;
        if (f > ((float) i) || f2 > ((float) i)) {
            if (f >= f2) {
                int i2 = this.f12160f;
                f2 *= ((float) i2) / f;
                f = (float) i2;
            } else {
                int i3 = this.f12160f;
                f *= ((float) i3) / f2;
                f2 = (float) i3;
            }
        }
        float f3 = f2 + 0.5f;
        float f4 = f + 0.5f;
        String str2 = f12155a;
        IMLog.m10020d(str2, "after reSize width= " + f4 + " height= " + f3);
        return new RelativeLayout.LayoutParams((int) f4, (int) f3);
    }
}
