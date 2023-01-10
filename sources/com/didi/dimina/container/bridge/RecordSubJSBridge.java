package com.didi.dimina.container.bridge;

import android.media.MediaRecorder;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMSandboxHelper;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RecordSubJSBridge {

    /* renamed from: b */
    private static final int[] f18535b = {8000, 11025, 22050, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR};

    /* renamed from: a */
    MediaRecorder f18536a;

    /* renamed from: c */
    private final DMSandboxHelper f18537c;

    /* renamed from: d */
    private final DMMina f18538d;

    /* renamed from: e */
    private String f18539e;

    /* renamed from: f */
    private CallbackFunction f18540f;

    public RecordSubJSBridge(DMMina dMMina) {
        LogUtil.m16841i("RecordSubJSBridge init");
        this.f18538d = dMMina;
        this.f18537c = new DMSandboxHelper(dMMina.getConfig());
    }

    public void startRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            this.f18539e = this.f18537c.getSandboxTmpDir() + File.separator + System.currentTimeMillis() + ".amr";
            MediaRecorder mediaRecorder = new MediaRecorder();
            this.f18536a = mediaRecorder;
            mediaRecorder.setAudioSource(1);
            this.f18536a.setOutputFormat(3);
            this.f18536a.setOutputFile(this.f18539e);
            this.f18536a.setAudioEncoder(1);
            this.f18536a.setAudioChannels(1);
            this.f18536a.setAudioSamplingRate(f18535b[3]);
            this.f18536a.setAudioEncodingBitRate(96000);
            this.f18536a.prepare();
            this.f18536a.start();
            this.f18540f = callbackFunction;
        } catch (IllegalStateException e) {
            LogUtil.m16839e(e.getMessage());
        } catch (IOException unused) {
            LogUtil.m16839e("prepare() failed");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stopRecord(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CallBackUtil.onSuccess(callbackFunction);
        MediaRecorder mediaRecorder = this.f18536a;
        if (mediaRecorder != null && this.f18540f != null) {
            try {
                mediaRecorder.stop();
                this.f18536a.release();
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", this.f18537c.filepath2url(this.f18539e));
                CallBackUtil.onSuccess((Map<String, ? extends Object>) hashMap, this.f18540f);
            } catch (IllegalStateException e) {
                CallBackUtil.onFail(e.getMessage(), this.f18540f);
            }
        }
    }
}
