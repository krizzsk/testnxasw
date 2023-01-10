package com.didi.global.fintech.cashier.p118ui.dialog;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt;
import com.taxis99.R;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000202H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR@\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R@\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR(\u0010\u001e\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010\"R\u0010\u0010(\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u00063"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "()V", "closeBtn", "Landroid/widget/ImageView;", "h1Btn", "Landroid/widget/Button;", "h2Btn", "horizontalLayout", "Landroid/widget/LinearLayout;", "value", "", "isHorizontal", "()Z", "setHorizontal", "(Z)V", "", "", "Landroid/view/View$OnClickListener;", "negativeBtn", "getNegativeBtn", "()Ljava/util/Map;", "setNegativeBtn", "(Ljava/util/Map;)V", "positiveBtn", "getPositiveBtn", "setPositiveBtn", "showCloseBtn", "getShowCloseBtn", "setShowCloseBtn", "subTitle", "getSubTitle", "()Ljava/lang/String;", "setSubTitle", "(Ljava/lang/String;)V", "subTitleTV", "Landroid/widget/TextView;", "title", "getTitle", "setTitle", "titleTV", "v1Btn", "v2Btn", "verticalLayout", "initData", "", "initView", "view", "Landroid/view/View;", "layout", "", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.dialog.GlobalCashierDrawer */
/* compiled from: GlobalCashierDrawer.kt */
public final class GlobalCashierDrawer extends GlobalCashierBaseDrawer {

    /* renamed from: a */
    private ImageView f23633a;

    /* renamed from: b */
    private TextView f23634b;

    /* renamed from: c */
    private TextView f23635c;

    /* renamed from: d */
    private Button f23636d;

    /* renamed from: e */
    private Button f23637e;

    /* renamed from: f */
    private Button f23638f;

    /* renamed from: g */
    private Button f23639g;

    /* renamed from: h */
    private LinearLayout f23640h;

    /* renamed from: i */
    private LinearLayout f23641i;

    /* renamed from: j */
    private boolean f23642j;

    /* renamed from: k */
    private boolean f23643k = true;

    /* renamed from: l */
    private String f23644l;

    /* renamed from: m */
    private String f23645m;

    /* renamed from: n */
    private Map<String, ? extends View.OnClickListener> f23646n;

    /* renamed from: o */
    private Map<String, ? extends View.OnClickListener> f23647o;

    public int layout() {
        return R.layout.dialog_global_cashier_drawer;
    }

    public final boolean getShowCloseBtn() {
        return this.f23642j;
    }

    public final void setShowCloseBtn(boolean z) {
        this.f23642j = z;
        ImageView imageView = this.f23633a;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final boolean isHorizontal() {
        return this.f23643k;
    }

    public final void setHorizontal(boolean z) {
        this.f23643k = z;
        LinearLayout linearLayout = this.f23640h;
        int i = 0;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ^ true ? 0 : 8);
        }
        LinearLayout linearLayout2 = this.f23641i;
        if (linearLayout2 != null) {
            View view = linearLayout2;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public final String getTitle() {
        return this.f23644l;
    }

    public final void setTitle(String str) {
        this.f23644l = str;
        TextView textView = this.f23634b;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final String getSubTitle() {
        return this.f23645m;
    }

    public final void setSubTitle(String str) {
        this.f23645m = str;
        TextView textView = this.f23635c;
        if (textView != null) {
            ViewKtxKt.content(textView, str);
        }
    }

    public final Map<String, View.OnClickListener> getPositiveBtn() {
        return this.f23646n;
    }

    public final void setPositiveBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f23646n = map;
        Button button = this.f23638f;
        int i = 8;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        Button button2 = this.f23636d;
        if (button2 != null) {
            View view = button2;
            if (!(map == null || map.isEmpty())) {
                i = 0;
            }
            view.setVisibility(i);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button3 = this.f23638f;
                if (button3 != null) {
                    button3.setText((CharSequence) next.getKey());
                }
                Button button4 = this.f23638f;
                if (button4 != null) {
                    ViewKtxKt.click$default(button4, 0, new GlobalCashierDrawer$positiveBtn$1$1(next, this), 1, (Object) null);
                }
                Button button5 = this.f23636d;
                if (button5 != null) {
                    button5.setText((CharSequence) next.getKey());
                }
                Button button6 = this.f23636d;
                if (button6 != null) {
                    ViewKtxKt.click$default(button6, 0, new GlobalCashierDrawer$positiveBtn$1$2(next, this), 1, (Object) null);
                }
            }
        }
    }

    public final Map<String, View.OnClickListener> getNegativeBtn() {
        return this.f23647o;
    }

    public final void setNegativeBtn(Map<String, ? extends View.OnClickListener> map) {
        this.f23647o = map;
        Button button = this.f23639g;
        int i = 8;
        boolean z = false;
        if (button != null) {
            button.setVisibility((map == null || map.isEmpty()) ^ true ? 0 : 8);
        }
        Button button2 = this.f23637e;
        if (button2 != null) {
            View view = button2;
            if (!(map == null || map.isEmpty())) {
                i = 0;
            }
            view.setVisibility(i);
        }
        if (map == null || map.isEmpty()) {
            z = true;
        }
        if (!z) {
            for (Map.Entry next : map.entrySet()) {
                Button button3 = this.f23639g;
                if (button3 != null) {
                    button3.setText((CharSequence) next.getKey());
                }
                Button button4 = this.f23639g;
                if (button4 != null) {
                    ViewKtxKt.click$default(button4, 0, new GlobalCashierDrawer$negativeBtn$1$1(next, this), 1, (Object) null);
                }
                Button button5 = this.f23637e;
                if (button5 != null) {
                    button5.setText((CharSequence) next.getKey());
                }
                Button button6 = this.f23637e;
                if (button6 != null) {
                    ViewKtxKt.click$default(button6, 0, new GlobalCashierDrawer$negativeBtn$1$2(next, this), 1, (Object) null);
                }
            }
        }
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f23633a = (ImageView) view.findViewById(R.id.drawer_close_img);
        this.f23634b = (TextView) view.findViewById(R.id.drawer_title);
        TextView textView = (TextView) view.findViewById(R.id.drawer_sub_title);
        this.f23635c = textView;
        if (textView != null) {
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        this.f23636d = (Button) view.findViewById(R.id.drawer_btn_ok);
        this.f23637e = (Button) view.findViewById(R.id.drawer_btn_cancel);
        this.f23638f = (Button) view.findViewById(R.id.drawer_btn_v1);
        this.f23639g = (Button) view.findViewById(R.id.drawer_btn_v2);
        this.f23640h = (LinearLayout) view.findViewById(R.id.drawer_btn_vertical);
        this.f23641i = (LinearLayout) view.findViewById(R.id.drawer_btn_horizontal);
        ImageView imageView = this.f23633a;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    GlobalCashierDrawer.m19241a(GlobalCashierDrawer.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19241a(GlobalCashierDrawer globalCashierDrawer, View view) {
        Intrinsics.checkNotNullParameter(globalCashierDrawer, "this$0");
        globalCashierDrawer.dismiss();
    }

    public void initData() {
        setShowCloseBtn(this.f23642j);
        setTitle(this.f23644l);
        setSubTitle(this.f23645m);
        setHorizontal(this.f23643k);
        setPositiveBtn(this.f23646n);
        setNegativeBtn(this.f23647o);
    }
}
