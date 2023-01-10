package kotlin.reflect.jvm.internal.impl.types.checker;

import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.iproov.sdk.bridge.OptionsBridge;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.b */
/* compiled from: TypeCheckerProcedureCallbacksImpl */
class C2674b implements TypeCheckingProcedureCallbacks {
    /* renamed from: a */
    private static /* synthetic */ void m5267a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
            default:
                objArr[0] = Constants.FILE_ANR_KEY;
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = OptionsBridge.CAPTURE_KEY;
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    C2674b() {
    }

    public boolean assertEqualTypeConstructors(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        if (typeConstructor == null) {
            m5267a(3);
        }
        if (typeConstructor2 == null) {
            m5267a(4);
        }
        return typeConstructor.equals(typeConstructor2);
    }
}
