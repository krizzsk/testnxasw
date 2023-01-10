package com.didi.one.netdetect.command;

import android.content.Context;
import android.text.TextUtils;

public class TraceRouteCommand extends Command {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f31897a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31898b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f31899c;

    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "traceroute";
    }

    protected TraceRouteCommand(Context context) {
        super(context);
    }

    public String generateCommandStr() {
        if (!TextUtils.isEmpty(this.f31897a)) {
            StringBuilder sb = new StringBuilder(getCmdPath());
            if (this.f31899c > 0) {
                sb.append(" ");
                sb.append("-m");
                sb.append(this.f31899c);
            }
            if (this.f31898b > 0) {
                sb.append(" ");
                sb.append("-w");
                sb.append(this.f31898b);
            }
            sb.append(" ");
            sb.append(this.f31897a);
            return sb.toString();
        }
        throw new IllegalArgumentException("host must not be null");
    }

    public static class Builder {
        private String host;
        private int maxTTL;
        private int waitTime;

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setMaxTTL(int i) {
            this.maxTTL = i;
            return this;
        }

        public Builder setWaitTime(int i) {
            this.waitTime = i;
            return this;
        }

        public TraceRouteCommand build(Context context) {
            TraceRouteCommand traceRouteCommand = new TraceRouteCommand(context);
            int unused = traceRouteCommand.f31898b = this.waitTime;
            String unused2 = traceRouteCommand.f31897a = this.host;
            int unused3 = traceRouteCommand.f31899c = this.maxTTL;
            return traceRouteCommand;
        }
    }
}
