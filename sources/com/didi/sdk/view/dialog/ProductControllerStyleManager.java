package com.didi.sdk.view.dialog;

import android.content.Context;
import com.taxis99.R;
import java.util.Locale;

public class ProductControllerStyleManager {

    /* renamed from: a */
    private static ProductControllerStyleManager f40696a;

    /* renamed from: b */
    private Context f40697b;

    /* renamed from: c */
    private ProductThemeStyle f40698c = new ProductThemeStyle();

    /* renamed from: d */
    private LocaleDelegate f40699d;

    public void setLocaleDelegate(LocaleDelegate localeDelegate) {
        this.f40699d = localeDelegate;
    }

    public LocaleDelegate getLocaleDelegate() {
        LocaleDelegate localeDelegate = this.f40699d;
        return localeDelegate == null ? new LocaleDelegate() {
            public Locale getLocale() {
                return Locale.getDefault();
            }
        } : localeDelegate;
    }

    private ProductControllerStyleManager() {
    }

    public void init(Context context) {
        this.f40697b = context;
        this.f40698c.setDefaultButtonTextColor(context.getResources().getColor(R.color.common_dialog_recommend_option_txt_color));
        this.f40698c.setProductBasicColor(this.f40697b.getResources().getColor(R.color.orange));
    }

    public static ProductControllerStyleManager getInstance() {
        if (f40696a == null) {
            f40696a = new ProductControllerStyleManager();
        }
        return f40696a;
    }

    public void setProductThemeStyle(ProductThemeStyle productThemeStyle) {
        this.f40698c = productThemeStyle;
    }

    public ProductThemeStyle getProductThemeStyle() {
        return this.f40698c;
    }
}
