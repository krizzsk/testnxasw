package com.didi.beatles.p101im.plugin.robot.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotGetConfigureResponse;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotPraise;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotTraceUtil;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotViewUtil;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMAudioHelper;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.utils.imageloader.Callback;
import com.didi.beatles.p101im.views.widget.IMToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotPraiseView */
public class IMRobotPraiseView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11365a = IMRobotPraiseView.class.getSimpleName();

    /* renamed from: b */
    private TextView f11366b;

    /* renamed from: c */
    private TextView f11367c;

    /* renamed from: d */
    private ImageView f11368d;

    /* renamed from: e */
    private View f11369e;

    /* renamed from: f */
    private View f11370f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImageView f11371g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ProgressBar f11372h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMRobotPraise f11373i;

    /* renamed from: j */
    private Context f11374j;

    /* renamed from: com.didi.beatles.im.plugin.robot.widget.IMRobotPraiseView$PraiseActionListener */
    public interface PraiseActionListener {
        void switchPraise();
    }

    public IMRobotPraiseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRobotPraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRobotPraiseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11374j = context;
        LayoutInflater.from(context).inflate(R.layout.im_plugin_robot_praise_view, this);
        this.f11370f = findViewById(R.id.change_view);
        this.f11371g = (ImageView) findViewById(R.id.change_img);
        this.f11368d = (ImageView) findViewById(R.id.start_avatar_image);
        this.f11367c = (TextView) findViewById(R.id.im_plugin_robot_title);
        this.f11366b = (TextView) findViewById(R.id.praise_txt);
        this.f11369e = findViewById(R.id.play_audio_btn);
        this.f11372h = (ProgressBar) findViewById(R.id.robot_avatar_progress_bar);
    }

    public void bind(IMRobotGetConfigureResponse.Robot robot, IMRobotPraise iMRobotPraise, final PraiseActionListener praiseActionListener) {
        BtsImageLoader.getInstance().loadInto((Object) robot.starImgBig, (View) this.f11368d, (Callback) new Callback() {
            public void onFailed() {
            }

            public void onStart() {
                IMRobotViewUtil.show((View) IMRobotPraiseView.this.f11372h);
            }

            public void onSuccess(Bitmap bitmap) {
                IMRobotViewUtil.hide((View) IMRobotPraiseView.this.f11372h);
            }
        });
        this.f11367c.setText(robot.name);
        this.f11373i = iMRobotPraise;
        if (iMRobotPraise != null) {
            this.f11366b.setText(iMRobotPraise.text);
            this.f11369e.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (IMRobotPraiseView.this.f11373i != null) {
                        IMRobotTraceUtil.tracePlayingRobotPraiseClick(IMRobotPraiseView.this.f11373i.robotId, IMRobotPraiseView.this.f11373i.praiseId, IMAudioHelper.isPlayingCurrentAudio(IMRobotPraiseView.this.f11373i.voice, 2) ^ true ? 1 : 0);
                        IMRobotPraiseView iMRobotPraiseView = IMRobotPraiseView.this;
                        iMRobotPraiseView.m9864a(iMRobotPraiseView.f11373i.voice);
                    }
                }
            });
            this.f11370f.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotPraiseView iMRobotPraiseView = IMRobotPraiseView.this;
                    iMRobotPraiseView.m9861a(iMRobotPraiseView.f11371g);
                    praiseActionListener.switchPraise();
                    IMRobotPraiseView.this.stopPlayAudio();
                    if (IMRobotPraiseView.this.f11373i != null) {
                        IMRobotTraceUtil.traceChangeRobotPraiseClick(IMRobotPraiseView.this.f11373i.robotId, IMRobotPraiseView.this.f11373i.praiseId);
                    }
                }
            });
        }
    }

    public IMRobotPraise getCurrentPraise() {
        return this.f11373i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9864a(final String str) {
        if (str == null) {
            IMLog.m10026w(f11365a, C4786I.m9980t("[playAudio] fid = null"));
            return;
        }
        try {
            IMAudioHelper.playFromNet(getContext(), str, 2, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMRobotPraiseView.this.m9866b();
                    IMLog.m10020d(IMRobotPraiseView.f11365a, C4786I.m9980t("[playAudio] #onStarted# fid=", str));
                }

                public void onCompletion() {
                    IMRobotPraiseView.this.m9868c();
                    IMLog.m10020d(IMRobotPraiseView.f11365a, C4786I.m9980t("[playAudio] #onCompletion# fid=", str));
                }

                public void onError(String str) {
                    SystemUtils.showToast(IMToast.makeText(IMRobotPraiseView.this.getContext(), (CharSequence) IMRobotPraiseView.this.getContext().getString(R.string.im_plugin_robot_audio_play_fail), 0));
                    IMLog.m10021e(IMRobotPraiseView.f11365a, C4786I.m9980t("[playAudio] #onError# fid=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMRobotPraiseView.this.m9868c();
                    IMLog.m10020d(IMRobotPraiseView.f11365a, C4786I.m9980t("[playAudio] #onStop# fid=", str));
                }
            });
        } catch (Exception e) {
            m9866b();
            IMLog.m10021e(f11365a, "[playAudio]", e);
        }
    }

    public void stopPlayAudio() {
        if (IMBtsAudioPlayer.isPlaying()) {
            IMAudioHelper.stopPlay(2);
            m9868c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9866b() {
        ((AnimationDrawable) this.f11369e.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9868c() {
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f11369e.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9861a(ImageView imageView) {
        imageView.startAnimation(AnimationUtils.loadAnimation(this.f11374j, R.anim.im_plugin_robot_change_anim));
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (!z) {
            stopPlayAudio();
        }
    }
}
