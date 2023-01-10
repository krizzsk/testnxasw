package p218io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.core.view.WindowInsetsControllerCompat;
import com.didi.sdk.apm.SystemUtils;
import java.io.FileNotFoundException;
import java.util.List;
import p218io.flutter.Log;
import p218io.flutter.embedding.engine.systemchannels.PlatformChannel;

/* renamed from: io.flutter.plugin.platform.PlatformPlugin */
public class PlatformPlugin {
    public static final int DEFAULT_SYSTEM_UI = 1280;

    /* renamed from: g */
    private static final String f60615g = "PlatformPlugin";

    /* renamed from: a */
    final PlatformChannel.PlatformMessageHandler f60616a;

    /* renamed from: b */
    private final Activity f60617b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final PlatformChannel f60618c;

    /* renamed from: d */
    private final PlatformPluginDelegate f60619d;

    /* renamed from: e */
    private PlatformChannel.SystemChromeStyle f60620e;

    /* renamed from: f */
    private int f60621f;

    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$PlatformPluginDelegate */
    public interface PlatformPluginDelegate {
        boolean popSystemNavigator();
    }

    public PlatformPlugin(Activity activity, PlatformChannel platformChannel) {
        this(activity, platformChannel, (PlatformPluginDelegate) null);
    }

    public PlatformPlugin(Activity activity, PlatformChannel platformChannel, PlatformPluginDelegate platformPluginDelegate) {
        C221151 r0 = new PlatformChannel.PlatformMessageHandler() {
            public void playSystemSound(PlatformChannel.SoundType soundType) {
                PlatformPlugin.this.m45710a(soundType);
            }

            public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
                PlatformPlugin.this.mo182626a(hapticFeedbackType);
            }

            public void setPreferredOrientations(int i) {
                PlatformPlugin.this.m45708a(i);
            }

            public void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
                PlatformPlugin.this.m45709a(appSwitcherDescription);
            }

