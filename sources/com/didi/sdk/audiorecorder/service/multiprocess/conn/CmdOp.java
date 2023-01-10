package com.didi.sdk.audiorecorder.service.multiprocess.conn;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

final class CmdOp {

    /* renamed from: a */
    static final int f38229a = -1;

    /* renamed from: b */
    static final int f38230b = 0;

    /* renamed from: c */
    int f38231c;

    /* renamed from: d */
    Object f38232d;

    /* renamed from: e */
    int f38233e = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Cmd {
        public static final int CLEAR_TTS_DATA = 10;
        public static final int GET_RECORDING_STATE = 5;
        public static final int PAUSE = 4;
        public static final int REGISTER_DURATION_CHANGED_LISTENER = 11;
        public static final int REGISTER_ERROR_LISTENER = 7;
        public static final int REGISTER_FILE_SLICE_LISTENER = 8;
        public static final int REGISTER_RECORD_LISTENER = 6;
        public static final int REGISTER_SPEECH_DETECT_LISTENER = 12;
        public static final int RESUME = 3;
        public static final int SLICE_AUDIO_FILE = 13;
        public static final int START = 1;
        public static final int START_16K_PCM_DISPATCH_SERVER = 14;
        public static final int STOP = 2;
        public static final int STOP_16K_PCM_DISPATCH_SERVER = 15;
        public static final int UPDATE_SPEECH_DETECT_PARAMS = 9;
    }

    CmdOp() {
    }

    CmdOp(int i) {
        this.f38231c = i;
    }

    CmdOp(int i, Object obj) {
        this.f38231c = i;
        this.f38232d = obj;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof CmdOp) && ((CmdOp) obj).f38231c == this.f38231c;
    }

    public String toString() {
        return "CmdOp{cmd=" + this.f38231c + ", params=" + this.f38232d + ", priority=" + this.f38233e + '}';
    }
}
