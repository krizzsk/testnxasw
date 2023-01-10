package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;

public class GifDrawableEncoder implements ResourceEncoder<GifDrawable> {
    private static final String TAG = "GifEncoder";

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.SOURCE;
    }

    public boolean encode(Resource<GifDrawable> resource, File file, Options options) {
        try {
            ByteBufferUtil.toFile(resource.get().getBuffer(), file);
            return true;
        } catch (IOException e) {
            IOException iOException = e;
            if (Log.isLoggable(TAG, 5)) {
                SystemUtils.log(5, TAG, "Failed to encode GIF drawable data", iOException, "com.bumptech.glide.load.resource.gif.GifDrawableEncoder", 36);
            }
            return false;
        }
    }
}