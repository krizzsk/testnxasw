package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.DataFetcher;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetPathFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public void cancel() {
    }

    /* access modifiers changed from: protected */
    public abstract void close(T t) throws IOException;

    /* access modifiers changed from: protected */
    public abstract T loadResource(AssetManager assetManager2, String str) throws IOException;

    public AssetPathFetcher(AssetManager assetManager2, String str) {
        this.assetManager = assetManager2;
        this.assetPath = str;
    }

    public void loadData(Priority priority, DataFetcher.DataCallback<? super T> dataCallback) {
        try {
            T loadResource = loadResource(this.assetManager, this.assetPath);
            this.data = loadResource;
            dataCallback.onDataReady(loadResource);
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 3)) {
                SystemUtils.log(3, TAG, "Failed to load data from asset manager", e, "com.bumptech.glide.load.data.AssetPathFetcher", 36);
            }
            dataCallback.onLoadFailed(e);
        }
    }

    public void cleanup() {
        T t = this.data;
        if (t != null) {
            try {
                close(t);
            } catch (IOException unused) {
            }
        }
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
