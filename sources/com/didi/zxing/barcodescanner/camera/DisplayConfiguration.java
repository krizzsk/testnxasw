package com.didi.zxing.barcodescanner.camera;

import android.graphics.Rect;
import com.didi.zxing.barcodescanner.Size;
import java.util.List;

public class DisplayConfiguration {

    /* renamed from: a */
    private static final String f48042a = "DisplayConfiguration";

    /* renamed from: b */
    private Size f48043b;

    /* renamed from: c */
    private int f48044c;

    /* renamed from: d */
    private boolean f48045d = false;

    /* renamed from: e */
    private PreviewScalingStrategy f48046e = new FitCenterStrategy();

    public DisplayConfiguration(int i) {
        this.f48044c = i;
    }

    public DisplayConfiguration(int i, Size size) {
        this.f48044c = i;
        this.f48043b = size;
    }

    public int getRotation() {
        return this.f48044c;
    }

    public void setViewfinderSize(Size size) {
        this.f48043b = size;
    }

    public Size getViewfinderSize() {
        return this.f48043b;
    }

    public PreviewScalingStrategy getPreviewScalingStrategy() {
        return this.f48046e;
    }

    public void setPreviewScalingStrategy(PreviewScalingStrategy previewScalingStrategy) {
        this.f48046e = previewScalingStrategy;
    }

    public Size getDesiredPreviewSize(boolean z) {
        Size size = this.f48043b;
        if (size == null) {
            return null;
        }
        return z ? size.rotate() : size;
    }

    public Size getBestPreviewSize(List<Size> list, boolean z) {
        return this.f48046e.getBestPreviewSize(list, getDesiredPreviewSize(z));
    }

    public Rect scalePreview(Size size) {
        return this.f48046e.scalePreview(size, this.f48043b);
    }
}
