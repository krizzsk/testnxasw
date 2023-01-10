package com.didi.payment.wallet_ui.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010-\u001a\u00020.2\u0014\u0010/\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001d\u0018\u000100J\u0014\u00101\u001a\u00020.2\f\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dJ\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u001d0\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\u001a\u0010+\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020,0\u001fX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/OptionWheelBuilder;", "", "()V", "cancelClick", "Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;", "getCancelClick", "()Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;", "setCancelClick", "(Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;)V", "confirmClick", "getConfirmClick", "setConfirmClick", "confirmText", "", "getConfirmText", "()Ljava/lang/CharSequence;", "setConfirmText", "(Ljava/lang/CharSequence;)V", "deleteText", "getDeleteText", "setDeleteText", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "getDialog", "()Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "setDialog", "(Lcom/didi/payment/wallet_ui/dialog/WalletDialog;)V", "optionList", "", "Lcom/didi/payment/wallet_ui/wheel/OptionWheelAdapter;", "resultMap", "", "", "", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "title", "getTitle", "setTitle", "viewMap", "Lcom/contrarywind/view/WheelView;", "addAllItem", "", "list", "", "addItem", "option", "build", "Lcom/didi/payment/wallet_ui/wheel/WalletWheel;", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OptionWheelBuilder.kt */
public final class OptionWheelBuilder {

    /* renamed from: a */
    private final List<OptionWheelAdapter<?>> f35747a = new ArrayList();

    /* renamed from: b */
    private final Map<String, WheelView> f35748b = new LinkedHashMap();

    /* renamed from: c */
    private WalletDialog f35749c;

    /* renamed from: d */
    private boolean f35750d;

    /* renamed from: e */
    private CharSequence f35751e;

    /* renamed from: f */
    private OnOptionWheelClick f35752f;

    /* renamed from: g */
    private CharSequence f35753g;

    /* renamed from: h */
    private OnOptionWheelClick f35754h;

    /* renamed from: i */
    private CharSequence f35755i;

    /* renamed from: j */
    private final Map<String, Integer> f35756j = new LinkedHashMap();

    public final WalletDialog getDialog() {
        return this.f35749c;
    }

    public final void setDialog(WalletDialog walletDialog) {
        this.f35749c = walletDialog;
    }

    public final boolean getShowDelete() {
        return this.f35750d;
    }

    public final void setShowDelete(boolean z) {
        this.f35750d = z;
    }

    public final CharSequence getDeleteText() {
        return this.f35751e;
    }

    public final void setDeleteText(CharSequence charSequence) {
        this.f35751e = charSequence;
    }

    public final OnOptionWheelClick getCancelClick() {
        return this.f35752f;
    }

    public final void setCancelClick(OnOptionWheelClick onOptionWheelClick) {
        this.f35752f = onOptionWheelClick;
    }

    public final CharSequence getConfirmText() {
        return this.f35753g;
    }

    public final void setConfirmText(CharSequence charSequence) {
        this.f35753g = charSequence;
    }

    public final OnOptionWheelClick getConfirmClick() {
        return this.f35754h;
    }

    public final void setConfirmClick(OnOptionWheelClick onOptionWheelClick) {
        this.f35754h = onOptionWheelClick;
    }

    public final CharSequence getTitle() {
        return this.f35755i;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f35755i = charSequence;
    }

    public final void addItem(OptionWheelAdapter<?> optionWheelAdapter) {
        if (optionWheelAdapter != null) {
            this.f35747a.add(optionWheelAdapter);
        }
    }

    public final void addAllItem(List<? extends OptionWheelAdapter<?>> list) {
        if (list != null && !list.isEmpty()) {
            for (OptionWheelAdapter addItem : list) {
                addItem(addItem);
            }
        }
    }

    public final WalletWheel build(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f35747a.isEmpty()) {
            return null;
        }
        WalletWheel walletWheel = new WalletWheel(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        for (OptionWheelAdapter next : this.f35747a) {
            if (next != null) {
                WheelView addItem$default = WalletWheel.addItem$default(walletWheel, false, false, 3, (Object) null);
                this.f35748b.put(next.getKey(), addItem$default);
                addItem$default.setAdapter(next);
                addItem$default.setCurrentItem(next.getInitSelectedIndex());
                this.f35756j.put(next.getKey(), Integer.valueOf(next.getInitSelectedIndex()));
                addItem$default.setOnItemSelectedListener(new OnItemSelectedListener(next) {
                    public final /* synthetic */ OptionWheelAdapter f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onItemSelected(int i) {
                        OptionWheelBuilder.m26925a(OptionWheelBuilder.this, this.f$1, i);
                    }
                });
            }
        }
        walletWheel.configDelete(getShowDelete(), getDeleteText(), new View.OnClickListener() {
            public final void onClick(View view) {
                OptionWheelBuilder.m26924a(OptionWheelBuilder.this, view);
            }
        });
        walletWheel.configCancelClick(new View.OnClickListener() {
            public final void onClick(View view) {
                OptionWheelBuilder.m26926b(OptionWheelBuilder.this, view);
            }
        });
        walletWheel.configTitle(getTitle());
        walletWheel.configConfirm(getConfirmText(), new View.OnClickListener() {
            public final void onClick(View view) {
                OptionWheelBuilder.m26927c(OptionWheelBuilder.this, view);
            }
        });
        return walletWheel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26925a(OptionWheelBuilder optionWheelBuilder, OptionWheelAdapter optionWheelAdapter, int i) {
        Intrinsics.checkNotNullParameter(optionWheelBuilder, "this$0");
        optionWheelBuilder.f35756j.put(optionWheelAdapter.getKey(), Integer.valueOf(i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26924a(OptionWheelBuilder optionWheelBuilder, View view) {
        WheelView wheelView;
        Intrinsics.checkNotNullParameter(optionWheelBuilder, "this$0");
        for (OptionWheelAdapter next : optionWheelBuilder.f35747a) {
            if (!(next == null || (wheelView = optionWheelBuilder.f35748b.get(next.getKey())) == null)) {
                wheelView.setCurrentItem(next.getInitSelectedIndex());
                optionWheelBuilder.f35756j.put(next.getKey(), Integer.valueOf(next.getInitSelectedIndex()));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26926b(OptionWheelBuilder optionWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(optionWheelBuilder, "this$0");
        WalletDialog dialog = optionWheelBuilder.getDialog();
        if (dialog != null) {
            OnOptionWheelClick cancelClick = optionWheelBuilder.getCancelClick();
            if (!(cancelClick == null ? true : cancelClick.onClick(optionWheelBuilder.f35756j))) {
                dialog = null;
            }
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m26927c(OptionWheelBuilder optionWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(optionWheelBuilder, "this$0");
        WalletDialog dialog = optionWheelBuilder.getDialog();
        if (dialog != null) {
            if (optionWheelBuilder.getConfirmClick() == null) {
                dialog.dismiss();
                return;
            }
            OnOptionWheelClick confirmClick = optionWheelBuilder.getConfirmClick();
            boolean z = false;
            if (confirmClick != null && !confirmClick.onClick(optionWheelBuilder.f35756j)) {
                z = true;
            }
            if (!z) {
                dialog.dismiss();
            }
        }
    }
}
