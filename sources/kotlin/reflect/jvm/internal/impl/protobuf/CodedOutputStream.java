package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class CodedOutputStream {

    /* renamed from: a */
    private final byte[] f5471a;

    /* renamed from: b */
    private final int f5472b;

    /* renamed from: c */
    private int f5473c;

    /* renamed from: d */
    private int f5474d = 0;

    /* renamed from: e */
    private final OutputStream f5475e;

    /* renamed from: a */
    static int m4970a(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    public static int computeRawVarint32Size(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int computeRawVarint64Size(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f5475e = outputStream;
        this.f5471a = bArr;
        this.f5473c = 0;
        this.f5472b = bArr.length;
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void writeDouble(int i, double d) throws IOException {
        writeTag(i, 1);
        writeDoubleNoTag(d);
    }

    public void writeFloat(int i, float f) throws IOException {
        writeTag(i, 5);
        writeFloatNoTag(f);
    }

    public void writeInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeInt32NoTag(i2);
    }

    public void writeBool(int i, boolean z) throws IOException {
        writeTag(i, 0);
        writeBoolNoTag(z);
    }

    public void writeGroup(int i, MessageLite messageLite) throws IOException {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    public void writeMessage(int i, MessageLite messageLite) throws IOException {
        writeTag(i, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeBytes(int i, ByteString byteString) throws IOException {
        writeTag(i, 2);
        writeBytesNoTag(byteString);
    }

    public void writeUInt32(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeUInt32NoTag(i2);
    }

    public void writeEnum(int i, int i2) throws IOException {
        writeTag(i, 0);
        writeEnumNoTag(i2);
    }

    public void writeSInt64(int i, long j) throws IOException {
        writeTag(i, 0);
        writeSInt64NoTag(j);
    }

    public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
        writeTag(1, 3);
        writeUInt32(2, i);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeDoubleNoTag(double d) throws IOException {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d));
    }

    public void writeFloatNoTag(float f) throws IOException {
        writeRawLittleEndian32(Float.floatToRawIntBits(f));
    }

    public void writeUInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    public void writeInt64NoTag(long j) throws IOException {
        writeRawVarint64(j);
    }

    public void writeInt32NoTag(int i) throws IOException {
        if (i >= 0) {
            writeRawVarint32(i);
        } else {
            writeRawVarint64((long) i);
        }
    }

    public void writeFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeFixed32NoTag(int i) throws IOException {
        writeRawLittleEndian32(i);
    }

    public void writeBoolNoTag(boolean z) throws IOException {
        writeRawByte(z ? 1 : 0);
    }

    public void writeStringNoTag(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public void writeMessageNoTag(MessageLite messageLite) throws IOException {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeBytesNoTag(ByteString byteString) throws IOException {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeUInt32NoTag(int i) throws IOException {
        writeRawVarint32(i);
    }

    public void writeEnumNoTag(int i) throws IOException {
        writeInt32NoTag(i);
    }

    public void writeSFixed32NoTag(int i) throws IOException {
        writeRawLittleEndian32(i);
    }

    public void writeSFixed64NoTag(long j) throws IOException {
        writeRawLittleEndian64(j);
    }

    public void writeSInt32NoTag(int i) throws IOException {
        writeRawVarint32(encodeZigZag32(i));
    }

    public void writeSInt64NoTag(long j) throws IOException {
        writeRawVarint64(encodeZigZag64(j));
    }

    public static int computeDoubleSize(int i, double d) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d);
    }

    public static int computeFloatSize(int i, float f) {
        return computeTagSize(i) + computeFloatSizeNoTag(f);
    }

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeTagSize(i) + computeBytesSizeNoTag(byteString);
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeEnumSizeNoTag(i2);
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeRawVarint64Size(j);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeRawVarint32Size(i);
        }
        return 10;
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        int serializedSize = lazyFieldLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeUInt32SizeNoTag(int i) {
        return computeRawVarint32Size(i);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeRawVarint32Size(encodeZigZag32(i));
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeRawVarint64Size(encodeZigZag64(j));
    }

    /* renamed from: a */
    private void m4971a() throws IOException {
        OutputStream outputStream = this.f5475e;
        if (outputStream != null) {
            outputStream.write(this.f5471a, 0, this.f5473c);
            this.f5473c = 0;
            return;
        }
        throw new OutOfSpaceException();
    }

    public void flush() throws IOException {
        if (this.f5475e != null) {
            m4971a();
        }
    }

    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public void writeRawByte(byte b) throws IOException {
        if (this.f5473c == this.f5472b) {
            m4971a();
        }
        byte[] bArr = this.f5471a;
        int i = this.f5473c;
        this.f5473c = i + 1;
        bArr[i] = b;
        this.f5474d++;
    }

    public void writeRawByte(int i) throws IOException {
        writeRawByte((byte) i);
    }

    public void writeRawBytes(ByteString byteString) throws IOException {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawBytes(byte[] bArr) throws IOException {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f5472b;
        int i4 = this.f5473c;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f5471a, i4, i2);
            this.f5473c += i2;
            this.f5474d += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f5471a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f5473c = this.f5472b;
        this.f5474d += i5;
        m4971a();
        if (i7 <= this.f5472b) {
            System.arraycopy(bArr, i6, this.f5471a, 0, i7);
            this.f5473c = i7;
        } else {
            this.f5475e.write(bArr, i6, i7);
        }
        this.f5474d += i7;
    }

    public void writeRawBytes(ByteString byteString, int i, int i2) throws IOException {
        int i3 = this.f5472b;
        int i4 = this.f5473c;
        if (i3 - i4 >= i2) {
            byteString.copyTo(this.f5471a, i, i4, i2);
            this.f5473c += i2;
            this.f5474d += i2;
            return;
        }
        int i5 = i3 - i4;
        byteString.copyTo(this.f5471a, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f5473c = this.f5472b;
        this.f5474d += i5;
        m4971a();
        if (i7 <= this.f5472b) {
            byteString.copyTo(this.f5471a, i6, 0, i7);
            this.f5473c = i7;
        } else {
            byteString.mo26146a(this.f5475e, i6, i7);
        }
        this.f5474d += i7;
    }

    public void writeTag(int i, int i2) throws IOException {
        writeRawVarint32(WireFormat.m5014a(i, i2));
    }

    public static int computeTagSize(int i) {
        return computeRawVarint32Size(WireFormat.m5014a(i, 0));
    }

    public void writeRawVarint32(int i) throws IOException {
        while ((i & -128) != 0) {
            writeRawByte((i & 127) | 128);
            i >>>= 7;
        }
        writeRawByte(i);
    }

    public void writeRawVarint64(long j) throws IOException {
        while ((-128 & j) != 0) {
            writeRawByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        writeRawByte((int) j);
    }

    public void writeRawLittleEndian32(int i) throws IOException {
        writeRawByte(i & 255);
        writeRawByte((i >> 8) & 255);
        writeRawByte((i >> 16) & 255);
        writeRawByte((i >> 24) & 255);
    }

    public void writeRawLittleEndian64(long j) throws IOException {
        writeRawByte(((int) j) & 255);
        writeRawByte(((int) (j >> 8)) & 255);
        writeRawByte(((int) (j >> 16)) & 255);
        writeRawByte(((int) (j >> 24)) & 255);
        writeRawByte(((int) (j >> 32)) & 255);
        writeRawByte(((int) (j >> 40)) & 255);
        writeRawByte(((int) (j >> 48)) & 255);
        writeRawByte(((int) (j >> 56)) & 255);
    }
}
