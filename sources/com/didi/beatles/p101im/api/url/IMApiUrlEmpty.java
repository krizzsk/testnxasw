package com.didi.beatles.p101im.api.url;

import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.api.url.IMApiUrlEmpty */
public class IMApiUrlEmpty extends IMBaseUrl {

    /* renamed from: a */
    private static final String f10968a = "IMApiUrlEmpty";

    public IMApiUrlEmpty() {
        IMLog.m10021e(f10968a, " api url use empty , please set it !!!");
    }

    public String getCommonHost(int i) {
        IMLog.m10021e(f10968a, " api url use empty , please set it !!!");
        return "";
    }

    public String getProfileHost() {
        IMLog.m10021e(f10968a, " api url use empty , please set it !!!");
        return "";
    }
}
