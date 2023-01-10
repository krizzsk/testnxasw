package kotlin.p066io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\b\u001a\t\u0010\r\u001a\u00020\u0001H\b\u001a\u0013\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\b\u001a\u0011\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\b\u001a\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, mo148868d2 = {"print", "", "message", "", "", "", "", "", "", "", "", "", "", "println", "readLine", "", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.io.ConsoleKt */
/* compiled from: Console.kt */
public final class ConsoleKt {
    /* renamed from: a */
    private static final void m4343a(Object obj) {
        System.out.print(obj);
    }

    /* renamed from: a */
    private static final void m4341a(int i) {
        System.out.print(i);
    }

    /* renamed from: a */
    private static final void m4342a(long j) {
        System.out.print(j);
    }

    /* renamed from: a */
    private static final void m4337a(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    /* renamed from: a */
    private static final void m4344a(short s) {
        System.out.print(Short.valueOf(s));
    }

    /* renamed from: a */
    private static final void m4338a(char c) {
        System.out.print(c);
    }

    /* renamed from: a */
    private static final void m4345a(boolean z) {
        System.out.print(z);
    }

    /* renamed from: a */
    private static final void m4340a(float f) {
        System.out.print(f);
    }

    /* renamed from: a */
    private static final void m4339a(double d) {
        System.out.print(d);
    }

    /* renamed from: a */
    private static final void m4346a(char[] cArr) {
        System.out.print(cArr);
    }

    /* renamed from: b */
    private static final void m4353b(Object obj) {
        System.out.println(obj);
    }

    /* renamed from: b */
    private static final void m4351b(int i) {
        System.out.println(i);
    }

    /* renamed from: b */
    private static final void m4352b(long j) {
        System.out.println(j);
    }

    /* renamed from: b */
    private static final void m4347b(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    /* renamed from: b */
    private static final void m4354b(short s) {
        System.out.println(Short.valueOf(s));
    }

    /* renamed from: b */
    private static final void m4348b(char c) {
        System.out.println(c);
    }

    /* renamed from: b */
    private static final void m4355b(boolean z) {
        System.out.println(z);
    }

    /* renamed from: b */
    private static final void m4350b(float f) {
        System.out.println(f);
    }

    /* renamed from: b */
    private static final void m4349b(double d) {
        System.out.println(d);
    }

    /* renamed from: b */
    private static final void m4356b(char[] cArr) {
        System.out.println(cArr);
    }

    /* renamed from: a */
    private static final void m4336a() {
        System.out.println();
    }

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "System.`in`");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "Charset.defaultCharset()");
        return lineReader.readLine(inputStream, defaultCharset);
    }
}
