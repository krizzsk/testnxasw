package com.didi.soda.blocks.track;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R4\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/blocks/track/TrackConfig;", "", "()V", "isOpen", "", "()Z", "setOpen", "(Z)V", "value", "", "Lcom/didi/soda/blocks/track/TrackConfig$TemplateRate;", "rateConfig", "getRateConfig", "()Ljava/util/List;", "setRateConfig", "(Ljava/util/List;)V", "rateConfigMap", "", "", "", "getRateConfigMap", "()Ljava/util/Map;", "setRateConfigMap", "(Ljava/util/Map;)V", "TemplateRate", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TrackConfig.kt */
public final class TrackConfig {
    private boolean isOpen;
    private List<TemplateRate> rateConfig;
    private Map<String, Integer> rateConfigMap = new LinkedHashMap();

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final void setOpen(boolean z) {
        this.isOpen = z;
    }

    public final Map<String, Integer> getRateConfigMap() {
        return this.rateConfigMap;
    }

    public final void setRateConfigMap(Map<String, Integer> map) {
        Intrinsics.checkParameterIsNotNull(map, "<set-?>");
        this.rateConfigMap = map;
    }

    public final List<TemplateRate> getRateConfig() {
        return this.rateConfig;
    }

    public final void setRateConfig(List<TemplateRate> list) {
        if (list != null) {
            for (TemplateRate templateRate : list) {
                String templateId = templateRate.getTemplateId();
                if (templateId != null) {
                    Integer put = this.rateConfigMap.put(templateId, Integer.valueOf(templateRate.getAndroidRate()));
                }
            }
        }
        this.rateConfig = list;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/soda/blocks/track/TrackConfig$TemplateRate;", "Ljava/io/Serializable;", "()V", "androidRate", "", "getAndroidRate", "()I", "setAndroidRate", "(I)V", "iOSRate", "getIOSRate", "setIOSRate", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: TrackConfig.kt */
    public static final class TemplateRate implements Serializable {
        private int androidRate;
        private int iOSRate;
        private String templateId;

        public final String getTemplateId() {
            return this.templateId;
        }

        public final void setTemplateId(String str) {
            this.templateId = str;
        }

        public final int getAndroidRate() {
            return this.androidRate;
        }

        public final void setAndroidRate(int i) {
            this.androidRate = i;
        }

        public final int getIOSRate() {
            return this.iOSRate;
        }

        public final void setIOSRate(int i) {
            this.iOSRate = i;
        }
    }
}
