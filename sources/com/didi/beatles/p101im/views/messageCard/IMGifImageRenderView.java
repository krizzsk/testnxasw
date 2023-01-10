package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.data.IMInnerData;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMGifImageRenderView */
public class IMGifImageRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ImageView f12152a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f12153b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ProgressBar f12154c;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMGifImageRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_mine_gifimage_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12152a = (ImageView) findViewById(R.id.gif_photo_view);
        this.f12154c = (ProgressBar) findViewById(R.id.gif_progressBar);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        m10432a();
    }

    /* renamed from: a */
    private void m10432a() {
        if (this.message.getFid() != null && this.message.getFid().length() > 1) {
            m10434a(this.message.getFid());
        } else if (TextUtils.isEmpty(IMInnerData.getInstance().getEmojiPrefix())) {
            IMInnerData.getInstance().addEmojiPrefixObserver(new IMInnerData.IMEmojiPerfixListener() {
                public void emojiPrefixUpdate(String str) {
                    IMGifImageRenderView iMGifImageRenderView = IMGifImageRenderView.this;
                    iMGifImageRenderView.m10434a(str + IMGifImageRenderView.this.message.getContent());
                    IMInnerData.getInstance().removeEmojiPrefixObserver(this);
                }
            });
        } else {
            m10434a(IMInnerData.getInstance().getEmojiPrefix() + this.message.getContent());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10434a(String str) {
        BtsImageLoader.getInstance().loadIntoAsGif(str, this.f12152a, new Callback() {
            public void onStart() {
                if (IMGifImageRenderView.this.f12154c != null) {
                    IMGifImageRenderView.this.f12154c.setVisibility(0);
                    boolean unused = IMGifImageRenderView.this.f12153b = false;
                }
            }

            public void onSuccess(Bitmap bitmap) {
                if (IMGifImageRenderView.this.f12154c != null) {
                    IMGifImageRenderView.this.f12154c.setVisibility(8);
                }
            }

            public void onFailed() {
                if (IMGifImageRenderView.this.f12154c != null) {
                    IMGifImageRenderView.this.f12152a.setImageResource(IMResource.getDrawableID(R.drawable.im_load_failed));
                    IMGifImageRenderView.this.f12154c.setVisibility(8);
                    boolean unused = IMGifImageRenderView.this.f12153b = true;
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (this.f12153b) {
            m10432a();
        }
    }
}
