package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

class RopeByteString extends ByteString {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final int[] f5490b;

    /* renamed from: c */
    private final int f5491c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ByteString f5492d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ByteString f5493e;

    /* renamed from: f */
    private final int f5494f;

    /* renamed from: g */
    private final int f5495g;

    /* renamed from: h */
    private int f5496h;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        f5490b = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = f5490b;
            if (i4 < iArr.length) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
                i4++;
            } else {
                return;
            }
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.f5496h = 0;
        this.f5492d = byteString;
        this.f5493e = byteString2;
        int size = byteString.size();
        this.f5494f = size;
        this.f5491c = size + byteString2.size();
        this.f5495g = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    /* renamed from: a */
    static ByteString m5005a(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return m5010b(byteString, byteString2);
            }
            if (ropeByteString != null && ropeByteString.f5493e.size() + byteString2.size() < 128) {
                byteString2 = new RopeByteString(ropeByteString.f5492d, m5010b(ropeByteString.f5493e, byteString2));
            } else if (ropeByteString == null || ropeByteString.f5492d.getTreeDepth() <= ropeByteString.f5493e.getTreeDepth() || ropeByteString.getTreeDepth() <= byteString2.getTreeDepth()) {
                if (size >= f5490b[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1]) {
                    return new RopeByteString(byteString, byteString2);
                }
                return new Balancer().balance(byteString, byteString2);
            } else {
                byteString2 = new RopeByteString(ropeByteString.f5492d, new RopeByteString(ropeByteString.f5493e, byteString2));
            }
        }
        return byteString2;
    }

    /* renamed from: b */
    private static LiteralByteString m5010b(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[(size + size2)];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    public int size() {
        return this.f5491c;
    }

    /* access modifiers changed from: protected */
    public int getTreeDepth() {
        return this.f5495g;
    }

    /* access modifiers changed from: protected */
    public boolean isBalanced() {
        return this.f5491c >= f5490b[this.f5495g];
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.f5494f;
        if (i4 <= i5) {
            this.f5492d.copyToInternal(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.f5493e.copyToInternal(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.f5492d.copyToInternal(bArr, i, i2, i6);
            this.f5493e.copyToInternal(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo26147b(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.f5494f;
        if (i3 <= i4) {
            this.f5492d.mo26147b(outputStream, i, i2);
        } else if (i >= i4) {
            this.f5493e.mo26147b(outputStream, i - i4, i2);
        } else {
            int i5 = i4 - i;
            this.f5492d.mo26147b(outputStream, i, i5);
            this.f5493e.mo26147b(outputStream, 0, i2 - i5);
        }
    }

    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.f5492d.partialIsValidUtf8(0, 0, this.f5494f);
        ByteString byteString = this.f5493e;
        if (byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f5494f;
        if (i4 <= i5) {
            return this.f5492d.partialIsValidUtf8(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f5493e.partialIsValidUtf8(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f5493e.partialIsValidUtf8(this.f5492d.partialIsValidUtf8(i, i2, i6), 0, i3 - i6);
    }

    public boolean equals(Object obj) {
        int peekCachedHashCode;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.f5491c != byteString.size()) {
            return false;
        }
        if (this.f5491c == 0) {
            return true;
        }
        if (this.f5496h == 0 || (peekCachedHashCode = byteString.peekCachedHashCode()) == 0 || this.f5496h == peekCachedHashCode) {
            return m5007a(byteString);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m5007a(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        LiteralByteString literalByteString = (LiteralByteString) pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString literalByteString2 = (LiteralByteString) pieceIterator2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = literalByteString.size() - i;
            int size2 = literalByteString2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? literalByteString.mo26321a(literalByteString2, i2, min) : literalByteString2.mo26321a(literalByteString, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.f5491c;
            if (i3 < i4) {
                if (min == size) {
                    literalByteString = (LiteralByteString) pieceIterator.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    literalByteString2 = (LiteralByteString) pieceIterator2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public int hashCode() {
        int i = this.f5496h;
        if (i == 0) {
            int i2 = this.f5491c;
            i = partialHash(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.f5496h = i;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int peekCachedHashCode() {
        return this.f5496h;
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.f5494f;
        if (i4 <= i5) {
            return this.f5492d.partialHash(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f5493e.partialHash(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f5493e.partialHash(this.f5492d.partialHash(i, i2, i6), 0, i3 - i6);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(new RopeInputStream());
    }

    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack<>();
        }

        /* access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
            } else if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.f5492d);
                doBalance(ropeByteString.f5493e);
            } else {
                String valueOf = String.valueOf(String.valueOf(byteString.getClass()));
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int i = RopeByteString.f5490b[depthBinForLength + 1];
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i) {
                this.prefixesStack.push(byteString);
                return;
            }
            int i2 = RopeByteString.f5490b[depthBinForLength];
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty() && this.prefixesStack.peek().size() < i2) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= RopeByteString.f5490b[getDepthBinForLength(ropeByteString.size()) + 1]) {
                    break;
                }
                ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
            }
            this.prefixesStack.push(ropeByteString);
        }

        private int getDepthBinForLength(int i) {
            int binarySearch = Arrays.binarySearch(RopeByteString.f5490b, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }
    }

    private static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private PieceIterator(ByteString byteString) {
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.f5492d;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            while (!this.breadCrumbs.isEmpty()) {
                LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().f5493e);
                if (!leafByLeft.isEmpty()) {
                    return leafByLeft;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public LiteralByteString next() {
            LiteralByteString literalByteString = this.next;
            if (literalByteString != null) {
                this.next = getNextNonEmptyLeaf();
                return literalByteString;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public ByteString.ByteIterator iterator() {
        return new RopeByteIterator();
    }

    private class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;

        private RopeByteIterator() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.bytesRemaining = RopeByteString.this.size();
        }

        public boolean hasNext() {
            return this.bytesRemaining > 0;
        }

        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class RopeInputStream extends InputStream {
        private LiteralByteString currentPiece;
        private int currentPieceIndex;
        private int currentPieceOffsetInRope;
        private int currentPieceSize;
        private int mark;
        private PieceIterator pieceIterator;

        public boolean markSupported() {
            return true;
        }

        public RopeInputStream() {
            initialize();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw null;
            } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return readSkipInternal(bArr, i, i2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public long skip(long j) {
            if (j >= 0) {
                if (j > 2147483647L) {
                    j = 2147483647L;
                }
                return (long) readSkipInternal((byte[]) null, 0, (int) j);
            }
            throw new IndexOutOfBoundsException();
        }

        private int readSkipInternal(byte[] bArr, int i, int i2) {
            int i3 = i2;
            while (true) {
                if (i3 <= 0) {
                    break;
                }
                advanceIfCurrentPieceFullyRead();
                if (this.currentPiece != null) {
                    int min = Math.min(this.currentPieceSize - this.currentPieceIndex, i3);
                    if (bArr != null) {
                        this.currentPiece.copyTo(bArr, this.currentPieceIndex, i, min);
                        i += min;
                    }
                    this.currentPieceIndex += min;
                    i3 -= min;
                } else if (i3 == i2) {
                    return -1;
                }
            }
            return i2 - i3;
        }

        public int read() throws IOException {
            advanceIfCurrentPieceFullyRead();
            LiteralByteString literalByteString = this.currentPiece;
            if (literalByteString == null) {
                return -1;
            }
            int i = this.currentPieceIndex;
            this.currentPieceIndex = i + 1;
            return literalByteString.mo26137a(i) & 255;
        }

        public int available() throws IOException {
            return RopeByteString.this.size() - (this.currentPieceOffsetInRope + this.currentPieceIndex);
        }

        public void mark(int i) {
            this.mark = this.currentPieceOffsetInRope + this.currentPieceIndex;
        }

        public synchronized void reset() {
            initialize();
            readSkipInternal((byte[]) null, 0, this.mark);
        }

        private void initialize() {
            PieceIterator pieceIterator2 = new PieceIterator(RopeByteString.this);
            this.pieceIterator = pieceIterator2;
            LiteralByteString next = pieceIterator2.next();
            this.currentPiece = next;
            this.currentPieceSize = next.size();
            this.currentPieceIndex = 0;
            this.currentPieceOffsetInRope = 0;
        }

        private void advanceIfCurrentPieceFullyRead() {
            int i;
            if (this.currentPiece != null && this.currentPieceIndex == (i = this.currentPieceSize)) {
                this.currentPieceOffsetInRope += i;
                this.currentPieceIndex = 0;
                if (this.pieceIterator.hasNext()) {
                    LiteralByteString next = this.pieceIterator.next();
                    this.currentPiece = next;
                    this.currentPieceSize = next.size();
                    return;
                }
                this.currentPiece = null;
                this.currentPieceSize = 0;
            }
        }
    }
}
