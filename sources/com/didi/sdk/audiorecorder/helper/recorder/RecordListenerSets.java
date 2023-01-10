package com.didi.sdk.audiorecorder.helper.recorder;

import com.didi.sdk.audiorecorder.helper.recorder.AudioRecorder;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecordListenerSets implements AudioRecordActionListener, AudioRecorder.RecordListener {

    /* renamed from: a */
    private CopyOnWriteArrayList<AudioRecorder.RecordListener> f38126a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private CopyOnWriteArrayList<AudioRecordActionListener> f38127b = new CopyOnWriteArrayList<>();

    public void addRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f38126a.add(recordListener);
    }

    public void removeRecordListener(AudioRecorder.RecordListener recordListener) {
        this.f38126a.remove(recordListener);
    }

    public void onStart() {
        for (int i = 0; i < this.f38126a.size(); i++) {
            this.f38126a.get(i).onStart();
        }
    }

    public void onResume() {
        for (int i = 0; i < this.f38126a.size(); i++) {
            this.f38126a.get(i).onResume();
        }
    }

    public void onPause() {
        for (int i = 0; i < this.f38126a.size(); i++) {
            this.f38126a.get(i).onPause();
        }
    }

    public void onStop() {
        for (int i = 0; i < this.f38126a.size(); i++) {
            this.f38126a.get(i).onStop();
        }
    }

    public void addActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f38127b.add(audioRecordActionListener);
    }

    public void removeActionListener(AudioRecordActionListener audioRecordActionListener) {
        this.f38127b.remove(audioRecordActionListener);
    }

    public void onTriggerStart() {
        for (int i = 0; i < this.f38127b.size(); i++) {
            this.f38127b.get(i).onTriggerStart();
        }
    }

    public void onTriggerResume() {
        for (int i = 0; i < this.f38127b.size(); i++) {
            this.f38127b.get(i).onTriggerResume();
        }
    }
}
