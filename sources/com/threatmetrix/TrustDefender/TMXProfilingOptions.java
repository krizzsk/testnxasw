package com.threatmetrix.TrustDefender;

import android.location.Location;
import com.threatmetrix.TrustDefender.jkjjkj;
import com.threatmetrix.TrustDefender.tqttqq;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TMXProfilingOptions {
    @Nullable
    private jkjjkj.GenericLocation b006400640064d0064d;
    private String b0064d0064d0064d;
    private List<String> bd00640064d0064d;

    public jkjjkj.GenericLocation b00730073s0073s0073s() {
        return this.b006400640064d0064d;
    }

    public List<String> bs0073s0073s0073s() {
        return this.bd00640064d0064d;
    }

    public String bss00730073s0073s() {
        return this.b0064d0064d0064d;
    }

    @Nonnull
    public TMXProfilingOptions setCustomAttributes(List<String> list) {
        this.bd00640064d0064d = list;
        return this;
    }

    @Nonnull
    public TMXProfilingOptions setLocation(Location location) {
        if (tqttqq.tttqtq.b00760076v0076vv()) {
            this.b006400640064d0064d = yyqyyy.bq0071q0071qq(location, true);
        }
        return this;
    }

    @Nonnull
    public TMXProfilingOptions setSessionID(String str) {
        this.b0064d0064d0064d = str;
        return this;
    }
}
