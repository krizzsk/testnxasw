package com.didichuxing.mas.sdk.quality.collect.lag;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.fps.OmegaFPS;
import com.didichuxing.mas.sdk.quality.collect.lag.internal.BlockInfo;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.record.LagRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.DataTrackUtil;
import java.util.Iterator;

public class OmegaLag {

    /* renamed from: a */
    private static OmegaLag f50684a;

    /* renamed from: b */
    private static BlockCanary f50685b;

    /* renamed from: c */
    private boolean f50686c = false;

    private OmegaLag() {
    }

    public static synchronized OmegaLag getInstance() {
        OmegaLag omegaLag;
        synchronized (OmegaLag.class) {
            if (f50684a == null) {
                f50684a = new OmegaLag();
            }
            omegaLag = f50684a;
        }
        return omegaLag;
    }

    public void start(Context context) {
        if (!this.f50686c) {
            this.f50686c = true;
            BlockCanary install = BlockCanary.install(context, new OmegaBlockCaneryContext());
            f50685b = install;
            install.start();
        }
    }

    public void stop() {
        BlockCanary blockCanary = f50685b;
        if (blockCanary != null) {
            blockCanary.stop();
            f50685b = null;
            this.f50686c = false;
        }
    }

    public class OmegaBlockCaneryContext extends BlockCanaryContext {
        public OmegaBlockCaneryContext() {
        }

        public void onBlock(Context context, BlockInfo blockInfo) {
            LagRecord createLagRecord = RecordFactory.createLagRecord();
            boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_lag", MASConfig.UPPER_LIMIT_LAG_EVENT_PER_DAY);
            DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.LAG, createLagRecord.getRecordId(), isUpperLimitByDay);
            if (isUpperLimitByDay) {
                OmegaLag.this.stop();
                return;
            }
            createLagRecord.takeLogcat();
            createLagRecord.setCpuBusy(Boolean.valueOf(blockInfo.cpuBusy));
            createLagRecord.setCpuRate(blockInfo.cpuRateInfo);
            createLagRecord.setBlockTime(blockInfo.getTimeString());
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = blockInfo.threadStackEntries.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("\r\n");
            }
            createLagRecord.setErrorTrace(sb.toString());
            createLagRecord.setLatestFPS(OmegaFPS.getInstance().getLatestFPS());
            createLagRecord.setSystemRefreshRate(OmegaFPS.getInstance().getSystemRefreshRate());
            RecordStorage.save(createLagRecord);
            CommonUtil.addUpperLimitByDay("upper_limit_lag");
        }
    }

    public boolean isLagChecking() {
        return this.f50686c;
    }
}
