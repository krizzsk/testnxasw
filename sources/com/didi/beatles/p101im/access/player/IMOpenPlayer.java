package com.didi.beatles.p101im.access.player;

import android.content.Context;
import android.media.AudioManager;
import android.widget.Toast;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.beatles.p101im.api.entity.IMSendMessageResponse;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.IMBtsAudioPlayer;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.manager.IMMessageReadStatusManager;
import com.didi.beatles.p101im.module.IIMMessageModule;
import com.didi.beatles.p101im.module.IMMessageCallback;
import com.didi.beatles.p101im.module.entity.IMMessage;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMTextUtil;
import com.didi.beatles.p101im.utils.IMToastHelper;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.File;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.player.IMOpenPlayer */
public class IMOpenPlayer {

    /* renamed from: a */
    private static final String f10675a = "IMOpenPlayer";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f10676b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final IMMessage f10677c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IMOpenPlayerCallback f10678d;

    public IMOpenPlayer(Context context, IMMessage iMMessage) {
        this.f10676b = context;
        this.f10677c = iMMessage;
    }

    public void setCallback(IMOpenPlayerCallback iMOpenPlayerCallback) {
        this.f10678d = iMOpenPlayerCallback;
    }

    public void stop() {
        IMBtsAudioHelper.stopPlaying();
        IMBtsAudioHelper.releaseSensorModle();
    }

