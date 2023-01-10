package com.iproov.sdk.cameray;

import android.media.Image;
import com.iproov.sdk.cameray.C20772import;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.iproov.sdk.cameray.a */
/* compiled from: YUVImageImpl */
class C20750a implements C20772import {

    /* renamed from: a */
    private final Image f56844a;

    /* renamed from: b */
    private final Map<C20772import.C20773do, Image.Plane> f56845b = new HashMap();

    /* renamed from: c */
    private final Map<C20772import.C20773do, ByteBuffer> f56846c = new HashMap();

    public C20750a(Image image) {
        this.f56844a = image;
        for (C20772import.C20773do doVar : C20772import.C20773do.values()) {
            this.f56845b.put(doVar, image.getPlanes()[doVar.ordinal()]);
            this.f56846c.put(doVar, image.getPlanes()[doVar.ordinal()].getBuffer());
        }
    }

    /* renamed from: a */
    public int mo171287a() {
        return this.f56844a.getWidth();
    }

    /* renamed from: b */
    public int mo171290b() {
        return this.f56844a.getHeight();
    }

    /* renamed from: a */
    public int mo171288a(C20772import.C20773do doVar) {
        return this.f56845b.get(doVar).getPixelStride();
    }

    /* renamed from: a */
    public void mo171289a(C20772import.C20773do doVar, int i, byte[] bArr, int i2, int i3) {
        ByteBuffer byteBuffer = this.f56846c.get(doVar);
        byteBuffer.position(i);
        byteBuffer.get(bArr, i2, i3);
    }

    /* renamed from: a */
    public byte mo171286a(C20772import.C20773do doVar, int i) {
        return this.f56846c.get(doVar).get(i);
    }

    /* renamed from: b */
    public int mo171291b(C20772import.C20773do doVar) {
        return this.f56845b.get(doVar).getRowStride();
    }
}
