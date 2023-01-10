package com.iproov.sdk.face;

import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import p095switch.C3657break;
import p095switch.C3658case;
import p095switch.C3678this;

public class FaceFeatureSmoother {
    private final C3657break faceBounds;
    private final C3678this normalizedSize;
    public final C3678this pitch;
    public final C3678this roll;
    public final C3678this yaw;

    public FaceFeatureSmoother(double d) {
        this.normalizedSize = new C3678this(d);
        this.faceBounds = new C3657break(d);
        this.roll = new C3678this(d);
        this.yaw = new C3678this(d);
        this.pitch = new C3678this(d);
    }

    public void reset() {
        this.normalizedSize.mo43506if();
        this.faceBounds.mo43490do();
        this.roll.mo43506if();
        this.yaw.mo43506if();
        this.pitch.mo43506if();
    }

    public FaceFeature smooth(FaceFeature faceFeature) {
        StringBuilder sb = new StringBuilder();
        sb.append("WAS faceBounds=");
        sb.append(faceFeature.getFaceBounds());
        this.normalizedSize.mo43505do(Double.valueOf(faceFeature.getNormalizedSize()));
        if (faceFeature.getFaceBounds() != null) {
            this.faceBounds.mo43491do(faceFeature.getFaceBounds());
        }
        Pose pose = null;
        if (faceFeature.getPose() != null) {
            this.roll.mo43505do(Double.valueOf(C3658case.m7393do(faceFeature.getPose().roll)));
            this.yaw.mo43505do(Double.valueOf(C3658case.m7393do(faceFeature.getPose().yaw)));
            this.pitch.mo43505do(Double.valueOf(C3658case.m7393do(faceFeature.getPose().pitch)));
            pose = new Pose(C3658case.m7395do(this.roll.mo43504do().doubleValue()), C3658case.m7395do(this.yaw.mo43504do().doubleValue()), C3658case.m7395do(this.pitch.mo43504do().doubleValue()));
        }
        FaceFeature faceFeature2 = new FaceFeature(this.normalizedSize.mo43504do().doubleValue(), this.faceBounds.mo43492if(), pose);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SMOOTHED faceBounds=");
        sb2.append(faceFeature2.getFaceBounds());
        return faceFeature2;
    }
}
