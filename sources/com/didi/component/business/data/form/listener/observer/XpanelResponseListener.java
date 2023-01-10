package com.didi.component.business.data.form.listener.observer;

import com.didiglobal.enginecore.data.exception.EngineErrorException;

public interface XpanelResponseListener {
    void onFailed(String str, EngineErrorException engineErrorException);
}
