package com.didi.globalsafetoolkit.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.p006os.ConfigurationCompat;
import com.android.didi.safetoolkit.activity.BaseActivityWithUIStuff;
import com.didi.globalsafetoolkit.BuildConfig;
import com.didi.globalsafetoolkit.dialog.LoadingProgressDialog;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didi.globalsafetoolkit.util.statuslightning.StatusBarLightingCompat;
import com.taxis99.R;
import java.util.Locale;

public abstract class BaseSafeToolkitActivity extends BaseActivityWithUIStuff {
    /* access modifiers changed from: protected */
    public void initObjects() {
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, BuildConfig.LIGHT_STATUS_BAR.booleanValue());
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* renamed from: a */
    private Context m19958a(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            Resources resources = context.getResources();
            Locale locale = ConfigurationCompat.getLocales(SfContextHelper.getContext().getResources().getConfiguration()).get(0);
            Configuration configuration = resources.getConfiguration();
            configuration.setLocale(locale);
            configuration.setLocales(new LocaleList(new Locale[]{locale}));
            return context.createConfigurationContext(configuration);
        } catch (Exception unused) {
            return null;
        }
    }

    public void showPDialog() {
        if (BuildConfig.LOADING_TYPE == BuildConfig.LOADING_TYPE_PROGRESS_DIALOG) {
            LoadingProgressDialog.showDialog(this, SfStringGetter.getString(R.string.sf_loading), false);
        } else {
            super.showPDialog();
        }
    }

    public void closePDialog() {
        if (BuildConfig.LOADING_TYPE == BuildConfig.LOADING_TYPE_PROGRESS_DIALOG) {
            LoadingProgressDialog.dismissProgressDialogFragmentSafely();
        } else {
            super.closePDialog();
        }
    }

    public boolean isDestory() {
        if (Build.VERSION.SDK_INT < 17) {
            return isFinishing();
        }
        return isFinishing() || super.isDestroyed();
    }
}
