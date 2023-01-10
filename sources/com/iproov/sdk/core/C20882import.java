package com.iproov.sdk.core;

import com.iproov.sdk.cameray.C20760do;
import com.iproov.sdk.cameray.C20767if;
import com.iproov.sdk.cameray.C20775throw;
import com.iproov.sdk.cameray.C20779while;
import com.iproov.sdk.core.C20873if;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import p243import.C22010if;

/* renamed from: com.iproov.sdk.core.import */
/* compiled from: PatchLocation */
public enum C20882import {
    AND1(1000, C20779while.class.getName(), C20775throw.class.getName()),
    AND2(1000, C20767if.C20769for.class.getName(), C20760do.class.getName()),
    AND3(1000, C20767if.C20771new.class.getName(), C20760do.class.getName()),
    AND4(1000, OpenGLRenderer.class.getName()),
    AND5(1000, C20873if.C20878goto.class.getName()),
    AND6(1000, C22010if.class.getName()),
    AND7(1000, C22010if.class.getName()),
    AND8(1000, C22010if.class.getName()),
    AND9(0, C20782break.class.getName()),
    AND10(0, C20782break.class.getName()),
    AND11(0, C20782break.class.getName()),
    AND12(0, C20782break.class.getName()),
    AND13(0, C20782break.class.getName()),
    AND14(0, C20767if.C20771new.class.getName(), C20760do.class.getName());
    

    /* renamed from: do */
    public final Set<String> f57167do;

    /* renamed from: if */
    public final long f57168if;

    private C20882import(long j, String... strArr) {
        this.f57167do = new HashSet(Arrays.asList(strArr));
        this.f57168if = j;
    }
}
