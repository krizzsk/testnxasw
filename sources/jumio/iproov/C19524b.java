package jumio.iproov;

import com.taxis99.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* renamed from: jumio.iproov.b */
/* compiled from: IproovScanPart.kt */
public enum C19524b {
    AMBIGUOUS_OUTCOME("ambiguous_outcome", 100, R.string.iproov__failure_ambiguous_outcome),
    MOTION_TOO_MUCH("motion_too_much_movement", 101, R.string.iproov__failure_motion_too_much_movement),
    LIGHTING_FLASH("lighting_flash_reflection_too_low", 102, R.string.iproov__failure_lighting_flash_reflection_too_low),
    LIGHTING_BACKLIT("lighting_backlit", 103, R.string.iproov__failure_lighting_backlit),
    LIGHTING_TOO_DARK("lighting_too_dark", 104, R.string.iproov__failure_lighting_too_dark),
    LIGHTING_TOO_BRIGHT("lighting_face_too_bright", 105, R.string.iproov__failure_lighting_face_too_bright),
    MOTION_MOUTH("motion_too_much_mouth_movement", 106, R.string.iproov__failure_motion_too_much_mouth_movement),
    GENERIC("generic", 107, R.string.iproov__error_unexpected_error);
    

    /* renamed from: d */
    public static final C19525a f55437d = null;

    /* renamed from: a */
    public final String f55447a;

    /* renamed from: b */
    public final int f55448b;

    /* renamed from: c */
    public final int f55449c;

    /* renamed from: jumio.iproov.b$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C19525a {
        public C19525a() {
        }

        public /* synthetic */ C19525a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final C19524b mo148785a(String str) {
            C19524b bVar;
            int i = 0;
            if (str == null || str.length() == 0) {
                return C19524b.GENERIC;
            }
            C19524b[] values = C19524b.values();
            int length = values.length;
            while (true) {
                if (i >= length) {
                    bVar = null;
                    break;
                }
                bVar = values[i];
                i++;
                if (StringsKt.equals(bVar.mo148782b(), str, true)) {
                    break;
                }
            }
            if (bVar == null) {
                return C19524b.GENERIC;
            }
            return bVar;
        }
    }

    /* access modifiers changed from: public */
    static {
        f55437d = new C19525a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    C19524b(String str, int i, int i2) {
        this.f55447a = str;
        this.f55448b = i;
        this.f55449c = i2;
    }

    /* renamed from: b */
    public final String mo148782b() {
        return this.f55447a;
    }

    /* renamed from: c */
    public final int mo148783c() {
        return this.f55448b;
    }

    /* renamed from: d */
    public final int mo148784d() {
        return this.f55449c;
    }
}
