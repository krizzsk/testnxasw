package jumio.iproov;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.widget.ImageView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.taxis99.R;
import javax.security.auth.Destroyable;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.iproov.c */
/* compiled from: IproovHelpAnimation.kt */
public final class C19526c implements MotionLayout.TransitionListener, Destroyable {

    /* renamed from: a */
    public Context f55450a;

    /* renamed from: b */
    public boolean f55451b;

    /* renamed from: c */
    public boolean f55452c;

    /* renamed from: d */
    public boolean f55453d;

    /* renamed from: e */
    public MotionLayout f55454e;

    /* renamed from: f */
    public C19527a f55455f = C19527a.START;

    /* renamed from: g */
    public ImageView f55456g;

    /* renamed from: h */
    public ImageView f55457h;

    /* renamed from: i */
    public ImageView f55458i;

    /* renamed from: j */
    public ImageView f55459j;

    /* renamed from: k */
    public ImageView f55460k;

    /* renamed from: l */
    public ImageView f55461l;

    /* renamed from: m */
    public ImageView f55462m;

    /* renamed from: n */
    public ImageView f55463n;

    /* renamed from: o */
    public ImageView f55464o;

    /* renamed from: p */
    public ImageView f55465p;

    /* renamed from: jumio.iproov.c$a */
    /* compiled from: IproovHelpAnimation.kt */
    public enum C19527a {
        START,
        APPEAR,
        ALIGN,
        FOCUS,
        FLASH,
        SUCCESS
    }

    /* renamed from: jumio.iproov.c$b */
    /* compiled from: IproovHelpAnimation.kt */
    public /* synthetic */ class C19528b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f55473a;

