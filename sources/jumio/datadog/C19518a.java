package jumio.datadog;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.fragment.app.Fragment;
import com.datadog.android.Datadog;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.configuration.Credentials;
import com.datadog.android.privacy.TrackingConsent;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.tracking.ComponentPredicate;
import com.datadog.android.rum.tracking.InteractionPredicate;
import com.datadog.android.rum.tracking.MixedViewTrackingStrategy;
import com.datadog.android.rum.tracking.ViewAttributesProvider;
import com.didi.trackupload.sdk.Constants;
import com.jumio.defaultui.view.BaseFragment;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* renamed from: jumio.datadog.a */
/* compiled from: JDataDog.kt */
public final class C19518a {

    /* renamed from: a */
    public static final C19518a f55421a = new C19518a();

    /* renamed from: b */
    public static final AtomicBoolean f55422b = new AtomicBoolean(false);

    /* renamed from: jumio.datadog.a$a */
    /* compiled from: JDataDog.kt */
    public static final class C19519a implements ComponentPredicate<Activity> {
        /* renamed from: a */
        public boolean accept(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "component");
            return false;
        }

        /* renamed from: b */
        public String getViewName(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "component");
            return activity.getClass().getName();
        }
    }

    /* renamed from: jumio.datadog.a$b */
    /* compiled from: JDataDog.kt */
    public static final class C19520b implements ComponentPredicate<Fragment> {
        /* renamed from: a */
        public boolean accept(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "component");
            return fragment instanceof BaseFragment;
        }

        /* renamed from: b */
        public String getViewName(Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "component");
            return fragment.getClass().getName();
        }
    }

    /* renamed from: jumio.datadog.a$c */
    /* compiled from: JDataDog.kt */
    public static final class C19521c implements ComponentPredicate<android.app.Fragment> {
        /* renamed from: a */
        public boolean accept(android.app.Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "component");
            return false;
        }

        /* renamed from: b */
        public String getViewName(android.app.Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "component");
            return fragment.getClass().getName();
        }
    }

    /* renamed from: a */
    public final void mo148769a(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(str, "clientToken");
        Intrinsics.checkNotNullParameter(str2, "rumAppId");
        try {
            if (!mo148770a()) {
                f55422b.set(true);
                Datadog.initialize(context, new Credentials(str, mo148768a(context), "", str2, (String) null, 16, (DefaultConstructorMarker) null), Configuration.Builder.trackInteractions$default(new Configuration.Builder(true, true, false, true), (ViewAttributesProvider[]) null, (InteractionPredicate) null, 3, (Object) null).trackLongTasks(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME).useViewTrackingStrategy(mo148771b()).build(), TrackingConsent.GRANTED);
                mo148772c();
                Intrinsics.stringPlus("Started DataDog successfully ", Boolean.valueOf(Datadog.isInitialized()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final MixedViewTrackingStrategy mo148771b() {
        return new MixedViewTrackingStrategy(true, new C19519a(), new C19520b(), new C19521c());
    }

    /* renamed from: c */
    public final void mo148772c() {
        boolean registerIfAbsent = GlobalRum.registerIfAbsent(new RumMonitor.Builder().build());
        GlobalRum.addAttribute("SDK version", "4.1.0");
        Intrinsics.stringPlus("Initialised DataDog RUM successfully ", Boolean.valueOf(registerIfAbsent));
    }

    /* renamed from: a */
    public final boolean mo148770a() {
        if (!f55422b.get() && !Datadog.isInitialized()) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public final String mo148768a(Context context) {
        String str;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        if (i == 0) {
            str = applicationInfo.nonLocalizedLabel.toString();
        } else {
            str = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(str, "context.getString(stringId)");
        }
        return new Regex("[^a-zA-Z0-9_:./-]").replace((CharSequence) str, "");
    }
}
