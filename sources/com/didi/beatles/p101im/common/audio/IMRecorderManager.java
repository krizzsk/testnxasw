package com.didi.beatles.p101im.common.audio;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.IMChatHelper;
import com.didi.beatles.p101im.common.audio.IMAudioRecorder;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager */
public class IMRecorderManager implements Handler.Callback {
    public static final int ERROR_NOT_RECORDER = 5;
    public static final int ERROR_NOT_START = 6;
    public static final int ERROR_OTHER_RECORDER = 4;
    public static final int ERROR_PERMISSION_DIALOG = 3;
    public static final int ERROR_SYSTEM_ERROR = 1;
    public static final int ERROR_TOO_SHORT = 2;

    /* renamed from: a */
    private static final String f10988a = "IMRecorderManager";

    /* renamed from: b */
    private static final int f10989b = 0;

    /* renamed from: c */
    private static final int f10990c = 1;

    /* renamed from: d */
    private static final int f10991d = 2;

    /* renamed from: e */
    private static final int f10992e = 3;

    /* renamed from: f */
    private static IMRecorderManager f10993f = new IMRecorderManager();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Holder f10994g = null;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Handler f10995h = new Handler(Looper.getMainLooper(), this);

    /* renamed from: i */
    private int f10996i = 11;

    /* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager$Callback */
    public interface Callback {
        void onEndRecord();

        void onError(int i, String str);

        void onResidueTimeChange(String str);

        void onSoundLevelChange(int i);

        void onStartRecord();

        void onSuccess(String str, long j);
    }

    public static String createFileId() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static IMRecorderManager getInstance() {
        return f10993f;
    }

    private IMRecorderManager() {
    }

    public void recorder(String str, Callback callback) {
        IMLog.m10024i(f10988a, C4786I.m9980t("recorder fileId ", str));
        Holder holder = this.f10994g;
        if (holder == null || !TextUtils.equals(str, holder.fileId)) {
            Holder holder2 = new Holder();
            holder2.fileId = str;
            holder2.callback = callback;
            holder2.recordTime = System.currentTimeMillis();
            Holder holder3 = this.f10994g;
            if (holder3 != null) {
                holder3.callback.onError(4, C4786I.m9980t("now recorder", str));
            }
            m9604a(true);
            this.f10994g = holder2;
            IMBtsAudioHelper.stopPlaying();
            m9606a(this.f10994g);
            return;
        }
        IMLog.m10021e(f10988a, C4786I.m9980t("fileId", str, "same as cur"));
    }

