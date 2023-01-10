package com.didi.sdk.apm;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.sdk.apm.b */
/* compiled from: FragmentHelper */
class C12710b {

    /* renamed from: a */
    public static final String f37737a = "FragmentHelper";

    C12710b() {
    }

    /* renamed from: a */
    public static boolean m28465a(Fragment fragment) {
        return (fragment.getHost() == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()) ? false : true;
    }

    /* renamed from: a */
    public static boolean m28464a(android.app.Fragment fragment) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (fragment.getHost() == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()) {
                return false;
            }
            return true;
        } else if (fragment.getActivity() == null || fragment.getActivity().isFinishing()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public static void m28459a(Fragment fragment, Intent intent) {
        m28462a(fragment, intent, (Bundle) null);
    }

    /* renamed from: a */
    public static void m28462a(Fragment fragment, Intent intent, Bundle bundle) {
        if (!m28465a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startActivity when detached. ");
            return;
        }
        fragment.startActivity(intent, bundle);
    }

    /* renamed from: a */
    public static void m28460a(Fragment fragment, Intent intent, int i) {
        m28461a(fragment, intent, i, (Bundle) null);
    }

    /* renamed from: a */
    public static void m28461a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!m28465a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startActivityForResult when detached. ");
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    /* renamed from: a */
    public static void m28463a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!m28465a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startIntentSenderForResult when detached. ");
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* renamed from: a */
    public static void m28454a(android.app.Fragment fragment, Intent intent) {
        m28457a(fragment, intent, (Bundle) null);
    }

    /* renamed from: a */
    public static void m28457a(android.app.Fragment fragment, Intent intent, Bundle bundle) {
        if (!m28464a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startActivity when detached .");
            return;
        }
        fragment.startActivity(intent, bundle);
    }

    /* renamed from: a */
    public static void m28455a(android.app.Fragment fragment, Intent intent, int i) {
        m28456a(fragment, intent, i, (Bundle) null);
    }

    /* renamed from: a */
    public static void m28456a(android.app.Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!m28464a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startActivityForResult when detached. ");
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    /* renamed from: a */
    public static void m28458a(android.app.Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!m28464a(fragment)) {
            Log.e(f37737a, "Fragment " + fragment + " try startIntentSenderForResult when detached. ");
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
