package com.didi.beatles.p101im.access.recorder;

import android.text.TextUtils;
import com.didi.beatles.p101im.common.IMChatHelper;
import com.didi.beatles.p101im.common.audio.IMFileHelper;
import com.didi.beatles.p101im.common.audio.IMRecorderManager;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import java.io.File;

/* renamed from: com.didi.beatles.im.access.recorder.IMOpenRecorder */
public class IMOpenRecorder {

    /* renamed from: a */
    private static final String f10679a = "IMOpenRecorder";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IMOpenRecorderCallback f10680b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMOpenRecorderTip f10681c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f10682d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMRecorderManager.Callback f10683e;

    public void setCallback(IMOpenRecorderCallback iMOpenRecorderCallback) {
        this.f10680b = iMOpenRecorderCallback;
    }

    public void setTip(IMOpenRecorderTip iMOpenRecorderTip) {
        this.f10681c = iMOpenRecorderTip;
    }

    public void startRecorder() {
        this.f10682d = IMRecorderManager.createFileId();
        this.f10683e = new IMRecorderManager.Callback() {
            public void onError(int i, String str) {
                if (IMOpenRecorder.this.f10680b == null) {
                    return;
                }
                if (i == 1) {
                    IMOpenRecorder.this.f10680b.onRecorderError(3);
                } else if (i == 2) {
                    IMOpenRecorder.this.f10680b.onRecorderError(1);
                } else if (i != 3) {
                    IMOpenRecorder.this.f10680b.onRecorderError(-1);
                } else {
                    IMOpenRecorder.this.f10680b.onRecorderError(2);
                }
            }

            public void onSuccess(String str, long j) {
                IMLog.m10024i(IMOpenRecorder.f10679a, C4786I.m9980t("recorder success ", str, " ", Long.valueOf(j)));
                File audioFile = IMFileHelper.getAudioFile(str);
                if (audioFile == null) {
                    IMLog.m10021e(IMOpenRecorder.f10679a, C4786I.m9980t("recorder file is empty ", str));
                    if (IMOpenRecorder.this.f10680b != null) {
                        IMOpenRecorder.this.f10680b.onRecorderError(-1);
                        return;
                    }
                    return;
                }
                IMOpenRecorder.this.f10680b.onRecorderFinish(audioFile.getAbsolutePath(), (int) (Math.min(j, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION) / 1000));
            }

            public void onStartRecord() {
                if (IMOpenRecorder.this.f10680b != null) {
                    IMOpenRecorder.this.f10680b.onRecorderStart();
                }
            }

            public void onSoundLevelChange(int i) {
                if (IMOpenRecorder.this.f10681c != null && IMOpenRecorder.this.f10681c.isShowing()) {
                    IMOpenRecorder.this.f10681c.mo46553a().changeBackGroundBySound(i);
                }
            }

            public void onResidueTimeChange(String str) {
                if (IMOpenRecorder.this.f10681c != null && IMOpenRecorder.this.f10681c.isShowing()) {
                    IMOpenRecorder.this.f10681c.mo46553a().showResidueTime(str);
                }
            }

            public void onEndRecord() {
                String unused = IMOpenRecorder.this.f10682d = null;
                IMRecorderManager.Callback unused2 = IMOpenRecorder.this.f10683e = null;
            }
        };
        IMRecorderManager.getInstance().recorder(this.f10682d, this.f10683e);
    }

    public void stopRecorder() {
        if (TextUtils.isEmpty(this.f10682d) || this.f10683e == null) {
            IMLog.m10026w(f10679a, "stopRecorder but recorder is already release");
            IMOpenRecorderCallback iMOpenRecorderCallback = this.f10680b;
            if (iMOpenRecorderCallback != null) {
                iMOpenRecorderCallback.onRecorderError(-1);
                return;
            }
            return;
        }
        IMRecorderManager.getInstance().stop(this.f10682d, this.f10683e);
    }
}
