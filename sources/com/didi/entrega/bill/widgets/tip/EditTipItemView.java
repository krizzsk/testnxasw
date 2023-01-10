package com.didi.entrega.bill.widgets.tip;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.didi.entrega.bill.model.BillTipModel;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.locale.LocalizationUtils;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002%&B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\"H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, mo148868d2 = {"Lcom/didi/entrega/bill/widgets/tip/EditTipItemView;", "Landroid/widget/RelativeLayout;", "Lcom/didi/entrega/bill/widgets/tip/ITipItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "billTipModel", "Lcom/didi/entrega/bill/model/BillTipModel;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/didi/entrega/bill/model/BillTipModel;)V", "getBillTipModel", "()Lcom/didi/entrega/bill/model/BillTipModel;", "callback", "Lcom/didi/entrega/bill/widgets/tip/EditTipItemView$BillTipEditCallback;", "currency", "", "currencyTv", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "editInput", "Landroid/widget/EditText;", "otherView", "percentSymbol", "textWatcher", "Landroid/text/TextWatcher;", "onPause", "", "onResume", "resetInput", "setBillTipEditCallback", "setData", "setSelectedState", "isSelected", "", "updateTypeFont", "isReset", "BillTipEditCallback", "TipTextWatcher", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditTipItemView.kt */
public final class EditTipItemView extends RelativeLayout implements ITipItemView {

    /* renamed from: a */
    private final BillTipModel f21460a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final EditText f21461b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final CustomerAppCompatTextView f21462c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final CustomerAppCompatTextView f21463d;

    /* renamed from: e */
    private TextWatcher f21464e;

    /* renamed from: f */
    private final CustomerAppCompatTextView f21465f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BillTipEditCallback f21466g;

