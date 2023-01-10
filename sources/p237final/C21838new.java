package p237final;

import android.view.Window;
import android.view.WindowManager;

/* renamed from: final.new */
/* compiled from: WindowManager */
public class C21838new {

    /* renamed from: a */
    private Window f60012a;

    public C21838new(Window window) {
        this.f60012a = window;
    }

    /* renamed from: do */
    public void mo180481do(float f) {
        WindowManager.LayoutParams attributes = this.f60012a.getAttributes();
        attributes.screenBrightness = f;
        this.f60012a.setAttributes(attributes);
    }

    /* renamed from: if */
    public void mo180483if(boolean z) {
        WindowManager.LayoutParams attributes = this.f60012a.getAttributes();
        if (z) {
            attributes.screenBrightness = 1.0f;
        } else {
            attributes.screenBrightness = -1.0f;
        }
        this.f60012a.setAttributes(attributes);
    }

    /* renamed from: do */
    public void mo180482do(boolean z) {
        if (z) {
            this.f60012a.addFlags(128);
        } else {
            this.f60012a.clearFlags(128);
        }
    }
}
