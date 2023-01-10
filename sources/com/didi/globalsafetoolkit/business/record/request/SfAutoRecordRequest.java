package com.didi.globalsafetoolkit.business.record.request;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.android.didi.bfflib.business.BffRequestUtil;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.globalsafetoolkit.business.record.model.SfAutoRecordResponse;
import com.didi.globalsafetoolkit.business.safeCenter.GlobalSfManager;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.sdk.util.ToastHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public class SfAutoRecordRequest {
    public static final int SF_AUTO_RECORD_CLOSE = 2;
    public static final int SF_AUTO_RECORD_OPEN = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SfAutoRecordStatus {
    }

    public static void autoRecordReport(int i, final int i2) {
        ArrayMap arrayMap = new ArrayMap(1);
        arrayMap.put("auto_voice_switch", Integer.valueOf(i));
        BffRequestUtil.request(SfContextHelper.getContext(), "heimdallr/pSetAutoVoiceConfig", arrayMap, new BffResponseListener<SfAutoRecordResponse>() {
            public void onSuccess(SfAutoRecordResponse sfAutoRecordResponse) {
                SfAutoRecordRequest.requestJarvis(i2);
                if (sfAutoRecordResponse != null && !TextUtils.isEmpty(sfAutoRecordResponse.toast)) {
                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfAutoRecordResponse.toast);
                }
            }
        });
    }

    public static void autoRecordReport(String str, final int i) {
        ArrayMap arrayMap = new ArrayMap(1);
        arrayMap.put("action_id", str);
        BffRequestUtil.request(SfContextHelper.getContext(), "heimdallr/pSetAutoVoiceConfig", arrayMap, new BffResponseListener<SfAutoRecordResponse>() {
            public void onSuccess(SfAutoRecordResponse sfAutoRecordResponse) {
                SfAutoRecordRequest.requestJarvis(i);
                if (sfAutoRecordResponse != null && !TextUtils.isEmpty(sfAutoRecordResponse.toast)) {
                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfAutoRecordResponse.toast);
                }
            }
        });
    }

    public static void requestJarvis(int i) {
        GlobalSfManager.getInstance().refreshBubbleData(i, (Map<String, Object>) null, (BffResponseListener) null);
    }
}
