package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.os.Build;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

public final class StrictChecker implements PermissionChecker {
    public boolean hasPermission(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : strArr) {
            if (!m44550a(context, a)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : list) {
            if (!m44550a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m44550a(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals(Permission.READ_SMS)) {
                        c = 19;
                        break;
                    }
                    break;
                case -1928411001:
                    if (str.equals(Permission.READ_CALENDAR)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (str.equals(Permission.READ_CALL_LOG)) {
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (str.equals(Permission.ACCESS_FINE_LOCATION)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1479758289:
                    if (str.equals(Permission.RECEIVE_WAP_PUSH)) {
                        c = 20;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals(Permission.BODY_SENSORS)) {
                        c = 16;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals(Permission.RECEIVE_MMS)) {
                        c = 18;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals(Permission.RECEIVE_SMS)) {
                        c = 21;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals(Permission.READ_EXTERNAL_STORAGE)) {
                        c = 22;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals(Permission.ACCESS_COARSE_LOCATION)) {
                        c = 6;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals(Permission.READ_PHONE_STATE)) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (str.equals(Permission.SEND_SMS)) {
                        c = 17;
                        break;
                    }
                    break;
                case 112197485:
                    if (str.equals(Permission.CALL_PHONE)) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (str.equals(Permission.WRITE_CONTACTS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals(Permission.CAMERA)) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (str.equals(Permission.WRITE_CALENDAR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (str.equals(Permission.WRITE_CALL_LOG)) {
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals(Permission.USE_SIP)) {
                        c = 14;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals(Permission.PROCESS_OUTGOING_CALLS)) {
                        c = 15;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals(Permission.GET_ACCOUNTS)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals(Permission.WRITE_EXTERNAL_STORAGE)) {
                        c = 23;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals(Permission.RECORD_AUDIO)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals(Permission.READ_CONTACTS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals(Permission.ADD_VOICEMAIL)) {
                        c = CharUtils.f7473CR;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return m44549a(context);
                case 1:
                    return m44552b(context);
                case 2:
                    return m44553c(context);
                case 3:
                    return m44554d(context);
                case 4:
                    return m44555e(context);
                case 6:
                    return m44556f(context);
                case 7:
                    return m44557g(context);
                case 8:
                    return m44558h(context);
                case 9:
                    return m44559i(context);
                case 11:
                    return m44560j(context);
                case 12:
                    return m44561k(context);
                case 13:
                    return m44562l(context);
                case 14:
                    return m44563m(context);
                case 16:
                    return m44564n(context);
                case 19:
                    return m44565o(context);
                case 22:
                    return m44548a();
                case 23:
                    return m44551b();
                default:
                    return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m44549a(Context context) throws Throwable {
        return new C21693b(context).mo178868a();
    }

    /* renamed from: b */
    private static boolean m44552b(Context context) throws Throwable {
        return new C21694c(context).mo178868a();
    }

    /* renamed from: c */
    private static boolean m44553c(Context context) throws Throwable {
        return new C21697f(context).mo178868a();
    }

    /* renamed from: d */
    private static boolean m44554d(Context context) throws Throwable {
        return new C21698g(context).mo178868a();
    }

    /* renamed from: e */
    private static boolean m44555e(Context context) throws Throwable {
        return new C21699h(context.getContentResolver()).mo178868a();
    }

    /* renamed from: f */
    private static boolean m44556f(Context context) throws Throwable {
        return new C21700i(context).mo178868a();
    }

    /* renamed from: g */
    private static boolean m44557g(Context context) throws Throwable {
        return new C21701j(context).mo178868a();
    }

    /* renamed from: h */
    private static boolean m44558h(Context context) throws Throwable {
        return new C21703l(context).mo178868a();
    }

    /* renamed from: i */
    private static boolean m44559i(Context context) throws Throwable {
        return new C21702k(context).mo178868a();
    }

    /* renamed from: j */
    private static boolean m44560j(Context context) throws Throwable {
        return new C21695d(context).mo178868a();
    }

    /* renamed from: k */
    private static boolean m44561k(Context context) throws Throwable {
        return new C21696e(context).mo178868a();
    }

    /* renamed from: l */
    private static boolean m44562l(Context context) throws Throwable {
        return new C21692a(context).mo178868a();
    }

    /* renamed from: m */
    private static boolean m44563m(Context context) throws Throwable {
        return new C21705n(context).mo178868a();
    }

    /* renamed from: n */
    private static boolean m44564n(Context context) throws Throwable {
        return new C21704m(context).mo178868a();
    }

    /* renamed from: o */
    private static boolean m44565o(Context context) throws Throwable {
        return new C21706o(context).mo178868a();
    }

    /* renamed from: a */
    private static boolean m44548a() throws Throwable {
        return new C21707p().mo178868a();
    }

    /* renamed from: b */
    private static boolean m44551b() throws Throwable {
        return new C21708q().mo178868a();
    }
}
