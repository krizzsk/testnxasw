package com.didi.beatles.p101im.plugin.robot;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.common.widget.IMOnAntiShakeClickListener;
import com.didi.beatles.p101im.plugin.robot.net.response.IMRobotMessageContent;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotTraceUtil;
import com.didi.beatles.p101im.plugin.robot.utils.IMRobotViewUtil;
import com.didi.beatles.p101im.protocol.host.IMMessageViewStatusCallback;
import com.didi.beatles.p101im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p101im.protocol.plugin.IIMPluginCardView;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMAudioHelper;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.widget.IMToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.Map;

/* renamed from: com.didi.beatles.im.plugin.robot.IMRobotMessageView */
public class IMRobotMessageView extends FrameLayout implements IIMPluginCardView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11326a = IMRobotMessageView.class.getSimpleName();

    /* renamed from: b */
    private View f11327b;

    /* renamed from: c */
    private ImageView f11328c;

    /* renamed from: d */
    private TextView f11329d;

    /* renamed from: e */
    private TextView f11330e;

    /* renamed from: f */
    private View f11331f;

    /* renamed from: g */
    private View f11332g;

    /* renamed from: h */
    private View f11333h;

    /* renamed from: i */
    private View f11334i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f11335j;

    /* renamed from: k */
    private IMRenderCardEnv f11336k;

    /* renamed from: l */
    private ArraySet<String> f11337l;

    public boolean isShowInMiddle() {
        return false;
    }

    public void onCardClick(View view) {
    }

    public IMRobotMessageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMRobotMessageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMRobotMessageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11335j = false;
        this.f11337l = new ArraySet<>();
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_plugin_robot_msg_view, this, true);
        this.f11327b = inflate;
        this.f11328c = (ImageView) inflate.findViewById(R.id.robot_msg_avatar_img);
        this.f11331f = this.f11327b.findViewById(R.id.robot_msg_share_layout);
        this.f11332g = this.f11327b.findViewById(R.id.robot_msg_audio_layout);
        this.f11333h = this.f11327b.findViewById(R.id.robot_msg_audio_img);
        this.f11334i = this.f11327b.findViewById(R.id.robot_msg_audio_progress_bar);
        this.f11329d = (TextView) this.f11327b.findViewById(R.id.robot_msg_title_text);
        this.f11330e = (TextView) this.f11327b.findViewById(R.id.robot_msg_content_text);
    }

    public void onBind(int i, IMRenderCardEnv iMRenderCardEnv, String str, IMMessageViewStatusCallback iMMessageViewStatusCallback) {
        this.f11335j = false;
        final IMRobotMessageContent iMRobotMessageContent = (IMRobotMessageContent) IMJsonUtil.objectFromJson(str, IMRobotMessageContent.class);
        this.f11336k = iMRenderCardEnv;
        if (iMRobotMessageContent != null) {
            if (!TextUtils.isEmpty(iMRobotMessageContent.cardImg)) {
                IMRobotViewUtil.show((View) this.f11328c);
                BtsImageLoader.getInstance().loadInto(iMRobotMessageContent.cardImg, this.f11328c);
            } else {
                IMRobotViewUtil.hide((View) this.f11328c);
            }
            if (!TextUtils.isEmpty(iMRobotMessageContent.title)) {
                IMRobotViewUtil.show((View) this.f11329d);
                this.f11329d.setText(iMRobotMessageContent.title);
            } else {
                IMRobotViewUtil.hide((View) this.f11329d);
            }
            if (!TextUtils.isEmpty(iMRobotMessageContent.text)) {
                IMRobotViewUtil.show((View) this.f11330e);
                this.f11330e.setText(iMRobotMessageContent.text);
            } else {
                IMRobotViewUtil.hide((View) this.f11330e);
            }
            this.f11331f.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotTraceUtil.traceCardShareCk(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, IMRobotMessageView.this.getOrderId(), IMRobotMessageView.this.getExtraTraceMap());
                    if (!IMRobotBridge.navigation(iMRobotMessageContent.shareUrl)) {
                        IMLog.m10021e(IMRobotMessageView.f11326a, "[share] invoke navigation fail");
                    }
                }
            });
            this.f11332g.setOnClickListener(new IMOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    IMRobotTraceUtil.traceCardVoiceCk(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, IMRobotMessageView.this.getOrderId(), IMRobotMessageView.this.getExtraTraceMap());
                    if (!IMRobotMessageView.this.f11335j) {
                        IMRobotMessageView.this.m9831a(iMRobotMessageContent.voice);
                    }
                }
            });
            if (this.f11337l.add(iMRobotMessageContent.praiseId)) {
                IMRobotTraceUtil.traceCardSw(iMRobotMessageContent.praiseId, iMRobotMessageContent.isAnon, getOrderId(), getExtraTraceMap());
            }
        }
    }

    /* access modifiers changed from: private */
    public String getOrderId() {
        IMRenderCardEnv iMRenderCardEnv = this.f11336k;
        if (iMRenderCardEnv != null) {
            return iMRenderCardEnv.getOrderId();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public Map<String, String> getExtraTraceMap() {
        IMRenderCardEnv iMRenderCardEnv = this.f11336k;
        if (iMRenderCardEnv != null) {
            return iMRenderCardEnv.getExtraTraceMap();
        }
        return null;
    }

    /* renamed from: b */
    private void m9833b() {
        this.f11335j = true;
        IMRobotViewUtil.hide(this.f11333h);
        IMRobotViewUtil.show(this.f11334i);
    }

    /* renamed from: c */
    private void m9834c() {
        this.f11335j = false;
        IMRobotViewUtil.hide(this.f11334i);
        IMRobotViewUtil.show(this.f11333h);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9831a(final String str) {
        if (str == null) {
            IMLog.m10026w(f11326a, C4786I.m9980t("[playAudio] fid = null"));
            return;
        }
        m9833b();
        try {
            IMAudioHelper.playFromNet(getContext(), str, 1, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMRobotMessageView.this.m9836d();
                    IMLog.m10020d(IMRobotMessageView.f11326a, C4786I.m9980t("[playAudio] #onStarted# fid=", str));
                }

                public void onCompletion() {
                    IMRobotMessageView.this.m9838e();
                    IMLog.m10020d(IMRobotMessageView.f11326a, C4786I.m9980t("[playAudio] #onCompletion# fid=", str));
                }

                public void onError(String str) {
                    SystemUtils.showToast(IMToast.makeText(IMRobotMessageView.this.getContext(), (CharSequence) IMRobotMessageView.this.getContext().getString(R.string.im_plugin_robot_audio_play_fail), 0));
                    IMLog.m10021e(IMRobotMessageView.f11326a, C4786I.m9980t("[playAudio] #onError# fid=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMRobotMessageView.this.m9838e();
                    IMLog.m10020d(IMRobotMessageView.f11326a, C4786I.m9980t("[playAudio] #onStop# fid=", str));
                }
            });
        } catch (Exception e) {
            m9838e();
            IMLog.m10021e(f11326a, "[playAudio]", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9836d() {
        m9834c();
        ((AnimationDrawable) this.f11333h.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m9838e() {
        m9834c();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f11333h.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }
}
