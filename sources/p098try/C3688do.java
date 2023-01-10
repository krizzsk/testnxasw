package p098try;

/* renamed from: try.do */
/* compiled from: CannyState */
public enum C3688do {
    NO_FACE_PATH("no_face_path", false),
    FACE_PATH("face_path", false),
    END_FACE_PATH("end_face_path", false, true),
    TOO_FAR_FACE_PATH("too_far_face_path"),
    TOO_CLOSE_FACE_PATH("too_close_face_path"),
    NO_FACE("no_face", false),
    TOO_FAR("face_too_small"),
    TOO_CLOSE("face_too_big"),
    TOO_BRIGHT("too_bright"),
    ROLL_TOO_HIGH("roll_too_high"),
    ROLL_TOO_LOW("roll_too_low"),
    YAW_TOO_HIGH("yaw_too_high"),
    YAW_TOO_LOW("yaw_too_low"),
    PITCH_TOO_HIGH("pitch_too_high"),
    PITCH_TOO_LOW("pitch_too_low"),
    READY("ready");
    

    /* renamed from: do */
    private String f8820do;

    /* renamed from: for  reason: not valid java name */
    private boolean f62331for;

    /* renamed from: if */
    private boolean f8821if;

    private C3688do(String str) {
        this.f8820do = str;
        this.f62331for = true;
        this.f8821if = false;
    }

    /* renamed from: do */
    public String mo43535do() {
        return this.f8820do;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m46680for() {
        return this.f62331for;
    }

    /* renamed from: if */
    public boolean mo43537if() {
        return this.f8821if;
    }

    private C3688do(String str, boolean z) {
        this.f8820do = str;
        this.f62331for = z;
        this.f8821if = false;
    }

    private C3688do(String str, boolean z, boolean z2) {
        this.f8820do = str;
        this.f62331for = z;
        this.f8821if = z2;
    }
}
