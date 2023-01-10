package kotlin.reflect.jvm.internal.impl.name;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

public final class FqNameUnsafe {

    /* renamed from: a */
    private static final Name f5441a = Name.special("<root>");

    /* renamed from: b */
    private static final Pattern f5442b = Pattern.compile("\\.");

    /* renamed from: c */
    private static final Function1<String, Name> f5443c = new Function1<String, Name>() {
        public Name invoke(String str) {
            return Name.guessByFirstCharacter(str);
        }
    };

    /* renamed from: d */
    private final String f5444d;

    /* renamed from: e */
    private transient FqName f5445e;

    /* renamed from: f */
    private transient FqNameUnsafe f5446f;

    /* renamed from: g */
    private transient Name f5447g;

    /* renamed from: a */
    private static /* synthetic */ void m4953a(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
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
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    FqNameUnsafe(String str, FqName fqName) {
        if (str == null) {
            m4953a(0);
        }
        if (fqName == null) {
            m4953a(1);
        }
        this.f5444d = str;
        this.f5445e = fqName;
    }

    public FqNameUnsafe(String str) {
        if (str == null) {
            m4953a(2);
        }
        this.f5444d = str;
    }

    private FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        if (str == null) {
            m4953a(3);
        }
        this.f5444d = str;
        this.f5446f = fqNameUnsafe;
        this.f5447g = name;
    }

    /* renamed from: a */
    private void m4952a() {
        int lastIndexOf = this.f5444d.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.f5447g = Name.guessByFirstCharacter(this.f5444d.substring(lastIndexOf + 1));
            this.f5446f = new FqNameUnsafe(this.f5444d.substring(0, lastIndexOf));
            return;
        }
        this.f5447g = Name.guessByFirstCharacter(this.f5444d);
        this.f5446f = FqName.ROOT.toUnsafe();
    }

    public String asString() {
        String str = this.f5444d;
        if (str == null) {
            m4953a(4);
        }
        return str;
    }

    public boolean isSafe() {
        return this.f5445e != null || asString().indexOf(60) < 0;
    }

    public FqName toSafe() {
        FqName fqName = this.f5445e;
        if (fqName != null) {
            if (fqName == null) {
                m4953a(5);
            }
            return fqName;
        }
        FqName fqName2 = new FqName(this);
        this.f5445e = fqName2;
        if (fqName2 == null) {
            m4953a(6);
        }
        return fqName2;
    }

    public boolean isRoot() {
        return this.f5444d.isEmpty();
    }

    public FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.f5446f;
        if (fqNameUnsafe != null) {
            if (fqNameUnsafe == null) {
                m4953a(7);
            }
            return fqNameUnsafe;
        } else if (!isRoot()) {
            m4952a();
            FqNameUnsafe fqNameUnsafe2 = this.f5446f;
            if (fqNameUnsafe2 == null) {
                m4953a(8);
            }
            return fqNameUnsafe2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public FqNameUnsafe child(Name name) {
        String str;
        if (name == null) {
            m4953a(9);
        }
        if (isRoot()) {
            str = name.asString();
        } else {
            str = this.f5444d + "." + name.asString();
        }
        return new FqNameUnsafe(str, this, name);
    }

    public Name shortName() {
        Name name = this.f5447g;
        if (name != null) {
            if (name == null) {
                m4953a(10);
            }
            return name;
        } else if (!isRoot()) {
            m4952a();
            Name name2 = this.f5447g;
            if (name2 == null) {
                m4953a(11);
            }
            return name2;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public Name shortNameOrSpecial() {
        if (isRoot()) {
            Name name = f5441a;
            if (name == null) {
                m4953a(12);
            }
            return name;
        }
        Name shortName = shortName();
        if (shortName == null) {
            m4953a(13);
        }
        return shortName;
    }

    public List<Name> pathSegments() {
        List<Name> emptyList = isRoot() ? Collections.emptyList() : ArraysKt.map((T[]) f5442b.split(this.f5444d), f5443c);
        if (emptyList == null) {
            m4953a(14);
        }
        return emptyList;
    }

    public boolean startsWith(Name name) {
        if (name == null) {
            m4953a(15);
        }
        if (isRoot()) {
            return false;
        }
        int indexOf = this.f5444d.indexOf(46);
        String str = this.f5444d;
        String asString = name.asString();
        if (indexOf == -1) {
            indexOf = this.f5444d.length();
        }
        return str.regionMatches(0, asString, 0, indexOf);
    }

    public static FqNameUnsafe topLevel(Name name) {
        if (name == null) {
            m4953a(16);
        }
        return new FqNameUnsafe(name.asString(), FqName.ROOT.toUnsafe(), name);
    }

    public String toString() {
        String asString = isRoot() ? f5441a.asString() : this.f5444d;
        if (asString == null) {
            m4953a(17);
        }
        return asString;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && this.f5444d.equals(((FqNameUnsafe) obj).f5444d);
    }

    public int hashCode() {
        return this.f5444d.hashCode();
    }
}
