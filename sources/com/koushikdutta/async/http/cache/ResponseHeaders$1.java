package com.koushikdutta.async.http.cache;

import com.koushikdutta.async.http.cache.HeaderParser;

class ResponseHeaders$1 implements HeaderParser.CacheControlHandler {
    final /* synthetic */ C21203d this$0;

    ResponseHeaders$1(C21203d dVar) {
        this.this$0 = dVar;
    }

    public void handle(String str, String str2) {
        if (str.equalsIgnoreCase("no-cache")) {
            boolean unused = this.this$0.f58226j = true;
        } else if (str.equalsIgnoreCase("no-store")) {
            boolean unused2 = this.this$0.f58227k = true;
        } else if (str.equalsIgnoreCase("max-age")) {
            int unused3 = this.this$0.f58228l = HeaderParser.m44068a(str2);
        } else if (str.equalsIgnoreCase("s-maxage")) {
            int unused4 = this.this$0.f58229m = HeaderParser.m44068a(str2);
        } else if (str.equalsIgnoreCase("public")) {
            boolean unused5 = this.this$0.f58230n = true;
        } else if (str.equalsIgnoreCase("must-revalidate")) {
            boolean unused6 = this.this$0.f58231o = true;
        }
    }
}
