package com.didi.payment.transfer.utils;

import com.didi.sdk.util.collection.CollectionUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TransStore {

    /* renamed from: a */
    private static TransStore f34035a = new TransStore();

    /* renamed from: b */
    private Map<Integer, String> f34036b = new ConcurrentHashMap();

    private TransStore() {
    }

    public static TransStore getInstance() {
        return f34035a;
    }

    public void addBankItem(int i, String str) {
        this.f34036b.put(Integer.valueOf(i), str);
    }

    public String getBankName(int i) {
        return this.f34036b.containsKey(Integer.valueOf(i)) ? this.f34036b.get(Integer.valueOf(i)) : "";
    }

    public int getBankCount() {
        return this.f34036b.size();
    }

    public boolean isBankDataPrepared() {
        return !CollectionUtil.isEmpty((Map<?, ?>) this.f34036b);
    }
}
