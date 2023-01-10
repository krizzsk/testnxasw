package com.google.android.datatransport;

public final class Encoding {
    private final String name;

    /* renamed from: of */
    public static Encoding m40760of(String str) {
        return new Encoding(str);
    }

    public String getName() {
        return this.name;
    }

    private Encoding(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Encoding)) {
            return false;
        }
        return this.name.equals(((Encoding) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.name + "\"}";
    }
}
