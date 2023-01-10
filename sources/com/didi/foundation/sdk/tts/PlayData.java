package com.didi.foundation.sdk.tts;

public class PlayData {

    /* renamed from: a */
    TtsPriority f23233a;

    /* renamed from: b */
    boolean f23234b;

    /* renamed from: c */
    private String f23235c;

    /* renamed from: d */
    private int f23236d;

    /* renamed from: e */
    private PlayData f23237e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PlayData f23238f;

    public enum TtsPriority {
        NORMAL_PRIORITY,
        MIDDLE_PRIORITY,
        HIGH_PRIORITY
    }

    PlayData() {
        this.f23233a = TtsPriority.NORMAL_PRIORITY;
        this.f23234b = true;
        this.f23237e = this;
        this.f23238f = this.f23238f;
    }

    PlayData(int i) {
        this();
        this.f23236d = i;
        this.f23234b = false;
    }

    PlayData(String str) {
        this();
        this.f23235c = str;
        this.f23234b = true;
    }

    public String getTts() {
        return this.f23235c;
    }

    public int getRawId() {
        return this.f23236d;
    }

    public PlayData getNext() {
        return this.f23238f;
    }

    public static class Builder {
        private PlayData mCurrentPlayData;
        private PlayData mHeaderPlayData;
        private TtsPriority mPriority;

        public Builder(TtsPriority ttsPriority) {
            this.mPriority = ttsPriority;
        }

        public Builder() {
        }

        public Builder tts(String str) {
            PlayData playData = new PlayData(str);
            if (this.mHeaderPlayData == null) {
                this.mHeaderPlayData = playData;
                this.mCurrentPlayData = playData;
            } else {
                PlayData unused = this.mCurrentPlayData.f23238f = playData;
                this.mCurrentPlayData = playData;
            }
            TtsPriority ttsPriority = this.mPriority;
            if (ttsPriority != null) {
                playData.f23233a = ttsPriority;
            }
            return this;
        }

        public Builder rawId(int i) {
            PlayData playData = new PlayData(i);
            if (this.mHeaderPlayData == null) {
                TtsPriority ttsPriority = this.mPriority;
                if (ttsPriority != null) {
                    playData.f23233a = ttsPriority;
                }
                this.mHeaderPlayData = playData;
                this.mCurrentPlayData = playData;
            } else {
                PlayData unused = this.mCurrentPlayData.f23238f = playData;
                this.mCurrentPlayData = playData;
            }
            return this;
        }

        public PlayData build() {
            return this.mHeaderPlayData;
        }
    }

    public String toString() {
        return "PlayData{priority=" + this.f23233a + ", mTts='" + this.f23235c + '\'' + ", mRawId=" + this.f23236d + ", mNext=" + this.f23238f + '}';
    }
}
