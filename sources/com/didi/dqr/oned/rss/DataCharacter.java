package com.didi.dqr.oned.rss;

import org.osgi.framework.VersionRange;

public class DataCharacter {

    /* renamed from: a */
    private final int f20657a;

    /* renamed from: b */
    private final int f20658b;

    public DataCharacter(int i, int i2) {
        this.f20657a = i;
        this.f20658b = i2;
    }

    public final int getValue() {
        return this.f20657a;
    }

    public final int getChecksumPortion() {
        return this.f20658b;
    }

    public final String toString() {
        return this.f20657a + "(" + this.f20658b + VersionRange.RIGHT_OPEN;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        if (this.f20657a == dataCharacter.f20657a && this.f20658b == dataCharacter.f20658b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f20657a ^ this.f20658b;
    }
}
