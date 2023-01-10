package com.didi.global.fintech.cashier.soda.processor;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.utils.CashierLog;
import com.didi.global.fintech.cashier.p118ui.widget.GlobalCashierLoadingView;
import com.didi.sdk.util.UiThreadHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncLoadingProcessor;", "Lcom/didi/global/fintech/cashier/core/api/ICashierOperateProcessor;", "context", "Landroid/content/Context;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)V", "isDestroyed", "", "loadingView", "Lcom/didi/global/fintech/cashier/ui/widget/GlobalCashierLoadingView;", "dismissLoading", "", "loading", "cancelable", "duration", "", "Companion", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaSyncLoadingProcessor.kt */
public final class SodaSyncLoadingProcessor implements ICashierOperateProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f23549e = "SodaSyncLoadingProcessor";

    /* renamed from: a */
    private final Context f23550a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final LifecycleOwner f23551b;

    /* renamed from: c */
    private final GlobalCashierLoadingView f23552c = new GlobalCashierLoadingView(false, 1, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f23553d;

    public SodaSyncLoadingProcessor(Context context, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.f23550a = context;
        this.f23551b = lifecycleOwner;
        this.f23551b.getLifecycle().addObserver(new DefaultLifecycleObserver(this) {
            final /* synthetic */ SodaSyncLoadingProcessor this$0;

            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
            }

            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
            }

            {
                this.this$0 = r1;
            }

            public void onDestroy(LifecycleOwner lifecycleOwner) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
                CashierLog.INSTANCE.mo68928i("SodaSyncLoadingProcessor onDestroy");
                this.this$0.f23553d = true;
                this.this$0.f23551b.getLifecycle().removeObserver(this);
            }
        });
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/processor/SodaSyncLoadingProcessor$Companion;", "", "()V", "TAG", "", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaSyncLoadingProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void loading(boolean z, long j) {
        if (this.f23553d) {
            CashierLog.INSTANCE.mo68928i("SodaSyncLoadingProcessor lifecycleOwner is Destroyed");
            return;
        }
        CashierLog.INSTANCE.mo68928i("SodaSyncLoadingProcessor loading start");
        UiThreadHandler.post(new Runnable(z, j) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ long f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                SodaSyncLoadingProcessor.m19225a(SodaSyncLoadingProcessor.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19225a(SodaSyncLoadingProcessor sodaSyncLoadingProcessor, boolean z, long j) {
        Intrinsics.checkNotNullParameter(sodaSyncLoadingProcessor, "this$0");
        if (sodaSyncLoadingProcessor.f23552c.isVisible()) {
            sodaSyncLoadingProcessor = null;
        }
        if (sodaSyncLoadingProcessor != null) {
            FragmentActivity fragmentActivity = (FragmentActivity) sodaSyncLoadingProcessor.f23550a;
            FragmentManager supportFragmentManager = fragmentActivity == null ? null : fragmentActivity.getSupportFragmentManager();
            GlobalCashierLoadingView globalCashierLoadingView = sodaSyncLoadingProcessor.f23552c;
            globalCashierLoadingView.setCancelable(z);
            GlobalCashierLoadingView globalCashierLoadingView2 = (j > 0 ? 1 : (j == 0 ? 0 : -1)) == 0 ? globalCashierLoadingView : null;
            if (globalCashierLoadingView2 == null) {
                globalCashierLoadingView2 = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it");
                globalCashierLoadingView2.show(supportFragmentManager, (String) null);
            }
            if (globalCashierLoadingView2 == null) {
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it");
                globalCashierLoadingView.showDuration(j, supportFragmentManager, (String) null);
            }
        }
    }

    public void dismissLoading() {
        this.f23552c.dismissAllowingStateLoss();
    }
}
