package kotlin.reflect.jvm.internal.impl.name;

import com.didi.beatles.p101im.access.utils.IMTextUtils;

public final class Name implements Comparable<Name> {

    /* renamed from: a */
    private final String f5448a;

    /* renamed from: b */
    private final boolean f5449b;

    /* renamed from: a */
    private static /* synthetic */ void m4955a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3)];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2 || i == 3 || i == 4) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    private Name(String str, boolean z) {
        if (str == null) {
            m4955a(0);
        }
        this.f5448a = str;
        this.f5449b = z;
    }

    public String asString() {
        String str = this.f5448a;
        if (str == null) {
            m4955a(1);
        }
        return str;
    }

    public String getIdentifier() {
        if (!this.f5449b) {
            String asString = asString();
            if (asString == null) {
                m4955a(2);
            }
            return asString;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public boolean isSpecial() {
        return this.f5449b;
    }

    public int compareTo(Name name) {
        return this.f5448a.compareTo(name.f5448a);
    }

    public static Name identifier(String str) {
        if (str == null) {
            m4955a(5);
        }
        return new Name(str, false);
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            m4955a(6);
        }
        if (str.isEmpty() || str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String str) {
        if (str == null) {
            m4955a(7);
        }
        if (str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            m4955a(8);
        }
        if (str.startsWith(IMTextUtils.STREET_IMAGE_TAG_START)) {
            return special(str);
        }
        return identifier(str);
    }

    public String toString() {
        return this.f5448a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        return this.f5449b == name.f5449b && this.f5448a.equals(name.f5448a);
    }

    public int hashCode() {
        return (this.f5448a.hashCode() * 31) + (this.f5449b ? 1 : 0);
    }
}