            public void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> list) {
                PlatformPlugin.this.m45722a(list);
            }

            public void showSystemUiMode(PlatformChannel.SystemUiMode systemUiMode) {
                PlatformPlugin.this.m45712a(systemUiMode);
            }

            public void setSystemUiChangeListener() {
                PlatformPlugin.this.m45707a();
            }

            public void restoreSystemUiOverlays() {
                PlatformPlugin.this.m45723b();
            }

            public void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
                PlatformPlugin.this.m45711a(systemChromeStyle);
            }

            public void popSystemNavigator() {
                PlatformPlugin.this.m45725c();
            }

            public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
                return PlatformPlugin.this.m45705a(clipboardContentFormat);
            }

            public void setClipboardData(String str) {
                PlatformPlugin.this.m45721a(str);
            }

            public boolean clipboardHasStrings() {
                return PlatformPlugin.this.m45727d();
            }
        };
        this.f60616a = r0;
        this.f60617b = activity;
        this.f60618c = platformChannel;
        platformChannel.setPlatformMessageHandler(r0);
        this.f60619d = platformPluginDelegate;
        this.f60621f = 1280;
    }

    public void destroy() {
        this.f60618c.setPlatformMessageHandler((PlatformChannel.PlatformMessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45710a(PlatformChannel.SoundType soundType) {
        if (soundType == PlatformChannel.SoundType.CLICK) {
            this.f60617b.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182626a(PlatformChannel.HapticFeedbackType hapticFeedbackType) {
        View decorView = this.f60617b.getWindow().getDecorView();
        int i = C221173.f60623x98e77c60[hapticFeedbackType.ordinal()];
        if (i == 1) {
            decorView.performHapticFeedback(0);
        } else if (i == 2) {
            decorView.performHapticFeedback(1);
        } else if (i == 3) {
            decorView.performHapticFeedback(3);
        } else if (i != 4) {
            if (i == 5 && Build.VERSION.SDK_INT >= 21) {
                decorView.performHapticFeedback(4);
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            decorView.performHapticFeedback(6);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45708a(int i) {
        SystemUtils.hookSetRequestedOrientation(this.f60617b, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45709a(PlatformChannel.AppSwitcherDescription appSwitcherDescription) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT > 21) {
                this.f60617b.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, (Bitmap) null, appSwitcherDescription.color));
            }
            if (Build.VERSION.SDK_INT >= 28) {
                this.f60617b.setTaskDescription(new ActivityManager.TaskDescription(appSwitcherDescription.label, 0, appSwitcherDescription.color));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45707a() {
        this.f60617b.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int i) {
                if ((i & 4) == 0) {
                    PlatformPlugin.this.f60618c.systemChromeChanged(false);
                } else {
                    PlatformPlugin.this.f60618c.systemChromeChanged(true);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45712a(PlatformChannel.SystemUiMode systemUiMode) {
        int i;
        if (systemUiMode == PlatformChannel.SystemUiMode.LEAN_BACK && Build.VERSION.SDK_INT >= 16) {
            i = 1798;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE && Build.VERSION.SDK_INT >= 19) {
            i = 3846;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.IMMERSIVE_STICKY && Build.VERSION.SDK_INT >= 19) {
            i = 5894;
        } else if (systemUiMode == PlatformChannel.SystemUiMode.EDGE_TO_EDGE && Build.VERSION.SDK_INT >= 29) {
            i = 1792;
        } else {
            return;
        }
        this.f60621f = i;
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45722a(List<PlatformChannel.SystemUiOverlay> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = C221173.f60624x4c113a23[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & -513 & -3;
            }
        }
        this.f60621f = i;
        updateSystemUiOverlays();
    }

    public void updateSystemUiOverlays() {
        this.f60617b.getWindow().getDecorView().setSystemUiVisibility(this.f60621f);
        PlatformChannel.SystemChromeStyle systemChromeStyle = this.f60620e;
        if (systemChromeStyle != null) {
            m45711a(systemChromeStyle);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m45723b() {
        updateSystemUiOverlays();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45711a(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        Window window = this.f60617b.getWindow();
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        if (Build.VERSION.SDK_INT >= 23) {
            if (systemChromeStyle.statusBarIconBrightness != null) {
                int i = C221173.f60622xfa6fb21b[systemChromeStyle.statusBarIconBrightness.ordinal()];
                if (i == 1) {
                    windowInsetsControllerCompat.setAppearanceLightStatusBars(true);
                } else if (i == 2) {
                    windowInsetsControllerCompat.setAppearanceLightStatusBars(false);
                }
            }
            if (systemChromeStyle.statusBarColor != null) {
                window.setStatusBarColor(systemChromeStyle.statusBarColor.intValue());
            }
        }
        if (systemChromeStyle.systemStatusBarContrastEnforced != null && Build.VERSION.SDK_INT >= 29) {
            window.setStatusBarContrastEnforced(systemChromeStyle.systemStatusBarContrastEnforced.booleanValue());
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (systemChromeStyle.systemNavigationBarIconBrightness != null) {
                int i2 = C221173.f60622xfa6fb21b[systemChromeStyle.systemNavigationBarIconBrightness.ordinal()];
                if (i2 == 1) {
                    windowInsetsControllerCompat.setAppearanceLightNavigationBars(true);
                } else if (i2 == 2) {
                    windowInsetsControllerCompat.setAppearanceLightNavigationBars(false);
                }
            }
            if (systemChromeStyle.systemNavigationBarColor != null) {
                window.setNavigationBarColor(systemChromeStyle.systemNavigationBarColor.intValue());
            }
        }
        if (systemChromeStyle.systemNavigationBarDividerColor != null && Build.VERSION.SDK_INT >= 28) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(View.NAVIGATION_BAR_TRANSIENT);
            window.setNavigationBarDividerColor(systemChromeStyle.systemNavigationBarDividerColor.intValue());
        }
        if (systemChromeStyle.systemNavigationBarContrastEnforced != null && Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(systemChromeStyle.systemNavigationBarContrastEnforced.booleanValue());
        }
        this.f60620e = systemChromeStyle;
    }

    /* renamed from: io.flutter.plugin.platform.PlatformPlugin$3 */
    static /* synthetic */ class C221173 {

        /* renamed from: $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$Brightness */
        static final /* synthetic */ int[] f60622xfa6fb21b;

        /* renamed from: $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$HapticFeedbackType */
        static final /* synthetic */ int[] f60623x98e77c60;

        /* renamed from: $SwitchMap$io$flutter$embedding$engine$systemchannels$PlatformChannel$SystemUiOverlay */
        static final /* synthetic */ int[] f60624x4c113a23;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
        static {
            /*
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness[] r0 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60622xfa6fb21b = r0
                r1 = 1
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness r2 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.DARK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f60622xfa6fb21b     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$Brightness r3 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.Brightness.LIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay[] r2 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f60624x4c113a23 = r2
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r3 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.TOP_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f60624x4c113a23     // Catch:{ NoSuchFieldError -> 0x0038 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$SystemUiOverlay r3 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay.BOTTOM_OVERLAYS     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType[] r2 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f60623x98e77c60 = r2
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r3 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.STANDARD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r1 = f60623x98e77c60     // Catch:{ NoSuchFieldError -> 0x0053 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r2 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.LIGHT_IMPACT     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f60623x98e77c60     // Catch:{ NoSuchFieldError -> 0x005e }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.MEDIUM_IMPACT     // Catch:{ NoSuchFieldError -> 0x005e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                int[] r0 = f60623x98e77c60     // Catch:{ NoSuchFieldError -> 0x0069 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.HEAVY_IMPACT     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                int[] r0 = f60623x98e77c60     // Catch:{ NoSuchFieldError -> 0x0074 }
                io.flutter.embedding.engine.systemchannels.PlatformChannel$HapticFeedbackType r1 = p218io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType.SELECTION_CLICK     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p218io.flutter.plugin.platform.PlatformPlugin.C221173.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m45725c() {
        PlatformPluginDelegate platformPluginDelegate = this.f60619d;
        if (platformPluginDelegate == null || !platformPluginDelegate.popSystemNavigator()) {
            Activity activity = this.f60617b;
            if (activity instanceof OnBackPressedDispatcherOwner) {
                ((OnBackPressedDispatcherOwner) activity).getOnBackPressedDispatcher().onBackPressed();
            } else {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public CharSequence m45705a(PlatformChannel.ClipboardContentFormat clipboardContentFormat) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f60617b.getSystemService("clipboard");
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            ClipData primaryClip = clipboardManager.getPrimaryClip();
            if (primaryClip == null) {
                return null;
            }
            if (clipboardContentFormat != null) {
                if (clipboardContentFormat != PlatformChannel.ClipboardContentFormat.PLAIN_TEXT) {
                    return null;
                }
            }
            ClipData.Item itemAt = primaryClip.getItemAt(0);
            if (itemAt.getUri() != null) {
                this.f60617b.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", (Bundle) null);
            }
            return itemAt.coerceToText(this.f60617b);
        } catch (SecurityException e) {
            Log.m45262w(f60615g, "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
            return null;
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m45721a(String str) {
        ((ClipboardManager) this.f60617b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m45727d() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f60617b.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }
}
