package com.didi.global.fintech.cashier.p118ui.dialog;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R@\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R(\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u0006*"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierPaySuccessDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "()V", "value", "", "", "Landroid/view/View$OnClickListener;", "btn", "getBtn", "()Ljava/util/Map;", "setBtn", "(Ljava/util/Map;)V", "button", "Landroid/widget/Button;", "priceStr", "getPriceStr", "()Ljava/lang/String;", "setPriceStr", "(Ljava/lang/String;)V", "priceTV", "Landroid/widget/TextView;", "statusIV", "Landroid/widget/ImageView;", "statusStr", "getStatusStr", "setStatusStr", "statusTV", "symbolStr", "getSymbolStr", "setSymbolStr", "symbolTV", "tipContentTV", "tipStr", "getTipStr", "setTipStr", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierPaySuccessDrawer */
/* compiled from: GlobalCashierPaySuccessDrawer.kt */
public final class GlobalCashierPaySuccessDrawer extends GlobalCashierBaseDrawer {

    /* renamed from: a */
    private ImageView f23648a;

    /* renamed from: b */
    private TextView f23649b;

    /* renamed from: c */
    private TextView f23650c;

    /* renamed from: d */
    private TextView f23651d;

    /* renamed from: e */
    private TextView f23652e;

    /* renamed from: f */
    private Button f23653f;

    /* renamed from: g */
    private String f23654g;

    /* renamed from: h */
    private String f23655h;

    /* renamed from: i */
    private String f23656i;

    /* renamed from: j */
    private String f23657j;

    /* renamed from: k */
    private Map<String, ? extends View.OnClickListener> f23658k;

    public int layout() {
        return R.layout.dialog_pay_result;
    }

    public final String getStatusStr() {
        return this.f23654g;
    }

    public final void setStatusStr(String str) {
        this.f23654g = str;
        TextView textView = this.f23649b;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getSymbolStr() {
        return this.f23655h;
    }

    public final void setSymbolStr(String str) {
        this.f23655h = str;
        TextView textView = this.f23650c;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getPriceStr() {
        return this.f23656i;
    }

    public final void setPriceStr(String str) {
        this.f23656i = str;
        TextView textView = this.f23651d;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getTipStr() {
        return this.f23657j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if ((r4.length() == 0) == true) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTipStr(java.lang.String r4) {
        /*
            r3 = this;
            r3.f23657j = r4
            android.widget.TextView r0 = r3.f23652e
            if (r0 != 0) goto L_0x0007
            goto L_0x000a
        L_0x0007:
            com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt.content(r0, r4)
        L_0x000a:
            android.widget.TextView r0 = r3.f23652e
            if (r0 != 0) goto L_0x000f
            goto L_0x0029
        L_0x000f:
            r1 = 1
            r2 = 0
            if (r4 != 0) goto L_0x0015
        L_0x0013:
            r1 = 0
            goto L_0x0022
        L_0x0015:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            if (r4 != r1) goto L_0x0013
        L_0x0022:
            if (r1 == 0) goto L_0x0026
            r2 = 8
        L_0x0026:
            r0.setVisibility(r2)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierPaySuccessDrawer.setTipStr(java.lang.String):void");
    }

    public final Map<String, View.OnClickListener> getBtn() {
        return this.f23658k;
    }

    public final void setBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f23658k = map;
        Button button = this.f23653f;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button2 = this.f23653f;
                if (button2 != null) {
                    button2.setText((CharSequence) next.getKey());
                }
                Button button3 = this.f23653f;
                if (button3 != null) {
                    ViewKtxKt.click$default(button3, 0, new GlobalCashierPaySuccessDrawer$btn$1$1(next, this), 1, (Object) null);
                }
            }
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f23648a = (ImageView) view.findViewById(R.id.iv_pay_status);
        this.f23649b = (TextView) view.findViewById(R.id.tv_pay_status);
        this.f23650c = (TextView) view.findViewById(R.id.tv_symbol);
        this.f23651d = (TextView) view.findViewById(R.id.tv_price);
        this.f23652e = (TextView) view.findViewById(R.id.tv_tip_content);
        this.f23653f = (Button) view.findViewById(R.id.btn_ok);
    }

    public void initData() {
        setStatusStr(this.f23654g);
        setSymbolStr(this.f23655h);
        setPriceStr(this.f23656i);
        setTipStr(this.f23657j);
        setBtn(this.f23658k);
    }
}
