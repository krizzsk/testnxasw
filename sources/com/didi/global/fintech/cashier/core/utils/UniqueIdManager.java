package com.didi.global.fintech.cashier.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/core/utils/UniqueIdManager;", "", "()V", "genUniqueId", "", "cashier_core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: UniqueIdManager.kt */
public final class UniqueIdManager {
    public static final UniqueIdManager INSTANCE = new UniqueIdManager();

    private UniqueIdManager() {
    }

    public final String genUniqueId() {
        List plus = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(new CharRange('A', Matrix.MATRIX_TYPE_ZERO), new CharRange('a', 'z')), new CharRange('0', '9')), '_');
        Iterable intRange = new IntRange(1, 20);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf(((Character) CollectionsKt.random(plus, Random.Default)).charValue()));
        }
        return CollectionsKt.joinToString$default((List) arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
