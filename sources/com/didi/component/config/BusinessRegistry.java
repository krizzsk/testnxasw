package com.didi.component.config;

import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.component.core.util.CLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessRegistry {

    /* renamed from: a */
    private static BizConfArray f14418a = new BizConfArray();

    /* renamed from: b */
    private static BizConfArray f14419b = new BizConfArray();

    public static void registerLocalBusiness(Entry entry) {
        f14418a.put(entry);
    }

    /* renamed from: a */
    static void m11955a(Entry entry) {
        f14419b.put(entry);
    }

    /* renamed from: a */
    static void m11956a(List<Entry> list) {
        f14419b.putAll(list);
    }

    /* renamed from: a */
    static void m11954a() {
        f14419b.clear();
    }

    public static String sid2ParentSid(String str) {
        return m11953a(str).parentSid;
    }

    public static int sid2Bid(String str) {
        return m11953a(str).bid;
    }

    public static String bid2ParentSid(int i) {
        return m11952a(i).parentSid;
    }

    public static String bid2Sid(int i) {
        return m11952a(i).sid;
    }

    /* renamed from: a */
    private static Entry m11953a(String str) {
        Entry entry;
        if (f14418a.contains(str)) {
            entry = f14418a.get(str);
        } else {
            entry = f14419b.get(str);
        }
        return entry != null ? entry : Entry.NONE;
    }

    /* renamed from: a */
    private static Entry m11952a(int i) {
        Entry entry;
        if (f14418a.contains(i)) {
            entry = f14418a.get(i);
        } else {
            entry = f14419b.get(i);
        }
        return entry != null ? entry : Entry.NONE;
    }

    private static final class BizConfArray {
        private SparseArray<Entry> mBidMap = new SparseArray<>();
        private Map<String, Entry> mSidMap = new HashMap();

        BizConfArray() {
        }

        public synchronized void put(Entry entry) {
            CLog.m12098d("BusinessRegistry put: " + entry);
            if (entry != null) {
                if (!entry.isInvalid()) {
                    this.mSidMap.put(entry.sid, entry);
                    this.mBidMap.put(entry.bid, entry);
                    return;
                }
            }
            CLog.m12098d("BusinessRegistry put: return");
        }

        public synchronized void putAll(List<Entry> list) {
            if (list != null) {
                for (Entry put : list) {
                    put(put);
                }
            }
        }

        public synchronized void clear() {
            this.mSidMap.clear();
            this.mBidMap.clear();
        }

        public synchronized Entry get(String str) {
            return this.mSidMap.get(str);
        }

        public synchronized Entry get(int i) {
            return this.mBidMap.get(i);
        }

        public boolean contains(String str) {
            return this.mSidMap.containsKey(str);
        }

        public boolean contains(int i) {
            return this.mBidMap.indexOfKey(i) >= 0;
        }
    }

    public static final class Entry {
        public static final Entry NONE = new Entry(-1, "", "");
        public int bid;
        public String parentSid;
        public String sid;

        public Entry(int i, String str, String str2) {
            this.bid = i;
            this.sid = str;
            this.parentSid = str2;
        }

        public boolean isInvalid() {
            return TextUtils.isEmpty(this.sid) && this.bid < 0;
        }

        public String toString() {
            return "Entry{bid=" + this.bid + ", sid='" + this.sid + '\'' + ", parentSid='" + this.parentSid + '\'' + '}';
        }
    }
}
