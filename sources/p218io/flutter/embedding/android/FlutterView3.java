package p218io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;

/* renamed from: io.flutter.embedding.android.FlutterView3 */
public class FlutterView3 extends FlutterView {

    /* renamed from: b */
    private int f60291b;

    /* renamed from: c */
    private int f60292c;

    public FlutterView3(Context context) {
        super(context);
    }

    public FlutterView3(Context context, FlutterSurfaceView flutterSurfaceView) {
        super(context, flutterSurfaceView);
    }

    public FlutterView3(Context context, FlutterTextureView flutterTextureView) {
        super(context, flutterTextureView);
    }

    public FlutterView3(Context context, FlutterImageView flutterImageView) {
        super(context, flutterImageView);
    }

    public FlutterView3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f60291b = i;
        this.f60292c = i2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void fixViewSize() {
        super.onSizeChanged(this.f60291b, this.f60292c, 0, 0);
    }

    public void attachToRenderer() {
        if ((this.f60250a != null && this.f60250a.getAttachedRenderer() == null) || !this.f60250a.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f60250a.attachToRenderer(getAttachedFlutterEngine().getRenderer());
        }
    }

    public void detachFromRenderer() {
        this.f60250a.detachFromRenderer();
    }
}
