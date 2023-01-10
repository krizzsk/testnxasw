package p218io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p218io.flutter.Log;
import p218io.flutter.embedding.android.FlutterViewV1;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

/* renamed from: io.flutter.embedding.android.FlutterSplashViewV1 */
final class FlutterSplashViewV1 extends FrameLayout {

    /* renamed from: a */
    private static String f60224a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f60225b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterViewV1 f60226c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f60227d;

    /* renamed from: e */
    private Bundle f60228e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f60229f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f60230g;

    /* renamed from: h */
    private final FlutterViewV1.FlutterEngineAttachmentListener f60231h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f60232i;

    /* renamed from: j */
    private final Runnable f60233j;

    public FlutterSplashViewV1(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashViewV1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashViewV1(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f60231h = new FlutterViewV1.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashViewV1.this.f60226c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashViewV1 flutterSplashViewV1 = FlutterSplashViewV1.this;
                flutterSplashViewV1.mo181968a(flutterSplashViewV1.f60226c, FlutterSplashViewV1.this.f60225b);
            }
        };
        this.f60232i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashViewV1.this.f60225b != null) {
                    FlutterSplashViewV1.this.m45469e();
                }
            }
        };
        this.f60233j = new Runnable() {
            public void run() {
                FlutterSplashViewV1 flutterSplashViewV1 = FlutterSplashViewV1.this;
                flutterSplashViewV1.removeView(flutterSplashViewV1.f60227d);
                FlutterSplashViewV1 flutterSplashViewV12 = FlutterSplashViewV1.this;
                String unused = flutterSplashViewV12.f60230g = flutterSplashViewV12.f60229f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f60230g;
        SplashScreen splashScreen = this.f60225b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f60230g = savedState.previousCompletedSplashIsolate;
        this.f60228e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo181968a(FlutterViewV1 flutterViewV1, SplashScreen splashScreen) {
        FlutterViewV1 flutterViewV12 = this.f60226c;
        if (flutterViewV12 != null) {
            flutterViewV12.removeOnFirstFrameRenderedListener(this.f60232i);
            removeView(this.f60226c);
        }
        View view = this.f60227d;
        if (view != null) {
            removeView(view);
        }
        this.f60226c = flutterViewV1;
        addView(flutterViewV1);
        this.f60225b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m45461a()) {
            Log.m45259v(f60224a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f60228e);
            this.f60227d = createSplashView;
            addView(createSplashView);
            flutterViewV1.addOnFirstFrameRenderedListener(this.f60232i);
        } else if (m45463b()) {
            Log.m45259v(f60224a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f60228e);
            this.f60227d = createSplashView2;
            addView(createSplashView2);
            m45469e();
        } else if (!flutterViewV1.isAttachedToFlutterEngine()) {
            Log.m45259v(f60224a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterViewV1.addFlutterEngineAttachmentListener(this.f60231h);
        }
    }

    /* renamed from: a */
    private boolean m45461a() {
        FlutterViewV1 flutterViewV1 = this.f60226c;
        return flutterViewV1 != null && flutterViewV1.isAttachedToFlutterEngine() && !this.f60226c.hasRenderedFirstFrame() && !m45467d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f60225b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m45463b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterViewV1 r0 = r1.f60226c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f60225b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m45465c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterSplashViewV1.m45463b():boolean");
    }

    /* renamed from: c */
    private boolean m45465c() {
        FlutterViewV1 flutterViewV1 = this.f60226c;
        if (flutterViewV1 == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterViewV1.isAttachedToFlutterEngine()) {
            return this.f60226c.hasRenderedFirstFrame() && !m45467d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m45467d() {
        FlutterViewV1 flutterViewV1 = this.f60226c;
        if (flutterViewV1 == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterViewV1.isAttachedToFlutterEngine()) {
            return this.f60226c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f60226c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f60230g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m45469e() {
        this.f60229f = this.f60226c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f60224a;
        Log.m45259v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f60229f);
        this.f60225b.transitionToFlutter(this.f60233j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashViewV1$SavedState */
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
