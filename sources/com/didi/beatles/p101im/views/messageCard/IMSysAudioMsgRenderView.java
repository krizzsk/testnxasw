package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMSysAudioMsgBody;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.omega.IMTraceUtil;
import com.didi.beatles.p101im.pref.IMPreference;
import com.didi.beatles.p101im.protocol.model.IMRenderCardEnv;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMAudioHelper;
import com.didi.beatles.p101im.utils.IMJsonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMParseUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.messageCard.IMSysAudioMsgRenderView */
public class IMSysAudioMsgRenderView extends IMBaseRenderView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12207a = IMSysAudioMsgRenderView.class.getSimpleName();

    /* renamed from: b */
    private static final int f12208b = 1;

    /* renamed from: l */
    private static final boolean f12209l;

    /* renamed from: m */
    private static int f12210m = 0;

    /* renamed from: c */
    private ImageView f12211c;

    /* renamed from: d */
    private ImageView f12212d;

    /* renamed from: e */
    private View f12213e;

    /* renamed from: f */
    private View f12214f;

    /* renamed from: g */
    private TextView f12215g;

    /* renamed from: h */
    private TextView f12216h;

    /* renamed from: i */
    private IMSysAudioMsgBody f12217i;

    /* renamed from: j */
    private boolean f12218j;

    /* renamed from: k */
    private IMRenderCardEnv f12219k;

    /* renamed from: n */
    private ArraySet<Long> f12220n = new ArraySet<>();

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    static {
        IToggle toggle = Apollo.getToggle("IM_Config_Sys_Audio_Auto_Play");
        f12209l = toggle != null && toggle.allow();
        String str = f12207a;
        IMLog.m10024i(str, "apollo auto play=" + f12209l);
    }

    public IMSysAudioMsgRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
        if (messageAdapter != null) {
            this.f12219k = messageAdapter.getRenderCardEnv();
        }
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        return this.inflater.inflate(R.layout.bts_im_message_sys_audio_layout, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12211c = (ImageView) findViewById(R.id.sys_audio_avatar_img);
        this.f12212d = (ImageView) findViewById(R.id.sys_audio_bg_img);
        this.f12213e = findViewById(R.id.sys_audio_play_view);
        this.f12214f = findViewById(R.id.sys_audio_progress_bar);
        this.f12215g = (TextView) findViewById(R.id.sys_audio_msg_content_text);
        this.f12216h = (TextView) findViewById(R.id.sys_audio_msg_hint_text);
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        if (this.message != null && this.message.getType() == 393224) {
            IMSysAudioMsgBody iMSysAudioMsgBody = (IMSysAudioMsgBody) IMJsonUtil.objectFromJson(this.message.getContent(), IMSysAudioMsgBody.class);
            this.f12217i = iMSysAudioMsgBody;
            if (iMSysAudioMsgBody != null) {
                if (this.f12220n.add(Long.valueOf(iMMessage.getMid()))) {
                    traceCardSw();
                }
                if (!TextUtils.isEmpty(this.f12217i.cardImg)) {
                    this.f12211c.setVisibility(0);
                    BtsImageLoader.getInstance().loadInto(this.f12217i.cardImg, this.f12211c);
                } else {
                    this.f12211c.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f12217i.bgImg)) {
                    this.f12212d.setVisibility(0);
                    BtsImageLoader.getInstance().loadInto(this.f12217i.bgImg, this.f12212d);
                } else {
                    this.f12212d.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f12217i.text)) {
                    this.f12215g.setVisibility(0);
                    this.f12215g.setText(this.f12217i.text);
                    if (!TextUtils.isEmpty(this.f12217i.titleColor)) {
                        this.f12215g.setTextColor(IMParseUtil.parseColor(this.f12217i.titleColor));
                    }
                } else {
                    this.f12215g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(this.f12217i.hint)) {
                    this.f12216h.setVisibility(0);
                    this.f12216h.setText(this.f12217i.hint);
                } else {
                    this.f12216h.setVisibility(8);
                }
            }
            this.f12218j = false;
            m10464b();
        }
    }

    /* renamed from: b */
    private void m10464b() {
        if (!f12209l) {
            IMLog.m10020d(f12207a, "[handleAutoPlay] not in apollo.");
        } else if (f12210m < 1) {
            int sysAudioAutoPlayCount = IMPreference.getInstance(IMContextInfoHelper.getContext()).getSysAudioAutoPlayCount(IMContextInfoHelper.getUid());
            f12210m = sysAudioAutoPlayCount;
            if (sysAudioAutoPlayCount >= 1) {
                String str = f12207a;
                IMLog.m10020d(str, "[handleAutoPlay] #sp# reach max play count:" + f12210m);
            } else if (this.f12217i != null) {
                int i = sysAudioAutoPlayCount + 1;
                IMPreference.getInstance(IMContextInfoHelper.getContext()).setSysAudioAutoPlayCount(IMContextInfoHelper.getUid(), i);
                f12210m = i;
                traceCardCk(true);
                m10463a(this.f12217i.voice);
                IMLog.m10020d(f12207a, "[handleAutoPlay] start auto play...");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        if (this.message != null) {
            traceCardCk(false);
        }
        if (!this.f12218j) {
            m10463a(this.f12217i.voice);
        }
    }

    /* renamed from: a */
    private void m10463a(final String str) {
        if (str == null) {
            IMLog.m10026w(f12207a, C4786I.m9980t("[playAudio] fid = null"));
            return;
        }
        m10466c();
        try {
            IMAudioHelper.playFromUrl(getContext(), str, 1, new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMSysAudioMsgRenderView.this.m10468e();
                    IMLog.m10020d(IMSysAudioMsgRenderView.f12207a, C4786I.m9980t("[playAudio] #onStarted# url=", str));
                }

                public void onCompletion() {
                    IMSysAudioMsgRenderView.this.m10469f();
                    IMLog.m10020d(IMSysAudioMsgRenderView.f12207a, C4786I.m9980t("[playAudio] #onCompletion# url=", str));
                }

                public void onError(String str) {
                    IMToastHelper.showShortError(IMSysAudioMsgRenderView.this.getContext(), IMSysAudioMsgRenderView.this.getContext().getString(R.string.bts_im_audio_play_fail));
                    IMLog.m10021e(IMSysAudioMsgRenderView.f12207a, C4786I.m9980t("[playAudio] #onError# url=", str, " |error=", str));
                    onStop();
                }

                public void onStop() {
                    IMSysAudioMsgRenderView.this.m10469f();
                    IMLog.m10020d(IMSysAudioMsgRenderView.f12207a, C4786I.m9980t("[playAudio] #onStop# url=", str));
                }
            });
        } catch (Exception e) {
            IMLog.m10021e(f12207a, "[playAudio]", e);
            m10467d();
        }
    }

    /* renamed from: c */
    private void m10466c() {
        this.f12218j = true;
        IMViewUtil.hide(this.f12213e);
        IMViewUtil.show(this.f12214f);
    }

    /* renamed from: d */
    private void m10467d() {
        this.f12218j = false;
        IMViewUtil.show(this.f12213e);
        IMViewUtil.hide(this.f12214f);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10468e() {
        m10467d();
        ((AnimationDrawable) this.f12213e.getBackground()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10469f() {
        m10467d();
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f12213e.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    public void traceCardSw() {
        IMTraceUtil.BusinessParam addBusinessEvent = IMTraceUtil.addBusinessEvent("ddim_service_springholiday_kkcard_sw");
        IMRenderCardEnv iMRenderCardEnv = this.f12219k;
        IMTraceUtil.BusinessParam add = addBusinessEvent.add("order_id", iMRenderCardEnv != null ? iMRenderCardEnv.getOrderId() : "");
        IMRenderCardEnv iMRenderCardEnv2 = this.f12219k;
        add.add(iMRenderCardEnv2 != null ? iMRenderCardEnv2.getExtraTraceMap() : null).report();
    }

    public void traceCardCk(boolean z) {
        IMTraceUtil.BusinessParam addBusinessEvent = IMTraceUtil.addBusinessEvent("ddim_service_springholiday_kkcardhot_ck");
        IMRenderCardEnv iMRenderCardEnv = this.f12219k;
        IMTraceUtil.BusinessParam add = addBusinessEvent.add("order_id", iMRenderCardEnv != null ? iMRenderCardEnv.getOrderId() : "").add("is_auto_broadcast", Integer.valueOf(z ? 1 : 0));
        IMRenderCardEnv iMRenderCardEnv2 = this.f12219k;
        add.add(iMRenderCardEnv2 != null ? iMRenderCardEnv2.getExtraTraceMap() : null).report();
    }
}
