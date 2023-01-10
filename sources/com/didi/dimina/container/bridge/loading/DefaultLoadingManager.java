package com.didi.dimina.container.bridge.loading;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.p065ui.dialog.LoadingView;
import com.didi.dimina.container.p065ui.loadpage.AbsLoadingManager;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/dimina/container/bridge/loading/DefaultLoadingManager;", "Lcom/didi/dimina/container/ui/loadpage/AbsLoadingManager;", "mContext", "Landroid/content/Context;", "mTitle", "", "mina", "Lcom/didi/dimina/container/DMMina;", "(Landroid/content/Context;Ljava/lang/String;Lcom/didi/dimina/container/DMMina;)V", "getMTitle", "()Ljava/lang/String;", "setMTitle", "(Ljava/lang/String;)V", "getDialogStyle", "", "getLoadingView", "Landroid/view/View;", "container_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: DefaultLoadingManager.kt */
public final class DefaultLoadingManager extends AbsLoadingManager {

    /* renamed from: a */
    private String f18627a;

    /* access modifiers changed from: protected */
    public int getDialogStyle() {
        return R.style.DiminaDialogNoBg;
    }

    public DefaultLoadingManager(Context context, String str, DMMina dMMina) {
        super(context, dMMina);
        this.f18627a = str;
        if (TextUtils.isEmpty(str)) {
            this.f18627a = context != null ? context.getString(R.string.dimina_page_loading_process_tip) : null;
        }
    }

    public final String getMTitle() {
        return this.f18627a;
    }

    public final void setMTitle(String str) {
        this.f18627a = str;
    }

    /* access modifiers changed from: protected */
    public View getLoadingView() {
        LoadingView loadingView = new LoadingView(this.mContext);
        loadingView.setMessage(this.f18627a);
        return loadingView;
    }
}
