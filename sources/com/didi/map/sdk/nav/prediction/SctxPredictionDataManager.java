package com.didi.map.sdk.nav.prediction;

import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SctxPredictionDataManager {

    /* renamed from: a */
    private static final String f30943a = "SctxPredictionDataManager";

    /* renamed from: b */
    private List<String> f30944b;

    /* renamed from: c */
    private int f30945c;

    /* renamed from: d */
    private int f30946d;

    /* renamed from: e */
    private long f30947e;

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final SctxPredictionDataManager mInstance = new SctxPredictionDataManager();

        private SingletonHolder() {
        }
    }

    private SctxPredictionDataManager() {
        this.f30944b = new ArrayList();
    }

    public static SctxPredictionDataManager getInstance() {
        return SingletonHolder.mInstance;
    }

    public void insertData(SctxPredictionOmegaData sctxPredictionOmegaData) {
        String str;
        if (sctxPredictionOmegaData == null) {
            return;
        }
        if (sctxPredictionOmegaData.timestamp <= 0 || sctxPredictionOmegaData.timestamp != this.f30947e) {
            this.f30947e = sctxPredictionOmegaData.timestamp;
            this.f30945c++;
            if (sctxPredictionOmegaData.isPredicted()) {
                str = sctxPredictionOmegaData.getOutput();
                this.f30944b.add(str);
                this.f30946d++;
            } else {
                str = " ";
            }
            DLog.m10773d(f30943a, "预判埋点-插入数据, data:%s, mTotalCount:%d, mMockCount:%d", str, Integer.valueOf(this.f30945c), Integer.valueOf(this.f30946d));
            return;
        }
        DLog.m10773d(f30943a, "预判埋点-插入数据，但时间戳相同，过滤这条", new Object[0]);
    }

    public void doOmega(String str) {
        if (!this.f30944b.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("total_point", Integer.valueOf(this.f30945c));
            hashMap.put("mock_point", Integer.valueOf(this.f30946d));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Const.jaLeft);
            if (!this.f30944b.isEmpty()) {
                for (int i = 0; i < this.f30944b.size(); i++) {
                    stringBuffer.append(this.f30944b.get(i));
                    if (i < this.f30944b.size() - 1) {
                        stringBuffer.append(",");
                    }
                }
            }
            stringBuffer.append(Const.jaRight);
            hashMap.put("list", stringBuffer.toString());
            if (!TextUtils.isEmpty(PlatInfo.getInstance().getDriverPhoneNumber())) {
                hashMap.put("role", "driver");
            } else {
                hashMap.put("role", "passenger");
            }
            OmegaSDKAdapter.trackEvent("globalmap_pax_car_trend", "", hashMap);
            DLog.m10773d(f30943a, "预判埋点-上报, 列表个数:%d, mTotalCount:%d, mMockCount:%d", Integer.valueOf(this.f30944b.size()), Integer.valueOf(this.f30945c), Integer.valueOf(this.f30946d));
            clearData();
        }
    }

    public void clearData() {
        this.f30944b.clear();
        this.f30946d = 0;
        this.f30945c = 0;
    }
}
