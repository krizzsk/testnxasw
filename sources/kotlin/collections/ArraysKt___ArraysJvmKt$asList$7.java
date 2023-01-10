package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, mo148868d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "element", "get", "index", "(I)Ljava/lang/Boolean;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: _ArraysJvm.kt */
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {
    final /* synthetic */ boolean[] $this_asList;

    ArraysKt___ArraysJvmKt$asList$7(boolean[] zArr) {
        this.$this_asList = zArr;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            return contains(((Boolean) obj).booleanValue());
        }
        return false;
    }

    public final int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            return indexOf(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    public final int lastIndexOf(Object obj) {
        if (obj instanceof Boolean) {
            return lastIndexOf(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    public boolean contains(boolean z) {
        return ArraysKt.contains(this.$this_asList, z);
    }

    public Boolean get(int i) {
        return Boolean.valueOf(this.$this_asList[i]);
    }

    public int indexOf(boolean z) {
        return ArraysKt.indexOf(this.$this_asList, z);
    }

    public int lastIndexOf(boolean z) {
        return ArraysKt.lastIndexOf(this.$this_asList, z);
    }
}
