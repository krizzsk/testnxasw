package com.didi.util;

import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didichuxing.foundation.spi.ServiceLoader;

public class DecodeConfigUtil {

    /* renamed from: a */
    private static DecodeConfig f47798a;
    public static int lum;

    public static DecodeConfig getConfig() {
        if (f47798a == null) {
            f47798a = (DecodeConfig) ServiceLoader.load(DecodeConfig.class).get();
        }
        return f47798a;
    }
}
