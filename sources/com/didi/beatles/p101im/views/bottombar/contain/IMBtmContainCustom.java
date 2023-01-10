package com.didi.beatles.p101im.views.bottombar.contain;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.picture.utils.IMDoubleUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainCustom */
class IMBtmContainCustom extends C4858a {

    /* renamed from: c */
    private ViewGroup f11856c;

    /* renamed from: d */
    private View f11857d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Callback f11858e;

    /* renamed from: com.didi.beatles.im.views.bottombar.contain.IMBtmContainCustom$Callback */
    interface Callback {
        void backToFunc();
    }

    IMBtmContainCustom(View view) {
        super(view);
        this.f11856c = (ViewGroup) view.findViewById(R.id.im_btm_cus_content);
        this.f11857d = view.findViewById(R.id.im_btm_cus_back);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48949a(Callback callback) {
        this.f11858e = callback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48948a(View view, boolean z) {
        this.f11856c.removeAllViews();
        this.f11856c.addView(view);
        if (z) {
            m10186b();
            this.f11857d.setVisibility(0);
            this.f11857d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!IMDoubleUtils.isFastDoubleClick()) {
                        IMBtmContainCustom.this.m10187c();
                    }
                }
            });
            return;
        }
        this.f11857d.setVisibility(8);
    }

    /* renamed from: b */
    private void m10186b() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11895a, R.anim.bts_im_actionsheet_dialog_in);
        this.f11856c.clearAnimation();
        this.f11856c.setAnimation(loadAnimation);
        loadAnimation.startNow();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10187c() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f11895a, R.anim.bts_im_actionsheet_dialog_out);
        this.f11856c.clearAnimation();
        this.f11856c.setAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (IMBtmContainCustom.this.f11858e != null) {
                    IMBtmContainCustom.this.f11858e.backToFunc();
                }
            }
        });
        loadAnimation.startNow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo48947a() {
        this.f11858e = null;
        this.f11856c.clearAnimation();
        this.f11856c.removeAllViews();
    }
}
