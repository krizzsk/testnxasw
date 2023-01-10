package kotlin.jvm.internal;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: PrimitiveSpreadBuilders.kt */
public final class ShortSpreadBuilder extends PrimitiveSpreadBuilder<short[]> {

    /* renamed from: a */
    private final short[] f4627a;

    public ShortSpreadBuilder(int i) {
        super(i);
        this.f4627a = new short[i];
    }

    /* access modifiers changed from: protected */
    public int getSize(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$this$getSize");
        return sArr.length;
    }

    public final void add(short s) {
        short[] sArr = this.f4627a;
        int position = getPosition();
        setPosition(position + 1);
        sArr[position] = s;
    }

    public final short[] toArray() {
        return (short[]) toArray(this.f4627a, new short[size()]);
    }
}
