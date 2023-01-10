package com.didichuxing.xpanel.xcard.loader;

import java.util.LinkedHashMap;
import java.util.Map;

public class XMLCache {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f52203a;

    /* renamed from: b */
    private LinkedHashMap<String, XMLCacheEntity> f52204b;

    private XMLCache() {
        this.f52203a = 40;
        this.f52204b = new LinkedHashMap<String, XMLCacheEntity>(this.f52203a) {
            /* access modifiers changed from: protected */
            public boolean removeEldestEntry(Map.Entry<String, XMLCacheEntity> entry) {
                return size() > XMLCache.this.f52203a;
            }
        };
    }

    private static class SingleTon {
        /* access modifiers changed from: private */
        public static XMLCache sInstance = new XMLCache();

        private SingleTon() {
        }
    }

    public static XMLCache getInstance() {
        return SingleTon.sInstance;
    }

    public LinkedHashMap<String, XMLCacheEntity> getXMLCache() {
        return this.f52204b;
    }

    public void putXMLCache(String str, XMLCacheEntity xMLCacheEntity) {
        this.f52204b.put(str, xMLCacheEntity);
    }
}
