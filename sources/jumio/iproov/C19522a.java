package jumio.iproov;

import com.iproov.sdk.core.exception.CameraException;
import com.iproov.sdk.core.exception.CameraPermissionException;
import com.iproov.sdk.core.exception.CaptureAlreadyActiveException;
import com.iproov.sdk.core.exception.FaceDetectorException;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.core.exception.MultiWindowUnsupportedException;
import com.iproov.sdk.core.exception.NetworkException;
import com.iproov.sdk.core.exception.ServerException;
import com.iproov.sdk.core.exception.UnexpectedErrorException;
import com.iproov.sdk.core.exception.UnsupportedDeviceException;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.iproov.a */
/* compiled from: IproovScanPart.kt */
public enum C19522a {
    CAMERA_PERMISSION(C2404Reflection.getOrCreateKotlinClass(CameraPermissionException.class).getSimpleName(), 201),
    CAPTURE_ALREADY_ACTIVE(C2404Reflection.getOrCreateKotlinClass(CaptureAlreadyActiveException.class).getSimpleName(), 202),
    UNEXPECTED_ERROR(C2404Reflection.getOrCreateKotlinClass(UnexpectedErrorException.class).getSimpleName(), 203),
    SERVER(C2404Reflection.getOrCreateKotlinClass(ServerException.class).getSimpleName(), 204),
    NETWORK(C2404Reflection.getOrCreateKotlinClass(NetworkException.class).getSimpleName(), 205),
    CAMERA(C2404Reflection.getOrCreateKotlinClass(CameraException.class).getSimpleName(), 200),
    UNSUPPORTED_DEVICE(C2404Reflection.getOrCreateKotlinClass(UnsupportedDeviceException.class).getSimpleName(), 206),
    FACE_DETECTOR(C2404Reflection.getOrCreateKotlinClass(FaceDetectorException.class).getSimpleName(), 207),
    MULTI_WINDOW(C2404Reflection.getOrCreateKotlinClass(MultiWindowUnsupportedException.class).getSimpleName(), 208),
    GENERIC(C2404Reflection.getOrCreateKotlinClass(IProovException.class).getSimpleName(), 209);
    

    /* renamed from: c */
    public static final C19523a f55423c = null;

    /* renamed from: a */
    public final String f55435a;

    /* renamed from: b */
    public final int f55436b;

    /* renamed from: jumio.iproov.a$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C19523a {
        public C19523a() {
        }

        public /* synthetic */ C19523a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: a */
        public final C19522a mo148781a(IProovException iProovException) {
            C19522a aVar;
            if (iProovException == null || iProovException.getReason() == null) {
                return C19522a.GENERIC;
            }
            C19522a[] values = C19522a.values();
            int i = 0;
            int length = values.length;
            while (true) {
                if (i >= length) {
                    aVar = null;
                    break;
                }
                aVar = values[i];
                i++;
                if (Intrinsics.areEqual((Object) aVar.mo148779b(), (Object) iProovException.getClass().getSimpleName())) {
                    break;
                }
            }
            if (aVar == null) {
                return C19522a.GENERIC;
            }
            return aVar;
        }
    }

    /* access modifiers changed from: public */
    static {
        f55423c = new C19523a((DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: public */
    C19522a(String str, int i) {
        this.f55435a = str;
        this.f55436b = i;
    }

    /* renamed from: b */
    public final String mo148779b() {
        return this.f55435a;
    }

    /* renamed from: c */
    public final int mo148780c() {
        return this.f55436b;
    }
}
