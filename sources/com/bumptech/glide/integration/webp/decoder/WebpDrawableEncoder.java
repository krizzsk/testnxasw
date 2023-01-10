package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;

public class WebpDrawableEncoder implements ResourceEncoder<WebpDrawable> {
    private static final String TAG = "WebpEncoder";

    public EncodeStrategy getEncodeStrategy(Options options) {
        return EncodeStrategy.SOURCE;
    }

    public boolean encode(Resource<WebpDrawable> resource, File file, Options options) {
        try {
            ByteBufferUtil.toFile(resource.get().getBuffer(), file);
            return true;
        } catch (IOException e) {
            IOException iOException = e;
            if (Log.isLoggable(TAG, 5)) {
                SystemUtils.log(5, TAG, "Failed to encode WebP drawable data", iOException, "com.bumptech.glide.integration.webp.decoder.WebpDrawableEncoder", 37);
            }
            return false;
        }
    }
}
