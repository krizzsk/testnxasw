package org.apache.commons.lang3.builder;

final class IDKey {

    /* renamed from: id */
    private final int f7477id;
    private final Object value;

    IDKey(Object obj) {
        this.f7477id = System.identityHashCode(obj);
        this.value = obj;
    }

    public int hashCode() {
        return this.f7477id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.f7477id == iDKey.f7477id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }
}
