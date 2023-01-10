package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;

public final class FqName {
    public static final FqName ROOT = new FqName("");

    /* renamed from: a */
    private final FqNameUnsafe f5439a;

    /* renamed from: b */
    private transient FqName f5440b;

    /* renamed from: a */
    private static /* synthetic */ void m4951a(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    public FqName(String str) {
        if (str == null) {
            m4951a(1);
        }
        this.f5439a = new FqNameUnsafe(str, this);
    }

    public FqName(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe == null) {
            m4951a(2);
        }
        this.f5439a = fqNameUnsafe;
    }

    private FqName(FqNameUnsafe fqNameUnsafe, FqName fqName) {
        if (fqNameUnsafe == null) {
            m4951a(3);
        }
        this.f5439a = fqNameUnsafe;
        this.f5440b = fqName;
    }

    public String asString() {
        String asString = this.f5439a.asString();
        if (asString == null) {
            m4951a(4);
        }
        return asString;
    }

    public FqNameUnsafe toUnsafe() {
        FqNameUnsafe fqNameUnsafe = this.f5439a;
        if (fqNameUnsafe == null) {
            m4951a(5);
        }
        return fqNameUnsafe;
    }

    public boolean isRoot() {
        return this.f5439a.isRoot();
    }

    public FqName parent() {
        FqName fqName = this.f5440b;
        if (fqName != null) {
            if (fqName == null) {
                m4951a(6);
            }
            return fqName;
        } else if (!isRoot()) {
            FqName fqName2 = new FqName(this.f5439a.parent());
            this.f5440b = fqName2;
            if (fqName2 == null) {
                m4951a(7);
            }
            return fqName2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public FqName child(Name name) {
        if (name == null) {
            m4951a(8);
        }
        return new FqName(this.f5439a.child(name), this);
    }

    public Name shortName() {
        Name shortName = this.f5439a.shortName();
        if (shortName == null) {
            m4951a(9);
        }
        return shortName;
    }

    public Name shortNameOrSpecial() {
        Name shortNameOrSpecial = this.f5439a.shortNameOrSpecial();
        if (shortNameOrSpecial == null) {
            m4951a(10);
        }
        return shortNameOrSpecial;
    }

    public List<Name> pathSegments() {
        List<Name> pathSegments = this.f5439a.pathSegments();
        if (pathSegments == null) {
            m4951a(11);
        }
        return pathSegments;
    }

    public boolean startsWith(Name name) {
        if (name == null) {
            m4951a(12);
        }
        return this.f5439a.startsWith(name);
    }

    public static FqName topLevel(Name name) {
        if (name == null) {
            m4951a(13);
        }
        return new FqName(FqNameUnsafe.topLevel(name));
    }

    public String toString() {
        return this.f5439a.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqName) && this.f5439a.equals(((FqName) obj).f5439a);
    }

    public int hashCode() {
        return this.f5439a.hashCode();
    }
}
