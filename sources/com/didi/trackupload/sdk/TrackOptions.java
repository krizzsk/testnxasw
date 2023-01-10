package com.didi.trackupload.sdk;

public class TrackOptions {

    /* renamed from: a */
    private GatherIntervalMode f46550a;

    /* renamed from: b */
    private UploadIntervalMode f46551b;

    public void setLocationMode(int i, int i2) {
    }

    public TrackOptions() {
    }

    public TrackOptions(GatherIntervalMode gatherIntervalMode, UploadIntervalMode uploadIntervalMode) {
        this.f46550a = gatherIntervalMode;
        this.f46551b = uploadIntervalMode;
    }

    public GatherIntervalMode getGatherIntervalMode() {
        return this.f46550a;
    }

    public void setGatherIntervalMode(GatherIntervalMode gatherIntervalMode) {
        this.f46550a = gatherIntervalMode;
    }

    public UploadIntervalMode getUploadIntervalMode() {
        return this.f46551b;
    }

    public void setUploadIntervalMode(UploadIntervalMode uploadIntervalMode) {
        this.f46551b = uploadIntervalMode;
    }

    public boolean checkVaild() {
        GatherIntervalMode gatherIntervalMode = this.f46550a;
        return (gatherIntervalMode == null || this.f46551b == null || gatherIntervalMode.value() > this.f46551b.value()) ? false : true;
    }

    public String toString() {
        return "{gather=" + this.f46550a + ", upload=" + this.f46551b + "}";
    }

    public enum GatherIntervalMode {
        NEVER(-1),
        HIGH_FREQUENCY(1000),
        NORMAL(3000),
        LOW_FREQUENCY(9000),
        BATTERY_SAVE(36000);
        
        private long mIntervalMillis;
        private String mName;

        private GatherIntervalMode(long j) {
            this.mIntervalMillis = j;
            this.mName = name() + "(" + value() + ")";
        }

        public long value() {
            return this.mIntervalMillis;
        }

        public String toString() {
            return this.mName;
        }
    }

    public enum UploadIntervalMode {
        ULTRAHIGH_FREQUENCY(1000),
        HIGH_FREQUENCY(3000),
        NORMAL(9000),
        LOW_FREQUENCY(36000),
        BATTERY_SAVE(72000);
        
        private long mIntervalMillis;
        private String mName;

        private UploadIntervalMode(long j) {
            this.mIntervalMillis = j;
            this.mName = name() + "(" + value() + ")";
        }

        public long value() {
            return this.mIntervalMillis;
        }

        private void configValue(long j) {
            this.mIntervalMillis = j;
        }

        public String toString() {
            return this.mName;
        }
    }
}
