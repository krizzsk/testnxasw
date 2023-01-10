package com.didi.dqr;

public final class Dimension {

    /* renamed from: a */
    private final int f20350a;

    /* renamed from: b */
    private final int f20351b;

    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.f20350a = i;
        this.f20351b = i2;
    }

    public int getWidth() {
        return this.f20350a;
    }

    public int getHeight() {
        return this.f20351b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (this.f20350a == dimension.f20350a && this.f20351b == dimension.f20351b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f20350a * 32713) + this.f20351b;
    }

    public String toString() {
        return this.f20350a + "x" + this.f20351b;
    }
}
