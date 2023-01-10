package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.apache.commons.p074io.IOUtils;

public class JvmClassName {

    /* renamed from: a */
    private final String f5598a;

    /* renamed from: b */
    private FqName f5599b;

    /* renamed from: a */
    private static /* synthetic */ void m5138a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 3 || i == 6 || i == 7 || i == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static JvmClassName byInternalName(String str) {
        if (str == null) {
            m5138a(0);
        }
        return new JvmClassName(str);
    }

    public static JvmClassName byClassId(ClassId classId) {
        if (classId == null) {
            m5138a(1);
        }
        FqName packageFqName = classId.getPackageFqName();
        String replace = classId.getRelativeClassName().asString().replace('.', '$');
        if (packageFqName.isRoot()) {
            return new JvmClassName(replace);
        }
        return new JvmClassName(packageFqName.asString().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + replace);
    }

    public static JvmClassName byFqNameWithoutInnerClasses(FqName fqName) {
        if (fqName == null) {
            m5138a(2);
        }
        JvmClassName jvmClassName = new JvmClassName(fqName.asString().replace('.', IOUtils.DIR_SEPARATOR_UNIX));
        jvmClassName.f5599b = fqName;
        return jvmClassName;
    }

    private JvmClassName(String str) {
        if (str == null) {
            m5138a(5);
        }
        this.f5598a = str;
    }

    public FqName getFqNameForTopLevelClassMaybeWithDollars() {
        return new FqName(this.f5598a.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
    }

    public FqName getPackageFqName() {
        int lastIndexOf = this.f5598a.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new FqName(this.f5598a.substring(0, lastIndexOf).replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
        }
        FqName fqName = FqName.ROOT;
        if (fqName == null) {
            m5138a(7);
        }
        return fqName;
    }

    public String getInternalName() {
        String str = this.f5598a;
        if (str == null) {
            m5138a(8);
        }
        return str;
    }

    public String toString() {
        return this.f5598a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5598a.equals(((JvmClassName) obj).f5598a);
    }

    public int hashCode() {
        return this.f5598a.hashCode();
    }
}
