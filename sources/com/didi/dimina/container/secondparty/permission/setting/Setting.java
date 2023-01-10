package com.didi.dimina.container.secondparty.permission.setting;

import android.os.Build;
import com.didi.dimina.container.secondparty.permission.setting.write.LWriteRequestFactory;
import com.didi.dimina.container.secondparty.permission.setting.write.MWriteRequestFactory;
import com.didi.dimina.container.secondparty.permission.setting.write.WriteRequest;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class Setting {

    /* renamed from: a */
    private static final SettingRequestFactory f19293a;

    /* renamed from: b */
    private final Source f19294b;

    public interface SettingRequestFactory {
        WriteRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f19293a = new MWriteRequestFactory();
        } else {
            f19293a = new LWriteRequestFactory();
        }
    }

    public Setting(Source source) {
        this.f19294b = source;
    }

    public WriteRequest write() {
        return f19293a.create(this.f19294b);
    }
}
