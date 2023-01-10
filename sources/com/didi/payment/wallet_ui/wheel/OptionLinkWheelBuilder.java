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

@Metadata(mo148867d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u00103\u001a\u0002042\u0014\u00105\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010&\u0018\u000106J\u0014\u00107\u001a\u0002042\f\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u00010&J\u0010\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020 H\u0002J\u001e\u0010>\u001a\u0002042\b\u0010?\u001a\u0004\u0018\u0001022\n\u0010@\u001a\u0006\u0012\u0002\b\u00030&H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010&0)X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001c\u0010.\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010\u0015R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/OptionLinkWheelBuilder;", "", "()V", "cancelClick", "Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;", "getCancelClick", "()Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;", "setCancelClick", "(Lcom/didi/payment/wallet_ui/wheel/OnOptionWheelClick;)V", "childSelectedMap", "", "", "", "confirmClick", "getConfirmClick", "setConfirmClick", "confirmText", "", "getConfirmText", "()Ljava/lang/CharSequence;", "setConfirmText", "(Ljava/lang/CharSequence;)V", "deleteText", "getDeleteText", "setDeleteText", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "getDialog", "()Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "setDialog", "(Lcom/didi/payment/wallet_ui/dialog/WalletDialog;)V", "keepLastSelected", "", "getKeepLastSelected", "()Z", "setKeepLastSelected", "(Z)V", "keyOptionAdapterMap", "Lcom/didi/payment/wallet_ui/wheel/LinkageWheelAdapter;", "linkageMap", "optionList", "", "resultMap", "showDelete", "getShowDelete", "setShowDelete", "title", "getTitle", "setTitle", "viewMap", "Lcom/contrarywind/view/WheelView;", "addAllItem", "", "list", "", "addItem", "option", "build", "Lcom/didi/payment/wallet_ui/wheel/WalletWheel;", "context", "Landroid/content/Context;", "checkOption", "initView", "wheelView", "optionAdapter", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OptionLinkWheelBuilder.kt */
public final class OptionLinkWheelBuilder {

    /* renamed from: a */
    private final List<LinkageWheelAdapter<?>> f35733a = new ArrayList();

    /* renamed from: b */
    private final Map<String, WheelView> f35734b = new LinkedHashMap();

    /* renamed from: c */
    private final Map<String, Integer> f35735c = new LinkedHashMap();

    /* renamed from: d */
    private WalletDialog f35736d;

    /* renamed from: e */
    private boolean f35737e;

    /* renamed from: f */
    private CharSequence f35738f;

    /* renamed from: g */
    private OnOptionWheelClick f35739g;

    /* renamed from: h */
    private CharSequence f35740h;

    /* renamed from: i */
    private OnOptionWheelClick f35741i;

    /* renamed from: j */
    private boolean f35742j;

    /* renamed from: k */
    private CharSequence f35743k;

    /* renamed from: l */
    private final Map<String, Integer> f35744l = new LinkedHashMap();

    /* renamed from: m */
    private final Map<String, String> f35745m = new LinkedHashMap();

    /* renamed from: n */
    private final Map<String, LinkageWheelAdapter<?>> f35746n = new LinkedHashMap();

    public final WalletDialog getDialog() {
        return this.f35736d;
    }

    public final void setDialog(WalletDialog walletDialog) {
        this.f35736d = walletDialog;
    }

    public final boolean getShowDelete() {
        return this.f35737e;
    }

    public final void setShowDelete(boolean z) {
        this.f35737e = z;
    }

    public final CharSequence getDeleteText() {
        return this.f35738f;
    }

    public final void setDeleteText(CharSequence charSequence) {
        this.f35738f = charSequence;
    }

    public final OnOptionWheelClick getCancelClick() {
        return this.f35739g;
    }

    public final void setCancelClick(OnOptionWheelClick onOptionWheelClick) {
        this.f35739g = onOptionWheelClick;
    }

    public final CharSequence getConfirmText() {
        return this.f35740h;
    }

    public final void setConfirmText(CharSequence charSequence) {
        this.f35740h = charSequence;
    }

    public final OnOptionWheelClick getConfirmClick() {
        return this.f35741i;
    }

    public final void setConfirmClick(OnOptionWheelClick onOptionWheelClick) {
        this.f35741i = onOptionWheelClick;
    }

    public final boolean getKeepLastSelected() {
        return this.f35742j;
    }

    public final void setKeepLastSelected(boolean z) {
        this.f35742j = z;
    }

    public final CharSequence getTitle() {
        return this.f35743k;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f35743k = charSequence;
    }

    public final void addItem(LinkageWheelAdapter<?> linkageWheelAdapter) {
        this.f35733a.add(linkageWheelAdapter);
    }

    public final void addAllItem(List<? extends LinkageWheelAdapter<?>> list) {
        if (list != null && !list.isEmpty()) {
            for (LinkageWheelAdapter addItem : list) {
                addItem(addItem);
            }
        }
    }

