package kotlin.reflect.jvm.internal.impl.name;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.apache.commons.p074io.IOUtils;

public final class ClassId {

    /* renamed from: a */
    static final /* synthetic */ boolean f5435a = (!ClassId.class.desiredAssertionStatus());

    /* renamed from: b */
    private final FqName f5436b;

    /* renamed from: c */
    private final FqName f5437c;

    /* renamed from: d */
    private final boolean f5438d;

    /* renamed from: a */
    private static /* synthetic */ void m4950a(int i) {
        String str = (i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? 2 : 3)];
        switch (i) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = TypedValues.Custom.S_STRING;
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        if (i == 5) {
            objArr[1] = "getPackageFqName";
        } else if (i == 6) {
            objArr[1] = "getRelativeClassName";
        } else if (i == 7) {
            objArr[1] = "getShortClassName";
        } else if (i == 9) {
            objArr[1] = "asSingleFqName";
        } else if (i == 13 || i == 14) {
            objArr[1] = "asString";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 5 || i == 6 || i == 7 || i == 9 || i == 13 || i == 14) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public static ClassId topLevel(FqName fqName) {
        if (fqName == null) {
            m4950a(0);
        }
        return new ClassId(fqName.parent(), fqName.shortName());
    }

    public ClassId(FqName fqName, FqName fqName2, boolean z) {
        if (fqName == null) {
            m4950a(1);
        }
        if (fqName2 == null) {
            m4950a(2);
        }
        this.f5436b = fqName;
        if (f5435a || !fqName2.isRoot()) {
            this.f5437c = fqName2;
            this.f5438d = z;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Class name must not be root: ");
        sb.append(fqName);
        sb.append(z ? " (local)" : "");
        throw new AssertionError(sb.toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ClassId(FqName fqName, Name name) {
        this(fqName, FqName.topLevel(name), false);
        if (fqName == null) {
            m4950a(3);
        }
        if (name == null) {
            m4950a(4);
        }
    }

    public FqName getPackageFqName() {
        FqName fqName = this.f5436b;
        if (fqName == null) {
            m4950a(5);
        }
        return fqName;
    }

    public FqName getRelativeClassName() {
        FqName fqName = this.f5437c;
        if (fqName == null) {
            m4950a(6);
        }
        return fqName;
    }

    public Name getShortClassName() {
        Name shortName = this.f5437c.shortName();
        if (shortName == null) {
            m4950a(7);
        }
        return shortName;
    }

    public boolean isLocal() {
        return this.f5438d;
    }

    public ClassId createNestedClassId(Name name) {
        if (name == null) {
            m4950a(8);
        }
        return new ClassId(getPackageFqName(), this.f5437c.child(name), this.f5438d);
    }

    public ClassId getOuterClassId() {
        FqName parent = this.f5437c.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(getPackageFqName(), parent, this.f5438d);
    }

    public boolean isNestedClass() {
        return !this.f5437c.parent().isRoot();
    }

    public FqName asSingleFqName() {
        if (this.f5436b.isRoot()) {
            FqName fqName = this.f5437c;
            if (fqName == null) {
                m4950a(9);
            }
            return fqName;
        }
        return new FqName(this.f5436b.asString() + "." + this.f5437c.asString());
    }

    public static ClassId fromString(String str) {
        if (str == null) {
            m4950a(11);
        }
        return fromString(str, false);
    }

    public static ClassId fromString(String str, boolean z) {
        String str2;
        if (str == null) {
            m4950a(12);
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            str2 = "";
        } else {
            String replace = str.substring(0, lastIndexOf).replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
            str = str.substring(lastIndexOf + 1);
            str2 = replace;
        }
        return new ClassId(new FqName(str2), new FqName(str), z);
    }

    public String asString() {
        if (this.f5436b.isRoot()) {
            String asString = this.f5437c.asString();
            if (asString == null) {
                m4950a(13);
            }
            return asString;
        }
        String str = this.f5436b.asString().replace('.', IOUtils.DIR_SEPARATOR_UNIX) + "/" + this.f5437c.asString();
        if (str == null) {
            m4950a(14);
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        if (!this.f5436b.equals(classId.f5436b) || !this.f5437c.equals(classId.f5437c) || this.f5438d != classId.f5438d) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((this.f5436b.hashCode() * 31) + this.f5437c.hashCode()) * 31) + Boolean.valueOf(this.f5438d).hashCode();
    }

    public String toString() {
        if (!this.f5436b.isRoot()) {
            return asString();
        }
        return "/" + asString();
    }
}
