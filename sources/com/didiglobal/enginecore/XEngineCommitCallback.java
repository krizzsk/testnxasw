package com.didiglobal.enginecore;

import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, mo148868d2 = {"Lcom/didiglobal/enginecore/XEngineCommitCallback;", "", "onFailed", "", "e", "Lcom/didiglobal/enginecore/data/exception/EngineErrorException;", "onSuccess", "data", "Lcom/didiglobal/enginecore/data/model/XEngineData;", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: XEngineCommitCallback.kt */
public interface XEngineCommitCallback {
    void onFailed(EngineErrorException engineErrorException);

    void onSuccess(XEngineData xEngineData);
}
