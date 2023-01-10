package com.kwai.koom.javaoom.common;

import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.monitor.HeapThreshold;
import java.io.File;

public class KConfig {

    /* renamed from: a */
    private HeapThreshold f58425a;

    /* renamed from: b */
    private String f58426b;

    /* renamed from: c */
    private String f58427c;

    public KConfig(HeapThreshold heapThreshold, String str, String str2) {
        this.f58426b = str;
        this.f58427c = str2;
        this.f58425a = heapThreshold;
    }

    public HeapThreshold getHeapThreshold() {
        return this.f58425a;
    }

    public String getRootDir() {
        return this.f58426b;
    }

    public void setRootDir(String str) {
        this.f58426b = str;
    }

    public String getProcessName() {
        return this.f58427c;
    }

    public static KConfig defaultConfig() {
        return new KConfigBuilder().build();
    }

    public static class KConfigBuilder {
        private float heapMaxRatio = KConstants.HeapThreshold.getDefaultMaxPercentRation();
        private int heapOverTimes = KConstants.HeapThreshold.OVER_TIMES;
        private int heapPollInterval = KConstants.HeapThreshold.POLL_INTERVAL;
        private float heapRatio = KConstants.HeapThreshold.getDefaultPercentRation();
        private String processName;
        private String rootDir;

        public KConfigBuilder() {
            String str;
            File cacheDir = KGlobalConfig.getApplication().getCacheDir();
            if (cacheDir != null) {
                str = cacheDir.getAbsolutePath() + File.separator + "koom";
            } else {
                str = "/data/data/" + KGlobalConfig.getApplication().getPackageName() + "/cache/" + "koom";
            }
            this.rootDir = str;
            File file = new File(this.rootDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.processName = KGlobalConfig.getApplication().getPackageName();
        }

        public KConfigBuilder heapRatio(float f) {
            this.heapRatio = f;
            return this;
        }

        public KConfigBuilder heapMaxRatio(float f) {
            this.heapMaxRatio = f;
            return this;
        }

        public KConfigBuilder heapOverTimes(int i) {
            this.heapOverTimes = i;
            return this;
        }

        public KConfigBuilder rootDir(String str) {
            this.rootDir = str;
            return this;
        }

        public KConfigBuilder processName(String str) {
            this.processName = str;
            return this;
        }

        public KConfig build() {
            float f = this.heapRatio;
            float f2 = this.heapMaxRatio;
            if (f <= f2) {
                return new KConfig(new HeapThreshold(f, f2, this.heapOverTimes, this.heapPollInterval), this.rootDir, this.processName);
            }
            throw new RuntimeException("heapMaxRatio be greater than heapRatio");
        }
    }
}
