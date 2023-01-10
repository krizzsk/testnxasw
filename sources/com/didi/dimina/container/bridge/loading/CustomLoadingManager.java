package com.didi.dimina.container.bridge.loading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.didi.dimina.container.p065ui.loadpage.DMCommonLoadingView;
import com.didi.dimina.container.p065ui.loadpage.DMNoTitleLoadingView;
import com.taxis99.R;

public class CustomLoadingManager extends AbsLoadingManager {

    /* renamed from: a */
    private String f18626a;

    /* access modifiers changed from: protected */
    public int getDialogStyle() {
        return R.style.DiminaDialogTransparentBg;
    }

    public CustomLoadingManager(Context context, String str, DMMina dMMina) {
        super(context, dMMina);
        this.f18626a = str;
    }

    public CustomLoadingManager(Context context, DMMina dMMina) {
        super(context, dMMina);
    }

    /* access modifiers changed from: protected */
    public View getLoadingView() {
        try {
            if (TextUtils.isEmpty(this.f18626a)) {
                Class<? extends DMNoTitleLoadingView> noTitleLoadingViewClazz = this.mDMMina.getConfig().getUIConfig().getNoTitleLoadingViewClazz();
                Class[] clsArr = {Context.class};
                return (DMNoTitleLoadingView) noTitleLoadingViewClazz.getConstructor(clsArr).newInstance(new Object[]{this.mContext});
            }
            Class<? extends DMCommonLoadingView> commonLoadingViewClazz = this.mDMMina.getConfig().getUIConfig().getCommonLoadingViewClazz();
            Class[] clsArr2 = {Context.class, String.class};
            return (DMCommonLoadingView) commonLoadingViewClazz.getConstructor(clsArr2).newInstance(new Object[]{this.mContext, this.f18626a});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
