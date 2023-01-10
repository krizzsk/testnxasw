package com.didi.sdk.audiorecorder.service.mainprocess;

import android.content.Context;
import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.IRecordService;
import com.didi.sdk.audiorecorder.speechdetect.TTServerWrapper;
import com.didi.sdk.audiorecorder.utils.LogUtil;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.b */
/* compiled from: MainProcessRecordService */
class C12913b implements AudioRecorder.FileSlicer, IRecordService {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AudioRecorderImpl f38210a;

    /* renamed from: b */
    private C12915d f38211b;

    /* renamed from: c */
    private TTServerWrapper f38212c = new TTServerWrapper();

    C12913b() {
    }

    /* renamed from: a */
    public void mo97569a(String str, AudioRecordContext audioRecordContext) {
        LogUtil.updateUserPhone(audioRecordContext.getUserPhone());
        Context appContext = audioRecordContext.getAppContext();
        if (this.f38210a == null) {
            AudioRecorderImpl audioRecorderImpl = new AudioRecorderImpl(appContext, appContext.getFilesDir().getAbsolutePath() + IRecordService.DEFAULT_AUDIO_CACHE_FOLDER);
            this.f38210a = audioRecorderImpl;
            C12915d dVar = new C12915d(audioRecorderImpl, this);
            this.f38211b = dVar;
            audioRecorderImpl.setRecordListener(dVar);
            this.f38210a.setDurationChangedListener(this.f38211b);
        }
        this.f38211b.mo97571a(audioRecordContext.getAudioSegmentDuration());
        this.f38212c.getTTServerName(new MainProcessRecordService$1(this, audioRecordContext, str));
    }

    public void startRecord() {
        if (this.f38210a != null) {
            this.f38211b.mo97575b(1);
            this.f38210a.startRecord();
        }
    }

    public void stopRecord() {
        if (this.f38210a != null) {
            this.f38211b.mo97575b(2);
            this.f38210a.stopRecord();
        }
    }

    public void resumeRecord() {
        if (this.f38210a != null) {
            this.f38211b.mo97575b(3);
            this.f38210a.resumeRecord();
        }
    }

    public void pauseRecord() {
        if (this.f38210a != null) {
            this.f38211b.mo97575b(4);
            this.f38210a.pauseRecord();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f38211b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isRecording() {
        /*
            r1 = this;
            com.didi.sdk.audiorecorder.helper.recorder.AudioRecorderImpl r0 = r1.f38210a
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isRecording()
            if (r0 == 0) goto L_0x0016
            com.didi.sdk.audiorecorder.service.mainprocess.d r0 = r1.f38211b
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.mo97576c()
            if (r0 == 0) goto L_0x0016
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.audiorecorder.service.mainprocess.C12913b.isRecording():boolean");
    }

    public void sliceAudioFile() {
        C12915d dVar = this.f38211b;
        if (dVar != null) {
            dVar.mo97574b();
        }
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.sliceAudioFile();
        }
    }

    public void updateSpeechDetectParams(String str) {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.updateSpeechDetectParams(str);
        }
    }

    public void clearTtsDataCache() {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.clearTtsDataCache();
        }
    }

    public void setRecordStateListener(AudioRecorder.RecordListener recordListener) {
        C12915d dVar = this.f38211b;
        if (dVar != null) {
            dVar.mo97573a(recordListener);
        }
    }

    public void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setOnErrorListener(onErrorListener);
        }
    }

    public void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        C12915d dVar = this.f38211b;
        if (dVar != null) {
            dVar.mo97572a(durationChangedListener);
        }
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setFileSliceListener(fileSliceListener);
        }
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setSpeechDetectListener(wordsDetectListener);
        }
    }

    public void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        AudioRecorderImpl audioRecorderImpl = this.f38210a;
        if (audioRecorderImpl != null) {
            audioRecorderImpl.setPcm16kConsumer(pcm16kConsumer);
        }
    }
}
