package com.didi.entrega.security.binder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.security.model.SecurityMethodModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/didi/entrega/security/binder/CurpBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "Lcom/didi/entrega/security/binder/CurpBinder$ViewHolder;", "mClickListener", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "mViewHolder", "bind", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "extraCanBindCondition", "", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CurpBinder.kt */
public final class CurpBinder extends ItemBinder<SecurityMethodModel, ViewHolder> {

    /* renamed from: a */
    private final Function0<Unit> f22907a;

    /* renamed from: b */
    private ViewHolder f22908b;

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public CurpBinder(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "mClickListener");
        this.f22907a = function0;
    }

    public void bind(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        viewHolder.getMTitle().setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.entrega_customer_selector_curp), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.getMTitle().setText(viewHolder.itemView.getContext().getResources().getString(R.string.FoodC_up_Verification_with_FSYz));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CurpBinder.m18852a(CurpBinder.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m18852a(CurpBinder curpBinder, View view) {
        Intrinsics.checkNotNullParameter(curpBinder, "this$0");
        curpBinder.f22907a.invoke();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_binder_security_item, viewGroup, false));
        this.f22908b = viewHolder;
        Intrinsics.checkNotNull(viewHolder);
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        return 41058 == securityMethodModel.getCode();
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/entrega/security/binder/CurpBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCaution", "Landroid/widget/TextView;", "mTitle", "getMTitle", "()Landroid/widget/TextView;", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CurpBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        private final TextView mCaution;
        private final TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_tv_security_method_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R…tv_security_method_title)");
            this.mTitle = (TextView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_tv_security_method_caution);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R…_security_method_caution)");
            this.mCaution = (TextView) findViewById2;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }
    }
}
