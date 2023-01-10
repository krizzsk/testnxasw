package com.didi.global.fintech.cashier.user.facade;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.base.module.GlobalCashierModuleType;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.global.fintech.cashier.user.theme.ThemeType;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J,\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H&J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH&J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J*\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\"\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010#H&J\"\u0010\"\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010#H&J*\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J*\u0010$\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010'\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010(H&¨\u0006)"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/user/facade/ICashierFacade;", "", "getParamByModuleSync", "", "moduleType", "Lcom/didi/global/fintech/cashier/base/module/GlobalCashierModuleType;", "paramName", "args", "getParamListByModuleSync", "", "getSdkVersion", "go2PayMethodSelPage", "", "activity", "Landroid/app/Activity;", "requestCode", "", "param", "Lcom/didi/global/fintech/cashier/user/model/CashierParam;", "fragment", "Landroidx/fragment/app/Fragment;", "init", "application", "Landroid/app/Application;", "theme", "Lcom/didi/global/fintech/cashier/user/theme/ThemeType;", "config", "Lcom/didi/global/fintech/cashier/user/facade/CashierInitConfig;", "launch", "listener", "Lcom/didi/global/fintech/cashier/user/facade/CashierLaunchListener;", "launchCustomCashier", "intent", "Landroid/content/Intent;", "launchForCashierResult", "Lcom/didi/global/fintech/cashier/user/facade/CashierResultListener;", "launchForResult", "pay", "Landroidx/fragment/app/FragmentActivity;", "updateConfigurationProxy", "Lcom/didi/global/fintech/cashier/user/facade/CashierConfigurationProxy;", "cashier_user_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: ICashierFacade.kt */
public interface ICashierFacade {
    String getParamByModuleSync(GlobalCashierModuleType globalCashierModuleType, String str, String str2);

    List<String> getParamListByModuleSync(GlobalCashierModuleType globalCashierModuleType, String str, String str2);

    String getSdkVersion();

    void go2PayMethodSelPage(Activity activity, int i, CashierParam cashierParam);

    void go2PayMethodSelPage(Fragment fragment, int i, CashierParam cashierParam);

    void init(Application application, ThemeType themeType, CashierInitConfig cashierInitConfig);

    void launch(Activity activity, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener);

    void launch(Fragment fragment, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener);

    void launchCustomCashier(Activity activity, Intent intent, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener);

    void launchForCashierResult(Activity activity, CashierParam cashierParam, CashierResultListener cashierResultListener);

    void launchForCashierResult(Fragment fragment, CashierParam cashierParam, CashierResultListener cashierResultListener);

    void launchForResult(Activity activity, int i, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener);

    void launchForResult(Fragment fragment, int i, CashierParam cashierParam, CashierLaunchListener cashierLaunchListener);

    void pay(FragmentActivity fragmentActivity, CashierParam cashierParam);

    void updateConfigurationProxy(CashierConfigurationProxy cashierConfigurationProxy);

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: ICashierFacade.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ String getParamByModuleSync$default(ICashierFacade iCashierFacade, GlobalCashierModuleType globalCashierModuleType, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return iCashierFacade.getParamByModuleSync(globalCashierModuleType, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getParamByModuleSync");
        }

        public static /* synthetic */ List getParamListByModuleSync$default(ICashierFacade iCashierFacade, GlobalCashierModuleType globalCashierModuleType, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = null;
                }
                return iCashierFacade.getParamListByModuleSync(globalCashierModuleType, str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getParamListByModuleSync");
        }
    }
}
