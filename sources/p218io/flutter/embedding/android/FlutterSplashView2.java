package p218io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.FlutterView;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

/* renamed from: io.flutter.embedding.android.FlutterSplashView2 */
final class FlutterSplashView2 extends FrameLayout {

    /* renamed from: a */
    private static String f60214a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f60215b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterView3 f60216c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f60217d;

    /* renamed from: e */
    private Bundle f60218e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f60219f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f60220g;

    /* renamed from: h */
    private final FlutterView.FlutterEngineAttachmentListener f60221h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f60222i;

    /* renamed from: j */
    private final Runnable f60223j;

    public FlutterSplashView2(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashView2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f60221h = new FlutterView.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashView2.this.f60216c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView2 flutterSplashView2 = FlutterSplashView2.this;
                flutterSplashView2.mo181961a(flutterSplashView2.f60216c, FlutterSplashView2.this.f60215b);
            }
        };
        this.f60222i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashView2.this.f60215b != null) {
                    FlutterSplashView2.this.m45457e();
                }
            }
        };
        this.f60223j = new Runnable() {
            public void run() {
                FlutterSplashView2 flutterSplashView2 = FlutterSplashView2.this;
                flutterSplashView2.removeView(flutterSplashView2.f60217d);
                FlutterSplashView2 flutterSplashView22 = FlutterSplashView2.this;
                String unused = flutterSplashView22.f60220g = flutterSplashView22.f60219f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f60220g;
        SplashScreen splashScreen = this.f60215b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f60220g = savedState.previousCompletedSplashIsolate;
        this.f60218e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo181961a(FlutterView3 flutterView3, SplashScreen splashScreen) {
        FlutterView3 flutterView32 = this.f60216c;
        if (flutterView32 != null) {
            flutterView32.removeOnFirstFrameRenderedListener(this.f60222i);
            removeView(this.f60216c);
        }
        View view = this.f60217d;
        if (view != null) {
            removeView(view);
        }
        this.f60216c = flutterView3;
        addView(flutterView3);
        this.f60215b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m45449a()) {
            Log.m45259v(f60214a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f60218e);
            this.f60217d = createSplashView;
            addView(createSplashView);
            flutterView3.addOnFirstFrameRenderedListener(this.f60222i);
        } else if (m45451b()) {
            Log.m45259v(f60214a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f60218e);
            this.f60217d = createSplashView2;
            addView(createSplashView2);
            m45457e();
        } else if (!flutterView3.isAttachedToFlutterEngine()) {
            Log.m45259v(f60214a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterView3.addFlutterEngineAttachmentListener(this.f60221h);
        }
    }

    /* renamed from: a */
    private boolean m45449a() {
        FlutterView3 flutterView3 = this.f60216c;
        return flutterView3 != null && flutterView3.isAttachedToFlutterEngine() && !this.f60216c.hasRenderedFirstFrame() && !m45455d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f60215b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m45451b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterView3 r0 = r1.f60216c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f60215b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m45453c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterSplashView2.m45451b():boolean");
    }

    /* renamed from: c */
    private boolean m45453c() {
        FlutterView3 flutterView3 = this.f60216c;
        if (flutterView3 == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterView3.isAttachedToFlutterEngine()) {
            return this.f60216c.hasRenderedFirstFrame() && !m45455d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m45455d() {
        FlutterView3 flutterView3 = this.f60216c;
        if (flutterView3 == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterView3.isAttachedToFlutterEngine()) {
            return this.f60216c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f60216c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f60220g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m45457e() {
        this.f60219f = this.f60216c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f60214a;
        Log.m45259v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f60219f);
        this.f60215b.transitionToFlutter(this.f60223j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashView2$SavedState */
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */
        public String previousCompletedSplashIsolate;
        /* access modifiers changed from: private */
        public Bundle splashScreenState;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }
}
