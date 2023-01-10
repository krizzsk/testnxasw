package com.didiglobal.scan.net;

import com.didiglobal.scan.data.ScanResultModel;
import com.didiglobal.scan.util.ScanSchemeDispatcher;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo148868d2 = {"<anonymous>", "", "run"}, mo148869k = 3, mo148870mv = {1, 1, 16})
/* compiled from: ScanNetRequest.kt */
final class ScanNetRequest$request$ability$2$onSuccess$1 implements Runnable {
    final /* synthetic */ ScanResultModel $model;

    ScanNetRequest$request$ability$2$onSuccess$1(ScanResultModel scanResultModel) {
        this.$model = scanResultModel;
    }

    public final void run() {
        ScanSchemeDispatcher.INSTANCE.dispatcher(this.$model.getSchema(), ScanNetRequest.INSTANCE.transActionType(this.$model.getAction_type()), this.$model.getSource());
    }
}
