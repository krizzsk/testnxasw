package kotlin.system;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¨\u0006\u0004"}, mo148868d2 = {"exitProcess", "", "status", "", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: Process.kt */
public final class ProcessKt {
    /* renamed from: a */
    private static final Void m5364a(int i) {
        System.exit(i);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