        static {
            int[] iArr = new int[C19527a.values().length];
            iArr[C19527a.START.ordinal()] = 1;
            iArr[C19527a.APPEAR.ordinal()] = 2;
            iArr[C19527a.ALIGN.ordinal()] = 3;
            iArr[C19527a.FOCUS.ordinal()] = 4;
            iArr[C19527a.FLASH.ordinal()] = 5;
            iArr[C19527a.SUCCESS.ordinal()] = 6;
            f55473a = iArr;
        }
    }

    public C19526c(Context context) {
        this.f55450a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo148786a() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f55453d     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            boolean r0 = r1.f55452c     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0011
            r0 = 1
            r1.f55452c = r0     // Catch:{ all -> 0x0013 }
            r1.mo148789b()     // Catch:{ all -> 0x0013 }
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C19526c.mo148786a():void");
    }

    /* renamed from: b */
    public final synchronized void mo148789b() {
        if (this.f55455f == C19527a.START) {
            MotionLayout motionLayout = this.f55454e;
            if (motionLayout != null) {
                motionLayout.setTransitionListener(this);
            }
            MotionLayout motionLayout2 = this.f55454e;
            if (motionLayout2 != null) {
                motionLayout2.setTransition(R.id.start, R.id.appear);
            }
            this.f55455f = C19527a.APPEAR;
            this.f55452c = true;
            MotionLayout motionLayout3 = this.f55454e;
            if (motionLayout3 != null) {
                motionLayout3.transitionToEnd();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo148790c() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f55453d     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            boolean r0 = r3.f55452c     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            jumio.iproov.c$a r0 = jumio.iproov.C19526c.C19527a.START     // Catch:{ all -> 0x002f }
            r3.f55455f = r0     // Catch:{ all -> 0x002f }
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f55454e     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            r1 = 2131434351(0x7f0b1b6f, float:1.8490513E38)
            if (r0 != 0) goto L_0x001b
            r2 = 0
            goto L_0x001f
        L_0x001b:
            androidx.constraintlayout.widget.ConstraintSet r2 = r0.getConstraintSet(r1)     // Catch:{ all -> 0x002f }
        L_0x001f:
            r0.updateState(r1, r2)     // Catch:{ all -> 0x002f }
        L_0x0022:
            androidx.constraintlayout.motion.widget.MotionLayout r0 = r3.f55454e     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            r0.transitionToStart()     // Catch:{ all -> 0x002f }
        L_0x002a:
            r0 = 0
            r3.f55452c = r0     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C19526c.mo148790c():void");
    }

    public void destroy() {
        mo148790c();
        this.f55450a = null;
        this.f55454e = null;
        this.f55456g = null;
        this.f55457h = null;
        this.f55458i = null;
        this.f55459j = null;
        this.f55460k = null;
        this.f55461l = null;
        this.f55462m = null;
        this.f55463n = null;
        this.f55464o = null;
        this.f55465p = null;
    }

    public boolean isDestroyed() {
        return !this.f55452c;
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        if (this.f55452c) {
            if (this.f55451b) {
                switch (C19528b.f55473a[this.f55455f.ordinal()]) {
                    case 1:
                        this.f55455f = C19527a.APPEAR;
                        MotionLayout motionLayout2 = this.f55454e;
                        if (motionLayout2 != null) {
                            motionLayout2.setTransition(R.id.start, R.id.appear);
                            break;
                        }
                        break;
                    case 2:
                        this.f55455f = C19527a.ALIGN;
                        MotionLayout motionLayout3 = this.f55454e;
                        if (motionLayout3 != null) {
                            motionLayout3.setTransition(R.id.appear, R.id.align);
                            break;
                        }
                        break;
                    case 3:
                        this.f55455f = C19527a.FOCUS;
                        MotionLayout motionLayout4 = this.f55454e;
                        if (motionLayout4 != null) {
                            motionLayout4.setTransition(R.id.align, R.id.focus);
                            break;
                        }
                        break;
                    case 4:
                        this.f55455f = C19527a.FLASH;
                        MotionLayout motionLayout5 = this.f55454e;
                        if (motionLayout5 != null) {
                            motionLayout5.setTransition(R.id.focus, R.id.flash);
                            break;
                        }
                        break;
                    case 5:
                        this.f55455f = C19527a.SUCCESS;
                        MotionLayout motionLayout6 = this.f55454e;
                        if (motionLayout6 != null) {
                            motionLayout6.setTransition(R.id.flash, R.id.success);
                            break;
                        }
                        break;
                    case 6:
                        this.f55455f = C19527a.START;
                        MotionLayout motionLayout7 = this.f55454e;
                        if (motionLayout7 != null) {
                            motionLayout7.setTransition(R.id.success, R.id.start);
                            break;
                        }
                        break;
                }
            } else {
                int i2 = C19528b.f55473a[this.f55455f.ordinal()];
                if (i2 == 1) {
                    this.f55455f = C19527a.APPEAR;
                    MotionLayout motionLayout8 = this.f55454e;
                    if (motionLayout8 != null) {
                        motionLayout8.setTransition(R.id.start, R.id.appear);
                    }
                } else if (i2 == 2) {
                    this.f55455f = C19527a.ALIGN;
                    MotionLayout motionLayout9 = this.f55454e;
                    if (motionLayout9 != null) {
                        motionLayout9.setTransition(R.id.appear, R.id.align);
                    }
                } else if (i2 == 3) {
                    this.f55455f = C19527a.FOCUS;
                    MotionLayout motionLayout10 = this.f55454e;
                    if (motionLayout10 != null) {
                        motionLayout10.setTransition(R.id.align, R.id.focus);
                    }
                } else if (i2 == 4) {
                    this.f55455f = C19527a.SUCCESS;
                    MotionLayout motionLayout11 = this.f55454e;
                    if (motionLayout11 != null) {
                        motionLayout11.setTransition(R.id.focus, R.id.success);
                    }
                } else if (i2 == 6) {
                    this.f55455f = C19527a.START;
                    MotionLayout motionLayout12 = this.f55454e;
                    if (motionLayout12 != null) {
                        motionLayout12.setTransition(R.id.success, R.id.start);
                    }
                }
            }
            MotionLayout motionLayout13 = this.f55454e;
            if (motionLayout13 != null) {
                motionLayout13.transitionToEnd();
            }
        }
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    /* renamed from: a */
    public final synchronized void mo148788a(MotionLayout motionLayout, boolean z) {
        Intrinsics.checkNotNullParameter(motionLayout, "animationContainer");
        if (this.f55452c) {
            mo148790c();
        }
        this.f55454e = motionLayout;
        this.f55456g = (ImageView) motionLayout.findViewById(R.id.iv_face);
        this.f55457h = (ImageView) motionLayout.findViewById(R.id.iv_face_oval_mask);
        this.f55462m = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_bl);
        this.f55463n = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_br);
        this.f55460k = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tl);
        this.f55461l = (ImageView) motionLayout.findViewById(R.id.iv_crosshair_tr);
        this.f55458i = (ImageView) motionLayout.findViewById(R.id.iv_checkmark);
        this.f55459j = (ImageView) motionLayout.findViewById(R.id.iv_checkmark_circle);
        this.f55464o = (ImageView) motionLayout.findViewById(R.id.iv_progress_lane);
        this.f55465p = (ImageView) motionLayout.findViewById(R.id.iv_progress_bar);
        this.f55451b = z;
        this.f55453d = true;
    }

    /* renamed from: a */
    public final void mo148787a(Resources resources, int i, int i2) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        Drawable drawable4;
        Drawable drawable5;
        Drawable drawable6;
        Drawable drawable7;
        Intrinsics.checkNotNullParameter(resources, "resources");
        MotionLayout motionLayout = this.f55454e;
        if (motionLayout != null) {
            motionLayout.setBackgroundColor(i2);
        }
        Drawable drawable8 = null;
        if (Build.VERSION.SDK_INT >= 21) {
            Context context = this.f55450a;
            Resources.Theme theme = context == null ? null : context.getTheme();
            TypedValue typedValue = new TypedValue();
            int i3 = 2132017569;
            boolean z = true;
            if (theme == null || !theme.resolveAttribute(R.attr.iproov_customization, typedValue, true)) {
                z = false;
            }
            if (z) {
                i3 = typedValue.data;
            }
            Drawable drawable9 = ResourcesCompat.getDrawable(resources, R.drawable.ic_face_oval_mask, new ContextThemeWrapper(this.f55450a, i3).getTheme());
            ImageView imageView = this.f55457h;
            if (imageView != null) {
                imageView.setImageDrawable(drawable9);
            }
        } else {
            Context context2 = this.f55450a;
            Drawable drawable10 = ResourcesCompat.getDrawable(resources, R.drawable.ic_face_oval, context2 == null ? null : context2.getTheme());
            ImageView imageView2 = this.f55457h;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable10);
            }
            ImageView imageView3 = this.f55457h;
            if (!(imageView3 == null || (drawable7 = imageView3.getDrawable()) == null)) {
                DrawableCompat.setTint(drawable7, i);
            }
        }
        ImageView imageView4 = this.f55460k;
        if (!(imageView4 == null || (drawable6 = imageView4.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable6, i);
        }
        ImageView imageView5 = this.f55462m;
        if (imageView5 != null) {
            ImageView imageView6 = this.f55460k;
            imageView5.setImageDrawable(imageView6 == null ? null : imageView6.getDrawable());
        }
        ImageView imageView7 = this.f55463n;
        if (imageView7 != null) {
            ImageView imageView8 = this.f55460k;
            imageView7.setImageDrawable(imageView8 == null ? null : imageView8.getDrawable());
        }
        ImageView imageView9 = this.f55461l;
        if (imageView9 != null) {
            ImageView imageView10 = this.f55460k;
            if (imageView10 != null) {
                drawable8 = imageView10.getDrawable();
            }
            imageView9.setImageDrawable(drawable8);
        }
        ImageView imageView11 = this.f55456g;
        if (!(imageView11 == null || (drawable5 = imageView11.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable5, i);
        }
        ImageView imageView12 = this.f55458i;
        if (!(imageView12 == null || (drawable4 = imageView12.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable4, i);
        }
        ImageView imageView13 = this.f55459j;
        if (!(imageView13 == null || (drawable3 = imageView13.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable3, i);
        }
        ImageView imageView14 = this.f55464o;
        if (!(imageView14 == null || (drawable2 = imageView14.getDrawable()) == null)) {
            DrawableCompat.setTint(drawable2, i);
        }
        ImageView imageView15 = this.f55465p;
        if (imageView15 != null && (drawable = imageView15.getDrawable()) != null) {
            DrawableCompat.setTint(drawable, i);
        }
    }
}
