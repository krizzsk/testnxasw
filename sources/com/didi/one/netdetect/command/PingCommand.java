package com.didi.one.netdetect.command;

import android.content.Context;
import android.text.TextUtils;

public class PingCommand extends Command {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f31883a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f31884b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f31885c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f31886d;

    /* access modifiers changed from: protected */
    public String whichCmd() {
        return "ping";
    }

    protected PingCommand(Context context) {
        super(context);
    }

    public String generateCommandStr() {
        if (!TextUtils.isEmpty(this.f31883a)) {
            StringBuilder sb = new StringBuilder();
            sb.append(getCmdPath());
            if (this.f31884b > 0) {
                sb.append(" ");
                sb.append("-c ");
                sb.append(this.f31884b);
            }
            if (this.f31885c > 0) {
                sb.append(" ");
                sb.append("-s ");
                sb.append(this.f31885c);
            }
            if (this.f31886d > 0) {
                sb.append(" ");
                sb.append("-W ");
                sb.append(this.f31886d);
            }
            sb.append(" ");
            sb.append(this.f31883a);
            return sb.toString();
        }
        throw new IllegalArgumentException("host must not be null");
    }

    public static class Builder {
        private String host;
        private boolean isNative;
        private int packageSize;
        private int sendCount;
        private int timeout;

        public Builder setIsNative(boolean z) {
            this.isNative = z;
            return this;
        }

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setSendCount(int i) {
            this.sendCount = i;
            return this;
        }

        public Builder setPackageSize(int i) {
            this.packageSize = i;
            return this;
        }

        public Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public PingCommand build(Context context) {
            PingCommand pingCommand = new PingCommand(context);
            pingCommand.isNative = this.isNative;
            String unused = pingCommand.f31883a = this.host;
            int unused2 = pingCommand.f31884b = this.sendCount;
            int unused3 = pingCommand.f31885c = this.packageSize;
            int unused4 = pingCommand.f31886d = this.timeout;
            return pingCommand;
        }
    }
}