    public void play() {
        if (!IMEngine.getInstance(this.f10676b).hasInit()) {
            IMLog.m10021e(f10675a, C4786I.m9980t("[playAudio] im init fail"));
            IMOpenPlayerCallback iMOpenPlayerCallback = this.f10678d;
            if (iMOpenPlayerCallback != null) {
                iMOpenPlayerCallback.onError();
                return;
            }
            return;
        }
        IMBtsAudioHelper.initSensorModle((IMBtsAudioPlayer.onVoiceChannelChangeListener) null);
        String file_name = this.f10677c.getFile_name();
        boolean isRead = this.f10677c.isRead();
        if (IMTextUtil.isEmpty(file_name)) {
            if (IMManager.getInstance().getMessageModel() == null) {
                IMLog.m10021e(f10675a, C4786I.m9980t("[playAudio] NULL message model"));
                IMOpenPlayerCallback iMOpenPlayerCallback2 = this.f10678d;
                if (iMOpenPlayerCallback2 != null) {
                    iMOpenPlayerCallback2.onError();
                    return;
                }
                return;
            }
            IIMMessageModule messageModel = IMManager.getInstance().getMessageModel();
            IMMessage iMMessage = this.f10677c;
            messageModel.loadAudioMessage(iMMessage, iMMessage.getSid(), new IMMessageCallback() {
                public void onHistoryMessageLoad(List<IMMessage> list, boolean z) {
                }

                public void onReadStatusChange(List<IMMessage> list, boolean z) {
                }

                public void onReceive(List<IMMessage> list) {
                }

                public void onSendStatusChanged(IMMessage iMMessage, int i, IMSendMessageResponse iMSendMessageResponse) {
                    IMLog.m10020d(IMOpenPlayer.f10675a, C4786I.m9980t("[playAudio] #loadAudioMessage# Fid=", iMMessage.getFid(), " |status=", Integer.valueOf(i)));
                    if (i == 301) {
                        IMOpenPlayer.this.play();
                    } else if (IMOpenPlayer.this.f10678d != null) {
                        IMOpenPlayer.this.f10678d.onError();
                    }
                }
            });
        } else if (!new File(file_name).exists()) {
            IMLog.m10021e(f10675a, C4786I.m9980t("[playAudio] unable to find the audio file"));
            Context context = this.f10676b;
            SystemUtils.showToast(Toast.makeText(context, context.getString(R.string.bts_im_notfound_audio_file), 1));
            IMOpenPlayerCallback iMOpenPlayerCallback3 = this.f10678d;
            if (iMOpenPlayerCallback3 != null) {
                iMOpenPlayerCallback3.onError();
            }
        } else {
            if (!isRead && IMModelProvider.getInstance().getMessageModule() != null) {
                IMModelProvider.getInstance().getMessageModule().updateMessageAsync(this.f10677c);
            }
            m9296a();
            boolean z = this.f10677c.getSenderUid() == IMContextInfoHelper.getUid();
            if (!this.f10677c.isRead() && !z) {
                this.f10677c.setIsRead(true);
                IMMessageReadStatusManager.getInstance().addHasReadMsg(this.f10677c);
            }
            try {
                IMBtsAudioHelper.play(this.f10677c.getFile_name(), new IMBtsAudioPlayer.OnAudioPlayingListener() {
                    public void onStarted() {
                        IMLog.m10020d(IMOpenPlayer.f10675a, C4786I.m9980t("[playAudio] #onStarted# fid=", IMOpenPlayer.this.f10677c.getFid()));
                        if (IMOpenPlayer.this.f10678d != null) {
                            IMOpenPlayer.this.f10678d.onStart();
                        }
                    }

                    public void onCompletion() {
                        IMLog.m10020d(IMOpenPlayer.f10675a, C4786I.m9980t("[playAudio] #onCompletion# Fid=", IMOpenPlayer.this.f10677c.getFid()));
                        if (IMOpenPlayer.this.f10678d != null) {
                            IMOpenPlayer.this.f10678d.onCompletion();
                        }
                    }

                    public void onError(String str) {
                        IMToastHelper.showShortError(IMOpenPlayer.this.f10676b, IMOpenPlayer.this.f10676b.getString(R.string.bts_im_audio_play_fail));
                        IMLog.m10021e(IMOpenPlayer.f10675a, C4786I.m9980t("[playAudio] #onError# Fid=", IMOpenPlayer.this.f10677c.getFid(), " |FileName=", IMOpenPlayer.this.f10677c.getFile_name()));
                        if (IMOpenPlayer.this.f10678d != null) {
                            IMOpenPlayer.this.f10678d.onError();
                        }
                    }

                    public void onStop() {
                        IMLog.m10020d(IMOpenPlayer.f10675a, C4786I.m9980t("[playAudio] #onStop# Fid=", IMOpenPlayer.this.f10677c.getFid()));
                        if (IMOpenPlayer.this.f10678d != null) {
                            IMOpenPlayer.this.f10678d.onStop();
                        }
                    }
                });
            } catch (Exception e) {
                IMLog.m10021e(f10675a, "[playAudio]", e);
                IMOpenPlayerCallback iMOpenPlayerCallback4 = this.f10678d;
                if (iMOpenPlayerCallback4 != null) {
                    iMOpenPlayerCallback4.onError();
                }
            }
        }
    }

    /* renamed from: a */
    private void m9296a() {
        AudioManager audioManager = (AudioManager) this.f10676b.getSystemService("audio");
        if (audioManager != null) {
            int streamType = IMContextInfoHelper.getAudioConfig().getStreamType();
            int streamVolume = audioManager.getStreamVolume(streamType);
            int streamMaxVolume = audioManager.getStreamMaxVolume(streamType);
            if (streamVolume == 0) {
                m9297a(R.drawable.bts_im_volume_tip, R.string.bts_im_audio_min_tip);
            } else if (((double) streamVolume) < ((double) streamMaxVolume) * 0.4d) {
                m9297a(R.drawable.im_volume_icon, R.string.bts_im_audio_min_tip);
            }
            IMLog.m10020d(f10675a, C4786I.m9980t(" [isAudioVoiceMin] currVolume=", Integer.valueOf(streamVolume), " |maxVolume=", Integer.valueOf(streamMaxVolume)));
        }
    }

    /* renamed from: a */
    private void m9297a(int i, int i2) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), i2, 0);
        SystemUtils.showToast(makeText);
        try {
            IMTipsToast.setIcon(makeText, i);
            IMTipsToast.setText(makeText, this.f10676b.getString(i2));
        } catch (Exception e) {
            IMLog.m10021e(f10675a, "[showTips]", e);
        }
    }
}
