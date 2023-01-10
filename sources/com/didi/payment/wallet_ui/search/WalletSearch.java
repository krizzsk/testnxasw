package com.didi.payment.wallet_ui.search;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u001b\u001a\u00020\u0017H\u0003J\u0010\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#J\u001a\u0010$\u001a\u00020\u00172\b\b\u0001\u0010%\u001a\u00020!2\b\b\u0001\u0010&\u001a\u00020!J\u0006\u0010'\u001a\u00020\rR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/search/WalletSearch;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelClickListenerList", "", "Landroid/view/View$OnClickListener;", "editTextOnToucheListenerList", "Landroid/view/View$OnTouchListener;", "etSearch", "Landroid/widget/EditText;", "flSearchContainer", "Landroid/widget/FrameLayout;", "isCancelShow", "", "tvSearchCancel", "Landroid/widget/TextView;", "vSearchBg", "Landroid/view/View;", "addCancelClickListener", "", "onClickListener", "addEditOnTouchListener", "onTouchListener", "configAutoShowCancel", "configHintText", "hintText", "", "configKeyboard", "imeAction", "", "onEditorActonListener", "Landroid/widget/TextView$OnEditorActionListener;", "configSearchBg", "type", "lineColor", "getEditText", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletSearch.kt */
public final class WalletSearch extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SEARCH_TYPE_GRAY = 2;
    public static final int SEARCH_TYPE_WHITE = 1;

    /* renamed from: h */
    private static final int f35686h = -1;

    /* renamed from: i */
    private static final int f35687i = Color.parseColor(ColorUtils.DIDI_GREY);

    /* renamed from: j */
    private static final float f35688j = TypedValue.applyDimension(1, 20.0f, Resources.getSystem().getDisplayMetrics());

    /* renamed from: k */
    private static final int f35689k = ((int) TypedValue.applyDimension(1, 16.0f, Resources.getSystem().getDisplayMetrics()));

    /* renamed from: a */
    private final View f35690a;

    /* renamed from: b */
    private final EditText f35691b;

    /* renamed from: c */
    private final FrameLayout f35692c;

    /* renamed from: d */
    private final TextView f35693d;

    /* renamed from: e */
    private final List<View.OnTouchListener> f35694e;

    /* renamed from: f */
    private final List<View.OnClickListener> f35695f;

    /* renamed from: g */
    private boolean f35696g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletSearch(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletSearch(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletSearch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_search, this);
        View findViewById = findViewById(R.id.v_search_bg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.v_search_bg)");
        this.f35690a = findViewById;
        View findViewById2 = findViewById(R.id.fl_search_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_search_container)");
        this.f35692c = (FrameLayout) findViewById2;
        EditText inflateCursorDrawableEdittext$default = UiUtils.Companion.inflateCursorDrawableEdittext$default(UiUtils.Companion, this.f35692c, 14.0f, false, 4, (Object) null);
        inflateCursorDrawableEdittext$default.setSingleLine();
        Unit unit = Unit.INSTANCE;
        this.f35691b = inflateCursorDrawableEdittext$default;
        View findViewById3 = findViewById(R.id.tv_search_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_search_cancel)");
        this.f35693d = (TextView) findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletSearch);
        configSearchBg(obtainStyledAttributes.getInt(3, 1), obtainStyledAttributes.getColor(2, Color.parseColor("#D4D7D9")));
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            this.f35693d.setText(string);
        }
        configHintText(obtainStyledAttributes.getString(1));
        m26910a();
        obtainStyledAttributes.recycle();
        int i = f35689k;
        setPadding(i, 0, i, 0);
        this.f35694e = new ArrayList();
        this.f35695f = new ArrayList();
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/search/WalletSearch$Companion;", "", "()V", "LRPadding", "", "SEARCH_TYPE_GRAY", "SEARCH_TYPE_WHITE", "TYPE_BACK_GRAY", "TYPE_BACK_WHITE", "searchCornerRadius", "", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletSearch.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final void m26910a() {
        this.f35691b.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return WalletSearch.m26913a(WalletSearch.this, view, motionEvent);
            }
        });
        this.f35693d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletSearch.m26911a(WalletSearch.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m26913a(WalletSearch walletSearch, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(walletSearch, "this$0");
        if (!walletSearch.f35696g) {
            if (motionEvent != null && motionEvent.getAction() == 1) {
                walletSearch.f35693d.setVisibility(0);
                walletSearch.f35696g = true;
            }
        }
        for (View.OnTouchListener onTouch : walletSearch.f35694e) {
            onTouch.onTouch(view, motionEvent);
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26911a(WalletSearch walletSearch, View view) {
        Intrinsics.checkNotNullParameter(walletSearch, "this$0");
        walletSearch.f35691b.getText().clear();
        walletSearch.f35693d.setVisibility(8);
        walletSearch.f35696g = false;
        for (View.OnClickListener onClick : walletSearch.f35695f) {
            onClick.onClick(view);
        }
    }

    public final void addCancelClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f35695f.add(onClickListener);
        }
    }

    public final void configHintText(String str) {
        this.f35691b.setHint(str);
    }

    public final void configSearchBg(@WalletSearchType int i, int i2) {
        int i3;
        View view = this.f35690a;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(UiUtils.Companion.intSize(1), i2);
        gradientDrawable.setCornerRadius(f35688j);
        if (i == 1) {
            i3 = -1;
        } else {
            i3 = f35687i;
        }
        gradientDrawable.setColor(i3);
        Unit unit = Unit.INSTANCE;
        view.setBackground(gradientDrawable);
    }

    public final EditText getEditText() {
        return this.f35691b;
    }

    public final void addEditOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.f35694e.add(onTouchListener);
        }
    }

    public static /* synthetic */ void configKeyboard$default(WalletSearch walletSearch, int i, TextView.OnEditorActionListener onEditorActionListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 3;
        }
        walletSearch.configKeyboard(i, onEditorActionListener);
    }

    public final void configKeyboard(int i, TextView.OnEditorActionListener onEditorActionListener) {
        this.f35691b.setSingleLine();
        this.f35691b.setImeOptions(i);
        this.f35691b.setOnEditorActionListener(new TextView.OnEditorActionListener(onEditorActionListener) {
            public final /* synthetic */ TextView.OnEditorActionListener f$0;

            {
                this.f$0 = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return WalletSearch.m26912a(this.f$0, textView, i, keyEvent);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m26912a(TextView.OnEditorActionListener onEditorActionListener, TextView textView, int i, KeyEvent keyEvent) {
        if (onEditorActionListener == null) {
            return false;
        }
        return onEditorActionListener.onEditorAction(textView, i, keyEvent);
    }
}
