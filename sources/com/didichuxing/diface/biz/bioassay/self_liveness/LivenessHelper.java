package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;

public class LivenessHelper implements LifecycleObserver {

    /* renamed from: a */
    private final ViewFlipper f49888a;

    /* renamed from: b */
    private final Context f49889b;

    /* renamed from: c */
    private final TextView f49890c;

    /* renamed from: d */
    private final TextView f49891d;

    /* renamed from: e */
    private VideoPlayer f49892e;

    /* renamed from: f */
    private String f49893f;

    public LivenessHelper(Context context, View view, String str) {
        this.f49889b = context;
        this.f49892e = new VideoPlayer(context);
        this.f49893f = str;
        this.f49888a = (ViewFlipper) view.findViewById(R.id.face_action_container);
        this.f49891d = (TextView) view.findViewById(R.id.face_voice_ctr);
        this.f49890c = (TextView) view.findViewById(R.id.tv_recognizing_tip_up);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void reset() {
        this.f49891d.setVisibility(4);
        this.f49890c.setText(R.string.df_liveness_hold_phone);
        if (this.f49888a.getDisplayedChild() != 0) {
            this.f49888a.setDisplayedChild(0);
        }
        this.f49892e.reset();
    }

    public void move(int i, int i2) {
        ActionType index = ActionType.index(i);
        if (index != null) {
            this.f49888a.showNext();
            if ("BR".equals(this.f49893f)) {
                this.f49891d.setVisibility(0);
                this.f49892e.videoPlayer(index.video);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        this.f49892e.reset();
    }

    public void initAction(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            iArr = new int[]{3};
        }
        for (int index : iArr) {
            ActionType index2 = ActionType.index(index);
            ImageView imageView = new ImageView(this.f49889b);
            DiSafetyImageLoader.with(this.f49889b).load(index2.getGif()).into(imageView);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.f49888a.addView(imageView, layoutParams);
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f49889b, R.anim.liveness_rightin);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f49889b, R.anim.liveness_leftout);
        this.f49888a.setInAnimation(loadAnimation);
        this.f49888a.setOutAnimation(loadAnimation2);
    }
}
