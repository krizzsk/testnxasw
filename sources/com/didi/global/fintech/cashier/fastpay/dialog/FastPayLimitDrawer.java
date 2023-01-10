package com.didi.global.fintech.cashier.fastpay.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.global.fintech.cashier.fastpay.dialog.FastPayLimitItem;
import com.didi.global.fintech.cashier.fastpay.omega.FastPayOmegaConstants;
import com.didi.global.fintech.cashier.p118ui.dialog.GlobalCashierBaseDrawer;
import com.didi.global.fintech.cashier.p118ui.omega.CashierOmegaUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\b\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0019X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0002\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitDrawer;", "Lcom/didi/global/fintech/cashier/ui/dialog/GlobalCashierBaseDrawer;", "listener", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "btn", "getBtn", "()Ljava/lang/String;", "setBtn", "(Ljava/lang/String;)V", "close", "Landroid/widget/ImageView;", "confirm", "Landroid/widget/Button;", "container", "Landroid/view/ViewGroup;", "curSelect", "", "getCurSelect", "()I", "setCurSelect", "(I)V", "data", "", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItemData;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "items", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitItem;", "initData", "initView", "view", "Landroid/view/View;", "layout", "Companion", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayLimitDrawer.kt */
public final class FastPayLimitDrawer extends GlobalCashierBaseDrawer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Function1<String, Unit> f23401a;

    /* renamed from: b */
    private Button f23402b;

    /* renamed from: c */
    private ImageView f23403c;

    /* renamed from: d */
    private ViewGroup f23404d;

    /* renamed from: e */
    private List<FastPayLimitItemData> f23405e;

    /* renamed from: f */
    private int f23406f;

    /* renamed from: g */
    private String f23407g;

    /* renamed from: h */
    private final List<FastPayLimitItem> f23408h = new ArrayList();

    public int layout() {
        return R.layout.dialog_fast_pay_limit;
    }

    public FastPayLimitDrawer(Function1<? super String, Unit> function1) {
        this.f23401a = function1;
    }

    @Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitDrawer$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/fastpay/dialog/FastPayLimitDrawer;", "listener", "Lkotlin/Function1;", "", "", "cashier_fastpay_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FastPayLimitDrawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPayLimitDrawer newInstance(Function1<? super String, Unit> function1) {
            return new FastPayLimitDrawer(function1);
        }
    }

    public final List<FastPayLimitItemData> getData() {
        return this.f23405e;
    }

    public final void setData(List<FastPayLimitItemData> list) {
        this.f23405e = list;
    }

    public final int getCurSelect() {
        return this.f23406f;
    }

    public final void setCurSelect(int i) {
        this.f23406f = i;
    }

    public final String getBtn() {
        return this.f23407g;
    }

    public final void setBtn(String str) {
        this.f23407g = str;
    }

    public void initView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.btn_confirm)");
        this.f23402b = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.iv_close)");
        this.f23403c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.ll_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.ll_container)");
        this.f23404d = (ViewGroup) findViewById3;
        ImageView imageView = this.f23403c;
        Button button = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("close");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPayLimitDrawer.m19188a(FastPayLimitDrawer.this, view);
            }
        });
        Button button2 = this.f23402b;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
        } else {
            button = button2;
        }
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPayLimitDrawer.m19189b(FastPayLimitDrawer.this, view);
            }
        });
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_LIMIT_DRAWER_SW);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19188a(FastPayLimitDrawer fastPayLimitDrawer, View view) {
        Intrinsics.checkNotNullParameter(fastPayLimitDrawer, "this$0");
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_LIMIT_DRAWER_CLOSE_CK);
        fastPayLimitDrawer.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m19189b(FastPayLimitDrawer fastPayLimitDrawer, View view) {
        Intrinsics.checkNotNullParameter(fastPayLimitDrawer, "this$0");
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_LIMIT_DRAWER_CONFIRM_CK);
        Function1<String, Unit> function1 = fastPayLimitDrawer.f23401a;
        if (function1 != null) {
            function1.invoke(fastPayLimitDrawer.f23408h.get(fastPayLimitDrawer.getCurSelect()).getAmount());
        }
        fastPayLimitDrawer.dismissAllowingStateLoss();
    }

    public void initData() {
        FastPayLimitItem fastPayLimitItem;
        Button button = this.f23402b;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            button = null;
        }
        button.setText(this.f23407g);
        List<FastPayLimitItemData> list = this.f23405e;
        if (list != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FastPayLimitItemData fastPayLimitItemData = (FastPayLimitItemData) next;
                Context context = getContext();
                if (context == null) {
                    fastPayLimitItem = null;
                } else {
                    FastPayLimitItem.Companion companion = FastPayLimitItem.Companion;
                    ViewGroup viewGroup = this.f23404d;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup = null;
                    }
                    fastPayLimitItem = companion.newIns(context, viewGroup);
                }
                if (fastPayLimitItem != null) {
                    ViewGroup viewGroup2 = this.f23404d;
                    if (viewGroup2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("container");
                        viewGroup2 = null;
                    }
                    viewGroup2.addView(fastPayLimitItem.getRootView());
                    this.f23408h.add(fastPayLimitItem);
                }
                if (fastPayLimitItem != null) {
                    fastPayLimitItem.bind(fastPayLimitItemData.getContent(), fastPayLimitItemData.getAmount(), i == getCurSelect());
                }
                if (fastPayLimitItem != null) {
                    fastPayLimitItem.click(new View.OnClickListener(i) {
                        public final /* synthetic */ int f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            FastPayLimitDrawer.m19187a(FastPayLimitDrawer.this, this.f$1, view);
                        }
                    });
                }
                i = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19187a(FastPayLimitDrawer fastPayLimitDrawer, int i, View view) {
        Intrinsics.checkNotNullParameter(fastPayLimitDrawer, "this$0");
        if (fastPayLimitDrawer.getCurSelect() != i) {
            fastPayLimitDrawer.f23408h.get(fastPayLimitDrawer.getCurSelect()).selected(false);
            fastPayLimitDrawer.setCurSelect(i);
            fastPayLimitDrawer.f23408h.get(fastPayLimitDrawer.getCurSelect()).selected(true);
            CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_SETTING_LIMIT_DRAWER_ITEM_CK);
        }
    }
}
