package com.didi.beatles.p101im.api.entity;

import java.io.Serializable;

/* renamed from: com.didi.beatles.im.api.entity.IMCreateSessionResponse */
public class IMCreateSessionResponse extends IMBaseResponse {
    public Body body;

    /* renamed from: com.didi.beatles.im.api.entity.IMCreateSessionResponse$Body */
    public static class Body implements Serializable {
        public long sid;
    }
}
