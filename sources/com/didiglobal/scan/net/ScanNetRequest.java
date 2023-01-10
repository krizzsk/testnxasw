package com.didiglobal.scan.net;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest;", "", "()V", "ABILITY_SCAN", "", "gson", "Lcom/google/gson/Gson;", "request", "", "context", "Landroid/content/Context;", "from", "Lcom/didiglobal/scan/GlobalScan$ScanFrom;", "scanUrl", "userType", "", "loadingDelegate", "Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "errorDelegate", "Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "transActionType", "Lcom/didiglobal/scan/delegate/ScanSchemeDispatcherDelegate$ActionType;", "actionType", "ErrorActionDelegate", "LoadingDelegate", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ScanNetRequest.kt */
public final class ScanNetRequest {
    public static final ScanNetRequest INSTANCE = new ScanNetRequest();

    /* renamed from: a */
    private static final String f53901a = "commonApi/pGetScanResult";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Gson f53902b = new Gson();

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo148868d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest$LoadingDelegate;", "", "hideLoading", "", "showLoading", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ScanNetRequest.kt */
    public interface LoadingDelegate {
        void hideLoading();

        void showLoading();
    }

    private ScanNetRequest() {
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, mo148868d2 = {"Lcom/didiglobal/scan/net/ScanNetRequest$ErrorActionDelegate;", "", "showError", "", "error", "", "title", "buttonTitle", "scheme", "actionType", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: ScanNetRequest.kt */
    public interface ErrorActionDelegate {
        void showError(String str, String str2, String str3, String str4, String str5);

        @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
        /* compiled from: ScanNetRequest.kt */
        public static final class DefaultImpls {
            public static /* synthetic */ void showError$default(ErrorActionDelegate errorActionDelegate, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
                if (obj == null) {
                    if ((i & 8) != 0) {
                        str4 = null;
                    }
                    errorActionDelegate.showError(str, str2, str3, str4, str5);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showError");
            }
        }
    }

    public final void request(Context context, GlobalScan.ScanFrom scanFrom, String str, int i, LoadingDelegate loadingDelegate, ErrorActionDelegate errorActionDelegate) {
        Intrinsics.checkParameterIsNotNull(scanFrom, "from");
        Intrinsics.checkParameterIsNotNull(str, "scanUrl");
        if (context != null) {
            if (loadingDelegate != null) {
                loadingDelegate.showLoading();
            }
            IBffProxy.Ability.Builder builder = new IBffProxy.Ability.Builder(context, f53901a);
            HashMap hashMap = new HashMap();
            hashMap.put("scan_url", str);
            hashMap.put("from", scanFrom.getFrom());
            hashMap.put(ParamKeys.PARAM_USER_TYPE, Integer.valueOf(i));
            Bff.call(builder.setParams(hashMap).setCallback(new ScanNetRequest$request$ability$2(loadingDelegate, errorActionDelegate, context)).build());
        }
    }

    public final ScanSchemeDispatcherDelegate.ActionType transActionType(String str) {
        Intrinsics.checkParameterIsNotNull(str, SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        int hashCode = str.hashCode();
        if (hashCode != -558860276) {
            if (hashCode != -503752126) {
                if (hashCode == 1471807280 && str.equals("cashiercode")) {
                    return ScanSchemeDispatcherDelegate.ActionType.CASHIERCODE;
                }
            } else if (str.equals("openride")) {
                return ScanSchemeDispatcherDelegate.ActionType.OPENRIDE;
            }
        } else if (str.equals("pixcode")) {
            return ScanSchemeDispatcherDelegate.ActionType.PIX;
        }
        return ScanSchemeDispatcherDelegate.ActionType.NONE;
    }
}
