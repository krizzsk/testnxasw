package com.didiglobal.eevee.mew;

import com.didiglobal.common.common.mew.model.EMewModel;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.List;

class EMewPresenter$1 implements XEResponseCallback {
    final /* synthetic */ C17606a this$0;

    EMewPresenter$1(C17606a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        EMewModel eMewModel = (EMewModel) new Gson().fromJson((JsonElement) xEngineData.jsonObject, EMewModel.class);
        if (eMewModel != null) {
            this.this$0.m39522a(eMewModel.uiConfig);
        }
        this.this$0.m39526a(list);
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        engineErrorException.printStackTrace();
    }
}
