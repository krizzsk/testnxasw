package com.didi.sdk.audiorecorder.service.mainprocess;

import com.didi.sdk.audiorecorder.AudioRecordContext;
import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import com.didi.sdk.audiorecorder.helper.recorder.Supporter;
import com.didi.sdk.audiorecorder.service.IRecordServiceConnection;

/* renamed from: com.didi.sdk.audiorecorder.service.mainprocess.c */
/* compiled from: MainProcessRecordServiceConnection */
class C12914c implements IRecordServiceConnection {

    /* renamed from: a */
    private C12913b f38213a = new C12913b();

    C12914c() {
    }

    public void updateRecordContext(String str, AudioRecordContext audioRecordContext) {
        this.f38213a.mo97569a(str, audioRecordContext);
    }

    public void startRecord() {
        this.f38213a.startRecord();
    }

    public void stopRecord() {
        this.f38213a.stopRecord();
    }

    public void resumeRecord() {
        this.f38213a.resumeRecord();
    }

    public void pauseRecord() {
        this.f38213a.pauseRecord();
    }

    public boolean isRecording() {
        return this.f38213a.isRecording();
    }

    public void sliceAudioFile() {
        this.f38213a.sliceAudioFile();
    }

    public void updateSpeechDetectParams(String str) {
        this.f38213a.updateSpeechDetectParams(str);
    }

    public void clearTtsDataCache() {
        this.f38213a.clearTtsDataCache();
    }

    public void setRecordStateListener(AudioRecorder.RecordListener recordListener) {
        this.f38213a.setRecordStateListener(recordListener);
    }

    public void setRecordErrorListener(AudioRecorder.OnErrorListener onErrorListener) {
        this.f38213a.setRecordErrorListener(onErrorListener);
    }

    public void setRecordDurationListener(AudioRecorder.DurationChangedListener durationChangedListener) {
        this.f38213a.setRecordDurationListener(durationChangedListener);
    }

    public void setFileSliceListener(AudioRecorder.FileSliceListener fileSliceListener) {
        this.f38213a.setFileSliceListener(fileSliceListener);
    }

    public void setSpeechDetectListener(AudioRecorder.WordsDetectListener wordsDetectListener) {
        this.f38213a.setSpeechDetectListener(wordsDetectListener);
    }

    public void set16kPcmConsumer(Supporter.Pcm16kConsumer pcm16kConsumer) {
        this.f38213a.set16kPcmConsumer(pcm16kConsumer);
    }
}
