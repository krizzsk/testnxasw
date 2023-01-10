package jumio.core;

import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.scanpart.JVisionScanPart;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.enums.JumioCameraFacing;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.y */
/* compiled from: ManualFaceScanPart.kt */
public final class C19515y extends JVisionScanPart<FaceScanPartModel> {

    /* renamed from: jumio.core.y$a */
    /* compiled from: ManualFaceScanPart.kt */
    public /* synthetic */ class C19516a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55420a;

        static {
            int[] iArr = new int[ScanMode.values().length];
            iArr[ScanMode.FACE_MANUAL.ordinal()] = 1;
            f55420a = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19515y(Controller controller, JumioFaceCredential jumioFaceCredential, FaceScanPartModel faceScanPartModel, JumioScanPartInterface jumioScanPartInterface) {
        super(controller, jumioFaceCredential, faceScanPartModel, jumioScanPartInterface);
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(jumioFaceCredential, "credential");
        Intrinsics.checkNotNullParameter(faceScanPartModel, "scanPartModel");
        Intrinsics.checkNotNullParameter(jumioScanPartInterface, "scanPartInterface");
        reset();
    }

    /* renamed from: i */
    public JumioCameraFacing[] mo148704i() {
        return new JumioCameraFacing[]{JumioCameraFacing.FRONT};
    }

    public void reset() {
        ((FaceScanPartModel) getScanPartModel()).setLivenessData((LivenessDataModel) null);
        super.reset();
    }

    public void onResult(StaticModel staticModel) {
        LivenessDataModel livenessDataModel = staticModel instanceof LivenessDataModel ? (LivenessDataModel) staticModel : null;
        ((FaceScanPartModel) getScanPartModel()).setLivenessData(livenessDataModel);
        if (C19516a.f55420a[((FaceScanPartModel) getScanPartModel()).getMode().ordinal()] == 1 && livenessDataModel != null) {
            getController().getBackendManager().uploadLiveness(getCredential(), livenessDataModel);
        }
        super.onResult(staticModel);
    }
}
