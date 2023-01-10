package p236else;

import com.iproov.sdk.face.model.Pose;
import p098try.C3688do;

/* renamed from: else.for */
/* compiled from: PoseManager */
public class C21831for {

    /* renamed from: a */
    private final Float f59994a;

    /* renamed from: b */
    private final Float f59995b;

    /* renamed from: c */
    private final Float f59996c;

    public C21831for(Float f, Float f2, Float f3) {
        this.f59994a = f;
        this.f59995b = f2;
        this.f59996c = f3;
    }

    /* renamed from: do */
    public C3688do mo180464do(Pose pose) {
        Float f = this.f59994a;
        if (f != null) {
            if (pose.roll > f.floatValue()) {
                return C3688do.ROLL_TOO_HIGH;
            }
            if ((-pose.roll) > this.f59994a.floatValue()) {
                return C3688do.ROLL_TOO_LOW;
            }
        }
        Float f2 = this.f59995b;
        if (f2 != null) {
            if (pose.yaw > f2.floatValue()) {
                return C3688do.YAW_TOO_HIGH;
            }
            if ((-pose.yaw) > this.f59995b.floatValue()) {
                return C3688do.YAW_TOO_LOW;
            }
        }
        Float f3 = this.f59996c;
        if (f3 == null) {
            return null;
        }
        if (pose.pitch > f3.floatValue()) {
            return C3688do.PITCH_TOO_HIGH;
        }
        if ((-pose.pitch) > this.f59996c.floatValue()) {
            return C3688do.PITCH_TOO_LOW;
        }
        return null;
    }
}
