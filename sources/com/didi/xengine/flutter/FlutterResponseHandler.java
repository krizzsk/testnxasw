package com.didi.xengine.flutter;

import com.didi.xengine.flutter.model.FlutterResponseModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import java.util.List;

@Deprecated
public class FlutterResponseHandler implements XEResponseCallback {

    /* renamed from: a */
    private FlutterEngineResponse f47849a;

    public FlutterResponseHandler(FlutterEngineResponse flutterEngineResponse) {
        this.f47849a = flutterEngineResponse;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        if (this.f47849a != null) {
            this.f47849a.onMessageGot(new FlutterResponseModel(0, "success", str, xEngineData));
        }
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        if (this.f47849a != null) {
            this.f47849a.onMessageGot(new FlutterResponseModel(engineErrorException.getErrNo(), "failed", str));
        }
    }
}
