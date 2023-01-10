package com.didi.beatles.p101im.views.messageCard;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.adapter.MessageAdapter;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.resource.IMThemeConstant;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMCommonUtil;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMRTLUtils;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.List;
import kotlin.text.Typography;

/* renamed from: com.didi.beatles.im.views.messageCard.IMAudioRenderView */
public class IMAudioRenderView extends IMBaseRenderView {

    /* renamed from: a */
    private static final int f12140a = 0;

    /* renamed from: b */
    private static final int f12141b = 1;

    /* renamed from: c */
    private static final int f12142c = 2;

    /* renamed from: d */
    private static final int f12143d = 3;

    /* renamed from: e */
    private View f12144e;

    /* renamed from: f */
    private View f12145f;

    /* renamed from: g */
    private View f12146g;

    /* renamed from: h */
    private TextView f12147h;

    /* renamed from: i */
    private boolean f12148i;

    /* access modifiers changed from: protected */
    public void onUpdateView() {
    }

    public IMAudioRenderView(Context context, int i, MessageAdapter messageAdapter) {
        super(context, i, messageAdapter);
    }

    /* access modifiers changed from: protected */
    public View onInflatView(ViewGroup viewGroup) {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            return this.inflater.inflate(this.isMine ? R.layout.bts_im_mine_audio_message_item_global_psg : R.layout.bts_im_other_audio_message_item_global_psg, viewGroup, false);
        }
        return this.inflater.inflate(this.isMine ? R.layout.bts_im_mine_audio_message_item : R.layout.bts_im_other_audio_message_item, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void onFindViewById() {
        this.f12144e = findViewById(R.id.message_layout);
        this.f12145f = findViewById(R.id.audio_antt_view);
        this.f12147h = (TextView) findViewById(R.id.audio_duration);
        this.f12146g = findViewById(R.id.audio_unread_notify);
        if (this.isMine) {
            this.f12144e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_right_black_bubble_selector));
            return;
        }
        this.f12144e.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_left_bubble_selector));
        this.f12144e.setPadding(IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 10.0f), IMViewUtil.dp2px(getContext(), 12.0f), IMViewUtil.dp2px(getContext(), 10.0f));
    }

    /* access modifiers changed from: protected */
    public void onSetUpView(IMMessage iMMessage) {
        this.adapter.audioRenderViewStore.add(this);
        if (IMStyleManager.getCurBusinessStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            this.f12145f.setBackgroundResource(this.isMine ? R.anim.bts_im_voice_play_mine : R.anim.bts_im_voice_play_other);
        } else if ((this.f12145f instanceof LottieAnimationView) && !this.f12148i) {
            if (this.isMine) {
                if (IMRTLUtils.isRTLLayout()) {
                    ((LottieAnimationView) this.f12145f).setAnimation("im/im_audio_play_mine_global_rtl_psg.json");
                } else {
                    ((LottieAnimationView) this.f12145f).setAnimation("im/im_audio_play_mine_global_psg.json");
                }
            } else if (IMRTLUtils.isRTLLayout()) {
                ((LottieAnimationView) this.f12145f).setAnimation("im/im_audio_play_other_global_rtl_psg.json");
            } else {
                ((LottieAnimationView) this.f12145f).setAnimation("im/im_audio_play_other_global_psg.json");
            }
            ((LottieAnimationView) this.f12145f).setRepeatCount(-1);
            this.f12148i = true;
        }
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.message.getSidType(), this.message.getBusinessId());
        if (this.isMine) {
            if (currentBusinessConfig.isUber()) {
                this.f12144e.setBackgroundResource(R.drawable.ub_other_imme_right_bg);
            } else if (currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG) != -1) {
                this.f12144e.setBackgroundResource(currentBusinessConfig.getExtendDrawableResource(IMThemeConstant.IM_SELF_TEXT_BG));
            }
        }
        int sec = this.message.getSec();
        if (sec <= 0) {
            sec = 1;
        }
        TextView textView = this.f12147h;
        textView.setText(String.valueOf(sec) + Typography.quote);
        if (this.contentLayout != null) {
            this.contentLayout.setContentDescription(String.format(IMResource.getString(R.string.im_accessibility_audio_sencond), new Object[]{Integer.valueOf(sec)}));
        }
        int audioBkSize = IMCommonUtil.getAudioBkSize(sec, this.context);
        if (audioBkSize < IMViewUtil.dp2px(this.context, 70.0f)) {
            audioBkSize = IMViewUtil.dp2px(this.context, 70.0f);
        }
        if (audioBkSize > IMViewUtil.dp2px(this.context, 250.0f)) {
            audioBkSize = IMViewUtil.dp2px(this.context, 250.0f);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12144e.getLayoutParams();
        layoutParams.width = audioBkSize;
        if (this.adapter.isUberMode && this.isMine) {
            this.f12144e.setBackgroundResource(R.drawable.ub_other_imme_right_bg);
        }
        this.f12144e.setLayoutParams(layoutParams);
        m10426f();
        if (!this.isMine) {
            getMessageFailed().setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onViewClick() {
        mo49163a(this.message);
    }

    /* renamed from: a */
    private static void m10414a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            int streamType = IMContextInfoHelper.getAudioConfig().getStreamType();
            int streamVolume = audioManager.getStreamVolume(streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(streamType);
            if (streamVolume == 0) {
                m10415a(context, (int) R.drawable.bts_im_volume_tip, (int) R.string.bts_im_audio_min_tip);
            } else if (((double) streamVolume) < ((double) streamMaxVolume) * 0.4d) {
                m10415a(context, (int) R.drawable.im_volume_icon, (int) R.string.bts_im_audio_min_tip);
            }
            IMLog.m10020d(TAG, C4786I.m9980t(" [isAudioVoiceMin] currVolume=", Integer.valueOf(streamVolume), " |maxVolume=", Integer.valueOf(streamMaxVolume)));
        }
    }

    /* renamed from: a */
    private static void m10415a(Context context, int i, int i2) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), i2, 0);
        SystemUtils.showToast(makeText);
        try {
            IMTipsToast.setIcon(makeText, i);
            IMTipsToast.setText(makeText, context.getString(i2));
        } catch (Exception e) {
            IMLog.m10021e(TAG, "[showTips]", e);
        }
    }

    public void startAnimation() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            View view = this.f12145f;
            if ((view instanceof LottieAnimationView) && !((LottieAnimationView) view).isAnimating()) {
                ((LottieAnimationView) this.f12145f).playAnimation();
                return;
            }
            return;
        }
        ((AnimationDrawable) this.f12145f.getBackground()).start();
    }

    public void stopAnimation() {
        if (IMStyleManager.getCurBusinessStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            View view = this.f12145f;
            if ((view instanceof LottieAnimationView) && ((LottieAnimationView) view).isAnimating()) {
                ((LottieAnimationView) this.f12145f).cancelAnimation();
                ((LottieAnimationView) this.f12145f).setProgress(0.0f);
                return;
            }
            return;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) this.f12145f.getBackground();
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
            animationDrawable.selectDrawable(0);
        }
    }

    /* renamed from: a */
    private void m10413a() {
        if (this.isMine) {
            this.f12146g.setVisibility(8);
        } else {
            this.f12146g.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m10419b() {
        this.f12146g.setVisibility(8);
    }

    /* renamed from: c */
    private void m10422c() {
        this.f12146g.setVisibility(8);
        getLoadingProgressBar().setVisibility(0);
    }

    /* renamed from: d */
    private void m10424d() {
        this.f12146g.setVisibility(8);
        getLoadingProgressBar().setVisibility(8);
        if (!this.isMine) {
            getMessageFailed().setVisibility(8);
        }
    }

    /* renamed from: e */
    private void m10425e() {
        this.f12146g.setVisibility(8);
        getLoadingProgressBar().setVisibility(8);
        getMessageFailed().setVisibility(0);
    }

    /* renamed from: f */
    private void m10426f() {
        int i;
        Integer num = this.adapter.audioRenderStatusStore.get(Long.valueOf(this.message.getMid()));
        if (num == null) {
            i = 0;
        } else {
            i = num.intValue();
        }
        if (i == 1) {
            m10422c();
            stopAnimation();
            m10419b();
        } else if (i == 2) {
            m10425e();
            stopAnimation();
            m10419b();
        } else if (i != 3) {
            m10424d();
            stopAnimation();
            if (this.message.isRead()) {
                m10419b();
            } else {
                m10413a();
            }
        } else {
            m10424d();
            startAnimation();
            m10419b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10416a(IMMessage iMMessage, Integer num) {
        IMLog.m10020d(TAG, C4786I.m9980t("[playAudio] updatePlayStatus ", Long.valueOf(iMMessage.getMid()), " ", num));
        this.adapter.audioRenderStatusStore.put(Long.valueOf(iMMessage.getMid()), num);
        if (iMMessage.getMid() == this.message.getMid()) {
            m10426f();
            return;
        }
        for (IMAudioRenderView next : this.adapter.audioRenderViewStore) {
            if (next.message.getMid() == iMMessage.getMid()) {
                next.m10426f();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo49163a(final IMMessage iMMessage) {
        if (!IMTextUtil.isEmpty(iMMessage.getFile_name())) {
            m10420b(iMMessage);
        } else if (IMManager.getInstance().getMessageModel() == null) {
            IMLog.m10021e(TAG, C4786I.m9980t("[playAudio] NULL message model"));
        } else {
            m10416a(iMMessage, (Integer) 1);
            IMManager.getInstance().getMessageModel().loadAudioMessage(iMMessage, iMMessage.getSid(), new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    IMLog.m10020d(IMBaseRenderView.TAG, C4786I.m9980t("[playAudio] #loadAudioMessage# Fid=", iMMessage.getFid(), " |status=", Integer.valueOf(i)));
                    if (i == 301) {
                        IMAudioRenderView.this.m10420b(iMMessage);
                    } else {
                        IMAudioRenderView.this.m10416a(iMMessage, (Integer) 2);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10420b(final IMMessage iMMessage) {
        String file_name = iMMessage.getFile_name();
        boolean z = iMMessage.getSenderUid() == IMContextInfoHelper.getUid();
        boolean isRead = iMMessage.isRead();
        if (!new File(file_name).exists()) {
            IMLog.m10021e(TAG, C4786I.m9980t("[playAudio] unable to find the audio file"));
            SystemUtils.showToast(Toast.makeText(this.context, this.context.getString(R.string.bts_im_notfound_audio_file), 1));
            m10416a(iMMessage, (Integer) 0);
            return;
        }
        if (!isRead && IMModelProvider.getInstance().getMessageModule() != null) {
            IMModelProvider.getInstance().getMessageModule().updateMessageAsync(iMMessage);
        }
        m10414a(this.context);
        if (!iMMessage.isRead() && !z) {
            iMMessage.setIsRead(true);
            m10416a(iMMessage, this.adapter.audioRenderStatusStore.get(Long.valueOf(iMMessage.getMid())));
            IMMessageReadStatusManager.getInstance().addHasReadMsg(iMMessage);
        }
        try {
            IMBtsAudioHelper.play(iMMessage.getFile_name(), new IMBtsAudioPlayer.OnAudioPlayingListener() {
                public void onStarted() {
                    IMAudioRenderView.this.m10416a(iMMessage, (Integer) 3);
                    IMLog.m10020d(IMBaseRenderView.TAG, C4786I.m9980t("[playAudio] #onStarted# fid=", iMMessage.getFid()));
                }

                public void onCompletion() {
                    IMAudioRenderView.this.m10416a(iMMessage, (Integer) 0);
                    IMLog.m10020d(IMBaseRenderView.TAG, C4786I.m9980t("[playAudio] #onCompletion# Fid=", iMMessage.getFid()));
                    IMAudioRenderView.this.m10423c(iMMessage);
                    IMAudioRenderView.this.adapter.notifyDataSetChanged();
                }

                public void onError(String str) {
                    IMAudioRenderView.this.m10416a(iMMessage, (Integer) 0);
                    IMToastHelper.showShortError(IMAudioRenderView.this.context, IMAudioRenderView.this.context.getString(R.string.bts_im_audio_play_fail));
                    IMLog.m10021e(IMBaseRenderView.TAG, C4786I.m9980t("[playAudio] #onError# Fid=", iMMessage.getFid(), " |FileName=", iMMessage.getFile_name()));
                }

                public void onStop() {
                    IMAudioRenderView.this.m10416a(iMMessage, (Integer) 0);
                    IMLog.m10020d(IMBaseRenderView.TAG, C4786I.m9980t("[playAudio] #onStop# Fid=", iMMessage.getFid()));
                }
            });
        } catch (Exception e) {
            m10416a(iMMessage, (Integer) 0);
            IMLog.m10021e(TAG, "[playAudio]", e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m10423c(IMMessage iMMessage) {
        IMMessage itemNext = this.adapter.getItemNext(iMMessage);
        if (itemNext != null) {
            boolean z = itemNext.getSenderUid() == IMContextInfoHelper.getUid();
            if (itemNext.getType() == 131072 && !itemNext.isRead() && !z) {
                try {
                    itemNext.setIsRead(true);
                    IMMessageReadStatusManager.getInstance().addHasReadMsg(itemNext);
                    mo49163a(itemNext);
                } catch (Exception e) {
                    IMLog.m10021e(TAG, "[playNextAudio]", e);
                }
            }
        }
    }
}
