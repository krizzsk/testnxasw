package com.didi.beatles.p101im.views.feed;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.module.entity.IMSession;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.IMDateUtil;
import com.didi.beatles.p101im.views.feed.IMListChatVHolder.ClickListener;
import com.didi.beatles.p101im.views.imageView.IMCircleImageView;
import com.taxis99.R;
import java.util.Date;

/* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder */
public abstract class IMListChatVHolder<T extends ClickListener> extends IMListTraceVHolder {

    /* renamed from: a */
    Activity f12091a;

    /* renamed from: b */
    TextView f12092b;

    /* renamed from: c */
    TextView f12093c;

    /* renamed from: d */
    TextView f12094d;

    /* renamed from: e */
    IMCircleImageView f12095e;

    /* renamed from: f */
    ImageView f12096f;

    /* renamed from: g */
    ImageView f12097g;

    /* renamed from: h */
    IMSession f12098h;

    /* renamed from: i */
    int f12099i;

    /* renamed from: j */
    T f12100j;

    /* renamed from: k */
    private TextView f12101k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f12102l;

    /* renamed from: m */
    private TextView f12103m;

    /* renamed from: n */
    private View f12104n;

    /* renamed from: o */
    private TextView f12105o;

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder$AnimationCallback */
    public interface AnimationCallback {
        void finishAnimation();
    }

    /* renamed from: com.didi.beatles.im.views.feed.IMListChatVHolder$ClickListener */
    interface ClickListener {
        void onClick(View view, IMSession iMSession);
    }

    public void traceHolder() {
    }

    IMListChatVHolder(Activity activity, ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item_chat, viewGroup, false));
        this.f12091a = activity;
        m10382c();
    }

    /* renamed from: c */
    private void m10382c() {
        this.f12095e = (IMCircleImageView) this.itemView.findViewById(R.id.contact_portrait);
        this.f12092b = (TextView) this.itemView.findViewById(R.id.shop_name);
        this.f12093c = (TextView) this.itemView.findViewById(R.id.message_body);
        this.f12094d = (TextView) this.itemView.findViewById(R.id.message_time);
        this.f12102l = (TextView) this.itemView.findViewById(R.id.message_count_notify);
        this.f12103m = (TextView) this.itemView.findViewById(R.id.message_red_notify);
        this.f12096f = (ImageView) this.itemView.findViewById(R.id.im_chat_mark);
        this.f12101k = (TextView) this.itemView.findViewById(R.id.im_chat_bussiness_icon);
        this.f12104n = this.itemView.findViewById(R.id.message_bottom_line);
        this.f12097g = (ImageView) this.itemView.findViewById(R.id.forbid_iv);
        this.f12105o = (TextView) this.itemView.findViewById(R.id.tv_session_label);
        this.f12095e.setImageResource(R.drawable.bts_im_general_default_avatar);
        this.f12096f.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_chat_user_mark_icon));
    }

    public void bindData(IMSession iMSession, int i, boolean z, T t) {
        this.f12098h = iMSession;
        this.f12099i = i;
        this.f12100j = t;
        m10383d();
        m10384e();
        mo49130a();
        mo49131b();
        this.f12104n.setVisibility(z ? 8 : 0);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMListChatVHolder.this.f12100j != null) {
                    IMListChatVHolder.this.f12100j.onClick(IMListChatVHolder.this.itemView, IMListChatVHolder.this.f12098h);
                }
            }
        });
    }

    /* renamed from: d */
    private void m10383d() {
        this.f12102l.clearAnimation();
        int unreadCount = this.f12098h.getUnreadCount();
        if (unreadCount <= 0) {
            unreadCount = this.f12098h.getRedDotCount();
        }
        if (unreadCount > 0) {
            String valueOf = String.valueOf(unreadCount);
            if (unreadCount > 99) {
                valueOf = "···";
            }
            this.f12102l.setBackgroundResource(R.drawable.im_dots_with_number);
            this.f12102l.setVisibility(0);
            this.f12103m.setVisibility(8);
            this.f12102l.setText(valueOf);
            return;
        }
        this.f12102l.setVisibility(8);
        this.f12103m.setVisibility(8);
    }

    /* renamed from: e */
    private void m10384e() {
        if (this.f12098h.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f12098h.getExtendSessionInfo().stag)) {
            this.f12101k.setVisibility(8);
            return;
        }
        this.f12101k.setVisibility(0);
        this.f12101k.setText(this.f12098h.getExtendSessionInfo().stag);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo49130a() {
        this.f12094d.setText(IMDateUtil.getListTimeDiffDesc(this.itemView.getContext(), new Date(this.f12098h.getLastModifyTime())));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo49131b() {
        if (this.f12098h.getExtendSessionInfo() == null || TextUtils.isEmpty(this.f12098h.getExtendSessionInfo().label)) {
            this.f12105o.setVisibility(8);
            return;
        }
        this.f12105o.setVisibility(0);
        this.f12105o.setText(this.f12098h.getExtendSessionInfo().label);
    }

    public void clearAnimation(Interpolator interpolator, final AnimationCallback animationCallback) {
        if (this.f12102l.getVisibility() != 8) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400);
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    IMListChatVHolder.this.f12102l.setVisibility(8);
                    AnimationCallback animationCallback = animationCallback;
                    if (animationCallback != null) {
                        animationCallback.finishAnimation();
                    }
                }
            });
            scaleAnimation.setInterpolator(interpolator);
            this.f12102l.startAnimation(scaleAnimation);
        }
    }
}