    /* renamed from: h */
    private String f21467h;

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo148868d2 = {"Lcom/didi/entrega/bill/widgets/tip/EditTipItemView$BillTipEditCallback;", "", "clearSelectedView", "", "showExceedMaxMessage", "updateTipAmount", "tipFee", "", "isManual", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EditTipItemView.kt */
    public interface BillTipEditCallback {
        void clearSelectedView();

        void showExceedMaxMessage();

        void updateTipAmount(long j, boolean z);
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EditTipItemView(Context context, AttributeSet attributeSet, int i, BillTipModel billTipModel, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, billTipModel);
    }

    public final BillTipModel getBillTipModel() {
        return this.f21460a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditTipItemView(Context context, AttributeSet attributeSet, int i, BillTipModel billTipModel) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(billTipModel, "billTipModel");
        this.f21460a = billTipModel;
        View inflate = LayoutInflater.from(context).inflate(R.layout.entrega_item_bill_tip_edit_container, this);
        View findViewById = inflate.findViewById(R.id.entrega_et_input_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.entrega_et_input_tip)");
        this.f21461b = (EditText) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_tip_currency);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.entrega_tip_currency)");
        this.f21462c = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.entrega_tip_percent);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.entrega_tip_percent)");
        this.f21463d = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.entrega_custom_other);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.entrega_custom_other)");
        this.f21465f = (CustomerAppCompatTextView) findViewById4;
        setOnClickListener(new View.OnClickListener(context, this) {
            public final /* synthetic */ Context f$0;
            public final /* synthetic */ EditTipItemView f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                EditTipItemView.m18054a(this.f$0, this.f$1, view);
            }
        });
        TextWatcher tipTextWatcher = new TipTextWatcher(this);
        this.f21464e = tipTextWatcher;
        this.f21461b.addTextChangedListener(tipTextWatcher);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18054a(Context context, EditTipItemView editTipItemView, View view) {
        Intrinsics.checkNotNullParameter(editTipItemView, "this$0");
        KeyboardUtils.showSoftInput(context, editTipItemView.f21461b);
    }

    public final void setBillTipEditCallback(BillTipEditCallback billTipEditCallback) {
        this.f21466g = billTipEditCallback;
    }

    public final void setData(BillTipModel billTipModel, String str) {
        Intrinsics.checkNotNullParameter(billTipModel, "billTipModel");
        this.f21467h = str;
        if (billTipModel.isPercent()) {
            this.f21462c.setText(ResourceHelper.getString(R.string.entrega_global_blank));
            this.f21463d.setText("%");
        } else if (LocalizationUtils.CurrencyUtils.isJPYLocalLang(str)) {
            this.f21462c.setText(ResourceHelper.getString(R.string.entrega_global_blank));
            this.f21463d.setText(LocalizationUtils.CurrencyUtils.getCurrencySymbol(str));
        } else {
            this.f21462c.setText(LocalizationUtils.CurrencyUtils.getCurrencySymbol(str));
            this.f21463d.setText(ResourceHelper.getString(R.string.entrega_global_blank));
        }
        this.f21462c.setVisibility(8);
        this.f21463d.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18053a() {
        if (this.f21460a.isPercent()) {
            this.f21461b.setHint("0%");
            this.f21462c.setVisibility(8);
        } else if (LocalizationUtils.CurrencyUtils.isJPYLocalLang(this.f21467h)) {
            this.f21462c.setVisibility(8);
            this.f21461b.setHint(Intrinsics.stringPlus("0", LocalizationUtils.CurrencyUtils.getCurrencySymbol(this.f21467h)));
        } else {
            this.f21462c.setVisibility(0);
            this.f21462c.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
            this.f21461b.setHint("0");
        }
        this.f21463d.setVisibility(8);
        m18055a(true);
    }

    public void setSelectedState(boolean z) {
        if (z) {
            m18057c();
        } else {
            m18056b();
        }
    }

    /* renamed from: b */
    private final void m18056b() {
        this.f21461b.setHint("");
        this.f21462c.setVisibility(8);
        this.f21463d.setVisibility(8);
        this.f21465f.setVisibility(0);
        this.f21461b.removeTextChangedListener(this.f21464e);
        this.f21461b.setText("");
        this.f21461b.clearFocus();
        KeyboardUtils.hideSoftInput(getContext(), this.f21461b);
    }

    /* renamed from: c */
    private final void m18057c() {
        m18053a();
        this.f21465f.setVisibility(8);
        TextWatcher tipTextWatcher = new TipTextWatcher(this);
        this.f21464e = tipTextWatcher;
        this.f21461b.addTextChangedListener(tipTextWatcher);
        KeyboardUtils.showSoftInput(getContext(), this.f21461b);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m18055a(boolean z) {
        if (z) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21462c, IToolsService.FontType.LIGHT);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21463d, IToolsService.FontType.LIGHT);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21461b, IToolsService.FontType.LIGHT);
            return;
        }
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21462c, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21463d, IToolsService.FontType.MEDIUM);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f21461b, IToolsService.FontType.MEDIUM);
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J*\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/entrega/bill/widgets/tip/EditTipItemView$TipTextWatcher;", "Landroid/text/TextWatcher;", "(Lcom/didi/entrega/bill/widgets/tip/EditTipItemView;)V", "isChanged", "", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EditTipItemView.kt */
    public final class TipTextWatcher implements TextWatcher {
        private boolean isChanged;
        final /* synthetic */ EditTipItemView this$0;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public TipTextWatcher(EditTipItemView editTipItemView) {
            Intrinsics.checkNotNullParameter(editTipItemView, "this$0");
            this.this$0 = editTipItemView;
        }

        public void afterTextChanged(Editable editable) {
            if (this.isChanged) {
                this.isChanged = false;
                return;
            }
            String valueOf = String.valueOf(editable);
            if (valueOf != null) {
                String obj = StringsKt.trim(valueOf).toString();
                CharSequence charSequence = obj;
                if (charSequence == null || charSequence.length() == 0) {
                    this.this$0.m18053a();
                    BillTipEditCallback access$getCallback$p = this.this$0.f21466g;
                    if (access$getCallback$p != null) {
                        access$getCallback$p.updateTipAmount(0, true);
                        return;
                    }
                    return;
                }
                this.this$0.f21462c.setVisibility(0);
                this.this$0.f21462c.setTextColor(ResourceHelper.getColor(R.color.color_333333));
                this.this$0.f21463d.setVisibility(0);
                this.this$0.f21461b.setHint("");
                this.this$0.m18055a(false);
                if (this.this$0.getBillTipModel().isPercent()) {
                    if (Integer.parseInt(obj) > this.this$0.getBillTipModel().getMaxTipFeeRate()) {
                        this.isChanged = true;
                        int length = obj.length() - 1;
                        if (obj != null) {
                            String substring = obj.substring(0, length);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (substring != null) {
                                String obj2 = StringsKt.trim(substring).toString();
                                this.this$0.f21461b.setText(obj2);
                                this.this$0.f21461b.setSelection(obj.length() - 1);
                                BillTipEditCallback access$getCallback$p2 = this.this$0.f21466g;
                                if (access$getCallback$p2 != null) {
                                    access$getCallback$p2.updateTipAmount(Long.parseLong(obj2), true);
                                }
                                BillTipEditCallback access$getCallback$p3 = this.this$0.f21466g;
                                if (access$getCallback$p3 != null) {
                                    access$getCallback$p3.showExceedMaxMessage();
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    BillTipEditCallback access$getCallback$p4 = this.this$0.f21466g;
                    if (access$getCallback$p4 != null) {
                        access$getCallback$p4.updateTipAmount(Long.parseLong(obj), true);
                    }
                } else if (Integer.parseInt(obj) * 100 > this.this$0.getBillTipModel().getMaxTipFeePrice()) {
                    this.isChanged = true;
                    int length2 = obj.length() - 1;
                    if (obj != null) {
                        String substring2 = obj.substring(0, length2);
                        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (substring2 != null) {
                            String obj3 = StringsKt.trim(substring2).toString();
                            this.this$0.f21461b.setText(obj3);
                            this.this$0.f21461b.setSelection(obj.length() - 1);
                            BillTipEditCallback access$getCallback$p5 = this.this$0.f21466g;
                            if (access$getCallback$p5 != null) {
                                access$getCallback$p5.updateTipAmount(Long.parseLong(obj3) * ((long) 100), true);
                            }
                            BillTipEditCallback access$getCallback$p6 = this.this$0.f21466g;
                            if (access$getCallback$p6 != null) {
                                access$getCallback$p6.showExceedMaxMessage();
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } else {
                    BillTipEditCallback access$getCallback$p7 = this.this$0.f21466g;
                    if (access$getCallback$p7 != null) {
                        access$getCallback$p7.updateTipAmount(Long.parseLong(obj) * ((long) 100), true);
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }
}
