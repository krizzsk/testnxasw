package com.yanzhenjie.permission.setting;

import android.os.Build;
import com.yanzhenjie.permission.setting.write.LWriteRequestFactory;
import com.yanzhenjie.permission.setting.write.MWriteRequestFactory;
import com.yanzhenjie.permission.setting.write.WriteRequest;
import com.yanzhenjie.permission.source.Source;

public class Setting {

    /* renamed from: a */
    private static final SettingRequestFactory f59014a;

    /* renamed from: b */
    private Source f59015b;

    public interface SettingRequestFactory {
        WriteRequest create(Source source);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            f59014a = new MWriteRequestFactory();
        } else {
            f59014a = new LWriteRequestFactory();
        }
    }

    public Setting(Source source) {
        this.f59015b = source;
    }

    public WriteRequest write() {
        return f59014a.create(this.f59015b);
    }
}
