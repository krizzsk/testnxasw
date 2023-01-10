package com.didi.payment.wallet_ui.push;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.push.WalletPushManager;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo148867d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/push/WalletPushManager;", "", "()V", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletPushManager.kt */
public final class WalletPushManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static boolean f35684a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Set<WalletPushInfo> f35685b = new LinkedHashSet();

    @Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J&\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002JD\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0007J\u0012\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/push/WalletPushManager$Companion;", "", "()V", "isPushShow", "", "pushList", "", "Lcom/didi/payment/wallet_ui/push/WalletPushInfo;", "addPush", "", "pushInfo", "title", "", "subTitle", "router", "", "configPush", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "context", "Landroid/content/Context;", "cancelOnBack", "cancelOnTouchOutside", "showPushDialog", "activity", "Landroid/app/Activity;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletPushManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void addPush(WalletPushInfo walletPushInfo) {
            if (walletPushInfo != null && !TextUtils.isEmpty(walletPushInfo.getTitle()) && !TextUtils.isEmpty(walletPushInfo.getSubTitle()) && !TextUtils.isEmpty(walletPushInfo.getRouter())) {
                WalletPushManager.f35685b.add(walletPushInfo);
                showPushDialog();
            }
        }

        public final void addPush(CharSequence charSequence, CharSequence charSequence2, String str) {
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2) && !TextUtils.isEmpty(str)) {
                WalletPushManager.f35685b.add(new WalletPushInfo(charSequence, charSequence2, str, false, false, 24, (DefaultConstructorMarker) null));
                showPushDialog();
            }
        }

        public final void showPushDialog() {
            WeakReference<Activity> topActivityReference = WalletPushLifecycle.Companion.getTopActivityReference();
            showPushDialog(topActivityReference == null ? null : (Activity) topActivityReference.get());
        }

        public final void showPushDialog(Activity activity) {
            if (!WalletPushManager.f35685b.isEmpty() && activity != null && !activity.isFinishing() && !WalletPushManager.f35684a) {
                WalletPushManager.f35684a = true;
                WalletPushInfo walletPushInfo = (WalletPushInfo) CollectionsKt.firstOrNull(WalletPushManager.f35685b);
                WalletDialog configPush = WalletPushManager.Companion.configPush(activity, walletPushInfo);
                if (configPush != null) {
                    configPush.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        public final void onDismiss(DialogInterface dialogInterface) {
                            WalletPushManager.Companion.m47117showPushDialog$lambda2$lambda1$lambda0(WalletPushInfo.this, dialogInterface);
                        }
                    });
                    SystemUtils.showDialog(configPush);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: showPushDialog$lambda-2$lambda-1$lambda-0  reason: not valid java name */
        public static final void m47117showPushDialog$lambda2$lambda1$lambda0(WalletPushInfo walletPushInfo, DialogInterface dialogInterface) {
            Companion companion = WalletPushManager.Companion;
            WalletPushManager.f35684a = false;
            Collection access$getPushList$cp = WalletPushManager.f35685b;
            if (access$getPushList$cp != null) {
                TypeIntrinsics.asMutableCollection(access$getPushList$cp).remove(walletPushInfo);
                WalletPushManager.Companion.showPushDialog();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        }

        private final WalletDialog configPush(Context context, WalletPushInfo walletPushInfo) {
            CharSequence charSequence;
            boolean z;
            boolean z2;
            String str = null;
            CharSequence title = walletPushInfo == null ? null : walletPushInfo.getTitle();
            if (walletPushInfo == null) {
                charSequence = null;
            } else {
                charSequence = walletPushInfo.getSubTitle();
            }
            if (walletPushInfo != null) {
                str = walletPushInfo.getRouter();
            }
            String str2 = str;
            if (walletPushInfo == null) {
                z = true;
            } else {
                z = walletPushInfo.getCancelOnBack();
            }
            if (walletPushInfo == null) {
                z2 = true;
            } else {
                z2 = walletPushInfo.getCancelOnTouchOutside();
            }
            return configPush(context, title, charSequence, str2, z, z2);
        }

        static /* synthetic */ WalletDialog configPush$default(Companion companion, Context context, CharSequence charSequence, CharSequence charSequence2, String str, boolean z, boolean z2, int i, Object obj) {
            return companion.configPush(context, charSequence, charSequence2, str, (i & 16) != 0 ? true : z, (i & 32) != 0 ? true : z2);
        }

        private final WalletDialog configPush(Context context, CharSequence charSequence, CharSequence charSequence2, String str, boolean z, boolean z2) {
            CharSequence charSequence3 = charSequence;
            CharSequence charSequence4 = charSequence2;
            String str2 = str;
            if (charSequence3 == null || charSequence4 == null || str2 == null) {
                return null;
            }
            WalletDialog create$default = WalletDialog.Companion.create$default(WalletDialog.Companion, context, -1, 0, 48, false, z, z2, R.style.WalletDialogPushAnim, R.style.WalletLoadingDialog, 20, (Object) null);
            WalletPush walletPush = new WalletPush(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletPush.config(charSequence3, charSequence4);
            walletPush.setOnClickListener(new View.OnClickListener(str2, context, create$default) {
                public final /* synthetic */ String f$0;
                public final /* synthetic */ Context f$1;
                public final /* synthetic */ WalletDialog f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    WalletPushManager.Companion.m47116configPush$lambda5$lambda4$lambda3(this.f$0, this.f$1, this.f$2, view);
                }
            });
            Unit unit = Unit.INSTANCE;
            create$default.setContentView((View) walletPush);
            return create$default;
        }

        /* access modifiers changed from: private */
        /* renamed from: configPush$lambda-5$lambda-4$lambda-3  reason: not valid java name */
        public static final void m47116configPush$lambda5$lambda4$lambda3(String str, Context context, WalletDialog walletDialog, View view) {
            Intrinsics.checkNotNullParameter(context, "$context");
            Intrinsics.checkNotNullParameter(walletDialog, "$this_apply");
            DRouter.build(str).start(context);
            walletDialog.dismiss();
        }
    }
}
