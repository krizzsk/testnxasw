package com.didi.global.fintech.cashier.p118ui.util;

import android.app.Activity;
import android.content.Context;
import android.view.ContextThemeWrapper;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.global.fintech.cashier.user.theme.ThemeType;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/util/ThemeManager;", "", "()V", "getContextThemeWrapper", "Landroid/content/Context;", "context", "getCurThemeResId", "", "initTheme", "", "activity", "Landroid/app/Activity;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.util.ThemeManager */
/* compiled from: ThemeManager.kt */
public final class ThemeManager {
    public static final ThemeManager INSTANCE = new ThemeManager();

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.util.ThemeManager$WhenMappings */
    /* compiled from: ThemeManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeType.values().length];
            iArr[ThemeType.THEME_GLOBAL.ordinal()] = 1;
            iArr[ThemeType.THEME_LATOUR.ordinal()] = 2;
            iArr[ThemeType.THEME_99_SODA.ordinal()] = 3;
            iArr[ThemeType.THEME_GLOBAL_SODA.ordinal()] = 4;
            iArr[ThemeType.THEME_99_DRIVER.ordinal()] = 5;
            iArr[ThemeType.THEME_GLOBAL_DRIVER.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ThemeManager() {
    }

    public final void initTheme(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.setTheme(m19246a());
    }

    @JvmStatic
    public static final Context getContextThemeWrapper(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ContextThemeWrapper(context, INSTANCE.m19246a());
    }

    /* renamed from: a */
    private final int m19246a() {
        switch (WhenMappings.$EnumSwitchMapping$0[CashierFacade.Companion.getInstance().getTheme().ordinal()]) {
            case 1:
                return R.style.GlobalCashierActivityTheme_for_global;
            case 2:
                return R.style.GlobalCashierActivityTheme_for_latour;
            case 3:
                return R.style.GlobalCashierActivityTheme_for_99_soda;
            case 4:
                return R.style.GlobalCashierActivityTheme_for_global_soda;
            case 5:
                return R.style.GlobalCashierActivityTheme_for_99_driver;
            case 6:
                return R.style.GlobalCashierActivityTheme_for_global_driver;
            default:
                return R.style.GlobalCashierActivityTheme_for_99;
        }
    }
}
