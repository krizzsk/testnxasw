package com.didi.payment.kycservice.kyc.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.utils.ViewExtsKt;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\"\u0010\u001c\u001a\u00020\u000f2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR.\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IncomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/kycservice/kyc/fragment/IncomeAdapter$ViewHolder;", "()V", "dataLst", "Ljava/util/ArrayList;", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "Lkotlin/collections/ArrayList;", "getDataLst", "()Ljava/util/ArrayList;", "setDataLst", "(Ljava/util/ArrayList;)V", "onItemClick", "Lkotlin/Function2;", "", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function2;", "setOnItemClick", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "dataSet", "ViewHolder", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: StepIncomeInfoFragment.kt */
public final class IncomeAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private ArrayList<GuidesInfoResp.Income> f33285a = new ArrayList<>();

    /* renamed from: b */
    private Function2<? super GuidesInfoResp.Income, ? super Integer, Unit> f33286b;

    public final ArrayList<GuidesInfoResp.Income> getDataLst() {
        return this.f33285a;
    }

    public final void setDataLst(ArrayList<GuidesInfoResp.Income> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f33285a = arrayList;
    }

    public final Function2<GuidesInfoResp.Income, Integer, Unit> getOnItemClick() {
        return this.f33286b;
    }

    public final void setOnItemClick(Function2<? super GuidesInfoResp.Income, ? super Integer, Unit> function2) {
        this.f33286b = function2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_income_layout, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        GuidesInfoResp.Income income = this.f33285a.get(i);
        Intrinsics.checkNotNullExpressionValue(income, "dataLst[position]");
        GuidesInfoResp.Income income2 = income;
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ViewExtsKt.click(view, new IncomeAdapter$onBindViewHolder$1(this, income2, i));
        viewHolder.bindData(income2);
    }

    public int getItemCount() {
        return this.f33285a.size();
    }

    public final void setData(ArrayList<GuidesInfoResp.Income> arrayList) {
        if (arrayList != null) {
            this.f33285a.clear();
            this.f33285a.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/payment/kycservice/kyc/fragment/IncomeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkbox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "incomeTV", "Landroid/widget/TextView;", "bindData", "", "item", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp$Income;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: StepIncomeInfoFragment.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkbox;
        private final TextView incomeTV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            this.incomeTV = (TextView) view.findViewById(R.id.income_tv);
            this.checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        }

        public final void bindData(GuidesInfoResp.Income income) {
            Intrinsics.checkNotNullParameter(income, "item");
            this.incomeTV.setText(income.getDisplay());
            this.checkbox.setChecked(income.getSelected());
        }
    }
}
