package com.didi.flutter.nacho.p115ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.flutter.nacho.Default;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.NachoFlutterFragment;
import com.didi.flutter.nacho.NachoPlugin;
import com.didi.flutter.nacho.p115ui.blur.BlurDialogEngine;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.taxis99.R;
import java.util.HashMap;
import p218io.flutter.embedding.engine.FlutterEngine;
import p218io.flutter.embedding.engine.FlutterEngineCache;

/* renamed from: com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment */
public class FlutterBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a */
    private BlurDialogEngine f22964a;

    /* renamed from: b */
    private NachoFlutterFragment f22965b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f22966c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BottomSheetBehavior<FrameLayout> f22967d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterBottomSheetDialogFragmentBuilder f22968e;

    /* renamed from: f */
    private FlutterEngine f22969f;

    /* renamed from: g */
    private int f22970g = 0;

    /* renamed from: h */
    private final String f22971h = (SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode()));

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        int screenHeight = UIHelper.getScreenHeight(context);
        if (screenHeight > 0) {
            if (this.f22968e.height > 0) {
                this.f22970g = screenHeight - this.f22968e.height;
            } else if (this.f22968e.heightRatio <= 0.0f || this.f22968e.heightRatio >= 1.0f) {
                this.f22970g = 20;
            } else {
                this.f22970g = (int) (((float) screenHeight) * (1.0f - this.f22968e.heightRatio));
            }
        }
        if (this.f22968e.withNewEngine) {
            this.f22969f = Nacho.getInstance().getEngine(this.f22971h);
            this.f22965b = (NachoFlutterFragment) NachoFlutterFragment.withCachedEngine(NachoFlutterFragment.class).engineId(this.f22971h).initialRoute(this.f22968e.initialRoute).build();
        } else {
            this.f22965b = (NachoFlutterFragment) NachoFlutterFragment.withCachedEngine(NachoFlutterFragment.class).engineId(Nacho.getInstance().getDefaultEngineId()).initialRoute(this.f22968e.initialRoute).build();
        }
        BlurDialogEngine blurDialogEngine = this.f22964a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onAttach(m18952b());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BlurDialogEngine blurDialogEngine = this.f22964a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onDetach();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            if (this.f22968e.blur) {
                window.setDimAmount(0.0f);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (onCreateDialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) onCreateDialog;
            bottomSheetDialog.setCanceledOnTouchOutside(this.f22968e.canceledOnTouchOutsideSet);
            BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
            this.f22967d = behavior;
            behavior.setHalfExpandedRatio(1.0E-7f);
            this.f22967d.setSkipCollapsed(true);
            this.f22967d.setPeekHeight(-1);
            this.f22967d.setFitToContents(false);
            this.f22967d.setState(5);
            this.f22967d.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                final NachoPlugin nachoPlugin = FlutterBottomSheetDialogFragment.this.m18948a();

                public void onSlide(View view, float f) {
                }

                public void onStateChanged(View view, int i) {
                    if (!this.nachoPlugin.isNativeProcessGesture() && i == 1) {
                        FlutterBottomSheetDialogFragment.this.f22967d.setState(FlutterBottomSheetDialogFragment.this.f22966c);
                    }
                    int state = FlutterBottomSheetDialogFragment.this.f22967d.getState();
                    if (state == 6 || state == 4) {
                        FlutterBottomSheetDialogFragment.this.f22967d.setState(5);
                    }
                    if (state != 1 && state != 2) {
                        int unused = FlutterBottomSheetDialogFragment.this.f22966c = state;
                    }
                }
            });
        }
        return onCreateDialog;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public NachoPlugin m18948a() {
        Nacho instance = Nacho.getInstance();
        FlutterEngine flutterEngine = this.f22969f;
        if (flutterEngine == null) {
            flutterEngine = Nacho.getInstance().getEngine();
        }
        return instance.getNachoPlugin(flutterEngine);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f22968e.blur) {
            BlurDialogEngine blurDialogEngine = new BlurDialogEngine(m18952b());
            this.f22964a = blurDialogEngine;
            blurDialogEngine.setBlurRadius(8);
            this.f22964a.setDownScaleFactor(8.0f);
            this.f22964a.debug(true);
            this.f22964a.setBlurActionBar(false);
            this.f22964a.setUseRenderScript(false);
        }
    }

    /* renamed from: b */
    private Activity m18952b() {
        return getActivity() != null ? getActivity() : Nacho.getInstance().getTopActivity();
    }

    public void onStart() {
        super.onStart();
        BlurDialogEngine blurDialogEngine = this.f22964a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onResume(false);
        }
        this.f22966c = this.f22967d.getState();
        View view = (View) getView().getParent();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        view.setBackground(colorDrawable);
        view.post(new Runnable() {
            public void run() {
                FlutterBottomSheetDialogFragment.this.f22967d.setState(3);
            }
        });
        ((View) view.getParent()).setBackground(colorDrawable);
    }

    public void onStop() {
        super.onStop();
        BlurDialogEngine blurDialogEngine = this.f22964a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onDismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog, viewGroup, false);
        inflate.setPadding(0, this.f22970g, 0, 0);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (FlutterBottomSheetDialogFragment.this.f22968e.cancelable && FlutterBottomSheetDialogFragment.this.f22968e.canceledOnTouchOutsideSet) {
                    FlutterBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                }
            }
        });
        getChildFragmentManager().beginTransaction().add((int) R.id.content, (Fragment) this.f22965b).commit();
        return inflate;
    }

    public void onDestroyView() {
        FlutterEngineCache.getInstance().remove(this.f22971h);
        getChildFragmentManager().beginTransaction().remove(this.f22965b).commitAllowingStateLoss();
        super.onDestroyView();
    }

    public static FlutterBottomSheetDialogFragmentBuilder Builder() {
        return new FlutterBottomSheetDialogFragmentBuilder();
    }

    public void show() {
        show(Nacho.getInstance().getTopActivity());
    }

    public void show(Context context) {
        if (context instanceof FragmentActivity) {
            show(((FragmentActivity) context).getSupportFragmentManager(), Default.TAG_BOTTOM_DIALOG);
        }
    }

    /* renamed from: com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder */
    public static class FlutterBottomSheetDialogFragmentBuilder {
        /* access modifiers changed from: private */
        public boolean blur = false;
        /* access modifiers changed from: private */
        public boolean cancelable = true;
        /* access modifiers changed from: private */
        public boolean canceledOnTouchOutsideSet = true;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public float heightRatio;
        /* access modifiers changed from: private */
        public String initialRoute;
        private HashMap params;
        /* access modifiers changed from: private */
        public boolean withNewEngine;

        public void setCanceledOnTouchOutsideSet(boolean z) {
            this.canceledOnTouchOutsideSet = z;
        }

        public void setCancelable(boolean z) {
            this.cancelable = z;
        }

        public FlutterBottomSheetDialogFragment build() {
            FlutterBottomSheetDialogFragment flutterBottomSheetDialogFragment = new FlutterBottomSheetDialogFragment();
            FlutterBottomSheetDialogFragmentBuilder unused = flutterBottomSheetDialogFragment.f22968e = this;
            flutterBottomSheetDialogFragment.setCancelable(this.cancelable);
            return flutterBottomSheetDialogFragment;
        }

        public FlutterBottomSheetDialogFragmentBuilder withNewEngine() {
            this.withNewEngine = true;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder height(int i) {
            this.height = i;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder heightRatio(float f) {
            this.heightRatio = f;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder params(HashMap hashMap) {
            this.params = hashMap;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder blur(boolean z) {
            this.blur = z;
            return this;
        }
    }
}