    public void stop(String str, Callback callback) {
        String str2 = str;
        Callback callback2 = callback;
        IMLog.m10024i(f10988a, C4786I.m9980t("stop fileId ", str2));
        Holder holder = this.f10994g;
        if (holder == null || !TextUtils.equals(str2, holder.fileId)) {
            IMLog.m10026w(f10988a, C4786I.m9980t("fileId", str2, "not recorder"));
            callback2.onError(5, (String) null);
            return;
        }
        long j = this.f10994g.recordTime;
        String a = m9604a(false);
        if (!IMAudioRecorder.isAudioExecute()) {
            IMLog.m10021e(f10988a, C4786I.m9980t("stop fileId ", str2, " but not start"));
            callback2.onError(6, (String) null);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        IMLog.m10024i(f10988a, C4786I.m9980t("fileId ", str2, " recorder duration ", Long.valueOf(currentTimeMillis), "ms"));
        int isAudioValid = IMChatHelper.isAudioValid(j, a);
        if (isAudioValid != IMChatHelper.ONCLICK_EVENT) {
            if (isAudioValid == IMChatHelper.TIME_TOO_SHORT) {
                callback2.onError(2, (String) null);
            } else if (isAudioValid == IMChatHelper.SIZE_TOO_SMALL) {
                callback2.onError(3, (String) null);
            } else {
                callback2.onSuccess(str2, currentTimeMillis);
            }
        }
    }

    public void cancel(String str, Callback callback) {
        IMLog.m10024i(f10988a, C4786I.m9980t("cancel fileId ", str));
        Holder holder = this.f10994g;
        if (holder == null || !TextUtils.equals(str, holder.fileId)) {
            IMLog.m10026w(f10988a, C4786I.m9980t("cancel fileId ", str, " but not recorder"));
            callback.onError(5, (String) null);
            return;
        }
        m9604a(true);
    }

    /* renamed from: a */
    private void m9606a(final Holder holder) {
        IMBtsAudioHelper.record(holder.fileId, new IMAudioRecorder.OnAudioRecordingListener() {
            /* access modifiers changed from: private */
            public boolean checkHolderPass() {
                if (holder == IMRecorderManager.this.f10994g) {
                    return false;
                }
                IMLog.m10024i(IMRecorderManager.f10988a, "holder is not same");
                return true;
            }

            public void onError(final String str) {
                IMLog.m10020d(IMRecorderManager.f10988a, "onError, " + str);
                IMRecorderManager.this.f10995h.post(new Runnable() {
                    public void run() {
                        if (!C45411.this.checkHolderPass()) {
                            holder.callback.onError(1, str);
                            String unused = IMRecorderManager.this.m9604a(true);
                        }
                    }
                });
            }

            public void onSucess() {
                IMLog.m10020d(IMRecorderManager.f10988a, "onSucess");
                IMRecorderManager.this.f10995h.post(new Runnable() {
                    public void run() {
                        if (!C45411.this.checkHolderPass()) {
                            holder.recordTime = System.currentTimeMillis();
                            IMRecorderManager.this.f10995h.sendEmptyMessageDelayed(0, (long) IMChatHelper.AUDIO_RECORD_THRESHOLD);
                        }
                    }
                });
            }

            public void permissionDialogShowed() {
                IMLog.m10020d(IMRecorderManager.f10988a, "permissionDialogShowed");
                IMRecorderManager.this.f10995h.post(new Runnable() {
                    public void run() {
                        if (!C45411.this.checkHolderPass()) {
                            holder.callback.onError(3, (String) null);
                            String unused = IMRecorderManager.this.m9604a(true);
                        }
                    }
                });
            }
        });
        this.f10995h.sendEmptyMessageDelayed(1, (long) IMChatHelper.AUDIO_RECORD_MAX_DURATION);
    }

    /* renamed from: a */
    private void m9605a() {
        Holder holder = this.f10994g;
        if (holder == null) {
            IMLog.m10026w(f10988a, "stopInner bug recorder is null!");
            return;
        }
        IMLog.m10024i(f10988a, C4786I.m9980t("stopInner fileId ", holder.fileId));
        stop(this.f10994g.fileId, this.f10994g.callback);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m9604a(boolean z) {
        this.f10995h.removeCallbacksAndMessages((Object) null);
        Holder holder = this.f10994g;
        if (holder != null) {
            holder.callback.onEndRecord();
        }
        this.f10994g = null;
        if (!z) {
            return IMBtsAudioHelper.stopRecording();
        }
        IMBtsAudioHelper.cancelRecording();
        return null;
    }

    public boolean handleMessage(Message message) {
        if (this.f10994g == null) {
            IMLog.m10026w(f10988a, C4786I.m9980t("handleMessage but recorder null msg what is ", Integer.valueOf(message.what)));
            return false;
        }
        int i = message.what;
        if (i == 0) {
            this.f10994g.callback.onStartRecord();
            this.f10996i = 11;
            this.f10995h.sendEmptyMessageDelayed(2, (long) IMChatHelper.AUDIO_RECORD_RESIDUE_TIME);
            this.f10995h.sendEmptyMessageDelayed(3, (long) IMChatHelper.AUDIO_RECORD_DB_DURATION);
        } else if (i == 1) {
            m9605a();
        } else if (i == 2) {
            int i2 = this.f10996i - 1;
            this.f10996i = i2;
            if (i2 > 0) {
                Callback callback = this.f10994g.callback;
                callback.onResidueTimeChange(this.f10996i + "");
            }
            this.f10995h.sendEmptyMessageDelayed(2, (long) IMChatHelper.AUDIO_RECORD_RESIDUE_DURATION);
        } else if (i != 3) {
            return false;
        } else {
            this.f10994g.callback.onSoundLevelChange(IMChatHelper.getBtsAudioAmpLitude());
            this.f10995h.sendEmptyMessageDelayed(3, (long) IMChatHelper.AUDIO_RECORD_DB_DURATION);
        }
        return true;
    }

    /* renamed from: com.didi.beatles.im.common.audio.IMRecorderManager$Holder */
    private static class Holder {
        Callback callback;
        String fileId;
        long recordTime;

        private Holder() {
        }
    }
}
