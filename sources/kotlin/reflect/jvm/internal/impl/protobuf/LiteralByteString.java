package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

class LiteralByteString extends ByteString {

    /* renamed from: b */
    protected final byte[] f5488b;

    /* renamed from: c */
    private int f5489c = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo26138a() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getTreeDepth() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isBalanced() {
        return true;
    }

    LiteralByteString(byte[] bArr) {
        this.f5488b = bArr;
    }

    /* renamed from: a */
    public byte mo26137a(int i) {
        return this.f5488b[i];
    }

    public int size() {
        return this.f5488b.length;
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f5488b, i, bArr, i2, i3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo26147b(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.f5488b, mo26138a() + i, i2);
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.f5488b, mo26138a(), size(), str);
    }

    public boolean isValidUtf8() {
        int a = mo26138a();
        return C2616a.m5020a(this.f5488b, a, size() + a);
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int a = mo26138a() + i2;
        return C2616a.m5018a(i, this.f5488b, a, i3 + a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return mo26321a((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(String.valueOf(obj.getClass()));
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo26321a(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i + i2 <= literalByteString.size()) {
            byte[] bArr = this.f5488b;
            byte[] bArr2 = literalByteString.f5488b;
            int a = mo26138a() + i2;
            int a2 = mo26138a();
            int a3 = literalByteString.mo26138a() + i;
            while (a2 < a) {
                if (bArr[a2] != bArr2[a3]) {
                    return false;
                }
                a2++;
                a3++;
            }
            return true;
        } else {
            int size2 = literalByteString.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public int hashCode() {
        int i = this.f5489c;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f5489c = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int peekCachedHashCode() {
        return this.f5489c;
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i, int i2, int i3) {
        return m5000a(i, this.f5488b, mo26138a() + i2, i3);
    }

    /* renamed from: a */
    static int m5000a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.m4962a(this);
    }

    public ByteString.ByteIterator iterator() {
        return new LiteralByteIterator();
    }

    private class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        private LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        public boolean hasNext() {
            return this.position < this.limit;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.f5488b;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
