package com.didi.unifylogin.spi;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.domainservice.model.AbsDomainSuffixModel;

public class CompassRequestService {

    /* renamed from: a */
    private static CompassRequestInterface f47525a;

    public static void compassRequestBegin() {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            a.compassRequestBegin();
        }
    }

    public static void compassResponse(String str) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            a.compassResponse(str);
        }
    }

    public static boolean cacheDomainSuffix(Context context, String str) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            return a.cacheDomainSuffix(context, str);
        }
        return false;
    }

    public static boolean cacheDomainSuffixModel(Context context, AbsDomainSuffixModel absDomainSuffixModel) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            return a.cacheDomainSuffixModel(context, absDomainSuffixModel);
        }
        return false;
    }

    public static void removeDomainSuffixModel(Context context, String str) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            a.removeDomainSuffixModel(context, str);
        }
    }

    public static String getCacheDomainSuffix(Context context, String str) {
        CompassRequestInterface a = m35677a();
        return a != null ? a.getCacheDomainSuffix(context, str) : str;
    }

    public static AbsDomainSuffixModel getCacheDomainSuffixModel(Context context, String str, String str2) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            return a.getCacheDomainSuffixModel(context, str, str2);
        }
        return null;
    }

    public static boolean isSupportDynamicDomain(Context context) {
        CompassRequestInterface a = m35677a();
        if (a != null) {
            return a.isDynamicDomainSupport(context);
        }
        return false;
    }

    /* renamed from: a */
    private static CompassRequestInterface m35677a() {
        if (f47525a == null) {
            synchronized (CompassRequestService.class) {
                if (f47525a == null) {
                    f47525a = (CompassRequestInterface) ServiceLoader.load(CompassRequestInterface.class).get();
                }
            }
        }
        return f47525a;
    }
}
