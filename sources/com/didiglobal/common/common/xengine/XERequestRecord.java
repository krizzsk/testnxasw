package com.didiglobal.common.common.xengine;

import java.util.HashMap;

public class XERequestRecord {

    /* renamed from: a */
    private static final XERequestRecord f52311a = new XERequestRecord();

    /* renamed from: b */
    private HashMap<String, Integer> f52312b = new HashMap<>();

    private XERequestRecord() {
    }

    public static XERequestRecord getInstance() {
        return f52311a;
    }

    public void countIncrease(String str) {
        int i = 1;
        if (this.f52312b.containsKey(str)) {
            i = 1 + this.f52312b.get(str).intValue();
        }
        this.f52312b.put(str, Integer.valueOf(i));
    }

    public boolean hasRecord(String str) {
        return this.f52312b.containsKey(str);
    }

    public int getRecordCount(String str) {
        if (this.f52312b.containsKey(str)) {
            return this.f52312b.get(str).intValue();
        }
        return 0;
    }

    public void clean() {
        this.f52312b.clear();
    }
}
