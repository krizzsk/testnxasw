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

/* renamed from: io.flutter.embedding.android.FlutterSplashView */
final class FlutterSplashView extends FrameLayout {

    /* renamed from: a */
    private static String f60204a = "FlutterSplashView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplashScreen f60205b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FlutterView f60206c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f60207d;

    /* renamed from: e */
    private Bundle f60208e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f60209f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f60210g;

    /* renamed from: h */
    private final FlutterView.FlutterEngineAttachmentListener f60211h;

    /* renamed from: i */
    private final FlutterUiDisplayListener f60212i;

    /* renamed from: j */
    private final Runnable f60213j;

    public FlutterSplashView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f60211h = new FlutterView.FlutterEngineAttachmentListener() {
            public void onFlutterEngineDetachedFromFlutterView() {
            }

            public void onFlutterEngineAttachedToFlutterView(FlutterEngine flutterEngine) {
                FlutterSplashView.this.f60206c.removeFlutterEngineAttachmentListener(this);
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.mo181952a(flutterSplashView.f60206c, FlutterSplashView.this.f60205b);
            }
        };
        this.f60212i = new FlutterUiDisplayListener() {
            public void onFlutterUiNoLongerDisplayed() {
            }

            public void onFlutterUiDisplayed() {
                if (FlutterSplashView.this.f60205b != null) {
                    FlutterSplashView.this.m45445e();
                }
            }
        };
        this.f60213j = new Runnable() {
            public void run() {
                FlutterSplashView flutterSplashView = FlutterSplashView.this;
                flutterSplashView.removeView(flutterSplashView.f60207d);
                FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
                String unused = flutterSplashView2.f60210g = flutterSplashView2.f60209f;
            }
        };
        setSaveEnabled(true);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        String unused = savedState.previousCompletedSplashIsolate = this.f60210g;
        SplashScreen splashScreen = this.f60205b;
        Bundle unused2 = savedState.splashScreenState = splashScreen != null ? splashScreen.saveSplashScreenState() : null;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f60210g = savedState.previousCompletedSplashIsolate;
        this.f60208e = savedState.splashScreenState;
    }

    /* renamed from: a */
    public void mo181952a(FlutterView flutterView, SplashScreen splashScreen) {
        FlutterView flutterView2 = this.f60206c;
        if (flutterView2 != null) {
            flutterView2.removeOnFirstFrameRenderedListener(this.f60212i);
            removeView(this.f60206c);
        }
        View view = this.f60207d;
        if (view != null) {
            removeView(view);
        }
        this.f60206c = flutterView;
        addView(flutterView);
        this.f60205b = splashScreen;
        if (splashScreen == null) {
            return;
        }
        if (m45437a()) {
            Log.m45259v(f60204a, "Showing splash screen UI.");
            View createSplashView = splashScreen.createSplashView(getContext(), this.f60208e);
            this.f60207d = createSplashView;
            addView(createSplashView);
            flutterView.addOnFirstFrameRenderedListener(this.f60212i);
        } else if (m45439b()) {
            Log.m45259v(f60204a, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View createSplashView2 = splashScreen.createSplashView(getContext(), this.f60208e);
            this.f60207d = createSplashView2;
            addView(createSplashView2);
            m45445e();
        } else if (!flutterView.isAttachedToFlutterEngine()) {
            Log.m45259v(f60204a, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
            flutterView.addFlutterEngineAttachmentListener(this.f60211h);
        }
    }

    /* renamed from: a */
    private boolean m45437a() {
        FlutterView flutterView = this.f60206c;
        return flutterView != null && flutterView.isAttachedToFlutterEngine() && !this.f60206c.hasRenderedFirstFrame() && !m45443d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f60205b;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m45439b() {
        /*
            r1 = this;
            io.flutter.embedding.android.FlutterView r0 = r1.f60206c
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isAttachedToFlutterEngine()
            if (r0 == 0) goto L_0x001c
            io.flutter.embedding.android.SplashScreen r0 = r1.f60205b
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.doesSplashViewRememberItsTransition()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r1.m45441c()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.embedding.android.FlutterSplashView.m45439b():boolean");
    }

    /* renamed from: c */
    private boolean m45441c() {
        FlutterView flutterView = this.f60206c;
        if (flutterView == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        } else if (flutterView.isAttachedToFlutterEngine()) {
            return this.f60206c.hasRenderedFirstFrame() && !m45443d();
        } else {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* renamed from: d */
    private boolean m45443d() {
        FlutterView flutterView = this.f60206c;
        if (flutterView == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        } else if (flutterView.isAttachedToFlutterEngine()) {
            return this.f60206c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId() != null && this.f60206c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId().equals(this.f60210g);
        } else {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m45445e() {
        this.f60209f = this.f60206c.getAttachedFlutterEngine().getDartExecutor().getIsolateServiceId();
        String str = f60204a;
        Log.m45259v(str, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f60209f);
        this.f60205b.transitionToFlutter(this.f60213j);
    }

    /* renamed from: io.flutter.embedding.android.FlutterSplashView$SavedState */
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
