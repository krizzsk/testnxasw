package com.jumio.sdk.credentials;

import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.C20952a;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.plugins.C20991a;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.sdk.enums.JumioScanSide;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.C19493n;
import jumio.core.C19515y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0005\u001a\u00020\u0002H\u0010¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, mo148868d2 = {"Lcom/jumio/sdk/credentials/JumioFaceCredential;", "Lcom/jumio/sdk/credentials/JumioCredential;", "", "start$jumio_core_release", "()V", "start", "Lcom/jumio/sdk/enums/JumioScanSide;", "scanSide", "Lcom/jumio/sdk/interfaces/JumioScanPartInterface;", "scanPartInterface", "Lcom/jumio/sdk/scanpart/JumioScanPart;", "initScanPart", "", "isConfigured", "()Z", "Lcom/jumio/core/Controller;", "controller", "Ljumio/core/n;", "credentialDataModel", "<init>", "(Lcom/jumio/core/Controller;Ljumio/core/n;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: JumioFaceCredential.kt */
public final class JumioFaceCredential extends JumioCredential {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JumioFaceCredential(Controller controller, C19493n nVar) {
        super(controller, nVar);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(nVar, "credentialDataModel");
    }

    /* renamed from: a */
    public final boolean mo172894a(C20952a... aVarArr) {
        C19493n nVar = (C19493n) getData$jumio_core_release();
        if (nVar.mo148681h() == null || nVar.mo148681h().isEmpty()) {
            return true;
        }
        int length = aVarArr.length;
        int i = 0;
        while (i < length) {
            C20952a aVar = aVarArr[i];
            i++;
            if (nVar.mo148681h().contains(aVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized JumioScanPart initScanPart(JumioScanSide jumioScanSide, JumioScanPartInterface jumioScanPartInterface) throws IllegalArgumentException {
        ScanPart<?> scanPart;
        JumioScanPart activeScanPart$jumio_core_release;
        Intrinsics.checkNotNullParameter(jumioScanSide, "scanSide");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        if (getData$jumio_core_release().mo148672f().containsKey(jumioScanSide)) {
            ScanPartPlugin scanPartPlugin = (ScanPartPlugin) C20991a.m43783b(C20991a.C20994c.FACE_IPROOV);
            Object obj = getData$jumio_core_release().mo148672f().get(jumioScanSide);
            if (obj != null) {
                FaceScanPartModel faceScanPartModel = (FaceScanPartModel) obj;
                if (scanPartPlugin != null) {
                    Controller controller$jumio_core_release = getController$jumio_core_release();
                    Object obj2 = getData$jumio_core_release().mo148672f().get(jumioScanSide);
                    Intrinsics.checkNotNull(obj2);
                    if (scanPartPlugin.isUsable(controller$jumio_core_release, (ScanPartModel) obj2)) {
                        if (mo172894a(C20952a.IPROOV_STANDARD, C20952a.IPROOV_PREMIUM)) {
                            faceScanPartModel.setMode(ScanMode.FACE_IPROOV);
                            scanPart = scanPartPlugin.getScanPart(getController$jumio_core_release(), this, faceScanPartModel, jumioScanPartInterface);
                            getData$jumio_core_release().mo148667a(jumioScanSide);
                            setActiveScanPart$jumio_core_release(new JumioScanPart(scanPart));
                            activeScanPart$jumio_core_release = getActiveScanPart$jumio_core_release();
                            Intrinsics.checkNotNull(activeScanPart$jumio_core_release);
                        }
                    }
                }
                faceScanPartModel.setMode(ScanMode.FACE_MANUAL);
                scanPart = new C19515y(getController$jumio_core_release(), this, faceScanPartModel, jumioScanPartInterface);
                getData$jumio_core_release().mo148667a(jumioScanSide);
                setActiveScanPart$jumio_core_release(new JumioScanPart(scanPart));
                activeScanPart$jumio_core_release = getActiveScanPart$jumio_core_release();
                Intrinsics.checkNotNull(activeScanPart$jumio_core_release);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.models.FaceScanPartModel");
            }
        } else {
            throw new IllegalArgumentException((jumioScanSide + " not found").toString());
        }
        return activeScanPart$jumio_core_release;
    }

    public boolean isConfigured() {
        return true;
    }

    public void start$jumio_core_release() {
        super.start$jumio_core_release();
        getData$jumio_core_release().mo148672f().put(JumioScanSide.FACE, new FaceScanPartModel(ScanMode.FACE_MANUAL));
    }

    public final synchronized JumioScanPart initScanPart(JumioScanPartInterface jumioScanPartInterface) {
        JumioScanSide firstKey;
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        firstKey = getData$jumio_core_release().mo148672f().firstKey();
        Intrinsics.checkNotNullExpressionValue(firstKey, "data.scanData.firstKey()");
        return initScanPart(firstKey, jumioScanPartInterface);
    }
}
