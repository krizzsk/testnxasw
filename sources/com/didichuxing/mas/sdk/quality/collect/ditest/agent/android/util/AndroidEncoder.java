package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.util;

import android.util.Base64;

public class AndroidEncoder implements Encoder {
    public String encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }
}
