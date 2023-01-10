package kshark;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kshark.GcRoot;
import kshark.Hprof;
import kshark.HprofRecord;
import kshark.ValueHolder;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u0019\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\u00020\u0010*\u00020\u0003H\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001dH\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001eH\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001fH\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020 H\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020!H\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\"\u001a\u00020\u0010*\u00020\u00032\u0006\u0010#\u001a\u00020$H\u0002J\u0014\u0010%\u001a\u00020\u0010*\u00020\u00032\u0006\u0010#\u001a\u00020&H\u0002J\u0014\u0010'\u001a\u00020\u0010*\u00020\u00032\u0006\u0010#\u001a\u00020(H\u0002J\u0014\u0010)\u001a\u00020\u0010*\u00020\u00032\u0006\u0010*\u001a\u00020+H\u0002J\u0014\u0010,\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u001a\u001a\u00020 H\u0002J-\u0010-\u001a\u00020\u0010*\u00020\u00032\u0006\u0010.\u001a\u00020\u00052\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001000¢\u0006\u0002\b1H\u0002J\u001c\u00102\u001a\u00020\u0010*\u00020\u00032\u0006\u0010.\u001a\u00020\u00052\u0006\u00103\u001a\u00020+H\u0002J\u0014\u00104\u001a\u00020\u0010*\u00020\u00032\u0006\u00105\u001a\u00020\u0015H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, mo148868d2 = {"Lkshark/HprofWriter;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "identifierByteSize", "", "hprofVersion", "Lkshark/Hprof$HprofVersion;", "(Lokio/BufferedSink;ILkshark/Hprof$HprofVersion;)V", "getHprofVersion", "()Lkshark/Hprof$HprofVersion;", "getIdentifierByteSize", "()I", "workBuffer", "Lokio/Buffer;", "close", "", "valuesToBytes", "", "values", "", "Lkshark/ValueHolder;", "write", "record", "Lkshark/HprofRecord;", "flushHeapBuffer", "array", "", "", "", "", "", "", "", "writeBoolean", "value", "", "writeDouble", "", "writeFloat", "", "writeId", "id", "", "writeIdArray", "writeNonHeapRecord", "tag", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "writeTagHeader", "length", "writeValue", "wrapper", "Companion", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: HprofWriter.kt */
public final class HprofWriter implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Buffer f6450a;

    /* renamed from: b */
    private final BufferedSink f6451b;

    /* renamed from: c */
    private final int f6452c;

    /* renamed from: d */
    private final Hprof.HprofVersion f6453d;

    private HprofWriter(BufferedSink bufferedSink, int i, Hprof.HprofVersion hprofVersion) {
        this.f6451b = bufferedSink;
        this.f6452c = i;
        this.f6453d = hprofVersion;
        this.f6450a = new Buffer();
    }

    public /* synthetic */ HprofWriter(BufferedSink bufferedSink, int i, Hprof.HprofVersion hprofVersion, DefaultConstructorMarker defaultConstructorMarker) {
        this(bufferedSink, i, hprofVersion);
    }

    public final int getIdentifierByteSize() {
        return this.f6452c;
    }

    public final Hprof.HprofVersion getHprofVersion() {
        return this.f6453d;
    }

    public final void write(HprofRecord hprofRecord) {
        Intrinsics.checkParameterIsNotNull(hprofRecord, SDKConsts.TAG_KEY_RECORD);
        m6343a(this.f6451b, hprofRecord);
    }

    public final byte[] valuesToBytes(List<? extends ValueHolder> list) {
        Intrinsics.checkParameterIsNotNull(list, "values");
        Buffer buffer = new Buffer();
        for (ValueHolder a : list) {
            m6344a((BufferedSink) buffer, a);
        }
        byte[] readByteArray = buffer.readByteArray();
        Intrinsics.checkExpressionValueIsNotNull(readByteArray, "valuesBuffer.readByteArray()");
        return readByteArray;
    }

    public void close() {
        m6337a(this.f6451b);
        this.f6451b.close();
    }

    /* renamed from: a */
    private final void m6344a(BufferedSink bufferedSink, ValueHolder valueHolder) {
        if (valueHolder instanceof ValueHolder.ReferenceHolder) {
            m6342a(bufferedSink, ((ValueHolder.ReferenceHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.BooleanHolder) {
            m6345a(bufferedSink, ((ValueHolder.BooleanHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.CharHolder) {
            m6346a(bufferedSink, new char[]{((ValueHolder.CharHolder) valueHolder).getValue()});
        } else if (valueHolder instanceof ValueHolder.FloatHolder) {
            m6339a(bufferedSink, ((ValueHolder.FloatHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.DoubleHolder) {
            m6338a(bufferedSink, ((ValueHolder.DoubleHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.ByteHolder) {
            bufferedSink.writeByte(((ValueHolder.ByteHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.ShortHolder) {
            bufferedSink.writeShort(((ValueHolder.ShortHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.IntHolder) {
            bufferedSink.writeInt(((ValueHolder.IntHolder) valueHolder).getValue());
        } else if (valueHolder instanceof ValueHolder.LongHolder) {
            bufferedSink.writeLong(((ValueHolder.LongHolder) valueHolder).getValue());
        }
    }

    /* renamed from: a */
    private final void m6343a(BufferedSink bufferedSink, HprofRecord hprofRecord) {
        if (hprofRecord instanceof HprofRecord.StringRecord) {
            m6341a(bufferedSink, 1, (Function1<? super BufferedSink, Unit>) new HprofWriter$write$1(this, hprofRecord));
        } else if (hprofRecord instanceof HprofRecord.LoadClassRecord) {
            m6341a(bufferedSink, 2, (Function1<? super BufferedSink, Unit>) new HprofWriter$write$2(this, hprofRecord));
        } else if (hprofRecord instanceof HprofRecord.StackTraceRecord) {
            m6341a(bufferedSink, 5, (Function1<? super BufferedSink, Unit>) new HprofWriter$write$3(this, hprofRecord));
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.GcRootRecord) {
            Buffer buffer = this.f6450a;
            GcRoot gcRoot = ((HprofRecord.HeapDumpRecord.GcRootRecord) hprofRecord).getGcRoot();
            if (gcRoot instanceof GcRoot.Unknown) {
                buffer.writeByte(255);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.JniGlobal) {
                buffer.writeByte(1);
                BufferedSink bufferedSink2 = buffer;
                m6342a(bufferedSink2, gcRoot.getId());
                m6342a(bufferedSink2, ((GcRoot.JniGlobal) gcRoot).getJniGlobalRefId());
            } else if (gcRoot instanceof GcRoot.JniLocal) {
                buffer.writeByte(2);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                GcRoot.JniLocal jniLocal = (GcRoot.JniLocal) gcRoot;
                buffer.writeInt(jniLocal.getThreadSerialNumber());
                buffer.writeInt(jniLocal.getFrameNumber());
            } else if (gcRoot instanceof GcRoot.JavaFrame) {
                buffer.writeByte(3);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                GcRoot.JavaFrame javaFrame = (GcRoot.JavaFrame) gcRoot;
                buffer.writeInt(javaFrame.getThreadSerialNumber());
                buffer.writeInt(javaFrame.getFrameNumber());
            } else if (gcRoot instanceof GcRoot.NativeStack) {
                buffer.writeByte(4);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                buffer.writeInt(((GcRoot.NativeStack) gcRoot).getThreadSerialNumber());
            } else if (gcRoot instanceof GcRoot.StickyClass) {
                buffer.writeByte(5);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.ThreadBlock) {
                buffer.writeByte(6);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                buffer.writeInt(((GcRoot.ThreadBlock) gcRoot).getThreadSerialNumber());
            } else if (gcRoot instanceof GcRoot.MonitorUsed) {
                buffer.writeByte(7);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.ThreadObject) {
                buffer.writeByte(8);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                GcRoot.ThreadObject threadObject = (GcRoot.ThreadObject) gcRoot;
                buffer.writeInt(threadObject.getThreadSerialNumber());
                buffer.writeInt(threadObject.getStackTraceSerialNumber());
            } else if (gcRoot instanceof GcRoot.ReferenceCleanup) {
                buffer.writeByte(140);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.VmInternal) {
                buffer.writeByte(141);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.JniMonitor) {
                buffer.writeByte(142);
                m6342a((BufferedSink) buffer, gcRoot.getId());
                GcRoot.JniMonitor jniMonitor = (GcRoot.JniMonitor) gcRoot;
                buffer.writeInt(jniMonitor.getStackTraceSerialNumber());
                buffer.writeInt(jniMonitor.getStackDepth());
            } else if (gcRoot instanceof GcRoot.InternedString) {
                buffer.writeByte(137);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Finalizing) {
                buffer.writeByte(138);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Debugger) {
                buffer.writeByte(139);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else if (gcRoot instanceof GcRoot.Unreachable) {
                buffer.writeByte(144);
                m6342a((BufferedSink) buffer, gcRoot.getId());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) {
            Buffer buffer2 = this.f6450a;
            buffer2.writeByte(32);
            BufferedSink bufferedSink3 = buffer2;
            HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord classDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord) hprofRecord;
            m6342a(bufferedSink3, classDumpRecord.getId());
            buffer2.writeInt(classDumpRecord.getStackTraceSerialNumber());
            m6342a(bufferedSink3, classDumpRecord.getSuperclassId());
            m6342a(bufferedSink3, classDumpRecord.getClassLoaderId());
            m6342a(bufferedSink3, classDumpRecord.getSignersId());
            m6342a(bufferedSink3, classDumpRecord.getProtectionDomainId());
            m6342a(bufferedSink3, 0);
            m6342a(bufferedSink3, 0);
            buffer2.writeInt(classDumpRecord.getInstanceSize());
            buffer2.writeShort(0);
            buffer2.writeShort(classDumpRecord.getStaticFields().size());
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord staticFieldRecord : classDumpRecord.getStaticFields()) {
                m6342a(bufferedSink3, staticFieldRecord.getNameStringId());
                buffer2.writeByte(staticFieldRecord.getType());
                m6344a(bufferedSink3, staticFieldRecord.getValue());
            }
            buffer2.writeShort(classDumpRecord.getFields().size());
            for (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord fieldRecord : classDumpRecord.getFields()) {
                m6342a(bufferedSink3, fieldRecord.getNameStringId());
                buffer2.writeByte(fieldRecord.getType());
            }
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) {
            Buffer buffer3 = this.f6450a;
            buffer3.writeByte(33);
            BufferedSink bufferedSink4 = buffer3;
            HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord instanceDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord) hprofRecord;
            m6342a(bufferedSink4, instanceDumpRecord.getId());
            buffer3.writeInt(instanceDumpRecord.getStackTraceSerialNumber());
            m6342a(bufferedSink4, instanceDumpRecord.getClassId());
            buffer3.writeInt(instanceDumpRecord.getFieldValues().length);
            buffer3.write(instanceDumpRecord.getFieldValues());
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) {
            Buffer buffer4 = this.f6450a;
            buffer4.writeByte(34);
            BufferedSink bufferedSink5 = buffer4;
            HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord objectArrayDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord) hprofRecord;
            m6342a(bufferedSink5, objectArrayDumpRecord.getId());
            buffer4.writeInt(objectArrayDumpRecord.getStackTraceSerialNumber());
            buffer4.writeInt(objectArrayDumpRecord.getElementIds().length);
            m6342a(bufferedSink5, objectArrayDumpRecord.getArrayClassId());
            m6350a(bufferedSink5, objectArrayDumpRecord.getElementIds());
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) {
            Buffer buffer5 = this.f6450a;
            buffer5.writeByte(35);
            BufferedSink bufferedSink6 = buffer5;
            HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord primitiveArrayDumpRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord) hprofRecord;
            m6342a(bufferedSink6, primitiveArrayDumpRecord.getId());
            buffer5.writeInt(primitiveArrayDumpRecord.getStackTraceSerialNumber());
            if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump booleanArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) hprofRecord;
                buffer5.writeInt(booleanArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.BOOLEAN.getHprofType());
                m6352a(bufferedSink6, booleanArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump charArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) hprofRecord;
                buffer5.writeInt(charArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.CHAR.getHprofType());
                m6346a(bufferedSink6, charArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump floatArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) hprofRecord;
                buffer5.writeInt(floatArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.FLOAT.getHprofType());
                m6348a(bufferedSink6, floatArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump doubleArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) hprofRecord;
                buffer5.writeInt(doubleArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.DOUBLE.getHprofType());
                m6347a(bufferedSink6, doubleArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump byteArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) hprofRecord;
                buffer5.writeInt(byteArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.BYTE.getHprofType());
                buffer5.write(byteArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump shortArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) hprofRecord;
                buffer5.writeInt(shortArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.SHORT.getHprofType());
                m6351a(bufferedSink6, shortArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump intArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) hprofRecord;
                buffer5.writeInt(intArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.INT.getHprofType());
                m6349a(bufferedSink6, intArrayDump.getArray());
            } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) {
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump longArrayDump = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) hprofRecord;
                buffer5.writeInt(longArrayDump.getArray().length);
                buffer5.writeByte(PrimitiveType.LONG.getHprofType());
                m6353b(bufferedSink6, longArrayDump.getArray());
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if (hprofRecord instanceof HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) {
            Buffer buffer6 = this.f6450a;
            buffer6.writeByte(254);
            HprofRecord.HeapDumpRecord.HeapDumpInfoRecord heapDumpInfoRecord = (HprofRecord.HeapDumpRecord.HeapDumpInfoRecord) hprofRecord;
            buffer6.writeInt(heapDumpInfoRecord.getHeapId());
            m6342a((BufferedSink) buffer6, heapDumpInfoRecord.getHeapNameStringId());
        } else if (hprofRecord instanceof HprofRecord.HeapDumpEndRecord) {
            throw new IllegalArgumentException("HprofWriter automatically emits HeapDumpEndRecord");
        }
    }

    /* renamed from: a */
    private final void m6338a(BufferedSink bufferedSink, double d) {
        bufferedSink.writeLong(Double.doubleToLongBits(d));
    }

    /* renamed from: a */
    private final void m6339a(BufferedSink bufferedSink, float f) {
        bufferedSink.writeInt(Float.floatToIntBits(f));
    }

    /* renamed from: a */
    private final void m6345a(BufferedSink bufferedSink, boolean z) {
        bufferedSink.writeByte(z ? 1 : 0);
    }

    /* renamed from: a */
    private final void m6346a(BufferedSink bufferedSink, char[] cArr) {
        bufferedSink.writeString(new String(cArr), Charsets.UTF_16BE);
    }

    /* renamed from: a */
    private final void m6341a(BufferedSink bufferedSink, int i, Function1<? super BufferedSink, Unit> function1) {
        m6337a(bufferedSink);
        function1.invoke(this.f6450a);
        m6340a(bufferedSink, i, this.f6450a.size());
        bufferedSink.writeAll(this.f6450a);
    }

    /* renamed from: a */
    private final void m6337a(BufferedSink bufferedSink) {
        if (this.f6450a.size() > 0) {
            m6340a(bufferedSink, 12, this.f6450a.size());
            bufferedSink.writeAll(this.f6450a);
            m6340a(bufferedSink, 44, 0);
        }
    }

    /* renamed from: a */
    private final void m6340a(BufferedSink bufferedSink, int i, long j) {
        bufferedSink.writeByte(i);
        bufferedSink.writeInt(0);
        bufferedSink.writeInt((int) j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m6342a(BufferedSink bufferedSink, long j) {
        int i = this.f6452c;
        if (i == 1) {
            bufferedSink.writeByte((int) j);
        } else if (i == 2) {
            bufferedSink.writeShort((int) j);
        } else if (i == 4) {
            bufferedSink.writeInt((int) j);
        } else if (i == 8) {
            bufferedSink.writeLong(j);
        } else {
            throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
        }
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo148868d2 = {"Lkshark/HprofWriter$Companion;", "", "()V", "open", "Lkshark/HprofWriter;", "hprofFile", "Ljava/io/File;", "identifierByteSize", "", "hprofVersion", "Lkshark/Hprof$HprofVersion;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: HprofWriter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ HprofWriter open$default(Companion companion, File file, int i, Hprof.HprofVersion hprofVersion, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 4;
            }
            if ((i2 & 4) != 0) {
                hprofVersion = Hprof.HprofVersion.ANDROID;
            }
            return companion.open(file, i, hprofVersion);
        }

        public final HprofWriter open(File file, int i, Hprof.HprofVersion hprofVersion) {
            Intrinsics.checkParameterIsNotNull(file, "hprofFile");
            Intrinsics.checkParameterIsNotNull(hprofVersion, "hprofVersion");
            BufferedSink buffer = Okio.buffer(Okio.sink((OutputStream) new FileOutputStream(file)));
            buffer.writeUtf8(hprofVersion.getVersionString());
            buffer.writeByte(0);
            buffer.writeInt(i);
            buffer.writeLong(System.currentTimeMillis());
            Intrinsics.checkExpressionValueIsNotNull(buffer, "sink");
            return new HprofWriter(buffer, i, hprofVersion, (DefaultConstructorMarker) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m6350a(BufferedSink bufferedSink, long[] jArr) {
        for (long a : jArr) {
            m6342a(bufferedSink, a);
        }
    }

    /* renamed from: a */
    private final void m6352a(BufferedSink bufferedSink, boolean[] zArr) {
        for (boolean z : zArr) {
            bufferedSink.writeByte(z ? 1 : 0);
        }
    }

    /* renamed from: a */
    private final void m6348a(BufferedSink bufferedSink, float[] fArr) {
        for (float a : fArr) {
            m6339a(bufferedSink, a);
        }
    }

    /* renamed from: a */
    private final void m6347a(BufferedSink bufferedSink, double[] dArr) {
        for (double a : dArr) {
            m6338a(bufferedSink, a);
        }
    }

    /* renamed from: a */
    private final void m6351a(BufferedSink bufferedSink, short[] sArr) {
        for (short writeShort : sArr) {
            bufferedSink.writeShort(writeShort);
        }
    }

    /* renamed from: a */
    private final void m6349a(BufferedSink bufferedSink, int[] iArr) {
        for (int writeInt : iArr) {
            bufferedSink.writeInt(writeInt);
        }
    }

    /* renamed from: b */
    private final void m6353b(BufferedSink bufferedSink, long[] jArr) {
        for (long writeLong : jArr) {
            bufferedSink.writeLong(writeLong);
        }
    }
}
