package com.didi.beatles.p101im.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.data.IMInnerData;
import com.didi.beatles.p101im.module.IMEmojiModule;
import com.didi.beatles.p101im.omega.IMMsgOmega;
import com.didi.beatles.p101im.picture.config.IMPictureMimeType;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.beatles.im.views.IMRecommendEmojiView */
public class IMRecommendEmojiView extends LinearLayout {

    /* renamed from: e */
    private static final long f11765e = 4000;

    /* renamed from: a */
    private Context f11766a;

    /* renamed from: b */
    private ImageView f11767b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RecommendListener f11768c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMEmojiModule f11769d;

    /* renamed from: f */
    private Handler f11770f;

    /* renamed from: com.didi.beatles.im.views.IMRecommendEmojiView$RecommendListener */
    public interface RecommendListener {
        void onClick(String str, String str2, String str3);
    }

    public IMRecommendEmojiView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRecommendEmojiView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRecommendEmojiView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11770f = new Handler();
        this.f11766a = context;
        m10088a();
    }

    /* renamed from: a */
    private void m10088a() {
        this.f11767b = (ImageView) LayoutInflater.from(this.f11766a).inflate(R.layout.im_recommond_emoji_view, this).findViewById(R.id.im_recommond_iv);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMRecommendEmojiView.this.f11768c != null && IMRecommendEmojiView.this.f11769d != null) {
                    IMRecommendEmojiView.this.f11768c.onClick(IMRecommendEmojiView.this.f11769d.emojiId, IMRecommendEmojiView.this.f11769d.picName, IMRecommendEmojiView.this.f11769d.desc);
                    IMRecommendEmojiView.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("name", IMRecommendEmojiView.this.f11769d.desc);
                    IMMsgOmega.getInstance().track("ddim_dy_all_icon_ck", hashMap);
                }
            }
        });
    }

    public void show(IMEmojiModule iMEmojiModule) {
        if (iMEmojiModule != null) {
            setVisibility(0);
            this.f11769d = iMEmojiModule;
            BtsImageLoader instance = BtsImageLoader.getInstance();
            instance.loadInto(IMInnerData.getInstance().getEmojiPrefix() + iMEmojiModule.picName + IMPictureMimeType.PNG, this.f11767b);
            this.f11770f.postDelayed(new Runnable() {
                public void run() {
                    if (IMRecommendEmojiView.this.isShown()) {
                        IMRecommendEmojiView.this.dismiss();
                    }
                }
            }, 4000);
        }
    }

    public void dismiss() {
        setVisibility(8);
    }

    public void setRecommondListener(RecommendListener recommendListener) {
        this.f11768c = recommendListener;
    }
}