    public final WalletWheel build(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!m26921a()) {
            return null;
        }
        WalletWheel walletWheel = new WalletWheel(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        for (String str : this.f35745m.keySet()) {
            LinkageWheelAdapter linkageWheelAdapter = this.f35746n.get(str);
            if (linkageWheelAdapter != null) {
                WheelView addItem$default = WalletWheel.addItem$default(walletWheel, false, false, 3, (Object) null);
                this.f35734b.put(linkageWheelAdapter.getKey(), addItem$default);
                m26918a(addItem$default, (LinkageWheelAdapter<?>) linkageWheelAdapter);
                addItem$default.setOnItemSelectedListener(new OnItemSelectedListener(linkageWheelAdapter) {
                    public final /* synthetic */ LinkageWheelAdapter f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onItemSelected(int i) {
                        OptionLinkWheelBuilder.m26920a(OptionLinkWheelBuilder.this, this.f$1, i);
                    }
                });
            }
        }
        walletWheel.configDelete(getShowDelete(), getDeleteText(), new View.OnClickListener() {
            public final void onClick(View view) {
                OptionLinkWheelBuilder.m26919a(OptionLinkWheelBuilder.this, view);
            }
        });
        walletWheel.configCancelClick(new View.OnClickListener() {
            public final void onClick(View view) {
                OptionLinkWheelBuilder.m26922b(OptionLinkWheelBuilder.this, view);
            }
        });
        walletWheel.configTitle(getTitle());
        walletWheel.configConfirm(getConfirmText(), new View.OnClickListener() {
            public final void onClick(View view) {
                OptionLinkWheelBuilder.m26923c(OptionLinkWheelBuilder.this, view);
            }
        });
        return walletWheel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26920a(OptionLinkWheelBuilder optionLinkWheelBuilder, LinkageWheelAdapter linkageWheelAdapter, int i) {
        WheelView wheelView;
        Intrinsics.checkNotNullParameter(optionLinkWheelBuilder, "this$0");
        Intrinsics.checkNotNullParameter(linkageWheelAdapter, "$optionAdapter");
        optionLinkWheelBuilder.f35735c.put(linkageWheelAdapter.getKey(), Integer.valueOf(i));
        LinkageWheelAdapter linkageWheelAdapter2 = optionLinkWheelBuilder.f35746n.get(linkageWheelAdapter.getLinkageKey());
        if (linkageWheelAdapter2 != null && (wheelView = optionLinkWheelBuilder.f35734b.get(linkageWheelAdapter2.getKey())) != null) {
            linkageWheelAdapter2.setSelectedRootIndex$wallet_ui_globalRelease(i);
            int i2 = 0;
            if (optionLinkWheelBuilder.getKeepLastSelected()) {
                Map<String, Integer> map = optionLinkWheelBuilder.f35744l;
                Integer num = map.get(linkageWheelAdapter2.getRootKey() + ':' + i);
                if (num != null) {
                    i2 = num.intValue();
                }
            }
            wheelView.setCurrentItem(i2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26919a(OptionLinkWheelBuilder optionLinkWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(optionLinkWheelBuilder, "this$0");
        for (Map.Entry next : optionLinkWheelBuilder.f35734b.entrySet()) {
            LinkageWheelAdapter linkageWheelAdapter = optionLinkWheelBuilder.f35746n.get(next.getKey());
            if (linkageWheelAdapter != null) {
                optionLinkWheelBuilder.m26918a((WheelView) next.getValue(), (LinkageWheelAdapter<?>) linkageWheelAdapter);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26922b(OptionLinkWheelBuilder optionLinkWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(optionLinkWheelBuilder, "this$0");
        WalletDialog dialog = optionLinkWheelBuilder.getDialog();
        if (dialog != null) {
            OnOptionWheelClick cancelClick = optionLinkWheelBuilder.getCancelClick();
            if (!(cancelClick == null ? true : cancelClick.onClick(optionLinkWheelBuilder.f35735c))) {
                dialog = null;
            }
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m26923c(OptionLinkWheelBuilder optionLinkWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(optionLinkWheelBuilder, "this$0");
        WalletDialog dialog = optionLinkWheelBuilder.getDialog();
        if (dialog != null) {
            if (optionLinkWheelBuilder.getConfirmClick() == null) {
                dialog.dismiss();
                return;
            }
            OnOptionWheelClick confirmClick = optionLinkWheelBuilder.getConfirmClick();
            boolean z = false;
            if (confirmClick != null && !confirmClick.onClick(optionLinkWheelBuilder.f35735c)) {
                z = true;
            }
            if (!z) {
                dialog.dismiss();
            }
        }
    }

    /* renamed from: a */
    private final void m26918a(WheelView wheelView, LinkageWheelAdapter<?> linkageWheelAdapter) {
        if (wheelView != null) {
            wheelView.setAdapter(linkageWheelAdapter);
            wheelView.setCurrentItem(linkageWheelAdapter.getInitSelectedIndex());
            this.f35735c.put(linkageWheelAdapter.getKey(), Integer.valueOf(linkageWheelAdapter.getInitSelectedIndex()));
            LinkageWheelAdapter linkageWheelAdapter2 = this.f35746n.get(linkageWheelAdapter.getLinkageKey());
            if (linkageWheelAdapter2 != null) {
                linkageWheelAdapter2.setSelectedRootIndex$wallet_ui_globalRelease(linkageWheelAdapter.getInitSelectedIndex());
            }
            if (this.f35742j && linkageWheelAdapter.getRootKey() != null) {
                Map<String, Integer> map = this.f35744l;
                map.put(linkageWheelAdapter.getRootKey() + ':' + linkageWheelAdapter.getInitSelectedIndex(), Integer.valueOf(linkageWheelAdapter.getInitSelectedIndex()));
            }
        }
    }

    /* renamed from: a */
    private final boolean m26921a() {
        if (this.f35733a.isEmpty()) {
            return false;
        }
        for (LinkageWheelAdapter next : this.f35733a) {
            if (next == null || this.f35745m.containsKey(next.getKey())) {
                return false;
            }
            this.f35745m.put(next.getKey(), next.getLinkageKey());
            this.f35746n.put(next.getKey(), next);
        }
        for (Map.Entry next2 : this.f35745m.entrySet()) {
            String str = this.f35745m.get(next2.getKey());
            if (str != null && Intrinsics.areEqual((Object) this.f35745m.get(str), next2.getKey())) {
                return false;
            }
        }
        return true;
    }
}
