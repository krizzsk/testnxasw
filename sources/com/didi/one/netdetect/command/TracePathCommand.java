package com.didi.one.netdetect.command;

import android.content.Context;
import android.text.TextUtils;

public class TracePathCommand extends Command {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f31894a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31895b;

    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "tracepath";
    }

    protected TracePathCommand(Context context) {
        super(context);
    }

    public String generateCommandStr() {
        if (!TextUtils.isEmpty(this.f31894a)) {
            StringBuilder sb = new StringBuilder(getCmdPath());
            if (this.f31895b > 0) {
                sb.append(" ");
                sb.append("-m");
                sb.append(this.f31895b);
            }
            sb.append(" ");
            sb.append(this.f31894a);
            return sb.toString();
        }
        throw new IllegalArgumentException("host must not be null");
    }

    public static class Builder {
        private String host;
        private int maxTTL;

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setMaxTTL(int i) {
            this.maxTTL = i;
            return this;
        }

        public TracePathCommand build(Context context) {
            TracePathCommand tracePathCommand = new TracePathCommand(context);
            String unused = tracePathCommand.f31894a = this.host;
            int unused2 = tracePathCommand.f31895b = this.maxTTL;
            return tracePathCommand;
        }
    }
}
