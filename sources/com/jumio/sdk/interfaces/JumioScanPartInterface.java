package com.jumio.sdk.interfaces;

import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\n"}, mo148868d2 = {"Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "", "Lcom/jumio/sdk/enums/JumioScanUpdate;", "jumioScanUpdate", "data", "", "onUpdate", "Lcom/jumio/sdk/enums/JumioScanStep;", "jumioScanStep", "onScanStep", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioScanPartInterface.kt */
public interface JumioScanPartInterface {
    void onScanStep(JumioScanStep jumioScanStep, Object obj);

    void onUpdate(JumioScanUpdate jumioScanUpdate, Object obj);
}
