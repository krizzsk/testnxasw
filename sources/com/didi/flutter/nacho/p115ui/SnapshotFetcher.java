package com.didi.flutter.nacho.p115ui;

import android.app.Activity;
import android.graphics.Bitmap;

/* renamed from: com.didi.flutter.nacho.ui.SnapshotFetcher */
public class SnapshotFetcher {

    /* renamed from: a */
    private static final SnapshotFetcher f22972a = new SnapshotFetcher();

    /* renamed from: b */
    private MapSnapshotFetcher f22973b;

    /* renamed from: com.didi.flutter.nacho.ui.SnapshotFetcher$MapSnapshotFetcher */
    public interface MapSnapshotFetcher {
        Bitmap getMapSnapshot(Activity activity);
    }

    public void setMapSnapshotFetcher(MapSnapshotFetcher mapSnapshotFetcher) {
        this.f22973b = mapSnapshotFetcher;
    }

    public static SnapshotFetcher getInstance() {
        return f22972a;
    }

    public Bitmap getMapSnapshot(Activity activity) {
        MapSnapshotFetcher mapSnapshotFetcher = this.f22973b;
        if (mapSnapshotFetcher == null) {
            return null;
        }
        return mapSnapshotFetcher.getMapSnapshot(activity);
    }
}
