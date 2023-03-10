package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.memory.MemoryTrimType;

public class DummyBitmapPool implements BitmapPool {
    public void trim(MemoryTrimType memoryTrimType) {
    }

    public Bitmap get(int i) {
        return Bitmap.createBitmap(1, (int) Math.ceil(((double) i) / 2.0d), Bitmap.Config.RGB_565);
    }

    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
