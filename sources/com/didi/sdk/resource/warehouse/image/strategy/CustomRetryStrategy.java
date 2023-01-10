package com.didi.sdk.resource.warehouse.image.strategy;

import com.didi.sdk.resource.warehouse.image.IRetryStrategy;
import java.util.ArrayList;
import java.util.List;

public class CustomRetryStrategy implements IRetryStrategy {

    /* renamed from: a */
    private final List<Integer> f39830a = new ArrayList();

    public CustomRetryStrategy(int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i : iArr) {
                if (i < 0) {
                    i = 0;
                }
                this.f39830a.add(Integer.valueOf(i));
            }
        }
    }

    public CustomRetryStrategy(List<Integer> list) {
        if (list != null && list.size() != 0) {
            for (Integer intValue : list) {
                int intValue2 = intValue.intValue();
                if (intValue2 < 0) {
                    intValue2 = 0;
                }
                this.f39830a.add(Integer.valueOf(intValue2));
            }
        }
    }

    public int interval(String str, int i, Throwable th) {
        if (i < 0 || i >= this.f39830a.size()) {
            return 0;
        }
        return this.f39830a.get(i).intValue();
    }

    public boolean isContinue(String str, int i, Throwable th) {
        return this.f39830a.size() >= i;
    }
}
